create database prova2BDI
go

use prova2BDI
go

create table Grupo (
	IDGrupo smallint not null,
	DescGrupo varchar(40) not null,
);

create table Subgrupo(
	IDSub bigint not null,
	DescSub varchar(40),
	IDGrupo int not null
);

create table Contas (
	IDConta int not null,
	DescConta varchar(40),
	Tipo char(1),
	IDsub bigint not null
);

create table Orcamento(
	Mes_ano date not null,
	IDConta int not null,
	Valor decimal(10,2)
);

create table Realizado(
	IDRealizado int not null,
	[Data] date,
	Valor decimal(10,2),
	Observacao varchar(40),
	IDConta int not null
);

alter table Grupo 
	add constraint pk_grupo
		primary key (IDGrupo);

alter table Subgrupo
	add constraint pk_subgrupo
		primary key (IDSub);

alter table Contas
	add constraint pk_conta
		primary key (IDConta);

ALTER TABLE Orcamento
	ADD CONSTRAINT pk_orcamento
		PRIMARY KEY (Mes_ano, IDConta)

alter table Realizado
	add constraint pk_realizado
		primary key (IDRealizado);

alter table Subgrupo
	add constraint fk_subgrupo_grupo
		foreign key (IDGrupo)
			references Grupo (IDGrupo);

alter table Contas
	add constraint fk_contas_subgrupo
		foreign key (IDSub)
			references Subgrupo (IDSub);

alter table Orcamento
	add constraint fk_orcamento_conta
		foreign key (IDConta)
			references Contas (IDConta);

alter table Realizado
	add constraint fk_realizado_conta
		foreign key (IDConta)
			references Contas (IDConta);

INSERT INTO Grupo (IDGrupo, DescGrupo) VALUES (1,'Receitas');
INSERT INTO Grupo (IDGrupo, DescGrupo) VALUES (2,'Despesas');
INSERT INTO Grupo (IDGrupo, DescGrupo) VALUES (3,'Bancos');


delete from Grupo where DescGrupo = 'Bancos';

update Orcamento set Valor = '100'
	where MONTH(Mes_ano) = '06'
	and YEAR(Mes_ano) = '2017'
	and IDConta = '2';


select s.* 
	from Subgrupo s, Grupo g
		where 
		s.IDGrupo =g.IDGrupo
	
select
	g.DescGrupo, 
	count(s.IDSub) as totalsubgrupo
	from Grupo g, Subgrupo s
	where s.IDGrupo = g.IDGrupo
		group by g.DescGrupo;
		

select o.IDConta, o.Mes_ano, o.Valor
	from Orcamento o
		where o.IDConta = '1'
		and DATEPART(MONTH, o.Mes_ano) = '01'
		and DATEPART(YEAR, o.Mes_ano) = '2022'
		order by o.Valor asc;

select
	c.DescConta,
	sum(r.Valor)
	from Contas c, Realizado r
	where c.IDConta = r.IDConta
	and c.Tipo = '1'
	group by c.DescConta

	select
	o.IDConta,
	o.Valor
	from Contas c, Orcamento o
	where c.IDConta = o.IDConta
		and o.valor >= '2500'
		and DATEPART(MONTH, o.Mes_ano) in ('01','02','03')
		and DATEPART(YEAR, o.Mes_ano) = '2022'
				order by o.valor desc;

	select count(c.IDsub),c.DescConta  
	from Contas c 
	where c.Tipo = '0'
	group by c.DescConta;

	select max(r.Valor), min(r.Valor), r.IDConta
		from Realizado r
			group by r.IDConta;

select r.* 
	from Realizado r
	where r.Valor<400;

	SELECT AVG(r.Valor) 
		FROM Realizado r
		 where DATEPART(YEAR, r.[Data]) = '2022';
		
		alter table Grupo add Tipo char(1);

alter table Realizado drop column Observacao;
alter table Realizado drop constraint fk_realizado_conta
