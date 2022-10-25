create database exercicio3
go

use exercicio3
go

-- Criando tabelas

create table peca(
	CodPeca varchar(3) not null,
	NomePeca varchar(9) not null,
	CorPeca varchar(40) not null,
	PesoPeca int not null,
	CidaadePeca varchar(40) not null
);

create table Fornec(
	CodFornec varchar(3) not null,
	NomeFornec varchar(40) not null,
	StatusFornec int not null,
	CidadeFornec varchar(40) not null
);

create table embarq(
	CodPeca varchar(3) not null,
	CodFornec varchar(3) not null,
	QtidEmbarq int not null
);

-- add primary key

alter table peca
	add constraint PK_Peca
		primary key (CodPeca);

alter table fornec
	add constraint PK_Fornec
		primary key (CodFornec);

alter table embarq
	add constraint PK_embarq
		primary key (CodPeca);

-- add FOREIGN KEY key

alter table embarq
	add constraint FK_Peca
		foreign key (CodPeca)
			references peca(CodPeca);

alter table embarq
	add constraint FK_Fornec
		foreign key (CodFornec)
			references fornec(CodFornec);


--

insert into peca (CodPeca,NomePeca,CorPeca,Peso)
