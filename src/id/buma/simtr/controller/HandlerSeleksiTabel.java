/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.model.BahanProduksi;
import id.buma.simtr.model.BufferTable_TransaksiPupuk;
import id.buma.simtr.model.KelompokTani;
import id.buma.simtr.model.User;
import id.buma.simtr.view.BahanProduksiTableModel;
import id.buma.simtr.view.BufferTransaksi_PupukRowRenderer;
import id.buma.simtr.view.BufferTransaksi_PupukTableModel;
import id.buma.simtr.view.KelompokTaniTableModel;
import id.buma.simtr.view.MainWindow;
import id.buma.simtr.view.UserDataTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class HandlerSeleksiTabel implements ListSelectionListener{

    private String seleksiMode;
    private JTable tbl;
    private MainWindow mw;
    
    private RDKKController rc = new RDKKController(mw);
    
    private PupukController pc = new PupukController(mw);
    
    public HandlerSeleksiTabel(MainWindow mw, String seleksiMode, JTable tbl){
        this.seleksiMode = seleksiMode;
        this.tbl = tbl;
        this.mw = mw;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        UserController uc = new UserController(mw);
        CommonController cc = new CommonController(mw);
        PerawatanController pwc = new PerawatanController(mw);
        BahanProduksiController bpc = new BahanProduksiController(mw);
        if (!e.getValueIsAdjusting()){
            switch (seleksiMode){
                case "KelompokTani-Petani":
                    if (tbl.getSelectedRow() > -1){
                        KelompokTaniTableModel kttm = (KelompokTaniTableModel) tbl.getModel();
                        List<KelompokTani> lst = kttm.getContentList();
                        //JOptionPane.showMessageDialog(null, lst.get(tbl.getSelectedRow()).getIdKelompok());
                        String idKelompok = lst.get(tbl.getSelectedRow()).getIdKelompok();
                        rc.populateTablePetaniByIdKelompok(mw.getTblValidasiRDKK_Petani(), idKelompok);
                        mw.getTblValidasiRDKK_Petani().setRowSelectionAllowed(false);
                    }
                    break;
                case "PupukKelTani-Petani":
                    if (tbl.getSelectedRow() > -1){
                        KelompokTaniTableModel kttm = (KelompokTaniTableModel) tbl.getModel();
                        List<KelompokTani> lst = kttm.getContentList();
                        String idKelompok = lst.get(tbl.getSelectedRow()).getIdKelompok();
                        pc.populateTblPupukPetaniByIdKelompok(mw.getTblPupukPetani(), idKelompok);
                        mw.getTblPupukPetani().setRowSelectionAllowed(true);
                        if (mw.getJcbFrmPupuk_PilihSemuaPetani().isSelected()) 
                            pc.selectAllRows(mw.getTblPupukPetani());
                        //----- untuk reset Buffer Table -----//
                        cc.setTableHeaderKelTani(mw.getTblBuffer_Pupuk_Permintaan().getTableHeader());
                        BufferTransaksi_PupukRowRenderer bufferRR = new BufferTransaksi_PupukRowRenderer();
                        mw.getTblBuffer_Pupuk_Permintaan().setDefaultRenderer(Object.class, bufferRR);
                        List<BufferTable_TransaksiPupuk> lbt = new ArrayList<>();
                        BufferTransaksi_PupukTableModel btptm = new BufferTransaksi_PupukTableModel(lbt);
                        mw.getTblBuffer_Pupuk_Permintaan().setModel(btptm);
                    }
                    break;
                case "UserData-FormUserData":
                    if (tbl.getSelectedRow() > -1){
                        UserDataTableModel udtm = (UserDataTableModel) tbl.getModel();
                        List<User> lstUser = udtm.getContentList();
                        uc.getUserDetail(lstUser.get(tbl.getSelectedRow()));
                        String afdeling = lstUser.get(tbl.getSelectedRow()).getIdAfd();
                        mw.getCbxFrmUserData_Afdeling().setSelectedItem(afdeling);
                    }
                    break;
                case "BahanProduksi-FormBahanProduksi":
                    if (tbl.getSelectedRow() > -1){
                        BahanProduksiTableModel bptm = (BahanProduksiTableModel) tbl.getModel();
                        List<BahanProduksi> lstBp = bptm.getContentList();
                        bpc.setBahanProduksi(lstBp.get(tbl.getSelectedRow()));
                        bpc.loadDetailData();
                        bpc.prepareTblBahanProduksiMasuk(mw.getTblMonitorBahanMasuk());                    
                    }
                    break;
                case "PerawatanKelTani-Petani":
                    if (tbl.getSelectedRow() > -1){
                        KelompokTaniTableModel kttm = (KelompokTaniTableModel) tbl.getModel();
                        List<KelompokTani> lst = kttm.getContentList();
                        String idKelompok = lst.get(tbl.getSelectedRow()).getIdKelompok();
                        pwc.populateTblPerawatanPetaniByIdKelompok(mw.getTblPetani_Perawatan_Permintaan(), idKelompok);
                        pwc.prepareTblPekerjaanKebun(idKelompok);
                        mw.getTblPetani_Perawatan_Permintaan().setRowSelectionAllowed(true);
                    }
                    break;
            }
        }
    }

}
