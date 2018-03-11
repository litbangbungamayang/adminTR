/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DbConnectionManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class CounterDAOSQL implements CounterDAO{

    @Override
    public String getNewIdKelompok(int afdeling) {
        String newIdKelompok = null;
        if (DbConnectionManager.isConnect() == true){
            try {
                String callSQL = "exec GET_NEW_IDKELOMPOK ?,?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSQL,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                cst.setInt(1, afdeling);
                cst.registerOutParameter(2, java.sql.Types.VARCHAR);
                cst.execute();
                newIdKelompok = cst.getString(2);
            } catch (Exception ex) {
                Logger.getLogger(CounterDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error getNewIdKelompok! \nError code : " +  
                        ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return newIdKelompok;
    }

    @Override
    public String getNewIdPetani(String idKelompok) {
        String newIdPetani = null;
        if (DbConnectionManager.isConnect() == true){
            try {
                String callSQL = "exec GET_NEW_IDPETANI ?,?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSQL,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                cst.setString(1, idKelompok);
                cst.registerOutParameter(2, java.sql.Types.VARCHAR);
                cst.execute();
                newIdPetani = cst.getString(2);
            } catch (Exception ex) {
                Logger.getLogger(CounterDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error getNewIdPetani! \nError code : " +  
                        ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return newIdPetani;
    }
    
}
