USE mundo_miudo;

INSERT INTO fornecedor (razao_social, telefone, email, cnpj, endereco) 
VALUES
("Lavínia e Carla  ME", "(16) 2933-5037", "venda@laviniaecarla.com.br", "67730015000186", "Rua Padre Sena Freitas 706 Vila Virgínia Ribeirão Preto/SP"),
("Renan e Daiane ME", "(16) 2638-9124", "financeiro@renanedaiane.com.br", "61007083000135", "Rua Bahia 250 Vila Santa Maria (Vila Xavier) Araraquara/SP"),
("Sebastião e Mariane Jogos Educativos ME", "(11) 3941-2137", "producao@sebastiaoemariane.com.br", "50766816000107", "Rua Raimundo Lúlio 261 Jardim São Nicolau São Paulo/SP"),
("Renato e Teresinha Brinquedos Ltda", "(18) 3568-9854", "venda@renatoeteresinha.com.br", "13326693000159", "Praça Raphael Avallone 263 Parque do Colégio Jundiaí/SP"),
("César e Fábio Pelúcias Ltda", "(11) 2868-0960", "fabricacao@cesarefabio.com.br", "40003977000187", "Rua Vereador José de Moura 563 Jaçanã São Paulo/SP" );

INSERT INTO produto (nome, marca, tipo, preco_Venda, desconto, fabricante, quantidade) 
VALUES
("Vestido junino", "abc", "roupas",  155.00, 10, "cde", 10),
("Vestido festa", "Kids", "roupas",  135.00,  10, "aei", 9),
("Urso Ted Grande", "Tedco", "pelúcia",  300.00,  10, "PlushToy", 23),
("Jogo de encaixe", "Glabro", "jogos educativos",  170.00,  10, "BrickMais", 54),
("Jogo de memória", "Glabro", "jogos educativos", 163.00,  10, "BrickMais", 12),
("Boneco Hary Potter", "Disney", "pelúcia",  155.00,  10, "WB Pelúcia", 32),
("Fantasia de Minie", "Cloths", "roupas", 250.00,  10, "Cloths LTDA", 5),
("Lancheira patrulha canina", "Sweet", "papelaria",  147.00, 10, "Sweet.co", 3),
("Boneco Baby Yoda", "Disney", "pelúcia",  245.00,  10, "WB Pelúcia", 7),
("Boneca Baby", "TiniToy", "brinquedos", 160.00,  10, "TiniToy.co", 4);


/*
INSERT INTO estoque (produto_id, quantidade_em_estoque) 
VALUES
(1, 10),
(2, 5),
(3, 7),
(4, 9),
(5, 5),
(6, 4),
(7, 5),
(8, 20),
(9, 15),
(10, 5);
*/



INSERT INTO usuario (nome, login, senha, nivel_acesso) 
VALUES
('Mário','adm', md5('adm'),'administrador'),
("Joana Isadora Regina dos Santos", 'vendedor', md5('vendedor'), 'vendedor'),
("Daiane Helena Olivia Dias", 'gerente', md5('gerente'), 'gerente');


INSERT INTO compra (id_fornecedor, data_compra, total) 
VALUES
(1, '2010-01-02', 1521.10),
(2, '2011-02-03', 2225.12),
(3, '2013-02-04', 1235.25),
(4, '2015-02-12', 352.41),
(5, '2017-12-11', 227.12);

INSERT INTO item_comprado(compra_id, produto_id, quantidade_comprada, preco)
VALUES
(1, 1, 10, 10),
(2, 2, 20, 10),
(3, 3, 30, 10),
(4, 4, 40, 10),
(5, 5, 50, 10);


INSERT INTO venda (data_Venda, forma_Pagamento, qtd_Parcelas, usuario_id, total) 
VALUES
('2022-01-20', "débito",  1, 1, 140),
('2022-01-20', "débito",  2, 2, 391.5),
('2022-01-20', "débito", 3, 2, 288),
('2022-01-20', "débito", 4, 2, 146.7),
('2022-01-20', "crédito", 5, 1, 897),
('2022-01-20', "crédito", 6, 1, 220.5),
('2022-01-20', "débito", 1, 1, 288),
('2022-01-20', "crédito", 3,  1, 290),
('2022-01-20', "crédito", 2, 1, 600),
('2022-01-20', "débito", 1, 2, 446.40);


INSERT INTO item_vendido (venda_id, produto_id, quantidade_vendida, preco)
VALUES
(1, 1, 1, 155.00),
(2, 2, 1, 135.00),
(2, 3, 1, 300.00),
(3, 4, 2, 170.00),
(4, 5, 1, 163.00),
(5, 6, 2, 155.00),
(5, 7, 3, 250.00),
(5, 8, 1, 147.00),
(6, 9, 23, 245.00),
(7, 10, 15, 160.00),
(8, 1, 8, 155.00),
(8, 2, 9, 135.00),
(9, 3, 12, 300.00),
(10, 4, 17, 170.00),
(10, 5, 4, 163.00);