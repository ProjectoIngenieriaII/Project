/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservas.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author danny
 */
@Embeddable
public class ClientesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Basic(optional = false)
    @Column(name = "nro_doc_cliente")
    private long nroDocCliente;

    public ClientesPK() {
    }

    public ClientesPK(String tipoDocumento, long nroDocCliente) {
        this.tipoDocumento = tipoDocumento;
        this.nroDocCliente = nroDocCliente;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public long getNroDocCliente() {
        return nroDocCliente;
    }

    public void setNroDocCliente(long nroDocCliente) {
        this.nroDocCliente = nroDocCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDocumento != null ? tipoDocumento.hashCode() : 0);
        hash += (int) nroDocCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientesPK)) {
            return false;
        }
        ClientesPK other = (ClientesPK) object;
        if ((this.tipoDocumento == null && other.tipoDocumento != null) || (this.tipoDocumento != null && !this.tipoDocumento.equals(other.tipoDocumento))) {
            return false;
        }
        if (this.nroDocCliente != other.nroDocCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.centroauto.reservas.entidades.ClientesPK[ tipoDocumento=" + tipoDocumento + ", nroDocCliente=" + nroDocCliente + " ]";
    }
    
}
