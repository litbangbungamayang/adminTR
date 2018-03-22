/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

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
        //mw.getLblMenuNav().setText(position);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        CommonController cc = new CommonController(mw);
        RDKKController rc = new RDKKController(mw);
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
                break;
                case "pnlWsRDKK":
                    mw.getPnlSubMenuHolder().setVisible(true);
                    pageSwitcher(mw.getPnlContent(), "crdFrmInputRDKK");
                    pageSwitcher(mw.getPnlFrmInputRDKK_ContainerInputPetani(), "crdInputPetani_Blank");
                    changeMenuNav("Pendaftaran RDKK Baru");
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
                        rc.konfirmasiSimpanData();
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
            case "pnlMenuPerawatan":
                mw.getPnlSubMenuHolder().setVisible(false);
                break;
            case "pnlMenuPupuk":
                mw.getPnlSubMenuHolder().setVisible(false);
                break;
            case "pnlMenuTMA":
                mw.getPnlSubMenuHolder().setVisible(false);
                break;
            case "pnlMenuPBH":
                mw.getPnlSubMenuHolder().setVisible(false);
                break;
            case "pnlMenuAdmin":
                mw.getPnlSubMenuHolder().setVisible(false);
                break;
            case "pnlMenuKeluar":
                System.exit(0);
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
            case "pnlMenuPupuk":
                standarMainMenuHover(menuPanel);
                break;
            case "pnlMenuTMA":
                standarMainMenuHover(menuPanel);
                break;
            case "pnlMenuPBH":
                standarMainMenuHover(menuPanel);
                break;
            case "pnlMenuAdmin":
                standarMainMenuHover(menuPanel);
                break;
            case "pnlMenuKeluar":
                standarMainMenuHover(menuPanel);
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
            case "pnlMenuPupuk":
                standarMainMenuDisplayed(menuPanel);
                break;
            case "pnlMenuTMA":
                standarMainMenuDisplayed(menuPanel);
                break;
            case "pnlMenuPBH":
                standarMainMenuDisplayed(menuPanel);
                break;
            case "pnlMenuAdmin":
                standarMainMenuDisplayed(menuPanel);
                break;
            case "pnlMenuKeluar":
                standarMainMenuDisplayed(menuPanel);
                break;
        }
    }
    
}
