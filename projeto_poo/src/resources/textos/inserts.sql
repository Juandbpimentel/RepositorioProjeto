--TABELA ESTADO
insert into estado (uf,nome)
values ('RJ','Rio de Janeiro'), ('CE','Ceará'), ('PA', 'Pará'), ('PI', 'Piauí'), ('AC', 'Acre');

--TABELA CIDADE
insert into cidade (nome,uf)
values ('Rio de Janeiro','RJ'), ('Fortaleza','CE'), ('Belem','PA'), ('Teresina','PI'), ('Rio Branco','AC');

--TABELA BAIRRO
insert into bairro (nome, id_cidade)
values ('Pavuna', 1), ('Parque Araxa', 2), ('CentroB', 3), ('CentroT', 4), ('CentroRB', 5);

--TABELA ENDERECO
insert into endereco (numero, cep, rua, complemento, id_bairro)
values  ( 13, '13112-001', 'Av Brasil', 'Apto', 1), 
        ( 23, '23012-002', 'Av Monsenhor Tabosa', 'Apto', 2), 
        ( 33, '33333-333', 'Rua belem do para', 'casa', 3), 
        ( 44, '4444-444', 'Rua Whindersson Nunes', 'casa', 4), 
        ( 55, '55555-555', 'Rua dos Dinossauros', 'Apto', 5);

--TABELA PESSOA
insert into pessoa (nome, data_nasc, cpf, login, senha, tipo, id_endereco)
values('Juan Pimentel', '2001-11-13', '111111111-11', 'juanpimentel', '12345', 'DON', 1), 
        ('Sarah Soares', '2002-01-23', '22222222-22', 'sarahsoares', '122333', 'DIR', 2), 
        ('Marcus Queiros', '2002-10-17', '3333333-33', 'marcusqueiros', '3333333', 'GER', 3), 
        ('Ana Beatriz', '2002-03-11', '44444444-44', 'anabeatriz', '444444', 'FUN', 4), 
        ('Yara Paula', '2002-06-09', '55555555-55', 'yarapaula', '555555', 'EST', 5);

--TABELA LOG INTERACAO
insert into log_interacao (data, tipo, codigo, mensagem, login_pessoa)
values ('2021-08-17', 'INS', 'abcD12e', 'Bem-vindo', 'juanpimentel');

--TABELA DONO
insert into dono (cpf)
values ('111111111-11');

--TABELA EMPRESA 
insert into empresa(orcamento, cnpj, nome, cpf_dono)
values(100.000, '1234578-0001', 'bmd.sy', '111111111-11');

--TABELA CATEGORIA
insert into categoria (nome, carga_horaria, descricao, salario, cnpj_empresa)
values('Programador', 08, 'Desenvolvedores de programas de computadores', 10.000, '1234578-0001');

--TABELA SETOR
insert into setor(nome, orcamento, cnpj_empresa)
values ('Programacao', 50.000, '1234578-0001');

--TABELA FUNCIONARIO
insert into funcionario(bonificacao, cpf, id_categoria, id_setor, dia_pagamento, data_inicio)
values (1.500, '44444444-44', 1, 1, 01, '2021-08-01'), (5.000, '3333333-33', 1, 1, 01, '2020-10-17');

--TABELA DIRETOR
insert into diretor (cpf, cnpj_empresa, id_categoria)
values('22222222-22', '1234578-0001', 1);

--TABELA ESTAGIARIO
insert into estagiario(cpf, id_categoria, id_setor, dia_pagamento, inicio_estagio, tempo_estagio)
values('55555555-55', 1, 1, 01, '2021-08-10', 90);

--TABELA TREINA
insert into treina (cpf_estagiario, cpf_funcionario, carga_horaria_treinamento)
values ('55555555-55', '44444444-44', 06);

--TABELA GERENTE
insert into gerente(bonificacao_gerente, cpf)
values(5.000, '3333333-33');

--TABELA GERENCIA
insert into gerencia(id_setor, gerente_cpf, data_inicio)
values (1, '3333333-33', '2020-10-17');