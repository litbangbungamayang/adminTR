/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DbConnectionManager;
import id.buma.simtr.model.Kecamatan;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class KecamatanDAOSQL implements KecamatanDAO{

    @Override
    public List<Kecamatan> getKecamatanByIdKecamatan(int IdKecamatan) {
        List<Kecamatan> lstKec = new ArrayList<>();
        if (DbConnectionManager.isConnect() == true){
            try {
                String callSQL  = "exec GET_KECAMATAN_BY_IDKECAMATAN ?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSQL);
                cst.setInt(1, IdKecamatan);
                boolean result = cst.execute();
                int rowsAffected = 0;
                ResultSet rs = null;
                while (result || rowsAffected != -1){
                    if (result){
                        rs = cst.getResultSet();
                        break;
                    } else {
                        rowsAffected = cst.getUpdateCount();
                    }
                    result = cst.getMoreResults();
                }
                while (rs.next()){
                    Kecamatan kec = new Kecamatan(
                            rs.getString("ID_KECAMATAN"), 
                            rs.getString("NAMA_KECAMATAN")
                    );
                    lstKec.add(kec);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error getKecamatanByIdKecamatan \nError code : " + 
                        ex.toString(), "", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(KecamatanDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lstKec;
    }

    @Override
    public List<Kecamatan> getAllKecamatan() {
        List<Kecamatan> lstKec = new ArrayList<>();
        if (DbConnectionManager.isConnect() == true){
            try {
                String callSQL  = "exec GET_ALL_KECAMATAN";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSQL);
                boolean result = cst.execute();
                int rowsAffected = 0;
                ResultSet rs = null;
                while (result || rowsAffected != -1){
                    if (result){
                        rs = cst.getResultSet();
                        break;
                    } else {
                        rowsAffected = cst.getUpdateCount();
                    }
                    result = cst.getMoreResults();
                }
                while (rs.next()){
                    Kecamatan kec = new Kecamatan(
                            rs.getString("ID_KECAMATAN"), 
                            rs.getString("NAMA_KECAMATAN")
                    );
                    lstKec.add(kec);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error getKecamatanByIdKecamatan \nError code : " + 
                        ex.toString(), "", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(KecamatanDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lstKec;
    }
    
}
