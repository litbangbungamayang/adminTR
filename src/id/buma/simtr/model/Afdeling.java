/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.model;

/**
 *
 * @author Bayu Anandavi Muhardika
 */

public class Afdeling {
    private String idAfd;
    private String afdeling;
    private int batasRit;
    private String namaAsisten;
    private String idRayon;
    
    public Afdeling(String idAfd, String afdeling, int batasRit, String namaAsisten, String idRayon){
        this.afdeling = afdeling;
        this.batasRit = batasRit;
        this.idAfd = idAfd;
        this.idRayon = idRayon;
        this.namaAsisten = namaAsisten;
    }

    public String getIdAfd() {
        return idAfd;
    }

    public void setIdAfd(String idAfd) {
        this.idAfd = idAfd;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    public int getBatasRit() {
        return batasRit;
    }

    public void setBatasRit(int batasRit) {
        this.batasRit = batasRit;
    }

    public String getNamaAsisten() {
        return namaAsisten;
    }

    public void setNamaAsisten(String namaAsisten) {
        this.namaAsisten = namaAsisten;
    }

    public String getIdRayon() {
        return idRayon;
    }

    public void setIdRayon(String idRayon) {
        this.idRayon = idRayon;
    }
    
}
