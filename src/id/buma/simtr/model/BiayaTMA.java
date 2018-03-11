/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.model;

/**
 *
 * @author Bayu Anandavi Muhardika
 */

public class BiayaTMA {
    private int idPosting;
    private java.sql.Date tglPosting;
    private String idKelompok;
    private String numerator;
    
    public BiayaTMA(int idPosting, java.sql.Date tglPosting, String idKelompok, 
            String numerator){
        this.idKelompok = idKelompok;
        this.idPosting = idPosting;
        this.numerator = numerator;
        this.tglPosting = tglPosting;
    }

    public int getIdPosting() {
        return idPosting;
    }

    public void setIdPosting(int idPosting) {
        this.idPosting = idPosting;
    }

    public java.sql.Date getTglPosting() {
        return tglPosting;
    }

    public void setTglPosting(java.sql.Date tglPosting) {
        this.tglPosting = tglPosting;
    }

    public String getIdKelompok() {
        return idKelompok;
    }

    public void setIdKelompok(String idKelompok) {
        this.idKelompok = idKelompok;
    }

    public String getNumerator() {
        return numerator;
    }

    public void setNumerator(String numerator) {
        this.numerator = numerator;
    }
    
}
