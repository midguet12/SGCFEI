/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author Luis
 */
public class AspectoMinuta {
    private int idAspectoMinuta;
    private String asunto;
    private int idAcademico;
    private int idMinuta;

    public AspectoMinuta() {
    }

    public int getIdAspectoMinuta() {
        return idAspectoMinuta;
    }

    public String getAsunto() {
        return asunto;
    }

    public int getIdAcademico() {
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

    public void setIdAcademico(int idAcademico) {
        this.idAcademico = idAcademico;
    }

    public void setIdMinuta(int idMinuta) {
        this.idMinuta = idMinuta;
    }
    
}
