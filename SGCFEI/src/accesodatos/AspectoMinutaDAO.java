package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.AspectoMinuta;
import util.RegistroExcepciones;

public class AspectoMinutaDAO implements DAO{
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;

    public AspectoMinutaDAO() {
        db = new ConexionDB();
    }

    public boolean insertar(AspectoMinuta aspectoMinuta) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO aspectoMinuta(asunto, idAcademico, idMinuta)"
                     + " VALUES(?, ?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, aspectoMinuta.getAsunto());
            consultaPreparada.setString(2, aspectoMinuta.getIdAcademico());
            consultaPreparada.setInt(3, aspectoMinuta.getIdMinuta());
            
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

    public AspectoMinuta obtener(int idAspectoMinuta) {
        AspectoMinuta aspectoMinuta = null;
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM aspectoMinuta WHERE idAspectoMinuta = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, idAspectoMinuta);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            aspectoMinuta = new AspectoMinuta(
                    resultados.getInt("idAspectoMinuta"),
                    resultados.getString("asunto"),
                    resultados.getString("idAcademico"),
                    resultados.getInt("idMinuta"));
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
        
        return aspectoMinuta;
    }

    public boolean actualizar(AspectoMinuta aspectoMinuta) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "UPDATE aspectoMinuta SET asunto = ?, idAcademico = ?, idMinuta = ? WHERE idAspectoMinuta = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, aspectoMinuta.getAsunto());
            consultaPreparada.setString(2, aspectoMinuta.getIdAcademico());
            consultaPreparada.setInt(3, aspectoMinuta.getIdMinuta());
            consultaPreparada.setInt(4, aspectoMinuta.getIdAspectoMinuta());
            
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

    public boolean eliminar(int idAspectoMinuta) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "DELETE FROM aspectoMinuta WHERE idAspectoMinuta = ?;";
        try{            
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, idAspectoMinuta);
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
