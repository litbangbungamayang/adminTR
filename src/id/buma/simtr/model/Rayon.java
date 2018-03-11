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

public class Rayon {
    private String idRayon;
    private String rayon;
    private String tstr;
    private String namaAskep;
    
    public Rayon(String idRayon, String rayon, String tstr, String namaAskep){
        this.idRayon = idRayon;
        this.namaAskep = namaAskep;
        this.rayon = rayon;
        this.tstr = tstr;
    }

    public String getIdRayon() {
        return idRayon;
    }

    public void setIdRayon(String idRayon) {
        this.idRayon = idRayon;
    }

    public String getRayon() {
        return rayon;
    }

    public void setRayon(String rayon) {
        this.rayon = rayon;
    }

    public String getTstr() {
        return tstr;
    }

    public void setTstr(String tstr) {
        this.tstr = tstr;
    }

    public String getNamaAskep() {
        return namaAskep;
    }

    public void setNamaAskep(String namaAskep) {
        this.namaAskep = namaAskep;
    }
    
}
