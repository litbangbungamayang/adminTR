/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.model.PekerjaanKebun;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class PekerjaanKebunTableModel extends AbstractTableModel{
    
    private final List<PekerjaanKebun> lsPk;
    private boolean isEmpty = false;
    
    public PekerjaanKebunTableModel(List<PekerjaanKebun> lsPk){
        this.lsPk = lsPk;
    }
    
    public List<PekerjaanKebun> getContentList(){
        return this.lsPk;
    }
    
    public final String[] columnNames = new String[]{
        "No",
        "Kategori Tanaman",
        "Nama Pekerjaan",
        "Biaya"
    };

    @Override
    public int getRowCount() {
        if (lsPk.size() > 0){
            return lsPk.size();
        } else {
            PekerjaanKebun pk = new PekerjaanKebun(0, "", "", "", 0, 0);
            lsPk.add(pk);      
            isEmpty = true;
            return lsPk.size();
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,##0", dfs);
        String biaya = df.format(lsPk.get(rowIndex).getHarga());
        if (!isEmpty){
            switch (columnIndex){
                case 0:
                    return rowIndex + 1;
                case 1:
                    return lsPk.get(rowIndex).getKategori();
                case 2:
                    return lsPk.get(rowIndex).getNamaPekerjaan();
                case 3:
                    return biaya + "/" + lsPk.get(rowIndex).getSatuan();
            }
        }
        return "";
    }
    
    
    
}