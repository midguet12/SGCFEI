/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author midgu
 */
public class Evaluacion {
    int idProgramaEE;
    String evidencia;
    String criterio;
    String ambito;
    String porcentaje;

    public Evaluacion(int idProgramaEE, String evidencia, String criterio, String ambito, String porcentaje) {
        this.idProgramaEE = idProgramaEE;
        this.evidencia = evidencia;
        this.criterio = criterio;
        this.ambito = ambito;
        this.porcentaje = porcentaje;
    }

    public int getIdProgramaEE() {
        return idProgramaEE;
    }

    public void setIdProgramaEE(int idProgramaEE) {
        this.idProgramaEE = idProgramaEE;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}
