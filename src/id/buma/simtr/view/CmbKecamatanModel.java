/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.model.Kecamatan;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class CmbKecamatanModel extends DefaultComboBoxModel<Kecamatan>{
    
    public CmbKecamatanModel(Kecamatan[] items){
        super(items);
    }

    @Override
    public String getSelectedItem() {
        Kecamatan selectedKec = (Kecamatan) super.getSelectedItem();
        return selectedKec.getNamaKecamatan();
    }
    
}
