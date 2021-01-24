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
       String consulta = "INSERT INTO experienciaEducativa(idAcademia, idPrograma, idCampus, idDependencia, ncr, individualGrupal, maximo, minimo, proyecto, elaboracion, modificacion, aprobacion, academicos, perfil, espacio, relacionDisciplinaria, descripcion, justificacion, unidadCompetencia, articulacion, saberTeorico, heuristico, axiologicos, estrategiasAprendizaje, estrategiasEnsenanza, materialesDidacticos, recursosDidacticos, acreditacion, bibliografiaBasica, bibliografiaComplementaria) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
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
            consultaPreparada.setString(15, programaExperiencia.getRelacionDisciplinaria());
            consultaPreparada.setString(16, programaExperiencia.getDescripcion());
            consultaPreparada.setString(17, programaExperiencia.getJustificacion());
            consultaPreparada.setString(18, programaExperiencia.getUnidadCompetencia());
            consultaPreparada.setString(19, programaExperiencia.getArticulacion());
            consultaPreparada.setString(20, programaExperiencia.getSaberTeorico());
            consultaPreparada.setString(21, programaExperiencia.getHeuristico());
            consultaPreparada.setString(22, programaExperiencia.getAxiologicos());
            consultaPreparada.setString(23, programaExperiencia.getEstrategiasAprendizaje());
            consultaPreparada.setString(24, programaExperiencia.getEstrategiasEnsenanza());
            consultaPreparada.setString(25, programaExperiencia.getMaterialesDidacticos());
            consultaPreparada.setString(26, programaExperiencia.getMaterialesDidacticos());
            consultaPreparada.setString(27, programaExperiencia.getRecursosDidacticos());
            consultaPreparada.setString(28, programaExperiencia.getAcreditacion());
            consultaPreparada.setString(29, programaExperiencia.getBibliografiaBasica());
            consultaPreparada.setString(30, programaExperiencia.getBibliografiaComplementaria());
            
            
            
            
            
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
        String consulta = "UPDATE programaExperiencia SET codigo = ?, nombre = ?, areaFormacionPrincipal = ?, areaFormacionSecundaria = ?, creditos = ?, teoria = ?, practica = ?, totalHoras = ?, equivalencias = ?, modalidad = ?, oportunidadesEvaluacion = ?, requisitos = ?, coRequisitos = ?, idAcademia = ? where nrc = ?;";
        idAcademia, idPrograma, idCampus, idDependencia, ncr, individualGrupal, maximo, minimo, proyecto, elaboracion, modificacion, aprobacion, academicos, perfil, espacio, relacionDisciplinaria, descripcion, justificacion, unidadCompetencia, articulacion, saberTeorico, heuristico, axiologicos, estrategiasAprendizaje, estrategiasEnsenanza, materialesDidacticos, recursosDidacticos, acreditacion, bibliografiaBasica, bibliografiaComplementaria
        
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
 }
   
   
   
    
    
    
    
    
}
