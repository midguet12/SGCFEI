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
            consultaPreparada.setDate(3, minuta.getFecha());
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
}