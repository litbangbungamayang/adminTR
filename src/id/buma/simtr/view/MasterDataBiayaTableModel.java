/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.controller.CommonController;
import id.buma.simtr.model.Biaya;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class MasterDataBiayaTableModel extends AbstractTableModel{
    
    List<Biaya> lsBya = new ArrayList<>();
    
    public MasterDataBiayaTableModel(List<Biaya> lsBya){
        this.lsBya = lsBya;
    }
    
    public List<Biaya> getContentList(){
        return this.lsBya;
    }
    
    public final String[] columnNames = new String[]{
            "No.",
            "Kode",
            "Kategori",
            "Jenis",
            "Uraian",
            "Satuan",
            "T/G",
            "Harga Satuan"
        };

    @Override
    public int getRowCount() {
        return lsBya.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CommonController cc = new CommonController();
        String biaya = cc.formatAngka(lsBya.get(rowIndex).getRupiahBiaya(), "#,##0");
        if (!lsBya.isEmpty()){
            switch (columnIndex){
                case 0:
                    return rowIndex + 1;
                case 1:
                    return lsBya.get(rowIndex).getKodeBiaya();
                case 2:
                    return lsBya.get(rowIndex).getKategori();
                case 3:
                    return lsBya.get(rowIndex).getJenisBiaya();
                case 4:
                    return lsBya.get(rowIndex).getNamaBiaya();
                case 5:
                    return lsBya.get(rowIndex).getSatuan();
                case 6:
                    return lsBya.get(rowIndex).getTahunGiling();
                case 7:
                    return biaya;
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
}
