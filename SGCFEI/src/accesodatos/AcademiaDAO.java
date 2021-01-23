package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.Academia;
import util.RegistroExcepciones;

public class AcademiaDAO implements DAO{
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;

    public AcademiaDAO() {
        db = new ConexionDB();
    }

    public void insertar(Academia academia) {
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO academia(nombre, descripcion, idCoordinador)"
                     + " VALUES(?, ?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, academia.getNombre());
            consultaPreparada.setString(2, academia.getDescripcion());
            consultaPreparada.setString(3, academia.getIdCoordinador());
            
            consultaPreparada.executeUpdate();
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
    }

    public Academia obtener(int id) {
        Academia academia = null;
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM academia WHERE idAcademia = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, id);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            academia = new Academia(
                    resultados.getInt("idAcademia"),
                    resultados.getString("nombre"),
                    resultados.getString("descripcion"),
                    resultados.getString("idCoordinador"));
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
        return academia;
    }

    public void actualizar(Academia academia) {
        conexion = db.obtenerConexion();
        String consulta = "UPDATE academia SET nombre = ?, descripcion = ?, idCoordinador = ? WHERE idAcademia = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, academia.getNombre());
            consultaPreparada.setString(2, academia.getDescripcion());
            consultaPreparada.setString(3, academia.getIdCoordinador());
            consultaPreparada.setInt(4, academia.getIdAcademia());
            
            consultaPreparada.executeUpdate();
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
    }

    public void eliminar(int id) {
        conexion = db.obtenerConexion();
        String consulta = "DELETE FROM academia WHERE idAcademia = ?;";
        try{            
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, id);
            consultaPreparada.executeUpdate();
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
    }   
}
