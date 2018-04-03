/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DBConnection;
import id.buma.simtr.model.BahanProduksi;
import java.sql.CallableStatement;
import java.sql.Connection;
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
        Connection conn = new DBConnection().getConn();
        List<BahanProduksi> lsb = new ArrayList<>();
        try {
            String strSql = "CALL GET_ALL_BAHAN_BY_JENIS(?)";
            CallableStatement cst = conn.prepareCall(strSql);
            cst.setString(1, jenisBahan);
            return commonGetBahanProduksi(cst);
        } catch (SQLException ex) {
            Logger.getLogger(BahanProduksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BahanProduksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lsb;
    }

    @Override
    public BahanProduksi getBahanProduksiByIdBahan(int idBahan) {
        Connection conn = new DBConnection().getConn();
        BahanProduksi bp = null;
        try {
            String strSql = "CALL GET_ALL_BAHAN_BY_IDBAHAN(?)";
            try (CallableStatement cst = conn.prepareCall(strSql)) {
                cst.setInt(1, idBahan);
                List<BahanProduksi> lsb = commonGetBahanProduksi(cst);
                if (lsb.size() == 1) return lsb.get(0);
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BahanProduksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bp;
    }
    
    private List<BahanProduksi> commonGetBahanProduksi(CallableStatement cst){
        List<BahanProduksi> lsb = new ArrayList<>();
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
        return lsb;
    }

    @Override
    public List<BahanProduksi> getAllBahanProduksi() {
        Connection conn = new DBConnection().getConn();
        List<BahanProduksi> lsb = new ArrayList<>();
        try {
            String strSql = "CALL GET_ALL_BAHAN";
            CallableStatement cst = conn.prepareCall(strSql);
            return commonGetBahanProduksi(cst);
        } catch (SQLException ex) {
            Logger.getLogger(BahanProduksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BahanProduksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lsb;
    }

    @Override
    public boolean insertNewBahan(BahanProduksi bp) {
        Connection conn = new DBConnection().getConn();
        String callSQL = "CALL INSERT_NEW_BAHAN (?,?,?,?)";
        /*
            1 - jenis bahan varchar(50)
            2 - nama bahan varchar(100)
            3 - satuan varchar(10)
            4 - dosis_per_ha double
        */
        try {
            CallableStatement cst = conn.prepareCall(callSQL);
            cst.setString(1, bp.getJenisBahan());
            cst.setString(2, bp.getNamaBahan());
            cst.setString(3, bp.getSatuan());
            cst.setDouble(4, bp.getDosisPerHa());
            cst.execute();
            if (cst.getUpdateCount() == 1) return true;
        } catch (SQLException ex) {
            Logger.getLogger(BahanProduksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BahanProduksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean updateBahan(BahanProduksi bp) {
        Connection conn = new DBConnection().getConn();
        String callSQL = "CALL UPDATE_BAHAN(?,?,?,?,?)";
        /*
            1 - id bahan int
            2 - jenis bahan varchar(50)
            3 - nama bahan varchar(100)
            4 - satuan varchar(10)
            5 - dosis double
        */
        try {
            CallableStatement cst = conn.prepareCall(callSQL);
            cst.setInt(1, bp.getIdBahan());
            cst.setString(2, bp.getJenisBahan());
            cst.setString(3, bp.getNamaBahan());
            cst.setString(4, bp.getSatuan());
            cst.setDouble(5, bp.getDosisPerHa());
            cst.execute();
            if (cst.getUpdateCount() == 1) return true;
        } catch (SQLException ex) {
            Logger.getLogger(BahanProduksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BahanProduksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean deleteBahan(int idBahan) {
        Connection conn = new DBConnection().getConn();
        String callSQL = "CALL DELETE_BAHAN(?)";
        /*
            1 - id bahan int
        */
        try {
            CallableStatement cst = conn.prepareCall(callSQL);
            cst.setInt(1, idBahan);
            cst.execute();
            if (cst.getUpdateCount() == 1) return true;
        } catch (SQLException ex) {
            Logger.getLogger(BahanProduksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BahanProduksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean cekBahanProduksiDigunakan(int idBahan) {
        Connection conn = new DBConnection().getConn();
        String callSQL = "CALL CEK_BAHAN (?)";
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setInt(1, idBahan);
            List<BahanProduksi> lsb = commonGetBahanProduksi(cst);
            if (lsb.size() > 0) return false;
        } catch (SQLException ex) {
            Logger.getLogger(BahanProduksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}
