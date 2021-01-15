package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.Carrera;
import util.RegistroExcepciones;

public class CarreraDAO {
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;

    public CarreraDAO() {
        db = new ConexionDB();
    }

    public void insertar(Carrera carrera) {
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO carrera(nombre, idFacultad) VALUES(?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, carrera.getNombre());
            consultaPreparada.setInt(2, carrera.getIdFacultad());
            
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

    public void actualizar(Carrera carrera) {
        conexion = db.obtenerConexion();
        String consulta = "UPDATE carrera SET nombre = ?, idFacultad = ? WHERE idCarrera = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, carrera.getNombre());
            consultaPreparada.setInt(2, carrera.getIdFacultad());
            consultaPreparada.setInt(3, carrera.getIdCarrera());
            
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
        String consulta = "DELETE FROM carrera WHERE idCarrera = ?;";
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
