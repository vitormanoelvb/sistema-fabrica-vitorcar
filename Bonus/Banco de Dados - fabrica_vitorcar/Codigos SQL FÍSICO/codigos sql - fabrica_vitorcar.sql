-- 1. Cria o banco
CREATE DATABASE fabrica_vitorcar;
USE fabrica_vitorcar;

-- 2. Tabela de pessoas
CREATE TABLE pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE
);

-- 3. Tabela de carros
CREATE TABLE carro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(100) NOT NULL,
    placa VARCHAR(10) NOT NULL UNIQUE,
    ano INT NOT NULL,
    id_pessoa INT NOT NULL,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)
);

-- 4. Tabela de autorizações de menores
CREATE TABLE termo_autorizacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cpf_menor VARCHAR(14) NOT NULL,
    nome_responsavel VARCHAR(100) NOT NULL,
    cpf_responsavel VARCHAR(14) NOT NULL,
    data_autorizacao DATE NOT NULL,
    UNIQUE (cpf_menor)
);

-- 5. VIEW: Menores autorizados com dados do responsável
CREATE OR REPLACE VIEW vw_menores_autorizados AS
SELECT 
    p.nome AS nome_menor,
    p.cpf AS cpf_menor,
    p.idade,
    t.nome_responsavel,
    t.cpf_responsavel,
    t.data_autorizacao
FROM pessoa p
JOIN termo_autorizacao t ON p.cpf = t.cpf_menor;

-- 6. FUNCTION: Retorna se o CPF tem termo assinado
DELIMITER //

CREATE FUNCTION tem_termo_autorizacao(cpf_busca VARCHAR(14))
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
    DECLARE existe BOOLEAN;

    SET existe = EXISTS (
        SELECT 1 FROM termo_autorizacao WHERE cpf_menor = cpf_busca
    );

    RETURN existe;
END;
//

DELIMITER ;

-- 7. STORED PROCEDURE: Cadastrar nova pessoa com validação de CPF duplicado
DELIMITER //

CREATE PROCEDURE sp_cadastrar_pessoa (
    IN nome_in VARCHAR(100),
    IN idade_in INT,
    IN cpf_in VARCHAR(14)
)
BEGIN
    IF EXISTS (SELECT 1 FROM pessoa WHERE cpf = cpf_in) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'CPF já cadastrado.';
    ELSE
        INSERT INTO pessoa (nome, idade, cpf) VALUES (nome_in, idade_in, cpf_in);
    END IF;
END;
//

DELIMITER ;

-- 8. STORED PROCEDURE: Cadastrar carro (relacionado a pessoa)
DELIMITER //

CREATE PROCEDURE sp_cadastrar_carro (
    IN modelo_in VARCHAR(100),
    IN placa_in VARCHAR(10),
    IN ano_in INT,
    IN cpf_pessoa VARCHAR(14)
)
BEGIN
    DECLARE id_p INT;

    SELECT id INTO id_p FROM pessoa WHERE cpf = cpf_pessoa;

    IF id_p IS NOT NULL THEN
        INSERT INTO carro (modelo, placa, ano, id_pessoa)
        VALUES (modelo_in, placa_in, ano_in, id_p);
    ELSE
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'CPF não encontrado.';
    END IF;
END;
//

DELIMITER ;