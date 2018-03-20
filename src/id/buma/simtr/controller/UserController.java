/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.dao.UserDAOSQL;
import id.buma.simtr.model.User;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class UserController {
    
    private final UserDAOSQL userDao = new UserDAOSQL();
    
    public User user = null;
    
    public void insertNewUser(){
        User newUser = new User(0, "byaktabariq910???", "bayu", 1, "Bayu Muhardika","19");
        userDao.addNewUser(newUser);
    }
    
    
    
}
