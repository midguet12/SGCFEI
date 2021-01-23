package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.CuerpoAcademico;
import util.RegistroExcepciones;

public class CuerpoAcademicoDAO implements DAO{
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;

    public CuerpoAcademicoDAO() {
        db = new ConexionDB();
    }

    public boolean insertar(CuerpoAcademico cuerpoAcademico) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO cuerpoAcademico(nombre, idCoordinador) VALUES(?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, cuerpoAcademico.getNombre());
            consultaPreparada.setString(2, cuerpoAcademico.getIdCoordinador());
            
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

    public CuerpoAcademico obtener(int id) {
        CuerpoAcademico cuerpoAcademico = null;
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM cuerpoAcademico WHERE idCuerpoAcademico = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, id);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            cuerpoAcademico = new CuerpoAcademico(
                    resultados.getInt("idCuerpoAcademico"),
                    resultados.getString("nombre"),
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
        
        return cuerpoAcademico;
    }

    public boolean actualizar(CuerpoAcademico cuerpoAcademico) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "UPDATE cuerpoAcademico SET nombre = ?, idCoordinador = ? WHERE idCuerpoAcademico = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, cuerpoAcademico.getNombre());
            consultaPreparada.setString(2, cuerpoAcademico.getIdCoordinador());
            consultaPreparada.setInt(3, cuerpoAcademico.getIdCuerpoAcademico());
            
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

    public boolean eliminar(int id) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "DELETE FROM cuerpoAcademico WHERE idCuerpoAcademico = ?;";
        try{            
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, id);
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
