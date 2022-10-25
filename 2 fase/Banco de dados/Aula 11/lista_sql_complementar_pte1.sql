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
    vlr_unitario numeric(10,2));

create table item_pedido (
    num_pedido integer not null,
    cod_produto integer not null,
    quantidade numeric(10,2));

create table vendedor (
    cod_vendedor integer not null, 
    nome_vendedor varchar(40),
    faixa_comissao char(1),
    salario_fixo numeric(10,2));

/* criar chaves prim�rias */
alter table cliente add constraint PK_CLIENTE primary key(cod_cliente);
alter table pedido add constraint PK_PEDIDO primary key(num_pedido);
alter table produto add constraint PK_PRODUTO primary key(cod_produto);
alter table item_pedido add constraint PK_ITEMPED primary key(num_pedido,cod_produto);
alter table vendedor add constraint PK_VENDEDOR primary key(cod_vendedor);

/* criar chaves estrangeiras */
alter table pedido add constraint FK_PEDIDO_VENDEDOR foreign key(cod_vendedor) references vendedor(cod_vendedor);
alter table pedido add constraint FK_PEDIDO_CLIENTE foreign key(cod_cliente) references cliente(cod_cliente);
alter table item_pedido add constraint FK_ITEMPED_NUMPEDIDO foreign key(num_pedido) references pedido(num_pedido);
alter table item_pedido add constraint FK_ITEMPED_PRODUTO foreign key(cod_produto) references produto(cod_produto);

/* secao 1 */
-- Q1
select pe.num_pedido,pe.prazo_entrega from pedido pe;
-- Q2
select pr.descricao,pr.vlr_unitario from produto pr;
-- Q3
select cl.nome_cliente,
		cl.endereco,
		cl.cidade,
		cl.cep,
		cl.uf from cliente cl;
-- Q4
select ve.nome_vendedor from vendedor ve;
-- Q5
select cl.* from cliente cl;
-- Q6
select pr.* from produto pr;
-- Q7
select 
'codigo do produto '+ cast(pr.cod_produto as varchar(6)), 
'nome do produto '+pr.descricao 
from produto pr;
-- Q8
select ve.nome_vendedor as NOME from vendedor ve;
-- Q9
select cl.nome_cliente as NOME from cliente cl;
-- Q10
select pr.vlr_unitario*1.10, pr.vlr_unitario*1.20,pr.vlr_unitario*0.80 from produto pr;
-- Q11
select ve.salario_fixo*1.05 vendedor ve;

/*se��o 2*/
-- Q1
select cl.nome_cliente 
	from cliente cl 
		where cl.cidade='Sorocaba';
-- Q2
select ve.* 
	from vendedor ve 
	where ve.salario_fixo<400;
-- Q3
select	pr.cod_produto,
		pr.descricao
		from produto pr		
		where pr.unidade='Kg';
-- Q4
select
	pe.num_pedido, 
	pe.prazo_entrega 
	from pedido pe
	where 
	pe.prazo_entrega between '01.05.1998' and '01.06.1998';

select pe.num_pedido, 
	   pe.prazo_entrega 
		from pedido pe
		where pe.prazo_entrega >= '01/05/1998' 
		and  pe.prazo_entrega<='01/06/1998';
-- Q5
select pr.* from produto pr 
	where pr.vlr_unitario between 100 and 200;
-- Q6
select 
	ip.num_pedido,
	ip.cod_produto 
	from item_pedido ip 
	where ip.quantidade between 999 and 1501;

-- Q7
	select ve.nome_vendedor 
		from vendedor ve where ve.nome_vendedor 
			like 'José%';

-- Q8
select cl.nome_cliente 
	from cliente cl 
		where cl.nome_cliente like '%Silvia';
-- Q9
select pr.descricao, pr.cod_produto 
	from produto pr where pr.descricao like '%AC%';

-- Q10
select ip.cod_produto 
	from item_pedido ip 
		where ip.quantidade in (100,200,300,500);

-- Q11
select ve.nome_vendedor, ve.faixa_comissao 
	from vendedor ve 
	where ve.salario_fixo in (300,400,500);
-- Q12
select cl.nome_cliente 
	from cliente cl 
	where cl.endereco is null
	or cl.endereco='';
-- Q13
select pr.descricao 
	from produto pr 
	where pr.unidade='Lt' 
	and pr.vlr_unitario between 100 and 150;
-- Q14
select cl.* from cliente cl 
	where cl.cidade='Itu' 
	and (cl.cep is null or cl.cep='');
-- Q15
select distinct cl.cidade from cliente cl;
select cl.cidade from cliente cl group by cl.cidade;

-- Q16
select cl.* from cliente cl order by cl.nome_cliente;
select cl.* from cliente cl order by 2;
-- Q17
select cl.* from cliente cl order by cl.cidade desc;
-- Q18
select max(ip.quantidade) from item_pedido ip;
-- Q19
select min(pr.vlr_unitario) from produto pr;
-- Q20
select sum(ve.salario_fixo) from vendedor ve;
-- Q21
select count(pr.cod_produto) from produto pr where pr.unidade='Lt';
-- Q22
select count(cl.cod_cliente),cl.cidade  
	from cliente cl 
	group by cl.cidade;
-- Q23
select count(pe.num_pedido),
pe.cod_vendedor from 
pedido pe 
group by pe.cod_vendedor;
-- Q24
select max(pr.vlr_unitario), 
min(pr.vlr_unitario),
pr.unidade  
from produto pr group by pr.unidade;
-- Q25
select 
	count(cl.cod_cliente),
	cl.cidade from cliente cl 
	group by cl.cidade 
having count(cl.cod_cliente)>4;


