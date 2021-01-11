/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author midgu
 */
public class PlanCurso {
    private int idPlanCurso;
    private int nrc;
    private String experienciaEducativa;
    private int bloque;
    private int seccion; 
    private String numeroPersonal;
    private String periodo;

    public PlanCurso(int nrc, String experienciaEducativa, int bloque, int seccion, String numeroPersonal, String periodo) {
        this.nrc = nrc;
        this.experienciaEducativa = experienciaEducativa;
        this.bloque = bloque;
        this.seccion = seccion;
        this.numeroPersonal = numeroPersonal;
        this.periodo = periodo;
    }

    public PlanCurso(int idPlanCurso, int nrc, String experienciaEducativa, int bloque, int seccion, String numeroPersonal, String periodo) {
        this.idPlanCurso = idPlanCurso;
        this.nrc = nrc;
        this.experienciaEducativa = experienciaEducativa;
        this.bloque = bloque;
        this.seccion = seccion;
        this.numeroPersonal = numeroPersonal;
        this.periodo = periodo;
    }

    public int getIdPlanCurso() {
        return idPlanCurso;
    }

    public void setIdPlanCurso(int idPlanCurso) {
        this.idPlanCurso = idPlanCurso;
    }

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public String getExperienciaEducativa() {
        return experienciaEducativa;
    }

    public void setExperienciaEducativa(String experienciaEducativa) {
        this.experienciaEducativa = experienciaEducativa;
    }

    public int getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public String getNumeroPersonal() {
        return numeroPersonal;
    }

    public void setNumeroPersonal(String numeroPersonal) {
        this.numeroPersonal = numeroPersonal;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    
    
    

    
}
