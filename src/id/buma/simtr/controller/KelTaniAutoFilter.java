/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.model.PetaniTebu;
import id.buma.simtr.view.MainWindow;
import id.buma.simtr.view.PetaniTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class KelTaniAutoFilter implements KeyListener{
    
    private MainWindow mw;
    
    private final CommonController cc = new CommonController(mw);
    
    private final JTable tbl;
    
    private JTable affectedTable;
   
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        JTextField txf = (JTextField) e.getComponent();
        String txt = txf.getText();
        cc.kelTaniAutoFilter(tbl, txt);
        if (affectedTable != null){
            List<PetaniTebu> lst = new ArrayList<>();
            PetaniTableModel ptm = new PetaniTableModel(lst);
            affectedTable.setModel(ptm);
        }
    }

    public KelTaniAutoFilter(JTable tbl) {
        this.tbl = tbl;
    }
    
    public void setAffectedTable(JTable tbl){
        this.affectedTable = tbl;
    }
    
}
