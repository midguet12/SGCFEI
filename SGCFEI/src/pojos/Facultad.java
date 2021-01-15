package pojos;

public class Facultad implements POJO{
    private int idFacultad;
    private String nombre;

    public Facultad(int idFacultad, String nombre) {
        this.idFacultad = idFacultad;
        this.nombre = nombre;
    }

    public Facultad(String nombre) {
        this.nombre = nombre;
    }
    
    public Facultad() {
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Facultad{" + "idFacultad=" + idFacultad + ", nombre=" + nombre + '}';
    }
        
}
