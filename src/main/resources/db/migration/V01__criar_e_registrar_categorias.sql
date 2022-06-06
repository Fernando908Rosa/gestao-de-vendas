CREATE TABLE categoria (
    codigo BIGINT PRIMARY KEY AUTO_INCREMENT, 
    nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8mb4;

INSERT INTO categoria (nome) values ('Tecnologia');
INSERT INTO categoria (nome) values ('Acessórios para veículos');
INSERT INTO categoria (nome) values ('Esporte e Lazer');
INSERT INTO categoria (nome) values ('Casa e Elotrodomésticos');
INSERT INTO categoria (nome) values ('Joias e relógios');