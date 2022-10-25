create database exerciciosql_3

use exerciciosql_3

/* criar tabelas */
create table peca(
    codpeca char(3) not null,
    nomepeca varchar(30),
    corpeca varchar(20),
    pesopeca numeric(6,2),
    cidadepeca varchar(30));

create table fornec(
    codfornec char(3) not null,
    nomefornec varchar(30),
    statusfornec smallint,
    cidadefornec varchar(30));

create table embarq(
    codpeca char(3) not null,
    codfornec char(3) not null,
    qtdembarq integer not null);

/*chaves primarias*/
alter table peca add constraint
pk_peca primary key(codpeca);

alter table fornec add constraint
pk_fornec primary key (codfornec);

/*chaves estrangeiras */
alter table embarq add constraint
fk_fornec_embarq foreign key (codfornec)
    references fornec(codfornec);

alter table embarq add constraint
fk_peca_embarq foreign key (codpeca)
    references peca(codpeca);

set dateformat dmy

/* inserir os dados */
insert into peca (codpeca, nomepeca, corpeca, pesopeca, cidadepeca)
values
('P1','EIXO','CINZA',10,'PORTO ALEGRE');

insert into peca (codpeca, nomepeca, corpeca, pesopeca, cidadepeca)
values
('P2','ROLAMENTO','PRETO',16,'SANTA MARIA'),
('P3','MANCAL','VERDE',30,'URUGUAIANA');

INSERT INTO FORNEC (CODFORNEC, NOMEFORNEC, STATUSFORNEC, CIDADEFORNEC)
VALUES
('F1','SILVA',5,'SAO PAULO');

INSERT INTO FORNEC (CODFORNEC, NOMEFORNEC, STATUSFORNEC, CIDADEFORNEC)
VALUES
('F2','SOUZA',10,'RIO DE JANEIRO');

INSERT INTO FORNEC (CODFORNEC, NOMEFORNEC, STATUSFORNEC, CIDADEFORNEC)
VALUES
('F3','ALVARES',5,'SAO PAULO');

INSERT INTO FORNEC (CODFORNEC, NOMEFORNEC, STATUSFORNEC, CIDADEFORNEC)
VALUES
('F4','TAVARES',8,'RIO DE JANEIRO');

INSERT INTO EMBARQ
VALUES
('P1','F1',300);

INSERT INTO EMBARQ
VALUES
('P1','F2',400);

INSERT INTO EMBARQ
VALUES
('P1','F3',200);

INSERT INTO EMBARQ
VALUES
('P2','F1',300);

INSERT INTO EMBARQ
VALUES
('P2','F4',350);

-- 1) Crie as seguintes consultas:
/*a) Listar os fornecedores e pecas
Embarcadas;*/

SELECT ---prdduto cartesiano
    F.nomefornec,
    P.nomepeca
    FROM EMBARQ E, FORNEC F, PECA P
        WHERE E.codfornec = F.codfornec
        AND E.codpeca = P.codpeca
--USANDO JOIN
SELECT
    F.nomefornec,
    P.nomepeca
    FROM EMBARQ E
	inner JOIN FORNEC F
	ON E.codfornec = F.codfornec
	INNER JOIN PECA P
    ON E.codpeca = P.codpeca

--b) Pecas embarcadas do fornecedor F2;

SELECT
    E.codpeca, P.nomepeca
    FROM EMBARQ E, PECA P
        WHERE E.codfornec = 'F2'
        AND E.codpeca = P.codpeca


        
SELECT
    E.codpeca, P.nomepeca
    FROM (SELECT CODPECA, CODFORNEC FROM EMBARQ
	WHERE codfornec = 'F2' ) E 
	INNER JOIN PECA P
	ON E.codpeca = P.codpeca
        
SELECT
    E.codpeca, P.nomepeca
    FROM EMBARQ E 
	INNER JOIN PECA P
	ON E.codpeca = P.codpeca
	WHERE codfornec = 'F2'


--c) Dados dos fornecedores de Sao Paulo;

SELECT F.*
    FROM (SELECT * FROM FORNEC) F
        WHERE F.cidadefornec = 'SAO PAULO';

SELECT F.*
    FROM (SELECT * FROM FORNEC 
        WHERE cidadefornec = 'SAO PAULO') F;

SELECT * FROM FORNEC 
        WHERE cidadefornec = 'SAO PAULO'

--d) Numero de embarques (contagem);
--funcao de agregacao - avg (media), sum (soma), count (contagem), min (minimo), max (maximo)
SELECT
    COUNT(*)
    FROM EMBARQ E


--e) Peca que nao teve embarque;

SELECT
  PEC.nomepeca
FROM PECA PEC
where PEC.codpeca
NOT IN -- not exists
(SELECT
    E.codpeca
    FROM EMBARQ E)

-- f) Media de quantidade embarcada;
SELECT
     AVG(E.qtdembarq)
    FROM EMBARQ E

-- usar os embarques abaixo da media
SELECT
  E.*
FROM PECA P, EMBARQ E
WHERE P.codpeca = E.codpeca
and e.qtdembarq < (SELECT
     AVG(E.qtdembarq)
    FROM EMBARQ E)

-- g) Total de quantidade embarcada
SELECT
     sum(E.qtdembarq)
    FROM EMBARQ E
	


/*2) Crie um script que permita adicionar
 o campo FoneFornec na tabela
 Fornecedores e eliminar o
 campo CorPeca da tabela Peca */

 select * from fornec

alter table Fornec add FoneFornec varchar(20);


select * from peca
alter table Peca drop column CorPeca;

sql ddl = data definition language (criar os dados dos dados = metadados)
sql dml = data manipulation language (editar os dados)
--3) Crie um script que permita totalizar
-- a quantidade de pecas embarcadas
--(por codigo de peca)

select  sum(e.qtdembarq) as total,
		p.nomepeca as nome
    from embarq e, peca p
		where e.codpeca = p.codpeca
        group by p.nomepeca

--4) Crie um script que permite
--acrescentar 10% na quantidade total de
--pecas

select sum(e.qtdembarq)
    from embarq e

update embarq 
set qtdembarq = qtdembarq * 1.10


/*5) Crie um script que elimine o
registro de embarque da peca 'P2' do
Fornecedor 'F4'
(ultimo registro de embarque) */

delete from embarq
    where codpeca = 'P2'
    and codfornec = 'F4'

/*6) Crie um script que permita a geracao
 de uma view, com o peso total que poder�
 ser embarcado */

create view q_6
(total_embarq)
as
select
     sum(e.qtdembarq * p.pesopeca)
    from embarq e, peca p
        where e.codpeca = p.codpeca

select * from q_6



 /* 7) Elimine a constraint que liga o CodPeca de Embarq 
 com o campo CodPeca de Pe�a */

 alter table embarq 
 drop constraint fk_peca_embarq

/* 8) elimine o campo CodPe�a de Embarq */

alter table embarq drop column codpeca

/* 9) Execute as a��es necess�rias (sql ddl) 
para eliminar a tabela Embarq */
 alter table embarq 
 drop constraint fk_fornec_embarq

 drop table embarq

 -- ALTERAR INSERIR NOT NULL PARA CORPECA
 ALTER TABLE peca
 ALTER COLUMN corpeca INT NOT NULL
 
 -- INSERIR O CAMPO CORPECA COM NOT NULL
  ALTER TABLE peca
  ADD corpeca INT NOT NULL