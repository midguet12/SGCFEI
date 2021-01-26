/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojos.Minuta;
import util.RegistroExcepciones;

/**
 *
 * @author Luis
 */
public class MinutaDAO implements DAO{
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;

    public MinutaDAO() {
        db = new ConexionDB();
    }
    
    public int insertar(Minuta minuta){
        int idMinuta = 0;
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO minuta (idAcademia, idCarrera, fecha, periodo, lugar, objetivo, temas, conclusiones) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, minuta.getIdAcademia());
            consultaPreparada.setInt(2, minuta.getIdCarrera());
            consultaPreparada.setString(3, minuta.getFecha());
            consultaPreparada.setString(4, minuta.getPeriodo());
            consultaPreparada.setString(5, minuta.getLugar());
            consultaPreparada.setString(6, minuta.getObjetivo());
            consultaPreparada.setString(7, minuta.getTemas());
            consultaPreparada.setString(8, minuta.getConclusiones());
            consultaPreparada.executeUpdate();
            consulta = "SELECT LAST_INSERT_ID()";
            consultaPreparada = conexion.prepareStatement(consulta);
            resultados = consultaPreparada.executeQuery();
            resultados.next();
            idMinuta = resultados.getInt(1);
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
        return idMinuta;
    }
    
    public List<Minuta> obtenerMinutasPorAcademia(int idAcademia){
        List<Minuta> minutas = new ArrayList<>();
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM minuta WHERE idAcademia = ?;";    
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, idAcademia);
            resultados = consultaPreparada.executeQuery(); 
            while (resultados.next()) {
                Minuta minuta = new Minuta();
                minuta.setIdMinuta(resultados.getInt("idMinuta"));
                minuta.setIdAcademia(resultados.getInt("idAcademia"));
                minuta.setIdCarrera(resultados.getInt("idCarrera"));
                minuta.setPeriodo(resultados.getString("periodo"));
                minuta.setFecha(resultados.getString("fecha"));
                minuta.setLugar(resultados.getString("lugar"));
                minuta.setObjetivo(resultados.getString("objetivo"));
                minuta.setTemas(resultados.getString("temas"));
                minuta.setConclusiones(resultados.getString("conclusiones"));
                minutas.add(minuta);
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
        
        return minutas;
    }

    public boolean actualizar(Minuta minuta) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "UPDATE minuta SET idCarrera = ?, periodo = ?, lugar = ?, objetivo = ?, temas = ?, conclusiones = ?, fecha = ? WHERE idMinuta = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, minuta.getIdCarrera());
            consultaPreparada.setString(2, minuta.getPeriodo());
            consultaPreparada.setString(3, minuta.getLugar());
            consultaPreparada.setString(4, minuta.getObjetivo());
            consultaPreparada.setString(5, minuta.getTemas());
            consultaPreparada.setString(6, minuta.getConclusiones());
            consultaPreparada.setString(7, minuta.getFecha());
            consultaPreparada.setInt(8, minuta.getIdMinuta());
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

    public boolean eliminar(int idMinuta) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "DELETE FROM minuta WHERE idMinuta = ?;";
        try{            
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, idMinuta);
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
