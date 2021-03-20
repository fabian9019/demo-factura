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
public class FacturaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idFactura")
    private int idFactura;
    @Basic(optional = false)
    @Column(name = "Cliente_idCliente")
    private int clienteidCliente;

    public FacturaPK() {
    }

    public FacturaPK(int idFactura, int clienteidCliente) {
        this.idFactura = idFactura;
        this.clienteidCliente = clienteidCliente;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(int clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFactura;
        hash += (int) clienteidCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaPK)) {
            return false;
        }
        FacturaPK other = (FacturaPK) object;
        if (this.idFactura != other.idFactura) {
            return false;
        }
        if (this.clienteidCliente != other.clienteidCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FacturaPK[ idFactura=" + idFactura + ", clienteidCliente=" + clienteidCliente + " ]";
    }
    
}
