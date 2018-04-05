/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.dao.BahanProduksiDAOSQL;
import id.buma.simtr.model.BahanProduksi;
import id.buma.simtr.model.BufferTable_TransaksiPupuk;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class BufferTransaksi_PupukTableModel extends AbstractTableModel {
    
    private List<BufferTable_TransaksiPupuk> lbt = new ArrayList<>();
    private BahanProduksiDAOSQL bpDao = new BahanProduksiDAOSQL();
    private List<BahanProduksi> lbp = bpDao.getAllBahanProduksiByJenis("PUPUK");
    private String[] columnNames;

    public BufferTransaksi_PupukTableModel(List<BufferTable_TransaksiPupuk> lbt){
        this.lbt = lbt;
        columnNames = new String[2 + lbp.size()];
        columnNames[0] = "No.";
        columnNames[1] = "Nama Petani";
        for (int i = 2; i < (lbp.size() + 2); i++){
            columnNames[i] = lbp.get(i-2).getNamaBahan();
        }
    }
    
    @Override
    public int getRowCount() {
        int rowCount = 0;
        if (lbt.size() > 0){
            rowCount = lbt.size();
        } else {
            rowCount = 1;
        }
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object cellValue = "";
        if (lbt.size() > 0){
            DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.UK);
            dfs.setDecimalSeparator(',');
            dfs.setGroupingSeparator('.');
            DecimalFormat df = new DecimalFormat("###,##0.00", dfs);
            if (columnIndex == 0){
                cellValue =  rowIndex + 1;
            } else {
                if (columnIndex == 1){
                    cellValue = lbt.get(rowIndex).getNamaPetani();
                } else {
                    if (columnIndex > 1){
                        cellValue =  df.format(lbt.get(rowIndex).getKuanta()[columnIndex-2]);
                    }
                }
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
}
