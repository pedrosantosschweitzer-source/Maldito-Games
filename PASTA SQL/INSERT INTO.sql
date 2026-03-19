insert into cliente (nome, cpf, telefone, email, endereco)
	Values ('João', '12345678900', '11999999999', 'joao@email.com', 'Rua A');

insert into produto (nome, descricao, preco, quantidade_estoque, categoria)
	values ('Pera', 'esta é uma fruta bonita', '15.08', '1', 'Fruta');

insert into venda (valor_total, data, cliente_id, status_pagamento)
	values (59.90,'2026-03-05', 1, 'Pago');

insert into item_venda (venda_id, produto_id, quantidade, subtotal)
	values ( 1, 1, 2, 23.80);

insert into pagamento (venda_id, forma_pagamento, valor_pagamento, data_pagamento)
	values (1, 'Cartao', 50.00, '2026-03-05');

insert into funcionario (nome,cargo,login,senha)
	values ('Carlos Silva', 'Gerente', 'carlos', '1234');