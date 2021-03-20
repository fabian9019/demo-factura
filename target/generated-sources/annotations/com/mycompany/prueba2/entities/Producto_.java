package com.mycompany.prueba2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Producto.class)
public abstract class Producto_ {

	public static volatile SingularAttribute<Producto, String> descripcion;
	public static volatile SingularAttribute<Producto, Double> valor;
	public static volatile ListAttribute<Producto, Factura> facturaList;
	public static volatile SingularAttribute<Producto, Integer> idProducto;
	public static volatile SingularAttribute<Producto, Integer> cantidad;

	public static final String DESCRIPCION = "descripcion";
	public static final String VALOR = "valor";
	public static final String FACTURA_LIST = "facturaList";
	public static final String ID_PRODUCTO = "idProducto";
	public static final String CANTIDAD = "cantidad";

}

