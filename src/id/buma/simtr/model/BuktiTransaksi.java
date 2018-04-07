/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.model;

import java.sql.Timestamp;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class BuktiTransaksi {
    
    private String noBukti;
    private int userId;
    private Timestamp postingTime;
    
    public BuktiTransaksi(String noBukti, int userId, Timestamp postingTime){
        this.noBukti = noBukti;
        this.userId = userId;
        this.postingTime = postingTime;
    }

    public String getNoBukti() {
        return noBukti;
    }

    public void setNoBukti(String noBukti) {
        this.noBukti = noBukti;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getPostingTime() {
        return postingTime;
    }

    public void setPostingTime(Timestamp postingTime) {
        this.postingTime = postingTime;
    }
    
}
