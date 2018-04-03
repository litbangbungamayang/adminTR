/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DBConnection;
import id.buma.simtr.model.IdNoKontrak;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public IdNoKontrak getNewIdKelompok(int afdeling, int kategori) {
        Connection conn = new DBConnection().getConn();
        IdNoKontrak newIdNoKontrak = null;
            try {
                String callSQL = "CALL GET_NEW_IDKELOMPOK(?,?,?,?)";
                try (CallableStatement cst = conn.prepareCall(callSQL,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                    cst.setInt(1, afdeling);
                    cst.setInt(2, kategori);
                    cst.registerOutParameter(3, java.sql.Types.VARCHAR);
                    cst.registerOutParameter(4, java.sql.Types.VARCHAR);
                    cst.execute();
                    String newIdKelompok = cst.getString(3);
                    String newNoKontrak = cst.getString(4);
                    newIdNoKontrak = new IdNoKontrak(newIdKelompok,newNoKontrak);
                } finally {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CounterDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error getNewIdKelompok! \nError code : " +  
                        ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        return newIdNoKontrak;
    }

    @Override
    public String getNewIdPetani(String idKelompok) {
        Connection conn = new DBConnection().getConn();
        String newIdPetani = null;
        try {
            String callSQL = "CALL GET_NEW_IDPETANI(?,?)";
            try (CallableStatement cst = conn.prepareCall(callSQL,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                cst.setString(1, idKelompok);
                cst.registerOutParameter(2, java.sql.Types.VARCHAR);
                cst.execute();
                newIdPetani = cst.getString(2);
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CounterDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error getNewIdPetani! \nError code : " +  
                    ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return newIdPetani;
    }
    
}
