package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.Carrera;
import util.RegistroExcepciones;

public class CarreraDAO implements DAO{
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;

    public CarreraDAO() {
        db = new ConexionDB();
    }

    public boolean insertar(Carrera carrera) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO carrera(nombre, idFacultad) VALUES(?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, carrera.getNombre());
            consultaPreparada.setInt(2, carrera.getIdFacultad());
            
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

    public Carrera obtener(int id) {
        Carrera carrera = null;
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM carrera WHERE idCarrera = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, id);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            carrera = new Carrera(
                    resultados.getInt("idCarrera"),
                    resultados.getString("nombre"),
                    resultados.getInt("idFacultad"));
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
        return carrera;
    }

    public boolean actualizar(Carrera carrera) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "UPDATE carrera SET nombre = ?, idFacultad = ? WHERE idCarrera = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, carrera.getNombre());
            consultaPreparada.setInt(2, carrera.getIdFacultad());
            consultaPreparada.setInt(3, carrera.getIdCarrera());
            
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
        String consulta = "DELETE FROM carrera WHERE idCarrera = ?;";
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
