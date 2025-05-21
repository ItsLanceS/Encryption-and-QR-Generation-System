package com.lance.component;



import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;

public class PanelLogin extends javax.swing.JPanel {

      public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    private Color color1;
    private Color color2;
    
    
    public PanelLogin() {
        initComponents();
        
        txtPass.setEchoChar('\u2022');   
        jLabel7.setVisible(true);
        jLabel8.setVisible(false);
        setOpaque(false);
        color1 = Color.orange;
        color2 = Color.white;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUser = new com.lance.swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        txtPass = new com.lance.swing.PasswordField();
        cmd = new com.lance.swing.Button();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        jLabel5.setText("jLabel5");

        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(51, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUser.setLabelText("User Name");
        add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 129, 290, -1));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(79, 79, 79));
        jLabel1.setText("Sign In");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        txtPass.setLabelText("Password");
        add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 250, -1));

        cmd.setBackground(new java.awt.Color(25, 182, 247));
        cmd.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cmd.setForeground(new java.awt.Color(255, 255, 255));
        cmd.setText("Login");
        cmd.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        add(cmd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 309, 290, -1));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 16, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lance/icon/cross.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, 28));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lance/icon/hidden.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lance/icon/eye (3).png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, 40));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setOpaque(true);
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 40, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lance/icon/close (1).png")));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lance/icon/cross.png")));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        txtPass.setEchoChar((char) 0);
        jLabel7.setVisible(false);
        jLabel8.setVisible(true);
       
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        txtPass.setEchoChar('\u2022');
        jLabel7.setVisible(true);
        jLabel8.setVisible(false);
    }//GEN-LAST:event_jLabel8MouseClicked

    
    @Override
    public void paintComponents(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g3 = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g3);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        
        super.paintComponents(g);
    }
    
    public void addEventLogin(ActionListener event) {
        cmd.addActionListener(event);
    }

    public boolean checkUser() {
        boolean action = true;
        if (txtUser.getText().trim().equals("")) {
            txtUser.setHelperText("Please input user name");
            action = false;
        }
        if (String.valueOf(txtPass.getPassword()).trim().equals("")) {
            txtPass.setHelperText("Please input password");
            action = false;
        }
        return action;
    }

    public String getUserName() {
        return txtUser.getText().trim();
    }

    public String getPassword() {
        return String.valueOf(txtPass.getPassword());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.lance.swing.Button cmd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private com.lance.swing.PasswordField txtPass;
    private com.lance.swing.TextField txtUser;
    // End of variables declaration//GEN-END:variables
}
