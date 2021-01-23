package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.LGCA;
import util.RegistroExcepciones;

public class LGCADAO implements DAO{
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;

    public LGCADAO() {
        db = new ConexionDB();
    }

    public boolean insertar(LGCA lgca) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO lgca(clave, descripcion, idResponsable) VALUES(?, ?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, lgca.getClave());
            consultaPreparada.setString(2, lgca.getDescripcion());
            consultaPreparada.setString(3, lgca.getIdResponsable());
            
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

    public LGCA obtener(int id) {
        LGCA lgca = null;
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM lgca WHERE idLGCA = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, id);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            lgca = new LGCA(
                    resultados.getInt("idLgca"),
                    resultados.getInt("clave"),
                    resultados.getString("descripcion"),
                    resultados.getString("idResponsable"));
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
        
        return lgca;
    }

    public boolean actualizar(LGCA lgca) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "UPDATE lgca SET clave = ?, descripcion = ?, idResponsable = ? WHERE idLGCA = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, lgca.getClave());
            consultaPreparada.setString(2, lgca.getDescripcion());
            consultaPreparada.setString(3, lgca.getIdResponsable());
            consultaPreparada.setInt(4, lgca.getIdLGCA());
            
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
        String consulta = "DELETE FROM lgca WHERE idLGCA = ?;";
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
