create database bahiatour;
use bahiatour;

CREATE TABLE Usuarios (
	id_usuario INT PRIMARY KEY auto_increment,
	nome VARCHAR(100),
    email VARCHAR(100),
    telefone VARCHAR(100),
    senha VARCHAR(100)
);

CREATE TABLE Reservas (
	id_reserva INT PRIMARY KEY auto_increment,
    data_inicio DATE,
    data_fim DATE,
    qtd_pessoa INTEGER,
    status_reserva VARCHAR(20),
    fk_usuario INT,
    fk_pacote INT
);

CREATE TABLE Pagamentos (
	id_pagamento INT PRIMARY KEY auto_increment,
    tipo VARCHAR(20),
    valor DECIMAL(5,2),
    fk_reserva INT
);

CREATE TABLE Pacotes (
	id_pacote INT PRIMARY KEY auto_increment,
    preco DECIMAL(5,2),
    destino VARCHAR(100)
);
 
ALTER TABLE Reservas ADD FOREIGN KEY (fk_usuario)
    REFERENCES Usuarios (id_usuario);
ALTER TABLE Reservas ADD FOREIGN KEY (fk_pacote)
    REFERENCES Pacotes (id_pacote);
ALTER TABLE Pagamentos ADD FOREIGN KEY (fk_reserva)
    REFERENCES Reservas (id_reserva);
    
    select * from Usuarios;
    select * from Pacotes;
    select * from Reservas;
    select * from Pagamentos;
    
    
-- Dados de teste
INSERT INTO Usuarios (nome, email, telefone, senha)
VALUES ('Carlos', 'carlos@email.com', '(11) 1234-5678', '123'),
       ('Maria Santos', 'maria@email.com', '(22) 9876-5432', '456');
INSERT INTO Pacotes (preco, destino)
VALUES (100.00, 'Ilha dos Frades'),
       (150.00, 'Capim Grosso');
INSERT INTO Reservas (data_inicio, data_fim, qtd_pessoa, status_reserva, fk_usuario, fk_pacote)
VALUES ('2023-11-01', '2023-11-10', 2, 'Regular', 1, 1),
       ('2023-12-05', '2023-12-12', 3, 'Pendente', 2, 2);
INSERT INTO Pagamentos (tipo, valor, fk_reserva)
VALUES ('Cartão', 90.00, 5),
       ('Pix', 120.00, 6);

CREATE VIEW ReservaUsuarioPacote AS
SELECT
    R.id_reserva, U.nome, P.destino, R.data_inicio, R.data_fim, R.status_reserva
FROM
    Reservas R
    JOIN Usuarios U ON R.fk_usuario = U.id_usuario
    JOIN Pacotes P ON R.fk_pacote = P.id_pacote;
