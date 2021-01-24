create database sgfei;

use sgfei;

create table Documento (
	idDocumento int not null auto_increment,
	nombre varchar(200) not null,
	docente int,
	fechaSubida DateTime not null,
	ruta varchar(200) not null,
	referenciaPlantilla varchar(200) not null,
	primary key (idDocumento)

);

create table Docente (

	nombre varchar(200),
	numeroEmpleado varchar(10),
	primary key(numeroEmpleado)

);

create table Academia (
	idAcademia int not null auto_increment,
	nombre varchar (20) not null,
	coordinador int,
	primary key (idAcademia)

);

create table experienciaEducativa (
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
);

create table programaEducativo(
	idPrograma int auto_increment not null,
	nombre varchar(200) not null,
	primary key(idPrograma)
);

create table campus(
	idCampus int auto_increment not null,
	nombre varchar(255) not null,
	primary key(idCampus)
);

create table dependencia(
	idDependencia int auto_increment not null,
	nombre varchar(255) not null,
	primary key(idDependencia)
);

create table ProgramaExperiencia(
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

);


insert into campus(nombre) values ('Xalapa');

insert into dependencia(nombre) values ('Facultad de estadistica e informatica');

insert into programaEducativo(nombre) values ('Licenciatura en Ingenieria de software');