package com.mycompany.prueba2.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Factura.class)
public abstract class Factura_ {

	public static volatile SingularAttribute<Factura, Cliente> idCliente;
	public static volatile SingularAttribute<Factura, Integer> idFactura;
	public static volatile SingularAttribute<Factura, Double> valorTotal;
	public static volatile ListAttribute<Factura, FacturaDetalle> facturaDetalleList;
	public static volatile SingularAttribute<Factura, Date> fechaVenta;

	public static final String ID_CLIENTE = "idCliente";
	public static final String ID_FACTURA = "idFactura";
	public static final String VALOR_TOTAL = "valorTotal";
	public static final String FACTURA_DETALLE_LIST = "facturaDetalleList";
	public static final String FECHA_VENTA = "fechaVenta";

}

