/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lance.form;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.lance.model.UserStats;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
/**
 *
 * @author wence
 */
public class Form_2 extends javax.swing.JPanel {
   
BufferedImage logoImage;
BufferedImage qrImage;
    /**
     */
    public Form_2() {
        initComponents();
        // Set fonts
    txtField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    btnGenerate.setFont(new Font("Segoe UI", Font.BOLD, 14));
    btnSave.setFont(new Font("Segoe UI", Font.BOLD, 14));

    // Set button colors
    btnGenerate.setBackground(new Color(66, 133, 244)); // Blue
    btnGenerate.setForeground(Color.WHITE);

    btnSave.setBackground(new Color(52, 168, 83)); // Green
    btnSave.setForeground(Color.WHITE);
    
    btnUploadLogo.setBackground(new Color(244, 180, 0)); // Orange
    btnUploadLogo.setForeground(Color.WHITE);
    btnUploadLogo.setFont(new Font("Segoe UI", Font.BOLD, 14));
    lblQRCode.setHorizontalAlignment(SwingConstants.CENTER);
    
    
    
    lblTip.setFont(new Font("Segoe UI", Font.ITALIC, 12));
    lblTip.setForeground(Color.GRAY);
    lblQRCode.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
    BorderFactory.createEmptyBorder(10, 10, 10, 10)    
));
    lblQRCode.setBorder(BorderFactory.createTitledBorder("QR Code"));
    btnGenerate.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnGenerate.setBackground(new Color(52, 103, 214));
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnGenerate.setBackground(new Color(66, 133, 244));
    }
});
    Font font = new Font("Segoe UI", Font.PLAIN, 14);
    Font fontbold = new Font("Segoe UI", Font.BOLD, 14);
    txtField.setFont(font);
    btnGenerate.setFont(font);
    btnSave.setFont(font);
    jLabel1.setFont(fontbold);
    
  
    
    lblQRCode.setOpaque(true);
    lblQRCode.setBackground(new Color(255, 255, 255, 230)); // Slight transparency
    setOpaque(false);
       color1 = Color.decode("#2193b0");
        color2 = Color.decode("#f2fcfe"); 
        
       

    }
    
    public BufferedImage createRoundedQRCode(BitMatrix matrix, int size, Color onColor) {
    int matrixWidth = matrix.getWidth();
    int matrixHeight = matrix.getHeight();
    
    BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = image.createGraphics();

    g2d.setColor(Color.WHITE);  // background white
    g2d.fillRect(0, 0, size, size);

    g2d.setColor(onColor);
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Calculate size of one module (dot)
    float moduleSize = (float) size / matrixWidth;

    // Draw rounded dots
    for (int y = 0; y < matrixHeight; y++) {
        for (int x = 0; x < matrixWidth; x++) {
            if (matrix.get(x, y)) {
                float cx = x * moduleSize;
                float cy = y * moduleSize;
                // Draw a filled oval (circle) for each 'on' bit
                g2d.fillOval(
                    Math.round(cx),
                    Math.round(cy),
                    Math.round(moduleSize),
                    Math.round(moduleSize));
            }
        }
    }

    g2d.dispose();
    return image;
}

    
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

        
    
public BufferedImage generateQRCodeImage(String text) throws WriterException {
    int size = 250;
    int moduleCount = 33;  // typical QR size, but get from BitMatrix dynamically
    int dotDiameter  = 14;

    // Set error correction to high
    Map<EncodeHintType, Object> hints = new HashMap<>();
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

    BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, size, size, hints);

    int matrixWidth = bitMatrix.getWidth();
    int matrixHeight = bitMatrix.getHeight();

    // Calculate module size (pixel size per bit)
    float moduleSizeX = (float)size / matrixWidth;
    float moduleSizeY = (float)size / matrixHeight;

    // We'll use the smaller of the two for a circle diameter
    dotDiameter = (int)Math.ceil(Math.min(moduleSizeX, moduleSizeY));

    BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = image.createGraphics();

    // White background
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, size, size);

    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.setColor(Color.BLUE);

    // Draw rounded dots centered in each module square
    for (int y = 0; y < matrixHeight; y++) {
        for (int x = 0; x < matrixWidth; x++) {
            if (bitMatrix.get(x, y)) {
                // Calculate top-left corner to center the circle in module square
                float px = x * moduleSizeX;
                float py = y * moduleSizeY;

                // Offset to center circle inside module square
                float offsetX = (moduleSizeX - dotDiameter) / 2f;
                float offsetY = (moduleSizeY - dotDiameter) / 2f;

                g.fillOval(Math.round(px + offsetX), Math.round(py + offsetY), dotDiameter, dotDiameter);
            }
        }
    }
    g.dispose();

    // Logo embedding code (same as before)
    if (logoImage != null) {
        int logoSize = size / 5;
        Image scaledLogo = logoImage.getScaledInstance(logoSize, logoSize, Image.SCALE_SMOOTH);

        BufferedImage logoWithBackground = new BufferedImage(logoSize, logoSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gLogo = logoWithBackground.createGraphics();
        gLogo.setColor(Color.WHITE);
        gLogo.fillRoundRect(0, 0, logoSize, logoSize, 10, 10);
        gLogo.drawImage(scaledLogo, 0, 0, null);
        gLogo.dispose();

        BufferedImage combined = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gCombined = combined.createGraphics();
        gCombined.drawImage(image, 0, 0, null);
        int centerX = (size - logoSize) / 2;
        int centerY = (size - logoSize) / 2;
        gCombined.drawImage(logoWithBackground, centerX, centerY, null);
        gCombined.dispose();

        return combined;
    }

    return image;
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtField = new javax.swing.JTextField();
        btnGenerate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblQRCode = new javax.swing.JLabel();
        lblTip = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnUploadLogo = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 242, 242));

        txtField.setMaximumSize(new java.awt.Dimension(50, 26));
        txtField.setMinimumSize(new java.awt.Dimension(50, 26));
        txtField.setPreferredSize(new java.awt.Dimension(50, 26));
        txtField.setColumns(20);
        txtField.setMaximumSize(txtField.getPreferredSize());
        txtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldActionPerformed(evt);
            }
        });

        btnGenerate.setText("Generate QR");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        btnSave.setText("Save QR");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblQRCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblQRCode.setMaximumSize(new java.awt.Dimension(250, 250));
        lblQRCode.setMinimumSize(new java.awt.Dimension(250, 250));
        lblQRCode.setPreferredSize(new java.awt.Dimension(250, 250));

        lblTip.setText("Tip: QR Code will encode plain text, URLs, etc.");

        jLabel1.setText("ENTER TEXT:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lance/icon/qr-code (2).png"))); // NOI18N
        jLabel2.setText("QR CODE GENERATOR");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setText("By: QRCipher");

        btnUploadLogo.setText("Upload Logo");
        btnUploadLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadLogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(299, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblTip, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQRCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnUploadLogo)))
                .addGap(225, 225, 225))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTip)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQRCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUploadLogo))
                .addGap(18, 18, 18)
                .addComponent(btnGenerate)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

@Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }
    
    
    private void txtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        // TODO add your handling code here:
        
     String text = txtField.getText();
    if (text == null || text.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter some text.", "Input Required", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        qrImage = generateQRCodeImage(text);
        lblQRCode.setIcon(new ImageIcon(qrImage));
        UserStats.incrementQR();
    } catch (WriterException e) {
        JOptionPane.showMessageDialog(this, "Failed to generate QR code: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnGenerateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
       if (qrImage == null) {
        JOptionPane.showMessageDialog(this, "No QR code to save. Generate one first.", "Save Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Save QR Code");
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PNG Image (*.png)", "png"));

    int userSelection = fileChooser.showSaveDialog(this);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();

        // Force .png extension
        String path = fileToSave.getAbsolutePath();
        if (!path.toLowerCase().endsWith(".png")) {
            path += ".png";
            fileToSave = new File(path);
        }

        // Optional: Prevent saving over existing file without confirmation
        if (fileToSave.exists()) {
            int result = JOptionPane.showConfirmDialog(this, "File already exists. Overwrite?", "Confirm Save", JOptionPane.YES_NO_OPTION);
            if (result != JOptionPane.YES_OPTION) {
                return;
            }
        }

        try {
            ImageIO.write(qrImage, "PNG", fileToSave);
            JOptionPane.showMessageDialog(this, "QR code saved successfully!", "Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to save QR code: " + e.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUploadLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadLogoActionPerformed
        // TODO add your handling code here:
        
        JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Choose a logo image");
    int userSelection = fileChooser.showOpenDialog(this);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        try {
            logoImage = ImageIO.read(selectedFile);
            JOptionPane.showMessageDialog(this, "Logo uploaded successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to load logo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    }//GEN-LAST:event_btnUploadLogoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUploadLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblQRCode;
    private javax.swing.JLabel lblTip;
    private javax.swing.JTextField txtField;
    // End of variables declaration//GEN-END:variables
}
