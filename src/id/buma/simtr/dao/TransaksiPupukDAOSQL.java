/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.controller.CommonController;
import id.buma.simtr.database.DBConnection;
import id.buma.simtr.model.TransaksiPupuk;
import java.math.BigInteger;
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

public class TransaksiPupukDAOSQL implements TransaksiPupukDAO {

    @Override
    public boolean insertNewTransaksiPupuk(TransaksiPupuk tp) {
        Connection conn = new DBConnection().getConn();
        try {
            String strSql = "CALL INSERT_TRANSAKSI_PERMINTAAN_PUPUK(?,?,?,?,?,?,?,?,?)";
            /*
            1 - idpetani (varchar)
            2 - idbahan (int)
            3 - tgl_transaksi (date)
            4 - kuanta (float)
            5 - iduser (int)
            6 - timestamp (datetime)
            7 - kode transaksi (varchar)
            8 - tahun giling (int)
            9 - nilai transaksi (big int)
            */
            try (CallableStatement cst = conn.prepareCall(strSql)) {
                cst.setString(1, tp.getIdPetani());
                cst.setInt(2, tp.getIdBahan());
                cst.setDate(3, tp.getTglTransaksi());
                cst.setFloat(4, tp.getKuantaTransaksi());
                cst.setInt(5, tp.getIdUser());
                cst.setTimestamp(6, tp.getTglPosting());
                cst.setString(7, tp.getKodeTransaksi());
                cst.setInt(8, tp.getTahunGiling());
                cst.setLong(9, Long.parseLong(String.valueOf(tp.getNilaiTransaksi())));
                cst.execute();
                if (cst.getUpdateCount() == 1) return true;
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPupukDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean cekDuplicateTransaksiPupuk(String idPetani, int idBahan) {
        Connection conn = new DBConnection().getConn();
        try {
            String strSql = "CALL GET_TRANSAKSI_PUPUK_BY_IDPETANI_IDBAHAN(?,?)";
            try ( /*
            1 = idpetani (Varchar)
            2 = idbahan int
             */ CallableStatement cst = conn.prepareCall(strSql)) {
                cst.setString(1, idPetani);
                cst.setInt(2, idBahan);
                boolean result = cst.execute();
                ResultSet rs = null;
                while (result){
                    if (result){
                        rs = cst.getResultSet();
                        break;
                    }
                    result = cst.getMoreResults();
                }
                int jmlRecord = 0;              
                while (rs.next()){
                    jmlRecord++;
                }
                if (jmlRecord == 0) return true;
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPupukDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean cekBarangMasuk(int idBahan) {
        Connection conn = new DBConnection().getConn();
        String callSQL = "CALL CEK_BARANG_MASUK(?,?)";
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setInt(1, idBahan);
            cst.registerOutParameter(2, java.sql.Types.INTEGER);
            cst.execute();
            if (cst.getInt(2) == 1) return true;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPupukDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<TransaksiPupuk> cekStokBahanProduksi(int idBahan) {
        Connection conn = new DBConnection().getConn();
        List<TransaksiPupuk> lsBp = new ArrayList<>();
        String callSQL = "CALL GET_SUMMARY_BAHAN_PRODUKSI(?)";
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setInt(1, idBahan);
            java.sql.Timestamp postingTimestamp = new java.sql.Timestamp(new java.util.Date().getTime());
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
                java.sql.Date lastDate;
                if (rs.getString("TGL_TRANSAKSI_TERAKHIR").equals("")){
                    lastDate = null;
                } else {
                    lastDate = rs.getDate("TGL_TRANSAKSI_TERAKHIR");
                }
                TransaksiPupuk tp = new TransaksiPupuk(
                        0, 
                        "", 
                        idBahan, 
                        lastDate, 
                        rs.getString("KODE_TRANSAKSI"), 
                        rs.getFloat("KUANTA_TRANSAKSI"), 
                        CommonController.user.getUserId(), 
                        postingTimestamp, 
                        rs.getInt("TAHUN_GILING"), 
                        BigInteger.valueOf(rs.getLong("NILAI_TRANSAKSI"))
                );
                lsBp.add(tp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPupukDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsBp;
    }
    
}
