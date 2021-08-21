
Condominio
-Nombre
-Direccion
-CedulaJuridica
-Representante
-CantidadUnidades
-Estado
-Cuota

CREATE TABLE `condominio` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad_unidades`  bigint(20) DEFAULT NULL,
  `cedula_juridica` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `representante` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `cuota` double NOT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE condominio MODIFY id bigint(20) AUTO_INCREMENT;



#>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

cuota
-id
-idCondominio
-Fecha LocalDate
-Precio Float

CREATE TABLE `cuota` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `id_condominio` bigint(20) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`id`)
);
ALTER TABLE exam3.cuota ADD CONSTRAINT foreingKeyIdAtl FOREIGN KEY (id_condominio) REFERENCES condominio (id);
ALTER TABLE exam3.cuota MODIFY id bigint(20) AUTO_INCREMENT;

#>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

amenidades
-id long
-idCondominio long
-Amenidad String

CREATE TABLE `amenidad` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amenidad` varchar(255) DEFAULT NULL,
  `id_condominio` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
);
ALTER TABLE exam3.amenidad ADD CONSTRAINT foreingKeyIdAtl2 FOREIGN KEY (id_condominio) REFERENCES condominio (id);
ALTER TABLE exam3.amenidad MODIFY id bigint(20) AUTO_INCREMENT;

#>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

condomino
-id long
-idCondominio long
-Nombre String

CREATE TABLE `condomino` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  `id_condominio` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
ALTER TABLE exam3.condomino ADD CONSTRAINT foreingKeyIdAtl3 FOREIGN KEY (id_condominio) REFERENCES condominio (id);
ALTER TABLE exam3.condomino MODIFY id bigint(20) AUTO_INCREMENT;
#>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>














ALTER TABLE exam3.condominio MODIFY id bigint(20) AUTO_INCREMENT;

ALTER TABLE exam3.cuota ADD CONSTRAINT foreingKeyIdAtl FOREIGN KEY (id_condominio) REFERENCES condominio (id);
ALTER TABLE exam3.cuota MODIFY id bigint(20) AUTO_INCREMENT;

ALTER TABLE exam3.amenidad ADD CONSTRAINT foreingKeyIdAtl2 FOREIGN KEY (id_condominio) REFERENCES condominio (id);
ALTER TABLE exam3.amenidad MODIFY id bigint(20) AUTO_INCREMENT;

ALTER TABLE exam3.condomino ADD CONSTRAINT foreingKeyIdAtl3 FOREIGN KEY (id_condominio) REFERENCES condominio (id);
ALTER TABLE exam3.condomino MODIFY id bigint(20) AUTO_INCREMENT;





#________________________________________________________________________________________________________Crear Condominio ***
DELIMITER //
CREATE PROCEDURE create_condominio(IN cantidadUnidadesParam bigint(20)
, IN cedulaJuridicaParam varchar(255)
, IN direccionParam varchar(255)
, IN nombreParam varchar(255)
, IN representanteParam varchar(255)
, IN estadoParam varchar(255)
, IN cuotaParam double)
BEGIN
INSERT INTO exam3.condominio (cantidad_unidades
, cedula_juridica
, direccion
, nombre
, representante
, estado
, cuota)
    VALUES (cantidadUnidadesParam
	, cedulaJuridicaParam
	, direccionParam
	, nombreParam
	, representanteParam
	, estadoParam
	, cuotaParam);
END;
//

call create_condominio(5,'304870951','Cartago','Condominio Ramirez','Esteban Lopez','activo',3500);

#________________________________________________________________________________________________________Listar Condominio ***
DELIMITER //
CREATE PROCEDURE list_condominio()
BEGIN
SELECT id,nombre,direccion,cedula_juridica,representante,cantidad_unidades,estado,cuota FROM condominio; 
END;
//


#________________________________________________________________________________________________________GetById Condominio ***
DELIMITER //
CREATE PROCEDURE getid_condominio(IN idParam bigint(20))
BEGIN
select id,nombre,direccion,cedula_juridica,representante,cantidad_unidades,estado,cuota from exam3.condominio where id = idParam;
END;
//


#________________________________________________________________________________________________________Search Estado ***
DELIMITER //
CREATE PROCEDURE searchEstado_condominio(IN estadoParam varchar(250))
BEGIN
SELECT * FROM exam3.condominio WHERE estado = estadoParam;
END;
//


#________________________________________________________________________________________________________Update Estado ***
DELIMITER //
CREATE PROCEDURE desactivar_condominio(IN idParam bigint(20))
BEGIN
UPDATE exam3.condominio 
SET estado = "inactivo" 
WHERE id = idParam;
END;
//

#________________________________________________________________________________________________________Update Condominio ***

DELIMITER //
CREATE PROCEDURE update_condominio(IN idParam bigint(20)
, IN cantidadUnidadesParam bigint(20)
, IN cedulaJuridicaParam varchar(255)
, IN direccionParam varchar(255)
, IN nombreParam varchar(255)
, IN representanteParam varchar(255)
, IN cuotaParam double)
BEGIN
UPDATE exam3.condominio 
SET cantidad_unidades = cantidadUnidadesParam
, cedula_juridica = cedulaJuridicaParam
, direccion = direccionParam
, nombre = nombreParam
, representante = representanteParam
, cuota = cuotaParam 
WHERE id = idParam;
END;
//

#________________________________________________________________________________________________________Crear Amenidad ***
DELIMITER //
CREATE PROCEDURE create_amenidad(IN amenidadParam varchar(255)
, IN idCondominioParam long)
BEGIN
INSERT INTO exam3.amenidad (amenidad
, id_condominio)
    VALUES (amenidadParam
	, idCondominioParam);
END;
//

call create_amenidad('Muebles',1);
#________________________________________________________________________________________________________Listar Amenidades de Condominio ***
DELIMITER //
CREATE PROCEDURE list_Amenidades_Condominio(IN idcondominioParam bigint(20)
)
BEGIN
SELECT * FROM exam3.amenidad 
WHERE id_condominio = idcondominioParam;
END;
//

#________________________________________________________________________________________________________Crear Cuota Historico ***
DELIMITER //
CREATE PROCEDURE create_historico_cuota(IN idCondominioParam bigint(20)
, IN precioParam double)
BEGIN
INSERT INTO exam3.cuota (fecha
, id_condominio
, precio)
    VALUES (CURRENT_DATE()
	, idCondominioParam
	, precioParam);
END;
//

#________________________________________________________________________________________________________Listar Historial Cuotas de Condominio ***
DELIMITER //
CREATE PROCEDURE list_cuota_condominio(IN idcondominioParam bigint(20))
BEGIN
SELECT * FROM exam3.cuota
WHERE id_condominio = idcondominioParam;
END;
//

#________________________________________________________________________________________________________Crear Condo ***
DELIMITER //
CREATE PROCEDURE create_condomino(IN nombreParam varchar(255)
, IN idCondominioParam long)
BEGIN
INSERT INTO exam3.condomino (nombre
, id_condominio, estado)
    VALUES (nombreParam
	, idCondominioParam,
	"activo");
END;
//

#________________________________________________________________________________________________________Listar Condos de Condominio ***
DELIMITER //
CREATE PROCEDURE list_condomino_Condominio(IN idcondominioParam bigint(20))
BEGIN
SELECT * FROM exam3.condomino
WHERE id_condominio = idcondominioParam;
END;
//

#________________________________________________________________________________________________________Borrado Logico Estado ***
DELIMITER //
CREATE PROCEDURE eliminar_condomino(IN idParam bigint(20))
BEGIN
UPDATE exam3.condomino 
SET estado = "ex-condomino" 
WHERE id = idParam;
END;
//

#________________________________________________________________________________________________________Get Condomino By id ***
DELIMITER //
CREATE PROCEDURE getid_condomino(IN idParam bigint(20))
BEGIN
select * from exam3.condomino where id = idParam;
END;
//


#________________________________________________________________________________________________________Update Condominio 
DELIMITER //
CREATE PROCEDURE update_condomino(IN idParam bigint(20)
, IN idCondominioParam bigint(20)
, IN nombreParam varchar(255))
BEGIN
UPDATE exam3.condomino 
SET id_condominio = idCondominioParam
, nombre = nombreParam
WHERE id = idParam;
END;
//










