/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba2.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author fabiancaicedocuellar
 */
@Embeddable
public class FacturahasProductoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Factura_idFactura")
    private int facturaidFactura;
    
    @Basic(optional = false)
    @Column(name = "Producto_idProducto")
    private int productoidProducto;

    public FacturahasProductoPK() {
    }

    public FacturahasProductoPK(int facturaidFactura, int productoidProducto) {
        this.facturaidFactura = facturaidFactura;
        this.productoidProducto = productoidProducto;
    }

    public int getFacturaidFactura() {
        return facturaidFactura;
    }

    public void setFacturaidFactura(int facturaidFactura) {
        this.facturaidFactura = facturaidFactura;
    }

    public int getProductoidProducto() {
        return productoidProducto;
    }

    public void setProductoidProducto(int productoidProducto) {
        this.productoidProducto = productoidProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) facturaidFactura;
        hash += (int) productoidProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturahasProductoPK)) {
            return false;
        }
        FacturahasProductoPK other = (FacturahasProductoPK) object;
        if (this.facturaidFactura != other.facturaidFactura) {
            return false;
        }
        if (this.productoidProducto != other.productoidProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FacturahasProductoPK[ facturaidFactura=" + facturaidFactura + ", productoidProducto=" + productoidProducto + " ]";
    }
    
}
