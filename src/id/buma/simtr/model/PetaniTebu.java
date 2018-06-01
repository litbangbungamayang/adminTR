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
    private String idKelompok;
    private String namaPetani;
    private Double luas;
    private String jenisTebu;
    private String utmZone;
    private Double easting;
    private Double northing;
    
    
    public PetaniTebu(String idPetani, String idKelompok, 
            String namaPetani, Double luas, String jenisTebu, String utmZone,
            Double easting, Double Northing){
        this.idKelompok = idKelompok;
        this.idPetani = idPetani;
        this.jenisTebu = jenisTebu;
        this.luas = luas;
        this.namaPetani = namaPetani;
    }

    public String getIdPetani() {
        return idPetani;
    }

    public void setIdPetani(String idPetani) {
        this.idPetani = idPetani;
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

    public Double getLuas() {
        return luas;
    }

    public void setLuas(Double luas) {
        this.luas = luas;
    }

    public String getJenisTebu() {
        return jenisTebu;
    }

    public void setJenisTebu(String jenisTebu) {
        this.jenisTebu = jenisTebu;
    }

    public String getUtmZone() {
        return utmZone;
    }

    public void setUtmZone(String utmZone) {
        this.utmZone = utmZone;
    }

    public Double getEasting() {
        return easting;
    }

    public void setEasting(Double easting) {
        this.easting = easting;
    }

    public Double getNorthing() {
        return northing;
    }

    public void setNorthing(Double northing) {
        this.northing = northing;
    }
    
    
}
