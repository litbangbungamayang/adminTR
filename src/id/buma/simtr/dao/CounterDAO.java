/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.model.IdNoKontrak;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public interface CounterDAO {
    
    public IdNoKontrak getNewIdKelompok(int afdeling, int kategori);
    
    public String getNewIdPetani(String idKelompok);
    
}
