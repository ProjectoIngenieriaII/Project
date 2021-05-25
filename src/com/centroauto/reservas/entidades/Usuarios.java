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
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author danny
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByNroDocUsuario", query = "SELECT u FROM Usuarios u WHERE u.nroDocUsuario = :nroDocUsuario"),
    @NamedQuery(name = "Usuarios.findByNombres", query = "SELECT u FROM Usuarios u WHERE u.nombres = :nombres"),
    @NamedQuery(name = "Usuarios.findByContrasena", query = "SELECT u FROM Usuarios u WHERE u.contrasena = :contrasena"),
    @NamedQuery(name = "Usuarios.findByTipoUsuario", query = "SELECT u FROM Usuarios u WHERE u.tipoUsuario = :tipoUsuario")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nro_doc_usuario")
    private Long nroDocUsuario;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    @ManyToMany(mappedBy = "usuariosList")
    private List<Areas> areasList;
    @ManyToMany(mappedBy = "usuariosList")
    private List<Opciones> opcionesList;

    public Usuarios() {
    }

    public Usuarios(Long nroDocUsuario) {
        this.nroDocUsuario = nroDocUsuario;
    }

    public Usuarios(Long nroDocUsuario, String nombres, String contrasena, String tipoUsuario) {
        this.nroDocUsuario = nroDocUsuario;
        this.nombres = nombres;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
    }

    public Long getNroDocUsuario() {
        return nroDocUsuario;
    }

    public void setNroDocUsuario(Long nroDocUsuario) {
        this.nroDocUsuario = nroDocUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Areas> getAreasList() {
        return areasList;
    }

    public void setAreasList(List<Areas> areasList) {
        this.areasList = areasList;
    }

    public List<Opciones> getOpcionesList() {
        return opcionesList;
    }

    public void setOpcionesList(List<Opciones> opcionesList) {
        this.opcionesList = opcionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroDocUsuario != null ? nroDocUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.nroDocUsuario == null && other.nroDocUsuario != null) || (this.nroDocUsuario != null && !this.nroDocUsuario.equals(other.nroDocUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroauto.reservas.entidades.Usuarios[ nroDocUsuario=" + nroDocUsuario + " ]";
    }
    
}
