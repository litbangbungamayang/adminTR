/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.view.BahanProduksiMasukRowRenderer;
import id.buma.simtr.view.BahanProduksiRowRenderer;
import id.buma.simtr.view.MainWindow;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class MenuController implements MouseListener{
    
    private MainWindow mw;
    
    public MenuController (MainWindow mw){
        this.mw = mw;
    }
    
    public void pageSwitcher(JPanel containerName, String cardName){
        CardLayout cl = (CardLayout) containerName.getLayout();
        cl.show(containerName, cardName);
    }
    
    public void changeMenuNav(String position){
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        CommonController cc = new CommonController(mw);
        RDKKController rc = new RDKKController(mw);
        PupukController pc = new PupukController(mw);
        UserController uc = new UserController(mw);
        PerawatanController pwc = new PerawatanController(mw);
        BahanProduksiController bpc = new BahanProduksiController(mw);
        TebanganController tc = new TebanganController(mw);
        mw.repaint();
        JPanel menuPanel = (JPanel) e.getSource();
        String menuPanelName = menuPanel.getName();
        switch(menuPanelName){
            case "pnlLoginLogin":
                if (cc.cekLogin()) pageSwitcher(mw.getPnlContent(), "crdPnlMenuUtama");
                break;
            case "pnlLoginKeluar":
                System.exit(0);
                break;
            case "pnlBackground":
                mw.getPnlSubMenuHolder().setVisible(false);
                break;
            case "pnlMenuRDKK":
                mw.getPnlSubMenuHolder().setVisible(true);
                pageSwitcher(mw.getPnlSubMenuHolder(), "crdSubMenuRDKK");
                break;
                case "pnlWsRDKK":
                    mw.getPnlSubMenuHolder().setVisible(true);
                    pageSwitcher(mw.getPnlContent(), "crdFrmInputRDKK");
                    pageSwitcher(mw.getPnlFrmInputRDKK_ContainerInputPetani(), "crdInputPetani_Blank");
                    changeMenuNav("Pendaftaran RDKK Baru");
                    cc.populateComboBox(mw.getCbxFrmInputRDKK_Afdeling(), uc.namaAfdelingList());
                    rc.clearInputKoordinator();
                    break;
                    case "pnlFrmInputRDKK_Back":
                        mw.getPnlSubMenuHolder().setVisible(false);
                        pageSwitcher(mw.getPnlContent(), "crdPnlMenuUtama");
                        changeMenuNav("");
                        break;
                    case "pnlFrmInputRDKK_LanjutKoord":
                        if (rc.validasiKoordinatorBaru() == true){
                            rc.statusIsianKoord(false);
                            pageSwitcher(mw.getPnlFrmInputRDKK_ContainerInputPetani(), "crdInputPetani_Table");
                            cc.prepareTableInputPetani(mw.getTblInputPetani());
                        }
                        break;
                    case "pnlFrmInputRDKK_BatalKoord":
                        if (JOptionPane.showConfirmDialog(null, "Anda yakin akan membatalkan input Draft RDKK?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                            rc.clearInputKoordinator();
                            pageSwitcher(mw.getPnlFrmInputRDKK_ContainerInputPetani(), "crdInputPetani_Blank");
                            mw.getJtfInputRDKKNamaKoord().requestFocus();
                        }
                        break;
                    case "pnlFrmInputRDKK_TambahPetani":
                        if (rc.validasiInputPetani() == true){
                            rc.insertBufferPetani();
                            rc.insertBufferKoordinat();
                            rc.clearInputPetani();
                            mw.getJtfInputRDKKNamaPetani().requestFocus();
                        }
                        break;
                    case "pnlFrmInputRDKK_Hapus":
                        if (mw.getTblInputPetani().getSelectedRow() > -1){
                            rc.hapusBarisTabelPetani(mw.getTblInputPetani().getSelectedRow());
                            mw.getJtfInputRDKKNamaPetani().requestFocus();
                        }
                        break;
                    case "pnlFrmInputRDKK_SimpanData":
                        rc.konfirmasiSimpanDataBatch();
                        break;
                case "pnlVerifikasiRdkk":
                    pageSwitcher(mw.getPnlContent(), "crdFrmValidasiRDKK");
                    changeMenuNav("Validasi RDKK");
                    rc.refreshTableValidasiRDKK();
                    break;
                    case "pnlFrmValidasiRDKK_Back":
                        mw.getPnlSubMenuHolder().setVisible(false);
                        pageSwitcher(mw.getPnlContent(), "crdPnlMenuUtama");
                        break;
                    case "pnlFrmValidasiRDKK_ClearKoord":
                        mw.getJtfFrmValidasiRDKK_SearchKoord().setText("");
                        rc.refreshTableValidasiRDKK();
                        rc.resetTablePetani(mw.getTblValidasiRDKK_Petani());
                        break;
                    case "pnlFrmValidasiRDKK_CetakDraft":
                        rc.cetakKontrak(mw.getTblValidasiRDKK());
                        break;
                    case "pnlFrmValidasiRDKK_CetakSKK":
                        rc.cetakBaSKK(mw.getTblValidasiRDKK());
                        break;
            //******************* MENU PERAWATAN
            case "pnlMenuPerawatan":
                mw.getPnlSubMenuHolder().setVisible(true);
                pageSwitcher(mw.getPnlSubMenuHolder(), "crdSubMenuPerawatan");
                break;
                case "pnlSubMenuPerawatan_Permintaan":
                    mw.getPnlSubMenuHolder().setVisible(false);
                    pageSwitcher(mw.getPnlContent(), "crdFrmPerawatan_Permintaan");
                    pwc.prepareTblPerawatanKelTani();
                    pwc.prepareTblPerawatanPetani();
                    break;
                    case "pnlFrmPerawatan_Permintaan_Tambah":
                        pwc.populateTblBufferPekerjaan();
                        break;
                    case "pnlFrmPerawatan_Permintaan_Simpan":
                        pwc.konfirmasiSimpanData();
                        break;
                    case "pnlFrmPerawatan_Permintaan_Back":
                        pwc.resetForm();
                        pageSwitcher(mw.getPnlContent(),"crdPnlMenuUtama");
                        break;
                    case "pnlFrmPerawatan_Permintaan_LihatData":
                        if (mw.getTblKelTani_Perawatan_Permintaan().getSelectedRow() > -1){
                            pageSwitcher(mw.getPnlContent(), "crdFrmPerawatan_BonDalam");
                            pwc.populateTblPosting();
                        } else {
                            cc.showErrorMsg("Perawatan Kebun", "Pilih dulu salah satu kelompok tani!");
                        }
                        break;
                        case "pnlFrmPerawatan_BonDalam_Back":
                            pwc.resetDetailForm();
                            pageSwitcher(mw.getPnlContent(), "crdFrmPerawatan_Permintaan");
                            break;
                        case "pnlFrmPerawatan_Permintaan_CetakBon":
                            pwc.cetakBonDalam();
                            break;
                case "pnlSubMenuPerawatan_Evaluasi":
                    break;
            //*******************************
            //******************** MENU PUPUK
            case "pnlMenuPupuk":
                mw.getPnlSubMenuHolder().setVisible(true);
                pageSwitcher(mw.getPnlSubMenuHolder(), "crdSubMenuPupuk");
                break;
                case "pnlSubMenuPupuk_Permintaan":
                    pageSwitcher(mw.getPnlContent(), "crdFrmPupuk_Permintaan");
                    pc.prepareTablePupukKelTani();
                    pc.prepareTablePupukPetani();
                    pc.prepareTablePupukJenisPupuk();
                    pc.prepareDatePicker();
                    break;
                    case "pnlFrmPupuk_Permintaan_Kembali":
                        mw.getPnlSubMenuHolder().setVisible(false);
                        pageSwitcher(mw.getPnlContent(), "crdPnlMenuUtama");
                        break;
                    case "pnlFrmPupuk_Permintaan_Clear":
                        mw.getJtfFrmPupuk_Permintaan_Cari().setText("");
                        pc.prepareTablePupukKelTani();
                        break;
                    case "pnlFrmPupuk_Permintaan_TambahPupuk":
                        pc.getDaftarPetaniDanPupuk(mw.getTblPupukPetani(), mw.getTblJenisPupuk_Pupuk_Permintaan());
                        break;
                    case "pnlFrmPupuk_Permintaan_SimpanData":
                        pc.insertNewTransaksiPupuk();
                        break;
                    case "pnlFrmPupuk_Permintaan_CetakPermintaan":
                        pc.cetakPermintaanPupuk(mw.getTblPupukKelTani());
                        break;
                case "pnlSubMenuPupuk_EvaluasiBiayaPupuk":
                    pageSwitcher(mw.getPnlContent(), "crdFrmPupuk_EvaluasiBiayaPupuk");
                    cc.populateComboBox(mw.getCbxFrmPupuk_EvaluasiBiayaPupuk(), uc.namaAfdelingList());
                    pc.prepareFrmEvaluasiPupuk();
                    break;
                    case "pnlFrmPupuk_EvaluasiBiayaPupuk_Back":
                        pc.resetFormEvaluasiPupuk();
                        pageSwitcher(mw.getPnlContent(), "crdPnlMenuUtama");
                        mw.getPnlSubMenuHolder().setVisible(false);
                        break;
                    case "pnlFrmPupuk_EvaluasiBiayaPupuk_View":
                        pc.cetakEvaluasiPupuk();
                        break;
            //*********************************
            //******************** MENU TMA
            case "pnlMenuTMA":
                mw.getPnlSubMenuHolder().setVisible(true);
                pageSwitcher(mw.getPnlSubMenuHolder(), "crdSubMenuTMA");
                break;
                case "pnlSubMenuTMA_Rekap":
                    mw.getPnlSubMenuHolder().setVisible(false);
                    pageSwitcher(mw.getPnlContent(), "crdFrmTMA");
                    tc.prepareTableTMAKelTani();
                    break;
                case "pnlFrmTMA_Back":
                    pageSwitcher(mw.getPnlContent(), "crdPnlMenuUtama");
                    break;
                case "pnlFrmTMAPosting":
                    tc.konfirmasiPostingData();
                    break;
                case "pnlFrmTMALihat":
                    break;
            case "pnlMenuPBH":
                mw.getPnlSubMenuHolder().setVisible(false);
                break;
            /*** MENU ADMIN ***/
            case "pnlMenuAdmin":
                if (CommonController.user.getPrivLevel() == 1){
                    mw.getPnlSubMenuHolder().setVisible(true);
                    pageSwitcher(mw.getPnlSubMenuHolder(), "crdSubMenuAdmin");
                } else {
                    cc.showErrorMsg("Main Menu", "Anda tidak memiliki hak akses untuk menu ini!");
                    mw.getPnlSubMenuHolder().setVisible(false);
                }
                break;
                case "pnlSubMenuAdmin_UserData":
                    pageSwitcher(mw.getPnlContent(), "crdPnlAdminSistem_UserData");
                    mw.getPnlSubMenuHolder().setVisible(false);
                    uc.setStatusForm(false);
                    uc.prepareTableUser(mw.getTblUserData());
                    cc.populateComboBox(mw.getCbxFrmUserData_Afdeling(), uc.namaAfdelingList());
                    break;
                    case "pnlAdminSistem_Kembali":
                        pageSwitcher(mw.getPnlContent(), "crdPnlMenuUtama");
                        break;
                    case "pnlAdminSistem_EditUser":
                        if (mw.getTblUserData().getSelectedRowCount() == 1){
                            uc.setMenuButton("edit");
                        }
                        break;
                    case "pnlAdminSistem_DeleteUser":
                        if (mw.getTblUserData().getSelectedRowCount() == 1){
                            uc.setMenuButton("delete");
                        }
                        break;
                    case "pnlAdminSistem_AddUser":
                        uc.setMenuButton("add");
                        break;
                    case "pnlAdminSistem_Cancel":
                        uc.setMenuButton("cancel");
                        break;
                    case "pnlAdminSistem_Save":
                        uc.saveUpdateData();
                        break;
                case "pnlSubMenuAdmin_BahanProduksi":
                    pageSwitcher(mw.getPnlContent(),"crdPnlAdminSistem_BahanProduksi");
                    mw.getPnlSubMenuHolder().setVisible(false);
                    bpc.prepareTblBahanProduksi(mw.getTblBahanProduksi());
                    bpc.setFormStatus(false);
                    bpc.setFormBahanMasukStatus(false);
                    BahanProduksiMasukRowRenderer bpmrr = new BahanProduksiMasukRowRenderer();
                    BahanProduksiRowRenderer bprr = new BahanProduksiRowRenderer();
                    bpc.prepareTableHeader(mw.getTblBahanProduksi(),bprr);
                    bpc.prepareTableHeader(mw.getTblMonitorBahanMasuk(),bpmrr);
                    break;
                    case "pnlAdminSistem_BahanProduksi_Kembali":
                        pageSwitcher(mw.getPnlContent(), "crdPnlMenuUtama");
                        bpc.setMode("cancel");
                        break;
                    case "pnlAdminSistem_BahanProduksi_Edit":
                        if (mw.getTblBahanProduksi().getSelectedRowCount() > 0)
                            bpc.setMode("edit");
                        break;
                    case "pnlAdminSistem_BahanProduksi_Add":
                        bpc.setMode("add");
                        break;
                    case "pnlAdminSistem_BahanProduksi_Delete":
                        if (mw.getTblBahanProduksi().getSelectedRowCount() > 0)
                            bpc.setMode("delete");
                        break;
                    case "pnlAdminSistem_BahanProduksi_Cancel":
                        bpc.setMode("cancel");
                        break;
                    case "pnlAdminSistem_BahanProduksi_Save":
                        bpc.setMode("save");
                        break;
                    case "pnlAdminSistem_BahanProduksi_CancelMasuk":
                        bpc.setMode("cancel");
                        break;
                    case "pnlAdminSistem_BahanProduksi_SaveMasuk":
                        bpc.saveBahanMasuk();
                        bpc.resetTable(mw.getTblMonitorBahanMasuk());
                        break;
                    case "pnlAdminSistem_BahanProduksi_AddMasuk":
                        if (mw.getTblBahanProduksi().getSelectedRowCount() == 1){ 
                            bpc.setFormBahanMasukStatus(true);
                            bpc.setButtonStatus(false);
                            mw.getJtfFrmBahanProduksi_KuantaMasuk().requestFocus();
                        }
                        break;
                case "pnlSubMenuAdmin_Biaya":
                    pageSwitcher(mw.getPnlContent(), "crdPnlAdminSistem_Biaya");
                    mw.getPnlSubMenuHolder().setVisible(false);
                    pwc.populateAdminTblBiaya();
                    pwc.setFormMasterBiaya("view");
                    break;
                    case "pnlAdminSistem_Biaya_Back":
                        pageSwitcher(mw.getPnlContent(), "crdPnlMenuUtama");
                        break;
                    case "pnlAdminSistem_Biaya_Add":
                        pwc.setFormMasterBiaya("add");
                        break;
                    case "pnlAdminSistem_Biaya_Edit":
                        pwc.setFormMasterBiaya("edit");
                        break;
                    case "pnlAdminSistem_Biaya_Cancel":
                        pwc.setFormMasterBiaya("view");
                        break;
                    case "pnlAdminSistem_Biaya_Save":
                        pwc.setFormMasterBiaya("save");
                        break;
            /******************/
            case "pnlMenuKeluar":
                System.exit(0);
                break;
            case "pnlCetak_Kembali":
                switch(cc.getLastPage()){
                    case "validasi_rdkk":
                        pageSwitcher(mw.getPnlContent(), "crdFrmValidasiRDKK");
                        cc.setLastPage(null);
                        break;
                    case "permintaan_pupuk":
                        pageSwitcher(mw.getPnlContent(), "crdFrmPupuk_Permintaan");
                        cc.setLastPage(null);
                        break;
                    case "evaluasi_pupuk":
                        pageSwitcher(mw.getPnlContent(), "crdFrmPupuk_EvaluasiBiayaPupuk");
                        cc.setLastPage(null);
                        break;
                    case "bon_dalam":
                        pageSwitcher(mw.getPnlContent(), "crdFrmPerawatan_BonDalam");
                        cc.setLastPage(null);
                        break;
                }
                break;
            case "pnlCetak_Cetak":
                switch(cc.getLastPage()){
                    case "validasi_rdkk":
                        rc.preparePrint();
                        break;
                    case "permintaan_pupuk":
                        pc.cetakPrinter();
                        //cc.testFlavor();
                        break;
                }
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    public void standarButtonHover(JPanel menuPanel){
        menuPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuPanel.setBackground(new Color(255,255,255,180));
    }
    
    public void standarMainMenuHover(JPanel menuPanel){
        menuPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuPanel.setBackground(new Color(34,59,14,150));
    }
    
    public void standarMainMenuDisplayed(JPanel menuPanel){
        menuPanel.setBackground(new Color(34,59,14,50));
    }
    
    public void standarButtonDisplayed(JPanel menuPanel){
        menuPanel.setBackground(new Color(255,255,255,0));
    }
    
    public void disableButton(JPanel buttonPanel, String buttonType){
        if (buttonPanel.getMouseListeners().length == 1){
            MouseListener ml = buttonPanel.getMouseListeners()[0];
            buttonPanel.removeMouseListener(ml);
            standarButtonHover(buttonPanel);
        }
    }
    
    public void enableButton(JPanel buttonPanel){
        buttonPanel.addMouseListener(this);
        standarButtonDisplayed(buttonPanel);
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        mw.repaint();
        JPanel menuPanel = (JPanel) e.getSource();
        String menuPanelName = menuPanel.getName();
        switch(menuPanelName){
            case "pnlLoginKeluar":
                standarButtonHover(menuPanel);
                break;
            case "pnlLoginLogin":
                standarButtonHover(menuPanel);
                break;
            case "pnlMenuRDKK":
                menuPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menuPanel.setBackground(new Color(34,59,14,150));
                break;
                case "pnlWsRDKK":
                    menuPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    menuPanel.setBackground(new Color(34,59,14,150));
                    break;
                    case "pnlFrmInputRDKK_Back":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmInputRDKK_LanjutKoord":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmInputRDKK_BatalKoord":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmInputRDKK_TambahPetani":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmInputRDKK_Hapus":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmInputRDKK_SimpanData" :
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmRDKKClearSearch":
                        menuPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        menuPanel.setBackground(new Color(198,213,213));
                        break;
                case "pnlVerifikasiRdkk":
                    standarMainMenuHover(menuPanel);
                    break;
                    case "pnlFrmValidasiRDKK_Back":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmValidasiRDKK_ClearKoord":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmValidasiRDKK_EditData":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmValidasiRDKK_CetakDraft":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmValidasiRDKK_CetakSKK":
                        standarButtonHover(menuPanel);
                        break;
            case "pnlMenuPerawatan":
                standarMainMenuHover(menuPanel);
                break;
                case "pnlSubMenuPerawatan_Permintaan":
                    standarMainMenuHover(menuPanel);
                    break;
                    case "pnlFrmPerawatan_Permintaan_Back":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmPerawatan_Permintaan_Tambah":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmPerawatan_Permintaan_Simpan":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmPerawatan_Permintaan_LihatData":
                        standarButtonHover(menuPanel);
                        break;
                        case "pnlFrmPerawatan_BonDalam_Back":
                            standarButtonHover(menuPanel);
                            break;
                        case "pnlFrmPerawatan_Permintaan_CetakBon":
                            standarButtonHover(menuPanel);
                            break;
                case "pnlSubMenuPerawatan_Evaluasi":
                    standarMainMenuHover(menuPanel);
                    break;
            case "pnlMenuPupuk":
                standarMainMenuHover(menuPanel);
                break;
                case  "pnlSubMenuPupuk_Permintaan":
                    standarMainMenuHover(menuPanel);
                    break;
                    case "pnlFrmPupuk_Permintaan_Kembali":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmPupuk_Permintaan_Clear":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmPupuk_Permintaan_TambahPupuk":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmPupuk_Permintaan_SimpanData":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmPupuk_Permintaan_CetakPermintaan":
                        standarButtonHover(menuPanel);
                        break;
                case "pnlSubMenuPupuk_EvaluasiBiayaPupuk":
                    standarMainMenuHover(menuPanel);
                    break;
                    case "pnlFrmPupuk_EvaluasiBiayaPupuk_Back":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlFrmPupuk_EvaluasiBiayaPupuk_View":
                        standarButtonHover(menuPanel);
                        break;
            case "pnlMenuTMA":
                standarMainMenuHover(menuPanel);
                break;
                case "pnlSubMenuTMA_Rekap":
                    standarMainMenuHover(menuPanel);
                    break;
                case "pnlFrmTMA_Back":
                    standarButtonHover(menuPanel);
                    break;
                case "pnlFrmTMALihat":
                    standarButtonHover(menuPanel);
                    break;
                case "pnlFrmTMAPosting":
                    standarButtonHover(menuPanel);
                    break;
            case "pnlMenuPBH":
                standarMainMenuHover(menuPanel);
                break;
            case "pnlMenuAdmin":
                standarMainMenuHover(menuPanel);
                break;
                case "pnlSubMenuAdmin_UserData":
                    standarMainMenuHover(menuPanel);
                    break;
                    case "pnlAdminSistem_Kembali":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_AddUser":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_EditUser":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_DeleteUser":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_Save":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_Cancel":
                        standarButtonHover(menuPanel);
                        break;
                case "pnlSubMenuAdmin_BahanProduksi":
                    standarMainMenuHover(menuPanel);
                    break;
                    case "pnlAdminSistem_BahanProduksi_Kembali":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_Add":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_Edit":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_Delete":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_Save":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_Cancel":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_SaveMasuk":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_CancelMasuk":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_AddMasuk":
                        standarButtonHover(menuPanel);
                        break;
                case "pnlSubMenuAdmin_Biaya":
                    standarMainMenuHover(menuPanel);
                    break;
                    case "pnlAdminSistem_Biaya_Back":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_Biaya_Add":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_Biaya_Edit":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_Biaya_Save":
                        standarButtonHover(menuPanel);
                        break;
                    case "pnlAdminSistem_Biaya_Cancel":
                        standarButtonHover(menuPanel);
                        break;
            case "pnlMenuKeluar":
                standarMainMenuHover(menuPanel);
                break;
            case "pnlCetak_Kembali":
                standarButtonHover(menuPanel);
                break;
                case "pnlCetak_Cetak":
                    standarButtonHover(menuPanel);
                    break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mw.repaint();
        JPanel menuPanel = (JPanel) e.getSource();
        String menuPanelName = menuPanel.getName();
        switch(menuPanelName){
            case "pnlLoginLogin":
                standarMainMenuDisplayed(menuPanel);
                break;
            case "pnlLoginKeluar":
                standarMainMenuDisplayed(menuPanel);
                break;
            case "pnlMenuRDKK":
                standarMainMenuDisplayed(menuPanel);
                break;
                case "pnlVerifikasiRdkk":
                    standarMainMenuDisplayed(menuPanel);
                    break;
                    case "pnlFrmValidasiRDKK_Back":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmValidasiRDKK_ClearKoord":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmValidasiRDKK_EditData":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmValidasiRDKK_CetakDraft":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmValidasiRDKK_CetakSKK":
                        standarButtonDisplayed(menuPanel);
                        break;
                case "pnlWsRDKK":
                    standarMainMenuDisplayed(menuPanel);
                    break;
                    case "pnlFrmInputRDKK_Back":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmInputRDKK_LanjutKoord":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmInputRDKK_BatalKoord":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmInputRDKK_TambahPetani":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmInputRDKK_Hapus":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmInputRDKK_SimpanData":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmRDKKClearSearch":
                        menuPanel.setBackground(new Color(85,131,131));
                        break;
            case "pnlMenuPerawatan":
                standarMainMenuDisplayed(menuPanel);
                break;
                case "pnlSubMenuPerawatan_Permintaan":
                    standarMainMenuDisplayed(menuPanel);
                    break;
                    case "pnlFrmPerawatan_Permintaan_Back":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmPerawatan_Permintaan_Tambah":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmPerawatan_Permintaan_Simpan":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmPerawatan_Permintaan_LihatData":
                        standarButtonDisplayed(menuPanel);
                        break;
                        case "pnlFrmPerawatan_BonDalam_Back":
                            standarButtonDisplayed(menuPanel);
                            break;
                        case "pnlFrmPerawatan_Permintaan_CetakBon":
                            standarButtonDisplayed(menuPanel);
                            break;
                case "pnlSubMenuPerawatan_Evaluasi":
                    standarMainMenuDisplayed(menuPanel);
                    break;
            case "pnlMenuPupuk":
                standarMainMenuDisplayed(menuPanel);
                break;
                case "pnlSubMenuPupuk_Permintaan":
                    standarMainMenuDisplayed(menuPanel);
                    break;
                    case "pnlFrmPupuk_Permintaan_Kembali":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmPupuk_Permintaan_Clear":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmPupuk_Permintaan_TambahPupuk":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmPupuk_Permintaan_SimpanData":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmPupuk_Permintaan_CetakPermintaan":
                        standarButtonDisplayed(menuPanel);
                        break;
                case "pnlSubMenuPupuk_EvaluasiBiayaPupuk":
                    standarMainMenuDisplayed(menuPanel);
                    break;
                    case "pnlFrmPupuk_EvaluasiBiayaPupuk_Back":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlFrmPupuk_EvaluasiBiayaPupuk_View":
                        standarButtonDisplayed(menuPanel);
                        break;
            case "pnlMenuTMA":
                standarMainMenuDisplayed(menuPanel);
                break;
                case "pnlSubMenuTMA_Rekap":
                    standarMainMenuDisplayed(menuPanel);
                    break;
                case "pnlFrmTMA_Back":
                    standarButtonDisplayed(menuPanel);
                    break;
                case "pnlFrmTMAPosting":
                    standarButtonDisplayed(menuPanel);
                    break;
                case "pnlFrmTMALihat":
                    standarButtonDisplayed(menuPanel);
                    break;
            case "pnlMenuPBH":
                standarMainMenuDisplayed(menuPanel);
                break;
            /* ADMIN MENU */    
            case "pnlMenuAdmin":
                standarMainMenuDisplayed(menuPanel);
                break;
                case "pnlSubMenuAdmin_UserData":
                    standarMainMenuDisplayed(menuPanel);
                    break;
                    case "pnlAdminSistem_Kembali":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_AddUser":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_EditUser":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_DeleteUser":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_Save":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_Cancel":
                        standarButtonDisplayed(menuPanel);
                        break;
                case "pnlSubMenuAdmin_BahanProduksi":
                    standarMainMenuDisplayed(menuPanel);
                    break;
                    case "pnlAdminSistem_BahanProduksi_Kembali":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_Add":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_Edit":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_Delete":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_Save":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_Cancel":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_SaveMasuk":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_CancelMasuk":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_BahanProduksi_AddMasuk":
                        standarButtonDisplayed(menuPanel);
                        break;
                case "pnlSubMenuAdmin_Biaya" :
                    standarMainMenuDisplayed(menuPanel);
                    break;
                    case "pnlAdminSistem_Biaya_Back":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_Biaya_Add":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_Biaya_Edit":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_Biaya_Cancel":
                        standarButtonDisplayed(menuPanel);
                        break;
                    case "pnlAdminSistem_Biaya_Save":
                        standarButtonDisplayed(menuPanel);
                        break;
            /*************/
            case "pnlMenuKeluar":
                standarMainMenuDisplayed(menuPanel);
                break;
            case "pnlCetak_Kembali":
                standarButtonDisplayed(menuPanel);
                break;
                case "pnlCetak_Cetak":
                    standarButtonDisplayed(menuPanel);
                    break;
        }
    }
    
}
