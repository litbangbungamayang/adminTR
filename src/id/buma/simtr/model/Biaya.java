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

public class Biaya {
    private int idBiaya;
    private String kodeBiaya;
    private String kategori;
    private String jenisBiaya;
    private String namaBiaya;
    private String satuan;
    private int tahunGiling;
    private int rupiahBiaya;
    
    public Biaya(int idBiaya, String kodeBiaya, String kategori, String jenisBiaya, String namaBiaya,
            String satuan, int tahunGiling, int rupiahBiaya){
        this.idBiaya = idBiaya;
        this.kodeBiaya = kodeBiaya;
        this.kategori = kategori;
        this.jenisBiaya = jenisBiaya;
        this.namaBiaya = namaBiaya;
        this.satuan = satuan;
        this.tahunGiling = tahunGiling;
        this.rupiahBiaya = rupiahBiaya;
    }

    public int getIdBiaya() {
        return idBiaya;
    }

    public void setIdBiaya(int idBiaya) {
        this.idBiaya = idBiaya;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getJenisBiaya() {
        return jenisBiaya;
    }

    public void setJenisBiaya(String jenisBiaya) {
        this.jenisBiaya = jenisBiaya;
    }

    public String getNamaBiaya() {
        return namaBiaya;
    }

    public void setNamaBiaya(String namaBiaya) {
        this.namaBiaya = namaBiaya;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public int getTahunGiling() {
        return tahunGiling;
    }

    public void setTahunGiling(int tahunGiling) {
        this.tahunGiling = tahunGiling;
    }

    public int getRupiahBiaya() {
        return rupiahBiaya;
    }

    public void setRupiahBiaya(int rupiahBiaya) {
        this.rupiahBiaya = rupiahBiaya;
    }

    public String getKodeBiaya() {
        return kodeBiaya;
    }

    public void setKodeBiaya(String kodeBiaya) {
        this.kodeBiaya = kodeBiaya;
    }
    
}
