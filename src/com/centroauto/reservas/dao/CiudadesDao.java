/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservas.dao;

import com.centroauto.reservas.conexion.Conexion;
import com.centroauto.reservas.entidades.Ciudades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danny
 */
public class CiudadesDao {

    private Conexion conexion;
    private Connection con;

        public List<Ciudades> consultarCiudadesPorDepto(Integer idDepto) throws Exception{
        List<Ciudades> lstCiudades = new ArrayList<Ciudades>();
        Ciudades c = new Ciudades();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try{
            conexion = new Conexion();
            con = conexion.conectarBD();
            pstm = con.prepareStatement("select c.id_ciudad, c.nom_ciudad "
                    + "from ciudades c inner join departamentos d "
                    + "on (c.id_depto = d.id_depto) "
                    + "where c.id_depto = ? ");
            pstm.setInt(1, idDepto);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                c = new Ciudades();
                c.setIdCiudad(rs.getInt("id_ciudad"));
                c.setNomCiudad(rs.getString("nom_ciudad"));
                lstCiudades.add(c);
            }
            return lstCiudades;
        }catch(Exception e){
            throw new Exception(e);
        }finally{
            pstm.close();
            rs.close();
            con.close();
        }
    }
}

