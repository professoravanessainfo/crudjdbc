create table pessoa(
	id			uuid			primary key,
	nome		varchar(150)	not null,
	cpf			varchar(14)		not null,
	email		varchar(20)		not null
);

--consultar
select * from pessoa;

--gravar
insert into pessoa(id,nome,cpf,telefone) 
values(gen_random_uuid(),'Ana Paula','123.456.789-88','(21)98888-7777');