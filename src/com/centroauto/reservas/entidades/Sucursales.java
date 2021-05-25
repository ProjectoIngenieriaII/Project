/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservas.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "sucursales")
@NamedQueries({
    @NamedQuery(name = "Sucursales.findAll", query = "SELECT s FROM Sucursales s"),
    @NamedQuery(name = "Sucursales.findByIdSucursal", query = "SELECT s FROM Sucursales s WHERE s.idSucursal = :idSucursal"),
    @NamedQuery(name = "Sucursales.findByNomSucursal", query = "SELECT s FROM Sucursales s WHERE s.nomSucursal = :nomSucursal"),
    @NamedQuery(name = "Sucursales.findByDirSucursal", query = "SELECT s FROM Sucursales s WHERE s.dirSucursal = :dirSucursal"),
    @NamedQuery(name = "Sucursales.findByTelSucursal", query = "SELECT s FROM Sucursales s WHERE s.telSucursal = :telSucursal")})
public class Sucursales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sucursal")
    private Integer idSucursal;
    @Basic(optional = false)
    @Column(name = "nom_sucursal")
    private String nomSucursal;
    @Basic(optional = false)
    @Column(name = "dir_sucursal")
    private String dirSucursal;
    @Column(name = "tel_sucursal")
    private Long telSucursal;
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad")
    @ManyToOne(optional = false)
    private Ciudades idCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<AreasSucursales> areasSucursalesList;

    public Sucursales() {
    }

    public Sucursales(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Sucursales(Integer idSucursal, String nomSucursal, String dirSucursal) {
        this.idSucursal = idSucursal;
        this.nomSucursal = nomSucursal;
        this.dirSucursal = dirSucursal;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getDirSucursal() {
        return dirSucursal;
    }

    public void setDirSucursal(String dirSucursal) {
        this.dirSucursal = dirSucursal;
    }

    public Long getTelSucursal() {
        return telSucursal;
    }

    public void setTelSucursal(Long telSucursal) {
        this.telSucursal = telSucursal;
    }

    public Ciudades getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudades idCiudad) {
        this.idCiudad = idCiudad;
    }

    public List<AreasSucursales> getAreasSucursalesList() {
        return areasSucursalesList;
    }

    public void setAreasSucursalesList(List<AreasSucursales> areasSucursalesList) {
        this.areasSucursalesList = areasSucursalesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSucursal != null ? idSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursales)) {
            return false;
        }
        Sucursales other = (Sucursales) object;
        if ((this.idSucursal == null && other.idSucursal != null) || (this.idSucursal != null && !this.idSucursal.equals(other.idSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroauto.reservas.entidades.Sucursales[ idSucursal=" + idSucursal + " ]";
    }
    
}
