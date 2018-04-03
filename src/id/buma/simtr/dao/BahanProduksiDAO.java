/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.model.BahanProduksi;
import java.util.List;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public interface BahanProduksiDAO {
    
    public List<BahanProduksi> getAllBahanProduksiByJenis(String jenisBahan);

    public BahanProduksi getBahanProduksiByIdBahan(int idBahan);
    
    public List<BahanProduksi> getAllBahanProduksi();
    
    public boolean insertNewBahan(BahanProduksi bp);
    
    public boolean updateBahan(BahanProduksi bp);
    
    public boolean deleteBahan(int idBahan);
    
    public boolean cekBahanProduksiDigunakan(int idBahan);
    
}
