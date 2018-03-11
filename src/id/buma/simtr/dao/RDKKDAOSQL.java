/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DbConnectionManager;
import id.buma.simtr.model.RDKK;
import java.sql.CallableStatement;
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
    
}
