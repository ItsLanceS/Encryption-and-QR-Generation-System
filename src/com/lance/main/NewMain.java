/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.lance.main;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author wence
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
    UIManager.setLookAndFeel( new FlatLightLaf() );
} catch( UnsupportedLookAndFeelException ex ) {
    System.err.println( "Failed to initialize LaF" );
}
        
        Login Login = new Login();
        Login.setVisible(true);
        
      
        
        
    }
    
}
