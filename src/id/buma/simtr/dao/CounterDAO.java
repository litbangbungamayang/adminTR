/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public interface CounterDAO {
    
    public String getNewIdKelompok(int afdeling);
    
    public String getNewIdPetani(String idKelompok);
    
}
