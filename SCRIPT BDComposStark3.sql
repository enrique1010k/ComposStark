# NOMBRE DE LA BASE DE DATOS: BDComposStark3
DROP DATABASE IF EXISTS BDComposStark3;
CREATE DATABASE BDComposStark3;
USE BDComposStark3;

DROP TABLE IF EXISTS T_Categoria;
CREATE TABLE T_Categoria(
	idcat INT PRIMARY KEY AUTO_INCREMENT,
    nomcat VARCHAR(40),
    estcat BIT(1)
);

DROP TABLE IF EXISTS T_Producto;
CREATE TABLE T_Producto(
	idpro INT PRIMARY KEY AUTO_INCREMENT,
    nompro VARCHAR(40),
    prepro DOUBLE,
    estpro BIT(1) default 1,
    idcat INT NOT NULL,
    FOREIGN KEY (idcat) REFERENCES T_Categoria(idcat)
);

DROP TABLE IF EXISTS T_Empleado;
CREATE TABLE T_Empleado(
	idemp INT PRIMARY KEY AUTO_INCREMENT,
    nomemp VARCHAR(40),
    apeemp VARCHAR(40),
    estdis BIT(1)
);



DROP TABLE IF EXISTS T_Distrito;
CREATE TABLE T_Distrito(
 	iddis INT PRIMARY KEY AUTO_INCREMENT,
    nomdis VARCHAR(40),
    estdis BIT(1)
);

DROP TABLE IF EXISTS T_Cliente;
CREATE TABLE T_Cliente(
	idcli INT PRIMARY KEY AUTO_INCREMENT,
    nomcli VARCHAR(40),
    apecli VARCHAR(40),
    dnicli int,
    dircli VARCHAR(70),
    estcli BIT(1),
	iddis INT NOT NULL,
	FOREIGN KEY (iddis) REFERENCES T_Distrito(iddis)
);

DROP TABLE IF EXISTS T_Factura;
CREATE TABLE T_Factura(
	idfac INT PRIMARY KEY AUTO_INCREMENT,
    fecfac VARCHAR(40),
    estfac BIT(1),
    idcli INT NOT NULL,
    FOREIGN KEY (idcli) REFERENCES T_Cliente(idcli),
	idemp INT NOT NULL,
	FOREIGN KEY (idemp) REFERENCES T_Empleado(idemp)
);


DROP TABLE IF EXISTS T_Detallefactura;
CREATE TABLE T_Detallefactura(
	iddet INT PRIMARY KEY AUTO_INCREMENT,
	candet double,
    pretdet double,
    estdet BIT,
# NOMBRE DE LA BASE DE DATOS: BDComposStark3
DROP DATABASE IF EXISTS BDComposStark3;
CREATE DATABASE BDComposStark3;
USE BDComposStark3;


DROP TABLE IF EXISTS T_Categoria;
CREATE TABLE T_Categoria(
	idcat INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nomcat VARCHAR(40) NOT NULL,
    estcat BIT NOT NULL
);


DROP TABLE IF EXISTS T_Producto;
CREATE TABLE T_Producto(
	idpro INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nompro VARCHAR(40) NOT NULL,
    prepro DOUBLE NOT NULL,
    estpro BIT NOT NULL,
    idcat INT NOT NULL,
    FOREIGN KEY (idcat) REFERENCES T_Categoria(idcat)
);


DROP TABLE IF EXISTS T_Empleado;
CREATE TABLE T_Empleado(
	idemp INT PRIMARY KEY AUTO_INCREMENT,
    nomemp VARCHAR(40),
    apeemp VARCHAR(40),
    estdis BIT(1)
);


DROP TABLE IF EXISTS T_Distrito;
CREATE TABLE T_Distrito(
 	iddis INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nomdis VARCHAR(40) NOT NULL,
    estdis BIT NOT NULL
);

DROP TABLE IF EXISTS T_Cliente;
CREATE TABLE T_Cliente(
	idcli INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nomcli VARCHAR(40) NOT NULL,
    apecli VARCHAR(40) NOT NULL,
    dnicli int NOT NULL,
    dircli VARCHAR(70) NOT NULL,
    estcli BIT NOT NULL,
	iddis INT NOT NULL,
	FOREIGN KEY (iddis) REFERENCES T_Distrito(iddis)
);

DROP TABLE IF EXISTS T_Factura;
CREATE TABLE T_Factura(
	idfac INT PRIMARY KEY AUTO_INCREMENT,
    fecfac VARCHAR(40),
    estfac BIT(1),
    idcli INT NOT NULL,
    FOREIGN KEY (idcli) REFERENCES T_Cliente(idcli),
	idemp INT NOT NULL,
	FOREIGN KEY (idemp) REFERENCES T_Empleado(idemp)
);


DROP TABLE IF EXISTS T_Detallefactura;
CREATE TABLE T_Detallefactura(
	iddet INT PRIMARY KEY AUTO_INCREMENT,
	candet double,
    pretdet double,
    estdet BIT,
	idpro INT NOT NULL,
    FOREIGN KEY (idpro) REFERENCES T_Producto(idpro)
);

DROP TABLE IF EXISTS T_Pagos;
CREATE TABLE T_Pagos(
	idpag INT PRIMARY KEY AUTO_INCREMENT,
    sumppag DOUBLE,
    igvpag DOUBLE,
    totppag DOUBLE,
    estpag BIT,
    iddet INT NOT NULL,
    FOREIGN KEY (iddet) REFERENCES T_Detallefactura(iddet),
    idfac INT NOT NULL,
    FOREIGN KEY (idfac) REFERENCES T_Factura(idfac)
);



INSERT INTO T_Categoria (nomcat, estcat) values ('televisores', 1);
INSERT INTO T_Categoria (nomcat, estcat) values ('celulares', 1);
INSERT INTO T_Categoria (nomcat, estcat) values ('computadoras', 1);
INSERT INTO T_Categoria (nomcat, estcat) values ('celulares de segunda mano', 0);

SELECT * FROM T_Categoria;

INSERT INTO T_Producto (nompro, prepro, estpro, idcat) values ('televisor Led', 1500, 1, 1);
INSERT INTO T_Producto (nompro, prepro, estpro, idcat) values ('iphone 14', 2000, 1, 2);
INSERT INTO T_Producto (nompro, prepro, estpro, idcat) values ('computadora intel core i5 4GB RAM', 2000, 1, 3);
INSERT INTO T_Producto (nompro, prepro, estpro, idcat) values ('Smart TV 50 pulgadas', 4500, 1, 2);
INSERT INTO T_Producto (nompro, prepro, estpro, idcat) values ('televisor HD', 6000, 1, '1');


INSERT INTO T_Distrito (nomdis, estdis) values ('Surco', 1);
INSERT INTO T_Distrito (nomdis, estdis) values ('San Juan de Lurigancho', 1);
INSERT INTO T_Distrito (nomdis, estdis) values ('Breña', 1);
INSERT INTO T_Distrito (nomdis, estdis) values ('Independencia', 1);
INSERT INTO T_Distrito (nomdis, estdis) values ('Los Olivos', 1);
INSERT INTO T_Distrito (nomdis, estdis) values ('Comas', 1);
INSERT INTO T_Distrito (nomdis, estdis) values ('Miraflores', 1);

SELECT * FROM T_Distrito;

INSERT INTO T_Cliente (nomcli, apecli, dnicli, dircli, estcli, iddis) values ('Armando Enrique', 'Kaneko Diaz', 73017920, 'Avenida Las Palmeras con Avenida Marañon', 1, 5);

SELECT * FROM T_Cliente;


# SELECCIONAR LA TABLA PRODUCTO
	# SELECT * FROM T_Producto;
# SELECCIONAR LA TABLA PRODUCTO CUYOS PRODUCTOS TENGAN EL ESTADO TRUE
	# SELECT * FROM T_Producto WHERE estpro = 1;
# SELECCIONAR LA TABLA PRODUCTO Y CATEGORIA AL MISMO TIEMPO ANEXADO POR SU CLAVE FORANEA
	# SELECT * FROM T_Producto LEFT JOIN T_Categoria ON T_Producto.idcat = T_Categoria.idcat;
# SELECCIONAR LA TABLA PRODUCTO Y CATEGORIA AL MISMO TIEMPO ANEXADO POR SU CLAVE FORANEA CUANDO EL PRODUCTO TENGA EL ESTADO TRUE
	SELECT * FROM T_Producto LEFT JOIN T_Categoria ON T_Producto.idpro = T_Categoria.idcat WHERE estpro = 1;


# SELECCIONAR LA TABLA CATEGORIA
# SELECT * FROM T_Categoria WHERE estcat = 1;











# INSERT INTO T_Distrito (nomdis, estdis) values ('Surco', 1);
# INSERT INTO T_Distrito (nomdis, estdis) values ('Miraflores', 1);
# INSERT INTO T_Distrito (nomdis, estdis) values ('Los Olivos', 1);
# INSERT INTO T_Distrito (nomdis, estdis) values ('Ate', 1);
# INSERT INTO T_Distrito (nomdis, estdis) values ('Alfonso Ugarte', 1);

# INSERT INTO T_Cliente (nomcli, apecli, dnicli, dircli, estcli, iddis) values ('usuario', 'admin', '12345678', 'home', 1, 4);
# insert into T_Cliente(dnicli,nomcli) values('3243232','ENRIQUE');

# SELECT * FROM T_Distrito;
# SELECT * FROM T_Cliente;
# SELECT * FROM T_Categoria;
# SELECT * FROM T_Producto;
# SELECT * FROM T_Producto WHERE estpro = 1;
# SELECT * FROM T_Categoria idcat, T_Producto idpro;


# SELECCIONAR LA TABLA PRODUCTO
SELECT * FROM T_Producto;

# SELECCIONAR LA TABLA PRODUCTO CUYOS PRODUCTOS TENGAN EL ESTADO TRUE
SELECT * FROM T_Producto WHERE estpro = 1;

# SELECCIONAR LA TABLA PRODUCTO Y CATEGORIA AL MISMO TIEMPO ANEXADO POR SU CLAVE FORANEA
SELECT * FROM T_Producto LEFT JOIN T_Categoria ON T_Producto.idpro = T_Categoria.idcat;

# SELECCIONAR LA TABLA PRODUCTO Y CATEGORIA AL MISMO TIEMPO ANEXADO POR SU CLAVE FORANEA CUANDO EL PRODUCTO TENGA EL ESTADO TRUE
SELECT * FROM T_Producto LEFT JOIN T_Categoria ON T_Producto.idpro = T_Categoria.idcat WHERE estpro = 1;

# idpro = 1
# nompro = 2
# prepro = 3
# estpro = 4
# idcat (T_Producto) = 5
# idcat (T_Categoria) = 6
# nomcat = 7
# estcat = 8



# UPDATE T_Producto set estpro = 0 where idpro=6 ;

