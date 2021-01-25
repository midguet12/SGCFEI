/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author midgu
 */
public class ProgramaExperienciaDAO implements DAO{
   private ConexionDB db;
   private Connection conexion;
   private ResultSet resultados;
   /*
        idProgramaEE int not null auto_increment,
	idAcademia int not null,
	idPrograma int not null,
	idCampus int not null,
	idDependencia int not null,
	ncr int not null,
	individualGrupal varchar(20),
	maximo int,
	minimo int,
	agrupacion varchar(255),
	proyecto varchar(255),
	elaboracion date,
	modificacion date,
	aprobacion date,
	academicos varchar(255),
	perfil varchar(255),
	espacio varchar(30),
	relacionDisciplinaria varchar(30),
	descripcion varchar(255),
	justificacion varchar(255),
	unidadCompetencia varchar(255),
	articulacion varchar(255),
	saberTeorico varchar(255),
	heuristico varchar(255),
	axiologicos varchar(255),
	estrategiasAprendizaje varchar(255),
	estrategiasEnsenanza varchar(255),
	materialesDidacticos varchar(255),
	recursosDidacticos varchar(255),
	acreditacion varchar(255),
	bibliografiaBasica varchar(255),
	bibliografiaComplementaria varchar(255),
	primary key(idProgramaEE)
   */
   
   public ProgramaExperienciaDAO(){
       db = new ConexionDB();
       
   }
   
   public boolean insertar(ProgramaExperiencia programaExperiencia){
       int filasModificadas = 0;
       conexion = db.obtenerConexion();
       String consulta = "INSERT INTO experienciaEducativa(idAcademia, idPrograma, idCampus, idDependencia, ncr, individualGrupal, maximo, minimo, proyecto, elaboracion, modificacion, aprobacion, academicos, perfil, espacio, relacionDisciplinaria, descripcion, justificacion, unidadCompetencia, articulacion, saberTeorico, heuristico, axiologicos, estrategiasAprendizaje, estrategiasEnsenanza, materialesDidacticos, recursosDidacticos, evaluacion, acreditacion, bibliografiaBasica, bibliografiaComplementaria) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
       try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, programaExperiencia.getIdAcademia());
            consultaPreparada.setInt(2, programaExperiencia.getPrograma());
            consultaPreparada.setInt(3, programaExperiencia.getCampus());
            consultaPreparada.setInt(4, programaExperiencia.getIdDependencia());
            consultaPreparada.setInt(5, programaExperiencia.getNcr());
            consultaPreparada.setString(6, programaExperiencia.getIndividualGrupal());
            consultaPreparada.setInt(7, programaExperiencia.getMaximo());
            consultaPreparada.setInt(8, programaExperiencia.getMinimo());
            consultaPreparada.setString(9, programaExperiencia.getProyecto());
            consultaPreparada.setDate(10, programaExperiencia.getElaboracion());
            consultaPreparada.setDate(11, programaExperiencia.getModificacion());
            consultaPreparada.setDate(12, programaExperiencia.getAprobacion());
            consultaPreparada.setString(13, programaExperiencia.getAcademicos());
            consultaPreparada.setString(14, programaExperiencia.getPerfil());
            consultaPreparada.setString(15, programaExperiencia.getEspacio());
            consultaPreparada.setString(16, programaExperiencia.getRelacionDisciplinaria());
            consultaPreparada.setString(17, programaExperiencia.getDescripcion());
            consultaPreparada.setString(18, programaExperiencia.getJustificacion());
            consultaPreparada.setString(19, programaExperiencia.getUnidadCompetencia());
            consultaPreparada.setString(20, programaExperiencia.getArticulacion());
            consultaPreparada.setString(21, programaExperiencia.getSaberTeorico());
            consultaPreparada.setString(22, programaExperiencia.getHeuristico());
            consultaPreparada.setString(23, programaExperiencia.getAxiologicos());
            consultaPreparada.setString(24, programaExperiencia.getEstrategiasAprendizaje());
            consultaPreparada.setString(25, programaExperiencia.getEstrategiasEnsenanza());
            consultaPreparada.setString(26, programaExperiencia.getMaterialesDidacticos());
            consultaPreparada.setString(27, programaExperiencia.getRecursosDidacticos());
            consultaPreparada.setString(28, programaExperiencia.getEvaluacion());
            consultaPreparada.setString(29, programaExperiencia.getAcreditacion());
            consultaPreparada.setString(30, programaExperiencia.getBibliografiaBasica());
            consultaPreparada.setString(31, programaExperiencia.getBibliografiaComplementaria());
            
            
            
            
            
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
                    resultados.getInt("idProgramaEE"),
                    resultados.getInt("idAcademia"),
                    resultados.getInt("idPrograma"),
                    resultados.getInt("idCampus"),
                    resultados.getInt("idDependencia"),
                    resultados.getInt("ncr"),
                    resultados.getString("individualGrupal"),
                    resultados.getInt("maximo"),
                    resultados.getInt("minimo"),
                    resultados.getString("proyecto"),
                    resultados.getDate("elaboracion"),
                    resultados.getDate("modificacion"),
                    resultados.getDate("aprobacion"),
                    resultados.getString("academicos"),
                    resultados.getString("perfil"),
                    resultados.getString("espacio"),
                    resultados.getString("relacionDisciplinaria"),
                    resultados.getString("descripcion"),
                    resultados.getString("justificacion"),
                    resultados.getString("unidadCompetencia"),
                    resultados.getString("articulacion"),
                    resultados.getString("saberTeorico"),
                    resultados.getString("heuristico"),
                    resultados.getString("axiologicos"),
                    resultados.getString("estrategiasAprendizaje"),
                    resultados.getString("estrategiasEnsenanza"),
                    resultados.getString("materialesDidacticos"),
                    resultados.getString("recursosDidacticos"),
                    resultados.getString("evaluacion"),
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
        String consulta = "UPDATE programaExperiencia SET idAcademia = ?, idPrograma = ?, idCampus = ?, idDependencia = ?, ncr = ?, individualGrupal = ?, maximo = ?, minimo = ?, proyecto = ?, elaboracion = ?, modificacion = ?, aprobacion = ?, academicos = ?, perfil = ?, espacio = ?, relacionDisciplinaria = ?, descripcion = ?, justificacion = ?, unidadCompetencia = ?, articulacion = ?, saberTeorico = ?, heuristico = ?, axiologicos = ?, estrategiasAprendizaje = ?, estrategiasEnsenanza = ?, materialesDidacticos = ?, recursosDidacticos = ?, acreditacion = ?, bibliografiaBasica = ?, bibliografiaComplementaria = ? where idProgramaEE = ?;";
        
        
         try{
            PreparedStatement consultaPreparada = conexion.prepareStatement(consulta);
            consultaPreparada.setInt(1, programaExperiencia.getIdAcademia());
            consultaPreparada.setInt(2, programaExperiencia.getPrograma());
            consultaPreparada.setInt(3, programaExperiencia.getCampus());
            consultaPreparada.setInt(4, programaExperiencia.getIdDependencia());
            consultaPreparada.setInt(5, programaExperiencia.getNcr());
            consultaPreparada.setString(6, programaExperiencia.getIndividualGrupal());
            consultaPreparada.setInt(7, programaExperiencia.getMaximo());
            consultaPreparada.setInt(8, programaExperiencia.getMinimo());
            consultaPreparada.setString(9, programaExperiencia.getProyecto());
            consultaPreparada.setDate(10, programaExperiencia.getElaboracion());
            consultaPreparada.setDate(11, programaExperiencia.getModificacion());
            consultaPreparada.setDate(12, programaExperiencia.getAprobacion());
            consultaPreparada.setString(13, programaExperiencia.getAcademicos());
            consultaPreparada.setString(14, programaExperiencia.getPerfil());
            consultaPreparada.setString(15, programaExperiencia.getEspacio());
            consultaPreparada.setString(16, programaExperiencia.getRelacionDisciplinaria());
            consultaPreparada.setString(17, programaExperiencia.getDescripcion());
            consultaPreparada.setString(18, programaExperiencia.getJustificacion());
            consultaPreparada.setString(19, programaExperiencia.getUnidadCompetencia());
            consultaPreparada.setString(20, programaExperiencia.getArticulacion());
            consultaPreparada.setString(21, programaExperiencia.getSaberTeorico());
            consultaPreparada.setString(22, programaExperiencia.getHeuristico());
            consultaPreparada.setString(23, programaExperiencia.getAxiologicos());
            consultaPreparada.setString(24, programaExperiencia.getEstrategiasAprendizaje());
            consultaPreparada.setString(25, programaExperiencia.getEstrategiasEnsenanza());
            consultaPreparada.setString(26, programaExperiencia.getMaterialesDidacticos());
            consultaPreparada.setString(27, programaExperiencia.getRecursosDidacticos());
            consultaPreparada.setString(28, programaExperiencia.getEvaluacion());
            consultaPreparada.setString(29, programaExperiencia.getAcreditacion());
            consultaPreparada.setString(30, programaExperiencia.getBibliografiaBasica());
            consultaPreparada.setString(31, programaExperiencia.getBibliografiaComplementaria());
            consultaPreparada.setInt(32, programaExperiencia.getIdProgramaEE());
            
            
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
                    resultados.getInt("idProgramaEE"),
                    resultados.getInt("idAcademia"),
                    resultados.getInt("idPrograma"),
                    resultados.getInt("idCampus"),
                    resultados.getInt("idDependencia"),
                    resultados.getInt("ncr"),
                    resultados.getString("individualGrupal"),
                    resultados.getInt("maximo"),
                    resultados.getInt("minimo"),
                    resultados.getString("proyecto"),
                    resultados.getDate("elaboracion"),
                    resultados.getDate("modificacion"),
                    resultados.getDate("aprobacion"),
                    resultados.getString("academicos"),
                    resultados.getString("perfil"),
                    resultados.getString("espacio"),
                    resultados.getString("relacionDisciplinaria"),
                    resultados.getString("descripcion"),
                    resultados.getString("justificacion"),
                    resultados.getString("unidadCompetencia"),
                    resultados.getString("articulacion"),
                    resultados.getString("saberTeorico"),
                    resultados.getString("heuristico"),
                    resultados.getString("axiologicos"),
                    resultados.getString("estrategiasAprendizaje"),
                    resultados.getString("estrategiasEnsenanza"),
                    resultados.getString("materialesDidacticos"),
                    resultados.getString("recursosDidacticos"),
                    resultados.getString("evaluacion"),
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
