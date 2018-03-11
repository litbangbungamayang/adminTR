/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DbConnectionManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class SistemDAOSQL implements SistemDAO{

    @Override
    public int getTahunGiling() {
        int tahunGiling = 0;
        if (DbConnectionManager.isConnect() == true){
            try {
                String callSQL = "exec GET_TAHUN_GILING";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSQL,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                boolean result = cst.execute();
                ResultSet rs = null;
                int rowsAff = 0;
                while (result || rowsAff != -1){
                    if (result){
                        rs = cst.getResultSet();
                        break;
                    } else {
                        rowsAff = cst.getUpdateCount();
                    }
                    result = cst.getMoreResults();
                }
                while (rs.next()){
                    tahunGiling = rs.getInt("TAHUN_GILING");
                }
            } catch (Exception ex) {
                Logger.getLogger(SistemDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tahunGiling;
    }
    
}
