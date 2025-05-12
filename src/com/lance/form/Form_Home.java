package com.lance.form;

import com.lance.model.Model_Card;
import com.lance.model.StatusType;
import com.lance.swing.ScrollBar;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Form_Home extends javax.swing.JPanel {
private int shift = 7;
private boolean isEncoding = true;

    public Form_Home() {
        initComponents();
        
       inputLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
inputLabel.setForeground(new Color(44, 62, 80));

outputLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
outputLabel.setForeground(new Color(44, 62, 80));

shiftLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
shiftLabel.setForeground(new Color(52, 73, 94));

inputArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
inputArea.setBackground(new Color(245, 245, 245));
inputArea.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createLineBorder(new Color(200, 200, 200)),
    BorderFactory.createEmptyBorder(8, 8, 8, 8)
));

outputArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
outputArea.setBackground(new Color(245, 245, 245));
outputArea.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createLineBorder(new Color(200, 200, 200)),
    BorderFactory.createEmptyBorder(8, 8, 8, 8)
));

Color btnColor = new Color(52, 152, 219); // blue
Font btnFont = new Font("Segoe UI", Font.BOLD, 13);

encodeBtn.setBackground(btnColor);
encodeBtn.setForeground(Color.WHITE);
encodeBtn.setFocusPainted(false);
encodeBtn.setFont(btnFont);
encodeBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

decodeBtn.setBackground(btnColor);
decodeBtn.setForeground(Color.WHITE);
decodeBtn.setFocusPainted(false);
decodeBtn.setFont(btnFont);
decodeBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

plusBtn.setBackground(new Color(39, 174, 96)); // green
plusBtn.setForeground(Color.WHITE);
plusBtn.setFocusPainted(false);
plusBtn.setFont(btnFont);

minusBtn.setBackground(new Color(231, 76, 60)); // red
minusBtn.setForeground(Color.WHITE);
minusBtn.setFocusPainted(false);
minusBtn.setFont(btnFont);
 setOpaque(false);
 
 color1 = Color.decode("#2193b0");
        color2 = Color.decode("#6dd5ed"); 
       
    }
    
    private void addHoverEffect(JButton button, Color normalColor, Color hoverColor) {
    button.setBackground(normalColor);
    button.setForeground(Color.WHITE);
    button.setFocusPainted(false);
    button.setCursor(new Cursor(Cursor.HAND_CURSOR));

    button.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            button.setBackground(hoverColor);
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
            button.setBackground(normalColor);
        }
    });
    
Color blue = new Color(52, 152, 219);
Color blueHover = new Color(41, 128, 185);

Color green = new Color(39, 174, 96);
Color greenHover = new Color(30, 132, 73);

Color red = new Color(231, 76, 60);
Color redHover = new Color(192, 57, 43);

addHoverEffect(encodeBtn, blue, blueHover);
addHoverEffect(decodeBtn, blue, blueHover);
addHoverEffect(plusBtn, green, greenHover);
addHoverEffect(minusBtn, red, redHover);

        

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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        inputArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        encodeBtn = new javax.swing.JButton();
        decodeBtn = new javax.swing.JButton();
        shiftLabel = new javax.swing.JLabel();
        minusBtn = new javax.swing.JButton();
        plusBtn = new javax.swing.JButton();
        inputLabel = new javax.swing.JLabel();
        outputLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(915, 585));

        inputArea.setColumns(20);
        inputArea.setLineWrap(true);
        inputArea.setRows(5);
        inputArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(inputArea);
        inputArea.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { updateOutput(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { updateOutput(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { updateOutput(); }
        });

        inputArea.setText("If he had anything confidential to say, he wrote it in cipher, that is, by so changing the order of the letters of the alphabet, that not a word could be made out.");
        inputArea.setForeground(Color.GRAY);

        inputArea.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (inputArea.getText().equals("If he had anything confidential to say, he wrote it in cipher, that is, by so changing the order of the letters of the alphabet, that not a word could be made out.")) {
                    inputArea.setText("");
                    inputArea.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (inputArea.getText().isEmpty()) {
                    inputArea.setText("If he had anything confidential to say, he wrote it in cipher, that is, by so changing the order of the letters of the alphabet, that not a word could be made out.");
                    inputArea.setForeground(Color.GRAY);
                }
            }
        });

        outputArea.setEditable(false);
        outputArea.setColumns(20);
        outputArea.setLineWrap(true);
        outputArea.setRows(5);
        outputArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(outputArea);

        encodeBtn.setText("ENCODE");
        encodeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encodeBtnActionPerformed(evt);
            }
        });
        encodeBtn.addActionListener(e -> {
            isEncoding = true;
            inputLabel.setText("Plain Text");
            outputLabel.setText("Cipher Text");
            updateOutput();
        });

        decodeBtn.setText("DECODE");
        decodeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decodeBtnActionPerformed(evt);
            }
        });
        decodeBtn.addActionListener(e -> {
            isEncoding = false;
            inputLabel.setText("Cipher Text");
            outputLabel.setText("Plain Text");
            updateOutput();
        });

        shiftLabel.setText("Shift: 7 (a  → h)");

        minusBtn.addActionListener(e -> {
            shift--;
            updateOutput();
        });
        minusBtn.setText("-");

        plusBtn.addActionListener(e -> {
            shift++;
            updateOutput();
        });
        plusBtn.setText("+");

        inputLabel.setText("Plain Text");

        outputLabel.setText("Cipher Text");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lance/icon/caesar-cipher (2).png"))); // NOI18N
        jLabel2.setText("CAESAR CIPHER");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setText("By: QRCipher");

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
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outputLabel)
                            .addComponent(inputLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(minusBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(shiftLabel)
                                    .addGap(51, 51, 51)
                                    .addComponent(plusBtn))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(encodeBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(decodeBtn))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(448, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encodeBtn)
                    .addComponent(decodeBtn))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minusBtn)
                    .addComponent(plusBtn)
                    .addComponent(shiftLabel))
                .addGap(26, 26, 26)
                .addComponent(outputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void decodeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decodeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decodeBtnActionPerformed

    private void encodeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encodeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_encodeBtnActionPerformed

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
    
    
    private String caesarCipher(String text, int shift) {
    StringBuilder result = new StringBuilder();
    shift = (shift % 26 + 26) % 26;

    for (char c : text.toCharArray()) {
        if (Character.isLetter(c)) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            char shifted = (char) ((c - base + shift) % 26 + base);
            result.append(shifted);
        } else {
            result.append(c);
        }
    }
    return result.toString();
}
    
    private void updateOutput() {
    // Update visual shift display always
    int displayShift = (shift % 26 + 26) % 26;
    char shiftedChar = (char) ('a' + displayShift);
    shiftLabel.setText("Shift: " + shift + " (a → " + shiftedChar + ")");

    // Then process cipher text if there is input
    String text = inputArea.getText().trim();
    if (text.isEmpty()) {
        outputArea.setText("");
        return;
    }

    String result = caesarCipher(text, isEncoding ? shift : -shift);
    outputArea.setText(result);
}




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton decodeBtn;
    private javax.swing.JButton encodeBtn;
    private javax.swing.JTextArea inputArea;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton minusBtn;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JButton plusBtn;
    private javax.swing.JLabel shiftLabel;
    // End of variables declaration//GEN-END:variables
}
