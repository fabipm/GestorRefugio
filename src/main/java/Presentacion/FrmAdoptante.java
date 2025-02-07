/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Config.Conexion;
import Entidad.clsEAdoptante;
import Entidad.clsEDistrito;
import Negocio.clsNAdoptante;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;


public class FrmAdoptante extends javax.swing.JFrame {

    private FrmAdmin frmAdmin;
    private FrmAsistente frmAsistente;
    private JPanel panelPadre;

    
    public FrmAdoptante() {
        initComponents();
        mostrarFechaActual();
        cargarDatosComboBox();
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void setFrmPrincipalAdmin(FrmAdmin frmAdmin) {
        this.frmAdmin = frmAdmin;
    }
    public void setFrmAsistente(FrmAsistente frmAsistente) {
        this.frmAsistente = frmAsistente;
    }
    
    public void setPanelHijo(JPanel panelPadre) {
        this.panelPadre = panelPadre;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbDistrito = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtOcupacion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        cmbGenero = new javax.swing.JComboBox<>();
        btnButton = new javax.swing.JButton();
        txtDni = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        btnSiguiente = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jLabel16.setText("DNI");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("fecha");

        jLabel3.setText("nombres");

        jLabel4.setText("Apellido Paterno");

        jLabel5.setText("genero");

        jLabel6.setText("ocupacion");

        jLabel7.setText("celular");

        jLabel8.setText("edad");

        cmbDistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDistritoActionPerformed(evt);
            }
        });

        jLabel9.setText("distrito");

        txtApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPaternoActionPerformed(evt);
            }
        });

        txtOcupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOcupacionActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "femenino", "masculino" }));

        btnButton.setText("Buscar");
        btnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Apellido Materno");

        txtApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMaternoActionPerformed(evt);
            }
        });

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        jLabel17.setText("DNI");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(244, 92, 69));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("REGISTRO ADOPTANTE");
        jLabel12.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(177, 177, 177)
                                        .addComponent(jLabel17))
                                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(202, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel2)))
                                .addGap(37, 37, 37)
                                .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEdad)
                                    .addComponent(cmbDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnSiguiente)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(146, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel12)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel12)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnSiguiente))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDistritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDistritoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       clsEAdoptante objEAdop = new clsEAdoptante();
        clsEDistrito objDi = new clsEDistrito();

        // GENERO

        String generoSeleccionadoStr = (String) cmbGenero.getSelectedItem();
        clsEAdoptante.Genero generoSeleccionado = null;

        if (generoSeleccionadoStr.equals("masculino")) {
            generoSeleccionado = clsEAdoptante.Genero.masculino;
        } else if (generoSeleccionadoStr.equals("femenino")) {
            generoSeleccionado = clsEAdoptante.Genero.femenino;
        }

        objEAdop.setDni(txtDni.getText());
        objEAdop.setFecha(LocalDate.parse(txtFecha.getText())); // Asumiendo que txtFecha contiene la fecha en formato adecuado
        objEAdop.setNombres(txtNombres.getText());
        objEAdop.setApellidoPaterno(txtApellidoPaterno.getText());
        objEAdop.setApellidoMaterno(txtApellidoMaterno.getText());

        String nombreDistrito = cmbDistrito.getSelectedItem().toString();
        int idDistrito = obteneridDistrito(nombreDistrito);
        objDi.setIddistrito(idDistrito);

        //objDi.setIddistrito(Integer.parseInt(cmbDistrito.getSelectedItem().toString()));

        objEAdop.setGenero(generoSeleccionado);
        objEAdop.setOcupacion(txtOcupacion.getText());
        objEAdop.setEdad(txtEdad.getText());
        objEAdop.setCelular(txtCelular.getText());
        
        
        clsNAdoptante objNAdop = new clsNAdoptante();
        
        
   
//    String dni = txtDni.getText();
//
//    if (dni.isEmpty()) {
//        JOptionPane.showMessageDialog(null, "Debe ingresar un DNI.");
//        return; // Salir del método si el campo DNI está vacío
//    }
//}
//    if (objNAdop.verificarExistenciaAdoptantePorDNI(dni)) {
//        JOptionPane.showMessageDialog(null, "El adoptante ya existe en la base de datos.");
//        return; // Salir del método si el adoptante ya existe
//    }
        
       if (objNAdop.mtdGuardarAdoptante(objEAdop, objDi)) {
        JOptionPane.showMessageDialog(null, "Adoptante guardado correctamente.");
        btnGuardar.setEnabled(false);
    } else {
        JOptionPane.showMessageDialog(null, "Error al intentar guardar el adoptante.");
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtOcupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOcupacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOcupacionActionPerformed

    private void txtApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPaternoActionPerformed

    private void btnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnButtonActionPerformed
        // TODO add your handling code here:
  
        String dni = txtDni.getText(); // Obtén el DNI del campo de texto
        buscarPorDni(dni); // Realiza la búsqueda por DNI utilizando el método creado anteriormente
                      
    }//GEN-LAST:event_btnButtonActionPerformed

    private void txtApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMaternoActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        FrmFormulario frmformulario = new FrmFormulario();
        Container contentPane = frmformulario.getContentPane();
        ((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder());
        contentPane.setLayout(new BorderLayout());
        panelPadre.removeAll();
        panelPadre.add(contentPane, BorderLayout.CENTER);
        panelPadre.revalidate();
        panelPadre.repaint();
        
    }//GEN-LAST:event_btnSiguienteActionPerformed

    
    private void buscarPorDni(String dni) {
   CloseableHttpClient httpClient = HttpClients.createDefault();
    String url = "https://api.apis.net.pe/v2/reniec/dni?numero=" + dni;
    HttpGet httpGet = new HttpGet(url);
    httpGet.addHeader("Authorization", "Bearer apis-token-8196.7bOkUjL8JX2mG-WUQpAM3m5gw2-C-m5T");

    try {
        CloseableHttpResponse response = httpClient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        
        if (statusCode == 200) {
            HttpEntity entity = response.getEntity();
            
            if (entity != null) {
                // Convierte la respuesta JSON en un objeto JSONObject
                JSONObject jsonResponse = new JSONObject(EntityUtils.toString(entity));
                
                // Obtiene el nombre del JSON
                String nombre = jsonResponse.getString("nombres");
                
                // Obtiene el apellido paterno del JSON
                String apellidoPaterno = jsonResponse.getString("apellidoPaterno");
                
                String apellidoMaterno = jsonResponse.getString("apellidoMaterno");
                
                // Actualiza los campos de texto con los valores obtenidos
                txtNombres.setText(nombre);
                txtNombres.setEditable(false);
                txtNombres.setEnabled(false);
                txtApellidoPaterno.setText(apellidoPaterno);
                txtApellidoPaterno.setEditable(false);
                txtApellidoPaterno.setEnabled(false);
                txtApellidoMaterno.setText(apellidoMaterno);
                txtApellidoMaterno.setEditable(false);
                txtApellidoMaterno.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al realizar la solicitud: " + statusCode, "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (IOException | JSONException e) {
        e.printStackTrace();
    }
}
//    private void buscarPorDni(String dni) {
//    // Crea un cliente HTTP
//    CloseableHttpClient httpClient = HttpClients.createDefault();
//    
//    // URL de la API y parámetro DNI
//    String url = "https://api.apis.net.pe/v2/reniec/dni?numero=" + dni;
//
//    // Crea una solicitud GET
//    HttpGet httpGet = new HttpGet(url);
//
//    try {
//        // Ejecuta la solicitud y obtiene la respuesta
//        CloseableHttpResponse response = httpClient.execute(httpGet);
//        try {
//            // Obtiene la entidad de la respuesta
//            HttpEntity entity = response.getEntity();
//            
//            // Si la entidad no es nula, la imprime en un cuadro de diálogo
//            if (entity != null) {
//                String responseBody = EntityUtils.toString(entity);
//                JOptionPane.showMessageDialog(this, responseBody, "Respuesta de la API", JOptionPane.INFORMATION_MESSAGE);
//            }
//        } finally {
//            // Asegúrate de liberar los recursos al finalizar
//            response.close();
//        }
//    } catch (IOException e) {
//        // Maneja cualquier excepción de E/S
//        e.printStackTrace();
//    } finally {
//        try {
//            // Asegúrate de liberar los recursos del cliente HTTP
//            httpClient.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

    
    private void mostrarFechaActual() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        String fechaTexto = fechaActual.toString();

        txtFecha.setText(fechaTexto);
    
    }
    
    private void cargarDatosComboBox() {
        Connection con;
        Conexion cn = new Conexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            // Establecer conexión con la base de datos
            con = (Connection) cn.getConnection(); // Reemplaza "TuClaseDondeEstablecesConexion" con la clase adecuada para obtener la conexión

            // Consulta SQL para obtener los datos de la tabla CARGO
            String sql = "SELECT nombre FROM distrito";

            // Preparar la consulta
            ps = con.prepareStatement(sql);

            // Ejecutar la consulta
            rs = ps.executeQuery();

            // Limpiar el combo box antes de agregar nuevos elementos
            cmbDistrito.removeAllItems();

            // Agregar los elementos del ResultSet al combo box
            while (rs.next()) {
                String nombredistrito = rs.getString("nombre");
                cmbDistrito.addItem(nombredistrito);
            }            
        }catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        } 
    }
    
    private int obteneridDistrito(String nombredistrito) {
        int idDistrito = 0;
        Connection con;
        Conexion cn = new Conexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            // Establecer conexión con la base de datos
            con = (Connection) cn.getConnection(); 

            // Consulta SQL para obtener el ID del cargo
            String sql = "SELECT idDistrito FROM distrito WHERE nombre = ?";

            // Preparar la consulta
            ps = con.prepareStatement(sql);
            ps.setString(1, nombredistrito);

            // Ejecutar la consulta
            rs = ps.executeQuery();

            // Obtener el ID del cargo
            if (rs.next()) {
                idDistrito = rs.getInt("idDistrito");
            }

        }catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }  
        return idDistrito;
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
            java.util.logging.Logger.getLogger(FrmAdoptante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdoptante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdoptante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdoptante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdoptante().setVisible(true);
            }
        });
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnButton;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cmbDistrito;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtOcupacion;
    // End of variables declaration//GEN-END:variables
}
