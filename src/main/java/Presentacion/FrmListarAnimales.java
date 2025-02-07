/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Config.Conexion;
import static Entidad.clsEVoluntario.Estado.activo;
import Negocio.clsNListarAnimales;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Negocio.clsNListarAnimales;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author RAUL
 */
public class FrmListarAnimales extends javax.swing.JFrame {

    DefaultTableModel modelo;
    private final Conexion conexion;
    private String imagePath;
    private int idAnimalSeleccionado; 
    private String animalactivo = "activo"; 
    
    public FrmListarAnimales() {
        initComponents();
        conexion = new Conexion(); // Inicializa la conexión a la base de datos
        cargarDatosTabla();
        getContentPane().setBackground(Color.WHITE); //no borren
    }
    private void cargarDatosTabla() {
    modelo = new DefaultTableModel();
    modelo.addColumn("ID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Raza"); 
    modelo.addColumn("Edad"); 
    modelo.addColumn("Fecha");
    modelo.addColumn("Estado");
    modelo.addColumn("Genero");
    modelo.addColumn("Tipo");

    clsNListarAnimales objNAnimal = new clsNListarAnimales();
    ResultSet rs = objNAnimal.mtdListarAnimal(); // Método para obtener los datos de la tabla

    try {
        while (rs.next()) {
            String[] dato = new String[8]; 
            dato[0] = Integer.toString(rs.getInt("idAnimal"));
            dato[1] = rs.getString("nombre");
            dato[2] = rs.getString("raza"); 
            dato[3] = rs.getString("edad"); 
            dato[4] = rs.getTimestamp("fecha").toString();
            dato[5] = rs.getString("estado");
            dato[6] = rs.getString("genero");
            dato[7] = rs.getString("tipo");

            modelo.addRow(dato);
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de excepciones
    }

    tbAnimales.setModel(modelo);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbAnimales = new javax.swing.JTable();
        lblImagen = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnActivos = new javax.swing.JButton();
        btnInactivos = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbAnimales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IdAnimal", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbAnimales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAnimalesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAnimales);

        lblImagen.setText(" ");

        jButton1.setText("Lista total");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnActivos.setText("Activos");
        btnActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivosActionPerformed(evt);
            }
        });

        btnInactivos.setText("Inactivos");
        btnInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInactivosActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(244, 92, 69));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("LISTA ANIMALES");
        jLabel12.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(538, Short.MAX_VALUE)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jButton1)
                        .addGap(29, 29, 29)
                        .addComponent(btnActivos)
                        .addGap(45, 45, 45)
                        .addComponent(btnInactivos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(310, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnActivos)
                    .addComponent(btnInactivos))
                .addGap(35, 35, 35)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(164, 164, 164)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbAnimalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAnimalesMouseClicked
        // Obtener el índice de la fila seleccionada
        int filaSeleccionada = tbAnimales.getSelectedRow();

        // Verificar si se seleccionó alguna fila
        if (filaSeleccionada != -1) {
            // Obtener el ID del animal seleccionado en la fila
            int idAnimal = Integer.parseInt(tbAnimales.getValueAt(filaSeleccionada, 0).toString());
            idAnimalSeleccionado = idAnimal;

            // Obtener los datos del animal seleccionado de la fila
            String nombre = tbAnimales.getValueAt(filaSeleccionada, 1).toString();
            String raza = tbAnimales.getValueAt(filaSeleccionada, 2).toString(); // Obtener la raza
            String edad = tbAnimales.getValueAt(filaSeleccionada, 3).toString(); // Obtener la edad
            String sexo = tbAnimales.getValueAt(filaSeleccionada, 6).toString();
            String estado = tbAnimales.getValueAt(filaSeleccionada, 5).toString();
            String tipo = tbAnimales.getValueAt(filaSeleccionada, 7).toString(); // El tipo ahora está en la posición 6

            // Mostrar los datos del animal en los campos de texto y comboboxes del formulario

            // Crear una instancia de ClsNAnimal
            clsNListarAnimales objNAnimal = new clsNListarAnimales();
            int newWidth = 300; // Definir el nuevo ancho deseado
            int newHeight = 200; // Definir la nueva altura deseada
            // Obtener la imagen del animal seleccionado y mostrarla en el JLabel lblImagen
            ImageIcon imagen = objNAnimal.mostrarImagenAnimal(idAnimal, newWidth, newHeight);
          lblImagen.setIcon(imagen);
        }
    }//GEN-LAST:event_tbAnimalesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    cargarDatosTabla();      
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivosActionPerformed

            String activo = "activo";           
            // Llamar al método para buscar el animal por su ID
            clsNListarAnimales objNAnimal = new clsNListarAnimales();
            ResultSet resultado = objNAnimal.BuscarporEstado(activo);
            
            // Cargar los datos en la tabla
            cargarDatosTablaAnimalesparecidos(resultado, tbAnimales);
       
    }//GEN-LAST:event_btnActivosActionPerformed

    private void btnInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInactivosActionPerformed
    
            String estado = "inactivo";           
            // Llamar al método para buscar el animal por su ID
            clsNListarAnimales objNAnimal = new clsNListarAnimales();
            ResultSet resultado = objNAnimal.BuscarporEstado(estado);
            
            // Cargar los datos en la tabla
            cargarDatosTablaAnimalesparecidos(resultado, tbAnimales);
       
       
    }//GEN-LAST:event_btnInactivosActionPerformed
    public void cargarDatosTablaAnimalesparecidos(ResultSet resultado, JTable tbAnimales) {
    DefaultTableModel modelo = (DefaultTableModel) tbAnimales.getModel();   
    modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
    try {
        while (resultado.next()) {
            String[] dato = new String[8]; // Se mantiene la cantidad de columnas igual a la del modelo
            dato[0] = Integer.toString(resultado.getInt("idAnimal"));
            dato[1] = resultado.getString("nombre");
            dato[2] = resultado.getString("raza");
            dato[3] = resultado.getString("edad");
            dato[4] = resultado.getTimestamp("fecha").toString();
            dato[5] = resultado.getString("estado");
            dato[6] = resultado.getString("genero");
            dato[7] = resultado.getString("tipo");

            modelo.addRow(dato);
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Manejo de excepciones
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
            java.util.logging.Logger.getLogger(FrmListarAnimales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListarAnimales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListarAnimales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListarAnimales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListarAnimales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivos;
    private javax.swing.JButton btnInactivos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTable tbAnimales;
    // End of variables declaration//GEN-END:variables
}
