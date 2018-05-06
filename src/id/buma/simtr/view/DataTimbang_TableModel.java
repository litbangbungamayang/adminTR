/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.model.DataTimbang;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class DataTimbang_TableModel extends AbstractTableModel{
    
    private List<DataTimbang> lsDt = new ArrayList<>();
    
    public DataTimbang_TableModel(List<DataTimbang> lsDt){
        this.lsDt = lsDt;
    }
    
    public List<DataTimbang> getContentList(){
        return lsDt;
    }
    
    public final String[] columnNames = new String[]{
            "No.",
            "ID Petani",
            "Nama Petani",
            "Bruto",
            "Tarra",
            "Netto",
            "Jam Keluar"
        };

    @Override
    public int getRowCount() {
        return lsDt.size();
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
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,##0",dfs);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        switch (columnIndex){
            case 0:
                return rowIndex + 1;
            case 1:
                return lsDt.get(rowIndex).getPetani().getIdPetani();
            case 2:
                return lsDt.get(rowIndex).getPetani().getNamaPetani();
            case 3:
                return df.format(lsDt.get(rowIndex).getBruto());
            case 4:
                return df.format(lsDt.get(rowIndex).getTarra());
            case 5:
                return df.format(lsDt.get(rowIndex).getNetto());
            case 6:
                return sdf.format(lsDt.get(rowIndex).getTglNetto());
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
}
