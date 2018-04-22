/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.dao.KelompokTaniDAOSQL;
import id.buma.simtr.dao.PekerjaanKebunDAOSQL;
import id.buma.simtr.dao.PetaniDAOSQL;
import id.buma.simtr.dao.SistemDAOSQL;
import id.buma.simtr.model.PekerjaanKebun;
import id.buma.simtr.model.PetaniTebu;
import id.buma.simtr.view.MainWindow;
import id.buma.simtr.view.PekerjaanKebunRowRenderer;
import id.buma.simtr.view.PekerjaanKebunTableModel;
import id.buma.simtr.view.PetaniTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class PerawatanController implements ActionListener {
    
    private MainWindow mw;
    private final CommonController cc = new CommonController(mw);
    private final PetaniDAOSQL petaniDao = new PetaniDAOSQL();

    public PerawatanController(MainWindow mw){
        this.mw = mw;
    }
    
    public void prepareTblPerawatanKelTani(){
        JTable tbl = mw.getTblKelTani_Perawatan_Permintaan();
        cc.setTableHeaderKelTani(tbl.getTableHeader());
        cc.setTableRowRendererKelTani(tbl);
        cc.setTableSelectionModel(tbl);
        cc.setTableModelKelTani(tbl);
        HandlerSeleksiTabel hst = new HandlerSeleksiTabel(mw, "PerawatanKelTani-Petani", tbl);
        tbl.getSelectionModel().addListSelectionListener(hst);
    }
    
    public void populateTblPerawatanPetaniByIdKelompok(JTable tbl, String idKelompok){
        PetaniTableModel ptm = new PetaniTableModel(petaniDao.getAllPetaniTebuByIdKelompok(idKelompok));
        tbl.setModel(ptm);
    }
    
    public void prepareTblPerawatanPetani(){
        JTable tbl = mw.getTblPetani_Perawatan_Permintaan();
        cc.setTableHeaderPetani(tbl.getTableHeader());
        List<PetaniTebu> lst = new ArrayList<>();
        PetaniTableModel ptm = new PetaniTableModel(lst);
        cc.setTableModelPetani(tbl, ptm);
        cc.setTableRowRendererPetani(tbl);
    }
    
    public void prepareTblPekerjaanKebun(String idKelompok){
        KelompokTaniDAOSQL kelTanDao = new KelompokTaniDAOSQL();
        String kategori = kelTanDao.getKelompokTaniByIdKelompok(idKelompok).getKategori();
        switch (kategori){
            case "PC":
                kategori = "PC";
                break;
            case "R1":
                kategori = "RT";
                break;
            case "R2":
                kategori = "RT";
                break;
            case "R3":
                kategori = "RT";
                break;
        }
        JTable tbl = mw.getTblPekerjaanKebun_Perawatan_Permintaan();
        cc.setTableHeaderKelTani(tbl.getTableHeader());
        PekerjaanKebunRowRenderer pkrr = new PekerjaanKebunRowRenderer();
        mw.getTblPekerjaanKebun_Perawatan_Permintaan().setDefaultRenderer(Object.class, pkrr);
        PekerjaanKebunDAOSQL pwcDao = new PekerjaanKebunDAOSQL();
        SistemDAOSQL sistDao = new SistemDAOSQL();
        List<PekerjaanKebun> lsPk = pwcDao.getAllPekerjaanKebunByKategori(sistDao.getTahunGiling(),kategori);
        PekerjaanKebunTableModel pktm = new PekerjaanKebunTableModel(lsPk);
        mw.getTblPekerjaanKebun_Perawatan_Permintaan().setModel(pktm);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
