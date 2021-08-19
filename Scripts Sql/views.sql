-- Funcionario e Setor
create view funcionario_Setor
as select  f.bonificacao, f.cpf, f.id_categoria, 
f.id_setor, f.dia_pagamento, f.data_inicio, s.id, s.nome, s.orcamento, s.cnpj_empresa 
from funcionario f
inner join setor s
on f.id_setor = s.id

-- Dono e Empresa
create view dono_Empresa
as select d.cpf, e.orcamento, e.cnpj, e.nome, e.cpf_dono
from dono d
inner join empresa e
on d.cpf = e.cpf_dono

-- Diretor e Empresa
create view diretor_empresa
as select d.cpf, d.cnpj_empresa, d.id_categoria, e.orcamento,
e.cnpj, e.nome, e.cpf_dono
from diretor d
inner join empresa e
on d.cnpj_empresa = e.cnpj

-- Diretor Setor 
--create view diretor_setor 
--as select d.cpf, d.cnpj_empresa, d.id_categoria,
--s.id, s.nome, s.orcamento, s.cnpj_empresa
--from diretor d 
--inner join setor s
--on d.cnpj_empresa = s.cnpj_empresa

--Estagiario e treina
create view estagiario_treina
as select e.cpf, e.id_categoria, e.id_setor, e.dia_pagamento,
e.inicio_estagio, e.tempo_estagio, t.cpf_estagiario, t.cpf_funcionario,
t.carga_horaria_treinamento
from estagiario e
inner join treina t 
on e.cpf = t.cpf_estagiario

--Funcionario e treina 
create view funcionario_treina 
as select f.bonificacao, f.cpf, f.id_categoria, f.id_setor, 
f.dia_pagamento, f.data_inicio, t.cpf_estagiario, t.cpf_funcionario,
t.carga_horaria_treinamento
from funcionario f
inner join treina t 
on f.cpf = t.cpf_funcionario