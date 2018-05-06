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
import id.buma.simtr.dao.TransaksiDAOSQL;
import id.buma.simtr.model.Biaya;
import id.buma.simtr.model.BuktiTransaksi;
import id.buma.simtr.model.DetailPostingTransaksi;
import id.buma.simtr.model.KelompokTani;
import id.buma.simtr.model.PekerjaanKebun;
import id.buma.simtr.model.PetaniTebu;
import id.buma.simtr.model.Transaksi;
import id.buma.simtr.view.BufferPerawatan_Permintaan_TableModel;
import id.buma.simtr.view.DetailPostingPerawatan_Permintaan_RowRenderer;
import id.buma.simtr.view.DetailPostingPerawatan_Permintaan_TableModel;
import id.buma.simtr.view.KelompokTaniTableModel;
import id.buma.simtr.view.MainWindow;
import id.buma.simtr.view.MasterDataBiayaTableModel;
import id.buma.simtr.view.MasterDataBiaya_RowRenderer;
import id.buma.simtr.view.PekerjaanKebunRowRenderer;
import id.buma.simtr.view.PekerjaanKebunTableModel;
import id.buma.simtr.view.Perawatan_Permintaan_RowRenderer;
import id.buma.simtr.view.PetaniTableModel;
import id.buma.simtr.view.PostingPerawatan_Permintaan_RowRenderer;
import id.buma.simtr.view.PostingPerawatan_Permintaan_TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class PerawatanController implements ActionListener {
    
    private MainWindow mw;
    private final CommonController cc = new CommonController(mw);
    private final PetaniDAOSQL petaniDao = new PetaniDAOSQL();
    private final TransaksiDAOSQL transDao = new TransaksiDAOSQL();
    private static KelompokTani selectedKelTani = null;
    private static boolean masterEditStatus = false;

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
    
    public void populateTblBufferPekerjaan(){
        if (mw.getTblPetani_Perawatan_Permintaan().getSelectedRowCount() > 0 && 
                mw.getTblPekerjaanKebun_Perawatan_Permintaan().getSelectedRowCount() > 0){
            List<PetaniTebu> lsPt = new ArrayList<>();
            List<PekerjaanKebun> lsPk = new ArrayList<>();
            List<PetaniTebu> lsPtBuffer = new ArrayList<>();
            List<PekerjaanKebun> lsPkBuffer = new ArrayList<>();
            JTable tblBuffer = mw.getTblBuffer_Perawatan_Permintaan();
            JTable tblPetani = mw.getTblPetani_Perawatan_Permintaan();
            JTable tblPekerjaan = mw.getTblPekerjaanKebun_Perawatan_Permintaan();
            PetaniTableModel ptm = (PetaniTableModel) tblPetani.getModel();
            PekerjaanKebunTableModel pktm = (PekerjaanKebunTableModel) tblPekerjaan.getModel();
            lsPt = ptm.getContentList();
            lsPk = pktm.getContentList();
            BufferPerawatan_Permintaan_TableModel bpptm = (BufferPerawatan_Permintaan_TableModel) tblBuffer.getModel();
            lsPtBuffer = bpptm.getSelectedPetani();
            lsPkBuffer = bpptm.getSelectedPekerjaan();         
            for (int i = 0; i < tblPetani.getSelectedRows().length; i++){
                for (int j = 0; j < tblPekerjaan.getSelectedRows().length; j++){
                    lsPtBuffer.add(lsPt.get(tblPetani.getSelectedRows()[i]));
                    lsPkBuffer.add(lsPk.get(tblPekerjaan.getSelectedRows()[j]));
                }
            }
            for (int i = 0; i < lsPt.size(); i++){
                for (int j = 0; j < lsPtBuffer.size(); j++){
                    if (lsPt.size() > 0){
                        if (lsPt.get(i).getIdPetani().equals(lsPtBuffer.get(j).getIdPetani())){
                            lsPt.remove(i);
                        }
                    }
                }
            }
            /*
            PetaniTableModel ptm = (PetaniTableModel) tblPetani.getModel();
            lsPt = ptm.getContentList();           
            for (int i = 0; i < tblPetani.getSelectedRows().length; i++){
                lsPtBuffer.add(lsPt.get(tblPetani.getSelectedRows()[i]));
            }
            
            PekerjaanKebunTableModel pktm = (PekerjaanKebunTableModel) tblPekerjaan.getModel();
            lsPk = pktm.getContentList();            
            for (int i = 0; i < tblPekerjaan.getSelectedRows().length; i++){
                lsPkBuffer.add(lsPk.get(tblPekerjaan.getSelectedRows()[i]));
            }
            */
            
            cc.setTableHeaderKelTani(tblBuffer.getTableHeader());
            Perawatan_Permintaan_RowRenderer pprr = new Perawatan_Permintaan_RowRenderer();
            tblBuffer.setDefaultRenderer(Object.class, pprr);
            bpptm = new BufferPerawatan_Permintaan_TableModel(lsPtBuffer, lsPkBuffer);
            tblBuffer.setModel(bpptm);
            ptm = new PetaniTableModel(lsPt);
            tblPetani.setModel(ptm);
        } else {
            if (mw.getTblPetani_Perawatan_Permintaan().getSelectedRowCount() == 0) cc.showErrorMsg("Perawatan Kebun", "Pilih minimal <b>satu</b> nama petani!");
            if (mw.getTblPekerjaanKebun_Perawatan_Permintaan().getSelectedRowCount() == 0) cc.showErrorMsg("Perawatan Kebun", "Pilih minimal <b>satu</b> pekerjaan perawatan kebun!");
        }
    }
    
    public void resetForm(){
        mw.getTblKelTani_Perawatan_Permintaan().clearSelection();
        mw.getTblPetani_Perawatan_Permintaan().clearSelection();
        mw.getTblBuffer_Perawatan_Permintaan().clearSelection();
        mw.getTblPekerjaanKebun_Perawatan_Permintaan().clearSelection();
        List<PekerjaanKebun> lsPkKosong = new ArrayList<>();
        List<PetaniTebu> lsPtKosong = new ArrayList<>();
        BufferPerawatan_Permintaan_TableModel bpptm = new BufferPerawatan_Permintaan_TableModel(lsPtKosong, lsPkKosong);
        PekerjaanKebunTableModel pktm = new PekerjaanKebunTableModel(lsPkKosong);
        PetaniTableModel ptmKosong = new PetaniTableModel(lsPtKosong);
        mw.getTblPetani_Perawatan_Permintaan().setModel(ptmKosong);
        mw.getTblBuffer_Perawatan_Permintaan().setModel(bpptm);
        mw.getTblPekerjaanKebun_Perawatan_Permintaan().setModel(pktm);
        mw.getDtpTglTransaksiPerawatan().setDate(null);
        prepareTblPerawatanKelTani();
    }
    
    public void resetDetailForm(){
        mw.getTblDetailPerawatanPermintaan().clearSelection();
        List<DetailPostingTransaksi> lsDpt = new ArrayList<>();
        DetailPostingPerawatan_Permintaan_TableModel dppptm = new DetailPostingPerawatan_Permintaan_TableModel(lsDpt);
        mw.getTblDetailPerawatanPermintaan().setModel(dppptm);
        mw.getLblFrmPosting_NamaKelompok().setText("");
        mw.getLblFrmPosting_NoKontrak().setText("");
    }
    
    public void konfirmasiSimpanData(){
        if (mw.getTblBuffer_Perawatan_Permintaan().getRowCount() > 0 && mw.getDtpTglTransaksiPerawatan().getDate() != null){
            if (JOptionPane.showConfirmDialog(mw, "<html><font face=\"Calibri\" size=4>Apakah Anda yakin akan menyimpan transaksi ini?<br>Cek kembali tabel <b>Permintaan Pekerjaan Perawatan!</b></font></html>", 
                    "Perawatan Kebun", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                BufferPerawatan_Permintaan_TableModel bpptm = (BufferPerawatan_Permintaan_TableModel) mw.getTblBuffer_Perawatan_Permintaan().getModel();
                List<PekerjaanKebun> lsPk = bpptm.getSelectedPekerjaan();
                List<PetaniTebu> lsPt = bpptm.getSelectedPetani();
                List<Transaksi> lsTr = new ArrayList<>();
                SistemDAOSQL sistDao = new SistemDAOSQL();
                int tahunGiling = sistDao.getTahunGiling();
                java.sql.Date tglTransaksi = new java.sql.Date(mw.getDtpTglTransaksiPerawatan().getDate().getTime());
                String idKelompok = lsPt.get(0).getIdKelompok();
                String noBukti = transDao.getNewNomorBuktiTransaksi(idKelompok);
                BuktiTransaksi bk = null ;
                for (int i = 0; i < lsPt.size(); i++){
                    String idPetani = lsPt.get(i).getIdPetani();
                    int idBiaya = lsPk.get(i).getIdPekerjaan();
                    if (transDao.cekDuplikatTransaksiPekerjaan(idPetani, idBiaya)){
                        float luas = lsPt.get(i).getLuas();
                            int biaya = lsPk.get(i).getHarga();
                            int nilaiTransaksi = Math.round(luas*biaya);
                            bk = new BuktiTransaksi(noBukti, cc.getUserId(), cc.getTimestamp());
                            Transaksi tr = new Transaksi(
                                    0, 
                                    idPetani, 
                                    0, 
                                    idBiaya,
                                    0,
                                    tglTransaksi, 
                                    "D", 
                                    luas, 
                                    cc.getUserId(), 
                                    cc.getTimestamp(), 
                                    tahunGiling, 
                                    BigInteger.valueOf(nilaiTransaksi), 
                                    noBukti
                            );
                            lsTr.add(tr);
                    } else {
                        cc.showErrorMsg("Perawatan Kebun", "Sudah ada transaksi atas nama <br><b>" + 
                                    lsPt.get(i).getNamaPetani() + " [" + lsPk.get(i).getNamaPekerjaan() + "] </b>");
                    }
                }
                if (bk != null){
                    if (transDao.insertBatchTransaksi(lsTr, bk)) cc.showInfoMsg("Perawatan Kebun", "Data telah disimpan!<br>Nomor transaksi <b>" + noBukti + "</b>");
                } else {
                    cc.showErrorMsg("Perawatan Kebun", "Data transaksi <b>gagal</b> tersimpan!");
                }
                resetForm();
            }
        } else {
            if (mw.getDtpTglTransaksiPerawatan().getDate() == null) cc.showErrorMsg("Perawatan Kebun", "Tanggal transaksi harus diisi!");
        }
    }
    
    public void populateTblPosting(){
        KelompokTaniTableModel kttm = (KelompokTaniTableModel) mw.getTblKelTani_Perawatan_Permintaan().getModel();
        int selectedIndex = mw.getTblKelTani_Perawatan_Permintaan().getSelectedRow();
        selectedKelTani = kttm.getContentList().get(selectedIndex);
        String idKelompok = selectedKelTani.getIdKelompok();
        mw.getLblFrmPosting_NamaKelompok().setText(selectedKelTani.getNamaKelompok());
        mw.getLblFrmPosting_NoKontrak().setText(selectedKelTani.getNoKontrak());
        //Setting table Master
        JTable tblPosting =  mw.getTblPosting_Perawatan_Permintaan();
        List<Transaksi> lsTrn = transDao.getDataTransaksiByIdKelompokGrouped(idKelompok);
        PostingPerawatan_Permintaan_TableModel ppptm = new PostingPerawatan_Permintaan_TableModel(lsTrn);
        tblPosting.setModel(ppptm);
        PostingPerawatan_Permintaan_RowRenderer ppprr = new PostingPerawatan_Permintaan_RowRenderer();
        tblPosting.setDefaultRenderer(Object.class, ppprr);
        cc.setTableHeaderKelTani(tblPosting.getTableHeader());
        HandlerSeleksiTabel hst = new HandlerSeleksiTabel(mw, "Posting-DetailPosting", tblPosting);
        tblPosting.getSelectionModel().addListSelectionListener(hst);
        //Setting table Detail
        DetailPostingPerawatan_Permintaan_RowRenderer dppprr = new DetailPostingPerawatan_Permintaan_RowRenderer();
        mw.getTblDetailPerawatanPermintaan().setDefaultRenderer(Object.class, dppprr);
        cc.setTableHeaderKelTani(mw.getTblDetailPerawatanPermintaan().getTableHeader());
    }
    
    public void populateDetailPosting(String idDokumen){
        List<DetailPostingTransaksi> lsDpt = transDao.getDetailPostingTransaksiByIdDokumen(idDokumen);
        DetailPostingPerawatan_Permintaan_TableModel dppptm = new DetailPostingPerawatan_Permintaan_TableModel(lsDpt);
        JTable tblDetailPosting = mw.getTblDetailPerawatanPermintaan();
        tblDetailPosting.setModel(dppptm);
        
    }
    
    public void cetakBonDalam(){
        if (mw.getTblPosting_Perawatan_Permintaan().getSelectedRowCount() == 1){
            String idKelompok = selectedKelTani.getIdKelompok();
            PostingPerawatan_Permintaan_TableModel ppptm = (PostingPerawatan_Permintaan_TableModel) mw.getTblPosting_Perawatan_Permintaan().getModel();
            Transaksi transSelected = ppptm.getListTransaksi().get(mw.getTblPosting_Perawatan_Permintaan().getSelectedRow());
            String idDokumen = transSelected.getNomorBuktiTransaksi();
            JasperPrint jp = transDao.cetakBonDalam(idKelompok, idDokumen);
            cc.setLastPage("bon_dalam");
            MenuController mc = new MenuController(mw);
            mc.pageSwitcher(mw.getPnlContent(), "crdPnlCetak");
            cc.setJasperPrint(jp);
            cc.prepareFormCetak(mw.getPnlCetak_Content());
        } else {
            cc.showErrorMsg("Perawatan Kebun", "Pilih salah satu data transaksi!");
        }
    }
    
    public void populateAdminTblBiaya(){
        JTable tblBiaya = mw.getTblMasterBiaya();
        PekerjaanKebunDAOSQL pkDao = new PekerjaanKebunDAOSQL();
        List<Biaya> lsBya = pkDao.getAllBiaya();
        MasterDataBiayaTableModel mdbtt = new MasterDataBiayaTableModel(lsBya);
        cc.setTableHeaderKelTani(tblBiaya.getTableHeader());
        MasterDataBiaya_RowRenderer mdbrr = new MasterDataBiaya_RowRenderer();
        tblBiaya.setDefaultRenderer(Object.class, mdbrr);
        tblBiaya.setModel(mdbtt);
    }
    
    public void populateCbxTahunGiling(){
        SistemDAOSQL sisDao = new SistemDAOSQL();
        int tahunGiling = sisDao.getTahunGiling();
        int tahunGilingDepan = 3;
        mw.getCbxMasterBiaya_TahunGiling().removeAllItems();
        for (int i = 0; i <= tahunGilingDepan; i++){
            String listTg = String.valueOf(tahunGiling + i);
            mw.getCbxMasterBiaya_TahunGiling().addItem(listTg);
        }
        mw.getCbxMasterBiaya_TahunGiling().setSelectedIndex(-1);
    }
    
    public void setFormMasterBiaya(String formStatus){
        switch (formStatus){
            case "view":
                if (mw.getTblMasterBiaya().getSelectedRow() == -1){
                    resetFormMasterBiaya();
                }
                populateCbxTahunGiling();
                HandlerSeleksiTabel hst = new HandlerSeleksiTabel(mw, "MasterBiaya-FormBiaya", mw.getTblMasterBiaya());
                mw.getTblMasterBiaya().getSelectionModel().addListSelectionListener(hst);
                setFormMasterBiaya(false);
                setFormButton(false);
                masterEditStatus = false;
                if (mw.getTblMasterBiaya().getSelectedRow() > -1){
                    MasterDataBiayaTableModel mdbtt = (MasterDataBiayaTableModel) mw.getTblMasterBiaya().getModel();
                    Biaya bya = mdbtt.getContentList().get(mw.getTblMasterBiaya().getSelectedRow());
                    showDetailBiaya(bya);
                }
                break;
            case "add":
                if (mw.getTblMasterBiaya().getSelectedRow() > -1){
                    mw.getJtfMasterBiaya_Harga().setText("");
                    setFormButton(true);
                    setFormMasterBiaya(true); 
                    masterEditStatus = false;
                }
                break;
            case "edit":
                if (mw.getTblMasterBiaya().getSelectedRow() > -1){
                    masterEditStatus = true;
                    setFormMasterBiaya(true);
                    setFormButton(true);
                }
                break;
            case "save":
                if (cekValidasiFormMasterBiaya()){
                    if (masterEditStatus){
                        MasterDataBiayaTableModel mdbtm = (MasterDataBiayaTableModel) mw.getTblMasterBiaya().getModel();
                        int idBiaya = mdbtm.getContentList().get(mw.getTblMasterBiaya().getSelectedRow()).getIdBiaya();
                        PekerjaanKebunDAOSQL pekDao = new PekerjaanKebunDAOSQL();
                        if (pekDao.cekPenggunaanBiaya(idBiaya)){
                            Biaya biaya = new Biaya(
                                    idBiaya, 
                                    mw.getJtfMasterBiaya_KodeBiaya().getText(), 
                                    mw.getCbxMasterBiaya_Kategori().getSelectedItem().toString(), 
                                    mw.getCbxMasterBiaya_JenisBiaya().getSelectedItem().toString(), 
                                    mw.getJtfMasterBiaya_Uraian().getText(), 
                                    mw.getCbxMasterBiaya_Satuan().getSelectedItem().toString(), 
                                    Integer.valueOf(mw.getCbxMasterBiaya_TahunGiling().getSelectedItem().toString()), 
                                    Integer.parseInt(mw.getJtfMasterBiaya_Harga().getText().replaceAll(",", ""))
                            );
                            if (pekDao.updateBiaya(biaya)){
                                cc.showInfoMsg("Master Biaya Produksi", "Perubahan data telah tersimpan!");
                            }
                        } else {
                            cc.showErrorMsg("Master Biaya Produksi", "Data biaya " +
                                    mw.getJtfMasterBiaya_Uraian().getText() + " sudah ada dalam transaksi!<br>Data tersebut tidak dapat diubah.");
                        }
                    } else {
                        Biaya biaya = new Biaya(
                                    0, 
                                    mw.getJtfMasterBiaya_KodeBiaya().getText(), 
                                    mw.getCbxMasterBiaya_Kategori().getSelectedItem().toString(), 
                                    mw.getCbxMasterBiaya_JenisBiaya().getSelectedItem().toString(), 
                                    mw.getJtfMasterBiaya_Uraian().getText(), 
                                    mw.getCbxMasterBiaya_Satuan().getSelectedItem().toString(), 
                                    Integer.valueOf(mw.getCbxMasterBiaya_TahunGiling().getSelectedItem().toString()), 
                                    Integer.parseInt(mw.getJtfMasterBiaya_Harga().getText().replaceAll(",", ""))
                            );
                        PekerjaanKebunDAOSQL pekDao = new PekerjaanKebunDAOSQL();
                        if (pekDao.cekDuplikatBiaya(biaya.getKodeBiaya(), biaya.getTahunGiling())){
                            if (pekDao.insertNewBiaya(biaya)){
                                cc.showInfoMsg("Master Biaya Produksi", "Penambahan data telah tersimpan!");
                            }
                        } else {
                            cc.showErrorMsg("Master Biaya Produksi", "Data biaya <b>" + 
                                    biaya.getNamaBiaya() + "</b> tahun " + biaya.getTahunGiling() + " sudah ada didalam database!");
                        }
                    }
                    resetFormMasterBiaya();
                    setFormMasterBiaya("view");
                    populateAdminTblBiaya();
                } else {
                    cc.showErrorMsg("Master Biaya Produksi", "Cek kembali input data master biaya!");
                }
                break;
        }
    }
    
    public boolean cekValidasiFormMasterBiaya(){
        return !mw.getJtfMasterBiaya_KodeBiaya().getText().isEmpty() &&
                !mw.getJtfMasterBiaya_Uraian().getText().isEmpty() &&
                !mw.getJtfMasterBiaya_Harga().getText().isEmpty() &&
                mw.getCbxMasterBiaya_JenisBiaya().getSelectedIndex() > -1 &&
                mw.getCbxMasterBiaya_Kategori().getSelectedIndex() > -1 &&
                mw.getCbxMasterBiaya_Satuan().getSelectedIndex() > -1 &&
                mw.getCbxMasterBiaya_TahunGiling().getSelectedIndex() > -1;
    }
    
    public boolean cekDuplikasiMasterBiaya(String kodeBiaya, int tahunGiling){
        PekerjaanKebunDAOSQL pekDao = new PekerjaanKebunDAOSQL();
        return pekDao.cekDuplikatBiaya(kodeBiaya, tahunGiling);
    }
    
    public boolean cekPenggunaanBiaya(int idBiaya){
        PekerjaanKebunDAOSQL pekDao = new PekerjaanKebunDAOSQL();
        return pekDao.cekPenggunaanBiaya(idBiaya);
    }
    
    public void setFormButton(boolean buttonStatus){
        if (buttonStatus == true){
            cc.disableButton(mw.getPnlAdminSistem_Biaya_Add());
            cc.disableButton(mw.getPnlAdminSistem_Biaya_Edit());
            cc.enableButton(mw.getPnlAdminSistem_Biaya_Cancel(), mw);
            cc.enableButton(mw.getPnlAdminSistem_Biaya_Save(), mw);
        } else {
            cc.enableButton(mw.getPnlAdminSistem_Biaya_Add(), mw);
            cc.enableButton(mw.getPnlAdminSistem_Biaya_Edit(), mw);
            cc.disableButton(mw.getPnlAdminSistem_Biaya_Cancel());
            cc.disableButton(mw.getPnlAdminSistem_Biaya_Save());
        }
    }
    
    public void setFormMasterBiaya(boolean status){
        //mw.getCbxMasterBiaya_JenisBiaya().setEnabled(status);
        //mw.getCbxMasterBiaya_Kategori().setEnabled(status);
        //mw.getCbxMasterBiaya_Satuan().setEnabled(status);
        mw.getCbxMasterBiaya_TahunGiling().setEnabled(status);
        mw.getJtfMasterBiaya_Harga().setEnabled(status);
        //mw.getJtfMasterBiaya_Uraian().setEnabled(status);
        mw.getTblMasterBiaya().setEnabled(!status);
        // Button
        mw.getPnlAdminSistem_Biaya_Add().setEnabled(!status);
        mw.getPnlAdminSistem_Biaya_Edit().setEnabled(!status);
        mw.getPnlAdminSistem_Biaya_Save().setEnabled(status);
        mw.getPnlAdminSistem_Biaya_Cancel().setEnabled(status);
    }
    
    public void resetFormMasterBiaya(){
        mw.getCbxMasterBiaya_JenisBiaya().setSelectedIndex(-1);
        mw.getCbxMasterBiaya_Kategori().setSelectedIndex(-1);
        mw.getCbxMasterBiaya_Satuan().setSelectedIndex(-1);
        mw.getCbxMasterBiaya_TahunGiling().setSelectedIndex(-1);
        mw.getJtfMasterBiaya_Harga().setText("");
        mw.getJtfMasterBiaya_KodeBiaya().setText("");
        mw.getJtfMasterBiaya_Uraian().setText("");
        populateCbxTahunGiling();
    }
    
    public void showDetailBiaya(Biaya bya){
        mw.getJtfMasterBiaya_KodeBiaya().setText(bya.getKodeBiaya());
        mw.getJtfMasterBiaya_Uraian().setText(bya.getNamaBiaya());
        mw.getJtfMasterBiaya_Harga().setText(cc.formatAngkaUS(bya.getRupiahBiaya(), "#,##0"));
        mw.getCbxMasterBiaya_JenisBiaya().setSelectedItem(bya.getJenisBiaya());
        mw.getCbxMasterBiaya_Kategori().setSelectedItem(bya.getKategori());
        mw.getCbxMasterBiaya_Satuan().setSelectedItem(bya.getSatuan());
        mw.getCbxMasterBiaya_TahunGiling().setSelectedItem(String.valueOf(bya.getTahunGiling()));
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
