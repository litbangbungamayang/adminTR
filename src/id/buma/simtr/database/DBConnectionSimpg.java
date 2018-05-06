/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class DBConnectionSimpg {
    
    private Connection conn;
    
    public Connection getConn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sLokal = "jdbc:mysql://localhost:3306/simpg?user=root&password=";
            conn = DriverManager.getConnection(sLokal);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnectionSimpg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
}
