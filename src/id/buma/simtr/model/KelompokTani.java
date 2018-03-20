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
    private String idAfd;
    private int idDesa;
    private String verifikasi;
    private String noKtp;
    private String noRdkk;
    private java.sql.Date tglRdkk;
    
    
    public KelompokTani(String idKelompok, int tahun, String namaKelompok, 
            String noKontrak, String kategori, String idAfd, int idDesa, 
            String verifikasi, String noKtp, String noRdkk, java.sql.Date tglRdkk){
        this.idAfd = idAfd;
        this.idKelompok = idKelompok;
        this.namaKelompok = namaKelompok;
        this.noKontrak = noKontrak;
        this.kategori = kategori;
        this.tahun = tahun;
        this.idDesa = idDesa;
        this.verifikasi = verifikasi;
        this.noKtp = noKtp;
        this.noRdkk = noRdkk;
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

    public String getIdAfd() {
        return idAfd;
    }

    public void setIdAfd(String idAfd) {
        this.idAfd = idAfd;
    }

    public String getVerifikasi() {
        return verifikasi;
    }

    public void setVerifikasi(String verifikasi) {
        this.verifikasi = verifikasi;
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

    public String getNoRdkk() {
        return noRdkk;
    }

    public void setNoRdkk(String noRdkk) {
        this.noRdkk = noRdkk;
    }

    public java.sql.Date getTglRdkk() {
        return tglRdkk;
    }

    public void setTglRdkk(java.sql.Date tglRdkk) {
        this.tglRdkk = tglRdkk;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    
    
}
