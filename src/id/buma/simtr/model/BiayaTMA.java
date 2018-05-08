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
    private int idDesa;
    private int tahunGiling;
    private int biayaTebang;
    private int biayaAngkut;
    
    public BiayaTMA(int idDesa, int tahunGiling, int biayaTebang, int biayaAngkut){
        this.idDesa = idDesa;
        this.tahunGiling = tahunGiling;
        this.biayaAngkut = biayaAngkut;
        this.biayaTebang = biayaTebang;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    public int getTahunGiling() {
        return tahunGiling;
    }

    public void setTahunGiling(int tahunGiling) {
        this.tahunGiling = tahunGiling;
    }

    public int getBiayaTebang() {
        return biayaTebang;
    }

    public void setBiayaTebang(int biayaTebang) {
        this.biayaTebang = biayaTebang;
    }

    public int getBiayaAngkut() {
        return biayaAngkut;
    }

    public void setBiayaAngkut(int biayaAngkut) {
        this.biayaAngkut = biayaAngkut;
    }
    
    
}
