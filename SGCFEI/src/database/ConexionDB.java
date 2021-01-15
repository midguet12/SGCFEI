package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.RegistroExcepciones;

public class ConexionDB {
    private Connection conexion;    
    private DBCredenciales credenciales;

    public ConexionDB() {
        conexion = null;
        credenciales = null;
    }
    
    public void iniciarConexion(){ 
        credenciales = ControladorCredenciales.leer();
        try{
            conexion = DriverManager.getConnection(credenciales.getStringConexion(), 
                    credenciales.getUsuario(), credenciales.getContrasena());
        }
        catch(SQLException ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
    }
    
    public Connection obtenerConexion(){
        iniciarConexion();
        return conexion;
    }
    
    public void cerrarConexion(){ 
        if (conexion != null) {
            try{
                if(!conexion.isClosed()){
                    conexion.close();
                }
            }
            catch(SQLException ex){
                RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
            }
        }
    }  
}