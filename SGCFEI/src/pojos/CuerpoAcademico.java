package pojos;

public class CuerpoAcademico implements POJO{
    private int idCuerpoAcademico;
    private String nombre;
    private String idCoordinador;

    public CuerpoAcademico(int idCuerpoAcademico, String nombre, String idCoordinador) {
        this.idCuerpoAcademico = idCuerpoAcademico;
        this.nombre = nombre;
        this.idCoordinador = idCoordinador;
    }

    public CuerpoAcademico(String nombre, String idCoordinador) {
        this.nombre = nombre;
        this.idCoordinador = idCoordinador;
    }

    public CuerpoAcademico() {
        
    }

    public int getIdCuerpoAcademico() {
        return idCuerpoAcademico;
    }

    public void setIdCuerpoAcademico(int idCuerpoAcademico) {
        this.idCuerpoAcademico = idCuerpoAcademico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(String idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    @Override
    public String toString() {
        return "CuerpoAcademico{" + "idCuerpoAcademico=" + idCuerpoAcademico + ", nombre=" + nombre + ", idCoordinador=" + idCoordinador + '}';
    }
    
}
