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

public class SubPekerjaan {
    private String idSubPekerjaan;
    private String namaSubPekerjaan;
    private String tahunGiling;
    private int hargaSatuan;
    
    public SubPekerjaan(String idSubPekerjaan, String namaSubPekerjaan, String tahunGiling, int hargaSatuan){
        this.hargaSatuan = hargaSatuan;
        this.idSubPekerjaan = idSubPekerjaan;
        this.namaSubPekerjaan = namaSubPekerjaan;
        this.tahunGiling = tahunGiling;
    }

    public String getIdSubPekerjaan() {
        return idSubPekerjaan;
    }

    public void setIdSubPekerjaan(String idSubPekerjaan) {
        this.idSubPekerjaan = idSubPekerjaan;
    }

    public String getNamaSubPekerjaan() {
        return namaSubPekerjaan;
    }

    public void setNamaSubPekerjaan(String namaSubPekerjaan) {
        this.namaSubPekerjaan = namaSubPekerjaan;
    }

    public String getTahunGiling() {
        return tahunGiling;
    }

    public void setTahunGiling(String tahunGiling) {
        this.tahunGiling = tahunGiling;
    }

    public int getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(int hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }
    
}
