/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.dao.BahanProduksiDAOSQL;
import id.buma.simtr.dao.SistemDAOSQL;
import id.buma.simtr.dao.TransaksiDAOSQL;
import id.buma.simtr.model.BahanProduksi;
import id.buma.simtr.model.Transaksi;
import id.buma.simtr.view.BahanProduksiMasukTableModel;
import id.buma.simtr.view.BahanProduksiTableModel;
import id.buma.simtr.view.MainWindow;
import java.awt.event.MouseListener;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class BahanProduksiController {
    
    private MainWindow mw;
    private final CommonController cc = new CommonController(mw);
    private final BahanProduksiDAOSQL bpDao = new BahanProduksiDAOSQL();
    private static String menuStatus = "";
    private static BahanProduksi bpLokal = null;
    
    public BahanProduksiController(MainWindow mw){
        this.mw = mw;
    }
    
    public void setBahanProduksi(BahanProduksi bp){
        BahanProduksiController.bpLokal = bp;
    }
    
    public void prepareTblBahanProduksi(JTable tbl){
        cc.setTableSelectionModel(tbl);
        BahanProduksiTableModel bptm = new BahanProduksiTableModel(bpDao.getAllBahanProduksi());
        tbl.setModel(bptm);
        HandlerSeleksiTabel hs = new HandlerSeleksiTabel(mw, "BahanProduksi-FormBahanProduksi", tbl);
        tbl.getSelectionModel().addListSelectionListener(hs);
    }
    
    public void prepareTblBahanProduksiMasuk(JTable tbl){
        cc.setTableSelectionModel(tbl);
        BahanProduksiTableModel bptm  = (BahanProduksiTableModel) mw.getTblBahanProduksi().getModel();
        List<BahanProduksi> lsBp = bptm.getContentList();
        int idBahan = lsBp.get(mw.getTblBahanProduksi().getSelectedRow()).getIdBahan();
        TransaksiDAOSQL transDao = new TransaksiDAOSQL();
        BahanProduksiMasukTableModel bpmtm = new BahanProduksiMasukTableModel(transDao.cekStokBahanProduksi(idBahan));
        tbl.setModel(bpmtm);
    }
    
    public void prepareTableHeader(JTable tbl, TableCellRenderer tcr){
        tbl.setDefaultRenderer(Object.class, tcr);
        cc.setTableHeaderKelTani(tbl.getTableHeader());
    }
    
    public void loadDetailData(){
        if (bpLokal != null){
            mw.getCbxFrmBahanProduksi_JenisBahan().setSelectedItem(bpLokal.getJenisBahan());
            mw.getJtfFrmBahanProduksi_NamaBahan().setText(bpLokal.getNamaBahan());
            mw.getCbxFrmBahanProduksi_Satuan().setSelectedItem(bpLokal.getSatuan());
            mw.getCbxFrmBahanProduksi_SatuanMasuk().setSelectedItem(bpLokal.getSatuan());
            mw.getJtfFrmBahanProduksi_Dosis().setText(String.valueOf(bpLokal.getDosisPerHa()));
        }
    }
    
    public void setFormStatus(boolean formStatus){
        mw.getCbxFrmBahanProduksi_JenisBahan().setEnabled(formStatus);
        mw.getJtfFrmBahanProduksi_NamaBahan().setEnabled(formStatus);
        mw.getJtfFrmBahanProduksi_Dosis().setEnabled(formStatus);
        mw.getCbxFrmBahanProduksi_Satuan().setEnabled(formStatus);
        if (formStatus){
            enablePanel(mw.getPnlAdminSistem_BahanProduksi_Cancel());
            enablePanel(mw.getPnlAdminSistem_BahanProduksi_Save());
        } else {
            resetInput();
            disablePanel(mw.getPnlAdminSistem_BahanProduksi_Cancel());
            disablePanel(mw.getPnlAdminSistem_BahanProduksi_Save());
        }
    }
    
    public void setFormBahanMasukStatus(boolean formMasukStatus){
        mw.getJtfFrmBahanProduksi_KuantaMasuk().setEnabled(formMasukStatus);
        mw.getJtfFrmBahanProduksi_NilaiMasuk().setEnabled(formMasukStatus);
        mw.getJtfFrmBahanProduksi_NoKontrak().setEnabled(formMasukStatus);
        if (formMasukStatus){
            enablePanel(mw.getPnlAdminSistem_BahanProduksi_CancelMasuk());
            enablePanel(mw.getPnlAdminSistem_BahanProduksi_SaveMasuk());
        } else {
            resetInputBahanMasuk();
            mw.getCbxFrmBahanProduksi_SatuanMasuk().setSelectedIndex(-1);
            mw.getJtfFrmBahanProduksi_KuantaMasuk().setText("");
            mw.getJtfFrmBahanProduksi_NilaiMasuk().setText("");
            mw.getJtfFrmBahanProduksi_NoKontrak().setText("");
            disablePanel(mw.getPnlAdminSistem_BahanProduksi_CancelMasuk());
            disablePanel(mw.getPnlAdminSistem_BahanProduksi_SaveMasuk());
        }
    }
    
    public void setButtonStatus(boolean buttonStatus){
        if (!buttonStatus){
            disablePanel(mw.getPnlAdminSistem_BahanProduksi_Add());
            disablePanel(mw.getPnlAdminSistem_BahanProduksi_Edit());
            disablePanel(mw.getPnlAdminSistem_BahanProduksi_Delete());
            disablePanel(mw.getPnlAdminSistem_BahanProduksi_AddMasuk());
        } else {
            enablePanel(mw.getPnlAdminSistem_BahanProduksi_Add());
            enablePanel(mw.getPnlAdminSistem_BahanProduksi_Edit());
            enablePanel(mw.getPnlAdminSistem_BahanProduksi_Delete());
            enablePanel(mw.getPnlAdminSistem_BahanProduksi_AddMasuk());
        }
    }
    
    public void disablePanel(JPanel pnl){
        if (pnl.getMouseListeners().length == 1){
            MouseListener ml = pnl.getMouseListeners()[0];
            pnl.removeMouseListener(ml);
        }
    }
    
    public void enablePanel(JPanel pnl){
        MenuController mc = new MenuController(mw);
        pnl.addMouseListener(mc);
    }
    
    public void resetInput(){
        mw.getCbxFrmBahanProduksi_JenisBahan().setSelectedIndex(-1);
        mw.getJtfFrmBahanProduksi_NamaBahan().setText("");
        mw.getJtfFrmBahanProduksi_Dosis().setText("");
        mw.getCbxFrmBahanProduksi_Satuan().setSelectedIndex(-1);
    }
    
    public void resetInputBahanMasuk(){
        mw.getJtfFrmBahanProduksi_KuantaMasuk().setText("");
        mw.getJtfFrmBahanProduksi_NilaiMasuk().setText("");
        mw.getJtfFrmBahanProduksi_NoKontrak().setText("");
    }
    
    public boolean cekInputForm(){
        return mw.getCbxFrmBahanProduksi_JenisBahan().getSelectedIndex() > -1 &&
                !mw.getJtfFrmBahanProduksi_NamaBahan().getText().equals("") &&
                !mw.getJtfFrmBahanProduksi_Dosis().getText().equals("") &&
                mw.getCbxFrmBahanProduksi_Satuan().getSelectedIndex() > -1 ;
    }
    
    public boolean cekInputBahanMasukForm(){
        return !mw.getJtfFrmBahanProduksi_KuantaMasuk().getText().equals("") &&
                !mw.getJtfFrmBahanProduksi_NilaiMasuk().getText().equals("") &&
                !mw.getJtfFrmBahanProduksi_NoKontrak().getText().equals("");
    }
    
    public void setMode(String inputStatusMenu){
        switch (inputStatusMenu){
            case "edit":
                setFormStatus(true);
                setButtonStatus(false);
                mw.getTblBahanProduksi().setEnabled(false);
                mw.getCbxFrmBahanProduksi_JenisBahan().setEnabled(false);
                menuStatus = "edit";
                break;
            case "cancel":
                setFormStatus(false);
                setFormBahanMasukStatus(false);
                setButtonStatus(true);
                mw.getTblBahanProduksi().setEnabled(true);
                mw.getTblBahanProduksi().clearSelection();
                prepareTblBahanProduksi(mw.getTblBahanProduksi());
                break;
            case "add":
                setFormStatus(true);
                setButtonStatus(false);
                resetInput();
                menuStatus = "add";
                mw.getTblBahanProduksi().setEnabled(false);
                mw.getCbxFrmBahanProduksi_JenisBahan().requestFocus();
                break;
            case "save":
                if (menuStatus.equals("edit")){
                    if (cekInputForm()){
                        String namaLama = bpLokal.getNamaBahan();
                        String jenisLama = bpLokal.getJenisBahan();
                        Float dosisLama = bpLokal.getDosisPerHa();
                        String satuanLama = bpLokal.getSatuan();
                        String namaBaru = mw.getJtfFrmBahanProduksi_NamaBahan().getText();
                        String jenisBaru = mw.getCbxFrmBahanProduksi_JenisBahan().getSelectedItem().toString();
                        String dosisBaru = mw.getJtfFrmBahanProduksi_Dosis().getText();
                        String satuanBaru = mw.getCbxFrmBahanProduksi_Satuan().getSelectedItem().toString();
                        bpLokal.setJenisBahan(jenisBaru);
                        bpLokal.setNamaBahan(namaBaru);
                        bpLokal.setDosisPerHa(Float.valueOf(dosisBaru.replaceAll(",", "")));
                        bpLokal.setSatuan(satuanBaru);
                        if (JOptionPane.showConfirmDialog(mw, "Anda akan mengubah data bahan produksi : \n" +
                                "[" + jenisLama + "]" + " " + namaLama + " (" + dosisLama + ") " + satuanLama + "/Ha \nmenjadi \n" +
                                "[" + jenisBaru + "]" + " " + namaBaru + " (" + dosisBaru + ") " + satuanBaru + "/Ha", 
                                "Konfirmasi Bahan Produksi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                            if (bpDao.cekBahanProduksiDigunakan(bpLokal.getIdBahan()) && bpDao.updateBahan(bpLokal)){
                                cc.showInfoMsg("Bahan Produksi", "Data berhasil diperbarui.");
                                menuStatus = "";
                                bpLokal = null;
                                setMode("cancel");
                            } else {
                                if (!bpDao.cekBahanProduksiDigunakan(bpLokal.getIdBahan())){
                                    cc.showErrorMsg("Bahan Produksi", "Sudah ada transaksi bahan atas nama bahan " + namaLama + 
                                            "! \n Anda tidak dapat mengubah atau menghapus bahan tersebut.");
                                    setMode("cancel");
                                    menuStatus = "";
                                    bpLokal = null;
                                }
                            }
                        }
                    } else {
                        cc.showErrorMsg("Bahan Produksi", "Cek kembali form bahan produksi! \nSemua data harus terisi.");
                    }
                } else {
                    if (menuStatus.equals("add")){
                        if (cekInputForm()){
                            String namaBaru = mw.getJtfFrmBahanProduksi_NamaBahan().getText();
                            String jenisBaru = mw.getCbxFrmBahanProduksi_JenisBahan().getSelectedItem().toString();
                            String dosisBaru = mw.getJtfFrmBahanProduksi_Dosis().getText();
                            String satuanBaru = mw.getCbxFrmBahanProduksi_Satuan().getSelectedItem().toString();
                            bpLokal = new BahanProduksi(0, 
                                    jenisBaru, 
                                    namaBaru, 
                                    satuanBaru, 
                                    Float.valueOf(dosisBaru.replaceAll(",", ""))
                            );
                            if (JOptionPane.showConfirmDialog(mw, "Anda akan menambah data bahan produksi : \n" +
                                    "[" + jenisBaru + "]" + " " + namaBaru + " (" + dosisBaru + ") " + satuanBaru + "/Ha", 
                                    "Konfirmasi Bahan Produksi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                                if (bpDao.insertNewBahan(bpLokal)){
                                    cc.showInfoMsg("Bahan Produksi", "Data berhasil ditambahkan.");
                                    menuStatus = "";
                                    setMode("cancel");
                                }
                            }
                        } else {
                            cc.showErrorMsg("Bahan Produksi", "Cek kembali form bahan produksi! \nSemua data harus terisi.");
                        }
                    }
                }
                break;
            case "delete":
                if (JOptionPane.showConfirmDialog(mw, "Anda akan menghapus data bahan produksi " + bpLokal.getNamaBahan(), 
                                    "Konfirmasi Bahan Produksi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    if (bpDao.cekBahanProduksiDigunakan(bpLokal.getIdBahan())){
                        if (bpDao.deleteBahan(bpLokal.getIdBahan())){
                            cc.showInfoMsg("Bahan Produksi", "Data berhasil dihapus!");
                            menuStatus = "";
                            bpLokal = null;
                            setMode("cancel");
                        }
                    } else {
                        cc.showErrorMsg("Bahan Produksi", "Sudah ada transaksi bahan atas nama bahan " + bpLokal.getNamaBahan() + 
                                                "! \n Anda tidak dapat mengubah atau menghapus bahan tersebut.");
                        setMode("cancel");
                        menuStatus = "";
                        bpLokal = null;
                    }
                }
                
                break;
        }
    }
    
    public void saveBahanMasuk(){
        if (cekInputBahanMasukForm()){
            int idBahan;
            int idUser;
            int tahunGiling;
            SistemDAOSQL sisDao = new SistemDAOSQL();
            tahunGiling = sisDao.getTahunGiling();
            idUser = CommonController.user.getUserId();
            BahanProduksiTableModel bptm = (BahanProduksiTableModel) mw.getTblBahanProduksi().getModel();
            List<BahanProduksi> lsBp = bptm.getContentList();
            idBahan = lsBp.get(mw.getTblBahanProduksi().getSelectedRow()).getIdBahan();
            java.sql.Timestamp postingTimestamp = new java.sql.Timestamp(new java.util.Date().getTime());
            java.sql.Date tglTransaksi = new java.sql.Date(new java.util.Date().getTime());
            String noKontrak = mw.getJtfFrmBahanProduksi_NoKontrak().getText();
            int kuantaMasuk = Integer.parseInt(mw.getJtfFrmBahanProduksi_KuantaMasuk().getText().replaceAll(",", ""));
            Transaksi tp = new Transaksi(
                    0, 
                    "NN", 
                    idBahan,
                    0,
                    0,
                    tglTransaksi, 
                    "K",
                    Float.valueOf(kuantaMasuk), 
                    idUser, 
                    postingTimestamp, 
                    tahunGiling, 
                    new BigInteger(mw.getJtfFrmBahanProduksi_NilaiMasuk().getText().replaceAll(",", "")),
                    noKontrak
            );
            TransaksiDAOSQL transDao = new TransaksiDAOSQL();
            if (transDao.insertNewTransaksiPupuk(tp)){
                setMode("cancel");
                cc.showInfoMsg("Bahan Produksi", "Data berhasil ditambahkan!");
            }
        } else {
            if (mw.getJtfFrmBahanProduksi_KuantaMasuk().getText().equals("")) cc.showErrorMsg("Bahan Produksi", "Kuanta bahan masuk harus diisi!");
            if (mw.getJtfFrmBahanProduksi_NilaiMasuk().getText().equals("")) cc.showErrorMsg("Bahan Produksi", "Nilai bahan masuk harus diisi!");
            if (mw.getJtfFrmBahanProduksi_NoKontrak().getText().equals("")) cc.showErrorMsg("Bahan Produksi", "Nomor Kontrak harus diisi!");
        }
    }
    
    public void resetTable(JTable tbl){
        DefaultTableModel dtm = new DefaultTableModel();
        tbl.setModel(dtm);
    }
    
}
