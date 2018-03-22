/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.model;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class Koordinat {
    
    private String idPetani;
    private float easting;
    private float northing;
    private String gridZone;
    
    public Koordinat(String idPetani, float easting, float northing, String gridZone){
        this.idPetani = idPetani;
        this.easting = easting;
        this.northing = northing;
        this.gridZone = gridZone;
    }

    public String getIdPetani() {
        return idPetani;
    }

    public void setIdPetani(String idPetani) {
        this.idPetani = idPetani;
    }

    public float getEasting() {
        return easting;
    }

    public void setEasting(float easting) {
        this.easting = easting;
    }

    public float getNorthing() {
        return northing;
    }

    public void setNorthing(float northing) {
        this.northing = northing;
    }

    public String getGridZone() {
        return gridZone;
    }

    public void setGridZone(String gridZone) {
        this.gridZone = gridZone;
    }
    
}
