/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class VersionController {
    
    String version;
    
    public String getVersion(){
        version = "0.9.1";
        /*
        + Versi pre-rilis
        + Sebagian besar GUI sudah tampil
        + Modul RDKK sudah di-test (UAT ke-1)
        */
        return version;
    }
        
}
