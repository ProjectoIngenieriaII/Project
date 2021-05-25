/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservas.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "opciones")
@NamedQueries({
    @NamedQuery(name = "Opciones.findAll", query = "SELECT o FROM Opciones o"),
    @NamedQuery(name = "Opciones.findByIdPermiso", query = "SELECT o FROM Opciones o WHERE o.idPermiso = :idPermiso"),
    @NamedQuery(name = "Opciones.findByFuncionalidad", query = "SELECT o FROM Opciones o WHERE o.funcionalidad = :funcionalidad"),
    @NamedQuery(name = "Opciones.findByRuta", query = "SELECT o FROM Opciones o WHERE o.ruta = :ruta")})
public class Opciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_permiso")
    private Integer idPermiso;
    @Basic(optional = false)
    @Column(name = "funcionalidad")
    private String funcionalidad;
    @Basic(optional = false)
    @Column(name = "ruta")
    private String ruta;
    @JoinTable(name = "permisos_usuarios", joinColumns = {
        @JoinColumn(name = "id_permiso", referencedColumnName = "id_permiso")}, inverseJoinColumns = {
        @JoinColumn(name = "nro_doc_usuario", referencedColumnName = "nro_doc_usuario")})
    @ManyToMany
    private List<Usuarios> usuariosList;

    public Opciones() {
    }

    public Opciones(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Opciones(Integer idPermiso, String funcionalidad, String ruta) {
        this.idPermiso = idPermiso;
        this.funcionalidad = funcionalidad;
        this.ruta = ruta;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermiso != null ? idPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opciones)) {
            return false;
        }
        Opciones other = (Opciones) object;
        if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroauto.reservas.entidades.Opciones[ idPermiso=" + idPermiso + " ]";
    }
    
}
