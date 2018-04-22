/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.dao.VarietasTebuDAO;
import id.buma.simtr.dao.VarietasTebuDAOSQL;
import id.buma.simtr.model.PetaniTebu;
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

public class PetaniTableModel extends AbstractTableModel {
    
    private final VarietasTebuDAO varDAO = new VarietasTebuDAOSQL();
    private boolean isEmpty = false;
    private final List<PetaniTebu> lsPetani;
    
    public PetaniTableModel(List<PetaniTebu> lsPetani){
        this.lsPetani = lsPetani;
        if (this.lsPetani.size() < 1){
            isEmpty = true;
            PetaniTebu pt = new PetaniTebu("", 0, "", "", "", 0, "");
            this.lsPetani.add(pt);
        }
    }
    
    public List<PetaniTebu> getContentList(){
        return lsPetani;
    }

    private final String[] columnNames = new String[]{
        "No.",
        "Nama Petani",
        "Luas",
        "MT",
        "Varietas"
    };
    
    @Override
    public int getRowCount() {
        return this.lsPetani.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String namaVarietas;
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.UK);
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("###,#0.00", dfs);
        if (!isEmpty){
            PetaniTebu pt = lsPetani.get(rowIndex);
            namaVarietas = varDAO.getVarietasById(pt.getJenisTebu()).getNamaLab();
            switch(columnIndex){
                case 0 :
                    return rowIndex + 1;
                case 1 :
                    return pt.getNamaPetani();
                case 2 :
                    return df.format(pt.getLuas());
                case 3 :
                    return pt.getMasaTanam();
                case 4 :
                    return namaVarietas;
            }
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }
    
    @Override
    public boolean isCellEditable(int row, int column){
        return false;
    }
    
}
