insert into categoria (nome) values ('Alimentos');
insert into categoria (nome) values ('Limpeza');

insert into fornecedor (cnpj, email, nome, telefone) values ('1234567843211', 'fornecedor@mail.com', 'Cabral e souza', '779985454544');
insert into fornecedor (cnpj, email, nome, telefone) values ('1214541221898', 'fornecedor@mail.com', 'Cabral e souza', '779985454544');

insert into produto (nome, qtde_minima, qtde_estoque, unidade_medida, id_categoria_fk) values ('Feijão', 2, 10, 'PC', 1);
