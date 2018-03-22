/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.model.Koordinat;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public interface KoordinatDAO {
    
    public Koordinat getKoordinatByIdPetani(String idPetani);
    
    public boolean insertNewKoordinat(Koordinat koordinat);
    
}
