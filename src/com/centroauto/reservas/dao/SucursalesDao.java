/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservas.dao;

import com.centroauto.reservas.conexion.Conexion;
import com.centroauto.reservas.dto.SucursalesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danny
 */
public class SucursalesDao {

    private Conexion conexion;
    private Connection con;

    /**
     * Metodo que consulta las sucursales teniendo en cuenta los filtros
     *
     * @param nomSucursal
     * @param idCiudad
     * @return Lista de sucursales
     * @throws Exception
     */
    public List<SucursalesDTO> consultarSucursales(String nomSucursal, 
                                                    Integer idCiudad) throws Exception{
        //Conectarse a la BD
        conexion = new Conexion();
        con = conexion.conectarBD();
        List<SucursalesDTO> lstSucursales = new ArrayList<>();
        SucursalesDTO sucursal = new SucursalesDTO();
        String sql;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try{
           sql = "SELECT s.id_sucursal, s.nom_sucursal, s.dir_sucursal, "
                   + " s.tel_sucursal, c.id_ciudad, c.nom_ciudad, d.id_depto, "
                   + " d.nom_depto FROM sucursales s INNER JOIN ciudades c ON "
                   + " (s.id_ciudad = c.id_ciudad) INNER JOIN departamentos d ON "
                   + " (c.id_depto = d.id_depto) WHERE 1=1 "; 
           if(nomSucursal != null){
               sql += "AND s.nom_sucursal LIKE '%" + nomSucursal + "%'  ";
           }
           if(idCiudad != null){
               sql += "AND c.id_ciudad = "+idCiudad;
           }
           sql += " order by s.id_sucursal asc";
           //Preparar consulta para ejecutar en BD
           pstm = con.prepareStatement(sql);
           //Obtener resultados de la ejecución de la consulta
           rs = pstm.executeQuery();
           //Recorrer los resultados
           while(rs.next()){
               //Armar cada sucursal
               sucursal = new SucursalesDTO();
               sucursal.setIdSucursal(rs.getInt("id_sucursal"));
               sucursal.setNomSucursal(rs.getString("nom_sucursal"));
               sucursal.setDirSucursal(rs.getString("dir_sucursal"));
               sucursal.setTelSucursal(rs.getLong("tel_sucursal"));
               sucursal.setIdCiudad(rs.getInt("id_ciudad"));
               sucursal.setNomCiudad(rs.getString("nom_ciudad"));
               sucursal.setIdDepto(rs.getInt("id_depto"));
               sucursal.setNomDepto(rs.getString("nom_depto"));
               
               lstSucursales.add(sucursal);
           }
           return lstSucursales;           
        }catch(Exception e){
            throw new Exception(e);
        }finally{
            pstm.close();
            rs.close();
            con.close();
        }                     
    }
   
   public void insertarSucursal(SucursalesDTO sucursal) throws Exception{
        //Conectarse a la BD
        conexion = new Conexion();
        con = conexion.conectarBD();
        
        PreparedStatement pstm = null;
        
        try{
            pstm = 
               con.prepareStatement("insert into sucursales (nom_sucursal, "
                   + "dir_sucursal, tel_sucursal, id_ciudad) values(?,?,?,?)");
            //Reemplazar valores a insertar
            pstm.setString(1, sucursal.getNomSucursal());
            pstm.setString(2, sucursal.getDirSucursal());
            pstm.setLong(3, sucursal.getTelSucursal());
            pstm.setInt(4, sucursal.getIdCiudad());
            
            pstm.executeUpdate();
            
        }catch(Exception e){
            throw new Exception(e);
        }finally{
            pstm.close();
            con.close();
        }
    }

    public void actualizarSucursales(SucursalesDTO sucursales) throws Exception {
        conexion = new Conexion();
        con = conexion.conectarBD();

        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("update sucursales set nom_sucursal = ? , dir_sucursal = ?, tel_sucursal = ? where id_sucursal = ?");
            pstm.setString(1, sucursales.getNomSucursal());
            pstm.setString(2, sucursales.getDirSucursal());
            pstm.setLong(3, sucursales.getTelSucursal());
            pstm.setInt(4, sucursales.getIdCiudad());
            pstm.executeUpdate();

        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            pstm.close();
            con.close();
        }
    }

    public void eliminarSucursales(Integer idSucursal) throws Exception {
        conexion = new Conexion();
        con = conexion.conectarBD();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("delete from sucursales where id_sucursal = ?");
            pstm.setInt(1, idSucursal);
            pstm.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            pstm.close();
            con.close();
        }
    }

}
