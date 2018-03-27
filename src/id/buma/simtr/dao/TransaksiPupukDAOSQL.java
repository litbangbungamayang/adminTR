/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DbConnectionManager;
import id.buma.simtr.model.TransaksiPupuk;
import java.sql.CallableStatement;
import java.sql.ResultSet;
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
        if (DbConnectionManager.isConnect()){
            try {
                String strSql = "exec INSERT_TRANSAKSI_PERMINTAAN_PUPUK ?,?,?,?,?,?";
                /*
                1 - idpetani (varchar)
                2 - idbahan (int)
                3 - tgl_transaksi (date)
                4 - kuanta (float)
                5 - iduser (int)
                6 - timestamp (datetime)
                */
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(strSql);
                cst.setString(1, tp.getIdPetani());
                cst.setInt(2, tp.getIdBahan());
                cst.setDate(3, tp.getTglTransaksi());
                cst.setFloat(4, tp.getKuantaTransaksi());
                cst.setInt(5, tp.getIdUser());
                cst.setTimestamp(6, tp.getTglPosting());
                cst.execute();
                if (cst.getUpdateCount() == 1) return true;
            } catch (Exception ex) {
                Logger.getLogger(TransaksiPupukDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean cekDuplicateTransaksiPupuk(String idPetani, int idBahan) {
        if (DbConnectionManager.isConnect()){
            try {
                String strSql = "exec GET_TRANSAKSI_PUPUK_BY_IDPETANI_IDBAHAN ?,?";
                /*
                1 = idpetani (Varchar)
                2 = idbahan int
                */
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(strSql);
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
            } catch (Exception ex) {
                Logger.getLogger(TransaksiPupukDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
}
