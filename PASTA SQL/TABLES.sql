CREATE TABLE IF NOT EXISTS cliente (
	id SERIAL Primary key,
	nome VARCHAR(150) NOT NULL,
	cpf VARCHAR (11) UNIQUE NOT NULL,
	telefone VARCHAR (14),
	email VARCHAR (150) UNIQUE,
	endereco VARCHAR (150) 
	);

CREATE TABLE IF NOT EXISTS produto (
	id SERIAL Primary key,
	nome VARCHAR(150) NOT NULL,
	descricao VARCHAR (150) NOT NULL,
	preco NUMERIC (14) NOT NULL,
	quantidade_estoque VARCHAR (150),
	categoria VARCHAR (150) 
	);

CREATE TABLE IF NOT EXISTS venda (
	id SERIAL Primary key,
	valor_total NUMERIC (15,2) NOT NULL,
	data DATE,
	cliente_id INT NOT NULL,
	status_pagamento VARCHAR (50),
	FOREIGN KEY (cliente_id) REFERENCES cliente(id)
	);

CREATE TABLE IF NOT EXISTS item_venda (
	id SERIAL Primary key,
	venda_id INT NOT NULL,
	produto_id INT NOT NULL,
	quantidade VARCHAR (1000) NOT NULL,
	subtotal NUMERIC (20,2), 
	FOREIGN KEY (venda_id) REFERENCES venda (id),
	FOREIGN KEY (produto_id) REFERENCES produto (id)
	);

CREATE TABLE IF NOT EXISTS pagamento (
	id SERIAL Primary key,
	venda_id INT NOT NULL,
	forma_pagamento VARCHAR(100) NOT NULL,
	valor_pagamento NUMERIC (20,2) NOT NULL,
	data_pagamento DATE,
	FOREIGN KEY (venda_id) REFERENCES venda (id)
	);

CREATE TABLE IF NOT EXISTS funcionario (
	id SERIAL Primary key,
	nome VARCHAR(100) NOT NULL,
	cargo VARCHAR (50) NOT NULL,
	login VARCHAR (50) NOT NULL,
	senha VARCHAR (50) NOT NULL
	);

	