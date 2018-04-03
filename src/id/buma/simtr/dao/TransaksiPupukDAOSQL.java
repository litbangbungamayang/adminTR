/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DBConnection;
import id.buma.simtr.model.TransaksiPupuk;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            String strSql = "CALL INSERT_TRANSAKSI_PERMINTAAN_PUPUK(?,?,?,?,?,?,?,?)";
            try ( /*
            1 - idpetani (varchar)
            2 - idbahan (int)
            3 - tgl_transaksi (date)
            4 - kuanta (float)
            5 - iduser (int)
            6 - timestamp (datetime)
             */ CallableStatement cst = conn.prepareCall(strSql)) {
                cst.setString(1, tp.getIdPetani());
                cst.setInt(2, tp.getIdBahan());
                cst.setDate(3, tp.getTglTransaksi());
                cst.setFloat(4, tp.getKuantaTransaksi());
                cst.setInt(5, tp.getIdUser());
                cst.setTimestamp(6, tp.getTglPosting());
                cst.setString(7, "D");
                cst.setInt(8, tp.getTahunGiling());
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
    
}
