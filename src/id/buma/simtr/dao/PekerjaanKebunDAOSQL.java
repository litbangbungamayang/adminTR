/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DBConnection;
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
    
}
