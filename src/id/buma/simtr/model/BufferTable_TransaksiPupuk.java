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

public class BufferTable_TransaksiPupuk {
    
    private String namaPetani;
    private int jmlBahan;
    float[] kuantaPupuk = new float[jmlBahan];
    
    
    public BufferTable_TransaksiPupuk(String namaPetani, float[] kuantaPupuk){
        this.namaPetani = namaPetani;
        this.jmlBahan = kuantaPupuk.length;
        this.kuantaPupuk = kuantaPupuk;
    }
    
    public String getNamaPetani(){
        return namaPetani;
    }
    
    public float[] getKuanta(){
        return kuantaPupuk;
    }
}
