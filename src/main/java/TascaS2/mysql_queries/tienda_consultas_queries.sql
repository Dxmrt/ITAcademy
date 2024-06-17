-- Consulta n1 Llista el nom de tots els productes que hi ha en la taula producto --
SELECT nombre FROM producto;
-- Consulta n2 Llista els noms i els preus de tots els productes de la taula producto --
SELECT nombre, precio FROM producto;
-- Consulta n3 Llista totes les columnes de la taula producto --
SELECT * FROM producto;
-- Consulta n4 Llista el nom dels productes, el preu en euros i el preu en dolars (USD) --
SELECT nombre, precio, precio * 1.1 AS precio_usd FROM producto;
-- Consulta n5 "" + Alias nom producto, euros, dolar --
SELECT nombre AS nom_de_producto, precio AS euros, precio * 1.1 AS dolars FROM producto;
-- Consulta n6 Llista els noms i els preus de tots els productes de la taula producto, convertint els noms a majus --
SELECT UPPER(nombre) AS nombre, precio FROM producto;
-- Consulta n7 Llista els noms i els preus de tots els productes de la taula producto, convertint els noms a minus --
SELECT LOWER(nombre) AS nombre, precio FROM producto;
-- Consulta n8 Llista el nom de tots els fabricants en una columna, i en una altra columna obtingui en majus els dos primers caracters del nom del fabricant --
SELECT nombre, UPPER(LEFT(nombre, 2)) AS primeros_dos_caracteres FROM fabricante;
-- Consulta n9 Llista els noms i els preus de tots els productes de la taula producto, arrodonint el valor del preu --
SELECT nombre, ROUND(precio, 2) AS precio FROM producto;
-- Consulta n10 Llista els noms i els preus de tots els productes de la taula producto, truncant el valor del preu per a mostrar-lo sense cap xifra decimal --
SELECT nombre, TRUNCATE(precio, 0) AS precio FROM producto;
-- Consulta n11 Llista el codi dels fabricants que tenen productes en la taula producto --
SELECT codigo_fabricante FROM producto;
-- Consulta n12 Llista el codi dels fabricants que tenen productes en la taula producto, eliminant els codis que apareixen repetits --
SELECT DISTINCT codigo_fabricante FROM producto;
-- Consulta n13 Llista els noms dels fabricants ordenats de manera ascendent --
SELECT nombre FROM fabricante ORDER BY nombre ASC;
-- Consulta n14 Llista els noms dels fabricants ordenats de manera descendent --
SELECT nombre FROM fabricante ORDER BY nombre DESC;
-- Consulta n15 Llista els noms dels productes ordenats, en primer lloc, pel nom de manera ascendent i, en segon lloc, pel preu de manera descendent --
SELECT nombre, precio FROM producto ORDER BY nombre ASC, precio DESC;
-- Consulta n16 Retorna una llista amb les 5 primeres files de la taula fabricante --
SELECT * FROM fabricante LIMIT 5;
-- Consulta n17 Retorna una llista amb 2 files a partir de la quarta fila de la taula fabricante. La quarta fila tambe s'ha d'incloure en la resposta --
SELECT * FROM fabricante LIMIT 3, 2;
-- Consulta n18 Llista el nom i el preu del producte més barat. (Utilitza solament les clàusules ORDER BY i LIMIT). NOTA: Aquí no podria usar MIN(preu), necessitaria GROUP BY --
SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1;
-- Consulta n19 Llista el nom i el preu del producte més car. (Utilitza solament les clàusules ORDER BY i LIMIT). NOTA: Aquí no podria usar MAX(preu), necessitaria GROUP BY --
SELECT nombre, precio FROM producto ORDER BY precio DESC LIMIT 1;
-- Consulta n20 Llista el nom de tots els productes del fabricant el codi de fabricant del qual és igual a 2 --
SELECT nombre FROM producto WHERE codigo_fabricante = 2;
-- Consulta n21 Retorna una llista amb el nom del producte, preu i nom de fabricant de tots els productes de la base de dades --
SELECT p.nombre AS nombre_producto, p.precio, f.nombre AS nombre_fabricante
FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo;
-- Consulta n22 Retorna una llista amb el nom del producte, preu i nom de fabricant de tots els productes de la base de dades. Ordena el resultat pel nom del fabricant, per ordre alfabètic --
SELECT p.nombre AS nombre_producto, p.precio, f.nombre AS nombre_fabricante
FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo
ORDER BY f.nombre ASC;
-- Consulta n23 Retorna una llista amb el codi del producte, nom del producte, codi del fabricador i nom del fabricador, de tots els productes de la base de dades --
SELECT p.codigo AS codigo_producto, p.nombre AS nombre_producto, p.codigo_fabricante, f.nombre AS nombre_fabricante
FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo;
-- Consulta n24 Retorna el nom del producte, el seu preu i el nom del seu fabricant, del producte més barat --
SELECT p.nombre, p.precio, f.nombre AS nombre_fabricante
FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo
ORDER BY p.precio ASC LIMIT 1;
-- Consulta n25 Retorna el nom del producte, el seu preu i el nom del seu fabricant, del producte més car --
SELECT p.nombre, p.precio, f.nombre AS nombre_fabricante
FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo
ORDER BY p.precio DESC LIMIT 1;
-- Consulta n26 Retorna una llista de tots els productes del fabricant Lenovo --
SELECT p.nombre, p.precio
FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE f.nombre = 'Lenovo';
-- Consulta n27 Retorna una llista de tots els productes del fabricant Crucial que tinguin un preu major que 200e --
SELECT p.nombre, p.precio
FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE f.nombre = 'Crucial' AND p.precio > 200;
-- Consulta n28 Retorna un llistat amb tots els productes dels fabricants Asus, Hewlett-Packard i Seagate. Sense utilitzar l'operador IN --
SELECT p.nombre, p.precio
FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE f.nombre = 'Asus' OR f.nombre = 'Hewlett-Packard' OR f.nombre = 'Seagate';
-- Consulta n29 Retorna un llistat amb tots els productes dels fabricants Asus, Hewlett-Packard i Seagate. Fent servir l'operador IN --
SELECT p.nombre, p.precio
FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE f.nombre IN ('Asus', 'Hewlett-Packard', 'Seagate');
-- Consulta n30 Retorna un llistat amb el nom i el preu de tots els productes dels fabricants el nom dels quals acabi per la vocal e --
SELECT p.nombre, p.precio
FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE f.nombre LIKE '%e';




