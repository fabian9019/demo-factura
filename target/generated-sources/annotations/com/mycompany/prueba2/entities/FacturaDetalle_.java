package com.mycompany.prueba2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacturaDetalle.class)
public abstract class FacturaDetalle_ {

	public static volatile SingularAttribute<FacturaDetalle, Double> valorTotal;
	public static volatile SingularAttribute<FacturaDetalle, Factura> idFactura;
	public static volatile SingularAttribute<FacturaDetalle, Double> valorUnidad;
	public static volatile SingularAttribute<FacturaDetalle, Integer> cantidad;
	public static volatile SingularAttribute<FacturaDetalle, Producto> idProducto;
	public static volatile SingularAttribute<FacturaDetalle, Integer> idFacturaDetalle;

	public static final String VALOR_TOTAL = "valorTotal";
	public static final String ID_FACTURA = "idFactura";
	public static final String VALOR_UNIDAD = "valorUnidad";
	public static final String CANTIDAD = "cantidad";
	public static final String ID_PRODUCTO = "idProducto";
	public static final String ID_FACTURA_DETALLE = "idFacturaDetalle";

}

