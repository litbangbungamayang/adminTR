/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.model.DetailPostingTransaksi;
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

public class DetailPostingPerawatan_Permintaan_TableModel extends AbstractTableModel{

    private List<DetailPostingTransaksi> lsDpt = new ArrayList<>();
    
    public DetailPostingPerawatan_Permintaan_TableModel(List<DetailPostingTransaksi> lsDpt){
        this.lsDpt = lsDpt;
    }
    
    public String[] columnNames = new String[]{
        "No.",
        "Nama Petani",
        "Tgl. Transaksi",
        "Nama Pekerjaan",
        "Kuanta",
        "Harga Satuan",
        "Nilai (Rp)"
    };
    
    @Override
    public int getRowCount() {
        return lsDpt.size();
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
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,##0.00", dfs);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        switch (columnIndex){
            case 0:
                return rowIndex + 1;
            case 1:
                return lsDpt.get(rowIndex).getPt().getNamaPetani();
            case 2:
                return sdf.format(lsDpt.get(rowIndex).getTrn().getTglTransaksi());
            case 3:
                return lsDpt.get(rowIndex).getBya().getNamaBiaya();
            case 4:
                return df.format(lsDpt.get(rowIndex).getTrn().getKuantaTransaksi()) + " " + lsDpt.get(rowIndex).getBya().getSatuan();
            case 5:
                return df.format(lsDpt.get(rowIndex).getBya().getRupiahBiaya()) + "/" + lsDpt.get(rowIndex).getBya().getSatuan();
            case 6:
                return df.format(lsDpt.get(rowIndex).getTrn().getNilaiTransaksi());
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    
}
