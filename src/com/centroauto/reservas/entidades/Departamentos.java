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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "departamentos")
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Departamentos.findByIdDepto", query = "SELECT d FROM Departamentos d WHERE d.idDepto = :idDepto"),
    @NamedQuery(name = "Departamentos.findByNomDepto", query = "SELECT d FROM Departamentos d WHERE d.nomDepto = :nomDepto")})
public class Departamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_depto")
    private Integer idDepto;
    @Basic(optional = false)
    @Column(name = "nom_depto")
    private String nomDepto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepto")
    private List<Ciudades> ciudadesList;

    public Departamentos() {
    }

    public Departamentos(Integer idDepto) {
        this.idDepto = idDepto;
    }

    public Departamentos(Integer idDepto, String nomDepto) {
        this.idDepto = idDepto;
        this.nomDepto = nomDepto;
    }

    public Integer getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Integer idDepto) {
        this.idDepto = idDepto;
    }

    public String getNomDepto() {
        return nomDepto;
    }

    public void setNomDepto(String nomDepto) {
        this.nomDepto = nomDepto;
    }

    public List<Ciudades> getCiudadesList() {
        return ciudadesList;
    }

    public void setCiudadesList(List<Ciudades> ciudadesList) {
        this.ciudadesList = ciudadesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepto != null ? idDepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.idDepto == null && other.idDepto != null) || (this.idDepto != null && !this.idDepto.equals(other.idDepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroauto.reservas.entidades.Departamentos[ idDepto=" + idDepto + " ]";
    }
    
}
