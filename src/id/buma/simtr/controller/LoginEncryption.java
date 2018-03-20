/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class LoginEncryption {
    
    public String hashingText(String input){
        String strResult = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodeHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < encodeHash.length; i++){
                String hex = Integer.toHexString(0xff & encodeHash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            strResult = hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginEncryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return strResult;
    }
    
}
