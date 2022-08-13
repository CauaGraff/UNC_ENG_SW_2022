create database bd126072022
go
use bd126072022
go


/* criar tabelas */
create table professor (
	id int primary key identity,
	nome varchar(40) not null,
	email varchar(40) )

create table disciplina (
	id int primary key identity,
	descricao varchar(40) not null,
	ch char(3),
	professor_id int not null)

alter table disciplina
	add professor_id int not null



create table academico (
	id int primary key identity,
	nome varchar(40) not null,
	dataNascto smalldatetime);

create table acad_disc (
	academico_id int not null,
	disciplina_id int not null)

--foreign keys
alter table disciplina 
	add constraint fk_prof_disciplina
		foreign key (professor_id)
			references professor(id)

alter table acad_disc
	add constraint fk_academico_disciplina
		foreign key (disciplina_id)
			references disciplina(id)


alter table acad_disc
	add constraint fk_disciplina_academico
		foreign key (academico_id)
			references academico(id)

-- SQL Data Manipulation Language = DML
insert into professor 
( nome, email)
values 
('Moacir','Email')

insert into professor
(nome, email)
values
('Pedro', 'Emailpedro'),
('Antony', 'emailantony')

select * from professor

delete from professor where id=3

update professor set email='sememail'
where id=2
