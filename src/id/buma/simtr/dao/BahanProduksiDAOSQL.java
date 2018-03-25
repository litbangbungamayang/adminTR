/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DbConnectionManager;
import id.buma.simtr.model.BahanProduksi;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class BahanProduksiDAOSQL implements BahanProduksiDAO {

    @Override
    public List<BahanProduksi> getAllBahanProduksiByJenis(String jenisBahan) {
        List<BahanProduksi> lsb = new ArrayList<>();
        if (DbConnectionManager.isConnect()){
            try {
                String strSql = "exec GET_ALL_BAHAN_BY_JENIS ?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(strSql);
                cst.setString(1, jenisBahan);
                return commonGetBahanProduksi(cst);
            } catch (Exception ex) {
                Logger.getLogger(BahanProduksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return lsb;
    }

    @Override
    public BahanProduksi getBahanProduksiByIdBahan(int idBahan) {
        BahanProduksi bp = null;
        if (DbConnectionManager.isConnect()){
            try {
                String strSql = "exec GET_ALL_BAHAN_BY_IDBAHAN ?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(strSql);
                cst.setInt(1, idBahan);
                List<BahanProduksi> lsb = commonGetBahanProduksi(cst);
                if (lsb.size() == 1) return lsb.get(0);
            } catch (Exception ex) {
                Logger.getLogger(BahanProduksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
        return bp;
    }
    
    private List<BahanProduksi> commonGetBahanProduksi(CallableStatement cst){
        List<BahanProduksi> lsb = new ArrayList<>();
        if (DbConnectionManager.isConnect()){
            try {
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
                    BahanProduksi bp = new BahanProduksi(
                            rs.getInt("ID_BAHAN"), 
                            rs.getString("JENIS_BAHAN"), 
                            rs.getString("NAMA_BAHAN"), 
                            rs.getString("SATUAN"), 
                            rs.getFloat("DOSIS")
                    );
                    lsb.add(bp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(BahanProduksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lsb;
    }
    
}
