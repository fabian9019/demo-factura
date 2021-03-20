package com.mycompany.prueba2.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Factura.class)
public abstract class Factura_ {

	public static volatile SingularAttribute<Factura, Integer> idFactura;
	public static volatile SingularAttribute<Factura, Cliente> clienteidCliente;
	public static volatile SingularAttribute<Factura, Date> fechaCreacion;
	public static volatile ListAttribute<Factura, FacturahasProducto> facturahasProductoList;

	public static final String ID_FACTURA = "idFactura";
	public static final String CLIENTEID_CLIENTE = "clienteidCliente";
	public static final String FECHA_CREACION = "fechaCreacion";
	public static final String FACTURAHAS_PRODUCTO_LIST = "facturahasProductoList";

}

