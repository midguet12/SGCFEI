package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojos.ExperienciaEducativa;
import util.RegistroExcepciones;

public class ExperienciaEducativaDAO implements DAO{
    private ConexionDB db;
    private Connection conexion;
    private ResultSet resultados;

    public ExperienciaEducativaDAO() {
        db = new ConexionDB();
    }

    public boolean insertar(ExperienciaEducativa experienciaEducativa) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "INSERT INTO experienciaEducativa(ncr, codigo, nombre, areaFormacionPrincipal, areaFormacionSecundaria, creditos, teoria, practica, totalHoras, equivalencias, modalidad, oportunidadesEvaluacion, requisitos, coRequisitos, idAcademia) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, experienciaEducativa.getNrc());
            consultaPreparada.setString(2, experienciaEducativa.getCodigo());
            consultaPreparada.setString(3, experienciaEducativa.getNombre());
            consultaPreparada.setString(4, experienciaEducativa.getAreaFormacionPrincipal());
            consultaPreparada.setString(5, experienciaEducativa.getAreaFormacionSecundaria());
            consultaPreparada.setInt(6, experienciaEducativa.getCreditos());
            consultaPreparada.setInt(7, experienciaEducativa.getTeoria());
            consultaPreparada.setInt(8, experienciaEducativa.getPractica());
            consultaPreparada.setInt(9, experienciaEducativa.getTotalHoras());
            consultaPreparada.setString(10, experienciaEducativa.getEquivalencias());
            consultaPreparada.setString(11, experienciaEducativa.getModalidad());
            consultaPreparada.setString(12, experienciaEducativa.getOportunidadesEvaluacion());
            consultaPreparada.setString(13, experienciaEducativa.getRequisitos());
            consultaPreparada.setString(14, experienciaEducativa.getCoRequisitos());
            consultaPreparada.setInt(15, experienciaEducativa.getIdAcademia());
            
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

    public ExperienciaEducativa obtener(int nrc) {
        ExperienciaEducativa experienciaEducativa = null;
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM experienciaEducativa WHERE nrc = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, nrc);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            experienciaEducativa = new ExperienciaEducativa(
                    resultados.getInt("nrc"),
                    resultados.getString("codigo"),
                    resultados.getString("nombre"),
                    resultados.getString("areaFormacionPrincipal"),
                    resultados.getString("areaFormacionSecundaria"),
                    resultados.getInt("creditos"),
                    resultados.getInt("teoria"),
                    resultados.getInt("practica"),
                    resultados.getInt("totalHoras"),
                    resultados.getString("equivalencias"),
                    resultados.getString("modalidad"),
                    resultados.getString("oportunidadesEvaluacion"),
                    resultados.getString("requisitos"),
                    resultados.getString("coRequisitos"),
                    resultados.getInt("idAcademia"));
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
        
        return experienciaEducativa;
    }

    public boolean actualizar(ExperienciaEducativa experienciaEducativa) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "UPDATE experienciaEducativa SET codigo = ?, nombre = ?, areaFormacionPrincipal = ?, areaFormacionSecundaria = ?, creditos = ?, teoria = ?, practica = ?, totalHoras = ?, equivalencias = ?, modalidad = ?, oportunidadesEvaluacion = ?, requisitos = ?, coRequisitos = ?, idAcademia = ? where nrc = ?;";
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, experienciaEducativa.getCodigo());
            consultaPreparada.setString(2, experienciaEducativa.getNombre());
            consultaPreparada.setString(3, experienciaEducativa.getAreaFormacionPrincipal());
            consultaPreparada.setString(4, experienciaEducativa.getAreaFormacionSecundaria());
            consultaPreparada.setInt(5, experienciaEducativa.getCreditos());
            consultaPreparada.setInt(6, experienciaEducativa.getTeoria());
            consultaPreparada.setInt(7, experienciaEducativa.getPractica());
            consultaPreparada.setInt(8, experienciaEducativa.getTotalHoras());
            consultaPreparada.setString(9, experienciaEducativa.getEquivalencias());
            consultaPreparada.setString(10, experienciaEducativa.getModalidad());
            consultaPreparada.setString(11, experienciaEducativa.getOportunidadesEvaluacion());
            consultaPreparada.setString(13, experienciaEducativa.getRequisitos());
            consultaPreparada.setString(13, experienciaEducativa.getCoRequisitos());
            consultaPreparada.setInt(14, experienciaEducativa.getIdAcademia());
            consultaPreparada.setInt(15, experienciaEducativa.getNrc());
            
            
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

    public boolean eliminar(int nrc) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "DELETE FROM experienciaEducativa WHERE nrc = ?;";
        try{            
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, nrc);
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
    public List<ExperienciaEducativa> obtenerTodasExperiencias() {
            List<ExperienciaEducativa> experiencias = new ArrayList<>();
            conexion = db.obtenerConexion();
            String consulta = "SELECT * FROM experienciaEducativa;";

            try { 
                PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
                resultados = consultaPreparada.executeQuery(); 
                while (resultados.next()) {
                    ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa(
                    resultados.getInt("nrc"),
                    resultados.getString("codigo"),
                    resultados.getString("nombre"),
                    resultados.getString("areaFormacionPrincipal"),
                    resultados.getString("areaFormacionSecundaria"),
                    resultados.getInt("creditos"),
                    resultados.getInt("teoria"),
                    resultados.getInt("practica"),
                    resultados.getInt("totalHoras"),
                    resultados.getString("equivalencias"),
                    resultados.getString("modalidad"),
                    resultados.getString("oportunidadesEvaluacion"),
                    resultados.getString("requisitos"),
                    resultados.getString("coRequisitos"),
                    resultados.getInt("idAcademia"));

                    experiencias.add(experienciaEducativa);
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

            return experiencias;
        }
}
