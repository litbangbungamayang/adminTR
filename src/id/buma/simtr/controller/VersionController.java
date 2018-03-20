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
        version = "0.9.2";
        /*
        + Nomor kontrak sudah di-generate otomatis
        + Ditambahkan pilihan untuk input kategori tanaman di modul RDKK
        */
        version = "0.9.3";
        /*
        + Pembatasan jumlah minimal luas lahan 5 Ha setiap kelompok
        */
        return version;
    }
        
}
