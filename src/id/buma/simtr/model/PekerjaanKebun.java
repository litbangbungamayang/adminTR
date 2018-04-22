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

public class PekerjaanKebun {
    private int idPekerjaan;
    private String kategori;
    private String namaPekerjaan;
    private String satuan;
    private int tahunGiling;
    private int harga;
    
    public PekerjaanKebun(int idPekerjaan, String kategori, String namaPekerjaan,
            String satuan, int tahunGiling, int harga){
        this.idPekerjaan = idPekerjaan;
        this.kategori = kategori;
        this.namaPekerjaan = namaPekerjaan;
        this.satuan = satuan;
        this.tahunGiling = tahunGiling;
        this.harga = harga;
        
    }

    public int getIdPekerjaan() {
        return idPekerjaan;
    }

    public void setIdPekerjaan(int idPekerjaan) {
        this.idPekerjaan = idPekerjaan;
    }

    public String getNamaPekerjaan() {
        return namaPekerjaan;
    }

    public void setNamaPekerjaan(String namaPekerjaan) {
        this.namaPekerjaan = namaPekerjaan;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
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

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
        
}
