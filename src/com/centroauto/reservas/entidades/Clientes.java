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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "clientes")
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByTipoDocumento", query = "SELECT c FROM Clientes c WHERE c.clientesPK.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Clientes.findByNroDocCliente", query = "SELECT c FROM Clientes c WHERE c.clientesPK.nroDocCliente = :nroDocCliente"),
    @NamedQuery(name = "Clientes.findByNomCliente", query = "SELECT c FROM Clientes c WHERE c.nomCliente = :nomCliente"),
    @NamedQuery(name = "Clientes.findByApeCliente", query = "SELECT c FROM Clientes c WHERE c.apeCliente = :apeCliente"),
    @NamedQuery(name = "Clientes.findByCorreoCliente", query = "SELECT c FROM Clientes c WHERE c.correoCliente = :correoCliente"),
    @NamedQuery(name = "Clientes.findByTelCliente", query = "SELECT c FROM Clientes c WHERE c.telCliente = :telCliente")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientesPK clientesPK;
    @Basic(optional = false)
    @Column(name = "nom_cliente")
    private String nomCliente;
    @Basic(optional = false)
    @Column(name = "ape_cliente")
    private String apeCliente;
    @Basic(optional = false)
    @Column(name = "correo_cliente")
    private String correoCliente;
    @Column(name = "tel_cliente")
    private Long telCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientes")
    private List<Turnos> turnosList;

    public Clientes() {
    }

    public Clientes(ClientesPK clientesPK) {
        this.clientesPK = clientesPK;
    }

    public Clientes(ClientesPK clientesPK, String nomCliente, String apeCliente, String correoCliente) {
        this.clientesPK = clientesPK;
        this.nomCliente = nomCliente;
        this.apeCliente = apeCliente;
        this.correoCliente = correoCliente;
    }

    public Clientes(String tipoDocumento, long nroDocCliente) {
        this.clientesPK = new ClientesPK(tipoDocumento, nroDocCliente);
    }

    public ClientesPK getClientesPK() {
        return clientesPK;
    }

    public void setClientesPK(ClientesPK clientesPK) {
        this.clientesPK = clientesPK;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getApeCliente() {
        return apeCliente;
    }

    public void setApeCliente(String apeCliente) {
        this.apeCliente = apeCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public Long getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(Long telCliente) {
        this.telCliente = telCliente;
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
        hash += (clientesPK != null ? clientesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.clientesPK == null && other.clientesPK != null) || (this.clientesPK != null && !this.clientesPK.equals(other.clientesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroauto.reservas.entidades.Clientes[ clientesPK=" + clientesPK + " ]";
    }
    
}
