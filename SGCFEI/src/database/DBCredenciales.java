package database;

import java.io.Serializable;


public class DBCredenciales implements Serializable{
    private static final long serialVersionUID = 2021L; 
    private final String direccion;
    private final String puerto;
    private final String db;
    private final String usuario;
    private final String contrasena;

    public DBCredenciales(String direccion, String puerto, String db, String usuario, String contrasena) {
        this.direccion = direccion;
        this.puerto = puerto;
        this.db = db;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPuerto() {
        return puerto;
    }

    public String getDb() {
        return db;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    public String getStringConexion(){
        return "jdbc:mysql://" + direccion + ":" + puerto + "/" + db +"?useUnicode=yes&characterEncoding=UTF-8";
    }
    
    @Override
    public String toString() {
        return "DBCredenciales{" + "direccion=" + direccion + ", puerto=" + puerto + ", db=" + db + ", usuario=" + usuario + ", contrasena=" + contrasena + '}';
    }
        
}
