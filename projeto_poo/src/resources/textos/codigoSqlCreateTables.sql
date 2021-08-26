create table if not exists ESTADO(
	NOME varchar(30) not null, 
	uf varchar(2) not null,
	
	--chave primária
	constraint estado_pkey primary key (uf)
	
);

create table if not exists CIDADE(
	id serial not null, 
	nome varchar (30) not null, 
	uf varchar(2) not null,
	
	--chave primária
	constraint cidade_pkey primary key (id),
	--chave estrangeira 
	constraint estado_fkey foreign key (uf)
	references estado (uf) ON UPDATE CASCADE ON DELETE CASCADE
);

create table if not exists bairro(
	id serial not null, 
	nome varchar (30) not null,
	id_cidade integer not null, 
	
	--chave primária
	constraint bairro_pkey primary key (id),
	--chave estrangeira 
	constraint cidade_fkey foreign key (id_cidade)
	references cidade (id) ON UPDATE CASCADE ON DELETE CASCADE
);

create table if not exists endereco(
	id serial not null, 
	numero integer not null, 
	cep varchar (9) not null, 
	rua varchar (30) not null, 
	complemento varchar (30), 
	id_bairro integer, 
	
	--chave primária
	constraint endereco_pkey primary key (id),
	--chave estrangeira 
	constraint bairro_fkey foreign key (id_bairro)
	references bairro (id) ON UPDATE CASCADE ON DELETE CASCADE
);

create table if not exists pessoa(
	nome varchar (30) not null, 
	data_nasc date not null, 
	cpf varchar(15) not null, 
	login varchar(28) not null unique, 
	senha varchar(30) not null,
	tipo varchar (3) not null, 
	id_endereco integer not null, 
	--valores padrao tipo 
	constraint tipo_check check (tipo in ('FUN', 'EST', 'GER', 'ADM', 'DIR', 'DON','DEM','PES')),
	--chave primária
	constraint pessoa_pkey primary key (cpf),
	--chave estrangeira 
	constraint endereco_fkey foreign key (id_endereco)
	references endereco (id) ON UPDATE CASCADE ON DELETE CASCADE
	
);

create table if not exists Log_Interacao(
	data timestamp not null, 
	tipo varchar (3) not null,
	id serial not null, 
	codigo varchar (200) not null, 
	mensagem varchar (300) not null, 
	login_pessoa varchar (28) not null, 
	--valores padrão tipo 
	constraint tipo_check check(tipo in ('INS','ATU','EXC','BUS')),
	--chave primária 
	constraint log_alteracao_pkey primary key (id),
	--chave estangeira
	constraint pessoa_fkey foreign key (login_pessoa)
	references pessoa (login) ON UPDATE CASCADE ON DELETE CASCADE
	
);

create table if not exists dono(
	cpf varchar(15), 
	--chave primária
	constraint dono_pkey primary key (cpf),
	--chave estrangeira 
	constraint pessoa_fkey foreign key (cpf)
	references pessoa (cpf) ON UPDATE CASCADE ON DELETE CASCADE
);

create table if not exists empresa(
	orcamento numeric not null, 
	cnpj varchar (19) not null, 
	nome varchar(30) not null, 
	cpf_dono varchar(15) not null, 
	
	--chave primária 
	constraint empresa_pkey primary key (cnpj), 
	--chave estrangeira 
	constraint dono_fkey foreign key (cpf_dono)
	references dono (cpf) ON UPDATE CASCADE ON DELETE CASCADE
);

create table if not exists categoria(
	nome varchar(30) not null, 
	id serial not null, 
	carga_horaria integer not null, 
	descricao varchar(50) not null, 
	salario numeric not null, 
	cnpj_empresa varchar (19) not null, 
	
	--chave primária
	constraint categoria_pkey primary key (id), 
	--chave estrangeira 
	constraint empresa_fkey foreign key (cnpj_empresa)
	references empresa (cnpj) ON UPDATE CASCADE ON DELETE CASCADE
);

create table if not exists setor(
	id serial not null, 
	nome varchar(30) not null, 
	orcamento numeric not null, 
	cnpj_empresa varchar(19) not null, 
	
	--chave primária
	constraint setor_pkey primary key (id),
	--chave estrangeira
	constraint empresa_fkey foreign key (cnpj_empresa)
	references empresa (cnpj) ON UPDATE CASCADE ON DELETE CASCADE
);

create table if not exists funcionario(
	bonificacao numeric not null, 
	cpf varchar(15) not null, 
	id_categoria integer not null, 
	id_setor integer not null, 
	dia_pagamento integer not null, 
	data_inicio date not null, 
	
	--chave primaria
	constraint funcionario_pkey primary key (cpf),
	--chave estrangeira
	constraint pessoa_fkey foreign key (cpf)
	references pessoa (cpf) ON UPDATE CASCADE ON DELETE CASCADE,
	
	constraint categoria_fkey foreign key (id_categoria)
	references categoria (id) ON UPDATE CASCADE ON DELETE CASCADE, 
	
	constraint setor_fkey foreign key (id_setor)
	references setor (id) ON UPDATE CASCADE ON DELETE CASCADE
);

create table if not exists diretor(
	cpf varchar (15) not null, 
	cnpj_empresa varchar (19) not null, 
	id_categoria integer not null, 
	
	--chave primária
	constraint diretor_pkey primary key (cpf),
	--chave estrangeira
	constraint pessoa_fkey foreign key (cpf) 
	references pessoa (cpf) ON UPDATE CASCADE ON DELETE CASCADE,
	
	constraint empresa_fkey foreign key (cnpj_empresa)
	references empresa (cnpj) ON UPDATE CASCADE ON DELETE CASCADE, 
	
	constraint categoria_fkey foreign key (id_categoria)
	references categoria (id) ON UPDATE CASCADE ON DELETE CASCADE
	
);

create table if not exists estagiario(
	cpf varchar (15) not null, 
	id_categoria integer not null, 
	id_setor integer not null, 
	dia_pagamento integer not null, 
	inicio_estagio date not null, 
	tempo_estagio integer not null,
	
	--chave primaria
	constraint estagiario_pkey primary key (cpf), 
	--chave estrangeira
	constraint pessoa_fkey foreign key (cpf)
	references pessoa (cpf) ON UPDATE CASCADE ON DELETE CASCADE, 
	
	constraint categoria_fkey foreign key (id_categoria)
	references categoria (id) ON UPDATE CASCADE ON DELETE CASCADE, 
	
	constraint setor_fkey foreign key (id_setor)
	references setor (id) ON UPDATE CASCADE ON DELETE CASCADE
);

create table if not exists treina (
	cpf_estagiario varchar(15) not null, 
	cpf_funcionario varchar(15) not null,
	carga_horaria_treinamento integer not null,
	
	--chave primaria
	constraint treina_pkey primary key (cpf_estagiario),
	--chave estrangeira
	constraint estagiario_fkey foreign key (cpf_estagiario)
	references estagiario (cpf) ON UPDATE CASCADE ON DELETE CASCADE, 
	
	constraint funcionario_fkey foreign key (cpf_funcionario)
	references funcionario (cpf) ON UPDATE CASCADE ON DELETE CASCADE
	
);

create table if not exists gerente (
	bonificacao_gerente numeric not null, 
	cpf varchar (15) not null,  
	
	--chave primaria
	constraint gerente_pkey primary key (cpf),
	--chave estrangeira
	constraint funcionario_fkey foreign key (cpf)
	references funcionario (cpf) ON UPDATE CASCADE ON DELETE CASCADE
);

create table if not exists gerencia (
	id_setor integer not null, 
	gerente_cpf varchar (15) not null,
	data_inicio date not null,
	
	--chave primaria
	constraint gerencia_pkey primary key (gerente_cpf, id_setor), 
	--chave estrangeira
	constraint setor_fkey foreign key (id_setor)
	references setor (id) ON UPDATE CASCADE ON DELETE CASCADE,
	
	constraint gerente_fkey foreign key (gerente_cpf)
	references gerente (cpf) ON UPDATE CASCADE ON DELETE CASCADE
);