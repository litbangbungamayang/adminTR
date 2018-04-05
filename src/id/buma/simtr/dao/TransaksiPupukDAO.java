/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.model.TransaksiPupuk;
import java.util.List;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public interface TransaksiPupukDAO {
    
    public boolean insertNewTransaksiPupuk(TransaksiPupuk tp);
    
    public boolean cekDuplicateTransaksiPupuk(String idPetani, int idBahan);
    
    public boolean cekBarangMasuk(int idBahan);
    
    public List<TransaksiPupuk> cekStokBahanProduksi(int idBahan);
    
}
