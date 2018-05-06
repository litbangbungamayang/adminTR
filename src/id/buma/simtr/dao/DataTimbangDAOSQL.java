/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DBConnection;
import id.buma.simtr.model.DataTimbang;
import id.buma.simtr.model.PetaniTebu;
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

public class DataTimbangDAOSQL implements DataTimbangDAO{

    @Override
    public List<DataTimbang> getDataTimbangByIdKelompok(String idKelompok) {
        Connection conn = new DBConnection().getConn();
        List<DataTimbang> lsDt = new ArrayList<>();
        String callSQL = "CALL GET_DATA_TIMBANG_BY_IDKELOMPOK(?)";
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setString(1, idKelompok);
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
                /*
                TIMB.ID_TIMBANGAN AS ID_TIMBANGAN,
		KD.IDPETANI AS ID_PETANI,
		TIMB.BRUTO AS BRUTO,
		TIMB.TARA AS TARA,
		TIMB.NETTO AS NETTO,
		TIMB.TGL_NETTO AS TGL_NETTO
                */
                DataTimbang dt = new DataTimbang(
                        rs.getInt("ID_TIMBANGAn"), 
                        getPetaniTebuByIdPetani(rs.getString("ID_PETANI")), 
                        rs.getInt("BRUTO"), 
                        rs.getInt("TARA"), 
                        rs.getInt("NETTO"), 
                        rs.getTimestamp("TGL_NETTO")
                );
                lsDt.add(dt);
            }
            return lsDt;
        } catch (SQLException ex) {
            Logger.getLogger(DataTimbangDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsDt;
    }

    @Override
    public PetaniTebu getPetaniTebuByIdPetani(String idPetani) {
        Connection conn = new DBConnection().getConn();
        PetaniTebu pt = null;
        String callSQL = "CALL GET_KELOMPOKTANID_BY_IDPETANI(?)";
        try(CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setString(1, idPetani);
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
                /*
                KD.IDPETANI AS ID_PETANI,
                KD.TAHUN AS TAHUN,
                KD.IDKELOMPOK AS ID_KELOMPOK,
                KD.NAMAPETANI AS NAMA_PETANI,
                KD.MASATANAM AS MASA_TANAM,
                KD.LUAS AS LUAS,
                KD.JENISTEBU AS JENISTEBU
                */
                pt = new PetaniTebu(
                        rs.getString("ID_PETANI"), 
                        rs.getInt("TAHUN"), 
                        rs.getString("ID_KELOMPOK"), 
                        rs.getString("NAMA_PETANI"), 
                        rs.getString("MASA_TANAM"), 
                        rs.getFloat("LUAS"), 
                        rs.getString("JENISTEBU")
                );
                return pt;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataTimbangDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pt;
    }
    
}
