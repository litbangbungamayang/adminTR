/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.dao.AfdelingDAO;
import id.buma.simtr.dao.AfdelingDAOSQL;
import id.buma.simtr.model.KelompokTani;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class KelompokTaniTableModel extends AbstractTableModel{
    
    private final AfdelingDAO afdelingDao = new AfdelingDAOSQL();
    
    private final List<KelompokTani> kelTani;
    
    public KelompokTaniTableModel(List<KelompokTani> lkt){
        this.kelTani = lkt;
    }
    
    public List<KelompokTani> getContentList(){
        return kelTani;
    }
    
    private final String[] columnNames = new String[]{
        "No.",
        "ID Kelompok",
        "Afd.",
        "Tahun",
        "Nama Kelompok",
        "No. Kontrak"
    };

    @Override
    public int getRowCount() {
        return kelTani.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        KelompokTani kt = kelTani.get(rowIndex);
        String afdStr;
        afdStr = afdelingDao.getAfdelingByIdAfd(kt.getIdAfd()).get(0).getAfdeling();
        switch(columnIndex){
            case 0 :
                return rowIndex + 1;
            case 1 :
                return kt.getIdKelompok();
            case 2 :
                return afdStr;
            case 3 :
                return kt.getTahun();
            case 4 :
                return kt.getNamaKelompok();
            case 5 :
                return kt.getNoKontrak();
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
