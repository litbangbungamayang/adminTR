/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DbConnectionManager;
import id.buma.simtr.model.Desa;
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

public class DesaDAOSQL implements DesaDAO {

    @Override
    public List<Desa> getAllDesa() {
        List<Desa> lsDesa = new ArrayList<>();
        if (DbConnectionManager.isConnect() == true){
            try {
                String callSQL = "exec GET_ALL_DESA";
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
                    cst.getMoreResults();
                }
                while (rs.next()){
                    Desa ds = new Desa(
                            rs.getInt("ID_DESA"), 
                            rs.getString("NAMA_DESA"), 
                            rs.getInt("ID_KECAMATAN")
                    );
                    lsDesa.add(ds);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error GetAllDesa! \nError code : " + ex.toString());
                Logger.getLogger(DesaDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
        return lsDesa;
    }

    @Override
    public List<Desa> getDesaByIdKecamatan(String IdKecamatan) {
        List<Desa> lsDesa = new ArrayList<>();
        if (DbConnectionManager.isConnect() == true){
            try {
                String callSQL = "exec GET_ALL_DESA_BY_IDKECAMATAN ?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSQL);
                cst.setString(1, IdKecamatan);
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
                    cst.getMoreResults();
                }
                while (rs.next()){
                    Desa ds = new Desa(
                            rs.getInt("ID_DESA"), 
                            rs.getString("NAMA_DESA"), 
                            rs.getInt("ID_KECAMATAN")
                    );
                    lsDesa.add(ds);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error GetAllDesa! \nError code : " + ex.toString());
                Logger.getLogger(DesaDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
        return lsDesa;
    }
    
    
    
}
