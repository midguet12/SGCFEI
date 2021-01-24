package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojos.Academico;
import util.RegistroExcepciones;

public class AcademicoDAO implements DAO{
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;

    public AcademicoDAO() {
        db = new ConexionDB();
    }

    public boolean insertar(Academico academico) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO academico(numeroPersonal, nombre, correo, rol)"
                     + " VALUES(?, ?, ?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, academico.getNumeroPersonal());
            consultaPreparada.setString(2, academico.getNombre());
            consultaPreparada.setString(3, academico.getCorreo());
            consultaPreparada.setString(4, academico.getRol());
            
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

    public Academico obtener(String numeroPersonal) {
        Academico academico = null;
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM academico WHERE numeroPersonal = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, numeroPersonal);
            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            academico = new Academico(
                    resultados.getString("numeroPersonal"),
                    resultados.getString("nombre"),
                    resultados.getString("correo"),
                    resultados.getString("Rol"));
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
        
        return academico;
    }

    public boolean actualizar(Academico academico) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "UPDATE academico SET nombre = ?, correo = ?, rol = ? WHERE numeroPersonal = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, academico.getNombre());
            consultaPreparada.setString(2, academico.getCorreo());
            consultaPreparada.setString(3, academico.getRol());
            consultaPreparada.setString(4, academico.getNumeroPersonal());
            
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

    public boolean eliminar(String numeroPersonal) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "DELETE FROM academico WHERE numeroPersonal = ?;";
        try{            
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, numeroPersonal);
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
    
    public List<Academico> obtenerTodosAcademicos() {
        List<Academico> academicos = new ArrayList<>();
        conexion = db.obtenerConexion();
        String consulta = "SELECT numeroPersonal, nombre, correo, rol FROM academico WHERE rol != 'Administrador'";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            resultados = consultaPreparada.executeQuery(); 
            while (resultados.next()) {
                Academico academico = new Academico();
                academico.setNumeroPersonal(resultados.getString("numeroPersonal"));
                academico.setNombre(resultados.getString("nombre"));
                academico.setCorreo(resultados.getString("correo"));
                academico.setRol(resultados.getString("rol"));
                academicos.add(academico);
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
        
        return academicos;
    }
    
    public List<Academico> obtenerAcademicosPorRol(String rol) {
        List<Academico> academicos = new ArrayList<>();
        conexion = db.obtenerConexion();
        String consulta = "SELECT numeroPersonal, nombre, correo, rol FROM academico where rol = ?;";    
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, rol);
            resultados = consultaPreparada.executeQuery(); 
            while (resultados.next()) {
                Academico academico = new Academico();
                academico.setNumeroPersonal(resultados.getString("numeroPersonal"));
                academico.setNombre(resultados.getString("nombre"));
                academico.setCorreo(resultados.getString("correo"));
                academico.setRol(resultados.getString("rol"));
                academicos.add(academico);
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
        
        return academicos;
    }
    
    public boolean esNumeroPersonalRegistrado(String numeroPersonal) {
        conexion = db.obtenerConexion();
        boolean esRegistrado = true;
        String consulta = "SELECT * FROM academico where numeroPersonal = ?";
        try {
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, numeroPersonal);

            resultados = consultaPreparada.executeQuery(); 
            if(resultados.next()){
                esRegistrado = true;
            }else{
                esRegistrado = false;
            }
        } catch (SQLException ex){    
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
        
        return esRegistrado;
    }
        
}
