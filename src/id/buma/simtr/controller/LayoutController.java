/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.view.MainWindow;
import java.awt.Color;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class LayoutController {

    private MainWindow mw;
    private Color mainWindowTitleBg = new Color(0, 153, 153);
    private Color subMainWindowBg = new Color(0,105,105);
    private Color lowerWindowBg = new Color(0, 105, 105);
    
    public LayoutController(MainWindow mw){
        this.mw = mw;
    }
    
    public void setMainWindowTitleBg(Color clr){
        this.mainWindowTitleBg = clr;
    }
    
    public void setSubMainWindowBg(Color clr){
        this.subMainWindowBg = clr;
    }
    
    public void setLowerWindowBg(Color clr){
        this.lowerWindowBg = clr;
    }
    
    public void applyColor(){
        
    }
    
}
