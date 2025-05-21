/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lance.model;

/**
 *
 * @author wence
 */
public class UserStats {
    public static int totalEncrypt = 0;
    public static int totalQR = 0;

    public static void incrementEncrypt() {
        totalEncrypt++;
    }

    public static void incrementQR() {
        totalQR++;
    }

    public static String getEncryptCount() {
        return String.valueOf(totalEncrypt);
    }

    public static String getQRCount() {
        return String.valueOf(totalQR);
    }
}

