/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.view.MainWindow_lama;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Bayu Anandavi Muhardika
 */

public class menuController_lama implements MouseListener{
    
    private MainWindow_lama mw;
    
    public menuController_lama(MainWindow_lama mw){
        this.mw = mw;
    }
    
    public void repaintKontainerMenuUtama(){
        mw.getPnlKontainerMenuUtama().repaint();
        mw.getPnlMenuAdminTR().repaint();
        mw.getPnlMenuMasterData().repaint();
    }
    
    public void changeMenuNav(String position){
        mw.getLblMenuNav().setText(position);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JPanel menuLabel = (JPanel) e.getSource();
        String menuName = menuLabel.getName();
        JPanel mainContainer = mw.getPnlKontainer();
        switch (menuName){
            case "pnlMenuAdminTR":
                pageSwitcher(mainContainer, "crdAdminTR");
                changeMenuNav("Menu Utama / Administrasi TR");
                break;
            case "pnlMenuMasterData":
                changeMenuNav("Menu Utama / Master Data");
                break;
            case "pnlMenuExit":
                System.exit(0);
                break;
            case "pnlSubMenuPerawatanKebun":
                changeMenuNav("Menu Utama / Administrasi TR / Perawatan Kebun");
                break;
            case "pnlSubMenuLKP":
                changeMenuNav("Menu Utama / Administrasi TR / LKP");
                pageSwitcher(mainContainer, "crdSubMenuLKP");
                break;
            case "pnlWsRDKK":
                changeMenuNav("Menu Utama / Administrasi TR / LKP / RDKK");
                break;
            case "pnlWsLKP":
                changeMenuNav("Menu Utama / Administrasi TR / LKP / Kertas Kerja LKP");
                break;
            case "pnlSubMenuLKPBack":
                changeMenuNav("Menu Utama / Administrasi TR");
                pageSwitcher(mainContainer, "crdAdminTR");
                break;
            case "pnlSubMenuPupuk":
                changeMenuNav("Menu Utama / Administrasi TR / Penggunaan Pupuk");
                break;
            case "pnlSubMenuTMA":
                changeMenuNav("Menu Utama / Administrasi TR / TMA");
                break;
            case "pnlSubMenuBAST":
                changeMenuNav("Menu Utama / Administrasi TR / Berita Acara Selesai Tebang");
                break;
            case "pnlSubMenuPBH":
                changeMenuNav("Menu Utama / Administrasi TR / Perhitungan Bagi Hasil");
                break;
            case "pnlSubMenuAdminTRBack":
                changeMenuNav("Menu Utama");
                pageSwitcher(mw.getPnlKontainer(), "crdMenuUtama");
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JPanel menuLabel = (JPanel) e.getSource();
        String menuName = menuLabel.getName();
        switch (menuName){
            case "pnlMenuAdminTR":
                menuLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menuLabel.setBackground(new Color(221,221,221));
                break;
            case "pnlMenuMasterData":
                menuLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menuLabel.setBackground(new Color(221,221,221));
                break;
            case "pnlMenuExit":
                menuLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menuLabel.setBackground(new Color(255,204,51));
                break;
            case "pnlSubMenuLKP":
                menuLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menuLabel.setBackground(new Color(255,204,51));
                break;
            case "pnlWsRDKK":
                menuLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menuLabel.setBackground(new Color(255,204,51));
                break;
            case "pnlWsLKP":
                menuLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menuLabel.setBackground(new Color(255,204,51));
                break;
            case "pnlSubMenuLKPBack":
                menuLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menuLabel.setBackground(new Color(255,204,51));
                break;
            case "pnlSubMenuPupuk":
                menuLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menuLabel.setBackground(new Color(255,204,51));
                break;
            case "pnlSubMenuPerawatanKebun":
                menuLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menuLabel.setBackground(new Color(255,204,51));
                break;
            case "pnlSubMenuTMA":
                menuLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menuLabel.setBackground(new Color(255,204,51));
                break;
            case "pnlSubMenuBAST":
                menuLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menuLabel.setBackground(new Color(255,204,51));
                break;
            case "pnlSubMenuPBH":
                menuLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menuLabel.setBackground(new Color(255,204,51));
                break;
            case "pnlSubMenuAdminTRBack":
                menuLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                menuLabel.setBackground(new Color(255,204,51));
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JPanel menuLabel = (JPanel) e.getSource();
        String menuName = menuLabel.getName();
        switch(menuName){
            case "pnlMenuAdminTR":
                menuLabel.setBackground(new Color(255,255,255));
                break;
            case "pnlMenuMasterData":
                menuLabel.setBackground(new Color(255,255,255));
                break;
            case "pnlMenuExit":
                menuLabel.setBackground(new Color(255,255,255));
                break;
            case "pnlSubMenuLKP":
                menuLabel.setBackground(new Color(255,255,255));
                break;
            case "pnlWsRDKK":
                menuLabel.setBackground(new Color(255,255,255));
                break;
            case "pnlWsLKP":
                menuLabel.setBackground(new Color(255,255,255));
                break;
            case "pnlSubMenuLKPBack":
                menuLabel.setBackground(new Color(255,255,255));
                break;
            case "pnlSubMenuPupuk":
                menuLabel.setBackground(new Color(255,255,255));
                break;
            case "pnlSubMenuPerawatanKebun":
                menuLabel.setBackground(new Color(255,255,255));
                break;
            case "pnlSubMenuTMA":
                menuLabel.setBackground(new Color(255,255,255));
                break;
            case "pnlSubMenuBAST":
                menuLabel.setBackground(new Color(255,255,255));
                break;
            case "pnlSubMenuPBH":
                menuLabel.setBackground(new Color(255,255,255));
                break;
            case "pnlSubMenuAdminTRBack":
                menuLabel.setBackground(new Color(255,255,255));
                break;
        }
    }
    
    public void pageSwitcher(JPanel containerName, String cardName){
        CardLayout cl = (CardLayout) containerName.getLayout();
        cl.show(containerName, cardName);
    }
    
}
