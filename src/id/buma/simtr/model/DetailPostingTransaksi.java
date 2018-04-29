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

public class DetailPostingTransaksi {
    
    private PetaniTebu pt;
    private Transaksi trn;
    private Biaya bya;
    
    public DetailPostingTransaksi(PetaniTebu pt, Transaksi trn, Biaya bya){
        this.pt = pt;
        this.trn = trn;
        this.bya = bya;
    }

    public PetaniTebu getPt() {
        return pt;
    }

    public void setPt(PetaniTebu pt) {
        this.pt = pt;
    }

    public Transaksi getTrn() {
        return trn;
    }

    public void setTrn(Transaksi trn) {
        this.trn = trn;
    }

    public Biaya getBya() {
        return bya;
    }

    public void setBya(Biaya bya) {
        this.bya = bya;
    }
    
    
    
}
