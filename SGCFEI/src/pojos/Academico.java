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
public class Academico {
    private int idAcademico;
    private String numeroPersonal;
    private String nombre;
    private String correo;
    private String rol;

    public Academico() {
    }

    public int getIdAcademico() {
        return idAcademico;
    }

    public String getNumeroPersonal() {
        return numeroPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRol() {
        return rol;
    }

    public void setIdAcademico(int idAcademico) {
        this.idAcademico = idAcademico;
    }

    public void setNumeroPersonal(String numeroPersonal) {
        this.numeroPersonal = numeroPersonal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Academico{" + "idAcademico=" + idAcademico + ", numeroPersonal=" + numeroPersonal + ", nombre=" + nombre + ", correo=" + correo + ", rol=" + rol + '}';
    }
    
}
