package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<AspectoMinuta> obtenerAspectosPorMinuta(int idMinuta){
        List<AspectoMinuta> aspectosMinuta = new ArrayList<>();
        conexion = db.obtenerConexion();
        conexion = db.obtenerConexion();
        String consulta = "SELECT AM.asunto, AC.nombre FROM aspectoMinuta AS AM INNER JOIN academico AS AC WHERE AM.idMinuta = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, idMinuta);
            resultados = consultaPreparada.executeQuery(); 
            while (resultados.next()) {
                AspectoMinuta aspectoMinuta = new AspectoMinuta();
                aspectoMinuta.setAsunto(resultados.getString("AM.asunto"));
                aspectoMinuta.setNombreParticipante(resultados.getString("AC.nombre"));
                aspectosMinuta.add(aspectoMinuta);
            }
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
        return aspectosMinuta;
    }
        
}
