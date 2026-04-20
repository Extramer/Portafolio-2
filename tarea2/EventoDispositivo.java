// Nueva abstracción del dominio requerida en Tarea 2
public class EventoDispositivo {

    // Variable de clase (static) para generar IDs automáticos - requisito técnico
    private static int contadorEventos = 0;

    private int id;
    private String fechaHora;
    private TipoEvento tipo;
    private DispositivoLocalizacion dispositivo; // Relación: cada evento pertenece a un dispositivo

    public EventoDispositivo() {
        contadorEventos++;
        this.id = contadorEventos;
        this.fechaHora = "Ahora";
    }

    public EventoDispositivo(String fechaHora, TipoEvento tipo, DispositivoLocalizacion dispositivo) {
        contadorEventos++;
        this.id = contadorEventos;
        this.fechaHora = fechaHora;
        this.tipo = tipo;
        this.dispositivo = dispositivo;
    }

    public int getId() { return id; }
    public String getFechaHora() { return fechaHora; }
    public TipoEvento getTipo() { return tipo; }
    public DispositivoLocalizacion getDispositivo() { return dispositivo; }

    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }
    public void setTipo(TipoEvento tipo) { this.tipo = tipo; }
    public void setDispositivo(DispositivoLocalizacion dispositivo) { this.dispositivo = dispositivo; }

    @Override
    public String toString() {
        return "Evento #" + id + " | Tipo: " + tipo + " | Fecha: " + fechaHora
                + " | Dispositivo: " + dispositivo.getCodigo();
    }
}
