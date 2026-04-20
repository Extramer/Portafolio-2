import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    // Almacenamiento en memoria
    static ArrayList<Mascota> mascotas = new ArrayList<>();
    static ArrayList<DispositivoLocalizacion> dispositivos = new ArrayList<>();
    static ArrayList<EventoDispositivo> eventos = new ArrayList<>();   // Nuevo en Tarea 2
    static ArrayList<Alerta> alertas = new ArrayList<>();              // Nuevo en Tarea 2
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        while (opcion != 9) {
            System.out.println("\n========== MENÚ PRINCIPAL ==========");
            System.out.println("1. Registrar mascota");
            System.out.println("2. Registrar dispositivo");
            System.out.println("3. Asociar dispositivo a mascota");
            System.out.println("4. Añadir ubicación manual");
            System.out.println("5. Ver toda la información");
            System.out.println("6. Iniciar simulación automática");
            System.out.println("7. Ver eventos registrados");
            System.out.println("8. Ver alertas registradas");
            System.out.println("9. Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                // Manejo explícito de excepción - requisito técnico
                System.out.println("[Error] Ingrese un número válido.");
                continue;
            }

            if (opcion == 1) {
                registrarMascota();
            } else if (opcion == 2) {
                registrarDispositivo();
            } else if (opcion == 3) {
                asociarDispositivo();
            } else if (opcion == 4) {
                agregarUbicacionManual();
            } else if (opcion == 5) {
                verTodo();
            } else if (opcion == 6) {
                iniciarSimulacion();
            } else if (opcion == 7) {
                verEventos();
            } else if (opcion == 8) {
                verAlertas();
            } else if (opcion != 9) {
                System.out.println("Opción no válida.");
            }
        }

        System.out.println("¡Hasta luego!");
    }

    // ---- Métodos del menú ----

    static void registrarMascota() {
        System.out.print("ID de la mascota: ");
        String id = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Tipo (perro/gato/etc): ");
        String tipo = sc.nextLine();
        System.out.print("Estado (activo/inactivo): ");
        String estado = sc.nextLine();
        mascotas.add(new Mascota(id, nombre, tipo, estado));
        System.out.println("Mascota registrada.");
    }

    static void registrarDispositivo() {
        System.out.print("Código del dispositivo: ");
        String codigo = sc.nextLine();
        System.out.print("Estado (activo/inactivo): ");
        String estado = sc.nextLine();
        dispositivos.add(new DispositivoLocalizacion(codigo, estado));
        System.out.println("Dispositivo registrado.");
    }

    static void asociarDispositivo() {
        if (mascotas.isEmpty() || dispositivos.isEmpty()) {
            System.out.println("Necesitas al menos una mascota y un dispositivo registrados.");
            return;
        }

        System.out.println("Mascotas disponibles:");
        for (int i = 0; i < mascotas.size(); i++) {
            System.out.println(i + ". " + mascotas.get(i).getNombre());
        }
        System.out.print("Número de mascota: ");
        int im = Integer.parseInt(sc.nextLine());

        System.out.println("Dispositivos disponibles:");
        for (int i = 0; i < dispositivos.size(); i++) {
            System.out.println(i + ". " + dispositivos.get(i).getCodigo());
        }
        System.out.print("Número de dispositivo: ");
        int id = Integer.parseInt(sc.nextLine());

        mascotas.get(im).setDispositivo(dispositivos.get(id));
        System.out.println("Dispositivo asociado correctamente.");
    }

    static void agregarUbicacionManual() {
        if (mascotas.isEmpty()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }

        System.out.println("Mascotas con dispositivo:");
        for (int i = 0; i < mascotas.size(); i++) {
            if (mascotas.get(i).getDispositivo() != null) {
                System.out.println(i + ". " + mascotas.get(i).getNombre());
            }
        }

        System.out.print("Número de mascota: ");
        int indice = Integer.parseInt(sc.nextLine());

        if (mascotas.get(indice).getDispositivo() == null) {
            System.out.println("Esa mascota no tiene dispositivo.");
            return;
        }

        System.out.print("ID del registro: ");
        String idReg = sc.nextLine();
        System.out.print("Ubicación: ");
        String ubicacion = sc.nextLine();

        // Usa la sobrecarga de métodos
        mascotas.get(indice).getDispositivo().agregarUbicacion(idReg, ubicacion);
        System.out.println("Ubicación añadida.");
    }

    static void verTodo() {
        if (mascotas.isEmpty()) {
            System.out.println("No hay información registrada.");
            return;
        }
        for (Mascota m : mascotas) {
            System.out.println(m.toString());
            if (m.getDispositivo() != null) {
                System.out.println("  " + m.getDispositivo().toString());
                for (RegistroUbicacion r : m.getDispositivo().getUbicaciones()) {
                    System.out.println("    - " + r.toString());
                }
            }
            // Mostrar alertas de la mascota
            for (Alerta a : m.getAlertas()) {
                System.out.println("  [!] " + a.toString());
            }
        }
    }

    static void iniciarSimulacion() {
        boolean hayDispositivoAsociado = false;

        for (Mascota m : mascotas) {
            if (m.getDispositivo() != null) {
                hayDispositivoAsociado = true;
                // Crear y arrancar un hilo por cada mascota con dispositivo
                SimuladorDispositivo hilo = new SimuladorDispositivo(
                        m.getDispositivo(), m, eventos, alertas);
                hilo.start(); // Inicia el hilo (llama a run() en segundo plano)
            }
        }

        if (!hayDispositivoAsociado) {
            System.out.println("No hay mascotas con dispositivo asociado para simular.");
        } else {
            System.out.println("Simulación iniciada. Puedes seguir usando el menú.");
        }
    }

    static void verEventos() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados. Inicia la simulación primero.");
            return;
        }
        System.out.println("=== Eventos registrados ===");
        for (EventoDispositivo e : eventos) {
            System.out.println(e.toString());
        }
    }

    static void verAlertas() {
        if (alertas.isEmpty()) {
            System.out.println("No hay alertas registradas.");
            return;
        }
        System.out.println("=== Alertas registradas ===");
        for (Alerta a : alertas) {
            System.out.println(a.toString());
        }
    }
}
