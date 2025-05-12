package com.lance.component;

import com.lance.component.PanelSlide;
import com.lance.event.EventMenuSelected;
import com.lance.model.ModelUser;
import com.lance.model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Menu extends javax.swing.JPanel {

    private EventMenuSelected event;

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }

    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }
    
    public void setData(ModelUser data) {
        pic.setIcon(data.getProfile());
        lbUser.setText(data.getUserName());
    }



    private void init() {
        listMenu1.addItem(new Model_Menu("1", "Home", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("2", "File Encryption", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("qr", "QR Generator", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("3", "Our Team", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("4", "Trivia", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("5", "About", Model_Menu.MenuType.EMPTY));

   
        listMenu1.addItem(new Model_Menu("6", "", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("7", "", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("8", "", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("user-logout", "Logout", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("5", "About", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("9", "", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("", "Version v1.0.0", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("", "Developed by BSCS Group1", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("", "WU-P - Aurora 2025", Model_Menu.MenuType.TITLE));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        listMenu1 = new com.lance.swing.ListMenu<>();
        pic = new com.lance.swing.ImageAvatar();
        lbUser = new javax.swing.JLabel();
        lbUser1 = new javax.swing.JLabel();

        panelMoving.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lance/icon/logo.png"))); // NOI18N
        jLabel1.setText("QRCipher");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("Encryption and QR Generation System");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMovingLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelMovingLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        pic.setBackground(new java.awt.Color(67, 99, 132));
        pic.setForeground(new java.awt.Color(188, 188, 188));
        pic.setBorderSize(3);
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lance/icon/hero (2).jpg"))); // NOI18N
        pic.setOpaque(true);

        lbUser.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbUser.setForeground(new java.awt.Color(92, 92, 92));
        lbUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUser.setText(" Lance William");

        lbUser1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbUser1.setForeground(new java.awt.Color(92, 92, 92));
        lbUser1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUser1.setText("Welcome Back!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbUser1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUser))
                    .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#FFC837"), 0, getHeight(), Color.decode("#FF8008"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbUser;
    private javax.swing.JLabel lbUser1;
    private com.lance.swing.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMoving;
    private com.lance.swing.ImageAvatar pic;
    // End of variables declaration//GEN-END:variables
}
