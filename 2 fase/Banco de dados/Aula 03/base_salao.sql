create database salao
go
use salao
go

--SQL/DDL - Estrutura da Base de Dados
--D ata D efinition L anguage

create table atendimento (
	id int not null,
	dt_atend date default getdate(),
	hora time,
	observacao varchar(100),
	cliente_id int not null)

create table cliente (
	id int not null,
	nome varchar(40) not null,
	fone varchar(15),
	email varchar(40))

create table atendente (
	id int not null,
	nome varchar(40) not null)

create table servico (
	id int not null,
	descricao varchar(40),
	preco numeric(18,2))

create table material (
	id int not null,
	descricao varchar(40),
	unidade char(3),
	preco numeric(18,2))
	
create table atendente_atendimento (
	id int identity not null,
	atendente_id int not null,
	atendimento_id int not null)

create table servico_atendimento (
	id int identity not null,
	preco numeric(18,2),
	servico_id int not null,
	atendimento_id int not null)

create table material_atendimento (
	id int identity not null,
	prc_unitario numeric(18,2),
	quantidade numeric(5,2),
	atendimento_id int not null,
	material_id int not null)

--drop table material_atendimento exemplo excluir tabela

--criar chaves primarias
alter table atendimento 
	add constraint pk_atendimento
	primary key(id) 

alter table cliente
	add constraint pk_cliente
	primary key(id) 

alter table atendente
	add constraint pk_atendente
	primary key(id)
	
alter table material
	add constraint pk_material
	primary key(id) 

 alter table servico
	add constraint pk_servico
	primary key(id) 

alter table atendente_atendimento
	add constraint pk_atendente_atendimento
	primary key(id) 

alter table servico_atendimento
	add constraint pk_servico_atendimento
	primary key(id) 

alter table material_atendimento
	add constraint pk_material_atendimento
		primary key(id) 

--criar chaves estrangeiras
alter table atendimento
	add constraint fk_cliente_atendimento
		foreign key(cliente_id)
			references cliente(id)

alter table atendente_atendimento
	add constraint fk_atendente_atendimento
		foreign key(atendente_id)
			references atendente(id)

alter table atendente_atendimento
	add constraint fk_atendimento_atendente
		foreign key(atendimento_id)
			references atendimento(id)
	
alter table servico_atendimento
	add constraint fk_servico_atendimento
		foreign key(servico_id)
			references servico(id)
	
alter table servico_atendimento
	add constraint fk_atendimento_servico
		foreign key(atendimento_id)
			references atendimento(id)	

alter table material_atendimento
	add constraint fk_material_atendimento
		foreign key(material_id)
			references material(id)
	
alter table material_atendimento
	add constraint fk_atendimento_material
		foreign key(atendimento_id)
			references atendimento(id)	


