/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.dao.BahanProduksiDAOSQL;
import id.buma.simtr.model.Transaksi;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class BahanProduksiMasukTableModel extends AbstractTableModel {
    
    private final List<Transaksi> lstTp;
    
    public BahanProduksiMasukTableModel(List<Transaksi> lstTp){
        this.lstTp = lstTp;
    }
    
    private final String[] columnNames = new String[]{
        "No.",
        "Kode",
        "Tgl. Transaksi",
        "Kuantitas",
        "",
        "Nilai (Rp)"
    };

    @Override
    public int getRowCount() {
        return lstTp.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String satuan;
        BahanProduksiDAOSQL bpDao = new BahanProduksiDAOSQL();
        satuan = bpDao.getBahanProduksiByIdBahan(lstTp.get(rowIndex).getIdBahan()).getSatuan();
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,##0",dfs);
        DecimalFormat dfKuanta = new DecimalFormat("#,##0.0", dfs);
        String nilai = df.format(lstTp.get(rowIndex).getNilaiTransaksi());
        String kuanta = df.format(lstTp.get(rowIndex).getKuantaTransaksi());
        switch (columnIndex){
            case 0 :
                return rowIndex + 1;
            case 1 :
                return lstTp.get(rowIndex).getKodeTransaksi();
            case 2 :
                return lstTp.get(rowIndex).getTglTransaksi();
            case 3 :
                return kuanta;
            case 4 :
                return satuan;
            case 5 :
                return nilai;
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
