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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "areas")
@NamedQueries({
    @NamedQuery(name = "Areas.findAll", query = "SELECT a FROM Areas a"),
    @NamedQuery(name = "Areas.findByIdArea", query = "SELECT a FROM Areas a WHERE a.idArea = :idArea"),
    @NamedQuery(name = "Areas.findByNomArea", query = "SELECT a FROM Areas a WHERE a.nomArea = :nomArea")})
public class Areas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_area")
    private Integer idArea;
    @Basic(optional = false)
    @Column(name = "nom_area")
    private String nomArea;
    @JoinTable(name = "areas_usuarios", joinColumns = {
        @JoinColumn(name = "id_area", referencedColumnName = "id_area")}, inverseJoinColumns = {
        @JoinColumn(name = "nro_doc_usuario", referencedColumnName = "nro_doc_usuario")})
    @ManyToMany
    private List<Usuarios> usuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArea")
    private List<Servicios> serviciosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArea")
    private List<AreasSucursales> areasSucursalesList;

    public Areas() {
    }

    public Areas(Integer idArea) {
        this.idArea = idArea;
    }

    public Areas(Integer idArea, String nomArea) {
        this.idArea = idArea;
        this.nomArea = nomArea;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public String getNomArea() {
        return nomArea;
    }

    public void setNomArea(String nomArea) {
        this.nomArea = nomArea;
    }

    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public List<Servicios> getServiciosList() {
        return serviciosList;
    }

    public void setServiciosList(List<Servicios> serviciosList) {
        this.serviciosList = serviciosList;
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
        hash += (idArea != null ? idArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areas)) {
            return false;
        }
        Areas other = (Areas) object;
        if ((this.idArea == null && other.idArea != null) || (this.idArea != null && !this.idArea.equals(other.idArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroauto.reservas.entidades.Areas[ idArea=" + idArea + " ]";
    }
    
}
