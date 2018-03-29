/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DBConnection;
import id.buma.simtr.database.DbConnectionManager;
import id.buma.simtr.model.Koordinat;
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

public class KoordinatDAOSQL implements KoordinatDAO{

    @Override
    public Koordinat getKoordinatByIdPetani(String idPetani) {
        Connection conn = new DBConnection().getConn();
        Koordinat koorRest = null;
        try {
            String callSql = "CALL GET_KOORDINAT_BY_IDPETANI(?)";
            try (CallableStatement cst = conn.prepareCall(callSql)) {
                cst.setString(1, idPetani);
                List<Koordinat> lstKoord = commonGetKoordinat(cst);
                if (lstKoord.size() == 1){
                    koorRest =  lstKoord.get(0);
                }
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(KoordinatDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return koorRest;
    }

    @Override
    public boolean insertNewKoordinat(Koordinat koordinat) {
        Connection conn = new DBConnection().getConn();
        try {
            /*
            1 : idPetani varchar
            2 : easting float
            3 : northing float
            4 : gridzone varchar
            */
            String callSql = "CALL INSERT_NEW_KOORDINAT(?,?,?,?)";
            try (CallableStatement cst = conn.prepareCall(callSql)) {
                cst.setString(1, koordinat.getIdPetani());
                cst.setFloat(2, koordinat.getEasting());
                cst.setFloat(3, koordinat.getNorthing());
                cst.setString(4, koordinat.getGridZone());
                cst.execute();
                if (cst.getUpdateCount() == 1) return true;
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(KoordinatDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<Koordinat> commonGetKoordinat(CallableStatement cst){
        List<Koordinat> lstKoord = new ArrayList<>();
        try {
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
                Koordinat koord = new Koordinat(
                        rs.getString("ID_PETANI"), 
                        rs.getFloat("EASTING"), 
                        rs.getFloat("NORTHING"), 
                        rs.getString("GRIDZONE")
                );
                lstKoord.add(koord);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KoordinatDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstKoord;
    }
    
    
}
