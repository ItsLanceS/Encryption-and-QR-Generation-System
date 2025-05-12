package com.lance.component;



import com.lance.model.ModelUser;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class PanelLoading extends javax.swing.JLayeredPane {

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
    
    public ModelUser getData() {
        return data;
    }

    private final Animator animator;
    private boolean slideLeft;
    private float animate;
    private boolean isMessage;
    private ModelUser data;

    public PanelLoading() {
        initComponents();
        loading.setVisible(true);
        profile.setVisible(false);
        message.setVisible(false);
        color1 = Color.orange;
        color2 = Color.cyan;
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (isMessage) {
                    message.setVisible(true);
                } else {
                    profile.setVisible(true);
                }
            }

            @Override
            public void timingEvent(float fraction) {
                if (isMessage) {
                    message.setAlpha(fraction);
                    loading.setAlpha(1f - fraction);
                } else {
                    profile.setAlpha(fraction);
                    loading.setAlpha(1f - fraction);
                }
                repaint();
            }
        };
        animator = new Animator(500, target);
        animator.setResolution(0);
    }

    public void setAnimate(boolean slideLeft, float animate) {
        this.slideLeft = slideLeft;
        this.animate = animate;
    }

    public void addEventBack(ActionListener event) {
        cmdCancel.addActionListener(event);
        cmdCancel1.addActionListener(event);
        cmdCancel2.addActionListener(event);
    }

    public void addEventContinue(ActionListener event) {
        cmdContinue.addActionListener(event);
    }

    public void doneLogin(ModelUser data) {
        isMessage = false;
        this.data = data;
        pic.setIcon(data.getProfile());
        cmdContinue.setText("Continue with " + data.getUserName());
        animator.start();
    }

    public void showError(String ms) {
        lbMessage.setText(ms);
        isMessage = true;
        animator.start();
    }

    public void reset() {
        loading.setAlpha(1f);
        loading.setVisible(true);
        profile.setVisible(false);
        message.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profile = new com.lance.swing.PanelTransparent();
        cmdCancel1 = new com.lance.swing.Button();
        pic = new com.lance.swing.ImageAvatar();
        cmdEdit = new com.lance.swing.EditButton();
        cmdContinue = new com.lance.swing.Button();
        loading = new com.lance.swing.PanelTransparent();
        cmdCancel = new com.lance.swing.Button();
        jLabel1 = new javax.swing.JLabel();
        message = new com.lance.swing.PanelTransparent();
        cmdCancel2 = new com.lance.swing.Button();
        lbMessage = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        cmdCancel1.setBackground(new java.awt.Color(67, 99, 132));
        cmdCancel1.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel1.setText("Cancel");

        pic.setBackground(new java.awt.Color(67, 99, 132));
        pic.setForeground(new java.awt.Color(188, 188, 188));
        pic.setBorderSize(3);
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lance/icon/user.png"))); // NOI18N
        pic.setOpaque(true);

        cmdEdit.setBackground(new java.awt.Color(55, 55, 55));
        cmdEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lance/icon/edit.png"))); // NOI18N
        cmdEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout picLayout = new javax.swing.GroupLayout(pic);
        pic.setLayout(picLayout);
        picLayout.setHorizontalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, picLayout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        picLayout.setVerticalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, picLayout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cmdContinue.setBackground(new java.awt.Color(88, 130, 172));
        cmdContinue.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cmdContinue.setForeground(new java.awt.Color(255, 255, 255));
        cmdContinue.setText("Continue");
        cmdContinue.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        cmdContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdContinueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(profile);
        profile.setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileLayout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(cmdCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
            .addGroup(profileLayout.createSequentialGroup()
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profileLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(profileLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(cmdContinue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(cmdContinue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(cmdCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        add(profile, "card2");

        cmdCancel.setBackground(new java.awt.Color(67, 99, 132));
        cmdCancel.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel.setText("Cancel");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lance/icon/loading.gif"))); // NOI18N

        javax.swing.GroupLayout loadingLayout = new javax.swing.GroupLayout(loading);
        loading.setLayout(loadingLayout);
        loadingLayout.setHorizontalGroup(
            loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadingLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
            .addGroup(loadingLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        loadingLayout.setVerticalGroup(
            loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadingLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        add(loading, "card2");

        cmdCancel2.setBackground(new java.awt.Color(67, 99, 132));
        cmdCancel2.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel2.setText("Cancel");

        lbMessage.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(255, 255, 255));
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText("Message");

        javax.swing.GroupLayout messageLayout = new javax.swing.GroupLayout(message);
        message.setLayout(messageLayout);
        messageLayout.setHorizontalGroup(
            messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, messageLayout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(cmdCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
            .addGroup(messageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        messageLayout.setVerticalGroup(
            messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, messageLayout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
                .addComponent(cmdCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        add(message, "card2");
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    GradientPaint g3 = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
    g2.setPaint(g3);
    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    g2.setColor(new Color(255, 255, 255, 50));
    g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
    g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
}
    
    
    
    private void cmdEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditActionPerformed
        SwingUtilities.invokeLater(() -> {
        JFileChooser ch = new JFileChooser();
        ch.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName().toLowerCase();
                return file.isDirectory() || name.endsWith(".png") || name.endsWith(".jpg");
            }

            @Override
            public String getDescription() {
                return "Image Files (*.png, *.jpg)";
            }
        });

        int option = ch.showOpenDialog(null); // Change 'this' to null or your JFrame instance
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = ch.getSelectedFile();
            if (file != null && file.exists()) {
                ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                pic.setIcon(icon);  // `pic` must be a visible JLabel
                data.setProfile(icon); // Save to your local object
                repaint();
                System.out.println("Profile image updated.");
            } else {
                System.err.println("Selected file does not exist.");
            }
        }
    });
    }//GEN-LAST:event_cmdEditActionPerformed

    private void cmdContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdContinueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdContinueActionPerformed

    
    
  
    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        int width = getWidth();
        int height = getHeight();
        int x = 0;
        int y = 0;
        if (slideLeft) {
            int centerY = height / 2;
            Path2D.Float p = new Path2D.Float();
            p.moveTo(x, y);
            p.lineTo(width, y);
            p.lineTo(width, height);
            p.lineTo(x, height);
            p.curveTo(x, height, easeOutBounce(animate) * width, centerY, x, y);
            g2.fill(p);
        } else {
            g2.fillRect(x, y, width, height);
        }
        g2.dispose();
        super.paint(grphcs);
    }

    private float easeOutBounce(float x) {
        float n1 = 7.5625f;
        float d1 = 2.75f;
        double v;
        if (x < 1 / d1) {
            v = n1 * x * x;
        } else if (x < 2 / d1) {
            v = n1 * (x -= 1.5 / d1) * x + 0.75;
        } else if (x < 2.5 / d1) {
            v = n1 * (x -= 2.25 / d1) * x + 0.9375;
        } else {
            v = n1 * (x -= 2.625 / d1) * x + 0.984375;
        }
        if (slideLeft) {
            return (float) (1f - v);
        } else {
            return (float) v;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.lance.swing.Button cmdCancel;
    private com.lance.swing.Button cmdCancel1;
    private com.lance.swing.Button cmdCancel2;
    private com.lance.swing.Button cmdContinue;
    private com.lance.swing.EditButton cmdEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbMessage;
    private com.lance.swing.PanelTransparent loading;
    private com.lance.swing.PanelTransparent message;
    private com.lance.swing.ImageAvatar pic;
    private com.lance.swing.PanelTransparent profile;
    // End of variables declaration//GEN-END:variables
}
