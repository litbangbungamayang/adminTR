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

public class KelompokTani {
    private String idKelompok;
    private int tahun;
    private String namaKelompok;
    private String noKontrak;
    private String kategori;
    private String masaTanam;
    private String idAfd;
    private int idDesa;
    private String noKtp;
    private java.sql.Date tglRdkk;
    
    
    public KelompokTani(String idKelompok, int tahun, String namaKelompok, 
            String noKontrak, String kategori, String masaTanam, String idAfd, int idDesa, 
            String noKtp, java.sql.Date tglRdkk){
        this.idAfd = idAfd;
        this.idKelompok = idKelompok;
        this.namaKelompok = namaKelompok;
        this.noKontrak = noKontrak;
        this.kategori = kategori;
        this.masaTanam = masaTanam;
        this.tahun = tahun;
        this.idDesa = idDesa;
        this.noKtp = noKtp;
        this.tglRdkk = tglRdkk;
    }

    public String getIdKelompok() {
        return idKelompok;
    }

    public void setIdKelompok(String idKelompok) {
        this.idKelompok = idKelompok;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getNamaKelompok() {
        return namaKelompok;
    }

    public void setNamaKelompok(String namaKelompok) {
        this.namaKelompok = namaKelompok;
    }

    public String getNoKontrak() {
        return noKontrak;
    }

    public void setNoKontrak(String noKontrak) {
        this.noKontrak = noKontrak;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getMasaTanam() {
        return masaTanam;
    }

    public void setMasaTanam(String masaTanam) {
        this.masaTanam = masaTanam;
    }

    public String getIdAfd() {
        return idAfd;
    }

    public void setIdAfd(String idAfd) {
        this.idAfd = idAfd;
    }

    public int getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(int idDesa) {
        this.idDesa = idDesa;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public java.sql.Date getTglRdkk() {
        return tglRdkk;
    }

    public void setTglRdkk(java.sql.Date tglRdkk) {
        this.tglRdkk = tglRdkk;
    }
    
}
