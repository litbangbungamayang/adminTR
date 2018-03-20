/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.model;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class User {
    
    private int userId;
    private String password;
    private String username;
    private int privLevel;
    private String namaLengkap;
    private String idAfd;
    
    public User(int userId, String password, String username, int privLevel, 
            String namaLengkap, String idAfd){
        this.password = password;
        this.privLevel = privLevel;
        this.userId = userId;
        this.username = username;
        this.namaLengkap = namaLengkap;
        this.idAfd = idAfd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPrivLevel() {
        return privLevel;
    }

    public void setPrivLevel(int privLevel) {
        this.privLevel = privLevel;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getIdAfd() {
        return idAfd;
    }

    public void setIdAfd(String idAfd) {
        this.idAfd = idAfd;
    }
    
    
    
}
