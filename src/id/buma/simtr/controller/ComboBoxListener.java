/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.view.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class ComboBoxListener implements ActionListener{
    
    private final MainWindow mw;
    
    private List<String> content = new ArrayList<>();

    public void ComboBoxListener(List<String> content){
        this.content = content;
    }
    
    public ComboBoxListener(MainWindow mw){
        this.mw = mw;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        RDKKController rc = new RDKKController(mw);
        JComboBox combobox = (JComboBox) e.getSource();
        String cbxName = combobox.getName();
        int indexList = combobox.getSelectedIndex()-1;
        switch(cbxName){
            case "cbxKecamatan":
                if (indexList != -1){
                    rc.getDetailDesa(indexList);
                }
                break;
        }
    }
    
    public String getValue(ActionEvent e){
        String value = null;
        JComboBox combobox = (JComboBox) e.getSource();
        if (combobox.getSelectedIndex() != -1){
            value = content.get(combobox.getSelectedIndex());
        }
        return value;
    }
    
}
