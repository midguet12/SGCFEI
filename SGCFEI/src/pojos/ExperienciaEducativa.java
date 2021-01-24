package pojos;

public class ExperienciaEducativa implements POJO{
    private int nrc;
    private String codigo;
    private String nombre;
    private String areaFormacionPrincipal;
    private String areaFormacionSecundaria;
    private int creditos;
    private int teoria;
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
    

    public ExperienciaEducativa(int nrc, String nombre, int idAcademia) {
        this.nrc = nrc;
        this.nombre = nombre;
        this.idAcademia = idAcademia;
    }

    public ExperienciaEducativa(String nombre, int idAcademia) {
        this.nombre = nombre;
        this.idAcademia = idAcademia;
    }

    public ExperienciaEducativa() {
        
    }

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
