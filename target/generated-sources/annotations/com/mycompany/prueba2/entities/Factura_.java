package com.mycompany.prueba2.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Factura.class)
public abstract class Factura_ {

	public static volatile SingularAttribute<Factura, Cliente> cliente;
	public static volatile SingularAttribute<Factura, FacturaPK> facturaPK;
	public static volatile ListAttribute<Factura, Producto> productoList;
	public static volatile SingularAttribute<Factura, Date> fechaCreacion;

	public static final String CLIENTE = "cliente";
	public static final String FACTURA_PK = "facturaPK";
	public static final String PRODUCTO_LIST = "productoList";
	public static final String FECHA_CREACION = "fechaCreacion";

}

