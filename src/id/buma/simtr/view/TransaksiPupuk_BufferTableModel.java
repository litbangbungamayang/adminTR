/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.dao.BahanProduksiDAOSQL;
import id.buma.simtr.model.BahanProduksi;
import id.buma.simtr.model.PetaniTebu;
import id.buma.simtr.model.TransaksiPupuk;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class TransaksiPupuk_BufferTableModel extends AbstractTableModel {
    
    private final BahanProduksiDAOSQL bpDao = new BahanProduksiDAOSQL();
    
    private List<BahanProduksi> lbp = bpDao.getAllBahanProduksiByJenis("PUPUK");
    
    private List<PetaniTebu> lpt = new ArrayList<>();
    
    private List<BahanProduksi> lbpSelected = new ArrayList<>();
    
    private List<TransaksiPupuk> listTransPupuk = new ArrayList<>();
    
    private JTable tblUsed;
    
    public void setTableUsed(JTable tbl){
        this.tblUsed = tbl;
    }
    
    public void setArrayPetani(List<PetaniTebu> lpt){
        this.lpt = lpt;
    }
    
    public void setArrayBahanProduksi(List<BahanProduksi> lbpSelected){
        this.lbpSelected = lbpSelected;
    }
    
    public TransaksiPupuk_BufferTableModel(List<TransaksiPupuk> listTransPupuk){
        this.listTransPupuk = listTransPupuk;
        initColumnNames();
    }
    
    private final String[] columnNames = new String[lbp.size() + 2];
    
    private void initColumnNames(){
        columnNames[0] = "No.";
        columnNames[1] = "Nama Petani";
        for (int i = 2; i < (lbp.size() + 2); i++){
            columnNames[i] = lbp.get(i-2).getNamaBahan();
        }
    }

    @Override
    public int getRowCount() {
        if (lpt.size() > 0)
            return lpt.size();
        else 
            return 0;
    }

    @Override
    public int getColumnCount() {
        return lbp.size() + 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.UK);
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("###,##0.00", dfs);
        if (columnIndex == 0){
            return rowIndex + 1;
        } else {
            if (columnIndex == 1){
                return lpt.get(rowIndex).getNamaPetani();
            } else {
                for (int i = 2; i < lbp.size() + 2; i++){
                    if (columnIndex == i){
                        String kuanta = "0.00";
                        for (int j = 0; j < lbpSelected.size(); j++){
                            if (lbp.get(i-2).getIdBahan() == lbpSelected.get(j).getIdBahan()){
                                kuanta = df.format(lbp.get(i-2).getDosisPerHa()*lpt.get(rowIndex).getLuas());
                            }
                        }
                        return kuanta;
                    }
                }
            }
        }
        return "Tidak ada data";
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    
    
}
