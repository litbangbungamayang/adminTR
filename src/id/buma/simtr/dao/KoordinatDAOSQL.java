/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DbConnectionManager;
import id.buma.simtr.model.Koordinat;
import java.sql.CallableStatement;
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
        Koordinat koorRest = null;
        if(DbConnectionManager.isConnect() == true){
            try {
                String callSql = "exec GET_KOORDINAT_BY_IDPETANI ?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSql);
                cst.setString(1, idPetani);
                List<Koordinat> lstKoord = commonGetKoordinat(cst);
                if (lstKoord.size() == 1){
                    koorRest =  lstKoord.get(0);
                }
            } catch (Exception ex) {
                Logger.getLogger(KoordinatDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return koorRest;
    }

    @Override
    public boolean insertNewKoordinat(Koordinat koordinat) {
        if (DbConnectionManager.isConnect()){
            try {
                /*
                1 : idPetani varchar
                2 : easting float
                3 : northing float
                4 : gridzone varchar
                */
                String callSql = "exec INSERT_NEW_KOORDINAT ?,?,?,?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSql);
                cst.setString(1, koordinat.getIdPetani());
                cst.setFloat(2, koordinat.getEasting());
                cst.setFloat(3, koordinat.getNorthing());
                cst.setString(4, koordinat.getGridZone());
                cst.execute();
                if (cst.getUpdateCount() == 1) return true;
            } catch (Exception ex) {
                Logger.getLogger(KoordinatDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return false;
    }
    
    public List<Koordinat> commonGetKoordinat(CallableStatement cst){
        List<Koordinat> lstKoord = new ArrayList<>();
        if (DbConnectionManager.isConnect() == true){
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
                if (lstKoord.isEmpty()){
                    Koordinat koord = new Koordinat(
                            "", 
                            0.00f, 
                            0.00f, 
                            "Data Tidak Tersedia"
                    );
                    lstKoord.add(koord);
                }
            } catch (SQLException ex) {
                Logger.getLogger(KoordinatDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lstKoord;
    }
    
    
}
