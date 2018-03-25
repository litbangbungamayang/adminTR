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

public class BahanProduksi {
    
    private int idBahan;
    private String jenisBahan;
    private String namaBahan;
    private String satuan;
    private float dosisPerHa;
    
    public BahanProduksi(int idBahan, String jenisBahan, String namaBahan, 
            String satuan, float dosisPerHa){
        this.idBahan = idBahan;
        this.jenisBahan = jenisBahan;
        this.namaBahan = namaBahan;
        this.satuan = satuan;
        this.dosisPerHa = dosisPerHa;
    }

    public int getIdBahan() {
        return idBahan;
    }

    public void setIdBahan(int idBahan) {
        this.idBahan = idBahan;
    }

    public String getJenisBahan() {
        return jenisBahan;
    }

    public void setJenisBahan(String jenisBahan) {
        this.jenisBahan = jenisBahan;
    }

    public String getNamaBahan() {
        return namaBahan;
    }

    public void setNamaBahan(String namaBahan) {
        this.namaBahan = namaBahan;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public float getDosisPerHa() {
        return dosisPerHa;
    }

    public void setDosisPerHa(float dosisPerHa) {
        this.dosisPerHa = dosisPerHa;
    }
    
}
