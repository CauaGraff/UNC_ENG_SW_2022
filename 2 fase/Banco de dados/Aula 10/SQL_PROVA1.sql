create database exercprova1

use exercprova1

create table vendedor (
	id smallint not null,
	nome varchar(40))

create table estoque (
	id int not null,
	descricao varchar(40) not null,
	unidade char(3),
	preco decimal(18,2))

create table vendas (
	id bigint not null,
	dt_venda date,
	horario time,
	comissao numeric(4,2),
	vendedor_id smallint not null)

create table vendas_estoque (
	id bigint not null,
	venda_id bigint not null,
	estoque_id int not null,
	qtd numeric(18,2),
	preco numeric(18,2))

-- primary keys
alter table vendedor 
	add constraint pk_vendedor
		primary key (id)

alter table vendas
	add constraint pk_venda
		primary key (id)

alter table estoque
	add constraint pk_estoque
		primary key (id)

alter table vendas_estoque
	add constraint pk_vendas_estoque
		primary key (id)

--foreign key
alter table vendas
	add constraint fk_vendas_vendedor
		foreign key (vendedor_id)
			references vendedor (id)

alter table vendas_estoque
	add constraint fk_vendas_estoque_venda
		foreign key (venda_id)
			references vendas(id)

alter table vendas_estoque
	add constraint fk_vendas_estoque_estoque
		foreign key (estoque_id)
			references estoque(id)


--eliminar constraint
alter table vendas_estoque
	drop constraint fk_vendas_estoque_estoque

--inserir registros
INSERT INTO VENDEDOR (ID, NOME)
VALUES 
(1,'MOACIR')

SELECT * FROM VENDEDOR

--ALTERAR DADOS
UPDATE VENDEDOR 
	SET NOME='MOACIR KICHEL'
		WHERE ID=1

DELETE FROM VENDEDOR 
	WHERE ID=1

--OUTRA FORMA DE INSERT
INSERT INTO VENDEDOR
VALUES 
(1,'MOACIR'),
(2,'BRUNO'),
(3,'BEL'),
(4,'PAJÉ')

INSERT INTO VENDEDOR (NOME, ID)
VALUES
('CARLOS', 24)

SELECT * FROM VENDAS

SET DATEFORMAT DMY

INSERT INTO VENDAS 
(ID, DT_VENDA, HORARIO, COMISSAO, VENDEDOR_ID)
VALUES
(1,'15.10.2021','21:56',3,24)

INSERT INTO VENDAS 
(ID, DT_VENDA, HORARIO, COMISSAO, VENDEDOR_ID)
VALUES
(2,'15.10.2021','21:57',5,3)

SELECT 
	VE.id, VE.dt_venda, VE.ID, VV.NOME
FROM VENDAS VE
INNER JOIN VENDEDOR VV
ON VE.vendedor_id = VV.ID

SELECT * FROM ESTOQUE

INSERT INTO ESTOQUE (ID,DESCRICAO,UNIDADE,PRECO)
VALUES
(1, 'FEIJAO', 'KG', 5.55),
(2, 'ARROZ', 'KG', 4.30),
(3, 'OVO', 'DZ', 10.99)


SELECT * FROM VENDAS_ESTOQUE

INSERT INTO VENDAS_ESTOQUE
(ID, VENDA_ID, ESTOQUE_ID, QTD, PRECO)
VALUES
(1, 1, 3, 3,6.66),
(2, 2, 1, 2, 7.44),
(3, 2, 2, 4, 4.32)

SELECT * FROM VENDAS_ESTOQUE

SELECT 
	VV.ID,
	ES.DESCRICAO,
	VE.qtd,
	(VE.QTD*VE.preco) AS TOTAL_VENDA,
	(VE.QTD*VE.preco)*(VV.COMISSAO/100)  AS COMISSAO
FROM VENDAS VV
INNER JOIN VENDAS_ESTOQUE VE
ON VV.id = VE.venda_id
INNER JOIN ESTOQUE ES
ON VE.estoque_id = ES.id