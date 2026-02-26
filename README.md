                                          ╔══════════════════════════════════════════════╗
                                          ║              SISTEMA DE LOJA                ║
                                          ╚══════════════════════════════════════════════╝
Sistema para gerenciamento de operações comerciais
Modelagem orientada a entidades e controle transacional

▌1 ▪ VISÃO GERAL DO SISTEMA

════════════════════════════════

O Sistema de Loja é uma aplicação desenvolvida para gerenciar o fluxo operacional de uma loja comercial, contemplando controle de produtos, estoque, clientes, vendas e pagamentos.

──────────────────────────────
OBJETIVOS PRINCIPAIS
──────────────────────────────

Centralizar dados comerciais

Garantir integridade e consistência das informações

Automatizar processos operacionais

Reduzir inconsistências manuais

Permitir rastreabilidade de transações

──────────────────────────────
ESCOPO FUNCIONAL
──────────────────────────────

✓ Cadastro de produtos
✓ Controle de estoque com atualização automática
✓ Registro de vendas
✓ Associação venda ⇄ cliente
✓ Registro de pagamentos
✓ Estrutura para relatórios gerenciais

──────────────────────────────
PADRÕES E CONCEITOS APLICADOS
──────────────────────────────

{ CRUD }
{ Modelagem Relacional }
{ Integridade Referencial }
{ Regras de Negócio }
{ Arquitetura em Camadas }

▌2 ▪ JUSTIFICATIVA TÉCNICA

════════════════════════════════

O domínio de gestão comercial foi escolhido por permitir aplicação prática de fundamentos essenciais da Engenharia de Software e Banco de Dados.

──────────────────────────────
CONCEITOS EXPLORADOS
──────────────────────────────

→ Relacionamentos 1:N
→ Relacionamentos N:N
→ Normalização de dados
→ Controle transacional
→ Separação de responsabilidades
→ Estruturação orientada a entidades

──────────────────────────────
MOTIVAÇÃO
──────────────────────────────

= Domínio amplamente utilizado no mercado
= Complexidade controlada e escalável
= Facilidade de expansão futura
= Aplicável a cenários reais

▌3 ▪ MODELAGEM PREVISTA

════════════════════════════════

Abaixo estão as entidades inicialmente definidas no modelo conceitual.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
▌ PRODUTO
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

{
id : PK
nome
descricao
preco
quantidade_estoque
categoria_id : FK
}

Relacionamento:
Produto (N) ──── (1) Categoria

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
▌ CLIENTE
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

{
id : PK
nome
cpf
email
telefone
endereco
}

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
▌ VENDA
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

{
id : PK
data_venda
cliente_id : FK
valor_total
}

Relacionamento:
Cliente (1) ──── (N) Venda

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
▌ ITEM_VENDA
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

{
id : PK
venda_id : FK
produto_id : FK
quantidade
preco_unitario
}

Relacionamentos:
Venda (1) ──── (N) Item_Venda
Produto (1) ──── (N) Item_Venda

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
▌ PAGAMENTO
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

{
id : PK
venda_id : FK
tipo_pagamento
valor
status
data_pagamento
}

Relacionamento:
Venda (1) ──── (N) Pagamento

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
▌ CATEGORIA
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

{
id : PK
nome
descricao
}

▌4 ▪ ESTRUTURA RELACIONAL (RESUMO)

══════════════════════════════════════

Cliente 1 ──────── N Venda
Venda 1 ───────── N Item_Venda
Produto 1 ─────── N Item_Venda
Categoria 1 ───── N Produto
Venda 1 ───────── N Pagamento
