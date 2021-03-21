/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba2.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fabiancaicedocuellar
 */
@Entity
@Table(name = "Factura_has_Producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturahasProducto.findAll", query = "SELECT f FROM FacturahasProducto f"),
    @NamedQuery(name = "FacturahasProducto.findByFacturaidFactura", query = "SELECT f FROM FacturahasProducto f WHERE f.facturahasProductoPK.facturaidFactura = :facturaidFactura"),
    @NamedQuery(name = "FacturahasProducto.findByProductoidProducto", query = "SELECT f FROM FacturahasProducto f WHERE f.facturahasProductoPK.productoidProducto = :productoidProducto"),
    @NamedQuery(name = "FacturahasProducto.findByCantidadProducto", query = "SELECT f FROM FacturahasProducto f WHERE f.cantidadProducto = :cantidadProducto")})
public class FacturahasProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected FacturahasProductoPK facturahasProductoPK;
    
    @Basic(optional = false)
    @Column(name = "cantidadProducto")
    private int cantidadProducto;
        
    @JoinColumns({
        @JoinColumn(name = "Factura_idFactura", referencedColumnName = "idFactura", insertable = false, updatable = false),
        @JoinColumn(name = "Producto_idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false, nullable = true)
    })
    @ManyToOne(optional = false)
    private Factura factura;
    
    @JoinColumns({
        @JoinColumn(name = "Factura_idFactura", referencedColumnName = "idFactura", insertable = false, updatable = false , nullable = true),
        @JoinColumn(name = "Producto_idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
    })    
    @ManyToOne(optional = false)
    private Producto producto;

    public FacturahasProducto() {
    }

    public FacturahasProducto(FacturahasProductoPK facturahasProductoPK) {
        this.facturahasProductoPK = facturahasProductoPK;
    }

    public FacturahasProducto(FacturahasProductoPK facturahasProductoPK, int cantidadProducto) {
        this.facturahasProductoPK = facturahasProductoPK;
        this.cantidadProducto = cantidadProducto;
    }

    public FacturahasProducto(int facturaidFactura, int productoidProducto) {
        this.facturahasProductoPK = new FacturahasProductoPK(facturaidFactura, productoidProducto);
    }

    public FacturahasProductoPK getFacturahasProductoPK() {
        return facturahasProductoPK;
    }

    public void setFacturahasProductoPK(FacturahasProductoPK facturahasProductoPK) {
        this.facturahasProductoPK = facturahasProductoPK;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturahasProductoPK != null ? facturahasProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturahasProducto)) {
            return false;
        }
        FacturahasProducto other = (FacturahasProducto) object;
        if ((this.facturahasProductoPK == null && other.facturahasProductoPK != null) || (this.facturahasProductoPK != null && !this.facturahasProductoPK.equals(other.facturahasProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FacturahasProducto[ facturahasProductoPK=" + facturahasProductoPK + " ]";
    }

}
