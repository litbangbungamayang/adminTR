/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.model.BahanProduksi;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class BahanProduksiTableModel extends AbstractTableModel {
    
    private final List<BahanProduksi> lsBp;
    
    public BahanProduksiTableModel(List<BahanProduksi> lsBp){
        this.lsBp = lsBp;
    }

    public List<BahanProduksi> getContentList(){
        return this.lsBp;
    }
    
    private final String[] columnNames = new String[]{
        "No.",
        "Jenis Bahan",
        "Nama Bahan",
        "Dosis/ha",
        "Satuan"
    };
    
    @Override
    public int getRowCount() {
        return this.lsBp.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 :
                return rowIndex + 1;
            case 1 :
                return lsBp.get(rowIndex).getJenisBahan();
            case 2 :
                return lsBp.get(rowIndex).getNamaBahan();
            case 3 :
                return lsBp.get(rowIndex).getDosisPerHa();
            case 4 :
                return lsBp.get(rowIndex).getSatuan();
        }
        return "N/A";
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    
    
}
