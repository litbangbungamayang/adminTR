/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DBConnection;
import id.buma.simtr.model.Biaya;
import id.buma.simtr.model.BiayaTMA;
import id.buma.simtr.model.PekerjaanKebun;
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

public class PekerjaanKebunDAOSQL implements PekerjaanKebunDAO {

    @Override
    public PekerjaanKebun getPekerjaanKebunByIdPekerjaan(int idPekerjaan, int tahunGiling) {
        Connection conn = new DBConnection().getConn();
        PekerjaanKebun pk = null;
        /*
            1 = id biaya
            2 = tahun giling
        */
        String callSQL = "CALL GET_ALL_BIAYA_BY_IDBIAYA (?,?)";
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setInt(1, idPekerjaan);
            cst.setInt(2, tahunGiling);
            List<PekerjaanKebun> lsPk = commonGetDataPekerjaanKebun(cst);
            if (lsPk.size() == 1) return lsPk.get(0);
        } catch (SQLException ex) { 
            Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pk;
    }

    @Override
    public List<PekerjaanKebun> getAllPekerjaanKebunByKategori(int tahunGiling, String kategori) {
        Connection conn = new DBConnection().getConn();
        List<PekerjaanKebun> lsPk = null;
        /*
            1 = tahun giling
            2 = kategori (varchar)
        */
        String callSQL = "CALL GET_ALL_BIAYA_BY_KATEGORI (?,?)";
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setInt(1, tahunGiling);
            cst.setString(2, kategori);
            return commonGetDataPekerjaanKebun(cst);
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsPk;
    }
    
    public List<PekerjaanKebun> commonGetDataPekerjaanKebun(CallableStatement cst){
        List<PekerjaanKebun> lsPk = new ArrayList<>();
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
                PekerjaanKebun pk = new PekerjaanKebun(
                        rs.getInt("ID_BIAYA"), 
                        rs.getString("KATEGORI"), 
                        rs.getString("NAMA_BIAYA"), 
                        rs.getString("SATUAN"), 
                        rs.getInt("TAHUN_GILING"), 
                        rs.getInt("BIAYA")
                );
                lsPk.add(pk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsPk;
    }
    
    public List<Biaya> commonGetBiaya(CallableStatement cst){
        List<Biaya> lsBya = new ArrayList<>();
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
                Biaya bya = new Biaya(
                        rs.getInt("ID_BIAYA"),
                        rs.getString("KODE_BIAYA"),
                        rs.getString("KATEGORI"),
                        rs.getString("JENIS_BIAYA"),
                        rs.getString("NAMA_BIAYA"), 
                        rs.getString("SATUAN"), 
                        rs.getInt("TAHUN_GILING"), 
                        rs.getInt("RUPIAH_BIAYA")
                );
                lsBya.add(bya);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsBya;
    }

    @Override
    public List<PekerjaanKebun> getAllPekerjaanKebun() {
        Connection conn = new DBConnection().getConn();
        String callSQL = "CALL GET_ALL_BIAYA";
        List<PekerjaanKebun> lsPk = new ArrayList<>();
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            return commonGetDataPekerjaanKebun(cst);
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsPk;
    }

    @Override
    public List<Biaya> getAllBiaya() {
        Connection conn = new DBConnection().getConn();
        List<Biaya> lsBya = new ArrayList<>();
        String callSQL = "CALL GET_ALL_BIAYA";
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            return commonGetBiaya(cst);
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsBya;
    }

    @Override
    public boolean cekDuplikatBiaya(String kodeBiaya, int tahunGiling) {
        Connection conn = new DBConnection().getConn();
        String callSQL = "CALL CEK_DUPLIKAT_BIAYA(?,?)";
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setString(1, kodeBiaya);
            cst.setInt(2, tahunGiling);
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
                if (rs.getInt("DUPLIKAT") == 0) return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean cekPenggunaanBiaya(int idBiaya) {
        Connection conn = new DBConnection().getConn();
        String callSQL = "CALL CEK_PENGGUNAAN_BIAYA(?)";
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setInt(1, idBiaya);
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
                if (rs.getInt("PENGGUNAAN") == 0) return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean insertNewBiaya(Biaya newBiaya) {
        Connection conn = new DBConnection().getConn();
        /*
            pKODE_BIAYA VARCHAR(45),
            pKATEGORI VARCHAR(5),
            pJENIS_BIAYA VARCHAR(45),
            pNAMA_BIAYA VARCHAR(100),
            pSATUAN VARCHAR(45),
            TAHUN_GILING INT,
            BIAYA INT
        */
        try{
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String callSQl = "CALL INSERT_NEW_BIAYA(?,?,?,?,?,?,?)";
        try(CallableStatement cst = conn.prepareCall(callSQl)){
            cst.setString(1, newBiaya.getKodeBiaya());
            cst.setString(2, newBiaya.getKategori());
            cst.setString(3, newBiaya.getJenisBiaya());
            cst.setString(4, newBiaya.getNamaBiaya());
            cst.setString(5, newBiaya.getSatuan());
            cst.setInt(6, newBiaya.getTahunGiling());
            cst.setInt(7, newBiaya.getRupiahBiaya());
            cst.execute();
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    @Override
    public boolean updateBiaya(Biaya biaya) {
        Connection conn = new DBConnection().getConn();
        String callSQL = "CALL UPDATE_BIAYA_BY_IDBIAYA(?,?,?,?,?,?,?,?)";
        /*
            pID_BIAYA INT,
            pKODE_BIAYA VARCHAR(45),
            pKATEGORI VARCHAR(5),
            pJENIS_BIAYA VARCHAR(45),
            pNAMA_BIAYA VARCHAR(100),
            pSATUAN VARCHAR(45),
            pTAHUN_GILING INT,
            pBIAYA INT
        */
        try{
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setInt(1, biaya.getIdBiaya());
            cst.setString(2, biaya.getKodeBiaya());
            cst.setString(3, biaya.getKategori());
            cst.setString(4, biaya.getJenisBiaya());
            cst.setString(5, biaya.getNamaBiaya());
            cst.setString(6, biaya.getSatuan());
            cst.setInt(7, biaya.getTahunGiling());
            cst.setInt(8, biaya.getRupiahBiaya());
            cst.execute();
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    @Override
    public Biaya getBiayaTMAByTahunGiling(int tahunGiling) {
       Connection conn = new DBConnection().getConn();
        Biaya bya = null;
        String callSQL = "CALL GET_BIAYA_TMA_BY_TAHUN_GILING(?)";
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setInt(1, tahunGiling);
            List<Biaya> lsBya = new ArrayList<>();
            lsBya =  commonGetBiaya(cst);
            if (lsBya.size() == 1) return lsBya.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bya; 
    }

    @Override
    public BiayaTMA getBiayaTMAByIdKelompokTahunGiling(String idKelompk, int tahunGiling) {
        Connection conn = new DBConnection().getConn();
        BiayaTMA bya = null;
        String callSQL = "CALL GET_BIAYA_TMA_BY_IDKELOMPOK_TAHUN_GILING(?, ?)"; //per desa
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setString(1, idKelompk);
            cst.setInt(2, tahunGiling);
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
                bya = new BiayaTMA(
                        rs.getInt("ID_DESA"), 
                        rs.getInt("TAHUN_GILING"), 
                        rs.getInt("BIAYA_TEBANG"), 
                        rs.getInt("BIAYA_ANGKUT")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(PekerjaanKebunDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bya; 
    }
    
}
