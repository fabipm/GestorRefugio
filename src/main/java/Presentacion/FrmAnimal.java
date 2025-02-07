
package Presentacion;
import Config.Conexion;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import Negocio.ClsNAnimal;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author RAUL
 */
public class FrmAnimal extends javax.swing.JFrame {

    /**
     * Creates new form FrmAnimal
     */
    DefaultTableModel modelo;
    private final Conexion conexion;
    private String imagePath;
    private int idAnimalSeleccionado; 
    
    public FrmAnimal() {
        initComponents();
        conexion = new Conexion(); // Inicializa la conexión a la base de datos
        cargarDatosTabla();
        cargarDatosComboBox();
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

    ClsNAnimal objNAnimal = new ClsNAnimal();
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

    
    private void cargarDatosComboBox() {
    // Elimina cualquier elemento previo en el JComboBox
    cmbSexo.removeAllItems();
    
    // Agrega las nuevas opciones al JComboBox
    cmbSexo.addItem("macho");
    cmbSexo.addItem("hembra");
    
    cmbTipo.removeAllItems();
    cmbTipo.addItem("perro");
    cmbTipo.addItem("gato");
    
    cmbEstado.removeAllItems();
    cmbEstado.addItem("activo");
    cmbEstado.addItem("inactivo");

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbAnimales = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscarID = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSubirImagen = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        cmbSexo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtRaza = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
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
        if (tbAnimales.getColumnModel().getColumnCount() > 0) {
            tbAnimales.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jLabel2.setText("Nombre :");

        jLabel3.setText("Sexo:");

        jLabel4.setText("Tipo de Animal:");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnActualizar.setText("Actulizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBuscarID.setText("Buscar Animal Por ID");
        btnBuscarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarIDActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscarID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(btnLimpiar)
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnSubirImagen.setText("Imagen");
        btnSubirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirImagenActionPerformed(evt);
            }
        });

        jLabel5.setText("Cargar imagen:");

        lblImagen.setText(" ");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSexoActionPerformed(evt);
            }
        });

        jLabel6.setText("Estado:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Raza:");

        jLabel8.setText("Edad:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(244, 92, 69));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("REGISTRO ANIMAL");
        jLabel12.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(67, 67, 67)
                                                        .addComponent(jLabel4))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(8, 8, 8)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addComponent(jLabel5))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnSubirImagen)))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubirImagen)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubirImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirImagenActionPerformed

    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

    // Filtrar solo archivos de imagen
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png", "gif");
    fileChooser.setFileFilter(filter);

    int result = fileChooser.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        imagePath = selectedFile.getAbsolutePath(); // Almacena la ruta de la imagen seleccionada en la variable
    }
    }//GEN-LAST:event_btnSubirImagenActionPerformed
   
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
        txtNombre.setText(nombre);
        txtRaza.setText(raza); 
        txtEdad.setText(edad); 
        cmbSexo.setSelectedItem(sexo);
        cmbEstado.setSelectedItem(estado);
        cmbTipo.setSelectedItem(tipo);
        
        // Crear una instancia de ClsNAnimal
        ClsNAnimal objNAnimal = new ClsNAnimal();
        int newWidth = 300; // Definir el nuevo ancho deseado
        int newHeight = 200; // Definir la nueva altura deseada
        // Obtener la imagen del animal seleccionado y mostrarla en el JLabel lblImagen
        ImageIcon imagen = objNAnimal.mostrarImagenAnimal(idAnimal, newWidth, newHeight);
        lblImagen.setIcon(imagen);
    } 
    }//GEN-LAST:event_tbAnimalesMouseClicked
    
    
    
    
    private void btnBuscarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarIDActionPerformed
    // Mostrar un cuadro de diálogo de entrada para que el usuario ingrese la ID del animal a buscar
    String input = JOptionPane.showInputDialog(this, "Ingrese la ID del animal a buscar:");

    // Verificar si se ingresó algún valor
    if (input != null && !input.isEmpty()) {
        // Convertir la entrada a un entero
        try {
            int idAnimal = Integer.parseInt(input);
            
            idAnimalSeleccionado = idAnimal;
            
            // Llamar al método para buscar el animal por su ID
            ClsNAnimal objNAnimal = new ClsNAnimal();
            ResultSet resultado = objNAnimal.buscarAnimalPorId(idAnimal);
            
            // Cargar los datos en la tabla
            cargarDatosTablaAnimalesparecidos(resultado, tbAnimales);
        } catch (NumberFormatException e) {
            // Manejar el caso en que la entrada no sea un número
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }        
    }//GEN-LAST:event_btnBuscarIDActionPerformed
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
     // Obtener los valores de los campos de texto
    String nombre = txtNombre.getText();
    String edad = txtEdad.getText();
    String raza = txtRaza.getText();
    String sexo = cmbSexo.getSelectedItem().toString();
    String tipo = cmbTipo.getSelectedItem().toString();
    String estado = cmbEstado.getSelectedItem().toString();

    // Verificar que los campos no estén vacíos
    if (!nombre.isEmpty() && !edad.isEmpty() && !raza.isEmpty()) {
        // Verificar que se haya seleccionado una imagen
        if (imagePath != null) {
            // Crear una instancia de ClsNAnimal para manejar la lógica de negocio
            ClsNAnimal objNAnimal = new ClsNAnimal();

            // Si la imagen se guarda en la base de datos y los datos del animal se insertan correctamente
            if (objNAnimal.insertarDatosAnimal(nombre, sexo, tipo, estado, imagePath, raza, edad)) {
                JOptionPane.showMessageDialog(this, "Los datos se han guardado correctamente en la base de datos.");
                cargarDatosTabla(); // Actualizar la tabla después de guardar los datos
                imagePath = null;
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar los datos en la base de datos.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una imagen.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
     // Verificar si se ha seleccionado un animal
    if (idAnimalSeleccionado != 0) {
        // Obtener los nuevos valores de los campos de texto
        String nuevoNombre = txtNombre.getText();
        String nuevoSexo = cmbSexo.getSelectedItem().toString();
        String nuevoTipo = cmbTipo.getSelectedItem().toString();
        String nuevoEstado = cmbEstado.getSelectedItem().toString();
        String nuevaRaza = txtRaza.getText(); 
        String nuevaEdad = txtEdad.getText(); 

        // Verificar si se ha seleccionado una nueva imagen
        if (imagePath != null) {
            // Llamar al método para actualizar los datos del animal junto con la nueva imagen
            ClsNAnimal objNAnimal = new ClsNAnimal();
            boolean actualizado = objNAnimal.actualizarDatosAnimal(idAnimalSeleccionado, nuevoNombre, nuevoSexo, nuevoTipo, 
                nuevoEstado, nuevaRaza, nuevaEdad,imagePath);
            
            // Verificar si los datos se actualizaron correctamente
            if (actualizado) {
                JOptionPane.showMessageDialog(this, "Los datos del animal se actualizaron correctamente.");
                // Recargar la tabla con los datos actualizados
                cargarDatosTabla();
                // Limpiar el valor de la imagen
                imagePath = null;
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar los datos del animal.");
            }
        } else {
            // Si no se seleccionó una nueva imagen, llamar al método para actualizar los datos del animal sin cambiar la imagen
            ClsNAnimal objNAnimal = new ClsNAnimal();
            boolean actualizado = objNAnimal.actualizarDatosAnimalsinfoto(idAnimalSeleccionado, nuevoNombre, nuevoSexo, nuevoTipo,
                nuevoEstado, nuevaRaza, nuevaEdad);
            
            // Verificar si los datos se actualizaron correctamente
            if (actualizado) {
                JOptionPane.showMessageDialog(this, "Los datos del animal se actualizaron correctamente.");
                // Recargar la tabla con los datos actualizados
                cargarDatosTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar los datos del animal...");
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un animal de la tabla antes de actualizar.");
    }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void cmbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSexoActionPerformed
 
    }//GEN-LAST:event_cmbSexoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
    // Limpiar el campo txtNombre
    txtNombre.setText("");
    txtRaza.setText("");
    txtEdad.setText("");
    // Recargar los datos en la tabla  
    cargarDatosTabla();      
    }//GEN-LAST:event_btnLimpiarActionPerformed

    
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
            java.util.logging.Logger.getLogger(FrmAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAnimal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscarID;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSubirImagen;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTable tbAnimales;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRaza;
    // End of variables declaration//GEN-END:variables


}
