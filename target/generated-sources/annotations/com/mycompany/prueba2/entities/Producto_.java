package com.mycompany.prueba2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Producto.class)
public abstract class Producto_ {

	public static volatile SingularAttribute<Producto, String> codigo;
	public static volatile ListAttribute<Producto, FacturaDetalle> facturaDetalleList;
	public static volatile SingularAttribute<Producto, Double> valorUnidad;
	public static volatile SingularAttribute<Producto, Integer> idProducto;
	public static volatile SingularAttribute<Producto, Integer> stock;
	public static volatile SingularAttribute<Producto, String> nombre;

	public static final String CODIGO = "codigo";
	public static final String FACTURA_DETALLE_LIST = "facturaDetalleList";
	public static final String VALOR_UNIDAD = "valorUnidad";
	public static final String ID_PRODUCTO = "idProducto";
	public static final String STOCK = "stock";
	public static final String NOMBRE = "nombre";

}

