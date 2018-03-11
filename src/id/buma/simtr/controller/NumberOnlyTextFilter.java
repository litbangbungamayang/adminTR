/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class NumberOnlyTextFilter extends DocumentFilter{
    
    private final int maxLength;
    
    public NumberOnlyTextFilter(int maxLength){
        this.maxLength = maxLength;
    }
    
    @Override
    public void insertString(FilterBypass fb, int offset, String str, AttributeSet attr) throws BadLocationException {
        String text = fb.getDocument().getText(0, fb.getDocument().getLength());
        text += str;
        if(text.matches("[0-9]+") && fb.getDocument().getLength() < maxLength){
            super.insertString(fb, offset, str, attr);
        }
    }
    
    @Override
    public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs) throws BadLocationException {
        String text = fb.getDocument().getText(0, fb.getDocument().getLength());
        text += str;
        if (text.matches("[0-9]+") && fb.getDocument().getLength() < maxLength){
            super.replace(fb, offset, length, str, attrs);
        }
    }
    
}
