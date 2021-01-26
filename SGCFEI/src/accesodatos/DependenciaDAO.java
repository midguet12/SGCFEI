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
import pojos.Dependencia;
import util.RegistroExcepciones;

/**
 *
 * @author midgu
 */
public class DependenciaDAO implements DAO{
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;
    
    public DependenciaDAO(){
        db = new ConexionDB();
    }
    
    public boolean insertar(Dependencia dependencia){
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO dependencia(nombre)"
                     + " VALUES(?);";
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, dependencia.getNombre());
            
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
    
    public Dependencia obtener(int id){
        Dependencia dependencia = null;
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM dependencia WHERE idDependencia = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, id);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            dependencia = new Dependencia(
                    resultados.getInt("idDependencia"),
                    resultados.getString("nombre"));
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
        return dependencia;
        
    }
    
    public boolean actualizar(Dependencia dependencia) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "UPDATE dependencia SET nombre = ? WHERE idDependencia = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, dependencia.getNombre());
            consultaPreparada.setInt(2, dependencia.getId());
            
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
        String consulta = "DELETE FROM dependencia WHERE idDependencia = ?;";
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
    
    public List<Dependencia> obtenerTodasDependencias() {
        List<Dependencia> dependencias = new ArrayList<>();
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM dependencia;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            resultados = consultaPreparada.executeQuery(); 
            while (resultados.next()) {
                Dependencia dependencia = new Dependencia(
                    resultados.getInt("id"),
                    resultados.getString("nombre"));
                
                dependencias.add(dependencia);
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
        
        return dependencias;
    }
    public List<String> obtenerNombres(){
            List<String> nombres = new ArrayList<>();
            conexion = db.obtenerConexion();
            String consulta = "Select nombre from dependencia;";

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
