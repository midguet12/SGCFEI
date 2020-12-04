create database sgfei;

use sgfei;

create table Documento (
	idDocumento int not null auto_increment,
	nombre varchar(200) not null,
	docente int,
	fechaSubida DateTime not null,
	ruta varchar(200) not null,
	referenciaPlantilla varchar(200) not null,
	primary key (idDocumento),

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

create table ExperienciaEducativa (
	ncr int not null,
	nombre varchar (50) not null,
	academia int not null,
	primary key (ncr)
);

