CREATE TABLE tb_usuarios (
                             id_usuario INTEGER NOT NULL AUTO_INCREMENT,
                             email VARCHAR(100),
                             cpf VARCHAR(11),
                             senha VARCHAR(30),
                             dt_criacao DATE,
                             dt_alteracao DATE,
                             dt_exclusao DATE,
                             PRIMARY KEY (id_usuario)
);

CREATE TABLE tb_funcao (
                           id_funcao INTEGER AUTO_INCREMENT,
                           nm_funcao VARCHAR(50),
                           ds_funcao VARCHAR(300),
                           modulo VARCHAR(60),
                           dt_criacao DATE,
                           dt_alteracao DATE,
                           dt_exclusao DATE,
                           PRIMARY KEY (id_funcao)
);

CREATE TABLE tb_infos_usuario (
                                  id_usuario INTEGER,
                                  id_funcao INTEGER,
                                  celular1 VARCHAR(11),
                                  celular2 VARCHAR(11),
                                  foto_perfil LONGBLOB,
                                  nome VARCHAR(40),
                                  sobrenome VARCHAR(70),
                                  dt_nascimento DATE,
                                  rg VARCHAR(9),
                                  dt_registro DATE,
                                  ativo BOOL,
                                  dt_criacao DATE,
                                  dt_alteracao DATE,
                                  dt_exclusao DATE,
                                  PRIMARY KEY (id_usuario),
                                  FOREIGN KEY (id_usuario) REFERENCES tb_usuarios(id_usuario),
                                  FOREIGN KEY (id_funcao) REFERENCES tb_funcao(id_funcao)
);

CREATE TABLE tb_enderecos (
                              id_endereco INTEGER AUTO_INCREMENT,
                              cep VARCHAR(8),
                              rua VARCHAR(60),
                              nro_casa INTEGER,
                              bairro VARCHAR(60),
                              complemento VARCHAR(60),
                              dt_criacao DATE,
                              dt_alteracao DATE,
                              dt_exclusao DATE,
                              PRIMARY KEY (id_endereco)
);

CREATE TABLE tb_tipos_doacoes (
                                  id_tipo_doacao INTEGER NOT NULL AUTO_INCREMENT,
                                  nm_tipo_doacao VARCHAR(30),
                                  dt_criacao DATE,
                                  dt_alteracao DATE,
                                  dt_exclusao DATE,

                                  CONSTRAINT pk_tb_tipos_doacoes_id_tipo_doacao PRIMARY KEY(id_tipo_doacao)
);

CREATE TABLE tb_doacoes (
                            id_doacao INTEGER NOT NULL AUTO_INCREMENT,
                            id_tipo_doacao INTEGER,
                            dt_criacao DATE,
                            dt_alteracao DATE,
                            dt_exclusao DATE,

                            CONSTRAINT pk_tb_doacoes_id_doacao PRIMARY KEY(id_doacao),
                            CONSTRAINT fk_tb_doacoes_id_tipo_doacao FOREIGN KEY(id_tipo_doacao) REFERENCES tb_tipos_doacoes(id_tipo_doacao)
);

CREATE TABLE tb_materiais (
                              id_material INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                              nm_material VARCHAR(50),
                              quantidade INTEGER,
                              ds_material VARCHAR(70),
                              dt_criacao DATE,
                              dt_alteracao DATE,
                              dt_exclusao DATE
);

CREATE TABLE tb_materiais_comprados (
                                        id_compra INT NOT NULL AUTO_INCREMENT,
                                        id_material INTEGER,
                                        quantidade INTEGER,
                                        vlr_pago DECIMAL(7,2),
                                        dt_criacao DATE,
                                        dt_alteracao DATE,
                                        dt_exclusao DATE,

                                        PRIMARY KEY (id_compra),
                                        FOREIGN KEY (id_material) REFERENCES tb_materiais(id_material)
);

CREATE TABLE tb_obras(
                         id_obra INTEGER,
                         id_endereco INTEGER,
                         dt_inicio DATE,
                         dt_termino DATE,
                         situacao_contrucao VARCHAR(20),
                         custo_estimado DECIMAL(8,2),
                         custo_total DECIMAL(8,2),
                         dt_criacao DATE,
                         dt_alteracao DATE,
                         dt_exclusao DATE,

                         CONSTRAINT pk_tb_obras_id_obra PRIMARY KEY(id_obra)
);


CREATE TABLE tb_produtos_outlet (
                                    id_prod_outlet INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                    id_doacao VARCHAR(5),
                                    ds_prod_outlet VARCHAR(100),
                                    nm_produto_outlet VARCHAR(60),
                                    status VARCHAR(20),
                                    dt_criacao DATE,
                                    dt_alteracao DATE,
                                    dt_exclusao DATE
);


CREATE TABLE tb_trocas (
                           id_troca INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           id_prod_outlet INTEGER,
                           ds_troca VARCHAR(100),
                           dt_criacao DATE,
                           dt_alteracao DATE,
                           dt_exclusao DATE,

                           FOREIGN KEY (id_prod_outlet) REFERENCES tb_produtos_outlet(id_prod_outlet)
);


CREATE TABLE tb_vendas (
                           id_venda INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           id_prod_outlet INTEGER,
                           valor_venda DECIMAL(7,2),
                           ds_venda VARCHAR(100),
                           dt_criacao DATE,
                           dt_alteracao DATE,
                           dt_exclusao DATE,

                           FOREIGN KEY (id_prod_outlet) REFERENCES tb_produtos_outlet(id_prod_outlet)
);


CREATE TABLE tb_abatimentos (
                                id_abatimento INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                id_troca INTEGER,
                                ds_abatimento VARCHAR(100),
                                valor_abatido DECIMAL(7,2),
                                FOREIGN KEY (id_troca) REFERENCES tb_trocas(id_troca)
);

CREATE TABLE tb_receitas(
                            id_receita INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            id_doacao INTEGER,
                            id_venda INTEGER,
                            id_abatimento INTEGER,
                            dt_recebimento DATE,
                            dt_vencimento DATE,
                            dt_criacao DATE,
                            dt_alteracao DATE,
                            dt_exclusao DATE,
                            FOREIGN KEY (id_doacao) REFERENCES tb_doacoes(id_doacao),
                            FOREIGN KEY (id_venda) REFERENCES tb_vendas(id_venda),
                            FOREIGN KEY (id_abatimento) REFERENCES tb_abatimentos(id_abatimento)
);

CREATE TABLE tb_despesas(
                            id_despesa INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            id_compra INTEGER,
                            id_obra INTEGER,
                            dt_recebimento DATE,
                            dt_vencimento DATE,
                            dt_criacao DATE,
                            dt_alteracao DATE,
                            dt_exclusao DATE,

                            FOREIGN KEY (id_compra) REFERENCES tb_materiais_comprados(id_compra),
                            FOREIGN KEY (id_obra) REFERENCES tb_obras(id_obra)
);

CREATE TABLE tb_movimentacoes (
                                  id_movimentacao INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                  id_receita INTEGER,
                                  id_despesa INTEGER,
                                  dt_criacao DATE,
                                  dt_alteracao DATE,
                                  dt_exclusao DATE,
                                  FOREIGN KEY (id_receita) REFERENCES tb_receitas(id_receita),
                                  FOREIGN KEY (id_despesa) REFERENCES tb_despesas(id_despesa)
);

CREATE TABLE tb_notas_fiscais (
                                  id_nota_fiscal INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                  id_movimentacao INTEGER,
                                  foto_nota_fiscal LONGBLOB,
                                  dt_criacao DATE,
                                  dt_alteracao DATE,
                                  dt_exclusao DATE,

                                  FOREIGN KEY (id_movimentacao) REFERENCES tb_movimentacoes(id_movimentacao)
);