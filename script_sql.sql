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
	nrc int not null,
	nombre varchar (50) not null,
	idAcademia int not null,
	primary key (nrc)
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

create table programaExperiencia(
	idProgramaEE int not null auto_increment,
	academia varchar(255) not null,
	programa varchar(255) not null,
	campus varchar(255) not null,
	dependencia varchar(255) not null,
	codigo varchar(255) not null,
	nombreExperiencia varchar(255) not null,
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
	individualGrupal varchar(20),
	maximo int,
	minimo int,
	agrupacion varchar(255),
	proyecto varchar(255),
	academicos varchar(255),
	perfil varchar(255),
	espacio varchar(30),
	relacionDisciplinaria varchar(30),
	descripcion varchar(255),
	justificacion varchar(255),
	unidadCompetencia varchar(255),
	articulacion varchar(255),
	teorico varchar(255),
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


create table evaluacion(
	idProgramaEE int not null,
	evidencia varchar(255),
	criterio varchar(255),
	ambito varchar(255),
	porcentaje int
);


insert into campus(nombre) values ('Xalapa');
insert into dependencia(nombre) values ('Facultad de estadistica e informatica');

insert into programaEducativo(nombre) values ('Licenciatura en Ingenieria de software');
insert into experienciaEducativa(nrc, nombre, idAcademia) values (18015,"Principios de diseño",9);
insert into experienciaEducativa values (18012, "Principios de diseño", 9);

insert into programaExperiencia(academia, programa, campus, dependencia, codigo, nombreExperiencia, areaFormacionPrincipal, areaFormacionSecundaria, creditos, teoria, practica, totalHoras, equivalencias, modalidad, oportunidadesEvaluacion, requisitos, coRequisitos, individualGrupal, maximo, minimo, agrupacion, proyecto, academicos, perfil, espacio, relacionDisciplinaria, descripcion, justificacion, unidadCompetencia, articulacion, teorico, heuristico, axiologicos, estrategiasAprendizaje, estrategiasEnsenanza, materialesDidacticos, recursosDidacticos, acreditacion, bibliografiaBasica, bibliografiaComplementaria) 
	values("1", "2", "3", "4", "5", "6", "7", "8", "9", 
		1, 2, 3, 4, "1", "2", "3", "4", "5", "6", 1, 2, 
		"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
		"11", "12", "13", "14", "15", "16", "17", "18", "19", "20");



insert into programaExperiencia values("1", "2", "3", "4", "5", "6", "7", "8", "9", 1, 2, 3, 4, "1", "2", "3", "4", "5", "6", 1, 2, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20");

insert into programaExperiencia values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);

update programaExperiencia set academia = ?, programa = ?, campus = ?, dependencia = ?, codigo = ?, nombreExperiencia = ?, areaFormacionPrincipal = ?, areaFormacionSecundaria = ?, creditos = ?, teoria = ?, practica = ?, totalHoras = ?, equivalencias = ?, modalidad = ?, oportunidadesEvaluacion = ?, requisitos = ?, coRequisitos = ?, individualGrupal = ?, maximo = ?, minimo = ?, agrupacion = ?, proyecto = ?, academicos = ?, perfil = ?, espacio = ?, relacionDisciplinaria = ?, descripcion = ?, justificacion = ?, unidadCompetencia = ?, articulacion = ?, teorico = ?, heuristico = ?, axiologicos = ?, estrategiasAprendizaje = ?, estrategiasEnsenanza = ?, materialesDidacticos = ?, recursosDidacticos = ?, acreditacion = ?, bibliografiaBasica = ?, bibliografiaComplementaria = ? where idProgramaEE = ?;
	admin@gmail.com : 83f397d8182d673a592971579c52ccd9 <- ADMIN
luis@gmail.com - 117b3b0be29d8f40fd282711710bba50 <- DIRECTOR
midguet@gmail.com - 53c0322b589bf54da7d035fa952ef7c6 <- COORDINADOR
seth@gmail.com - 14a69fb91e7bedf52af383fbdba95474 <- DOCENTE