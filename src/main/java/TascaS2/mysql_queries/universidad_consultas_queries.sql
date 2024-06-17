-- Consulta n1 Retorna un llistat amb el primer cognom, segon cognom i el nom de tots els/les alumnes. El llistat haurà d'estar ordenat alfabèticament de menor a major pel primer cognom, segon cognom i nom --
SELECT apellido1, apellido2, nombre
FROM persona
WHERE tipo = 'alumno'
ORDER BY apellido1, apellido2, nombre;
-- Consulta n2 Esbrina el nom i els dos cognoms dels alumnes que no han donat d'alta el seu número de telèfon en la base de dades --
SELECT nombre, apellido1, apellido2
FROM persona
WHERE tipo = 'alumno' AND telefono IS NULL;
-- Consulta n3 Retorna el llistat dels alumnes que van néixer en 1999 --
SELECT nombre, apellido1, apellido2
FROM persona
WHERE tipo = 'alumno' AND YEAR(fecha_nacimiento) = 1999;
-- Consulta n4 Retorna el llistat de professors/es que no han donat d'alta el seu número de telèfon en la base de dades i a més el seu NIF acaba en K --
SELECT nombre, apellido1, apellido2
FROM persona
WHERE tipo = 'profesor' AND telefono IS NULL AND nif LIKE '%K';
-- Consulta n5 Retorna el llistat de les assignatures que s'imparteixen en el primer quadrimestre, en el tercer curs del grau que té l'identificador 7 --
SELECT nombre
FROM asignatura
WHERE cuatrimestre = 1 AND curso = 3 AND id_grado = 7;
-- Consulta n6 Retorna un llistat dels professors/es juntament amb el nom del departament al qual estan vinculats. El llistat ha de retornar quatre columnes, primer cognom, segon cognom, nom i nom del departament. El resultat estarà ordenat alfabèticament de menor a major pels cognoms i el nom --
SELECT p.apellido1, p.apellido2, p.nombre, d.nombre AS nombre_departamento
FROM persona p
JOIN profesor pr ON p.id = pr.id_profesor
JOIN departamento d ON pr.id_departamento = d.id
ORDER BY p.apellido1, p.apellido2, p.nombre;
-- Consulta n7 Retorna un llistat amb el nom de les assignatures, any d'inici i any de fi del curs escolar de l'alumne/a amb NIF 26902806M --
SELECT a.nombre, c.anyo_inicio, c.anyo_fin
FROM asignatura a
JOIN alumno_se_matricula_asignatura am ON a.id = am.id_asignatura
JOIN curso_escolar c ON am.id_curso_escolar = c.id
JOIN persona p ON am.id_alumno = p.id
WHERE p.nif = '26902806M';
-- Consulta n8 Retorna un llistat amb el nom de tots els departaments que tenen professors/es que imparteixen alguna assignatura en el Grau en Enginyeria Informàtica (Pla 2015) --
SELECT DISTINCT d.nombre
FROM departamento d
JOIN profesor pr ON d.id = pr.id_departamento
JOIN asignatura a ON pr.id_profesor = a.id_profesor
JOIN grado g ON a.id_grado = g.id
WHERE g.nombre = 'Grado en Ingeniería Informática (Plan 2015)';
-- Consulta n9 Retorna un llistat amb tots els alumnes que s'han matriculat en alguna assignatura durant el curs escolar 2018/2019 --
SELECT DISTINCT p.nombre, p.apellido1, p.apellido2
FROM persona p
JOIN alumno_se_matricula_asignatura am ON p.id = am.id_alumno
JOIN curso_escolar c ON am.id_curso_escolar = c.id
WHERE c.anyo_inicio = 2018 AND c.anyo_fin = 2019;

-- Consultas LEFT JOIN --
-- Consulta n1 Retorna un llistat amb els noms de tots els professors/es i els departaments que tenen vinculats. El llistat també ha de mostrar aquells professors/es que no tenen cap departament associat --
SELECT d.nombre AS nombre_departamento, p.apellido1, p.apellido2, p.nombre
FROM persona p
LEFT JOIN profesor pr ON p.id = pr.id_profesor
LEFT JOIN departamento d ON pr.id_departamento = d.id
WHERE p.tipo = 'profesor'
ORDER BY d.nombre, p.apellido1, p.apellido2, p.nombre;
-- Consulta n2 Retorna un llistat amb els professors/es que no estan associats a un departament --
SELECT p.apellido1, p.apellido2, p.nombre
FROM persona p
LEFT JOIN profesor pr ON p.id = pr.id_profesor
WHERE p.tipo = 'profesor' AND pr.id_departamento IS NULL;
-- Consulta n3 Retorna un llistat amb els departaments que no tenen professors/es associats --
SELECT d.nombre
FROM departamento d
LEFT JOIN profesor pr ON d.id = pr.id_departamento
WHERE pr.id_profesor IS NULL;
-- Consulta n4 Retorna un llistat amb els professors/es que no imparteixen cap assignatura --
SELECT p.apellido1, p.apellido2, p.nombre
FROM persona p
LEFT JOIN profesor pr ON p.id = pr.id_profesor
LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor
WHERE p.tipo = 'profesor' AND a.id IS NULL;
-- Consulta n5 Retorna un llistat amb les assignatures que no tenen un professor/a assignat --
SELECT a.nombre
FROM asignatura a
LEFT JOIN profesor pr ON a.id_profesor = pr.id_profesor
WHERE pr.id_profesor IS NULL;
-- Consulta n6 Retorna un llistat amb tots els departaments que no han impartit assignatures en cap curs escolar --
SELECT d.nombre
FROM departamento d
LEFT JOIN profesor pr ON d.id = pr.id_departamento
LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor
WHERE a.id IS NULL;

-- Consultas RESUM --
-- Consulta n1 Retorna el nombre total d'alumnes que hi ha --
SELECT COUNT(*) AS total_alumnes
FROM persona
WHERE tipo = 'alumno';
-- Consulta n2 Calcula quants alumnes van néixer en 1999 --
SELECT COUNT(*) AS alumnes_1999
FROM persona
WHERE tipo = 'alumno' AND YEAR(fecha_nacimiento) = 1999;
-- Consulta n3 Calcula quants professors/es hi ha en cada departament --
SELECT d.nombre AS nom_departamento, COUNT(p.id) AS num_professors
FROM departamento d
JOIN profesor pr ON d.id = pr.id_departamento
JOIN persona p ON pr.id_profesor = p.id
WHERE p.tipo = 'profesor'
GROUP BY d.nombre
ORDER BY num_professors DESC;
-- Consulta n4 Retorna un llistat amb tots els departaments i el nombre de professors/es que hi ha en cadascun d'ells --
SELECT d.nombre AS nom_departamento, COUNT(p.id) AS num_professors
FROM departamento d
LEFT JOIN profesor pr ON d.id = pr.id_departamento
LEFT JOIN persona p ON pr.id_profesor = p.id AND p.tipo = 'profesor'
GROUP BY d.nombre;
-- Consulta n5 Retorna un llistat amb el nom de tots els graus existents en la base de dades i el nombre d'assignatures que te cadascun --
SELECT g.nombre AS nom_grau, COUNT(a.id) AS num_assignatures
FROM grado g
LEFT JOIN asignatura a ON g.id = a.id_grado
GROUP BY g.nombre
ORDER BY num_assignatures DESC;
-- Consulta n6 Retorna un llistat amb el nom de tots els graus existents en la base de dades i el nombre d'assignatures que te cadascun, dels graus que tinguin mes de 40 assignatures associades --
SELECT g.nombre AS nom_grau, COUNT(a.id) AS num_assignatures
FROM grado g
LEFT JOIN asignatura a ON g.id = a.id_grado
GROUP BY g.nombre
HAVING num_assignatures > 40;
-- Consulta n7 Retorna un llistat que mostri el nom dels graus i la suma del numero total de credits que hi ha per a cada tipus d'assignatura --
SELECT g.nombre AS nom_grau, a.tipo, SUM(a.creditos) AS total_credits
FROM grado g
JOIN asignatura a ON g.id = a.id_grado
GROUP BY g.nombre, a.tipo;
-- Consulta n8 Retorna un llistat que mostri quants alumnes s'han matriculat d'alguna assignatura en cadascun dels cursos escolars --
SELECT c.anyo_inicio, c.anyo_fin, COUNT(DISTINCT am.id_alumno) AS num_alumnes
FROM curso_escolar c
JOIN alumno_se_matricula_asignatura am ON c.id = am.id_curso_escolar
GROUP BY c.anyo_inicio, c.anyo_fin;
-- Consulta n9 Retorna un llistat amb el nombre d'assignatures que imparteix cada professor/a --
SELECT p.id, p.nombre, p.apellido1, p.apellido2, COUNT(a.id) AS num_assignatures
FROM persona p
LEFT JOIN profesor pr ON p.id = pr.id_profesor
LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor
WHERE p.tipo = 'profesor'
GROUP BY p.id, p.nombre, p.apellido1, p.apellido2
ORDER BY num_assignatures DESC;
-- Consulta n10 Retorna totes les dades de l'alumne/a més jove --
SELECT *
FROM persona
WHERE tipo = 'alumno'
ORDER BY fecha_nacimiento DESC
LIMIT 1;
-- Consulta n11 Retorna un llistat amb els professors/es que tenen un departament associat i que no imparteixen cap assignatura --
SELECT p.nombre, p.apellido1, p.apellido2, d.nombre AS nombre_departamento
FROM persona p
JOIN profesor pr ON p.id = pr.id_profesor
LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor
JOIN departamento d ON pr.id_departamento = d.id
WHERE p.tipo = 'profesor' AND a.id IS NULL;











