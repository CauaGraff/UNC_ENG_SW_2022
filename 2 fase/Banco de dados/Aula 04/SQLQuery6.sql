create database Oficina
go
use Oficina
go

create table OrdemServico(
id int not null,
data_inicio date default getdate(),
data_fim date default getdate(),

)
