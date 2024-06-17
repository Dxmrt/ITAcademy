-- Crear base de datos
CREATE DATABASE IF NOT EXISTS Pizzeria;
USE Pizzeria;

-- Crear tabla Provincies
CREATE TABLE IF NOT EXISTS Provincies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL
);

-- Crear tabla Localitats
CREATE TABLE IF NOT EXISTS Localitats (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    provincia_id INT,
    FOREIGN KEY (provincia_id) REFERENCES Provincies(id)
);

-- Crear tabla Clients
CREATE TABLE IF NOT EXISTS Clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    cognoms VARCHAR(255) NOT NULL,
    adreca VARCHAR(255) NOT NULL,
    codi_postal VARCHAR(10) NOT NULL,
    localitat_id INT,
    telefon VARCHAR(20),
    FOREIGN KEY (localitat_id) REFERENCES Localitats(id)
);

-- Crear tabla Botigues
CREATE TABLE IF NOT EXISTS Botigues (
    id INT AUTO_INCREMENT PRIMARY KEY,
    adreca VARCHAR(255) NOT NULL,
    codi_postal VARCHAR(10) NOT NULL,
    localitat_id INT,
    FOREIGN KEY (localitat_id) REFERENCES Localitats(id)
);

-- Crear tabla Categories
CREATE TABLE IF NOT EXISTS Categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL
);

-- Crear tabla Productes
CREATE TABLE IF NOT EXISTS Productes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    descripcio TEXT,
    imatge VARCHAR(255),
    preu DECIMAL(10, 2) NOT NULL,
    tipus_producte ENUM('Begudes','Hamburgueses','Pizzes') NOT NULL,
    categoria_id INT,
    FOREIGN KEY (categoria_id) REFERENCES Categories(id)
);

-- Crear tabla Comandes
CREATE TABLE IF NOT EXISTS Comandes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    data_hora DATETIME NOT NULL,
    tipus_enviament ENUM('domicili', 'botiga') NOT NULL,
    preu_total DECIMAL(10, 2) NOT NULL,
    botiga_id INT,
    FOREIGN KEY (client_id) REFERENCES Clients(id),
    FOREIGN KEY (botiga_id) REFERENCES Botigues(id)
);

-- Crear tabla Comanda_Producte
CREATE TABLE IF NOT EXISTS Comanda_Producte (
    comanda_id INT,
    producte_id INT,
    quantitat INT NOT NULL,
    PRIMARY KEY (comanda_id, producte_id),
    FOREIGN KEY (comanda_id) REFERENCES Comandes(id),
    FOREIGN KEY (producte_id) REFERENCES Productes(id)
);

-- Crear tabla Empleats
CREATE TABLE IF NOT EXISTS Empleats (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    cognoms VARCHAR(255) NOT NULL,
    nif VARCHAR(20) NOT NULL,
    telefon VARCHAR(20),
    posicio ENUM('cuiner', 'repartidor') NOT NULL,
    botiga_id INT,
    FOREIGN KEY (botiga_id) REFERENCES Botigues(id)
);

-- Crear tabla Lliuraments
CREATE TABLE IF NOT EXISTS Lliuraments (
    comanda_id INT,
    empleat_id INT,
    data_hora_lliurament DATETIME,
    PRIMARY KEY (comanda_id),
    FOREIGN KEY (comanda_id) REFERENCES Comandes(id),
    FOREIGN KEY (empleat_id) REFERENCES Empleats(id)
);


-- Insertar datos en la tabla Provincies
INSERT INTO Provincies (nom) VALUES 
('Barcelona'), 
('Madrid'), 
('Valencia');

-- Insertar datos en la tabla Localitats
INSERT INTO Localitats (nom, provincia_id) VALUES 
('Barcelona', 1), 
('Hospitalet', 1), 
('Madrid', 2), 
('Valencia', 3);

-- Insertar datos en la tabla Clients
INSERT INTO Clients (nom, cognoms, adreca, codi_postal, localitat_id, telefon) VALUES 
('Juan', 'Perez', 'Calle Falsa 123', '08001', 1, '123456789'),
('Ana', 'Garcia', 'Avenida Siempre Viva 742', '08002', 2, '987654321');

-- Insertar datos en la tabla Botigues
INSERT INTO Botigues (adreca, codi_postal, localitat_id) VALUES 
('Carrer de les Pizzes 1', '08003', 1),
('Carrer de les Pizzes 2', '28001', 3);

-- Insertar datos en la tabla Categories
INSERT INTO Categories (nom) VALUES 
('Pizza'), 
('Begudes'), 
('Hamburgueses');

-- Insertar datos en la tabla Productes
INSERT INTO Productes (nom, descripcio, imatge, preu, categoria_id) VALUES 
('Pizza Margarita', 'Deliciosa pizza con tomate y mozzarella', 'imagen1.jpg', 8.50, 1),
('Coca-Cola', 'Bebida refrescante de cola', 'imagen2.jpg', 1.50, 2),
('Bacon Cheese', 'Hamburguesa de bacon con queso', 'imagen3.jpg', 3.00, 3);

-- Insertar datos en la tabla Comandes
INSERT INTO Comandes (client_id, data_hora, tipus_enviament, preu_total, botiga_id) VALUES 
(1, '2023-06-01 12:30:00', 'domicili', 10.00, 1),
(2, '2023-06-02 13:00:00', 'botiga', 5.00, 2);

-- Insertar datos en la tabla Comanda_Producte
INSERT INTO Comanda_Producte (comanda_id, producte_id, quantitat) VALUES 
(1, 1, 1),
(1, 2, 1),
(2, 3, 1);

-- Insertar datos en la tabla Empleats
INSERT INTO Empleats (nom, cognoms, nif, telefon, posicio, botiga_id) VALUES 
('Carlos', 'Lopez', '12345678A', '111222333', 'cuiner', 1),
('Maria', 'Martinez', '87654321B', '444555666', 'repartidor', 2);

-- Insertar datos en la tabla Lliuraments
INSERT INTO Lliuraments (comanda_id, empleat_id, data_hora_lliurament) VALUES 
(1, 2, '2023-06-01 13:00:00');

-- Insertar pedidos adicionales con productos de la categoría 'Begudes'
INSERT INTO Comandes (client_id, data_hora, tipus_enviament, preu_total, botiga_id) VALUES 
(1, '2023-06-03 14:00:00', 'domicili', 3.00, 1),
(2, '2023-06-04 15:00:00', 'botiga', 1.50, 2);

INSERT INTO Comanda_Producte (comanda_id, producte_id, quantitat) VALUES 
(3, 2, 2),
(4, 2, 1);

INSERT INTO Lliuraments (comanda_id, empleat_id, data_hora_lliurament) VALUES
(3, 2, '2023-06-03 14:30:00'),
(4, 2, '2023-06-04 15:30:00');

-- Crear vista para productos de categoría 'Begudes'
CREATE VIEW Productes_Begudes AS
SELECT p.id AS producte_id, p.nom AS producte_nom, c.nom AS categoria_nom
FROM Productes p
JOIN Categories c ON p.categoria_id = c.id
WHERE c.nom = 'Begudes';

-- Consulta para contar cuántos productos de la categoría 'Begudes' se han vendido en una determinada localitat
SELECT l.nom AS localitat, COUNT(cp.producte_id) AS total_begudes
FROM Comanda_Producte cp
JOIN Comandes c ON cp.comanda_id = c.id
JOIN Clients cl ON c.client_id = cl.id
JOIN Localitats l ON cl.localitat_id = l.id
JOIN Productes_Begudes pb ON cp.producte_id = pb.producte_id
WHERE l.nom = 'Barcelona'
GROUP BY l.nom;

-- Consulta para contar cuántas comandes ha efectuado un determinado empleado
SELECT e.nom AS empleat_nom, e.cognoms AS empleat_cognoms, COUNT(l.comanda_id) AS total_comandes
FROM Lliuraments l
JOIN Empleats e ON l.empleat_id = e.id
GROUP BY e.nom, e.cognoms;