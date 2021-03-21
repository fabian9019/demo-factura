package com.mycompany.prueba2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, String> apellidos;
	public static volatile SingularAttribute<Cliente, Integer> idCliente;
	public static volatile SingularAttribute<Cliente, String> direccion;
	public static volatile ListAttribute<Cliente, Factura> facturaList;
	public static volatile SingularAttribute<Cliente, String> telefono;
	public static volatile SingularAttribute<Cliente, Integer> identifiacion;
	public static volatile SingularAttribute<Cliente, String> email;
	public static volatile SingularAttribute<Cliente, String> nombres;

	public static final String APELLIDOS = "apellidos";
	public static final String ID_CLIENTE = "idCliente";
	public static final String DIRECCION = "direccion";
	public static final String FACTURA_LIST = "facturaList";
	public static final String TELEFONO = "telefono";
	public static final String IDENTIFIACION = "identifiacion";
	public static final String EMAIL = "email";
	public static final String NOMBRES = "nombres";

}

