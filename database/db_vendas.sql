CREATE
DATABASE sistema_vendas;
USE
sistema_vendas;

CREATE TABLE fornecedores
(
    id_fornecedor       INT AUTO_INCREMENT PRIMARY KEY,
    nome_fornecedor     VARCHAR(150)       NOT NULL,
    cpf_ou_cnpj         VARCHAR(11) UNIQUE NOT NULL,
    telefone_fornecedor VARCHAR(20),
    email_fornecedor    VARCHAR(100),
    endereco_fornecedor VARCHAR(255),
    criado_em           TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ==========================================================
-- TABELA: PRODUTOS (Módulo 2)
-- ==========================================================
CREATE TABLE produtos
(
    id_produto         INT AUTO_INCREMENT PRIMARY KEY,
    id_fornecedor      INT,
    nome_produto       VARCHAR(100)   NOT NULL,
    preco_produto      DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    quantidade_estoque INT            NOT NULL DEFAULT 0,
    criado_em          TIMESTAMP               DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_fornecedor) REFERENCES fornecedores (id_fornecedor)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);
-- ==========================================================
-- TABELA: ENTRADAS DE ESTOQUE (Módulo 4)
-- ==========================================================
CREATE TABLE entradas
(
    id_entrada           INT AUTO_INCREMENT PRIMARY KEY,
    id_produto           INT            NOT NULL,
    quantidade           INT            NOT NULL,
    preco_custo_unitario DECIMAL(10, 2) NOT NULL,
    data_entrada         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (id_produto) REFERENCES produtos (id_produto) ON DELETE CASCADE
);
-- ==========================================================
-- TABELA: VENDAS - CABEÇALHO (Módulo 5)
-- Registra o recibo/venda geral
-- ==========================================================
CREATE TABLE vendas
(
    id_venda        INT AUTO_INCREMENT PRIMARY KEY,
    data_venda      TIMESTAMP               DEFAULT CURRENT_TIMESTAMP,
    valor_total     DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    forma_pagamento ENUM('Dinheiro', 'Cartao_Credito', 'Cartao_Debito', 'Pix') NOT NULL
);

-- ==========================================================
-- TABELA: ITENS DA VENDA (Módulo 5)
-- Detalha os produtos vendidos em cada recibo
-- ==========================================================
CREATE TABLE itens_venda
(
    id_item        INT AUTO_INCREMENT PRIMARY KEY,
    id_venda       INT            NOT NULL,
    id_produto     INT            NOT NULL,
    quantidade     INT            NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    subtotal       DECIMAL(10, 2) NOT NULL,

    FOREIGN KEY (id_venda) REFERENCES vendas (id_venda) ON DELETE CASCADE,
    FOREIGN KEY (id_produto) REFERENCES produtos (id_produto)
);

INSERT INTO fornecedores (nome_fornecedor, cpf_ou_cnpj, telefone_fornecedor, email_fornecedor, endereco_fornecedor)
VALUES ('Distribuidora Silva LTDA', '12345678901', '(11) 98765-4321', 'contato@distribuidorasilva.com',
        'Rua das Flores, 123 - São Paulo/SP'),
       ('Atacado Central EIRELI', '98765432100', '(21) 99876-5432', 'vendas@atacadocentral.com',
        'Av. Brasil, 456 - Rio de Janeiro/RJ'),
       ('Comércio de Alimentos Costa', '45678912300', '(31) 97654-3210', 'financeiro@costaalimentos.com',
        'Rua Bahia, 789 - Belo Horizonte/MG');