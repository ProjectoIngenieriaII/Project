/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centroauto.reservas.vista;
import com.centroauto.reservas.dao.AreasDao;
import com.centroauto.reservas.dao.CiudadesDao;
import com.centroauto.reservas.dao.DepartamentosDao;
import com.centroauto.reservas.dao.SucursalesDao;
import com.centroauto.reservas.dto.AreasDTO;
import com.centroauto.reservas.dto.SucursalesDTO;
import com.centroauto.reservas.entidades.Ciudades;
import com.centroauto.reservas.entidades.Departamentos;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author danny
 */
public class WinAreasForm extends javax.swing.JFrame {
    
    private WinAreasPpal areasPpal;
    private DepartamentosDao deptoDao;
    private CiudadesDao ciudadDao;
    private SucursalesDao sucursalDao;
    private AreasDao areasDao;
    private AreasDTO areaExistente;
    private boolean modoNuevo;

    /**
     * Creates new form WinAreasForm
     */
    public WinAreasForm() {   
        initComponents();
    }
    
    public WinAreasForm(boolean modoNuevo, AreasDTO areaExistente,
                                WinAreasPpal areasPpal){
        this.modoNuevo = modoNuevo;
        this.areaExistente = areaExistente;
        this.areasPpal = areasPpal;
        initComponents();
        this.setLocationRelativeTo(null);
        deptoDao = new DepartamentosDao();
        ciudadDao = new CiudadesDao();
        sucursalDao = new SucursalesDao();
        llenarDepartamentos();
        llenarEstados();

        //Modo Edición
        if(!this.modoNuevo){
            llenarFormulario();
        }
        //TODO: Bloquear el depto y la ciudad en modo edición        
        this.cmbDeptosForm.setEditable(this.modoNuevo);
        this.cmbCiudadForm.setEditable(this.modoNuevo);
    }
    
    public void llenarFormulario(){
        this.txtNombre.setText(this.areaExistente.getNomArea());     
    }
    
    public void llenarDepartamentos(){
        try{
            List<Departamentos> lstDeptos = deptoDao.consultarDepartamentos();           
            this.cmbDeptosForm.addItem("0 - Seleccione");
            for(Departamentos d : lstDeptos){
                this.cmbDeptosForm.addItem(d.getIdDepto()+" - "+d.getNomDepto());
            }
            //Modo Edición: seleccionar Depto de la sucursal existente
            if(!this.modoNuevo){
                this.cmbDeptosForm.setSelectedItem(
                        this.areaExistente.getIdDepto()+" - "+
                                this.areaExistente.getNomDepto());
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: "+e.getMessage(),
                    "Error Consulta Deptos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
      public void llenarCiudades(){
        ciudadDao = new CiudadesDao();
        Integer idDepto = Integer.parseInt(this.cmbDeptosForm.getSelectedItem().toString().split("-")[0].trim());
        try{  
            if(idDepto > 0){
                this.cmbCiudadForm.removeAllItems();
                this.cmbCiudadForm.addItem("0 - Seleccione");
                List<Ciudades> lstCiudades = 
                    ciudadDao.consultarCiudadesPorDepto(idDepto);            
                for(Ciudades c : lstCiudades){
                    this.cmbCiudadForm.addItem(c.getIdCiudad()+" - "+c.getNomCiudad());
                }
                //Modo Edición: seleccionar ciudad de la sucursal existente 
                if(!this.modoNuevo){
                    this.cmbCiudadForm.setSelectedItem( this.areaExistente.getIdCiudad()+ " - " + this.areaExistente.getNomCiudad());
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: "+e.getMessage(),
                    "Error Consulta Ciudades", JOptionPane.ERROR_MESSAGE);
        }
    }
      
    public void llenarSucursales(){
        sucursalDao = new SucursalesDao();
        Integer idCiudad = Integer.parseInt(this.cmbCiudadForm.getSelectedItem().toString().split(" - ")[0].trim());
        try{
            this.cmbSucursalForm.removeAllItems();
            this.cmbSucursalForm.addItem("0 - Seleccione");
            if(idCiudad > 0){
                List<SucursalesDTO> lstSucursales = sucursalDao.consultarSucursales(null, idCiudad);
                for(SucursalesDTO s : lstSucursales){
                    this.cmbSucursalForm.addItem(s.getIdCiudad() + " - " + s.getNomSucursal());
                }
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error Consulta Sucursales: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void llenarEstados(){
            this.cmbEstadoArea.addItem("0 - Seleccione");
            this.cmbEstadoArea.addItem("H - Habilitada");
            this.cmbEstadoArea.addItem("I - Inhabilitada");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        cmbEstadoArea = new javax.swing.JComboBox<>();
        lblDeptos = new javax.swing.JLabel();
        lblSucursales = new javax.swing.JLabel();
        lblCiudades = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        cmbDeptosForm = new javax.swing.JComboBox<>();
        cmbCiudadForm = new javax.swing.JComboBox<>();
        cmbSucursalForm = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("CREAR / EDITAR AREA");

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombre.setText("NOMBRE:");

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEstado.setText("ESTADO:");

        cmbEstadoArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoAreaActionPerformed(evt);
            }
        });

        lblDeptos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDeptos.setText("DEPARTAMENTOS:");

        lblSucursales.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSucursales.setText("SUCURSAL:");

        lblCiudades.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCiudades.setText("CIUDADES:");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        cmbDeptosForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDeptosFormActionPerformed(evt);
            }
        });

        cmbCiudadForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCiudadFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCiudades)
                                    .addGap(272, 272, 272)
                                    .addComponent(lblSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbSucursalForm, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblNombre)
                                            .addGap(38, 38, 38)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblEstado)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbCiudadForm, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addComponent(lblDeptos)
                                    .addGap(18, 18, 18)
                                    .addComponent(cmbDeptosForm, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbEstadoArea, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGuardar))
                                .addGap(89, 89, 89)
                                .addComponent(btnCancelar)))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitulo)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDeptos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDeptosForm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCiudadForm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSucursalForm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEstadoArea, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbEstadoAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoAreaActionPerformed
        
    }//GEN-LAST:event_cmbEstadoAreaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(this.txtNombre.getText() == null ||
            Integer.parseInt(this.cmbCiudadForm.getSelectedItem().toString()
                .split("-")[0].trim()) == 0){
            JOptionPane.showMessageDialog(this, "Faltan campos por diligenciar",
                "Error Creación Sucursal", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //  Validar modo nuevo o edicion
        AreasDTO a;
        if (this.modoNuevo) {
            a = new AreasDTO();
        } else {
            a = this.areaExistente;
        }
        a.setNomArea(this.txtNombre.getText());
        a.setIdDepto(Integer.parseInt(this.cmbDeptosForm.getSelectedItem().toString().split(" - ")[0].trim()));
        a.setIdCiudad( Integer.parseInt(this.cmbCiudadForm.getSelectedItem().toString().split(" - ")[0].trim()));
        a.setIdSucursal( Integer.parseInt(this.cmbSucursalForm.getSelectedItem().toString().split(" - ")[0].trim()));

        try{
            areasDao.insertarArea(a);
            this.areasPpal.consultarDatos(null, null);
            this.setVisible(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error Creacion Sucursal: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbDeptosFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDeptosFormActionPerformed
        this.llenarCiudades();
    }//GEN-LAST:event_cmbDeptosFormActionPerformed

    private void cmbCiudadFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCiudadFormActionPerformed
        this.llenarSucursales();
    }//GEN-LAST:event_cmbCiudadFormActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WinAreasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WinAreasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WinAreasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WinAreasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WinAreasForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbCiudadForm;
    private javax.swing.JComboBox<String> cmbDeptosForm;
    private javax.swing.JComboBox<String> cmbEstadoArea;
    private javax.swing.JComboBox<String> cmbSucursalForm;
    private javax.swing.JLabel lblCiudades;
    private javax.swing.JLabel lblDeptos;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSucursales;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
