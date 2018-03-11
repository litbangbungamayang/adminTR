/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.model.Afdeling;
import java.util.List;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public interface AfdelingDAO {
    
    public boolean insertAfdeling(Afdeling afd);
    
    public List<Afdeling> getAfdelingByIdAfd(String idAfd);
    
}
