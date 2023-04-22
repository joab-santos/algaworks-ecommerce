INSERT INTO produto (id, nome, preco, descricao) VALUES(1,'Kindle', 499.0, 'Conheça o novo kindle');
INSERT INTO produto (id, nome, preco, descricao) VALUES(3,'Câmera GoPro Hero 7', 1400.0, 'Desempenho 2x melhor');

INSERT INTO cliente(id, nome) VALUES(1, "Fernando Medeiros");
INSERT INTO cliente(id, nome) VALUES(2, "Marcos Mariano");

INSERT INTO algaworks_ecommerce.pedido (id, data_conclusao, data_pedido, bairro, cep, cidade, complemento, estado, logradouro, numero, nota_fiscal_id, status, total, cliente_id) VALUES(1, NULL, '2023-04-22 13:51:17.085854', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'AGUARDANDO', 499.00, 1);

INSERT INTO algaworks_ecommerce.item_pedido(id, preco_produto, quantidade, pedido_id, produto_id)VALUES(1, 499.00, 1, 1, 1);
