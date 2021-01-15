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
      
}
