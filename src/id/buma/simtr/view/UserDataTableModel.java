/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.model.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class UserDataTableModel extends AbstractTableModel {
    
    private final List<User> lstUser;
    
    public UserDataTableModel(List<User> lstUser){
        this.lstUser = lstUser;
    }
    
    public List<User> getContentList(){
        return this.lstUser;
    }
    
    private final String[] columnNames = new String[]{
        "No.",
        "Nama Lengkap",
        "Username",
        "Level",
        "Afd"
    };

    @Override
    public int getRowCount() {
        return lstUser.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return rowIndex + 1;
            case 1:
                return lstUser.get(rowIndex).getNamaLengkap();
            case 2:
                return lstUser.get(rowIndex).getUsername();
            case 3:
                return lstUser.get(rowIndex).getPrivLevel();
            case 4:
                return lstUser.get(rowIndex).getIdAfd();
        }
        return null;
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
