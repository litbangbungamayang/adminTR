/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.view.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class TextBoxListener implements ActionListener {
    
    private MainWindow mw;
    
    public TextBoxListener (MainWindow mw){
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField txtField = (JTextField) e.getSource();
        String txtName = txtField.getName();
        CommonController cc = new CommonController(mw);
        MenuController mc = new MenuController(mw);
        switch (txtName){
            case "jtfLoginPassword":
                if (cc.cekLogin()) mc.pageSwitcher(mw.getPnlContent(), "crdPnlMenuUtama");
                break;
        }
    }
    
}
