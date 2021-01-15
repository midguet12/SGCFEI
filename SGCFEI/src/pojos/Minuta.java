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
public class Minuta {
    private int idMinuta;
    private int idAcademia;
    private int idCarrera;
    private String fecha;
    private String hora;
    private String periodo;
    private String lugar;
    private String objetivo;
    private String temas;
    private String conclusiones;

    public Minuta() {
    }

    public int getIdMinuta() {
        return idMinuta;
    }

    public int getIdAcademia() {
        return idAcademia;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getLugar() {
        return lugar;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getTemas() {
        return temas;
    }

    public String getConclusiones() {
        return conclusiones;
    }

    public void setIdMinuta(int idMinuta) {
        this.idMinuta = idMinuta;
    }

    public void setIdAcademia(int idAcademia) {
        this.idAcademia = idAcademia;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setTemas(String temas) {
        this.temas = temas;
    }

    public void setConclusiones(String conclusiones) {
        this.conclusiones = conclusiones;
    }
    
}
