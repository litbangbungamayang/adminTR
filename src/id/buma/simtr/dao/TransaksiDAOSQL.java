/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.controller.CommonController;
import id.buma.simtr.database.DBConnection;
import id.buma.simtr.model.Biaya;
import id.buma.simtr.model.BiayaTMA;
import id.buma.simtr.model.BuktiTransaksi;
import id.buma.simtr.model.DetailPostingTransaksi;
import id.buma.simtr.model.PetaniTebu;
import id.buma.simtr.model.Transaksi;
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

public class TransaksiDAOSQL implements TransaksiDAO {

    @Override
    public boolean insertNewTransaksiPupuk(Transaksi tp) {
        Connection conn = new DBConnection().getConn();
        try {
            String strSql = "CALL INSERT_TRANSAKSI_BAHAN (?,?,?,?,?,?,?,?,?,?,?,?)";
            /*
            1- p_IDPETANI VARCHAR(15),
            2 - p_IDBAHAN INT,
            3 - p_IDBIAYA INT,
            4 - p_ID_TIMBANGAN INT,
            5 - p_TGL_TRANSAKSI DATE,
            6 - p_KUANTA DOUBLE,
            7 - p_IDUSER INT,
            8 - p_DATETIME_POSTING DATETIME(3),
            9 - p_KODE_TRANSAKSI CHAR(3),
            10 - p_TAHUN_GILING int,
            11 - p_NILAI_TRANSAKSI BIGINT,
            12 - p_ID_DOKUMEN VARCHAR(100)
            */
            try (CallableStatement cst = conn.prepareCall(strSql)) {
                cst.setString(1, tp.getIdPetani());
                cst.setInt(2, tp.getIdBahan());
                cst.setInt(3, tp.getIdBiaya());
                cst.setInt(4, tp.getIdTimbangan());
                cst.setDate(5, tp.getTglTransaksi());
                cst.setFloat(6, tp.getKuantaTransaksi());
                cst.setInt(7, tp.getIdUser());
                cst.setTimestamp(8, tp.getTglPosting());
                cst.setString(9, tp.getKodeTransaksi());
                cst.setInt(10, tp.getTahunGiling());
                cst.setLong(11, Long.parseLong(String.valueOf(tp.getNilaiTransaksi())));
                cst.setString(12, tp.getNomorBuktiTransaksi());
                cst.execute();
                if (cst.getUpdateCount() == 1) return true;
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean cekDuplikatTransaksiPupuk(String idPetani, int idBahan) {
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
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Transaksi> cekStokBahanProduksi(int idBahan) {
        Connection conn = new DBConnection().getConn();
        List<Transaksi> lsBp = new ArrayList<>();
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
                Transaksi tp = new Transaksi(
                        0, 
                        "", 
                        idBahan,
                        0,
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
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jp;
    }

    /*
    public boolean insertBatchTransaksi(List<TransaksiBahan> listTp) {
        Connection conn = new DBConnection().getConn();
        try {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            String callSQL = "CALL INSERT_TRANSAKSI_BAHAN (?,?,?,?,?,?,?,?,?,?,?)";
            CallableStatement cst = conn.prepareCall(callSQL);
            for(Transaksi tp : listTp){
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
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    */

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
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public String getNewNomorBuktiTransaksi(String idKelompok) {
        Connection conn = new DBConnection().getConn();
        String callSQl = "CALL GET_NEW_NO_BUKTI_TRANSAKSI (?,?)";
        try (CallableStatement cst = conn.prepareCall(callSQl)){
            cst.setString(1, idKelompok);
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.execute();
            return cst.getString(2);
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jp;
    }

    @Override
    public boolean insertBatchTransaksi(List<Transaksi> listTp, BuktiTransaksi buktiTrans) {
        Connection conn = new DBConnection().getConn();
        try {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            String callSQL = "CALL INSERT_TRANSAKSI_BAHAN (?,?,?,?,?,?,?,?,?,?,?,?)";
            CallableStatement cst = conn.prepareCall(callSQL);
            for(Transaksi tp : listTp){
                cst.setString(1, tp.getIdPetani());
                cst.setInt(2, tp.getIdBahan());
                cst.setInt(3, tp.getIdBiaya());
                cst.setInt(4, tp.getIdTimbangan());
                cst.setDate(5, tp.getTglTransaksi());
                cst.setFloat(6, tp.getKuantaTransaksi());
                cst.setInt(7, tp.getIdUser());
                cst.setTimestamp(8, tp.getTglPosting());
                cst.setString(9, tp.getKodeTransaksi());
                cst.setInt(10, tp.getTahunGiling());
                cst.setLong(11, Long.parseLong(String.valueOf(tp.getNilaiTransaksi())));
                cst.setString(12, tp.getNomorBuktiTransaksi());
                cst.addBatch();
            }
            cst.executeBatch();
            callSQL = "CALL INSERT_NEW_BUKTI_TRANSAKSI(?,?,?)";
            /*
                1 - no dokumen (varchar 100)
                2 - user id (int)
                3 - posting timestamp (datetime)
            */
            cst = conn.prepareCall(callSQL);
            cst.setString(1, buktiTrans.getNoBukti());
            cst.setInt(2, buktiTrans.getUserId());
            cst.setTimestamp(3, buktiTrans.getPostingTime());
            cst.execute();
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean cekDuplikatTransaksiPekerjaan(String idPetani, int idBiaya) {
        Connection conn = new DBConnection().getConn();
        String callSQL = "CALL CEK_TRANSAKSI_PEKERJAAN_BY_IDPETANI_IDPEKERJAAN(?,?)";
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            /*
             1 = idPetani (Varchar)
             2 = idBiaya (int)
            */
            /*
                AWAS! Hasilnya terbalik, kalau nilai output SP = 1 artinya ada record yg sama, begitu sebaliknya
            */
            cst.setString(1, idPetani);
            cst.setInt(2, idBiaya);
            cst.execute();
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
                if (rs.getInt("TRANSAKSI") == 0) return true; 
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Transaksi> getDataTransaksiByIdKelompokGrouped(String idKelompok) {
        Connection conn  = new DBConnection().getConn();
        List<Transaksi> lsTrn = new ArrayList<>();
        String callSQL = "CALL GET_TRANSAKSI_BY_IDKELOMPOK_GROUPED_IDDOKUMEN(?)";
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setString(1, idKelompok);
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
                 Transaksi trn = new Transaksi(
                         rs.getInt("ID_TRANSAKSI"), 
                         rs.getString("ID_PETANI"), 
                         rs.getInt("ID_BAHAN"), 
                         rs.getInt("ID_BIAYA"),
                         0,
                         rs.getDate("TGL_TRANSAKSI"), 
                         rs.getString("KODE_TRANSAKSI"), 
                         rs.getFloat("KUANTA_TRANSAKSI"), 
                         rs.getInt("ID_USER"), 
                         rs.getTimestamp("DATESTAMP_POSTING"), 
                         rs.getInt("TAHUN_GILING"), 
                         BigInteger.valueOf(rs.getInt("NILAI_TRANSAKSI")), 
                         rs.getString("ID_DOKUMEN")
                 );
                 lsTrn.add(trn);
            }
            return lsTrn;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsTrn;
    }

    @Override
    public List<DetailPostingTransaksi> getDetailPostingTransaksiByIdDokumen(String idDokumen) {
        Connection conn = new DBConnection().getConn();
        String callSQL = "CALL GET_TRANSAKSI_BY_IDDOKUMEN (?)";
        List<DetailPostingTransaksi> lsDpt = new ArrayList<>();
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setString(1, idDokumen);
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
                Transaksi trn = new Transaksi(
                        rs.getInt("ID_TRANSAKSI"), 
                        rs.getString("ID_PETANI"), 
                        rs.getInt("ID_BAHAN"), 
                        rs.getInt("ID_BIAYA"),
                        0,
                        rs.getDate("TGL_TRANSAKSI"), 
                        rs.getString("KODE_TRANSAKSI"), 
                        rs.getFloat("KUANTA_TRANSAKSI"), 
                        rs.getInt("ID_USER"), 
                        rs.getTimestamp("DATESTAMP_POSTING"), 
                        rs.getInt("TAHUN_GILING"), 
                        BigInteger.valueOf(rs.getInt("NILAI_TRANSAKSI")), 
                        rs.getString("ID_DOKUMEN")
                );
                PetaniTebu pt = new PetaniTebu(
                        rs.getString("ID_PETANI"), 
                        rs.getInt("TAHUN_GILING"), 
                        rs.getString("IDKELOMPOK"), 
                        rs.getString("NAMAPETANI"), 
                        rs.getString("MASATANAM"), 
                        rs.getFloat("LUAS"), 
                        rs.getString("JENISTEBU")
                );
                Biaya bya = new Biaya(
                        rs.getInt("ID_BIAYA"), 
                        rs.getString("KODE_BIAYA"),
                        rs.getString("KATEGORI"), 
                        rs.getString("JENIS_BIAYA"), 
                        rs.getString("NAMA_BIAYA"), 
                        rs.getString("SATUAN"), 
                        rs.getInt("TAHUN_GILING"), 
                        rs.getInt("BIAYA")
                );
                DetailPostingTransaksi dpt = new DetailPostingTransaksi(pt, trn, bya);
                lsDpt.add(dpt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsDpt;
    }

    @Override
    public JasperPrint cetakBonDalam(String idKelompok, String idDokumen) {
        Connection conn = new DBConnection().getConn();
        JasperPrint jp = null;
        String fileName = "./reports/BonDalam.jasper";
        Map map = new HashMap();
        map.put("ID_KELOMPOK", idKelompok);
        map.put("ID_DOKUMEN", idDokumen);
        try {
            jp = JasperFillManager.fillReport(fileName, map, conn);
        } catch (JRException ex) {
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jp;
    }

    @Override
    public List<Transaksi> getDataTMAByIdKelompokGrouped(String idKelompok) {
        Connection conn  = new DBConnection().getConn();
        List<Transaksi> lsTrn = new ArrayList<>();
        String callSQL = "CALL GET_TRANSAKSI_TMA_BY_IDKELOMPOK_GROUPED_IDDOKUMEN(?)";
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setString(1, idKelompok);
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
                 Transaksi trn = new Transaksi(
                         rs.getInt("ID_TRANSAKSI"), 
                         rs.getString("ID_PETANI"), 
                         rs.getInt("ID_BAHAN"), 
                         rs.getInt("ID_BIAYA"),
                         0,
                         rs.getDate("TGL_TRANSAKSI"), 
                         rs.getString("KODE_TRANSAKSI"), 
                         rs.getFloat("KUANTA_TRANSAKSI"), 
                         rs.getInt("ID_USER"), 
                         rs.getTimestamp("DATESTAMP_POSTING"), 
                         rs.getInt("TAHUN_GILING"), 
                         BigInteger.valueOf(rs.getInt("NILAI_TRANSAKSI")), 
                         rs.getString("ID_DOKUMEN")
                 );
                 lsTrn.add(trn);
            }
            return lsTrn;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsTrn;
    }

    @Override
    public List<DetailPostingTransaksi> getDetailPostingTransaksiTMAByIdDokumen(String idDokumen) {
        Connection conn = new DBConnection().getConn();
        String callSQL = "CALL GET_TRANSAKSI_TMA_BY_IDDOKUMEN (?)";
        List<DetailPostingTransaksi> lsDpt = new ArrayList<>();
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setString(1, idDokumen);
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
                Transaksi trn = new Transaksi(
                        rs.getInt("ID_TRANSAKSI"), 
                        rs.getString("ID_PETANI"), 
                        rs.getInt("ID_BAHAN"), 
                        rs.getInt("ID_BIAYA"),
                        0,
                        rs.getDate("TGL_TRANSAKSI"), 
                        rs.getString("KODE_TRANSAKSI"), 
                        rs.getFloat("KUANTA_TRANSAKSI"), 
                        rs.getInt("ID_USER"), 
                        rs.getTimestamp("DATESTAMP_POSTING"), 
                        rs.getInt("TAHUN_GILING"), 
                        BigInteger.valueOf(rs.getInt("NILAI_TRANSAKSI")), 
                        rs.getString("ID_DOKUMEN")
                );
                PetaniTebu pt = new PetaniTebu(
                        rs.getString("ID_PETANI"), 
                        rs.getInt("TAHUN_GILING"), 
                        rs.getString("IDKELOMPOK"), 
                        rs.getString("NAMAPETANI"), 
                        rs.getString("MASATANAM"), 
                        rs.getFloat("LUAS"), 
                        rs.getString("JENISTEBU")
                );
                BiayaTMA bTMA = new BiayaTMA(
                        rs.getInt("ID_DESA"), 
                        rs.getInt("TAHUN_GILING"), 
                        rs.getInt("BIAYA_TEBANG"), 
                        rs.getInt("BIAYA_ANGKUT")
                );
                DetailPostingTransaksi dpt = new DetailPostingTransaksi(pt, trn, bTMA);
                lsDpt.add(dpt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsDpt;
    }
    
}
