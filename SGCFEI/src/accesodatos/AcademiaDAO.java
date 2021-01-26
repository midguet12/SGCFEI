package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojos.Academia;
import util.RegistroExcepciones;

public class AcademiaDAO implements DAO{
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;

    public AcademiaDAO() {
        db = new ConexionDB();
    }

    public boolean insertar(Academia academia) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO academia(nombre, descripcion, idCoordinador)"
                     + " VALUES(?, ?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, academia.getNombre());
            consultaPreparada.setString(2, academia.getDescripcion());
            consultaPreparada.setString(3, academia.getIdCoordinador());
            
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

    public boolean actualizar(Academia academia) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "UPDATE academia SET nombre = ?, descripcion = ?, idCoordinador = ? WHERE idAcademia = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, academia.getNombre());
            consultaPreparada.setString(2, academia.getDescripcion());
            consultaPreparada.setString(3, academia.getIdCoordinador());
            consultaPreparada.setInt(4, academia.getIdAcademia());
            
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
        String consulta = "DELETE FROM academia WHERE idAcademia = ?;";
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
    
    public List<Academia> obtenerTodasAcademias() {
        List<Academia> academias = new ArrayList<>();
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM academia;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            resultados = consultaPreparada.executeQuery(); 
            while (resultados.next()) {
                Academia academia = new Academia(
                    resultados.getInt("idAcademia"),
                    resultados.getString("nombre"),
                    resultados.getString("descripcion"),
                    resultados.getString("idCoordinador"));
                
                academias.add(academia);
            }
        }catch (SQLException ex){    
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
        
        return academias;
    }
    
    public Academia obtenerAcademiaPorCoordinador(String idCoordinador) {
        Academia academia = null;
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM academia WHERE idCoordinador = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, idCoordinador);

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
    public List<String> obtenerNombres(){
            List<String> nombres = new ArrayList<>();
            conexion = db.obtenerConexion();
            String consulta = "Select nombre from academia;";

            try{
                PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
                resultados = consultaPreparada.executeQuery();
                while (resultados.next()){
                    nombres.add(resultados.getString("nombre"));
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


            return nombres;
        }
}
