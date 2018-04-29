/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.model.PekerjaanKebun;
import id.buma.simtr.model.PetaniTebu;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class BufferPerawatan_Permintaan_TableModel extends AbstractTableModel{
    
    private List<PetaniTebu> lsPt = new ArrayList<>();
    private List<PekerjaanKebun> lsPk = new ArrayList<>();
    
    public BufferPerawatan_Permintaan_TableModel(List<PetaniTebu> lsPt, List<PekerjaanKebun> lsPk){
        this.lsPt = lsPt;
        this.lsPk = lsPk;
    }
    
    public List<PetaniTebu> getSelectedPetani(){
        return this.lsPt;
    }
    
    public List<PekerjaanKebun> getSelectedPekerjaan(){
        return this.lsPk;
    }
    
    private final String[] columnNames = new String[]{
        "Nama Petani",
        "Pekerjaan Diajukan"
    };
    

    @Override
    public int getRowCount() {
        if (lsPk.size() > lsPt.size()){
            return lsPk.size();
        } else {
            if (lsPk.size() < lsPt.size()){
                return lsPt.size();
            }
        }
        return lsPt.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                if (rowIndex < lsPt.size()){
                    return lsPt.get(rowIndex).getNamaPetani();
                }
                break;
            case 1:
                if (rowIndex < lsPk.size()){
                    return lsPk.get(rowIndex).getNamaPekerjaan();
                }
                break;
        }
        return null;
    }
    
}
