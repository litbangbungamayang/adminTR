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
import javax.swing.JOptionPane;

/**
 *
 * @author Bayu Anandavi Muhardika
 */

public class DbConnectionManager {
    
    public static Connection conn = null;
    
    public DbConnectionManager(){
        getConnection();
    }
    
    public static Connection getConnection_mssql() throws Exception {
        if (conn == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//NOT NEEDED as in the JDBC API 4.0, the DriverManager.getConnection method is enhanced to load JDBC drivers automatically. (https://docs.microsoft.com/en-us/sql/connect/jdbc/using-the-jdbc-driver)
                
                String slive = "jdbc:jtds:sqlserver://192.168.39.100:1433;"+
                                   "databaseName=SugarCaneDb;user=prod;password=prod;";
                
                String slokal = "jdbc:sqlserver://LOCALHOST\\X230_SRV:1433;"+
                                   "databaseName=SIM_TR;user=prod;password=prod;";

                conn = DriverManager.getConnection(slokal);
                
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return conn;
    }
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sLokal = "jdbc:mysql://localhost:3306/sim_tr?user=root&password=";
            conn = DriverManager.getConnection(sLokal);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static boolean isConnect(){
        if (getConnection() == null){
            return false;
        }
        return true;
    }
    
    public static void closeConnection(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
