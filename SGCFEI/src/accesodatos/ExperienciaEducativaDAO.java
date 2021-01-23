package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.ExperienciaEducativa;
import util.RegistroExcepciones;

public class ExperienciaEducativaDAO implements DAO{
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;

    public ExperienciaEducativaDAO() {
        db = new ConexionDB();
    }

    public boolean insertar(ExperienciaEducativa experienciaEducativa) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO experienciaEducativa(nombre, idAcademia) VALUES(?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, experienciaEducativa.getNombre());
            consultaPreparada.setInt(2, experienciaEducativa.getIdAcademia());
            
            filasModificadas = consultaPreparada.executeUpdate();
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
        
        return filasModificadas > 0;
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

    public boolean actualizar(ExperienciaEducativa experienciaEducativa) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "UPDATE experienciaEducativa SET nombre = ?, idAcademia = ? WHERE nrc = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, experienciaEducativa.getNombre());
            consultaPreparada.setInt(2, experienciaEducativa.getIdAcademia());
            consultaPreparada.setInt(3, experienciaEducativa.getNrc());
            
            filasModificadas = consultaPreparada.executeUpdate();
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
         
        return filasModificadas > 0;
    }

    public boolean eliminar(int nrc) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "DELETE FROM experienciaEducativa WHERE nrc = ?;";
        try{            
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, nrc);
            filasModificadas = consultaPreparada.executeUpdate();
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
        
        return filasModificadas > 0;
    }
}
