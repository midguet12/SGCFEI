package pojos;

import accesodatos.FacultadDAO;

public class Carrera implements POJO{
    private int idCarrera;
    private String nombre;
    private int idFacultad;
    private String facultad;

    public Carrera(int idCarrera, String nombre, int idFacultad) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.idFacultad = idFacultad;
    }

    public Carrera(String nombre, int idFacultad) {
        this.nombre = nombre;
        this.idFacultad = idFacultad;
    }

    public Carrera() {
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    
    public void cargarFacultad(){
        FacultadDAO dao = new FacultadDAO();
        this.facultad = dao.obtener(idFacultad).getNombre();
    }

    @Override
    public String toString() {
        return nombre;
    }
}
