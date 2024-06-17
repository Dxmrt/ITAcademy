CREATE DATABASE IF NOT EXISTS Youtube;
USE Youtube;

-- Crear tabla Usuaris
CREATE TABLE IF NOT EXISTS Usuaris (
    email VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    nom VARCHAR(255) NOT NULL,
    data_naixement DATE NOT NULL,
    sexe ENUM('M', 'F') NOT NULL,
    pais VARCHAR(255) NOT NULL,
    codi_postal VARCHAR(10) NOT NULL
);

-- Crear tabla Videos
CREATE TABLE IF NOT EXISTS Videos (
    video_id INT AUTO_INCREMENT PRIMARY KEY,
    titol VARCHAR(255) NOT NULL,
    descripcio TEXT,
    grandaria DECIMAL(10, 2),
    nom_arxiu VARCHAR(255) NOT NULL,
    durada TIME NOT NULL,
    thumbnail VARCHAR(255),
    nombre_reproduccions INT DEFAULT 0,
    num_likes INT DEFAULT 0,
    num_dislikes INT DEFAULT 0,
    estat ENUM('public', 'ocult', 'privat') NOT NULL,
    usuari_email VARCHAR(255),
    data_hora_publicacio DATETIME NOT NULL,
    FOREIGN KEY (usuari_email) REFERENCES Usuaris(email)
);

-- Crear tabla Etiquetes
CREATE TABLE IF NOT EXISTS Etiquetes (
    etiqueta_id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL
);

-- Crear tabla Video_Etiquetes
CREATE TABLE IF NOT EXISTS Video_Etiquetes (
    video_id INT,
    etiqueta_id INT,
    PRIMARY KEY (video_id, etiqueta_id),
    FOREIGN KEY (video_id) REFERENCES Videos(video_id),
    FOREIGN KEY (etiqueta_id) REFERENCES Etiquetes(etiqueta_id)
);

-- Crear tabla Canals
CREATE TABLE IF NOT EXISTS Canals (
    canal_id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    descripcio TEXT,
    data_creacio DATE NOT NULL,
    usuari_email VARCHAR(255),
    FOREIGN KEY (usuari_email) REFERENCES Usuaris(email)
);

-- Crear tabla Subscricions
CREATE TABLE IF NOT EXISTS Subscricions (
    usuari_email VARCHAR(255),
    canal_id INT,
    PRIMARY KEY (usuari_email, canal_id),
    FOREIGN KEY (usuari_email) REFERENCES Usuaris(email),
    FOREIGN KEY (canal_id) REFERENCES Canals(canal_id)
);

-- Crear tabla Likes_Dislikes_Videos
CREATE TABLE IF NOT EXISTS Likes_Dislikes_Videos (
    usuari_email VARCHAR(255),
    video_id INT,
    tipus ENUM('like', 'dislike') NOT NULL,
    data_hora DATETIME NOT NULL,
    PRIMARY KEY (usuari_email, video_id),
    FOREIGN KEY (usuari_email) REFERENCES Usuaris(email),
    FOREIGN KEY (video_id) REFERENCES Videos(video_id)
);

-- Crear tabla Playlists
CREATE TABLE IF NOT EXISTS Playlists (
    playlist_id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    data_creacio DATE NOT NULL,
    estat ENUM('publica', 'privada') NOT NULL,
    usuari_email VARCHAR(255),
    FOREIGN KEY (usuari_email) REFERENCES Usuaris(email)
);

-- Crear tabla Playlist_Videos
CREATE TABLE IF NOT EXISTS Playlist_Videos (
    playlist_id INT,
    video_id INT,
    PRIMARY KEY (playlist_id, video_id),
    FOREIGN KEY (playlist_id) REFERENCES Playlists(playlist_id),
    FOREIGN KEY (video_id) REFERENCES Videos(video_id)
);

-- Crear tabla Comentaris
CREATE TABLE IF NOT EXISTS Comentaris (
    comentari_id INT AUTO_INCREMENT PRIMARY KEY,
    text TEXT NOT NULL,
    data_hora DATETIME NOT NULL,
    usuari_email VARCHAR(255),
    video_id INT,
    FOREIGN KEY (usuari_email) REFERENCES Usuaris(email),
    FOREIGN KEY (video_id) REFERENCES Videos(video_id)
);

-- Crear tabla Likes_Dislikes_Comentaris
CREATE TABLE IF NOT EXISTS Likes_Dislikes_Comentaris (
    usuari_email VARCHAR(255),
    comentari_id INT,
    tipus ENUM('like', 'dislike') NOT NULL,
    data_hora DATETIME NOT NULL,
    PRIMARY KEY (usuari_email, comentari_id),
    FOREIGN KEY (usuari_email) REFERENCES Usuaris(email),
    FOREIGN KEY (comentari_id) REFERENCES Comentaris(comentari_id)
);

-- Insertar datos en la tabla Usuaris
INSERT INTO Usuaris (email, password, nom, data_naixement, sexe, pais, codi_postal) VALUES
('josep@example.com', 'password345', 'Josep Gonzalez', '1990-01-01', 'M', 'Espanya', '08001'),
('laura@example.com', 'password123', 'Laura Lopez', '1992-02-02', 'F', 'Espanya', '08002');

-- Insertar datos en la tabla Videos
INSERT INTO Videos (titol, descripcio, grandaria, nom_arxiu, durada, thumbnail, nombre_reproduccions, num_likes, num_dislikes, estat, usuari_email, data_hora_publicacio) VALUES 
('Video Gatitos', 'Descripció del video 1', 100.50, 'video1.mp4', '00:05:00', 'thumb1.jpg', 10, 5, 1, 'public', 'josep@example.com', '2023-01-01 10:00:00'),
('Video Pasteles', 'Descripció del video 2', 200.75, 'video2.mp4', '00:10:00', 'thumb2.jpg', 20, 10, 2, 'public', 'laura@example.com', '2023-02-01 11:00:00');

-- Consulta de usuarios y sus videos --
SELECT 
    u.nom AS nom_usuari,
    v.titol AS titol_video,
    v.data_hora_publicacio
FROM 
    Usuaris u
JOIN 
    Videos v ON u.email = v.usuari_email;

-- Insertar datos en la tabla Etiquetes
INSERT INTO Etiquetes (nom) VALUES
('Mascotas'), ('Cocina');

-- Insertar datos en la tabla Video_Etiquetes
INSERT INTO Video_Etiquetes (video_id, etiqueta_id) VALUES
(1, 1), (1, 2), (1, 2);

-- Consulta de Videos y sus Etiquetas
SELECT 
    v.titol AS titol_video,
    e.nom AS nom_etiqueta
FROM 
    Videos v
JOIN 
    Video_Etiquetes ve ON v.video_id = ve.video_id
JOIN 
    Etiquetes e ON ve.etiqueta_id = e.etiqueta_id;
    
-- Consulta de canales y suscriptores --
-- Insertar datos en la tabla Canals
INSERT INTO Canals (nom, descripcio, data_creacio, usuari_email) VALUES
('Canal de Josep', 'Descripció del canal de Josep', '2023-01-01', 'josep@example.com'),
('Canal de Laura', 'Descripció del canal de Laura', '2023-02-01', 'laura@example.com');

-- Insertar datos en la tabla Subscricions
INSERT INTO Subscricions (usuari_email, canal_id) VALUES
('laura@example.com', 1), ('josep@example.com', 2);

-- Consulta de Canales y sus Suscriptores
SELECT 
    c.nom AS nom_canal,
    u.nom AS nom_usuari
FROM 
    Canals c
JOIN 
    Subscricions s ON c.canal_id = s.canal_id
JOIN 
    Usuaris u ON s.usuari_email = u.email;

