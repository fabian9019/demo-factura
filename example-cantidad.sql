
-- -----------------------------------------------------
-- Table Producto
-- -----------------------------------------------------
DROP TABLE IF EXISTS Producto ;

CREATE TABLE IF NOT EXISTS Producto (
  idProducto INT NOT NULL AUTO_INCREMENT,
  Descripcion VARCHAR(45) NULL,
  Cantidad INT NULL DEFAULT 0,
  Valor DOUBLE NULL DEFAULT 0,
  PRIMARY KEY (idProducto)
);


-- -----------------------------------------------------
-- Table Cliente
-- -----------------------------------------------------
DROP TABLE IF EXISTS Cliente ;

CREATE TABLE IF NOT EXISTS Cliente (
  idCliente INT NOT NULL AUTO_INCREMENT,
  Nombre VARCHAR(45) NULL,
  PRIMARY KEY (idCliente)
);


-- -----------------------------------------------------
-- Table Factura
-- -----------------------------------------------------
DROP TABLE IF EXISTS Factura ;

CREATE TABLE IF NOT EXISTS Factura (
  idFactura INT NOT NULL AUTO_INCREMENT,
  FechaCreacion DATETIME NOT NULL,
  Cliente_idCliente INT NOT NULL,
  PRIMARY KEY (idFactura),
  CONSTRAINT fk_Factura_Cliente
    FOREIGN KEY (Cliente_idCliente)
    REFERENCES Cliente (idCliente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


-- -----------------------------------------------------
-- Table Factura_has_Producto
-- -----------------------------------------------------
DROP TABLE IF EXISTS Factura_has_Producto ;

CREATE TABLE IF NOT EXISTS Factura_has_Producto (
  Factura_idFactura INT NOT NULL,
  Producto_idProducto INT NOT NULL,
  cantidadProducto INT NOT NULL,
  PRIMARY KEY (Factura_idFactura, Producto_idProducto),
  CONSTRAINT fk_Factura_has_Producto_Factura1
    FOREIGN KEY (Factura_idFactura)
    REFERENCES Factura (idFactura)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Factura_has_Producto_Producto1
    FOREIGN KEY (Producto_idProducto)
    REFERENCES Producto (idProducto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

