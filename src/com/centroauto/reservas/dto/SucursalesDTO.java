/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservas.dto;

/**
 *
 * @author danny
 */
public class SucursalesDTO {
    
    private Integer idSucursal;
    private String nomSucursal;
    private String dirSucursal;
    private Long telSucursal;
    private Integer idCiudad;
    private String nomCiudad;
    private Integer idDepto;
    private String nomDepto;

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

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNomCiudad() {
        return nomCiudad;
    }

    public void setNomCiudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
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
    
    
    
}
