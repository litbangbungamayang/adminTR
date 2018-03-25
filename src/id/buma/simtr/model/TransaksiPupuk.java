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

public class TransaksiPupuk {
    
    private int idTransaksi;
    private String idPetani;
    private int idBahan;
    private java.sql.Date tglTransaksi;
    private float kuantaTransaksi;
    private int idUser;
    private java.sql.Timestamp tglPosting;
    
    public TransaksiPupuk(int idTransaksi, String idPetani, int idBahan, 
            java.sql.Date tglTransaksi, float kuantaTransaksi, 
            int idUser, java.sql.Timestamp tglPosting){
        this.idTransaksi = idTransaksi;
        this.idPetani = idPetani;
        this.idBahan = idBahan;
        this.tglTransaksi = tglTransaksi;
        this.kuantaTransaksi = kuantaTransaksi;
        this.idUser = idUser;
        this.tglPosting = tglPosting;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getIdPetani() {
        return idPetani;
    }

    public void setIdPetani(String idPetani) {
        this.idPetani = idPetani;
    }

    public java.sql.Date getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(java.sql.Date tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public float getKuantaTransaksi() {
        return kuantaTransaksi;
    }

    public void setKuantaTransaksi(float kuantaTransaksi) {
        this.kuantaTransaksi = kuantaTransaksi;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public java.sql.Timestamp getTglPosting() {
        return tglPosting;
    }

    public void setTglPosting(java.sql.Timestamp tglPosting) {
        this.tglPosting = tglPosting;
    }

    public int getIdBahan() {
        return idBahan;
    }

    public void setIdBahan(int idBahan) {
        this.idBahan = idBahan;
    }
    
}
