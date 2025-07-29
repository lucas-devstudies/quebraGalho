CREATE DATABASE quebraGalho;
USE quebraGalho;
drop database quebragalho;
CREATE TABLE usuario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    tipo ENUM('administrador', 'vendedor') NOT NULL
);

CREATE TABLE administrador (
    id BIGINT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES usuario(id) ON DELETE CASCADE
);

CREATE TABLE vendedor (
    id BIGINT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES usuario(id) ON DELETE CASCADE
);

CREATE TABLE profissao (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE vendedor_profissao (
    vendedor_id BIGINT NOT NULL,
    profissao_id BIGINT NOT NULL,
    PRIMARY KEY (vendedor_id, profissao_id),
    FOREIGN KEY (vendedor_id) REFERENCES vendedor(id) ON DELETE CASCADE,
    FOREIGN KEY (profissao_id) REFERENCES profissao(id) ON DELETE CASCADE
);

CREATE TABLE avaliacao (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nota INT NOT NULL CHECK (nota BETWEEN 1 AND 5),
    titulo varchar(255),
    descricao VARCHAR(255),
    vendedor_id BIGINT NOT NULL,
    FOREIGN KEY (vendedor_id) REFERENCES vendedor(id) ON DELETE CASCADE
);

select * from administrador;

-- Usuários
INSERT INTO usuario (cpf, nome, email, senha, tipo) VALUES
('12345678901', 'João Silva', 'joao@example.com', 'senha123', 'administrador'),
('23456789012', 'Maria Oliveira', 'maria@example.com', 'senha456', 'vendedor'),
('34567890123', 'Pedro Santos', 'pedro@example.com', 'senha789', 'vendedor');

-- Administrador (id deve corresponder ao id do usuário administrador)
INSERT INTO administrador (id)
SELECT id FROM usuario WHERE cpf = '12345678901';

-- Vendedores
INSERT INTO vendedor (id)
SELECT id FROM usuario WHERE cpf IN ('23456789012', '34567890123');

-- Profissões
INSERT INTO profissao (nome) VALUES
('eletricista'),
('encanador'),
('pintor'),
('pedreiro');

-- Associação vendedor_profissao
-- Maria: eletricista e pintor
INSERT INTO vendedor_profissao (vendedor_id, profissoes_id)
SELECT v.id, p.id FROM vendedor v, profissao p
WHERE v.id = (SELECT id FROM usuario WHERE cpf = '23456789012') AND p.nome IN ('eletricista', 'pintor');

-- Pedro: encanador e pedreiro
INSERT INTO vendedor_profissao (vendedor_id, profissoes_id)
SELECT v.id, p.id FROM vendedor v, profissao p
WHERE v.id = (SELECT id FROM usuario WHERE cpf = '34567890123') AND p.nome IN ('encanador', 'pedreiro');

-- Avaliações para os vendedores
INSERT INTO avaliacao (nota, titulo,descricao, vendedor_id) VALUES
(5, 'Excelente serviço, muito profissional.','realmente valeu cada centavo. Ficou perfeito.', (SELECT id FROM usuario WHERE cpf = '23456789012')),
(4, 'Bom atendimento, recomendo.','Cara bom e serviço bom.', (SELECT id FROM usuario WHERE cpf = '23456789012')),
(3, 'Serviço razoável, poderia melhorar.','cobrou caro para algo simples.', (SELECT id FROM usuario WHERE cpf = '34567890123'));

select * from vendedor;