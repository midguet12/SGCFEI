package pojos;

public class ExperienciaEducativa implements POJO{
    private int nrc;
    private String nombre;
    private int idAcademia;

    public ExperienciaEducativa(int nrc, String nombre, int idAcademia) {
        this.nrc = nrc;
        this.nombre = nombre;
        this.idAcademia = idAcademia;
    }

    public ExperienciaEducativa(String nombre, int idAcademia) {
        this.nombre = nombre;
        this.idAcademia = idAcademia;
    }

    public ExperienciaEducativa() {
        
    }

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdAcademia() {
        return idAcademia;
    }

    public void setIdAcademia(int idAcademia) {
        this.idAcademia = idAcademia;
    }

    @Override
    public String toString() {
        return "ExperienciaEducativa{" + "nrc=" + nrc + ", nombre=" + nombre + ", idAcademia=" + idAcademia + '}';
    }
    
}
