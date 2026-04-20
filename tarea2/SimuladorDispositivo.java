import java.util.ArrayList;
import java.util.Random;

// Hilo para simular un dispositivo - requisito técnico: uso explícito de hilos
public class SimuladorDispositivo extends Thread {

    private DispositivoLocalizacion dispositivo;
    private Mascota mascota;
    private ArrayList<EventoDispositivo> eventosGlobales; // Lista compartida de eventos
    private ArrayList<Alerta> alertasGlobales;           // Lista compartida de alertas

    // Ubicaciones de ejemplo para la simulación
    private String[] ubicacionesEjemplo = {"Parque", "Casa", "Calle", "Veterinaria", "Jardín"};
    private Random random = new Random();

    public SimuladorDispositivo(DispositivoLocalizacion dispositivo, Mascota mascota,
                                 ArrayList<EventoDispositivo> eventosGlobales,
                                 ArrayList<Alerta> alertasGlobales) {
        this.dispositivo = dispositivo;
        this.mascota = mascota;
        this.eventosGlobales = eventosGlobales;
        this.alertasGlobales = alertasGlobales;
    }

    // run() es el método que ejecuta el hilo - sobrescritura de método (requisito técnico)
    @Override
    public void run() {
        System.out.println("[Simulación] Iniciando dispositivo: " + dispositivo.getCodigo());

        // El hilo genera 3 ubicaciones automáticas con una pausa entre cada una
        for (int i = 1; i <= 3; i++) {
            try {
                // Pausa de 1 segundo entre cada generación
                Thread.sleep(1000);

                // Generar ubicación aleatoria
                String ubicacion = ubicacionesEjemplo[random.nextInt(ubicacionesEjemplo.length)];
                String fechaHora = "Ciclo-" + i;

                // Registrar ubicación en el dispositivo
                dispositivo.agregarUbicacion("SIM-" + i, ubicacion);

                // Registrar evento asociado al dispositivo
                EventoDispositivo evento = new EventoDispositivo(fechaHora, TipoEvento.UBICACION_GENERADA, dispositivo);
                dispositivo.agregarEvento(evento);

                // Agregar el evento también a la lista global
                synchronized (eventosGlobales) {
                    eventosGlobales.add(evento);
                }

                System.out.println("[" + dispositivo.getCodigo() + "] Nueva ubicación: " + ubicacion);

                // Si la ubicación es "Calle", generar una alerta de ejemplo
                if (ubicacion.equals("Calle")) {
                    Alerta alerta = new Alerta(fechaHora, TipoAlerta.FUERA_DE_ZONA, mascota);
                    mascota.agregarAlerta(alerta);
                    synchronized (alertasGlobales) {
                        alertasGlobales.add(alerta);
                    }
                    System.out.println("[ALERTA] " + mascota.getNombre() + " está fuera de zona.");
                }

            } catch (InterruptedException e) {
                // Manejo explícito de excepción - requisito técnico
                System.out.println("[Error] Simulación interrumpida: " + e.getMessage());
            }
        }

        System.out.println("[Simulación] Dispositivo " + dispositivo.getCodigo() + " terminó.");
    }
}
