create database listao_complementar

use listao_complementar

/*criar estrutura das tabelas */
create table cliente (
    cod_cliente integer not null,
    nome_cliente varchar(40) not null,
    endereco varchar(40),
    cidade varchar(40),
    cep varchar(9),
    uf char(2),
    cgc char(18),
    ie char(11));

create table pedido (
    num_pedido integer not null,
    cod_cliente integer not null,
    prazo_entrega date not null,
    cod_vendedor integer not null);

create table produto (
    cod_produto integer not null,
    descricao varchar(40),
    unidade char(3),
    vlr_unitario numeric(18,2));

create table item_pedido (
    num_pedido integer not null,
    cod_produto integer not null,
    quantidade numeric(10,2));

create table vendedor (
    cod_vendedor integer not null, 
    nome_vendedor varchar(40),
    faixa_comissao char(1),
    salario_fixo numeric(18,2));

/* criar chaves prim�rias */
alter table cliente add constraint PK_CLIENTE
primary key(cod_cliente);
alter table pedido add constraint PK_PEDIDO
primary key(num_pedido);
alter table produto add constraint PK_PRODUTO
primary key(cod_produto);
alter table item_pedido add constraint PK_ITEMPED
primary key(num_pedido,cod_produto);
alter table vendedor add constraint PK_VENDEDOR
primary key(cod_vendedor);

/* criar chaves estrangeiras */
alter table pedido add constraint
FK_PEDIDO_VENDEDOR foreign key(cod_vendedor)
references vendedor(cod_vendedor);

alter table pedido add constraint
FK_PEDIDO_CLIENTE foreign key(cod_cliente)
references cliente(cod_cliente);

alter table item_pedido add constraint
FK_ITEMPED_NUMPEDIDO foreign key(num_pedido)
references pedido(num_pedido);

alter table item_pedido add constraint
FK_ITEMPED_PRODUTO foreign key(cod_produto)
references produto(cod_produto);

/* se��o 1 */
-- Q1
select
    pe.num_pedido,
    pe.prazo_entrega
        from pedido pe;

-- Q2
select
    pr.descricao,
    pr.vlr_unitario
        from produto pr;
-- Q3
select
    cl.nome_cliente,
    cl.endereco,
    cl.cidade,
    cl.cep,
    cl.uf
        from cliente cl;
-- Q4
select
    ve.nome_vendedor
    from vendedor ve;
-- Q5
select cl.* from cliente cl;
-- Q6
select pr.* from produto pr;
-- Q7
select
'codigo do produto '||pr.cod_produto,
'nome do produto '||pr.descricao
    from produto pr;

INSERT INTO PRODUTO (COD_PRODUTO, DESCRICAO)
VALUES (1,'MOACIR GOSTOSAO');

INSERT INTO PRODUTO (COD_PRODUTO)
VALUES (24);
-- Q8
select ve.nome_vendedor AS NOME
from vendedor ve;
-- Q9
select cl.nome_cliente as NOME
from cliente cl;
-- Q10
UPDATE PRODUTO SET VLR_UNITARIO = 10

select
pr.vlr_unitario*.5 des50,
pr.vlr_unitario*1.05 COM05,
pr.vlr_unitario*1.2 COM20,
pr.vlr_unitario*1.3 COM30
from produto pr;
-- Q11
select ve.salario_fixo*1.05
from vendedor ve;


/*secao 2*/
-- Q1
select
    cl.nome_cliente
    from cliente cl
    where cl.cidade='Sorocaba';

-- Q2
select ve.*
    from vendedor ve
    where ve.salario_fixo<400;

-- Q3
select
    pr.cod_produto,
    pr.descricao from
    produto pr
    where pr.unidade='Kg';

-- Q4
select
    pe.num_pedido,
    pe.prazo_entrega
    from pedido pe
    where pe.prazo_entrega
	--pe.prazo_entrega>='01.05.1998'
	--and pe.prazo_entrega<='01.06.1998'	
    between '01.05.1998' and '01.06.1998';

-- Q5
select pr.*
    from produto pr
    where pr.vlr_unitario
    between 100 and 200;

-- Q6
select ip.num_pedido
    from item_pedido ip
    where ip.quantidade
    between 1000 and 1500;

-- Q7
select
    ve.nome_vendedor
    from vendedor ve
    where ve.nome_vendedor 
    like 'José%';

-- Q8
select
    cl.nome_cliente
    from cliente cl where
    cl.nome_cliente like '%Silvia';

-- Q9
select
    pr.descricao,
    pr.cod_produto
    from produto pr
    where pr.descricao
    like '%AC%';

-- Q10
select
    ip.cod_produto
    from item_pedido ip
    where ip.quantidade in (100,200,300);

-- Q11
select
    ve.nome_vendedor,
    ve.faixa_comissao
    from vendedor ve
    where ve.salario_fixo in (300,400,500);

-- Q12
select
    cl.nome_cliente
    from cliente cl
    where cl.endereco is null;

-- Q13
select
    pr.descricao
	from
    produto pr
    where pr.unidade='Lt' 
	and
    pr.vlr_unitario
    between 100 and 150;

-- Q14
select
    cl.*
    from cliente cl
    where cl.cidade='Itu' and
    cl.cep is null;

-- Q15
select distinct cl.cidade
    from cliente cl;

select cl.cidade
	from cliente cl
		group by cl.cidade


-- Q16
select cl.*
    from cliente cl
    order by cl.nome_cliente;

select cl.cod_cliente,
		cl.nome_cliente,
		cl.endereco,
		cl.cidade,
		cl.cep,
		cl.uf,
		cl.cgc,
		cl.ie
		from cliente cl
			order by 2 desc --ordena decrescente

-- Q17
select cl.*
    from cliente cl
    order by cl.cidade desc;

-- Q18
select
    max(ip.quantidade)
    from item_pedido ip;
	
-- Q19
select
    min(pr.vlr_unitario)
    from produto pr;

-- Q20
select
    sum(ve.salario_fixo)
    from vendedor ve;

-- Q21
select count(pr.cod_produto)
    from produto pr
    where pr.unidade='Lt';

-- Q22
select
    count(cl.cod_cliente),
    cl.cidade
    from cliente cl
    group by cl.cidade;

-- Q23
select
    count(pe.num_pedido),
    pe.cod_vendedor
    from pedido pe
    group by pe.cod_vendedor;

-- Q24
select
    max(pr.vlr_unitario),
    min(pr.vlr_unitario),
    pr.unidade
    from produto pr
    group by pr.unidade;

-- Q25
select
    count(cl.cod_cliente),
    cl.cidade
    from cliente cl
    group by cl.cidade
    having count(cl.cod_cliente)>4;

select
    avg(ip.quantidade),
    ip.cod_produto
    from item_pedido ip
    group by ip.cod_produto
    having
    avg(ip.quantidade)<
    (select avg(ip2.quantidade)
     from item_pedido ip2)

/*secao 3*/
-- Q1
select ve.cod_vendedor, 
	ve.nome_vendedor
from 
	pedido pe, 
	vendedor ve
where pe.cod_vendedor = ve.cod_vendedor
and pe.cod_cliente=10;

--plus
select ve.cod_vendedor, 
	ve.nome_vendedor
    from 
	vendedor ve, 
	pedido pe, 
	cliente cl
   where ve.cod_vendedor = pe.cod_vendedor   
   and pe.cod_cliente = cl.cod_cliente 
   and cl.nome_cliente='Ciclano da Silva';


-- Q2
select pe.num_pedido,
	pe.prazo_entrega,
	it.quantidade, 
	pr.descricao
from pedido pe, 
item_pedido it,
produto pr
where
pe.num_pedido = it.num_pedido and
it.cod_produto = pr.cod_produto and
PR.cod_produto=100;


-- Q3
select cl.endereco,cl.cidade,cl.uf,cl.cep
from cliente cl, pedido pe
where cl.cod_cliente = pe.cod_cliente
AND cl.uf='RJ'  and
(pe.prazo_entrega='03-08-1998'
OR pe.cod_vendedor=20);


select cl.endereco,cl.cidade,cl.uf,cl.cep
from cliente cl
inner join pedido pe on
cl.cod_cliente = pe.cod_cliente
where (cl.uf='RJ'  and
pe.prazo_entrega='03-08-1998')
or pe.cod_vendedor=20;


-- Q4
select ve.cod_vendedor, 
	ve.nome_vendedor
    from 
	vendedor ve, 
	pedido pe, 
	cliente cl
   where ve.cod_vendedor = pe.cod_vendedor   
   and pe.cod_cliente = cl.cod_cliente 
   and cl.nome_cliente='Ciclano da Silva';


-- Q5
select pr.cod_produto, 
	pr.descricao,
	pr.unidade, 
	SUM(ip.quantidade) QTD_TOTAL
    from produto pr, item_pedido ip 
    WHERE 
	pr.cod_produto = ip.cod_produto    	
	group by
    pr.cod_produto, pr.descricao, pr.unidade
   -- WHERE DO GROUP BY
    having sum(ip.quantidade) between 50 and 100;


-- Q6
select
    pe.num_pedido,
    pr.cod_produto,
    pr.descricao,
    ve.cod_vendedor,
    ve.nome_vendedor,
    cl.nome_cliente
    from pedido pe, item_pedido ip, produto pr, vendedor ve,  cliente cl
    WHERE    
	pe.num_pedido = ip.num_pedido AND
	ip.cod_produto = pr.cod_produto AND
	pe.cod_vendedor=ve.cod_vendedor AND
	pe.cod_cliente = cl.cod_cliente AND
     cl.cidade='Sorocaba';

-- Q7
select cl.cod_cliente, 
		cl.nome_cliente
from pedido pe, cliente cl  
where pe.cod_cliente = cl.cod_cliente
and
month(pe.prazo_entrega)=5 
and 
year(pe.prazo_entrega)=2002

-- Q8
select pr.cod_produto, 
pr.descricao, 
ip.quantidade, 
pe.prazo_entrega  
	from pedido pe, item_pedido ip,   produto pr 
	where
    pe.num_pedido = ip.num_pedido and
	ip.cod_produto = pr.cod_produto and
    pe.num_pedido = 123;

-- Q9
select cl.nome_cliente,cl.cidade,cl.endereco,cl.uf,cl.cep 
	from pedido pe, cliente cl, vendedor ve
		where pe.cod_cliente=cl.cod_cliente
		pe.cod_vendedor=ve.cod_vendedor
    and (cl.cidade='Itu' or cl.cidade='Sorocaba') 
	--where cl.cidade IN('Itu','Sorocaba') 
	and ve.nome_vendedor='Alôncio Pimentão'
   
select cl.nome_cliente,cl.cidade,cl.endereco,cl.uf,cl.cep 
	from pedido pe, cliente cl, vendedor ve
		where pe.cod_cliente=cl.cod_cliente
		pe.cod_vendedor=ve.cod_vendedor
    where cl.cidade IN('Itu','Sorocaba') 
	and ve.nome_vendedor='Alôncio Pimentão'

-- Q10
create view questao_10_secao_3
(NUM_PEDIDO, 
 COD_PRODUTO, 
 DES_PRODUTO,
 COD_VENDEDOR,
 NOM_VENDEDOR,
 NOM_CLIENTE)
as
    select pe.num_pedido,
	pr.cod_produto,
	pr.descricao,
	ve.cod_vendedor,
	ve.nome_vendedor,
	cl.nome_cliente
    from pedido pe, item_pedido ip, produto pr,  
	vendedor ve, cliente cl
	where
	pe.num_pedido = ip.num_pedido and
    ip.cod_produto = pr.cod_produto and
    pe.cod_vendedor = ve.cod_vendedor and
    pe.cod_cliente = cl.cod_cliente
    and cl.cidade='Itu'
	

/* para ver os dados da view */
select vw.cod_produto, vw.DES_PRODUTO 
from questao_10_secao_3 vw
order by vw.NOM_VENDEDOR desc




/* não é alterável ou atualizável porque depende de várias tabelas */
-- Q11
select cl.* from cliente cl
    where cl.cidade in
(select cli.cidade from cliente cli
where cli.nome_cliente='João da Silva');

select pr.* from produto pr
where pr.vlr_unitario >
(select avg(pro.vlr_unitario) from produto pro);


--Q12
select pr.* from produto pr
where pr.vlr_unitario > 
(select AVG(vlr_unitario) from produto);


select 
	cl.cod_cliente,
	cl.nome_cliente,
	(select nome_cliente from cliente 
	where cod_cliente=cl.cod_cliente)
from cliente cl



select 
	ped.num_pedido,
	(select c.nome_cliente from cliente c where 
	c.cod_cliente = ped.cod_cliente) cliente,
	(select v.nom_vendedor from questao_10_secao_3 v 
	where v.COD_VENDEDOR = ped.cod_vendedor) vendedor
 from pedido ped

--Q13

select cl.* from pedido pe, cliente cl 
where pe.cod_cliente = cl.cod_cliente
and pe.cod_vendedor=10;

-- Q14
select cl.* from cliente cl
    where cl.cod_cliente in
    (select cli.cod_cliente 
	from pedido pe, cliente cli,vendedor ve
     where 	
	 pe.cod_cliente = cli.cod_cliente and
	 pe.cod_vendedor = ve.cod_vendedor and
	 ve.nome_vendedor = 'Fulano de Tal')

-- Q15
select ve.* from vendedor ve
where ve.cod_vendedor not in
(select ven.cod_vendedor 
	from pedido pe, vendedor ven 
 where pe.cod_vendedor = ven.cod_vendedor
	and month(pe.prazo_entrega)=11 and
year(pe.prazo_entrega)=1998);


/*seção 4*/
-- Q1
-- DDL
alter table item_pedido
drop constraint FK_ITEMPED_PRODUTO;

alter table item_pedido
add constraint FK_ITEMPED_PRODUTO
foreign key(cod_produto)
references produto(cod_produto)
ON DELETE CASCADE;

-- DML
delete from produto pr
where pr.vlr_unitario>600;
--OU
delete from item_pedido ip
where ip.cod_produto
in (select pr.cod_produto from
produto pr where pr.vlr_unitario>600);

delete from produto pr
where pr.vlr_unitario>600;

-- Q2
alter table pedido drop constraint
FK_PEDIDO_VENDEDOR;
alter table pedido add constraint
FK_PEDIDO_VENDEDOR foreign key(cod_vendedor)
 references vendedor(cod_vendedor)
 ON DELETE CASCADE;
--OU
delete from item_pedido ip
where ip.num_pedido
in (select pe.num_pedido from pedido pe
where pe.cod_vendedor=30);

delete from pedido pe where pe.cod_vendedor=30;

-- Q3
delete from vendedor ve
where ve.cod_vendedor not in
(select pe.cod_vendedor from pedido pe);
-- Q4
delete from item_pedido 
where cod_produto in
 (select pr.cod_produto from produto pr
 where pr.vlr_unitario>300);

-- Q5
update produto  set
vlr_unitario=vlr_unitario*1.05;

-- Q6
update vendedor set
faixa_comissao='A'
where cod_vendedor=32;

-- Q7
update produto set produto.vlr_unitario=produto.vlr_unitario*0.995--(99.5/100)
where produto.vlr_unitario>
(select avg(pro.vlr_unitario)
from produto pro)





