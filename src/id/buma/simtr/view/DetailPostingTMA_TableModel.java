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

public class DetailPostingTMA_TableModel extends AbstractTableModel{

    private List<DetailPostingTransaksi> lsDpt = new ArrayList<>();
    
    public DetailPostingTMA_TableModel(List<DetailPostingTransaksi> lsDpt){
        this.lsDpt = lsDpt;
    }
    
    public List<DetailPostingTransaksi> getContentList(){
        return lsDpt;
    }
    
    public String[] columnNames = new String[]{
        "No.",
        "Nama Petani",
        "Tgl.",
        "<html><center>Netto<br>(Kw)</center></html>",
        "<html><center>Harga<br>Tebang Muat</center></html>",
        "<html><center>Harga<br>Angkutan</center></html>",
        "<html><center>Rp<br>Tebang Muat</center></html>",
        "<html><center>Rp<br>Angkutan</center></html>",
        "Total Biaya TMA"
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
        DecimalFormat df = new DecimalFormat("#,##0", dfs);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        int kwTebu = (int) (lsDpt.get(rowIndex).getTrn().getKuantaTransaksi()/100);
        int biayaTebang = (int) lsDpt.get(rowIndex).getByaTMA().getBiayaTebang()*100;
        int biayaAngkut = (int) lsDpt.get(rowIndex).getByaTMA().getBiayaAngkut()*100;
        int rpBiayaTebang = kwTebu * biayaTebang;
        int rpBiayaAngkut = kwTebu * biayaAngkut;
        switch (columnIndex){
            case 0:
                return rowIndex + 1;
            case 1:
                return lsDpt.get(rowIndex).getPt().getNamaPetani();
            case 2:
                return sdf.format(lsDpt.get(rowIndex).getTrn().getTglTransaksi());
            case 3:
                return df.format(kwTebu);
            case 4:
                return "Rp" + df.format(biayaTebang) + "/Kw";
            case 5:
                return "Rp" + df.format(biayaAngkut) + "/Kw";
            case 6:
                return "Rp" + df.format(rpBiayaTebang);
            case 7:
                return "Rp" + df.format(rpBiayaAngkut);
            case 8:
                return "Rp" + df.format(rpBiayaTebang + rpBiayaAngkut);
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
}
