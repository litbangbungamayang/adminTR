/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DBConnection;
import id.buma.simtr.database.DbConnectionManager;
import id.buma.simtr.model.VarietasTebu;
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

public class VarietasTebuDAOSQL implements VarietasTebuDAO{

    @Override
    public List<VarietasTebu> getAllVarietasTebu() {
        Connection conn = new DBConnection().getConn();
        List<VarietasTebu> lstVar = new ArrayList<>();
        try {
            String callSQL = "CALL GET_ALL_VARIETAS";
            CallableStatement cst = conn.prepareCall(callSQL,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            lstVar = commonGetDataVarietas(cst);
        } catch (SQLException ex) {
            Logger.getLogger(VarietasTebuDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error getAllVarietas! \nError code : " + 
                    ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(VarietasTebuDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lstVar;
    }

    @Override
    public VarietasTebu getVarietasById(String idVarietas) {
        Connection conn = new DBConnection().getConn();
        List<VarietasTebu> lstVar = new ArrayList<>();
        VarietasTebu vt = null;
        int idVarStr = 0;
        try {
            String callSQL = "CALL GET_VARIETAS_BY_IDVARIETAS(?)";
            CallableStatement cst = conn.prepareCall(callSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            if (idVarietas.isEmpty() == false){
                idVarStr = Integer.parseInt(idVarietas);
            }
            cst.setInt(1, idVarStr);
            lstVar = commonGetDataVarietas(cst);
            if (lstVar.size() == 1){
                vt = lstVar.get(0);
            }
        } catch (NumberFormatException | SQLException ex) {
            Logger.getLogger(VarietasTebuDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error getVarietasByID! \nError code : " + 
                    ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(VarietasTebuDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return vt;
    }
    
    private List<VarietasTebu> commonGetDataVarietas(CallableStatement statement){
        List<VarietasTebu> lstVar = new ArrayList<>();
        try {
                CallableStatement cst = statement;
                boolean result = cst.execute();
                ResultSet rs = null;
                int rowsAffected = 0;
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
                    VarietasTebu vt = new VarietasTebu(
                            rs.getString("ID_VARIETAS"), 
                            rs.getString("NAMA_LAB"), 
                            rs.getString("NAMA_RILIS"),
                            rs.getString("NOMOR_SURAT"), 
                            rs.getString("SIFAT_KEMASAKAN")
                    );
                    lstVar.add(vt);
                }
            } catch (SQLException ex) {
                Logger.getLogger(VarietasTebuDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error getCommonDataVarietas! \nError code : " + 
                        ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        return lstVar;
    }
    
}
