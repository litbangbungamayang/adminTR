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
public class PetaniTebu {
    private String idPetani;
    private int tahun;
    private String idKelompok;
    private String namaPetani;
    private String masaTanam;
    private float luas;
    private String jenisTebu;
    
    public PetaniTebu(String idPetani, int tahun, String idKelompok, 
            String namaPetani, String masaTanam, float luas, String jenisTebu){
        this.idKelompok = idKelompok;
        this.idPetani = idPetani;
        this.jenisTebu = jenisTebu;
        this.luas = luas;
        this.masaTanam = masaTanam;
        this.namaPetani = namaPetani;
        this.tahun = tahun;
    }

    public String getIdPetani() {
        return idPetani;
    }

    public void setIdPetani(String idPetani) {
        this.idPetani = idPetani;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getIdKelompok() {
        return idKelompok;
    }

    public void setIdKelompok(String idKelompok) {
        this.idKelompok = idKelompok;
    }

    public String getNamaPetani() {
        return namaPetani;
    }

    public void setNamaPetani(String namaPetani) {
        this.namaPetani = namaPetani;
    }

    public String getMasaTanam() {
        return masaTanam;
    }

    public void setMasaTanam(String masaTanam) {
        this.masaTanam = masaTanam;
    }

    public float getLuas() {
        return luas;
    }

    public void setLuas(float luas) {
        this.luas = luas;
    }

    public String getJenisTebu() {
        return jenisTebu;
    }

    public void setJenisTebu(String jenisTebu) {
        this.jenisTebu = jenisTebu;
    }
    
    
}
