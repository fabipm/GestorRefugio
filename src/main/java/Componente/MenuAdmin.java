package Componente;

import Entidad.clsEMenu;
import Eventos.EventoMenuCallBack;
import Eventos.EventoMenu;
import Eventos.EventoMenuSelected;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Path2D;
import javax.swing.JFrame;



public class MenuAdmin extends javax.swing.JPanel {
    
    public void addEventMenu(EventoMenu event){
        this.event =event;
    }
    
    private int selectedIndex = -1;
    private final Timer timer;
    private boolean toUp; // para animacion es go up
    private int menuYTarget;
    private int menuY;
    private int speed = 2;
    private EventoMenuCallBack callBack;
    private EventoMenu event;

    public MenuAdmin() {
        initComponents();
        setOpaque(false);
        listaMenu.setOpaque(false);
        listaMenu.addEventSelectedMenu(new EventoMenuSelected() {
            @Override
            public void menuSelected(int index, EventoMenuCallBack callback) {
                if (index != selectedIndex){
                    MenuAdmin.this.callBack = callback;
                    toUp =selectedIndex > index;
                    if(selectedIndex==-1){
                        speed=20;
                    } else {
                        speed = selectedIndex - index;
                        if (speed < 0){
                            speed*= -1;                           
                        }
                    }
                    speed++;
                    selectedIndex =index;
                    menuYTarget=selectedIndex * 41 + listaMenu.getY(); //menuYTarget is location Y
                    if (!timer.isRunning()){
                        timer.start();
                    }
                }
            }
        });
        timer = new Timer(0, new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent ae){
                if(toUp) {
                    if(menuY<=menuYTarget - 5) {
                       menuY = menuYTarget;
                       repaint();
                       timer.stop();
                       callBack.call(selectedIndex);
                       if(event!=null){
                           event.menuIndexChange(selectedIndex);
                       }
                    } else{
                        menuY-=speed;
                        repaint();         
                    }
                }else {
                    if(menuY>=menuYTarget + 5){
                       menuY = menuYTarget;
                       repaint();
                       timer.stop();
                       callBack.call(selectedIndex);
                       if(event!=null){
                          event.menuIndexChange(selectedIndex);
                       }
                    } else {
                        menuY += speed;
                        repaint();
                    }
                }          
            } 
        });
                            
        initData();
        
    }
    
    
    private void initData() {
    listaMenu.addItem(new clsEMenu("1", "REGISTRAR ADOPCION", clsEMenu.MenuType.MENU));
    listaMenu.addItem(new clsEMenu("2", "PROCESAR ADOPCION", clsEMenu.MenuType.MENU));
    listaMenu.addItem(new clsEMenu("3", "REGISTRAR VOLUNTARIO", clsEMenu.MenuType.MENU));
    listaMenu.addItem(new clsEMenu("4", "REGISTRO ANIMAL", clsEMenu.MenuType.MENU));
    listaMenu.addItem(new clsEMenu("5", "LISTAR ANIMALES", clsEMenu.MenuType.MENU));
    listaMenu.addItem(new clsEMenu("6", "REPORTES", clsEMenu.MenuType.MENU));
    listaMenu.addItem(new clsEMenu("7", "CERRAR SESION", clsEMenu.MenuType.MENU));
    listaMenu.addItem(new clsEMenu("", "", clsEMenu.MenuType.EMPTY)); 
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listaMenu = new swing.ListaMenu<>();

        panelMoving.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icono/logo.png"))); // NOI18N
        jLabel1.setText("PET CARE");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listaMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#eea849"), 0, getHeight(), Color.decode("#f46b45"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        if (selectedIndex >= 0){
            int menuX = 10;
            int height = 35;
            int width = getWidth();
            g2.setColor(new Color(255, 255, 255));
            g2.fillRoundRect(menuX, menuY, width, height, 35, 35);   
            Path2D.Float f = new Path2D.Float();
            f.moveTo(width -30, menuY);           
            f.curveTo(width-10, menuY, width, menuY, width,   menuY - 30);                    
            f.lineTo(width, menuY + height + 30);
            f.curveTo(width, menuY + height, width - 10, menuY + height, width - 30, menuY + height);
            g2.fill(f);
        }
        super.paintComponent(grphcs);
    }
    
    private int x;
    private int y;
    public void initMoving (JFrame fram){
        panelMoving.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me){
                x = me.getX() + 6;
                y = me.getY() + 6;
                        
            }  
            
        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent me){
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private swing.ListaMenu<String> listaMenu;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
