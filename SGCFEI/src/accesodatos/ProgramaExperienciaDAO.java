package accesodatos;

import database.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojos.ProgramaExperiencia;
import util.RegistroExcepciones;

public class ProgramaExperienciaDAO implements DAO{
   private ConexionDB db;
   private Connection conexion;
   private ResultSet resultados;
   
   
   public ProgramaExperienciaDAO(){
       db = new ConexionDB();
       
   }
   
   public boolean insertar(ProgramaExperiencia programaExperiencia){
       int filasModificadas = 0;
       conexion = db.obtenerConexion();
       String consulta = "insert into programaExperiencia(academia, programa, campus, dependencia, codigo, nombreExperiencia, areaFormacionPrincipal, areaFormacionSecundaria, creditos, teoria, practica, totalHoras, equivalencias, modalidad, oportunidadesEvaluacion, requisitos, coRequisitos, individualGrupal, maximo, minimo, agrupacion, proyecto, academicos, perfil, espacio, relacionDisciplinaria, descripcion, justificacion, unidadCompetencia, articulacion, teorico, heuristico, axiologicos, estrategiasAprendizaje, estrategiasEnsenanza, materialesDidacticos, recursosDidacticos, acreditacion, bibliografiaBasica, bibliografiaComplementaria) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
       try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, programaExperiencia.getAcademia());
            consultaPreparada.setString(2, programaExperiencia.getPrograma());
            consultaPreparada.setString(3, programaExperiencia.getCampus());
            consultaPreparada.setString(4, programaExperiencia.getDependencia());
            consultaPreparada.setString(5, programaExperiencia.getCodigo());
            consultaPreparada.setString(6, programaExperiencia.getNombreExperiencia());
            consultaPreparada.setString(7, programaExperiencia.getAreaFormacionPrincipal());
            consultaPreparada.setString(8, programaExperiencia.getAreaFormacionSecundaria());
            consultaPreparada.setInt(9, programaExperiencia.getCreditos());
            consultaPreparada.setInt(10, programaExperiencia.getTeoria());
            consultaPreparada.setInt(11, programaExperiencia.getPractica());
            consultaPreparada.setInt(12, programaExperiencia.getTotalHoras());
            consultaPreparada.setString(13, programaExperiencia.getEquivalencias());
            consultaPreparada.setString(14, programaExperiencia.getModalidad());
            consultaPreparada.setString(15, programaExperiencia.getOportunidadesEvaluacion());
            consultaPreparada.setString(16, programaExperiencia.getRequisitos());
            consultaPreparada.setString(17, programaExperiencia.getCoRequisitos());
            consultaPreparada.setString(18, programaExperiencia.getIndividualGrupal());
            consultaPreparada.setInt(19, programaExperiencia.getMaximo());
            consultaPreparada.setInt(20, programaExperiencia.getMinimo());
            consultaPreparada.setString(21, programaExperiencia.getAgrupacion());
            consultaPreparada.setString(22, programaExperiencia.getProyecto());
            consultaPreparada.setString(23, programaExperiencia.getAcademicos());
            consultaPreparada.setString(24, programaExperiencia.getPerfil());
            consultaPreparada.setString(25, programaExperiencia.getEspacio());
            consultaPreparada.setString(26, programaExperiencia.getRelacionDisciplinaria());
            consultaPreparada.setString(27, programaExperiencia.getDescripcion());
            consultaPreparada.setString(28, programaExperiencia.getJustificacion());
            consultaPreparada.setString(29, programaExperiencia.getUnidadCompetencia());
            consultaPreparada.setString(30, programaExperiencia.getArticulacion());
            consultaPreparada.setString(31, programaExperiencia.getTeorico());
            consultaPreparada.setString(32, programaExperiencia.getHeuristico());
            consultaPreparada.setString(33, programaExperiencia.getAxiologicos());
            consultaPreparada.setString(34, programaExperiencia.getEstrategiasAprendizaje());
            consultaPreparada.setString(35, programaExperiencia.getEstrategiasEnsenanza());
            consultaPreparada.setString(36, programaExperiencia.getMaterialesDidacticos());
            consultaPreparada.setString(37, programaExperiencia.getRecursosDidacticos());
            consultaPreparada.setString(38, programaExperiencia.getAcreditacion());
            consultaPreparada.setString(39, programaExperiencia.getBibliografiaBasica());
            consultaPreparada.setString(40, programaExperiencia.getBibliografiaComplementaria());
            
            
            
            
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
   
    public ProgramaExperiencia obtener(int idProgramaEE) {
        ProgramaExperiencia programaExperiencia = null;
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM programaExperiencia WHERE idProgramaEE = ?;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, idProgramaEE);

            resultados = consultaPreparada.executeQuery(); 
            resultados.next();
            
            programaExperiencia = new ProgramaExperiencia(
                    resultados.getString("academia"),
                    resultados.getString("programa"),
                    resultados.getString("campus"),
                    resultados.getString("dependencia"),
                    resultados.getString("codigo"),
                    resultados.getString("nombreExperiencia"),
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
                    resultados.getString("individualGrupal"),
                    resultados.getInt("maximo"),
                    resultados.getInt("minimo"),
                    resultados.getString("agrupacion"),
                    resultados.getString("proyecto"),
                    resultados.getString("academicos"),
                    resultados.getString("perfil"),
                    resultados.getString("espacio"),
                    resultados.getString("relacionDisciplinaria"),
                    resultados.getString("descripcion"),
                    resultados.getString("justificacion"),
                    resultados.getString("unidadCompetencia"),
                    resultados.getString("articulacion"),
                    resultados.getString("teorico"),
                    resultados.getString("heuristico"),
                    resultados.getString("axiologicos"),
                    resultados.getString("estrategiasAprendizaje"),
                    resultados.getString("estrategiasEnsenanza"),
                    resultados.getString("materialesDidacticos"),
                    resultados.getString("recursosDidacticos"),
                    resultados.getString("acreditacion"),
                    resultados.getString("bibliografiaBasica"),
                    resultados.getString("bibliografiaComplementaria"));
                    
                    
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
        
        return programaExperiencia;
    }
    
    public boolean actualizar(ProgramaExperiencia programaExperiencia) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "update programaExperiencia set academia = ?, programa = ?, campus = ?, dependencia = ?, codigo = ?, nombreExperiencia = ?, areaFormacionPrincipal = ?, areaFormacionSecundaria = ?, creditos = ?, teoria = ?, practica = ?, totalHoras = ?, equivalencias = ?, modalidad = ?, oportunidadesEvaluacion = ?, requisitos = ?, coRequisitos = ?, individualGrupal = ?, maximo = ?, minimo = ?, agrupacion = ?, proyecto = ?, academicos = ?, perfil = ?, espacio = ?, relacionDisciplinaria = ?, descripcion = ?, justificacion = ?, unidadCompetencia = ?, articulacion = ?, teorico = ?, heuristico = ?, axiologicos = ?, estrategiasAprendizaje = ?, estrategiasEnsenanza = ?, materialesDidacticos = ?, recursosDidacticos = ?, acreditacion = ?, bibliografiaBasica = ?, bibliografiaComplementaria = ? where idProgramaEE = ?;";

         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setString(1, programaExperiencia.getAcademia());
            consultaPreparada.setString(2, programaExperiencia.getPrograma());
            consultaPreparada.setString(3, programaExperiencia.getCampus());
            consultaPreparada.setString(4, programaExperiencia.getDependencia());
            consultaPreparada.setString(5, programaExperiencia.getCodigo());
            consultaPreparada.setString(6, programaExperiencia.getNombreExperiencia());
            consultaPreparada.setString(7, programaExperiencia.getAreaFormacionPrincipal());
            consultaPreparada.setString(8, programaExperiencia.getAreaFormacionSecundaria());
            consultaPreparada.setInt(9, programaExperiencia.getCreditos());
            consultaPreparada.setInt(10, programaExperiencia.getTeoria());
            consultaPreparada.setInt(11, programaExperiencia.getPractica());
            consultaPreparada.setInt(12, programaExperiencia.getTotalHoras());
            consultaPreparada.setString(13, programaExperiencia.getEquivalencias());
            consultaPreparada.setString(14, programaExperiencia.getModalidad());
            consultaPreparada.setString(15, programaExperiencia.getOportunidadesEvaluacion());
            consultaPreparada.setString(16, programaExperiencia.getRequisitos());
            consultaPreparada.setString(17, programaExperiencia.getCoRequisitos());
            consultaPreparada.setString(18, programaExperiencia.getIndividualGrupal());
            consultaPreparada.setInt(19, programaExperiencia.getMaximo());
            consultaPreparada.setInt(20, programaExperiencia.getMinimo());
            consultaPreparada.setString(21, programaExperiencia.getAgrupacion());
            consultaPreparada.setString(22, programaExperiencia.getProyecto());
            consultaPreparada.setString(23, programaExperiencia.getAcademicos());
            consultaPreparada.setString(24, programaExperiencia.getPerfil());
            consultaPreparada.setString(25, programaExperiencia.getEspacio());
            consultaPreparada.setString(26, programaExperiencia.getRelacionDisciplinaria());
            consultaPreparada.setString(27, programaExperiencia.getDescripcion());
            consultaPreparada.setString(28, programaExperiencia.getJustificacion());
            consultaPreparada.setString(29, programaExperiencia.getUnidadCompetencia());
            consultaPreparada.setString(30, programaExperiencia.getArticulacion());
            consultaPreparada.setString(31, programaExperiencia.getTeorico());
            consultaPreparada.setString(32, programaExperiencia.getHeuristico());
            consultaPreparada.setString(33, programaExperiencia.getAxiologicos());
            consultaPreparada.setString(34, programaExperiencia.getEstrategiasAprendizaje());
            consultaPreparada.setString(35, programaExperiencia.getEstrategiasEnsenanza());
            consultaPreparada.setString(36, programaExperiencia.getMaterialesDidacticos());
            consultaPreparada.setString(37, programaExperiencia.getRecursosDidacticos());
            consultaPreparada.setString(38, programaExperiencia.getAcreditacion());
            consultaPreparada.setString(39, programaExperiencia.getBibliografiaBasica());
            consultaPreparada.setString(40, programaExperiencia.getBibliografiaComplementaria());
            consultaPreparada.setInt(41, programaExperiencia.getIdProgramaEE());
            
            
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
    
    public boolean eliminar(int idProgramaEE) {
        int filasModificadas = 0;
        conexion = db.obtenerConexion();
        String consulta = "DELETE FROM programaExperiencia WHERE idProgramaEE = ?;";
        try{            
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, idProgramaEE);
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
    
    public List<ProgramaExperiencia> obtenerTodosProgramasEE() {
        List<ProgramaExperiencia> programasExperiencia = new ArrayList<>();
        conexion = db.obtenerConexion();
        String consulta = "SELECT * FROM programaExperiencia;";
        
        try { 
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            resultados = consultaPreparada.executeQuery(); 
            while (resultados.next()) {
                ProgramaExperiencia programaExperiencia = new ProgramaExperiencia(
                    resultados.getString("academia"),
                    resultados.getString("programa"),
                    resultados.getString("campus"),
                    resultados.getString("dependencia"),
                    resultados.getString("codigo"),
                    resultados.getString("nombreExperiencia"),
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
                    resultados.getString("individualGrupal"),
                    resultados.getInt("maximo"),
                    resultados.getInt("minimo"),
                    resultados.getString("agrupacion"),
                    resultados.getString("proyecto"),
                    resultados.getString("academicos"),
                    resultados.getString("perfil"),
                    resultados.getString("espacio"),
                    resultados.getString("relacionDisciplinaria"),
                    resultados.getString("descripcion"),
                    resultados.getString("justificacion"),
                    resultados.getString("unidadCompetencia"),
                    resultados.getString("articulacion"),
                    resultados.getString("teorico"),
                    resultados.getString("heuristico"),
                    resultados.getString("axiologicos"),
                    resultados.getString("estrategiasAprendizaje"),
                    resultados.getString("estrategiasEnsenanza"),
                    resultados.getString("materialesDidacticos"),
                    resultados.getString("recursosDidacticos"),
                    resultados.getString("acreditacion"),
                    resultados.getString("bibliografiaBasica"),
                    resultados.getString("bibliografiaComplementaria"));
                
                programasExperiencia.add(programaExperiencia);
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
        
        return programasExperiencia;
    }
    
}
