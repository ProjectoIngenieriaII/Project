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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danny
 */
public class AreasDao {

    SucursalesDTO sucursalesDTO = new SucursalesDTO();

    private Conexion conexion;
    private Connection con;

    /**
     * Metodo que consulta las sucursales teniendo en cuenta los filtros
     *
     * @param IdArea
     * @param NomArea
     * @return Lista de sucursales
     * @throws Exception
     */
    public List<AreasDTO> consultarAreas(String nomArea, 
                                                    Integer idSucursal) throws Exception {

        // Conectarse a la base de datos
        conexion = new Conexion();
        con = conexion.conectarBD();
        List<AreasDTO> lstAreas = new ArrayList<>();
        AreasDTO areas = new AreasDTO();
        String sql;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            sql = "select s.id_sucursal,  s.dir_sucursal, ar_s.id_area, a.nom_area ,ar_s.estado_area "
                    + " from sucursales s inner join areas_sucursales ar_s on (s.id_sucursal = ar_s.id_sucursal) inner join areas a on (ar_s.id_area = a.id_area) "
                    + "where 1 = 1 ";
            //sql = "select s.id_sucursal, s.nom_sucursal, s.dir_sucursal, ar_s.id_area, a.nom_area ,ar_s.estado_area  from areas_sucursales ar_s inner join sucursales s inner join areas a on ar_s.id_area = a.id_area;";

            if (nomArea != null) {
                sql += "AND a.nom_area LIKE '%" + nomArea + "%'  ";
            }
            
             if (idSucursal != null) {
                sql += "AND s.id_sucursal = " + idSucursal;
            }
            
           
            // Preparar consulta para ejecutar en la base de datos
            pstm = con.prepareStatement(sql);
            // Obtener resultados de la ejecucion de la consulta
            rs = pstm.executeQuery();
            // Recorrer los resultados
            while (rs.next()) {

                //Armando cada sucursal
                areas = new AreasDTO();
                areas.setIdSucursal(rs.getInt("id_sucursal"));
                areas.setDirSucursal(rs.getString("dir_sucursal"));
                areas.setIdArea(rs.getInt("id_area"));
                areas.setNomArea(rs.getString("nom_area"));
                areas.setEstadoArea(rs.getString("estado_area"));
                lstAreas.add(areas);
            }

            return lstAreas;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            pstm.close();
            rs.close();
            con.close();
        }
    }

    public void insertarArea(AreasDTO areas) throws Exception {
        // Conectarse a la base de datos
        conexion = new Conexion();
        con = conexion.conectarBD();

        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement(" insert into areas(nom_area) values(?)");
            // Reemplazar valores a insertar
            pstm.setString(1, areas.getNomArea().toString());
            pstm.executeUpdate();

        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            pstm.close();
            con.close();
        }
    }

    public void actualizarAreas(AreasDTO areas) throws Exception {
        conexion = new Conexion();
        con = conexion.conectarBD();

        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("update areas set id_area = ? , nom_area = ? ");

            pstm.setInt(1, areas.getIdArea());
            pstm.setString(2, areas.getNomArea().toString());
            pstm.executeUpdate();

        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            pstm.close();
            con.close();
        }
    }

    public void eliminarArea(Integer idArea) throws Exception {
        conexion = new Conexion();
        con = conexion.conectarBD();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("delete from areas where id_area = ?");
            pstm.setInt(1, idArea);
            pstm.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            pstm.close();
            con.close();
        }
    }
}
