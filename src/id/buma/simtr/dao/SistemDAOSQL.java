/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DBConnection;
import id.buma.simtr.database.DbConnectionManager;
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

public class SistemDAOSQL implements SistemDAO{

    @Override
    public int getTahunGiling() {
        Connection conn = new DBConnection().getConn();
        int tahunGiling = 0;
            try {
                String callSQL = "CALL GET_TAHUN_GILING";
                try (CallableStatement cst = conn.prepareCall(callSQL,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
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
                } finally {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SistemDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        return tahunGiling;
    }
    
}
