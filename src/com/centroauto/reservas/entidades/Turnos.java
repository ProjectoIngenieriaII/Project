/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservas.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "turnos")
@NamedQueries({
    @NamedQuery(name = "Turnos.findAll", query = "SELECT t FROM Turnos t"),
    @NamedQuery(name = "Turnos.findByIdTurno", query = "SELECT t FROM Turnos t WHERE t.idTurno = :idTurno"),
    @NamedQuery(name = "Turnos.findByFechaTurno", query = "SELECT t FROM Turnos t WHERE t.fechaTurno = :fechaTurno"),
    @NamedQuery(name = "Turnos.findByHoraInicio", query = "SELECT t FROM Turnos t WHERE t.horaInicio = :horaInicio"),
    @NamedQuery(name = "Turnos.findByHoraFin", query = "SELECT t FROM Turnos t WHERE t.horaFin = :horaFin"),
    @NamedQuery(name = "Turnos.findByEstadoTurno", query = "SELECT t FROM Turnos t WHERE t.estadoTurno = :estadoTurno"),
    @NamedQuery(name = "Turnos.findByObsTurno", query = "SELECT t FROM Turnos t WHERE t.obsTurno = :obsTurno"),
    @NamedQuery(name = "Turnos.findByCodReserva", query = "SELECT t FROM Turnos t WHERE t.codReserva = :codReserva")})
public class Turnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_turno")
    private Integer idTurno;
    @Basic(optional = false)
    @Column(name = "fecha_turno")
    @Temporal(TemporalType.DATE)
    private Date fechaTurno;
    @Basic(optional = false)
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @Basic(optional = false)
    @Column(name = "estado_turno")
    private String estadoTurno;
    @Column(name = "obs_turno")
    private String obsTurno;
    @Column(name = "cod_reserva")
    private String codReserva;
    @JoinColumns({
        @JoinColumn(name = "tipo_documento", referencedColumnName = "tipo_documento"),
        @JoinColumn(name = "nro_doc_cliente", referencedColumnName = "nro_doc_cliente")})
    @ManyToOne(optional = false)
    private Clientes clientes;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne(optional = false)
    private Servicios idServicio;

    public Turnos() {
    }

    public Turnos(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Turnos(Integer idTurno, Date fechaTurno, Date horaInicio, Date horaFin, String estadoTurno) {
        this.idTurno = idTurno;
        this.fechaTurno = fechaTurno;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estadoTurno = estadoTurno;
    }

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    public Date getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(Date fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public String getEstadoTurno() {
        return estadoTurno;
    }

    public void setEstadoTurno(String estadoTurno) {
        this.estadoTurno = estadoTurno;
    }

    public String getObsTurno() {
        return obsTurno;
    }

    public void setObsTurno(String obsTurno) {
        this.obsTurno = obsTurno;
    }

    public String getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(String codReserva) {
        this.codReserva = codReserva;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Servicios getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicios idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTurno != null ? idTurno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turnos)) {
            return false;
        }
        Turnos other = (Turnos) object;
        if ((this.idTurno == null && other.idTurno != null) || (this.idTurno != null && !this.idTurno.equals(other.idTurno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroauto.reservas.entidades.Turnos[ idTurno=" + idTurno + " ]";
    }
    
}
