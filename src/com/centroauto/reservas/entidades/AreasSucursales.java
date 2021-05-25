/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservas.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "areas_sucursales")
@NamedQueries({
    @NamedQuery(name = "AreasSucursales.findAll", query = "SELECT a FROM AreasSucursales a"),
    @NamedQuery(name = "AreasSucursales.findByIdAreaSucursal", query = "SELECT a FROM AreasSucursales a WHERE a.idAreaSucursal = :idAreaSucursal"),
    @NamedQuery(name = "AreasSucursales.findByEstadoArea", query = "SELECT a FROM AreasSucursales a WHERE a.estadoArea = :estadoArea")})
public class AreasSucursales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_area_sucursal")
    private Integer idAreaSucursal;
    @Basic(optional = false)
    @Column(name = "estado_area")
    private String estadoArea;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne(optional = false)
    private Areas idArea;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private Sucursales idSucursal;

    public AreasSucursales() {
    }

    public AreasSucursales(Integer idAreaSucursal) {
        this.idAreaSucursal = idAreaSucursal;
    }

    public AreasSucursales(Integer idAreaSucursal, String estadoArea) {
        this.idAreaSucursal = idAreaSucursal;
        this.estadoArea = estadoArea;
    }

    public Integer getIdAreaSucursal() {
        return idAreaSucursal;
    }

    public void setIdAreaSucursal(Integer idAreaSucursal) {
        this.idAreaSucursal = idAreaSucursal;
    }

    public String getEstadoArea() {
        return estadoArea;
    }

    public void setEstadoArea(String estadoArea) {
        this.estadoArea = estadoArea;
    }

    public Areas getIdArea() {
        return idArea;
    }

    public void setIdArea(Areas idArea) {
        this.idArea = idArea;
    }

    public Sucursales getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursales idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAreaSucursal != null ? idAreaSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreasSucursales)) {
            return false;
        }
        AreasSucursales other = (AreasSucursales) object;
        if ((this.idAreaSucursal == null && other.idAreaSucursal != null) || (this.idAreaSucursal != null && !this.idAreaSucursal.equals(other.idAreaSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroauto.reservas.entidades.AreasSucursales[ idAreaSucursal=" + idAreaSucursal + " ]";
    }
    
}
