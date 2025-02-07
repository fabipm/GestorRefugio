
package Presentacion;

import Eventos.EventoMenu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JComponent;




public class FrmAdmin extends javax.swing.JFrame {


    public FrmAdmin() {
        initComponents();
        init();
    }
    
    private void init(){
     
        setBackground(new Color (0,0,0,0));
        menuAdmin2.initMoving(this);
        menuAdmin2.addEventMenu(new EventoMenu(){
            @Override
            public void menuIndexChange(int index){             
                switch (index) {
                    case 0:  //registrar adopcion
                        frmadoptante();
                        break;
                    case 1: // proceso adopcion
                        frmProcesodeAdopcion();
                        break;
                    case 2: // registro voluntario
                        frmRegistroVoluntario();
                        break;
                    case 3: // registro animal
                        frmRegistroAnimal();
                        break;
                        
                    case 4: // listar animales
                        frmListarAnimales();
                        break;
                        
                    case 5: // reportes
                        frmReportes();
                        break;
                        
                    case 6: // SAFO
                        frmLogin();
                        break;

                }
                 
            }
        });
    }
 
    private void frmadoptante() {
        FrmAdoptante frame = new FrmAdoptante();
        frame.setFrmPrincipalAdmin(this); //ESO
        frame.setPanelHijo(panelPadre); //ESO
        Container contentPane = frame.getContentPane();
        ((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder());
        contentPane.setLayout(new BorderLayout());
        panelPadre.removeAll();
        panelPadre.add(contentPane, BorderLayout.CENTER);
        panelPadre.revalidate();
        panelPadre.repaint();
    }
    
    
    private void frmProcesodeAdopcion(){
        FrmProcesoAdopcion frame2 = new FrmProcesoAdopcion();
        Container contentPane = frame2.getContentPane();
        ((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder());
        contentPane.setLayout(new BorderLayout());
        panelPadre.removeAll();
        panelPadre.add(contentPane, BorderLayout.CENTER);
        panelPadre.revalidate();
        panelPadre.repaint();
    }
    
    private void frmRegistroVoluntario(){
        FrmRegistroVoluntario frame3 = new FrmRegistroVoluntario();
        Container contentPane = frame3.getContentPane();
        ((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder());
        contentPane.setLayout(new BorderLayout());
        panelPadre.removeAll();
        panelPadre.add(contentPane, BorderLayout.CENTER);
        panelPadre.revalidate();
        panelPadre.repaint();
    }
    
    private void frmRegistroAnimal(){
        FrmAnimal frame4 = new FrmAnimal();
        Container contentPane = frame4.getContentPane();
        ((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder());
        contentPane.setLayout(new BorderLayout());
        panelPadre.removeAll();
        panelPadre.add(contentPane, BorderLayout.CENTER);
        panelPadre.revalidate();
        panelPadre.repaint();
    }
    
    private void frmListarAnimales(){
        FrmListarAnimales frame5 = new FrmListarAnimales();
        Container contentPane = frame5.getContentPane();
        ((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder());
        contentPane.setLayout(new BorderLayout());
        panelPadre.removeAll();
        panelPadre.add(contentPane, BorderLayout.CENTER);
        panelPadre.revalidate();
        panelPadre.repaint();
    }
    private void frmReportes(){
        FrmReportes frame6 = new FrmReportes();
        Container contentPane = frame6.getContentPane();
        ((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder());
        contentPane.setLayout(new BorderLayout());
        panelPadre.removeAll();
        panelPadre.add(contentPane, BorderLayout.CENTER);
        panelPadre.revalidate();
        panelPadre.repaint();
    }
    
    private void frmLogin(){
        dispose();
        Login frame7 = new Login();
        frame7.setVisible(true);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo1 = new swing.PanelFondo();
        panelPadre = new swing.PanelFondo();
        menuAdmin2 = new Componente.MenuAdmin();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelFondo1.setBackground(new java.awt.Color(255, 255, 255));

        panelPadre.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelPadreLayout = new javax.swing.GroupLayout(panelPadre);
        panelPadre.setLayout(panelPadreLayout);
        panelPadreLayout.setHorizontalGroup(
            panelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 835, Short.MAX_VALUE)
        );
        panelPadreLayout.setVerticalGroup(
            panelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelFondo1Layout = new javax.swing.GroupLayout(panelFondo1);
        panelFondo1.setLayout(panelFondo1Layout);
        panelFondo1Layout.setHorizontalGroup(
            panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuAdmin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPadre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelFondo1Layout.setVerticalGroup(
            panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuAdmin2, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addComponent(panelPadre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Componente.MenuAdmin menuAdmin2;
    private swing.PanelFondo panelFondo1;
    private swing.PanelFondo panelPadre;
    // End of variables declaration//GEN-END:variables
}
