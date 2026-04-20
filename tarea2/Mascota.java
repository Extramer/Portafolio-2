import java.util.ArrayList;

public class Mascota {
    private String id;
    private String nombre;
    private String tipo;
    private String estado;
    private DispositivoLocalizacion dispositivo;
    // Nueva lista de alertas - relación 1 a muchos con Alerta
    private ArrayList<Alerta> alertas;

    public Mascota() {
        this.alertas = new ArrayList<>();
    }

    public Mascota(String id, String nombre, String tipo, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
        this.alertas = new ArrayList<>();
    }

    // Nuevo método para agregar alertas
    public void agregarAlerta(Alerta alerta) {
        alertas.add(alerta);
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public DispositivoLocalizacion getDispositivo() { return dispositivo; }
    public void setDispositivo(DispositivoLocalizacion dispositivo) { this.dispositivo = dispositivo; }
    public ArrayList<Alerta> getAlertas() { return alertas; }

    @Override
    public String toString() {
        String infoDisp = (dispositivo != null) ? dispositivo.getCodigo() : "Sin dispositivo";
        return "Mascota: " + nombre + " (" + tipo + ") | Estado: " + estado + " | Disp: " + infoDisp;
    }
}
