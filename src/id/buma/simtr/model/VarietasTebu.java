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

public class VarietasTebu {
    
    private String idVarietas;
    private String namaLab;
    private String namaRilis;
    private String dasarHukum;
    private String sifatKemasakan;
    
    public VarietasTebu(String idVarietas, String namaLab, String namaRilis, String dasarHukum, String sifatKemasakan){
        this.idVarietas = idVarietas;
        this.namaLab = namaLab;
        this.namaRilis = namaRilis;
        this.dasarHukum = dasarHukum;
        this.sifatKemasakan = sifatKemasakan;
    }

    public String getIdVarietas() {
        return idVarietas;
    }

    public void setIdVarietas(String idVarietas) {
        this.idVarietas = idVarietas;
    }

    public String getNamaLab() {
        return namaLab;
    }

    public void setNamaLab(String namaLab) {
        this.namaLab = namaLab;
    }

    public String getNamaRilis() {
        return namaRilis;
    }

    public void setNamaRilis(String namaRilis) {
        this.namaRilis = namaRilis;
    }

    public String getDasarHukum() {
        return dasarHukum;
    }

    public void setDasarHukum(String dasarHukum) {
        this.dasarHukum = dasarHukum;
    }

    public String getSifatKemasakan() {
        return sifatKemasakan;
    }

    public void setSifatKemasakan(String sifatKemasakan) {
        this.sifatKemasakan = sifatKemasakan;
    }
    
    
    
}
