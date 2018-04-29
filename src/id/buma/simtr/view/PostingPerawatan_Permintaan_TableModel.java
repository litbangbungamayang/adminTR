/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.model.Transaksi;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class PostingPerawatan_Permintaan_TableModel extends AbstractTableModel {
    
    private List<Transaksi> lsTrn = new ArrayList<>();
    
    public PostingPerawatan_Permintaan_TableModel(List<Transaksi> lsTrn){
        this.lsTrn = lsTrn;
    }
    
    public List<Transaksi> getListTransaksi(){
        return this.lsTrn;
    }
    
    public String[] columnNames = new String[]{
        "No.",
        "Nomor Transaksi",
        "Tanggal Transaksi"
    };
    
    @Override
    public int getRowCount() {
        return lsTrn.size();
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        switch (columnIndex){
            case 0:
                return rowIndex + 1;
            case 1:
                return lsTrn.get(rowIndex).getNomorBuktiTransaksi();
            case 2:
                return sdf.format(lsTrn.get(rowIndex).getTglTransaksi());
        }
        return null;
    }
    
}
