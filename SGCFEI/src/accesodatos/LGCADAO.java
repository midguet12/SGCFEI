package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojos.Academia;
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
        String consulta = "INSERT INTO lgca(clave, descripcion) VALUES(?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, lgca.getClave());
            consultaPreparada.setString(2, lgca.getDescripcion());
            
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
                    resultados.getString("descripcion"));
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
        String consulta = "UPDATE lgca SET clave = ?, descripcion = ? WHERE idLGCA = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, lgca.getClave());
            consultaPreparada.setString(2, lgca.getDescripcion());
            consultaPreparada.setInt(3, lgca.getIdLGCA());
            
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
    
    public List<LGCA> obtenerTodasLGCA() {
        List<LGCA> lgcas = new ArrayList<>();
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM lgca;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            resultados = consultaPreparada.executeQuery(); 
            while (resultados.next()) {
                LGCA lgca = new LGCA(
                    resultados.getInt("idLgca"),
                    resultados.getInt("clave"),
                    resultados.getString("descripcion"));
                
                lgcas.add(lgca);
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
        
        return lgcas;
    }
}
