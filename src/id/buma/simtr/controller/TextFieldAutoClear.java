/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class TextFieldAutoClear extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e) {
        JTextField tf = (JTextField) e.getComponent();
        if (tf.getText().equalsIgnoreCase("Pencarian...")){
            tf.setText("");
        }
    }
    
}
