package pojos;

public class Academico implements POJO{
    private String numeroPersonal;
    private String nombre;
    private String correo;
    private String rol;

    public Academico(String numeroPersonal, String nombre, String correo, String rol) {
        this.numeroPersonal = numeroPersonal;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
    }

    public Academico(String nombre, String correo, String rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
    }

    public Academico() {
    }

    public String getNumeroPersonal() {
        return numeroPersonal;
    }

    public void setNumeroPersonal(String numeroPersonal) {
        this.numeroPersonal = numeroPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Academico{" + "numeroPersonal=" + numeroPersonal + ", nombre=" + nombre + ", correo=" + correo + ", rol=" + rol + '}';
    }
    
}
