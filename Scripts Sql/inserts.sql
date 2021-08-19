--TABELA ESTADO
insert into estado (nome, id)
values ('RJ', 2001), ('CE', 2002), ('PA', 2003), ('PI', 2004), ('AC', 2005)

--TABELA CIDADE
insert into cidade (nome, id, id_estado)
values ('Rio de Janeiro', 111, 2001), ('Fortaleza', 222, 2002), ('Belem', 333, 2003), ('Teresina', 444, 2004), ('Rio Branco', 555, 2005)

--TABELA BAIRRO
insert into bairro (id, nome, id_cidade)
values (011, 'Pavuna', 111), (022, 'Parque Araxa', 222), (033, 'CentroB', 333), (044, 'CentroT', 444), (055, 'CentroRB', 555)

--TABELA ENDERECO
insert into endereco (id, numero, cep, rua, complemento, id_bairro)
values (001, 13, '13112-001', 'Av Brasil', 'Apto', 011), 
        (002, 23, '23012-002', 'Av Monsenhor Tabosa', 'Apto', 022), 
        (003, 33, '33333-333', 'Rua belem do para', 'casa', 033), 
        (004, 44, '4444-444', 'Rua Whindersson Nunes', 'casa', 044), 
        (005, 55, '55555-555', 'Rua dos Dinossauros', 'Apto', 055)

--TABELA PESSOA
insert into pessoa (nome, data_nasc, cpf, login, senha, tipo, id_endereco)
values('Juan Pimentel', '2001-11-13', '111111111-11', 'juanpimentel', '12345', 'DON', 001), 
        ('Sarah Soares', '2002-01-23', '22222222-22', 'sarahsoares', '122333', 'DIR', 002), 
        ('Marcus Queiros', '2002-10-17', '3333333-33', 'marcusqueiros', '3333333', 'GER', 003), 
        ('Ana Beatriz', '2002-03-11', '44444444-44', 'anabeatriz', '444444', 'FUN', 004), 
        ('Yara Paula', '2002-06-09', '55555555-55', 'yarapaula', '555555', 'EST', 005)

--TABELA LOG INTERACAO
insert into log_interacao (data, tipo, codigo, mensagem, login_pessoa)
values ('2021-08-17', 'INS', 'abcD12e', 'Bem-vindo', 'juanpimentel')

--TABELA DONO
insert into dono (cpf)
values ('111111111-11')

--TABELA EMPRESA 
insert into empresa(orcamento, cnpj, nome, cpf_dono)
values(100.000, '1234578-0001', 'bmd.sy', '111111111-11')

--TABELA CATEGORIA
insert into categoria (nome, id, carga_horaria, descricao, salario, cnpj_empresa)
values('Programador', 082021, 08, 'Desenvolvedores de programas de computadores', 10.000, '1234578-0001')

--TABELA SETOR
insert into setor(id, nome, orcamento, cnpj_empresa)
values (092021, 'Programacao', 50.000, '1234578-0001')

--TABELA FUNCIONARIO
insert into funcionario(bonificacao, cpf, id_categoria, id_setor, dia_pagamento, data_inicio)
values (1.500, '44444444-44', 082021, 092021, 01, '2021-08-01'), (5.000, '3333333-33', 082021, 092021, 01, '2020-10-17')

--TABELA DIRETOR
insert into diretor (cpf, cnpj_empresa, id_categoria)
values('22222222-22', '1234578-0001', 082021)

--TABELA ESTAGIARIO
insert into estagiario(cpf, id_categoria, id_setor, dia_pagamento, inicio_estagio, tempo_estagio)
values('55555555-55', 082021, 092021, 01, '2021-08-10', 90)

--TABELA TREINA
insert into treina (cpf_estagiario, cpf_funcionario, carga_horaria_treinamento)
values ('55555555-55', '44444444-44', 06)

--TABELA GERENTE
insert into gerente(bonificacao_gerente, cpf)
values(5.000, '3333333-33')

--TABELA GERENCIA
insert into gerencia(id_setor, gerente_cpf, data_inicio)
values (092021, '3333333-33', '2020-10-17')