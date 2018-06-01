/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.model.Kecamatan;
import java.util.List;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public interface KecamatanDAO {
    
    public List<Kecamatan> getKecamatanByIdKecamatan(int IdKecamatan);
    
    public List<Kecamatan> getAllKecamatan();
    
    public List<String> getAllStringKecamatan();
    
}
