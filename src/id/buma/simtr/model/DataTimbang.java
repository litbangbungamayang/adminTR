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

public class DataTimbang {
    private int idTimbangan;
    private PetaniTebu petani;
    private int bruto;
    private int tarra;
    private int netto;
    private java.util.Date tglNetto;
    
    public DataTimbang(int idTimbangan, PetaniTebu petani, int bruto, int tarra, int netto, java.util.Date tglNetto){
        this.idTimbangan = idTimbangan;
        this.petani = petani;
        this.bruto = bruto;
        this.tarra = tarra;
        this.netto = netto;
        this.tglNetto = tglNetto;
    }

    public int getIdTimbangan() {
        return idTimbangan;
    }

    public void setIdTimbangan(int idTimbangan) {
        this.idTimbangan = idTimbangan;
    }

    public PetaniTebu getPetani() {
        return petani;
    }

    public void setPetani(PetaniTebu petani) {
        this.petani = petani;
    }

    public int getBruto() {
        return bruto;
    }

    public void setBruto(int bruto) {
        this.bruto = bruto;
    }

    public int getTarra() {
        return tarra;
    }

    public void setTarra(int tarra) {
        this.tarra = tarra;
    }

    public int getNetto() {
        return netto;
    }

    public void setNetto(int netto) {
        this.netto = netto;
    }

    public java.util.Date getTglNetto() {
        return tglNetto;
    }

    public void setTglNetto(java.sql.Date tglNetto) {
        this.tglNetto = tglNetto;
    }
    
}
