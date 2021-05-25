/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservas.dao;

import com.centroauto.reservas.conexion.Conexion;
import com.centroauto.reservas.dto.AreasDTO;
import com.centroauto.reservas.dto.SucursalesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author danny
 */
public class AreasSucursalesDao {
    
    AreasDTO areas = new AreasDTO();

    private Conexion conexion;
    private Connection con;
    
    public void insertarAreaSucursal() throws Exception{
    
        conexion = new Conexion();
        con = conexion.conectarBD();
        PreparedStatement pstm = null;
        int idarea = 0;
        
        try{
            pstm = con.prepareStatement(" select max (id_area) + 1 as idarea from areas ");
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
             idarea = rs.getInt("idarea");
            }
            
            pstm = con.prepareStatement("insert into areas (nom_area) "
                    + "values (?) " );
            pstm.setString(1,areas.getNomArea());
            idarea = pstm.executeUpdate();
            
            pstm = con.prepareStatement("insert into areas_sucursales (estado_area, id_sucursal, id_area ) "
                    + " values (?,?,?) " );
            
            pstm.setString(1, areas.getEstadoArea().toString());
            pstm.setInt(2, areas.getIdSucursal());
            pstm.setInt(3, idarea);
            
            pstm.executeUpdate();
        }catch(Exception e){
            throw new Exception(e);
        } finally {
            pstm.close();
            con.close();
        }     
    } 
}
