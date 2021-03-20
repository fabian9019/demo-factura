package com.mycompany.prueba2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, Integer> idCliente;
	public static volatile ListAttribute<Cliente, Factura> facturaList;
	public static volatile SingularAttribute<Cliente, String> nombre;

	public static final String ID_CLIENTE = "idCliente";
	public static final String FACTURA_LIST = "facturaList";
	public static final String NOMBRE = "nombre";

}

