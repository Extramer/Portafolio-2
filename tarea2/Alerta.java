// Nueva abstracción del dominio requerida en Tarea 2
public class Alerta {

    // Variable de clase (static) para generar IDs automáticos - requisito técnico
    private static int contadorAlertas = 0;

    private int id;
    private String fechaHora;
    private TipoAlerta tipo;
    private Mascota mascota; // Relación: cada alerta está asociada a una mascota

    public Alerta() {
        contadorAlertas++;
        this.id = contadorAlertas;
        this.fechaHora = "Ahora";
    }

    public Alerta(String fechaHora, TipoAlerta tipo, Mascota mascota) {
        contadorAlertas++;
        this.id = contadorAlertas;
        this.fechaHora = fechaHora;
        this.tipo = tipo;
        this.mascota = mascota;
    }

    public int getId() { return id; }
    public String getFechaHora() { return fechaHora; }
    public TipoAlerta getTipo() { return tipo; }
    public Mascota getMascota() { return mascota; }

    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }
    public void setTipo(TipoAlerta tipo) { this.tipo = tipo; }
    public void setMascota(Mascota mascota) { this.mascota = mascota; }

    @Override
    public String toString() {
        return "Alerta #" + id + " | Tipo: " + tipo + " | Fecha: " + fechaHora
                + " | Mascota: " + mascota.getNombre();
    }
}
