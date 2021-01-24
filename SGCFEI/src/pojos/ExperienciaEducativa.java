package pojos;

public class ExperienciaEducativa implements POJO{
    private int nrc;
    private String codigo;
    private String nombre;
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
    private int idAcademia;
    
    /*
        ncr int not null,
	codigo varchar(20),
	nombre varchar (50) not null,
	areaFormacionPrincipal varchar(255),
	areaFormacionSecundaria varchar(255),
	creditos int,
	teoria int,
	practica int,
	totalHoras int,
	equivalencias varchar(255),
	modalidad varchar(255),
	oportunidadesEvaluacion varchar(255),
	requisitos varchar(255),
	coRequisitos varchar(255),
	academia int not null,
	primary key (ncr)
    */

    public ExperienciaEducativa(int nrc, String codigo, String nombre, String areaFormacionPrincipal, String areaFormacionSecundaria, int creditos, int teoria, int practica, int totalHoras, String equivalencias, String modalidad, String oportunidadesEvaluacion, String requisitos, String coRequisitos, int idAcademia) {
        this.nrc = nrc;
        this.codigo = codigo;
        this.nombre = nombre;
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
        this.idAcademia = idAcademia;
    }

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getIdAcademia() {
        return idAcademia;
    }

    public void setIdAcademia(int idAcademia) {
        this.idAcademia = idAcademia;
    }

   
    
    

    
    @Override
    public String toString() {
        return "ExperienciaEducativa{" + "nrc=" + nrc + ", nombre=" + nombre + ", idAcademia=" + idAcademia + '}';
    }
    
}
