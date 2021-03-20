/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba2.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "Factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.facturaPK.idFactura = :idFactura"),
    @NamedQuery(name = "Factura.findByFechaCreacion", query = "SELECT f FROM Factura f WHERE f.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Factura.findByClienteidCliente", query = "SELECT f FROM Factura f WHERE f.facturaPK.clienteidCliente = :clienteidCliente")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected FacturaPK facturaPK;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @JoinTable(
            name = "Factura_has_Producto", 
            joinColumns = {@JoinColumn(name = "Factura_idFactura", referencedColumnName = "idFactura"),
                            @JoinColumn(name = "Producto_idProducto", referencedColumnName = "idProducto")},
            
        inverseJoinColumns = {@JoinColumn(name = "Producto_idProducto", referencedColumnName = "idProducto")})
    @ManyToMany
    private List<Producto> productoList;
    
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Factura() {
    }

    public Factura(FacturaPK facturaPK) {
        this.facturaPK = facturaPK;
    }

    public Factura(FacturaPK facturaPK, Date fechaCreacion) {
        this.facturaPK = facturaPK;
        this.fechaCreacion = fechaCreacion;
    }

    public Factura(int idFactura, int clienteidCliente) {
        this.facturaPK = new FacturaPK(idFactura, clienteidCliente);
    }

    public FacturaPK getFacturaPK() {
        return facturaPK;
    }

    public void setFacturaPK(FacturaPK facturaPK) {
        this.facturaPK = facturaPK;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaPK != null ? facturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.facturaPK == null && other.facturaPK != null) || (this.facturaPK != null && !this.facturaPK.equals(other.facturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.entity.Factura[ facturaPK=" + facturaPK + " ]";
    }
    
}
