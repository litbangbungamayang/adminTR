/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DBConnection;
import id.buma.simtr.model.Afdeling;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class AfdelingDAOSQL implements AfdelingDAO{

    @Override
    public boolean insertAfdeling(Afdeling afd) {
        Connection conn = new DBConnection().getConn();
        try {
            String callSQL = "CALL GET_AFDELING_BY_IDAFD(?,?,?,?,?)";
            try (CallableStatement cst = conn.prepareCall(callSQL)) {
                cst.setString(1, afd.getIdAfd());
                cst.setString(2, afd.getIdRayon());
                cst.setString(3, afd.getAfdeling());
                cst.setInt(4, afd.getBatasRit());
                cst.setString(5, afd.getNamaAsisten());
                cst.execute();
                if (cst.getUpdateCount() == 1){
                    return true;
                }
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error on insertAfdeling! \nError code : " + 
                    ex.toString(), "", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AfdelingDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Afdeling> getAfdelingByIdAfd(String idAfd) {
        List<Afdeling> listAfd = new ArrayList<>();
        Connection conn = new DBConnection().getConn();
        try {
            String callSQL = "CALL GET_AFDELING_BY_IDAFD(?)";
            try (CallableStatement cst = conn.prepareCall(callSQL)) {
                cst.setString(1, idAfd);
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
                    result = cst.getMoreResults();
                }
                while (rs.next()){
                    Afdeling afd = new Afdeling(
                            rs.getString("IDAFD"),
                            rs.getString("AFDELING"),
                            rs.getInt("BATASRIT"),
                            rs.getString("NAMAASISTEN"),
                            rs.getString("IDRAYON")
                    );
                    listAfd.add(afd);
                }
                cst.close();
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error getAfdByIdAfd! \nError code : " + 
                    ex.toString(), "", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AfdelingDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAfd;
    }
    
}
