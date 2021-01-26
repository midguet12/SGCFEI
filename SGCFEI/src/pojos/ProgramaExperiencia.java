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
    private String academia;
    private String programa;
    private String campus;
    private String dependencia;
    private String codigo;
    private String nombreExperiencia;
    private String areaFormacionPrincipal;
    private String areaFormacionSecundaria;
    private int creditos;
    private int teoria;
    private int practica;
    private int totalHoras;
    private String equivalencias;
    private String modalidad;
    private String oportunidadesEvaluacion;
    private String requisitos;
    private String coRequisitos;
    private String individualGrupal;
    
    private int maximo;
    private int minimo;
    
    private String agrupacion;
    private String proyecto;
    private String academicos;
    private String perfil;
    private String espacio;
    private String relacionDisciplinaria;
    private String descripcion;
    private String justificacion;
    
    private String unidadCompetencia;
    private String articulacion;
    private String teorico;
    private String heuristico;
    private String axiologicos;
    private String estrategiasAprendizaje;
    private String estrategiasEnsenanza;
    private String materialesDidacticos;
    private String recursosDidacticos;
    private String acreditacion;
    private String bibliografiaBasica;
    private String bibliografiaComplementaria;

    public ProgramaExperiencia(String academia, String programa, String campus, String dependencia, String codigo, String nombreExperiencia, String areaFormacionPrincipal, String areaFormacionSecundaria, int creditos, int teoria, int practica, int totalHoras, String equivalencias, String modalidad, String oportunidadesEvaluacion, String requisitos, String coRequisitos, String individualGrupal, int maximo, int minimo, String agrupacion, String proyecto, String academicos, String perfil, String espacio, String relacionDisciplinaria, String descripcion, String justificacion, String unidadCompetencia, String articulacion, String teorico, String heuristico, String axiologicos, String estrategiasAprendizaje, String estrategiasEnsenanza, String materialesDidacticos, String recursosDidacticos, String acreditacion, String bibliografiaBasica, String bibliografiaComplementaria) {
        this.academia = academia;
        this.programa = programa;
        this.campus = campus;
        this.dependencia = dependencia;
        this.codigo = codigo;
        this.nombreExperiencia = nombreExperiencia;
        this.areaFormacionPrincipal = areaFormacionPrincipal;
        this.areaFormacionSecundaria = areaFormacionSecundaria;
        this.creditos = creditos;
        this.teoria = teoria;
        this.practica = practica;
        this.totalHoras = totalHoras;
        this.equivalencias = equivalencias;
        this.modalidad = modalidad;
        this.oportunidadesEvaluacion = oportunidadesEvaluacion;
        this.requisitos = requisitos;
        this.coRequisitos = coRequisitos;
        this.individualGrupal = individualGrupal;
        this.maximo = maximo;
        this.minimo = minimo;
        this.agrupacion = agrupacion;
        this.proyecto = proyecto;
        this.academicos = academicos;
        this.perfil = perfil;
        this.espacio = espacio;
        this.relacionDisciplinaria = relacionDisciplinaria;
        this.descripcion = descripcion;
        this.justificacion = justificacion;
        this.unidadCompetencia = unidadCompetencia;
        this.articulacion = articulacion;
        this.teorico = teorico;
        this.heuristico = heuristico;
        this.axiologicos = axiologicos;
        this.estrategiasAprendizaje = estrategiasAprendizaje;
        this.estrategiasEnsenanza = estrategiasEnsenanza;
        this.materialesDidacticos = materialesDidacticos;
        this.recursosDidacticos = recursosDidacticos;
        this.acreditacion = acreditacion;
        this.bibliografiaBasica = bibliografiaBasica;
        this.bibliografiaComplementaria = bibliografiaComplementaria;
    }

    public ProgramaExperiencia(int idProgramaEE, String academia, String programa, String campus, String dependencia, String codigo, String nombreExperiencia, String areaFormacionPrincipal, String areaFormacionSecundaria, int creditos, int teoria, int practica, int totalHoras, String equivalencias, String modalidad, String oportunidadesEvaluacion, String requisitos, String coRequisitos, String individualGrupal, int maximo, int minimo, String agrupacion, String proyecto, String academicos, String perfil, String espacio, String relacionDisciplinaria, String descripcion, String justificacion, String unidadCompetencia, String articulacion, String teorico, String heuristico, String axiologicos, String estrategiasAprendizaje, String estrategiasEnsenanza, String materialesDidacticos, String recursosDidacticos, String acreditacion, String bibliografiaBasica, String bibliografiaComplementaria) {
        this.idProgramaEE = idProgramaEE;
        this.academia = academia;
        this.programa = programa;
        this.campus = campus;
        this.dependencia = dependencia;
        this.codigo = codigo;
        this.nombreExperiencia = nombreExperiencia;
        this.areaFormacionPrincipal = areaFormacionPrincipal;
        this.areaFormacionSecundaria = areaFormacionSecundaria;
        this.creditos = creditos;
        this.teoria = teoria;
        this.practica = practica;
        this.totalHoras = totalHoras;
        this.equivalencias = equivalencias;
        this.modalidad = modalidad;
        this.oportunidadesEvaluacion = oportunidadesEvaluacion;
        this.requisitos = requisitos;
        this.coRequisitos = coRequisitos;
        this.individualGrupal = individualGrupal;
        this.maximo = maximo;
        this.minimo = minimo;
        this.agrupacion = agrupacion;
        this.proyecto = proyecto;
        this.academicos = academicos;
        this.perfil = perfil;
        this.espacio = espacio;
        this.relacionDisciplinaria = relacionDisciplinaria;
        this.descripcion = descripcion;
        this.justificacion = justificacion;
        this.unidadCompetencia = unidadCompetencia;
        this.articulacion = articulacion;
        this.teorico = teorico;
        this.heuristico = heuristico;
        this.axiologicos = axiologicos;
        this.estrategiasAprendizaje = estrategiasAprendizaje;
        this.estrategiasEnsenanza = estrategiasEnsenanza;
        this.materialesDidacticos = materialesDidacticos;
        this.recursosDidacticos = recursosDidacticos;
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

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
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

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreExperiencia() {
        return nombreExperiencia;
    }

    public void setNombreExperiencia(String nombreExperiencia) {
        this.nombreExperiencia = nombreExperiencia;
    }

    public String getAreaFormacionPrincipal() {
        return areaFormacionPrincipal;
    }

    public void setAreaFormacionPrincipal(String areaFormacionPrincipal) {
        this.areaFormacionPrincipal = areaFormacionPrincipal;
    }

    public String getAreaFormacionSecundaria() {
        return areaFormacionSecundaria;
    }

    public void setAreaFormacionSecundaria(String areaFormacionSecundaria) {
        this.areaFormacionSecundaria = areaFormacionSecundaria;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getTeoria() {
        return teoria;
    }

    public void setTeoria(int teoria) {
        this.teoria = teoria;
    }

    public int getPractica() {
        return practica;
    }

    public void setPractica(int practica) {
        this.practica = practica;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }

    public String getEquivalencias() {
        return equivalencias;
    }

    public void setEquivalencias(String equivalencias) {
        this.equivalencias = equivalencias;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getOportunidadesEvaluacion() {
        return oportunidadesEvaluacion;
    }

    public void setOportunidadesEvaluacion(String oportunidadesEvaluacion) {
        this.oportunidadesEvaluacion = oportunidadesEvaluacion;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getCoRequisitos() {
        return coRequisitos;
    }

    public void setCoRequisitos(String coRequisitos) {
        this.coRequisitos = coRequisitos;
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

    public String getAgrupacion() {
        return agrupacion;
    }

    public void setAgrupacion(String agrupacion) {
        this.agrupacion = agrupacion;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
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

    public String getTeorico() {
        return teorico;
    }

    public void setTeorico(String teorico) {
        this.teorico = teorico;
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
