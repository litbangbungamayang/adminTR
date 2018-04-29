/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.model.BuktiTransaksi;
import id.buma.simtr.model.KelompokTani;
import id.buma.simtr.model.Koordinat;
import id.buma.simtr.model.PetaniTebu;
import id.buma.simtr.model.RDKK;
import id.buma.simtr.model.Transaksi;
import java.util.List;

/**
 *
 * @author Bayu Anandavi Muhardika
 */

public interface RDKKDAO {
    
    public boolean insertInputData(RDKK rdkk);
    
    public boolean insertBatchKelompokTaniBaru(KelompokTani kt, List<PetaniTebu> lsPt, 
            List<Koordinat> lsKr, List<Transaksi> lsTb, BuktiTransaksi bt);
    
}
