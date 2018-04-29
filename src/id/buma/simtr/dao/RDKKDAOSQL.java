/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DBConnection;
import id.buma.simtr.database.DbConnectionManager;
import id.buma.simtr.model.BuktiTransaksi;
import id.buma.simtr.model.KelompokTani;
import id.buma.simtr.model.Koordinat;
import id.buma.simtr.model.PetaniTebu;
import id.buma.simtr.model.RDKK;
import id.buma.simtr.model.Transaksi;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class RDKKDAOSQL implements RDKKDAO {

    @Override
    public boolean insertInputData(RDKK rdkk) {
        if (DbConnectionManager.isConnect()){
            try {
                String callSQL = "exec INSERT_NEW_RDKK ?,?,?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSQL);
                cst.setString(1, rdkk.getNoRdkk());
                cst.setDate(2, rdkk.getTglRdkk());
                cst.setString(3, rdkk.getIdPetani());
                boolean result = cst.execute();
                if (cst.getUpdateCount() == 1){
                    return true;
                }
            } catch (Exception ex) {
                Logger.getLogger(RDKKDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean insertBatchKelompokTaniBaru(KelompokTani kt, List<PetaniTebu> lsPt, 
            List<Koordinat> lsKr, List<Transaksi> lsTb, BuktiTransaksi bt) {
        Connection conn = new DBConnection().getConn();
        /******
                1 = iD Kelompok
                2 = Nama Kelompok
                3 = No Kontrak
                4 = Kategori
                5 = ID Afd
                6 = Tahun
                7 = ID Desa
                8 = No KTP
                9 = No RDKK
                10 = Tanggal RDKK
            ******/
        try {
            TransaksiDAOSQL transDao = new TransaksiDAOSQL();
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            String callSQL = "CALL INSERT_KELOMPOKTANIH(?,?,?,?,?,?,?,?,?,?)";
            CallableStatement cst = conn.prepareCall(callSQL);
            cst.setString(1, kt.getIdKelompok());
            cst.setString(2, kt.getNamaKelompok());
            cst.setString(3, kt.getNoKontrak());
            cst.setString(4, kt.getKategori());
            cst.setString(5, kt.getIdAfd());
            cst.setInt(6, kt.getTahun());
            cst.setInt(7, kt.getIdDesa());
            cst.setString(8, kt.getNoKtp());
            cst.setString(9, kt.getNoRdkk());
            cst.setDate(10, kt.getTglRdkk());
            cst.addBatch();
            cst.executeBatch();
            callSQL = "CALL INSERT_KELOMPOKTANID(?,?,?,?,?,?,?)";
            cst = conn.prepareCall(callSQL);
            for (PetaniTebu pt : lsPt){
                cst.setString(1, pt.getIdPetani());
                cst.setInt(2, pt.getTahun());
                cst.setString(3, pt.getIdKelompok());
                cst.setString(4, pt.getNamaPetani());
                cst.setString(5, pt.getMasaTanam());
                cst.setFloat(6, pt.getLuas());
                cst.setString(7, pt.getJenisTebu());
                cst.addBatch();
            }
            cst.executeBatch();
            /*
                1 : idPetani varchar
                2 : easting float
                3 : northing float
                4 : gridzone varchar
            */
            callSQL = "CALL INSERT_NEW_KOORDINAT(?,?,?,?)";
            cst = conn.prepareCall(callSQL);
            for (Koordinat kr : lsKr){
                cst.setString(1, kr.getIdPetani());
                cst.setFloat(2, kr.getEasting());
                cst.setFloat(3, kr.getNorthing());
                cst.setString(4, kr.getGridZone());
                cst.addBatch();
            }
            cst.executeBatch();
            conn.commit();
            if (transDao.insertBatchTransaksi(lsTb, bt)){
                conn.setAutoCommit(true);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RDKKDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(RDKKDAOSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }
    
}
