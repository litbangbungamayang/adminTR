/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.model.KelompokTani;
import id.buma.simtr.view.KelompokTaniTableModel;
import id.buma.simtr.view.MainWindow;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class TableSelectionController implements MouseListener{
    
    private MainWindow mw;
    
    public TableSelectionController(MainWindow mw){
        this.mw = mw;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        CommonController cc = new CommonController(mw);
        RDKKController rc = new RDKKController(mw);
        JTable tbl = (JTable) e.getSource();
        String tblName = tbl.getName();
        switch (tblName){
            case "tblValidasiRDKK":
                if (tbl.getSelectedRow() > -1){
                    KelompokTaniTableModel kttm = (KelompokTaniTableModel) tbl.getModel();
                    List<KelompokTani> lst = kttm.getContentList();
                    rc.populateTablePetaniByIdKelompok(mw.getTblValidasiRDKK_Petani(),
                            lst.get(tbl.getSelectedRow()).getIdKelompok());
                }
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
