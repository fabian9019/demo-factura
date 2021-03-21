/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba2.daos;

import com.mycompany.prueba2.entities.FacturaDetalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fabiancaicedocuellar
 */
@Stateless
public class FacturaDetalleDao extends AbstractDao<FacturaDetalle> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaDetalleDao() {
        super(FacturaDetalle.class);
    }
    
}
