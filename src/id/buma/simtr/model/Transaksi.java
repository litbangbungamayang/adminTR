/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.model;

import java.math.BigInteger;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class Transaksi {
    
    private int idTransaksi;
    private String idPetani;
    private int idBahan;
    private int idBiaya;
    private java.sql.Date tglTransaksi;
    private String kodeTransaksi; //D - Debit, K - Kredit
    private float kuantaTransaksi;
    private int idUser;
    private java.sql.Timestamp tglPosting;
    private int tahunGiling;
    private BigInteger nilaiTransaksi;
    private String nomorBuktiTransaksi;
    
    public Transaksi(int idTransaksi, String idPetani, int idBahan, int idBiaya, 
            java.sql.Date tglTransaksi, String kodeTransaksi, float kuantaTransaksi, 
            int idUser, java.sql.Timestamp tglPosting, int tahunGiling, BigInteger nilaiTransaksi,
            String nomorBuktiTransaksi){
        this.idTransaksi = idTransaksi;
        this.idPetani = idPetani;
        this.idBahan = idBahan;
        this.idBiaya = idBiaya;
        this.tglTransaksi = tglTransaksi;
        this.kuantaTransaksi = kuantaTransaksi;
        this.idUser = idUser;
        this.tglPosting = tglPosting;
        this.tahunGiling = tahunGiling;
        this.nilaiTransaksi = nilaiTransaksi;
        this.kodeTransaksi = kodeTransaksi;
        this.nilaiTransaksi = nilaiTransaksi;
        this.nomorBuktiTransaksi = nomorBuktiTransaksi;
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

    public int getTahunGiling() {
        return tahunGiling;
    }

    public void setTahunGiling(int tahunGiling) {
        this.tahunGiling = tahunGiling;
    }

    public void setNilaiTransaksi(BigInteger nilaiTransaksi) {
        this.nilaiTransaksi = nilaiTransaksi;
    }

    public BigInteger getNilaiTransaksi() {
        return nilaiTransaksi;
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public String getNomorBuktiTransaksi() {
        return nomorBuktiTransaksi;
    }

    public void setNomorBuktiTransaksi(String nomorBuktiTransaksi) {
        this.nomorBuktiTransaksi = nomorBuktiTransaksi;
    }

    public int getIdBiaya() {
        return idBiaya;
    }

    public void setIdBiaya(int idBiaya) {
        this.idBiaya = idBiaya;
    }
    
}
