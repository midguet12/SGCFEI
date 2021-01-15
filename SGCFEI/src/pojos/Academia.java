package pojos;

public class Academia implements POJO{
    private int idAcademia;
    private String nombre;
    private String descripcion;
    private String idCoordinador;

    public Academia(int idAcademia, String nombre, String descripcion, String idCoordinador) {
        this.idAcademia = idAcademia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idCoordinador = idCoordinador;
    }
    
    public Academia(String nombre, String descripcion, String idCoordinador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idCoordinador = idCoordinador;
    }

    public Academia(){
    
    }

    public int getIdAcademia() {
        return idAcademia;
    }

    public void setIdAcademia(int idAcademia) {
        this.idAcademia = idAcademia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(String idCoordinador) {
        this.idCoordinador = idCoordinador;
    } 

    @Override
    public String toString() {
        return "Academia{" + "idAcademia=" + idAcademia + ", nombre=" + nombre + ", descripcion=" + descripcion + ", idCoordinador=" + idCoordinador + '}';
    }   
}
