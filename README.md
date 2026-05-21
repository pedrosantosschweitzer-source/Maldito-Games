Teste
# Sistema de Loja

## Apresentação do Projeto

Este projeto consiste no desenvolvimento de um Sistema de Loja com fins
educacionais, elaborado por alunos do 3º ano do Ensino Médio Técnico. O
objetivo principal é simular o funcionamento de um sistema comercial
real, aplicando conceitos fundamentais de programação, banco de dados e
modelagem de sistemas.

O projeto será desenvolvido de forma contínua ao longo do ano, com
rodízio de alunos a cada bimestre. Dessa forma, a organização, clareza e
documentação adequada tornam-se elementos essenciais para garantir a
continuidade e evolução do sistema.

Este repositório não representa apenas código, mas também um ambiente de
aprendizado colaborativo.

------------------------------------------------------------------------

## Objetivo Geral

Desenvolver um sistema capaz de:

-   Realizar cadastro de produtos
-   Gerenciar controle de estoque
-   Cadastrar clientes
-   Registrar vendas
-   Processar pagamentos
-   Permitir futura expansão com relatórios e controle de usuários

O sistema deve ser estruturado de maneira organizada, permitindo que
novos alunos compreendam rapidamente sua lógica e possam dar
continuidade ao desenvolvimento.

------------------------------------------------------------------------

## Motivação

O tema foi escolhido por sua relevância prática e por permitir a
aplicação de diversos conteúdos técnicos aprendidos no curso.

Sistemas comerciais estão presentes em praticamente todos os
estabelecimentos. Trabalhar com esse modelo permite compreender:

-   Estruturação de banco de dados
-   Relacionamento entre entidades
-   Organização de código
-   Separação de responsabilidades no sistema
-   Boas práticas de documentação

Além disso, o formato com rodízio de desenvolvedores simula um cenário
próximo ao ambiente profissional, onde diferentes pessoas contribuem
para o mesmo projeto ao longo do tempo.

------------------------------------------------------------------------

## Previsão de Entidades do Sistema

A seguir estão as principais entidades previstas para o sistema:

### Produto

-   idProduto
-   nome
-   descricao
-   preco
-   quantidadeEstoque
-   categoria

### Cliente

-   idCliente
-   nome
-   cpf
-   telefone
-   email
-   endereco

### Venda

-   idVenda
-   data
-   valorTotal
-   idCliente
-   statusPagamento

### ItemVenda

-   idItemVenda
-   idVenda
-   idProduto
-   quantidade
-   subtotal

### Pagamento

-   idPagamento
-   idVenda
-   formaPagamento
-   valorPago
-   dataPagamento

### Funcionario (evolução futura)

-   idFuncionario
-   nome
-   cargo
-   login
-   senha

------------------------------------------------------------------------
# COMO RODAR O SISTEMA

##  Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **Java JDK 11 ou superior** (recomendado JDK 17)
- **PostgreSQL 14 ou superior** (com pgAdmin opcional)
- **Git** (opcional, para clonar o repositório)
- **Uma IDE** (Eclipse, IntelliJ, VS Code ou NetBeans)

---

## 🗄️ Configuração do Banco de Dados

### 1. Criar o banco de dados

Abra o **pgAdmin** ou o terminal `psql` e execute:

```sql
CREATE DATABASE Bemdito_Games;
```

### 2. Criar as tabelas

Conecte-se ao banco Bemdito_Games e execute o script abaixo:
```
-- Tabela de produtos
CREATE TABLE produtos (
    id_produto SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    quantidade_estoque INTEGER NOT NULL,
    categoria VARCHAR(50)
);

-- Tabela de clientes
CREATE TABLE clientes (
    id_cliente SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    telefone VARCHAR(15),
    email VARCHAR(100),
    endereco VARCHAR(200)
);

-- Tabela de funcionários
CREATE TABLE funcionarios (
    id_funcionario SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cargo VARCHAR(50),
    login VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL
);

-- Tabela de vendas
CREATE TABLE vendas (
    id_venda SERIAL PRIMARY KEY,
    data VARCHAR(20) NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL,
    id_cliente INTEGER NOT NULL,
    status_pagamento VARCHAR(30) NOT NULL
);

-- Tabela de pagamentos
CREATE TABLE pagamentos (
    id_pagamento SERIAL PRIMARY KEY,
    id_venda INTEGER NOT NULL,
    forma_pagamento VARCHAR(30) NOT NULL,
    valor_pago DECIMAL(10,2) NOT NULL,
    data_pagamento VARCHAR(20)
);

-- Tabela de itens de venda
CREATE TABLE itens_venda (
    id_item_venda SERIAL PRIMARY KEY,
    id_venda INTEGER NOT NULL,
    id_produto INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL
);
```
obs:
Você pode executar esse script no Query Tool do pgAdmin (botão direito no banco → Query Tool) ou via terminal com `psql -U postgres -d Bemdito_Games`.

## 3. Importar o projeto no Eclipse

1. Baixe o projeto do GitHub
2. No Eclipse: File → Import → Existing Projects into Workspace
3. Selecione a pasta do projeto

## 4. Baixar o driver JDBC

1. Acesse: https://jdbc.postgresql.org/download/
2. Baixe o arquivo `postgresql-42.7.3.jar`
3. Clique com botão direito no projeto → Build Path → Configure Build PathAba Libraries → Add External JARs
4. Selecione o arquivo baixado
5. Clique em Apply and Close

## 5. Configurar a senha do banco

Abra o arquivo `src/dao/DBConnection.java` e altere a senha para a sua:
```
this.connection = DriverManager.getConnection(
    "jdbc:postgresql://localhost:5432/Bemdito_Games", 
    "postgres",     // seu usuário
    "SUA_SENHA"     // ← coloque sua senha do PostgreSQL aqui
);
```

## 6. Executar

Clique com botão direito em `main/App.java` → Run As → Java Application
