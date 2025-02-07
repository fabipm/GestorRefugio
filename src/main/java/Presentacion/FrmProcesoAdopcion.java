/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import java.awt.Color;


import Config.Conexion;
import Negocio.clsNFormularioAdopcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import Entidad.clsEFormularioAdopcion;
import Entidad.clsEFormularioAdopcion.Estado;
import Entidad.clsEEvidencia;

/**
 *
 * @author zouoz
 */
public class FrmProcesoAdopcion extends javax.swing.JFrame {

    
    DefaultTableModel modelo;
    public FrmProcesoAdopcion() {
        initComponents();
        configurarTabla();
        getContentPane().setBackground(Color.WHITE); //no borren
        cargasDatos();
        cargarDatosComboBoxEvidencia();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProcesoAdop = new javax.swing.JTable();
        txtID = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbEvidencia = new javax.swing.JComboBox<>();
        btnActulizar = new javax.swing.JButton();
        btnRecargar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(244, 92, 69));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Procesos de adopcion");
        jLabel11.setToolTipText("");

        tblProcesoAdop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProcesoAdop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProcesoAdopMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProcesoAdop);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "aprobado", "pendiente", "rechazado" }));

        jLabel1.setText("Estado:");

        jLabel2.setText("Visita Domiciliaria:");

        cmbEvidencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnActulizar.setText("Actulizar");
        btnActulizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActulizarActionPerformed(evt);
            }
        });

        btnRecargar.setText("Recargar");
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(215, 215, 215))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnLimpiar)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmbEvidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnActulizar)
                                    .addGap(39, 39, 39)
                                    .addComponent(btnRecargar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(txtID)))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbEvidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActulizar)
                    .addComponent(btnRecargar))
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProcesoAdopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProcesoAdopMouseClicked
        // Obtener el índice de la fila seleccionada
        int filaSeleccionada = tblProcesoAdop.getSelectedRow();

        // Obtener el valor del ID de la fila seleccionada
        String id = tblProcesoAdop.getValueAt(filaSeleccionada, 0).toString();
        // Establecer el ID en el JTextField txtID
        txtID.setText(id);

        // Obtener el valor de la columna "Estado" de la fila seleccionada
        String estado = tblProcesoAdop.getValueAt(filaSeleccionada, 2).toString();
        // Establecer el estado en el JComboBox cmbEstado
        cmbEstado.setSelectedItem(estado);

        // Obtener el valor de la columna "Evidencia" de la fila seleccionada
        String evidencia = tblProcesoAdop.getValueAt(filaSeleccionada, 4).toString();
        // Establecer la evidencia en el JComboBox cmbEvidencia
        cmbEvidencia.setSelectedItem(evidencia);
    }//GEN-LAST:event_tblProcesoAdopMouseClicked

    private void btnActulizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActulizarActionPerformed
        clsEFormularioAdopcion objFA = new clsEFormularioAdopcion();
        clsNFormularioAdopcion objNFA = new clsNFormularioAdopcion();
        clsEEvidencia objEE = new clsEEvidencia();
        // Obtener el índice de la fila seleccionada
        int filaSeleccionada = tblProcesoAdop.getSelectedRow();

        // Obtener el valor del ID de la fila seleccionada
        int id = Integer.parseInt(tblProcesoAdop.getValueAt(filaSeleccionada, 0).toString());
        // Obtener el objeto Estado seleccionado del JComboBox cmbEstado
        //  Estado estadoSeleccionado = (Estado) cmbEstado.getSelectedItem();
        // Obtener el valor seleccionado del JComboBox cmbEstado como un String
        String estadoSeleccionadoStr = cmbEstado.getSelectedItem().toString();

        // Convertir el String al enum Estado
        Estado estadoSeleccionado = Estado.valueOf(estadoSeleccionadoStr);

        // Obtener el valor seleccionado del JComboBox cmbEvidencia
        String nombreEvidencia = cmbEvidencia.getSelectedItem().toString();
        // Suponiendo que tienes una lista de objetos clsEEvidencia disponibles y puedes buscar el ID de la evidencia por su nombre
        int idEvidencia = buscarIdEvidenciaPorNombre(nombreEvidencia);

        // Establecer los valores en el objeto objFA
        objFA.setIdformularioadopcion(id);
        objFA.setEstado(estadoSeleccionado);
        objEE.setIdevidencia(idEvidencia);

        // Luego puedes hacer lo que necesites con el objeto objFA
        // Por ejemplo, llamar a un método para procesarlo
        objNFA.actulizarProceso(objFA,objEE);
    }//GEN-LAST:event_btnActulizarActionPerformed
    
    
    public int buscarIdEvidenciaPorNombre(String nombreEvidencia){
        if (nombreEvidencia.equals("no")) {
            return 1;
        } else {
            return 2;
        }

    
    }
    
    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        cargasDatos();        // TODO add your handling code here:
    }//GEN-LAST:event_btnRecargarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        mtdLimpiarTabla();
    }//GEN-LAST:event_btnLimpiarActionPerformed
    
     private void configurarTabla(){
        // INICILIAR COLUMNAS DE LA TABLA
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Fecha Registro");
        modelo.addColumn("Estado");
        modelo.addColumn("Adoptante");
        modelo.addColumn("Evidencia");
        modelo.addColumn("Nombre de Registrante");
        tblProcesoAdop.setModel(modelo);
        
        // Configurar el tamaño de cada columna
        tblProcesoAdop.getColumnModel().getColumn(0).setPreferredWidth(40); // Tamaño de la primera columna (Código)
        tblProcesoAdop.getColumnModel().getColumn(1).setPreferredWidth(60); // Tamaño de la segunda columna (Fecha Registro)
        tblProcesoAdop.getColumnModel().getColumn(2).setPreferredWidth(40); // Tamaño de la tercera columna (Estado)
        tblProcesoAdop.getColumnModel().getColumn(3).setPreferredWidth(100); // Tamaño de la cuarta columna (Adoptante)
        tblProcesoAdop.getColumnModel().getColumn(4).setPreferredWidth(20); // Tamaño de la quinta columna (Evidencia)
        tblProcesoAdop.getColumnModel().getColumn(5).setPreferredWidth(100); // Tamaño de la sexta columna (Nombre de Registrante)

    }

    private void cargasDatos(){
        //mtdLimpiarTabla();
        clsNFormularioAdopcion objNFA = new clsNFormularioAdopcion();
        ResultSet rs = objNFA.mtdListarProcesoAdopcion();
        try {
            while (rs.next()) {
                String dato[] = new String[6];
                dato[0] = rs.getString("idFormularioAdopcion");
                dato[1] = rs.getString("fecha");
                dato[2] = rs.getString("estado");
                // Obteniendo el nombre del adoptante a través del idAdoptante
                int idAdoptante = rs.getInt("idAdoptante");
                String nombreAdoptante = objNFA.obtenerNombreAdoptante(idAdoptante);
                dato[3] = nombreAdoptante;
                // Obteniendo la descripción de la evidencia a través del idEvidencia
                int idEvidencia = rs.getInt("idEvidencia");
                String descripcionEvidencia = objNFA.obtenerDescripcionEvidencia(idEvidencia);
                dato[4] = descripcionEvidencia;
                dato[5] = rs.getString("nombre");
                modelo.addRow(dato);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        tblProcesoAdop.setModel(modelo);
    
    }
    
    
       
        
  

    
        
        private void cargarDatosComboBoxEvidencia() {
        Connection con;
        Conexion cn = new Conexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            // Establecer conexión con la base de datos
            con = (Connection) cn.getConnection(); // Reemplaza "TuClaseDondeEstablecesConexion" con la clase adecuada para obtener la conexión

            // Consulta SQL para obtener los datos de la tabla CARGO
            String sql = "SELECT nombre FROM evidencia";

            // Preparar la consulta
            ps = con.prepareStatement(sql);

            // Ejecutar la consulta
            rs = ps.executeQuery();

            // Limpiar el combo box antes de agregar nuevos elementos
            cmbEvidencia.removeAllItems();

            // Agregar los elementos del ResultSet al combo box
            while (rs.next()) {
                String estadoEvidencia = rs.getString("nombre"); // Obtener el nombre del cargo
                cmbEvidencia.addItem(estadoEvidencia); // Agregar el nombre del cargo al ComboBox
            }
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
           
            
        }  
    
    }

    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(FrmProcesoAdopcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProcesoAdopcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProcesoAdopcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProcesoAdopcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProcesoAdopcion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActulizar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbEvidencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProcesoAdop;
    private javax.swing.JLabel txtID;
    // End of variables declaration//GEN-END:variables
    private void mtdLimpiarTabla(){
        for(int i = 0; i < modelo.getRowCount(); i++){
        modelo.removeRow(i);
        i -= 1;
        }
    }



}
