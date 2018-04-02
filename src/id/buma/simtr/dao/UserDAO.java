/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.model.User;
import java.util.List;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public interface UserDAO {
    
    public List<User> getAllUser();
    
    public User getUserData(String username, String password);
    
    public boolean addNewUser(User user);
    
    public boolean updateUserData(User user);
    
    public boolean deleteUserData(User user);
    
}
