/*3) Quais são os clientes (Customers) que têm ficha na base de dados da Northwind? Apresente a listagem (CustomerID, CompanyName) ordenada alfabeticamente segundo o nome do cliente (CompanyName). */
select c.CustomerID, c.CompanyName
	from Customers c 
	order by c.CompanyName asc

/*4)  Quais são os contactos (ContactName) e as regiões (Region) dos clientes (Customers) do país (Country) 'Mexico'? Apresente a listagem (CustomerID, CompanyName, ContactName, Region) ordenada por ordem alfabética segundo a região (Region) do cliente*/
select c.CustomerID, c.CompanyName, c.ContactName,c.Region
	from Customers c
	where c.Country = 'Mexico'
	order by c.Region asc

/*5) Quais são os produtos (Products) da categoria (CategoryId) '1' que estão disponíveis*/
select * 
	from Products p
		where p.CategoryID = '1'

/*em stock (UnitsInStock > 0)? Apresente a listagem (ProductID, ProductName, SupplierID, UnitsInStock ) ordenada de forma decrescente segundo a quantidade existente (UnitsInStock) em stock. */
select p.ProductID, p.ProductName, p.SupplierID, p.UnitsInStock
	from Products p
		where p.UnitsInStock>0
			order by UnitsInStock desc

/*6) Quais as encomendas (Orders) registadas na Northwind até ao momento e respectivos clientes? Apresente uma lista (OrderID, OrderDate, CustomerID) ordenada de forma decrescente segundo a data de encomenda(OrderDate).*/ 
select o.OrderID, o.OrderDate, o.CustomerID
	from Orders o
		order by o.OrderDate desc

/*7) Quais as encomendas (Orders) processadas pelo funcionário (EmployeeID) '5', às sextas-feiras, durante o ano de '1998'? Apresente uma lista (OrderID, OrderDate, EmployeeID) ordenada de forma crescente pela data de processamento da encomenda (OrderDate).*/ 
select o.OrderID, o.OrderDate, o.EmployeeID
	from Orders o
		where o.EmployeeID = '5'
		and DATEPART(WEEKDAY, o.OrderDate) = '6'
		and DATEPART(YEAR, o.OrderDate) = '1998'
		order by o.OrderDate asc

/*8)  Quais os produtos (ProductID) que foram encomendados, e em que quantidades (Quantity), nas encomendas (OrderId) com os códigos '10812', '10296' e '10251'*/
select ord.ProductID, ord.Quantity, ord.OrderID
	from [Order Details] ord
		where ord.OrderID in('10812', '10296' , '10251')

/*9) Quais foram os valores (UnitPrice*Quantity), sem desconto, por encomenda processada durante os meses de ‘Agosto’ e ‘Setembro’ do ano de '1996'?*/ 
select ord.UnitPrice, ord.Quantity, (ord.UnitPrice*ord.Quantity) as totalSemDesc
	from [Order Details] ord, Orders o
		where DATEPART(MONTH, o.OrderDate) in('8','9')
		and DATEPART(YEAR, o.OrderDate) = '1996'
		GROUP BY ord.OrderID;

/*10) Qual foi o valor total das encomendas (Orders), com e sem desconto (Discount), efectuadas pelo cliente como código (CustomerID) 'Quick' durante a semana '52'?*/  
/*11)  Quais os nomes (ProductName) dos produtos (Products) que foram encomendados pelos clientes  com os códigos (CustomerID) 'VINET' e 'HANAR', em encomendas registadas pelo funcionário com o código (EmployeeID) '5', durante o ano de '1996'? */
/*12)  Quais os fornecedores (SupplierID e CompanyName) dos produtos (ProductID) que foram encomendados (Order Details) durante o ano de '1996' por cliente (Customers) da região de código (Customers.Region) 'SP' ?*/
/*13) Mostrar quantos produtos existem em cada categoria. Mostrar o nome da categoria (tabelas Products e Categories).*/
/*14) Listar a quantidade de pedidos feitos por cada cliente entre Janeiro/97 e Junho/97. Mostrar o nome da empresa cliente.*/
/*15) Listar a venda total realizada por empregado no mês de Abril/1997.*/
/*16) Listar o nome e a soma dos valores de pedidos feitos para cada produto no mês de Março/1998. Mostrar apenas os 10 maiores.*/
/*17) Listar os 5 fornecedores que mais foram acionados no ano de 1997, por total de vendas. Mostrar o nome do fornecedor e o total da venda.*/
/*18) Listar o total de vendas realizadas mês a mês. Mostrar o mês/ano e o total de vendas realizadas naquele mês/ano.*/
