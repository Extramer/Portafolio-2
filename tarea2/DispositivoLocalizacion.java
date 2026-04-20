import java.util.ArrayList;

public class DispositivoLocalizacion {
    private String codigo;
    private String estado;
    private ArrayList<RegistroUbicacion> ubicaciones;
    // Nueva lista de eventos - relación 1 a muchos con EventoDispositivo
    private ArrayList<EventoDispositivo> eventos;

    public DispositivoLocalizacion() {
        this.ubicaciones = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }

    public DispositivoLocalizacion(String codigo, String estado) {
        this.codigo = codigo;
        this.estado = estado;
        this.ubicaciones = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }

    // Sobrecarga de métodos (igual que Tarea 1, se mantiene)
    public void agregarUbicacion(RegistroUbicacion r) {
        ubicaciones.add(r);
    }

    public void agregarUbicacion(String id, String loc) {
        ubicaciones.add(new RegistroUbicacion(id, "Ahora", loc));
    }

    // Nuevo método para registrar eventos
    public void agregarEvento(EventoDispositivo evento) {
        eventos.add(evento);
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public ArrayList<RegistroUbicacion> getUbicaciones() { return ubicaciones; }
    public ArrayList<EventoDispositivo> getEventos() { return eventos; }

    @Override
    public String toString() {
        return "Dispositivo: " + codigo + " | Estado: " + estado;
    }
}
