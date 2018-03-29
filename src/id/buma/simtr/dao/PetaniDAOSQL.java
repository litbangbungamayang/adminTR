/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DBConnection;
import id.buma.simtr.database.DbConnectionManager;
import id.buma.simtr.model.PetaniTebu;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class PetaniDAOSQL implements PetaniDAO{

    @Override
    public List<PetaniTebu> getAllPetaniTebuByIdKelompok(String idKelompok) {
        Connection conn = new DBConnection().getConn();
        List <PetaniTebu> lpt = new ArrayList<>();
        try {
            String callSQL = "CALL GET_KELOMPOKTANID_BY_IDKELOMPOK(?)";
            CallableStatement cst = conn.prepareCall(callSQL,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cst.setString(1, idKelompok);
            lpt = commonGetDataPetaniTebu(cst);
        } catch (SQLException ex) {
            Logger.getLogger(PetaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PetaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lpt;
    }


    @Override
    public List<PetaniTebu> getAllPetaniTebu() {
        List <PetaniTebu> lpt = new ArrayList<>();
        Connection conn = new DBConnection().getConn();
        try {
            String callSQL = "CALL GET_ALL_KELOMPOKTANID";
            CallableStatement cst = conn.prepareCall(callSQL,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            lpt = commonGetDataPetaniTebu(cst);
        } catch (SQLException ex) {
            Logger.getLogger(PetaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PetaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lpt;
    }

    @Override
    public List<PetaniTebu> getAllPetaniTebuByTahun(int tahun) {
        Connection conn = new DBConnection().getConn();
        List <PetaniTebu> lpt = new ArrayList<>();
        try {
            String callSQL = "CALL GET_KELOMPOKTANID_BY_TAHUN(?)";
            CallableStatement cst = conn.prepareCall(callSQL,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cst.setInt(1, tahun);
            lpt = commonGetDataPetaniTebu(cst);
        } catch (SQLException ex) {
            Logger.getLogger(PetaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PetaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lpt;
    }
    
    public List<PetaniTebu> commonGetDataPetaniTebu(CallableStatement cstInput){
        CallableStatement cst = cstInput;
        List<PetaniTebu> lpt = new ArrayList<>();
        try {
            boolean result = cst.execute();
            ResultSet rs = null;
            while (result){
                if (result){
                    rs = cst.getResultSet();
                    break;
                }
                result = cst.getMoreResults();
            }
            while (rs.next()){
                PetaniTebu pt = new PetaniTebu(
                        rs.getString("IDPETANI"),
                        rs.getInt("TAHUN"), 
                        rs.getString("IDKELOMPOK"), 
                        rs.getString("NAMAPETANI"), 
                        rs.getString("MASATANAM"), 
                        rs.getFloat("LUAS"), 
                        rs.getString("JENISTEBU")
                );
                lpt.add(pt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PetaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lpt;
    }

    @Override
    public boolean insertPetaniTebu(PetaniTebu pt) {
        Connection conn = new DBConnection().getConn();
        try {
            String callSQL = "CALL INSERT_KELOMPOKTANID(?,?,?,?,?,?,?)";
            try (CallableStatement cst = conn.prepareCall(callSQL,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                cst.setString(1, pt.getIdPetani());
                cst.setInt(2, pt.getTahun());
                cst.setString(3, pt.getIdKelompok());
                cst.setString(4, pt.getNamaPetani());
                cst.setString(5, pt.getMasaTanam());
                cst.setFloat(6, pt.getLuas());
                cst.setString(7, pt.getJenisTebu());
                cst.execute();
                if (cst.getUpdateCount() == 1){
                    return true;
                }
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PetaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error insertPetaniTebu! \nError code : " + 
                    ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
