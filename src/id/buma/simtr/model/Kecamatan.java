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

public class Kecamatan {
    private String idKecamatan;
    private String namaKecamatan;
    
    public Kecamatan(String idKecamatan, String namaKecamatan){
        this.idKecamatan = idKecamatan;
        this.namaKecamatan = namaKecamatan;
    }

    public String getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(String idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public String getNamaKecamatan() {
        return namaKecamatan;
    }

    public void setNamaKecamatan(String namaKecamatan) {
        this.namaKecamatan = namaKecamatan;
    }
    
    @Override
    public String toString(){
        return namaKecamatan;
    }
    
    
}
