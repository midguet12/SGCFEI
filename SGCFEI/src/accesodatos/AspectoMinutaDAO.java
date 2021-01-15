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

    public void insertar(AspectoMinuta aspectoMinuta) {
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO aspectoMinuta(asunto, idAcademico, idMinuta)"
                     + " VALUES(?, ?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, aspectoMinuta.getAsunto());
            consultaPreparada.setString(2, aspectoMinuta.getIdAcademico());
            consultaPreparada.setInt(3, aspectoMinuta.getIdMinuta());
            
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

    public void actualizar(AspectoMinuta aspectoMinuta) {
        conexion = db.obtenerConexion();
        String consulta = "UPDATE aspectoMinuta SET asunto = ?, idAcademico = ?, idMinuta = ? WHERE idAspectoMinuta = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, aspectoMinuta.getAsunto());
            consultaPreparada.setString(2, aspectoMinuta.getIdAcademico());
            consultaPreparada.setInt(3, aspectoMinuta.getIdMinuta());
            consultaPreparada.setInt(4, aspectoMinuta.getIdAspectoMinuta());
            
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

    public void eliminar(int idAspectoMinuta) {
        conexion = db.obtenerConexion();
        String consulta = "DELETE FROM aspectoMinuta WHERE idAspectoMinuta = ?;";
        try{            
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, idAspectoMinuta);
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
