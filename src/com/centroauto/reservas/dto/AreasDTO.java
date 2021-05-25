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
public class AreasDTO {
    
    private Integer idDepto;
    private String nomDepto;
    private Integer idCiudad;
    private String nomCiudad;
    private Integer idSucursal;
    private String nomSucursal;
    private String dirSucursal;
    private Integer idArea;
    private String nomArea;
    private String estadoArea;
    
    public AreasDTO(){
    
    }

    public void setIdDepto(Integer idDepto) {
        this.idDepto = idDepto;
    }
    
    public Integer getIdDepto() {
        return idDepto;
    }

    public void setNomDepto(String nomDepto) {
        this.nomDepto = nomDepto;
    }
    
    public String getNomDepto() {
        return nomDepto;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }
    
    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setNomCiudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
    }
    
    public String getNomCiudad() {
        return nomCiudad;
    }
    
    public void setIdSucursal(Integer idSucursal){
        this.idSucursal = idSucursal;
    }
    
    public Integer getIdSucursal() {
        return idSucursal;
    }
    
    public void setNomSucursal(String string) {
        this.nomSucursal = nomSucursal;
    }
    
    public Object getNomSucursal() {
        return nomSucursal;
    }
    
    public void setDirSucursal(String dirSucursal){
        this.dirSucursal = dirSucursal;
    }
    public Object getDirSucursal() {
        return dirSucursal;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public Integer getIdArea() {
        return idArea;
    }
    
    public void setNomArea(String nomArea){
        this.nomArea = nomArea;
    }
    
    public String getNomArea(){
        return nomArea;
    }
    
    public void setEstadoArea(String estadoArea) {
        this.estadoArea = estadoArea;
    }

    public Object getEstadoArea() {
        return estadoArea;
    }
}
