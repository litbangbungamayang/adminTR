/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.dao.BahanProduksiDAOSQL;
import id.buma.simtr.model.BahanProduksi;
import id.buma.simtr.view.BahanProduksiRowRenderer;
import id.buma.simtr.view.BahanProduksiTableModel;
import id.buma.simtr.view.MainWindow;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

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
        BahanProduksiRowRenderer bprr = new BahanProduksiRowRenderer();
        tbl.setDefaultRenderer(Object.class, bprr);
        cc.setTableHeaderKelTani(tbl.getTableHeader());
        cc.setTableSelectionModel(tbl);
        BahanProduksiTableModel bptm = new BahanProduksiTableModel(bpDao.getAllBahanProduksi());
        tbl.setModel(bptm);
        HandlerSeleksiTabel hs = new HandlerSeleksiTabel(mw, "BahanProduksi-FormBahanProduksi", tbl);
        tbl.getSelectionModel().addListSelectionListener(hs);
    }
    
    public void loadDetailData(){
        if (bpLokal != null){
            mw.getCbxFrmBahanProduksi_JenisBahan().setSelectedItem(bpLokal.getJenisBahan());
            mw.getJtfFrmBahanProduksi_NamaBahan().setText(bpLokal.getNamaBahan());
            mw.getCbxFrmBahanProduksi_Satuan().setSelectedItem(bpLokal.getSatuan());
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
    
    public void setButtonStatus(boolean buttonStatus){
        if (!buttonStatus){
            disablePanel(mw.getPnlAdminSistem_BahanProduksi_Add());
            disablePanel(mw.getPnlAdminSistem_BahanProduksi_Edit());
            disablePanel(mw.getPnlAdminSistem_BahanProduksi_Delete());
        } else {
            enablePanel(mw.getPnlAdminSistem_BahanProduksi_Add());
            enablePanel(mw.getPnlAdminSistem_BahanProduksi_Edit());
            enablePanel(mw.getPnlAdminSistem_BahanProduksi_Delete());
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
    
    public boolean cekInputForm(){
        return mw.getCbxFrmBahanProduksi_JenisBahan().getSelectedIndex() > -1 &&
                !mw.getJtfFrmBahanProduksi_NamaBahan().getText().equals("") &&
                !mw.getJtfFrmBahanProduksi_Dosis().getText().equals("") &&
                mw.getCbxFrmBahanProduksi_Satuan().getSelectedIndex() > -1 ;
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
                        bpLokal.setDosisPerHa(Float.valueOf(dosisBaru));
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
                                    Float.valueOf(dosisBaru)
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
    
}
