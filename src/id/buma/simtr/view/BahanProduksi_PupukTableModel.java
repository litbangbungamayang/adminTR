/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.dao.BahanProduksiDAOSQL;
import id.buma.simtr.model.BahanProduksi;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class BahanProduksi_PupukTableModel extends AbstractTableModel{

    private final BahanProduksiDAOSQL bpDao = new BahanProduksiDAOSQL();
    
    private final List<BahanProduksi> lbp;
    
    public BahanProduksi_PupukTableModel(List<BahanProduksi> lsbp){
        this.lbp = lsbp;
    }
    
    public List<BahanProduksi> getContentList(){
        return lbp;
    }
    
    private final String[] columnNames = new String[]{
        "No.",
        "Nama Pupuk",
        "Dosis/Ha"
        };
    
    
    @Override
    public int getRowCount() {
        return lbp.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BahanProduksi bp = lbp.get(rowIndex);
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.UK);
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("###,##0.00", dfs);
        switch (columnIndex){
            case 0:
                return rowIndex + 1;
            case 1:
                return bp.getNamaBahan();
            case 2:
                return df.format(bp.getDosisPerHa()) + " " + bp.getSatuan();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
}
