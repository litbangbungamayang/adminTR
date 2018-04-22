/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.controller.CommonController;
import id.buma.simtr.database.DBConnection;
import id.buma.simtr.model.BuktiTransaksi;
import id.buma.simtr.model.TransaksiBahan;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class TransaksiBahanDAOSQL implements TransaksiBahanDAO {

    @Override
    public boolean insertNewTransaksiPupuk(TransaksiBahan tp) {
        Connection conn = new DBConnection().getConn();
        try {
            String strSql = "CALL INSERT_TRANSAKSI_PERMINTAAN_PUPUK(?,?,?,?,?,?,?,?,?,?)";
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
            10 - id dokumen (varchar 10)
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
                cst.setString(10, tp.getNomorBuktiTransaksi());
                cst.execute();
                if (cst.getUpdateCount() == 1) return true;
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiBahanDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TransaksiBahanDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TransaksiBahanDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<TransaksiBahan> cekStokBahanProduksi(int idBahan) {
        Connection conn = new DBConnection().getConn();
        List<TransaksiBahan> lsBp = new ArrayList<>();
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
                TransaksiBahan tp = new TransaksiBahan(
                        0, 
                        "", 
                        idBahan,
                        0,
                        lastDate, 
                        rs.getString("KODE_TRANSAKSI"), 
                        rs.getFloat("KUANTA_TRANSAKSI"), 
                        CommonController.user.getUserId(), 
                        postingTimestamp, 
                        rs.getInt("TAHUN_GILING"), 
                        BigInteger.valueOf(rs.getLong("NILAI_TRANSAKSI")),
                        ""
                );
                lsBp.add(tp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiBahanDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsBp;
    }

    @Override
    public boolean cekTransaksiPupukByIdKelompokJenisBahan(String idKelompok, String jenisBahan) {
        Connection conn = new DBConnection().getConn();
        String callSQL = "CALL CEK_TRANSAKSI_BAHAN_BY_IDKELOMPOK_JENISBAHAN (?,?,?)";
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setString(1, idKelompok);
            cst.setString(2, jenisBahan);
            cst.registerOutParameter(3, java.sql.Types.INTEGER);
            cst.execute();
            if (cst.getInt(3) == 1) return true;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiBahanDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public JasperPrint cetakPermintaanPupuk(String idKelompok) {
        Connection conn = new DBConnection().getConn();
        JasperPrint jp = null;
        String fileName = "./reports/PermintaanPupuk.jasper";
        Map map = new HashMap();
        map.put("IDKELOMPOK", idKelompok);
        try {
            jp = JasperFillManager.fillReport(fileName, map, conn);
        } catch (JRException ex) {
            Logger.getLogger(TransaksiBahanDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiBahanDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jp;
    }

    @Override
    public boolean insertBatchTransaksiPupuk(List<TransaksiBahan> listTp) {
        Connection conn = new DBConnection().getConn();
        try {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            String callSQL = "CALL INSERT_TRANSAKSI_PERMINTAAN_PUPUK(?,?,?,?,?,?,?,?,?,?,?)";
            CallableStatement cst = conn.prepareCall(callSQL);
            for(TransaksiBahan tp : listTp){
                cst.setString(1, tp.getIdPetani());
                cst.setInt(2, tp.getIdBahan());
                cst.setInt(3, tp.getIdBiaya());
                cst.setDate(4, tp.getTglTransaksi());
                cst.setFloat(5, tp.getKuantaTransaksi());
                cst.setInt(6, tp.getIdUser());
                cst.setTimestamp(7, tp.getTglPosting());
                cst.setString(8, tp.getKodeTransaksi());
                cst.setInt(9, tp.getTahunGiling());
                cst.setLong(10, Long.parseLong(String.valueOf(tp.getNilaiTransaksi())));
                cst.setString(11, tp.getNomorBuktiTransaksi());
                cst.addBatch();
            }
            cst.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiBahanDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(TransaksiBahanDAOSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiBahanDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean insertBuktiTransaksiPupuk(BuktiTransaksi bk) {
        Connection conn = new DBConnection().getConn();
        String callSQl = "CALL INSERT_NEW_BUKTI_TRANSAKSI(?,?,?)";
        /*
            1 - no dokumen (varchar 100)
            2 - user id (int)
            3 - posting timestamp (datetime)
        */
        try (CallableStatement cst = conn.prepareCall(callSQl)){
            cst.setString(1, bk.getNoBukti());
            cst.setInt(2, bk.getUserId());
            cst.setTimestamp(3, bk.getPostingTime());
            cst.execute();
            if (cst.getUpdateCount() > 0) return true;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiBahanDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public String getNewNomorBuktiTransaksi(String idKelompok, int idBahan) {
        Connection conn = new DBConnection().getConn();
        String callSQl = "CALL GET_NEW_NO_BUKTI_TRANSAKSI (?,?,?)";
        try (CallableStatement cst = conn.prepareCall(callSQl)){
            cst.setString(1, idKelompok);
            cst.setInt(2, idBahan);
            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            cst.execute();
            return cst.getString(3);
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiBahanDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public JasperPrint cetakEvaluasiPupuk(String idAfd, java.sql.Date tgl1, java.sql.Date tgl2) {
        Connection conn = new DBConnection().getConn();
        JasperPrint jp = null;
        String fileName = "./reports/RekapPemakaianPupuk.jasper";
        Map map = new HashMap();
        map.put("IDAFD", idAfd);
        map.put("TGL1", tgl1);
        map.put("TGL2", tgl2);
        try {
            jp = JasperFillManager.fillReport(fileName, map, conn);
        } catch (JRException ex) {
            Logger.getLogger(TransaksiBahanDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiBahanDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jp;
    }
    
}
