/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.model.PetaniTebu;
import java.util.List;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public interface PetaniDAO {
    
    public List<PetaniTebu> getAllPetaniTebuByIdKelompok(String idKelompok);
    
    public List<PetaniTebu> getAllPetaniTebu();
    
    public List<PetaniTebu> getAllPetaniTebuByTahun(int tahun);
    
    public boolean insertPetaniTebu(PetaniTebu pt);
    
}
