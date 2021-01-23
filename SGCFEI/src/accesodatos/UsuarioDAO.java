package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.Usuario;
import util.RegistroExcepciones;

public class UsuarioDAO {
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;

    public UsuarioDAO() {
        db = new ConexionDB();
    }

    public boolean insertar(Usuario usuario) {
        int count = 0;
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO usuario(username, password, idAcademico) VALUES(?, ?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, usuario.getUsername());
            consultaPreparada.setString(2, usuario.getPassword());
            consultaPreparada.setString(3, usuario.getIdAcademico());
            count = consultaPreparada.executeUpdate();
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
        return count > 0;
    }

    public Usuario obtener(int id) {
        Usuario usuario = null;
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM usuario WHERE idUsuario = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, id);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            usuario = new Usuario(
                    resultados.getInt("idUsuario"),
                    resultados.getString("username"),
                    resultados.getString("password"),
                    resultados.getString("idAcademico"));
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
        return usuario;
    }

    public void actualizar(Usuario usuario) {
        conexion = db.obtenerConexion();
        String consulta = "UPDATE usuario SET username = ?, password = ?, idAcademico = ? WHERE idUsuario = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, usuario.getUsername());
            consultaPreparada.setString(2, usuario.getPassword());
            consultaPreparada.setString(3, usuario.getIdAcademico());
            consultaPreparada.setInt(4, usuario.getIdUsuario());
            
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
        String consulta = "DELETE FROM usuario WHERE idUsuario = ?;";
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
    
    public boolean esCorreoRegistrado(String correo){
        conexion = db.obtenerConexion();
        boolean esRegistrado = true;
        String consulta = "SELECT * FROM usuario WHERE username = ?";
        try {
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, correo);
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
