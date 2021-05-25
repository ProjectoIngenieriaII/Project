/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservas.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "servicios")
@NamedQueries({
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s"),
    @NamedQuery(name = "Servicios.findByIdServicio", query = "SELECT s FROM Servicios s WHERE s.idServicio = :idServicio"),
    @NamedQuery(name = "Servicios.findByNomServicio", query = "SELECT s FROM Servicios s WHERE s.nomServicio = :nomServicio"),
    @NamedQuery(name = "Servicios.findByValorServicio", query = "SELECT s FROM Servicios s WHERE s.valorServicio = :valorServicio"),
    @NamedQuery(name = "Servicios.findByTiempoServicio", query = "SELECT s FROM Servicios s WHERE s.tiempoServicio = :tiempoServicio")})
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_servicio")
    private Integer idServicio;
    @Basic(optional = false)
    @Column(name = "nom_servicio")
    private int nomServicio;
    @Basic(optional = false)
    @Column(name = "valor_servicio")
    private int valorServicio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "tiempo_servicio")
    private BigDecimal tiempoServicio;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne(optional = false)
    private Areas idArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio")
    private List<Turnos> turnosList;

    public Servicios() {
    }

    public Servicios(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Servicios(Integer idServicio, int nomServicio, int valorServicio, BigDecimal tiempoServicio) {
        this.idServicio = idServicio;
        this.nomServicio = nomServicio;
        this.valorServicio = valorServicio;
        this.tiempoServicio = tiempoServicio;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public int getNomServicio() {
        return nomServicio;
    }

    public void setNomServicio(int nomServicio) {
        this.nomServicio = nomServicio;
    }

    public int getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(int valorServicio) {
        this.valorServicio = valorServicio;
    }

    public BigDecimal getTiempoServicio() {
        return tiempoServicio;
    }

    public void setTiempoServicio(BigDecimal tiempoServicio) {
        this.tiempoServicio = tiempoServicio;
    }

    public Areas getIdArea() {
        return idArea;
    }

    public void setIdArea(Areas idArea) {
        this.idArea = idArea;
    }

    public List<Turnos> getTurnosList() {
        return turnosList;
    }

    public void setTurnosList(List<Turnos> turnosList) {
        this.turnosList = turnosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicios)) {
            return false;
        }
        Servicios other = (Servicios) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroauto.reservas.entidades.Servicios[ idServicio=" + idServicio + " ]";
    }
    
}
