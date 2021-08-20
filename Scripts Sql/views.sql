
--Junção de estagiario com os dados da tabela pessoa e categoria
create view estagiario_pessoa_categoria
as 	select e.cpf, p.nome, e.id_categoria, c.nome as nome_categoria, e.id_setor, e.dia_pagamento, e.inicio_estagio, e.tempo_estagio
   	from estagiario e
   	inner join pessoa p on p.cpf = e.cpf
   	inner join categoria c on e.id_categoria = c.id;


--Junção de funcionario com os dados da tabela pessoa e categoria
create view funcionario_pessoa_categoria
as 	select f.cpf, p.nome, f.bonificacao, f.id_categoria, c.nome as nome_categoria, f.id_setor, f.dia_pagamento, f.data_inicio
    from funcionario f inner join pessoa p on p.cpf = f.cpf
    inner join categoria c on f.id_categoria = c.id;


--Junção de diretor com os dados da tabela pessoa e categoria
create view diretor_pessoa_categoria
as 	select d.cpf, p.nome, d.cnpj_empresa, d.id_categoria, c.nome as nome_categoria
    from diretor d inner join pessoa p on p.cpf = d.cpf
   	inner join categoria c on d.id_categoria = c.id;


--Junção de dono com os dados da tabela pessoa
create view dono_pessoa
as 	select d.cpf, p.nome
    from dono d inner join pessoa p on p.cpf = d.cpf;


--Junção de gerente com os dados da tabela pessoa
create view gerente_pessoa
as  select g.cpf, p.nome, g.bonificacao_gerente
	from gerente g inner join pessoa p on p.cpf = g.cpf;


--Junção dos dados das tabelas funcionario e estagiario com a tabela treina
create view funcionario_treina_estagiario as
    select t.cpf_estagiario, e.nome as estagiario,t.cpf_funcionario, f.nome as funcionario, t.carga_horaria_treinamento
    from  estagiario_pessoa_categoria as e
    inner join treina as t on t.cpf_estagiario = e.cpf
    inner join funcionario_pessoa_categoria as f on f.cpf = t.cpf_funcionario;



-- Junção dos dados da tabela funcionario com setor
create view funcionario_setor
as select  f.nome,f.cpf, f.id_categoria, f.nome_categoria, f.id_setor, s.nome as nome_setor, f.bonificacao, f.dia_pagamento, f.data_inicio
from funcionario_pessoa_categoria f
inner join setor s
on f.id_setor = s.id;


-- Junção dos dados da tabela empresa com dono
create view dono_Empresa
as select d.nome as nome, d.cpf,e.nome as nome_empresa, e.cnpj, e.orcamento
   from dono_pessoa d
   inner join empresa e on e.cpf_dono = d.cpf;



-- Junção dos dados da tabela diretores com empresa
create view diretor_empresa
as select d.cpf, d.nome as nome, d.id_categoria, d.nome_categoria, e.nome as empresa, d.cnpj_empresa
from diretor_pessoa_categoria d
inner join empresa e
on d.cnpj_empresa = e.cnpj;

--Junção dos dados da tabela setor,gerente com a tabela gerencia
create view gerente_gerencia_setor
as select g2.nome as gerente, g1.id_setor, g1.gerente_cpf, g1.data_inicio,
g2.bonificacao_gerente, s.nome as setor
from gerente_pessoa as g2
inner join gerencia as g1 on g1.gerente_cpf= g2.cpf
inner join setor as s on s.id = g1.id_setor;

--Junção dos dados da tabela pessoa com a tabela log_alteracao

create view pessoa_log as
select log.id as id_log, log.login_pessoa, p.nome, log.data,log.tipo, log.codigo, log.mensagem
	from pessoa as p
	inner join log_alteracao as log on p.login = log.login_pessoa

--Junção dos dados da tabela pessoa com a tabela endereco

select p.nome, p.cpf, p.id_endereco, e.numero, e.rua, e.complemento,
	   e.cep, b.nome as nome_bairro ,c.nome as nome_cidade,est.nome as nome_estado
    from pessoa p
    inner join endereco e on p.id_endereco = e.id
    inner join bairro b on e.id_bairro = b.id
    inner join cidade c on b.id_cidade = c.id
    inner join estado est on c.id_estado = est.id;
