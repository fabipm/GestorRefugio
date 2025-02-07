
package Presentacion;

import Eventos.EventoMenu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JComponent;


public class FrmAsistente extends javax.swing.JFrame {


    public FrmAsistente() {
        initComponents();
        init();
    }
    
    
    public void setNombreVoluntario(String nombre) {
        lblNombreVoluntario.setText(nombre);
    }
    
    private void init(){
     
        setBackground(new Color (0,0,0,0));
        menuVoluntario1.initMoving(this);
        menuVoluntario1.addEventMenu(new EventoMenu(){
            @Override
            public void menuIndexChange(int index){             
                switch (index) {
                    case 0:  //registrar adopcion
                        frmadoptante();
                        break;
                    case 1: // proceso adopcion
                        frmProcesodeAdopcion();
                        break;

                    case 2: // registro animal
                        frmRegistroAnimal();
                        break;
                        
                    case 3: // listar animales
                        frmListarAnimales();
                        break;
                       
                        
                    case 4: // SAFO
                        frmLogin();
                        break;

                }
                 
            }
        });
    }
   
    
    private void frmadoptante() {
        FrmAdoptante frame = new FrmAdoptante();
        frame.setFrmAsistente(this); //ESO
        frame.setPanelHijo(panelPadreV); //ESO
        Container contentPane = frame.getContentPane();
        ((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder());
        contentPane.setLayout(new BorderLayout());
        panelPadreV.removeAll();
        panelPadreV.add(contentPane, BorderLayout.CENTER);
        panelPadreV.revalidate();
        panelPadreV.repaint();
    }
    
    
    private void frmProcesodeAdopcion(){
        FrmProcesoAdopcion frame2 = new FrmProcesoAdopcion();
        Container contentPane = frame2.getContentPane();
        ((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder());
        contentPane.setLayout(new BorderLayout());
        panelPadreV.removeAll();
        panelPadreV.add(contentPane, BorderLayout.CENTER);
        panelPadreV.revalidate();
        panelPadreV.repaint();
    }
    

    private void frmRegistroAnimal(){
        FrmAnimal frame3 = new FrmAnimal();
        Container contentPane = frame3.getContentPane();
        ((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder());
        contentPane.setLayout(new BorderLayout());
        panelPadreV.removeAll();
        panelPadreV.add(contentPane, BorderLayout.CENTER);
        panelPadreV.revalidate();
        panelPadreV.repaint();
    }
    
    private void frmListarAnimales(){
        FrmListarAnimales frame4 = new FrmListarAnimales();
        Container contentPane = frame4.getContentPane();
        ((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder());
        contentPane.setLayout(new BorderLayout());
        panelPadreV.removeAll();
        panelPadreV.add(contentPane, BorderLayout.CENTER);
        panelPadreV.revalidate();
        panelPadreV.repaint();
    }

    private void frmLogin(){
        dispose();
        Login frame5 = new Login();
        frame5.setVisible(true);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo1 = new swing.PanelFondo();
        menuVoluntario1 = new Componente.MenuVoluntario();
        panelPadreV = new swing.PanelFondo();
        jLabel1 = new javax.swing.JLabel();
        lblNombreVoluntario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelFondo1.setBackground(new java.awt.Color(255, 255, 255));

        panelPadreV.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelPadreVLayout = new javax.swing.GroupLayout(panelPadreV);
        panelPadreV.setLayout(panelPadreVLayout);
        panelPadreVLayout.setHorizontalGroup(
            panelPadreVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 835, Short.MAX_VALUE)
        );
        panelPadreVLayout.setVerticalGroup(
            panelPadreVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Bienvenido");

        lblNombreVoluntario.setText("jLabel14");

        javax.swing.GroupLayout panelFondo1Layout = new javax.swing.GroupLayout(panelFondo1);
        panelFondo1.setLayout(panelFondo1Layout);
        panelFondo1Layout.setHorizontalGroup(
            panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuVoluntario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondo1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreVoluntario, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondo1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelPadreV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelFondo1Layout.setVerticalGroup(
            panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondo1Layout.createSequentialGroup()
                .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondo1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblNombreVoluntario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelPadreV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelFondo1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(menuVoluntario1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


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
            java.util.logging.Logger.getLogger(FrmAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAsistente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAsistente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblNombreVoluntario;
    private Componente.MenuVoluntario menuVoluntario1;
    private swing.PanelFondo panelFondo1;
    private swing.PanelFondo panelPadreV;
    // End of variables declaration//GEN-END:variables
}
