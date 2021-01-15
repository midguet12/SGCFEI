package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.Academico;
import util.RegistroExcepciones;

public class AcademicoDAO implements DAO{
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;

    public AcademicoDAO() {
        db = new ConexionDB();
    }

    public void insertar(Academico academico) {
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO academico(nombre, correo, rol)"
                     + " VALUES(?, ?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, academico.getNombre());
            consultaPreparada.setString(2, academico.getCorreo());
            consultaPreparada.setString(3, academico.getRol());
            
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

    public void actualizar(Academico academico) {
        conexion = db.obtenerConexion();
        String consulta = "UPDATE academico SET nombre = ?, correo = ?, rol = ? WHERE idAcademico = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, academico.getNombre());
            consultaPreparada.setString(2, academico.getCorreo());
            consultaPreparada.setString(3, academico.getRol());
            consultaPreparada.setString(4, academico.getNumeroPersonal());
            
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

    public void eliminar(String numeroPersonal) {
        conexion = db.obtenerConexion();
        String consulta = "DELETE FROM academico WHERE idAcademico = ?;";
        try{            
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, numeroPersonal);
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
