
CREATE DATABASE OpticaCulDAmpolla;

USE OpticaCulDAmpolla;

CREATE TABLE Adreces (
    adreca_id INT AUTO_INCREMENT PRIMARY KEY,
    carrer VARCHAR(100) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    pis VARCHAR(10),
    porta VARCHAR(10),
    ciutat VARCHAR(50) NOT NULL,
    codi_postal VARCHAR(10) NOT NULL,
    pais VARCHAR(50) NOT NULL
);

CREATE TABLE Proveidors (
    proveidor_id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    adreca_id INT,
    marca_id INT,
    telefon VARCHAR(15),
    fax VARCHAR(15),
    nif VARCHAR(15) NOT NULL,
    FOREIGN KEY (adreca_id) REFERENCES Adreces(adreca_id),
    FOREIGN KEY (marca_id) REFERENCES Marcas(marca_id)

);

CREATE TABLE Clients (
    client_id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    adreca_id INT,
    telefon VARCHAR(15),
    correu_electronic VARCHAR(100),
    data_registre DATE NOT NULL,
    client_recomanador_id INT,
    FOREIGN KEY (adreca_id) REFERENCES Adreces(adreca_id),
    FOREIGN KEY (client_recomanador_id) REFERENCES Clients(client_id)
);

CREATE TABLE Empleats (
    empleat_id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    adreca_id INT,
    telefon VARCHAR(15),
    correu_electronic VARCHAR(100),
    FOREIGN KEY (adreca_id) REFERENCES Adreces(adreca_id)
);

CREATE TABLE Ulleres (
    ullera_id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(100) NOT NULL,
    graduacio_vidre_dret FLOAT NOT NULL,
    graduacio_vidre_esquerre FLOAT NOT NULL,
    tipus_muntura ENUM('flotant', 'pasta', 'metàl·lica') NOT NULL,
    color_muntura VARCHAR(30) NOT NULL,
    color_vidre_dret VARCHAR(30) NOT NULL,
    color_vidre_esquerre VARCHAR(30) NOT NULL,
    preu DECIMAL(10, 2) NOT NULL,
    proveidor_id INT,
    marca_id INT,
    FOREIGN KEY (proveidor_id) REFERENCES Proveidors(proveidor_id),
    FOREIGN KEY (marca_id) REFERENCES Marcas(marca_id)
);


CREATE TABLE Marcas (
    marca_id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE Vendes (
    venda_id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    ullera_id INT,
    empleat_id INT,
    data_venda DATE NOT NULL,
    FOREIGN KEY (client_id) REFERENCES Clients(client_id),
    FOREIGN KEY (ullera_id) REFERENCES Ulleres(ullera_id),
    FOREIGN KEY (empleat_id) REFERENCES Empleats(empleat_id)
);

-- Insertar dades a la taula Adreces
INSERT INTO Adreces (carrer, numero, pis, porta, ciutat, codi_postal, pais) VALUES 
('Carrer Major', '12', '3', 'A', 'Barcelona', '08001', 'Espanya'),
('Avinguda Diagonal', '456', NULL, NULL, 'Barcelona', '08013', 'Espanya'),
('Passeig de Gràcia', '34', '2', 'B', 'Barcelona', '08007', 'Espanya');

-- Insertar dades a la taula Proveidors
INSERT INTO Proveidors (nom, adreca_id, telefon, fax, nif) VALUES 
('GafasNet', 1, '932000000', '932000001', 'A12345678'),
('GafasOnline', 2, '933000000', '933000001', 'B12345678'),
('ESunglasses', 3, '934000000', '934000001', 'C12345678');

-- Insertar dades a la taula Clients
INSERT INTO Clients (nom, adreca_id, telefon, correu_electronic, data_registre, client_recomanador_id) VALUES 
('Claudia', 1, '600000000', 'claudia@example.com', '2023-01-10', NULL),
('David', 2, '600000001', 'david@example.com', '2023-02-15', 1),
('Carlos', 3, '600000002', 'carlos@example.com', '2023-03-20', 2);

-- Insertar dades a la taula Empleats
INSERT INTO Empleats (nom, adreca_id, telefon, correu_electronic) VALUES 
('Juan', 1, '610000000', 'empleat1@example.com'),
('Laura', 2, '610000001', 'empleat2@example.com'),
('Jose', 3, '610000002', 'empleat3@example.com');

-- Insertar dades a la taula Ulleres
INSERT INTO Ulleres (marca, graduacio_vidre_dret, graduacio_vidre_esquerre, tipus_muntura, color_muntura, color_vidre_dret, color_vidre_esquerre, preu, proveidor_id) VALUES 
('Adidas', 1.0, 1.5, 'pasta', 'negre', 'transparent', 'transparent', 100.00, 1),
('Fendi', 2.0, 2.5, 'metàl·lica', 'platejat', 'blau', 'blau', 150.00, 2),
('Channel', 1.75, 2.25, 'flotant', 'negre', 'verd', 'verd', 200.00, 3),
('Gucci', 1.3, 1.2, 'pasta', 'negre', 'blanc', 'vermell', 300.00, 1);

-- Insertar dades a la taula Vendes
INSERT INTO Vendes (client_id, ullera_id, empleat_id, data_venda) VALUES 
(1, 1, 1, '2023-04-10'),
(2, 2, 2, '2023-05-15'),
(3, 3, 3, '2023-06-20'),
(1, 2, 1, '2024-02-23');

-- Consulta total de factures d'un client en un periode determinat --
SELECT 
    v.venda_id, 
    v.data_venda, 
    u.marca, 
    u.preu,
    c.nom AS client_nom
FROM 
    Vendes v 
JOIN 
    Ulleres u ON v.ullera_id = u.ullera_id 
JOIN 
    Clients c ON v.client_id = c.client_id
WHERE 
    v.client_id = 1 
    AND v.data_venda BETWEEN '2022-01-01' AND '2023-12-31';

-- Consulta diferents models d'ulleres que ha venut un empleat durant un any --
SELECT 
    e.nom AS nom_empleat,
    u.marca, 
    u.tipus_muntura, 
    u.color_muntura, 
    COUNT(v.venda_id) AS total_vendes 
FROM 
    Vendes v 
JOIN 
    Ulleres u ON v.ullera_id = u.ullera_id 
JOIN 
    Empleats e ON v.empleat_id = e.empleat_id
WHERE 
    v.empleat_id = 1 
   AND v.data_venda BETWEEN '2023-01-01' AND '2024-12-31'
GROUP BY 
    e.nom, u.marca, u.tipus_muntura, u.color_muntura;

-- Consulta diferents proveidors que han suministrat ulleres venudes amb exit --
SELECT DISTINCT 
    p.nom, 
    a.carrer, 
    a.numero, 
    a.pis, 
    a.porta, 
    a.ciutat, 
    a.codi_postal, 
    a.pais, 
    p.telefon, 
    p.fax, 
    p.nif 
FROM 
    Vendes v 
JOIN 
    Ulleres u ON v.ullera_id = u.ullera_id 
JOIN 
    Proveidors p ON u.proveidor_id = p.proveidor_id 
JOIN 
    Adreces a ON p.adreca_id = a.adreca_id;

