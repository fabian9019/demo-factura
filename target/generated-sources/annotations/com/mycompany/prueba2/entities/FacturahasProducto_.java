package com.mycompany.prueba2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacturahasProducto.class)
public abstract class FacturahasProducto_ {

	public static volatile SingularAttribute<FacturahasProducto, FacturahasProductoPK> facturahasProductoPK;
	public static volatile SingularAttribute<FacturahasProducto, Factura> factura;
	public static volatile SingularAttribute<FacturahasProducto, Producto> producto;
	public static volatile SingularAttribute<FacturahasProducto, Integer> cantidadProducto;

	public static final String FACTURAHAS_PRODUCTO_PK = "facturahasProductoPK";
	public static final String FACTURA = "factura";
	public static final String PRODUCTO = "producto";
	public static final String CANTIDAD_PRODUCTO = "cantidadProducto";

}

