package com.centroauto.reservas.dao;

import com.centroauto.reservas.conexion.Conexion;
import com.centroauto.reservas.entidades.Departamentos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danny
 */
public class DepartamentosDao {

    private Conexion conexion;
    private Connection con;

    public List<Departamentos> consultarDepartamentos() throws Exception {
        String sql = "select id_depto, nom_depto from departamentos";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Departamentos> lstDeptos = new ArrayList<>();
        try {
            conexion = new Conexion();
            con = conexion.conectarBD();

            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Departamentos d = new Departamentos();
                d.setIdDepto(rs.getInt("id_depto"));
                d.setNomDepto(rs.getString("nom_depto"));

                lstDeptos.add(d);
            }

            return lstDeptos;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            pstm.close();
            rs.close();
            con.close();
        }
    }
}
