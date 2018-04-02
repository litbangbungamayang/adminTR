/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.controller.LoginEncryption;
import id.buma.simtr.database.DBConnection;
import id.buma.simtr.model.User;
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

public class UserDAOSQL implements UserDAO{
    
    private final LoginEncryption le = new LoginEncryption();

    @Override
    public List<User> getAllUser() {
        Connection conn = new DBConnection().getConn();
        List<User> lstUser = new ArrayList<>();
        try {
            String callSQL = "CALL GET_ALL_USER";
            try (CallableStatement cst = conn.prepareCall(callSQL,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                lstUser = commonGetDataUser(cst);
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstUser;
    }

    @Override
    public User getUserData(String username, String password) {
        Connection conn = new DBConnection().getConn();
        User userResult = null;
        try {
            /*
            1. username (Varchar)
            2. password (varchar)
            */
            //String callSql = "exec GET_USER_BY_LOGIN ?,?";
            String callSql = "CALL GET_USER_BY_LOGIN(?,?)";
            try (CallableStatement cst = conn.prepareCall(callSql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                cst.setString(1, username);
                cst.setString(2, password);
                List<User> lstUser = commonGetDataUser(cst);
                if(lstUser.size() == 1){
                    userResult = lstUser.get(0);
                }
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userResult;
    }

    @Override
    public boolean addNewUser(User user) {
        Connection conn = new DBConnection().getConn();
        try {
            /*
            1. nama lengkap (varchar)
            2. username (varchar)
            3. password (varchar)
            4. privlevel (integer)
            5. idafd (varchar)
            */
            String callSql = "CALL INSERT_NEW_USER(?,?,?,?,?)";
            try (CallableStatement cst = conn.prepareCall(callSql)) {
                cst.setString(1, user.getNamaLengkap());
                cst.setString(2, le.hashingText(user.getUsername()));
                cst.setString(3, le.hashingText(user.getPassword()));
                cst.setInt(4, user.getPrivLevel());
                cst.setString(5, user.getIdAfd());
                cst.execute();
                if (cst.getUpdateCount() == 1) return true;
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private List<User> commonGetDataUser(CallableStatement cst) throws SQLException{
      List<User> lstUser = new ArrayList<>();
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
                User user = new User(
                        rs.getInt("USR_USERID"), 
                        rs.getString("USR_PASSWORD"), 
                        rs.getString("USR_USERNAME"), 
                        rs.getInt("USR_PRIVLEVEL"), 
                        rs.getString("USR_NAMALENGKAP"),
                        rs.getString("USR_IDAFD")
                );
                lstUser.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstUser;
    }

    @Override
    public boolean updateUserData(User user) {
        Connection conn = new DBConnection().getConn();
        String callSQL = "CALL UPDATE_USER(?,?,?,?,?,?)";
        try {
            /*
            1 - userid - int
            2 - namaLengkap - varchar 50
            3 - username - varchar 255
            4 - password - varchar 255
            5 - privLevel - int
            6 - idAfd - varchar 2
            */
            CallableStatement cst = conn.prepareCall(callSQL);
            cst.setInt(1, user.getUserId());
            cst.setString(2, user.getNamaLengkap());
            cst.setString(3, le.hashingText(user.getUsername()));
            cst.setString(4, le.hashingText(user.getPassword()));
            cst.setInt(5, user.getPrivLevel());
            cst.setString(6, user.getIdAfd());
            cst.execute();
            if (cst.getUpdateCount() == 1 ) return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean deleteUserData(User user) {
        Connection conn = new DBConnection().getConn();
        String callSQL = "CALL DELETE_USER(?)";
        try {
            CallableStatement cst = conn.prepareCall(callSQL);
            cst.setInt(1, user.getUserId());
            cst.execute();
            if (cst.getUpdateCount() == 1) return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    
}
