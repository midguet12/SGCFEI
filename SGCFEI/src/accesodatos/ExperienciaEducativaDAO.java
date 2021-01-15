package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.ExperienciaEducativa;
import util.RegistroExcepciones;

public class ExperienciaEducativaDAO {
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;

    public ExperienciaEducativaDAO() {
        db = new ConexionDB();
    }

    public void insertar(ExperienciaEducativa experienciaEducativa) {
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO experienciaEducativa(nombre, idAcademia) VALUES(?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, experienciaEducativa.getNombre());
            consultaPreparada.setInt(2, experienciaEducativa.getIdAcademia());
            
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

    public ExperienciaEducativa obtener(int nrc) {
        ExperienciaEducativa experienciaEducativa = null;
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM experienciaEducativa WHERE nrc = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, nrc);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            experienciaEducativa = new ExperienciaEducativa(
                    resultados.getInt("nrc"),
                    resultados.getString("nombre"),
                    resultados.getInt("idAcademia"));
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
        return experienciaEducativa;
    }

    public void actualizar(ExperienciaEducativa experienciaEducativa) {
        conexion = db.obtenerConexion();
        String consulta = "UPDATE experienciaEducativa SET nombre = ?, idAcademia = ? WHERE nrc = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, experienciaEducativa.getNombre());
            consultaPreparada.setInt(2, experienciaEducativa.getIdAcademia());
            consultaPreparada.setInt(3, experienciaEducativa.getNrc());
            
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

    public void eliminar(int nrc) {
        conexion = db.obtenerConexion();
        String consulta = "DELETE FROM experienciaEducativa WHERE nrc = ?;";
        try{            
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, nrc);
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
