package util;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class obtenerID {
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;

    public obtenerID() {
        db = new ConexionDB();
    }
    
    public int obtenerIDAcademia(String nombre){
        int id = 0;
        conexion = db.obtenerConexion();
        String consulta = "SELECT idAcademia FROM academia WHERE nombre = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, nombre);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            id = resultados.getInt("idAcademia");
        }
        catch (SQLException ex){    
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        } 
        catch (NullPointerException ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        catch (Exception ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        finally{
            db.cerrarConexion();
        }        
        return id;
    }
    
    public String obtenerIDAcademico(String nombre){
        String num = "";
        conexion = db.obtenerConexion();
        String consulta = "SELECT numeroPersonal FROM academico WHERE nombre = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, nombre);

            resultados = consultaPreparada.executeQuery(); 
            
            resultados.next();
            
            num = resultados.getString("numeroPersonal");
        }
        catch (SQLException ex){    
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        } 
        catch (NullPointerException ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        catch (Exception ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        finally{
            db.cerrarConexion();
        }        
        return num;
    }
    
    public int obtenerIDCarrera(String nombre){
        int id = 0;
        conexion = db.obtenerConexion();
        String consulta = "SELECT idCarrera FROM carrera WHERE nombre = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, nombre);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            id = resultados.getInt("idCarrera");
        }
        catch (SQLException ex){    
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        } 
        catch (NullPointerException ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        catch (Exception ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        finally{
            db.cerrarConexion();
        }        
        return id;
    }
    
    public int obtenerIDCuerpoAcademico(String nombre){
        int id = 0;
        conexion = db.obtenerConexion();
        String consulta = "SELECT idCuerpoAcademico FROM cuerpoAcademico WHERE nombre = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, nombre);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            id = resultados.getInt("idCuerpoAcademico");
        }
        catch (SQLException ex){    
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        } 
        catch (NullPointerException ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        catch (Exception ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        finally{
            db.cerrarConexion();
        }        
        return id;
    }
    
    public int obtenerIDExperienciaEducativa(String nombre){
        int id = 0;
        conexion = db.obtenerConexion();
        String consulta = "SELECT nrc FROM experienciaEducativa WHERE nombre = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, nombre);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            id = resultados.getInt("nrc");
        }
        catch (SQLException ex){    
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        } 
        catch (NullPointerException ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        catch (Exception ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        finally{
            db.cerrarConexion();
        }        
        return id;
    }
    
    public int obtenerIDFacultad(String nombre){
        int id = 0;
        conexion = db.obtenerConexion();
        String consulta = "SELECT idFacultad FROM facultad WHERE nombre = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, nombre);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            id = resultados.getInt("idFacultad");
        }
        catch (SQLException ex){    
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        } 
        catch (NullPointerException ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        catch (Exception ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        finally{
            db.cerrarConexion();
        }        
        return id;
    }
    
    public int obtenerIDlgca(String nombre){
        int id = 0;
        conexion = db.obtenerConexion();
        String consulta = "SELECT idLgca FROM lgca WHERE descripcion = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, nombre);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            id = resultados.getInt("idLgca");
        }
        catch (SQLException ex){    
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        } 
        catch (NullPointerException ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        catch (Exception ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        finally{
            db.cerrarConexion();
        }        
        return id;
    }
    
    public int obtenerIDMinuta(String nombre){
        int id = 0;
        conexion = db.obtenerConexion();
        String consulta = "SELECT idMinuta FROM minuta WHERE nombre = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, nombre);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            id = resultados.getInt("idMinuta");
        }
        catch (SQLException ex){    
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        } 
        catch (NullPointerException ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        catch (Exception ex){
            RegistroExcepciones.escribirExcepcion(ex, this.getClass().getName());
        }
        finally{
            db.cerrarConexion();
        }        
        return id;
    }    
}
