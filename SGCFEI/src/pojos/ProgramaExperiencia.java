/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.sql.Date;

/**
 *
 * @author midgu
 */
public class ProgramaExperiencia {
    private int idProgramaEE;
    private String idAcademia;
    private String programa;
    private String campus;
    private String idDependencia;
    private int ncr;
    private String individualGrupal;
    private int maximo;
    private int minimo;
    private String proyecto;
    private Date elaboracion;
    private Date modificacion;
    private Date aprobacion;
    private String academicos;
    private String perfil;
    private String espacio;
    private String relacionDisciplinaria;
    private String descripcion;
    private String justificacion;
    private String unidadCompetencia;
    private String articulacion;
    private String saberTeorico;
    private String heuristico;
    private String axiologicos;
    private String estrategiasAprendizaje;
    private String estrategiasEnsenanza;
    private String materialesDidacticos;
    private String recursosDidacticos;
    private String evaluacion;
    private String acreditacion;
    private String bibliografiaBasica;
    private String bibliografiaComplementaria;

    public ProgramaExperiencia(String idAcademia, String programa, String campus, String idDependencia, int ncr, String individualGrupal, int maximo, int minimo, String proyecto, String academicos, String perfil, String espacio, String relacionDisciplinaria, String descripcion, String justificacion, String unidadCompetencia, String articulacion, String saberTeorico, String heuristico, String axiologicos, String estrategiasAprendizaje, String estrategiasEnsenanza, String materialesDidacticos, String recursosDidacticos, String evaluacion, String acreditacion, String bibliografiaBasica, String bibliografiaComplementaria) {
        this.idAcademia = idAcademia;
        this.programa = programa;
        this.campus = campus;
        this.idDependencia = idDependencia;
        this.ncr = ncr;
        this.individualGrupal = individualGrupal;
        this.maximo = maximo;
        this.minimo = minimo;
        this.proyecto = proyecto;
        this.academicos = academicos;
        this.perfil = perfil;
        this.espacio = espacio;
        this.relacionDisciplinaria = relacionDisciplinaria;
        this.descripcion = descripcion;
        this.justificacion = justificacion;
        this.unidadCompetencia = unidadCompetencia;
        this.articulacion = articulacion;
        this.saberTeorico = saberTeorico;
        this.heuristico = heuristico;
        this.axiologicos = axiologicos;
        this.estrategiasAprendizaje = estrategiasAprendizaje;
        this.estrategiasEnsenanza = estrategiasEnsenanza;
        this.materialesDidacticos = materialesDidacticos;
        this.recursosDidacticos = recursosDidacticos;
        this.evaluacion = evaluacion;
        this.acreditacion = acreditacion;
        this.bibliografiaBasica = bibliografiaBasica;
        this.bibliografiaComplementaria = bibliografiaComplementaria;
    }

    public ProgramaExperiencia(String idAcademia, String programa, String campus, String idDependencia, int ncr, String individualGrupal, int maximo, int minimo, String proyecto, Date elaboracion, Date modificacion, Date aprobacion, String academicos, String perfil, String espacio, String relacionDisciplinaria, String descripcion, String justificacion, String unidadCompetencia, String articulacion, String saberTeorico, String heuristico, String axiologicos, String estrategiasAprendizaje, String estrategiasEnsenanza, String materialesDidacticos, String recursosDidacticos, String evaluacion, String acreditacion, String bibliografiaBasica, String bibliografiaComplementaria) {
        this.idAcademia = idAcademia;
        this.programa = programa;
        this.campus = campus;
        this.idDependencia = idDependencia;
        this.ncr = ncr;
        this.individualGrupal = individualGrupal;
        this.maximo = maximo;
        this.minimo = minimo;
        this.proyecto = proyecto;
        this.elaboracion = elaboracion;
        this.modificacion = modificacion;
        this.aprobacion = aprobacion;
        this.academicos = academicos;
        this.perfil = perfil;
        this.espacio = espacio;
        this.relacionDisciplinaria = relacionDisciplinaria;
        this.descripcion = descripcion;
        this.justificacion = justificacion;
        this.unidadCompetencia = unidadCompetencia;
        this.articulacion = articulacion;
        this.saberTeorico = saberTeorico;
        this.heuristico = heuristico;
        this.axiologicos = axiologicos;
        this.estrategiasAprendizaje = estrategiasAprendizaje;
        this.estrategiasEnsenanza = estrategiasEnsenanza;
        this.materialesDidacticos = materialesDidacticos;
        this.recursosDidacticos = recursosDidacticos;
        this.evaluacion = evaluacion;
        this.acreditacion = acreditacion;
        this.bibliografiaBasica = bibliografiaBasica;
        this.bibliografiaComplementaria = bibliografiaComplementaria;
    }

    public ProgramaExperiencia(int idProgramaEE, String idAcademia, String programa, String campus, String idDependencia, int ncr, String individualGrupal, int maximo, int minimo, String proyecto, Date elaboracion, Date modificacion, Date aprobacion, String academicos, String perfil, String espacio, String relacionDisciplinaria, String descripcion, String justificacion, String unidadCompetencia, String articulacion, String saberTeorico, String heuristico, String axiologicos, String estrategiasAprendizaje, String estrategiasEnsenanza, String materialesDidacticos, String recursosDidacticos, String evaluacion, String acreditacion, String bibliografiaBasica, String bibliografiaComplementaria) {
        this.idProgramaEE = idProgramaEE;
        this.idAcademia = idAcademia;
        this.programa = programa;
        this.campus = campus;
        this.idDependencia = idDependencia;
        this.ncr = ncr;
        this.individualGrupal = individualGrupal;
        this.maximo = maximo;
        this.minimo = minimo;
        this.proyecto = proyecto;
        this.elaboracion = elaboracion;
        this.modificacion = modificacion;
        this.aprobacion = aprobacion;
        this.academicos = academicos;
        this.perfil = perfil;
        this.espacio = espacio;
        this.relacionDisciplinaria = relacionDisciplinaria;
        this.descripcion = descripcion;
        this.justificacion = justificacion;
        this.unidadCompetencia = unidadCompetencia;
        this.articulacion = articulacion;
        this.saberTeorico = saberTeorico;
        this.heuristico = heuristico;
        this.axiologicos = axiologicos;
        this.estrategiasAprendizaje = estrategiasAprendizaje;
        this.estrategiasEnsenanza = estrategiasEnsenanza;
        this.materialesDidacticos = materialesDidacticos;
        this.recursosDidacticos = recursosDidacticos;
        this.evaluacion = evaluacion;
        this.acreditacion = acreditacion;
        this.bibliografiaBasica = bibliografiaBasica;
        this.bibliografiaComplementaria = bibliografiaComplementaria;
    }
    
    
    

    public int getIdProgramaEE() {
        return idProgramaEE;
    }

    public void setIdProgramaEE(int idProgramaEE) {
        this.idProgramaEE = idProgramaEE;
    }

    public String getIdAcademia() {
        return idAcademia;
    }

    public void setIdAcademia(String idAcademia) {
        this.idAcademia = idAcademia;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(String idDependencia) {
        this.idDependencia = idDependencia;
    }

    public int getNcr() {
        return ncr;
    }

    public void setNcr(int ncr) {
        this.ncr = ncr;
    }

    public String getIndividualGrupal() {
        return individualGrupal;
    }

    public void setIndividualGrupal(String individualGrupal) {
        this.individualGrupal = individualGrupal;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public Date getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(Date elaboracion) {
        this.elaboracion = elaboracion;
    }

    public Date getModificacion() {
        return modificacion;
    }

    public void setModificacion(Date modificacion) {
        this.modificacion = modificacion;
    }

    public Date getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(Date aprobacion) {
        this.aprobacion = aprobacion;
    }

    public String getAcademicos() {
        return academicos;
    }

    public void setAcademicos(String academicos) {
        this.academicos = academicos;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getEspacio() {
        return espacio;
    }

    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    public String getRelacionDisciplinaria() {
        return relacionDisciplinaria;
    }

    public void setRelacionDisciplinaria(String relacionDisciplinaria) {
        this.relacionDisciplinaria = relacionDisciplinaria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getUnidadCompetencia() {
        return unidadCompetencia;
    }

    public void setUnidadCompetencia(String unidadCompetencia) {
        this.unidadCompetencia = unidadCompetencia;
    }

    public String getArticulacion() {
        return articulacion;
    }

    public void setArticulacion(String articulacion) {
        this.articulacion = articulacion;
    }

    public String getSaberTeorico() {
        return saberTeorico;
    }

    public void setSaberTeorico(String saberTeorico) {
        this.saberTeorico = saberTeorico;
    }

    public String getHeuristico() {
        return heuristico;
    }

    public void setHeuristico(String heuristico) {
        this.heuristico = heuristico;
    }

    public String getAxiologicos() {
        return axiologicos;
    }

    public void setAxiologicos(String axiologicos) {
        this.axiologicos = axiologicos;
    }

    public String getEstrategiasAprendizaje() {
        return estrategiasAprendizaje;
    }

    public void setEstrategiasAprendizaje(String estrategiasAprendizaje) {
        this.estrategiasAprendizaje = estrategiasAprendizaje;
    }

    public String getEstrategiasEnsenanza() {
        return estrategiasEnsenanza;
    }

    public void setEstrategiasEnsenanza(String estrategiasEnsenanza) {
        this.estrategiasEnsenanza = estrategiasEnsenanza;
    }

    public String getMaterialesDidacticos() {
        return materialesDidacticos;
    }

    public void setMaterialesDidacticos(String materialesDidacticos) {
        this.materialesDidacticos = materialesDidacticos;
    }

    public String getRecursosDidacticos() {
        return recursosDidacticos;
    }

    public void setRecursosDidacticos(String recursosDidacticos) {
        this.recursosDidacticos = recursosDidacticos;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getAcreditacion() {
        return acreditacion;
    }

    public void setAcreditacion(String acreditacion) {
        this.acreditacion = acreditacion;
    }

    public String getBibliografiaBasica() {
        return bibliografiaBasica;
    }

    public void setBibliografiaBasica(String bibliografiaBasica) {
        this.bibliografiaBasica = bibliografiaBasica;
    }

    public String getBibliografiaComplementaria() {
        return bibliografiaComplementaria;
    }

    public void setBibliografiaComplementaria(String bibliografiaComplementaria) {
        this.bibliografiaComplementaria = bibliografiaComplementaria;
    }


    
    

    
  

    
    

    
}
