USE prueba;

DROP TABLE IF EXISTS TEST_CLIENTE ;

CREATE TABLE IF NOT EXISTS TEST_CLIENTE(
IdCliente INT AUTO_INCREMENT primary key,
Identifiacion INT not null,
Nombres VARCHAR(100) not null,
Apellidos VARCHAR(100) not null,
Direccion VARCHAR(300) not null,
Telefono VARCHAR(50),
Email VARCHAR(100)
);

DROP TABLE IF EXISTS TEST_PRODUCTO ;
CREATE TABLE IF NOT EXISTS TEST_PRODUCTO(
IdProducto INT AUTO_INCREMENT primary key,
Codigo VARCHAR(30) not null,
Nombre VARCHAR(100) not null,
ValorUnidad DOUBLE not null,
Stock INT not null
);


DROP TABLE IF EXISTS TEST_FACTURA ;
CREATE TABLE IF NOT EXISTS TEST_FACTURA(
IdFactura INT AUTO_INCREMENT primary key,
IdCliente INT not null,
FechaVenta DATETIME not null,
ValorTotal DOUBLE not null,
foreign key(IdCliente) references TEST_CLIENTE(IdCliente)
);


DROP TABLE IF EXISTS TEST_FACTURA_DETALLE ;
CREATE TABLE IF NOT EXISTS TEST_FACTURA_DETALLE(
IdFacturaDetalle INT AUTO_INCREMENT primary key,
IdFactura INT not null,
IdProducto INT not null,
Cantidad INT not null,
ValorUnidad DOUBLE not null,
ValorTotal DOUBLE not null,
foreign key(IdFactura) references TEST_FACTURA(IdFactura),
foreign key(IdProducto) references TEST_PRODUCTO(IdProducto)
);


INSERT INTO TEST_CLIENTE (Identifiacion, Nombres, Apellidos, Direccion, Telefono, Email) VALUES(11223344,'CLIENTE','BAJO','CALLE 1 # 2-1','3210099','CL01@YAHOO.ES');
INSERT INTO TEST_CLIENTE (Identifiacion, Nombres, Apellidos, Direccion, Telefono, Email) VALUES(789456,'PETER','ROJO','CALLE 11 # 21-11',NULL,NULL);
INSERT INTO TEST_CLIENTE (Identifiacion, Nombres, Apellidos, Direccion, Telefono, Email) VALUES(66995522,'JAIR','RUIZ','CALLE 63 # 55-1','3669955','JAIR@YAHOO.ES');
INSERT INTO TEST_CLIENTE (Identifiacion, Nombres, Apellidos, Direccion, Telefono, Email) VALUES(2255448,'VICTOR','BARCO','CALLE 19 # 21','7410022','VICTOR@YAHOO.ES');
INSERT INTO TEST_CLIENTE (Identifiacion, Nombres, Apellidos, Direccion, Telefono, Email) VALUES(123456789,'MARIA','CALLE','CALLE 61 # 77D-96','6660005','CALLE@YAHOO.ES');
INSERT INTO TEST_CLIENTE (Identifiacion, Nombres, Apellidos, Direccion, Telefono, Email) VALUES(41000333,'LUIS','CORREO','CALLE 45 # 32-11','4444444','LCORREO@YAHOO.ES');


INSERT INTO TEST_PRODUCTO (Codigo, Nombre, ValorUnidad, Stock) VALUES('0001','TOSTACOS',950,15);
INSERT INTO TEST_PRODUCTO (Codigo, Nombre, ValorUnidad, Stock) VALUES('0002','LECHE',2350,40);
INSERT INTO TEST_PRODUCTO (Codigo, Nombre, ValorUnidad, Stock) VALUES('0003','PLATANO',1500,20);
INSERT INTO TEST_PRODUCTO (Codigo, Nombre, ValorUnidad, Stock) VALUES('0004','PAPALES',36500,4);
INSERT INTO TEST_PRODUCTO (Codigo, Nombre, ValorUnidad, Stock) VALUES('0005','BULTO DE MANDARINAS',156800,9);
INSERT INTO TEST_PRODUCTO (Codigo, Nombre, ValorUnidad, Stock) VALUES('0006','ARROZ',6450,60);
INSERT INTO TEST_PRODUCTO (Codigo, Nombre, ValorUnidad, Stock) VALUES('0007','PESCADO',99000,45);
INSERT INTO TEST_PRODUCTO (Codigo, Nombre, ValorUnidad, Stock) VALUES('0008','HUEVOS',11500,20);
INSERT INTO TEST_PRODUCTO (Codigo, Nombre, ValorUnidad, Stock) VALUES('0009','PAPAS JAJAJAJA',6600,1);
INSERT INTO TEST_PRODUCTO (Codigo, Nombre, ValorUnidad, Stock) VALUES('0010','DETERGENTE',5001000,3);

