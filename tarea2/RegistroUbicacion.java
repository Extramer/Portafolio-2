public class RegistroUbicacion {
    private String id;
    private String fechaHora;
    private String ubicacion;

    public RegistroUbicacion() { this.fechaHora = "Actual"; }

    public RegistroUbicacion(String id, String fechaHora, String ubicacion) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    @Override
    public String toString() {
        return "Ubicación: " + ubicacion + " (Fecha: " + fechaHora + ")";
    }
}
