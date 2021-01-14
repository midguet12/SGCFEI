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
public class Usuario {
    private int idUsuario;
    private String username; 
    private String password;

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Academico getAcademico() {
        return academico;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
