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

public class RDKK {
    private String idRdkk;
    private String noRdkk;
    private java.sql.Date tglRdkk;
    private String idPetani;
    
    public RDKK(String idRdkk, String noRdkk, java.sql.Date tglRdkk, String idPetani, String idDesa){
        this.idPetani = idPetani;
        this.idRdkk = idRdkk;
        this.noRdkk = noRdkk;
        this.tglRdkk = tglRdkk;
    }

    public String getIdRdkk() {
        return idRdkk;
    }

    public void setIdRdkk(String idRdkk) {
        this.idRdkk = idRdkk;
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

    public String getIdPetani() {
        return idPetani;
    }

    public void setIdPetani(String idPetani) {
        this.idPetani = idPetani;
    }
    
}
