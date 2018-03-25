/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.dao.BahanProduksiDAOSQL;
import id.buma.simtr.dao.KelompokTaniDAOSQL;
import id.buma.simtr.dao.PetaniDAOSQL;
import id.buma.simtr.model.BahanProduksi;
import id.buma.simtr.model.PetaniTebu;
import id.buma.simtr.model.TransaksiPupuk;
import id.buma.simtr.view.BahanProduksi_PupukTableModel;
import id.buma.simtr.view.BufferTransaksi_PupukRowRenderer;
import id.buma.simtr.view.MainWindow;
import id.buma.simtr.view.PetaniTableModel;
import id.buma.simtr.view.TransaksiPupuk_BufferTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class PupukController implements ActionListener{
    
    private MainWindow mw;
    
    private final CommonController cc = new CommonController(mw);
    
    private final KelompokTaniDAOSQL keltanDao = new KelompokTaniDAOSQL();
    
    private final PetaniDAOSQL petaniDao = new PetaniDAOSQL();
    
    private final BahanProduksiDAOSQL pupukDao = new BahanProduksiDAOSQL();
    
    public static List<TransaksiPupuk> transPupuk = new ArrayList<>();
    
    private final BufferTransaksi_PupukRowRenderer bufferRR = new BufferTransaksi_PupukRowRenderer();
    
    public PupukController(MainWindow mw){
        this.mw = mw;
    }
    
    public void setBufferTransaksiPupuk(List<PetaniTebu> listPetani, List<BahanProduksi> listBahan, java.sql.Date tglTransaksi){
        java.sql.Timestamp postingTimestamp = new java.sql.Timestamp(new java.util.Date().getTime());
        //cc.showErrorMsg("Test", String.valueOf(listBahan.size()));
        transPupuk.clear();
        for (int i = 0; i < listPetani.size(); i++){
            for (int j = 0; j < listBahan.size(); j++){
                float kuanta = listPetani.get(i).getLuas() * listBahan.get(j).getDosisPerHa();
                TransaksiPupuk tp = new TransaksiPupuk(
                        0, 
                        listPetani.get(i).getIdPetani(),
                        listBahan.get(j).getIdBahan(), 
                        tglTransaksi, 
                        kuanta, 
                        CommonController.user.getUserId(),
                        postingTimestamp
                );
                //cc.showErrorMsg("Tes", "listPetani size = " + listPetani.size() + "; listBahan size = " + listBahan.size());
                transPupuk.add(tp);
            }
        }
        //cc.showErrorMsg("Tes", "listBuffer size = " + transPupuk.size());
    }
    
    public void addDaftarPetaniPupuk(){
        if (mw.getTblPupukPetani().getSelectedRowCount() > 0 && 
                mw.getTblJenisPupuk_Pupuk_Permintaan().getSelectedRowCount() > 0){
            PetaniTableModel ptm = (PetaniTableModel) mw.getTblPupukPetani().getModel();
            List<PetaniTebu> listPetani = ptm.getContentList();
            List<PetaniTebu> listPetaniSelected = new ArrayList<>();
            int[] selectionPetani = mw.getTblPupukPetani().getSelectedRows();
            for (int i = 0; i < selectionPetani.length; i++){
                listPetaniSelected.add(listPetani.get(selectionPetani[i]));
            }
            BahanProduksi_PupukTableModel bpptm = (BahanProduksi_PupukTableModel) mw.getTblJenisPupuk_Pupuk_Permintaan().getModel();
            List<BahanProduksi> listBahan = bpptm.getContentList();
            List<BahanProduksi> listBahanSelected = new ArrayList<>();
            int[] selectionBahan = mw.getTblJenisPupuk_Pupuk_Permintaan().getSelectedRows();
            for (int i = 0; i < selectionBahan.length; i++){
                listBahanSelected.add(listBahan.get(selectionBahan[i]));
            }
            //cc.showErrorMsg("Test", String.valueOf(listPetaniSelected.size()));
            java.sql.Date tglTransaksi = new java.sql.Date(mw.getDtpTglTransaksiPupuk().getDate().getTime());
            setBufferTransaksiPupuk(listPetaniSelected, listBahanSelected, tglTransaksi);
            if (transPupuk.size() > 0){
                TransaksiPupuk_BufferTableModel tpbtm = new TransaksiPupuk_BufferTableModel(transPupuk);
                tpbtm.setArrayPetani(listPetaniSelected);
                tpbtm.setArrayBahanProduksi(listBahanSelected);
                mw.getTblBuffer_Pupuk_Permintaan().setModel(tpbtm);
                cc.setTableHeaderKelTani(mw.getTblBuffer_Pupuk_Permintaan().getTableHeader());
                mw.getTblBuffer_Pupuk_Permintaan().setDefaultRenderer(Object.class, bufferRR);
            }
        } else {
            if (mw.getTblPupukPetani().getSelectedRowCount() == 0) 
                cc.showErrorMsg("Permintaan Pupuk", "Pilih minimal 1 petani!");
            if (mw.getTblJenisPupuk_Pupuk_Permintaan().getSelectedRowCount() == 0) 
                cc.showErrorMsg("Permintaan Pupuk", "Pilih minimal 1 jenis pupuk!");
        }
    }
    
    public void clearTable(){
        prepareDatePicker();
        java.sql.Date tglTransaksi = new java.sql.Date(mw.getDtpTglTransaksiPupuk().getDate().getTime());
        List<PetaniTebu> listPetaniKosong = new ArrayList<>();
        List<BahanProduksi> listBahanKosong = new ArrayList<>();
        setBufferTransaksiPupuk(listPetaniKosong, listBahanKosong, tglTransaksi);
        TransaksiPupuk_BufferTableModel tpbtm = new TransaksiPupuk_BufferTableModel(transPupuk);
        tpbtm.setArrayPetani(listPetaniKosong);
        tpbtm.setArrayBahanProduksi(listBahanKosong);
        mw.getTblBuffer_Pupuk_Permintaan().setModel(tpbtm);
        cc.setTableHeaderKelTani(mw.getTblBuffer_Pupuk_Permintaan().getTableHeader());
        mw.getTblBuffer_Pupuk_Permintaan().setDefaultRenderer(Object.class, bufferRR);
    }
    
    public void prepareTablePupukKelTani(){
        JTable tbl = mw.getTblPupukKelTani();
        cc.setTableHeaderKelTani(tbl.getTableHeader());
        cc.setTableModelKelTani(tbl);
        cc.setTableRowRendererKelTani(tbl);
        cc.setTableSelectionModel(tbl);
        HandlerSeleksiTabel hst = new HandlerSeleksiTabel(mw, "PupukKelTani-Petani", tbl);
        tbl.getSelectionModel().addListSelectionListener(hst);
    }
    
    public void prepareTablePupukPetani(){
        JTable tbl = mw.getTblPupukPetani();
        cc.setTableHeaderPetani(tbl.getTableHeader());
        List<PetaniTebu> lst = new ArrayList<>();
        PetaniTableModel ptm = new PetaniTableModel(lst);
        cc.setTableModelPetani(tbl, ptm);
        cc.setTableRowRendererPetani(tbl);
    }
    
    public void prepareDatePicker(){
        mw.getDtpTglTransaksiPupuk().setFormats("dd-MM-yyyy");
        mw.getDtpTglTransaksiPupuk().setDate(new java.util.Date());
    }
    
    public void populateTblPupukPetaniByIdKelompok(JTable tbl, String idKelompok){
        PetaniTableModel ptm = new PetaniTableModel(petaniDao.getAllPetaniTebuByIdKelompok(idKelompok));
        tbl.setModel(ptm);
    }
    
    public void prepareTablePupukJenisPupuk(){
        JTable tbl = mw.getTblJenisPupuk_Pupuk_Permintaan();
        cc.setTableRowRendererJenisPupuk(tbl);
        cc.setTableHeaderKelTani(tbl.getTableHeader());
        List<BahanProduksi> lbp = pupukDao.getAllBahanProduksiByJenis("PUPUK");
        BahanProduksi_PupukTableModel bpptm = new BahanProduksi_PupukTableModel(lbp);
        cc.setTableModelPupuk(tbl, bpptm);
    }
    
    public void selectAllRows(JTable tbl){
        if (tbl.getRowCount() > 0){
            tbl.setRowSelectionInterval(0, tbl.getRowCount() - 1);
            tbl.setEnabled(false);
        }
    }
    
    public void deselectAllRows(JTable tbl){
        tbl.clearSelection();
        tbl.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource().getClass();
        if (obj == JCheckBox.class){
            JCheckBox chkBox = (JCheckBox) e.getSource();
            String chkBoxName = chkBox.getName();
            switch(chkBoxName){
                case "jcbFrmPupuk_PilihSemuaPetani":
                    if (chkBox.isSelected()) 
                        selectAllRows(mw.getTblPupukPetani()); 
                    else
                        deselectAllRows(mw.getTblPupukPetani());
                    break;
                case "jcbFrmPupuk_PilihSemuaPupuk":
                    if (chkBox.isSelected()) 
                        selectAllRows(mw.getTblJenisPupuk_Pupuk_Permintaan());
                    else
                        deselectAllRows(mw.getTblJenisPupuk_Pupuk_Permintaan());
                    break;
            }
        }
    }
    
}
