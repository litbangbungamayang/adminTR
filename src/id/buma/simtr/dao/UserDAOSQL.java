/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.controller.LoginEncryption;
import id.buma.simtr.database.DbConnectionManager;
import id.buma.simtr.model.User;
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

public class UserDAOSQL implements UserDAO{
    
    private final LoginEncryption le = new LoginEncryption();

    @Override
    public List<User> getAllUser() {
        List<User> lstUser = new ArrayList<>();
        if (DbConnectionManager.isConnect() == true){
            try {
                String callSQL = "exec GET_ALL_USER";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSQL,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                lstUser = commonGetDataUser(cst);
            } catch (Exception ex) {
                Logger.getLogger(UserDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lstUser;
    }

    @Override
    public User getUserData(String username, String password) {
        User userResult = null;
        if (DbConnectionManager.isConnect() == true){
            try {
                /*
                1. username (Varchar)
                2. password (varchar)
                */
                String callSql = "exec GET_USER_BY_LOGIN ?,?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                cst.setString(1, username);
                cst.setString(2, password);
                List<User> lstUser = commonGetDataUser(cst);
                if(lstUser.size() == 1){
                    userResult = lstUser.get(0);
                }
            } catch (Exception ex) {
                Logger.getLogger(UserDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return userResult;
    }

    @Override
    public void addNewUser(User user) {
        if (DbConnectionManager.isConnect() == true){
            try {
                /*
                1. nama lengkap (varchar)
                2. username (varchar)
                3. password (varchar)
                4. privlevel (integer)
                5. idafd (varchar)
                */
                String callSql = "exec INSERT_NEW_USER ?,?,?,?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSql);
                cst.setString(1, user.getNamaLengkap());
                cst.setString(2, le.hashingText(user.getUsername()));
                cst.setString(3, le.hashingText(user.getPassword()));
                cst.setInt(4, user.getPrivLevel());
                cst.execute();
            } catch (Exception ex) {
                Logger.getLogger(UserDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    private List<User> commonGetDataUser(CallableStatement cst){
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
    
    
}
