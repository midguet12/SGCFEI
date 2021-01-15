package pojos;

public class AspectoMinuta implements POJO{
    private int idAspectoMinuta;
    private String asunto;
    private String idAcademico;
    private int idMinuta;

    public AspectoMinuta(int idAspectoMinuta, String asunto, String idAcademico, int idMinuta) {
        this.idAspectoMinuta = idAspectoMinuta;
        this.asunto = asunto;
        this.idAcademico = idAcademico;
        this.idMinuta = idMinuta;
    }

    public AspectoMinuta(String asunto, String idAcademico, int idMinuta) {
        this.asunto = asunto;
        this.idAcademico = idAcademico;
        this.idMinuta = idMinuta;
    }

    public AspectoMinuta() {
    }

    public int getIdAspectoMinuta() {
        return idAspectoMinuta;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getIdAcademico() {
        return idAcademico;
    }

    public int getIdMinuta() {
        return idMinuta;
    }

    public void setIdAspectoMinuta(int idAspectoMinuta) {
        this.idAspectoMinuta = idAspectoMinuta;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setIdAcademico(String idAcademico) {
        this.idAcademico = idAcademico;
    }

    public void setIdMinuta(int idMinuta) {
        this.idMinuta = idMinuta;
    }

    @Override
    public String toString() {
        return "AspectoMinuta{" + "idAspectoMinuta=" + idAspectoMinuta + ", asunto=" + asunto + ", idAcademico=" + idAcademico + ", idMinuta=" + idMinuta + '}';
    }
    
}
