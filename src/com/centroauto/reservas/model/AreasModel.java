/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservas.model;

import com.centroauto.reservas.dto.AreasDTO;
import com.centroauto.reservas.dto.SucursalesDTO;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author danny
 */
public class AreasModel extends AbstractTableModel {
    
    SucursalesDTO sucursalesDTO = new SucursalesDTO();

    public static final int OBJECT_COL = -1;
    public static final int COL_ID_SUCURSAL = 0;
    public static final int COL_DIR_SUCURSAL = 1;
    public static final int COL_ID_AREA = 2;
    public static final int COL_NOM_AREA = 3;
    public static final int COL_ESTADO_AREA = 4;
    

    private String[] columNames = {"Codigo Sucursal" , "Direccion Sucursal","Codigo Area", "Nombre Area", "Estado Area"};

    private List<AreasDTO> lstAreas;

    // Constructor de la clase
    public AreasModel(List<AreasDTO> lstAreas) {
        this.lstAreas = lstAreas;
    }//SucursalesModel

    /**
     * Metodo que obtiene el numero de columnas de la tabla de sucursales
     *
     * @return num columnas
     */
    public int getColumnCount() {
        return columNames.length;
    }//getColumnCount

    /**
     * Metodo que obtiene el numero de filas de la lista de sucursales
     *
     * @return
     */
    public int getRowCount() {
        if (lstAreas != null && lstAreas.size() > 0) {
            return lstAreas.size();
        } else {
            return 0;
        }
    }//getRowCount

    /**
     * Metodo que obtiene el encabezado de una columna a partir del indice
     *
     * @param indice de la columna
     * @return nombre de la columna
     */
    public String getColumnName(int col) {
        return columNames[col];
    }//getColumName

    public Object getValueAt(int row, int col) {
        AreasDTO a = lstAreas.get(row);
        

        switch (col) {
            case COL_ID_SUCURSAL:
                return a.getIdSucursal();
            case COL_DIR_SUCURSAL:
                return a.getDirSucursal();
            case COL_ID_AREA:
                return a.getIdArea();
            case COL_NOM_AREA:
            return a.getNomArea();
            case COL_ESTADO_AREA:
            return a.getEstadoArea();
            default:
                return a;
        }//SWITCH
    }//getValueAt

}
