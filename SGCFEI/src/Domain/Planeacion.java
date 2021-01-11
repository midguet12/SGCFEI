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
public class Planeacion {
    private int idPlanCurso;
    private int unidad;
    private String tema;
    private String fechas;
    private String tarea;
    private String tecnica;

    public Planeacion(int unidad, String tema, String fechas, String tarea, String tecnica) {
        this.unidad = unidad;
        this.tema = tema;
        this.fechas = fechas;
        this.tarea = tarea;
        this.tecnica = tecnica;
    }

    public Planeacion(int idPlanCurso, int unidad, String tema, String fechas, String tarea, String tecnica) {
        this.idPlanCurso = idPlanCurso;
        this.unidad = unidad;
        this.tema = tema;
        this.fechas = fechas;
        this.tarea = tarea;
        this.tecnica = tecnica;
    }

    public int getIdPlanCurso() {
        return idPlanCurso;
    }

    public void setIdPlanCurso(int idPlanCurso) {
        this.idPlanCurso = idPlanCurso;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }
    
    
    
}
