/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.view;

import id.buma.simtr.controller.ComboBoxListener;
import id.buma.simtr.controller.CommonController;
import id.buma.simtr.controller.KelTaniAutoFilter;
import id.buma.simtr.controller.MenuController;
import id.buma.simtr.controller.NumberOnlyTextFilter;
import id.buma.simtr.controller.PupukController;
import id.buma.simtr.controller.RDKKController;
import id.buma.simtr.controller.UppercaseTextField;
import id.buma.simtr.controller.TextBoxListener;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class MainWindow extends javax.swing.JFrame {

    private final MenuController mc = new MenuController(this);
    
    private final DocumentFilter df = new UppercaseTextField();
    
    private final CommonController cc = new CommonController(this);
    
    private final RDKKController rc = new RDKKController(this);
    
    private final ComboBoxListener cbl = new ComboBoxListener(this);
    
    private final PupukController pc = new PupukController(this);
    
    private final TextBoxListener tbl = new TextBoxListener(this);
   
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        setBackground();
        setMenuAction();
        setTextFieldUppercase();
        setTextFieldAutoClear();
        setTextAutoFilter();
        pnlSubMenuHolder.setVisible(false);
        mc.pageSwitcher(pnlContent, "crdLogin");
        setTableListener();
        setObjectAction();
        setComboBox();
    }
    
    private void setBackground(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void setTableListener(){
        
    }
    
    private void setObjectAction(){
        jcbFrmPupuk_PilihSemuaPetani.addActionListener(pc);
        jcbFrmPupuk_PilihSemuaPupuk.addActionListener(pc);
    }
    
    private void setMenuAction(){
        pnlBackground.addMouseListener(mc);
        pnlMenuRDKK.addMouseListener(mc);
        pnlMenuPupuk.addMouseListener(mc);
        pnlMenuPerawatan.addMouseListener(mc);
        pnlMenuTMA.addMouseListener(mc);
        pnlMenuPBH.addMouseListener(mc);
        pnlMenuAdmin.addMouseListener(mc);
        pnlVerifikasiRdkk.addMouseListener(mc);
        pnlWsRDKK.addMouseListener(mc);
        pnlFrmRDKKBack.addMouseListener(mc);
        pnlFrmInputRDKK_Back.addMouseListener(mc);
        pnlFrmRDKKClearSearch.addMouseListener(mc);
        pnlFrmInputRDKK_LanjutKoord.addMouseListener(mc);
        pnlFrmInputRDKK_BatalKoord.addMouseListener(mc);
        pnlFrmInputRDKK_TambahPetani.addMouseListener(mc);
        pnlFrmInputRDKK_Hapus.addMouseListener(mc);
        pnlFrmInputRDKK_SimpanData.addMouseListener(mc);
        pnlFrmValidasiRDKK_Back.addMouseListener(mc);
        pnlFrmValidasiRDKK_ClearKoord.addMouseListener(mc);
        pnlFrmValidasiRDKK_CetakDraft.addMouseListener(mc);
        pnlFrmValidasiRDKK_CetakSKK.addMouseListener(mc);
        pnlLoginLogin.addMouseListener(mc);
        pnlLoginKeluar.addMouseListener(mc);
        pnlMenuKeluar.addMouseListener(mc);
        pnlCetak_Kembali.addMouseListener(mc);
        pnlCetak_Cetak.addMouseListener(mc);
        pnlSubMenuPupuk_Permintaan.addMouseListener(mc);
        pnlFrmPupuk_Permintaan_Kembali.addMouseListener(mc);
        pnlFrmPupuk_Permintaan_Clear.addMouseListener(mc);
        pnlFrmPupuk_Permintaan_TambahPupuk.addMouseListener(mc);
        pnlFrmPupuk_Permintaan_SimpanData.addMouseListener(mc);
        pnlAdminSistem_Kembali.addMouseListener(mc);
        pnlSubMenuAdmin_UserData.addMouseListener(mc);
        pnlAdminSistem_AddUser.addMouseListener(mc);
        pnlAdminSistem_DeleteUser.addMouseListener(mc);
        pnlAdminSistem_EditUser.addMouseListener(mc);
        pnlAdminSistem_Save.addMouseListener(mc);
        pnlAdminSistem_Cancel.addMouseListener(mc);
        pnlSubMenuAdmin_BahanProduksi.addMouseListener(mc);
        pnlAdminSistem_BahanProduksi_Kembali.addMouseListener(mc);
        pnlAdminSistem_BahanProduksi_Add.addMouseListener(mc);
        pnlAdminSistem_BahanProduksi_Delete.addMouseListener(mc);
        pnlAdminSistem_BahanProduksi_Edit.addMouseListener(mc);
        pnlAdminSistem_BahanProduksi_Cancel.addMouseListener(mc);
        pnlAdminSistem_BahanProduksi_Save.addMouseListener(mc);
        pnlAdminSistem_BahanProduksi_AddMasuk.addMouseListener(mc);
        pnlAdminSistem_BahanProduksi_CancelMasuk.addMouseListener(mc);
        pnlAdminSistem_BahanProduksi_SaveMasuk.addMouseListener(mc);
        pnlFrmPupuk_Permintaan_CetakPermintaan.addMouseListener(mc);
        pnlSubMenuPupuk_EvaluasiBiayaPupuk.addMouseListener(mc);
        pnlFrmPupuk_EvaluasiBiayaPupuk_Back.addMouseListener(mc);
        pnlFrmPupuk_EvaluasiBiayaPupuk_View.addMouseListener(mc);
        pnlSubMenuPerawatan_Permintaan.addMouseListener(mc);
        pnlSubMenuPerawatan_Evaluasi.addMouseListener(mc);
        pnlFrmPerawatan_Permintaan_Back.addMouseListener(mc);
        pnlFrmPerawatan_Permintaan_Tambah.addMouseListener(mc);
        pnlFrmPerawatan_Permintaan_Simpan.addMouseListener(mc);
        pnlFrmPerawatan_Permintaan_LihatData.addMouseListener(mc);
        pnlFrmPerawatan_BonDalam_Back.addMouseListener(mc);
        pnlFrmPerawatan_Permintaan_CetakBon.addMouseListener(mc);
        pnlSubMenuAdmin_Biaya.addMouseListener(mc);
        pnlAdminSistem_Biaya_Back.addMouseListener(mc);
        pnlAdminSistem_Biaya_Add.addMouseListener(mc);
        pnlAdminSistem_Biaya_Edit.addMouseListener(mc);
        pnlAdminSistem_Biaya_Save.addMouseListener(mc);
        pnlAdminSistem_Biaya_Cancel.addMouseListener(mc);
        pnlSubMenuTMA_Rekap.addMouseListener(mc);
        pnlFrmTMA_Back.addMouseListener(mc);
        pnlFrmTMALihat.addMouseListener(mc);
        pnlFrmTMAPosting.addMouseListener(mc);
    }
    
    private void setTextFieldUppercase(){
        ((AbstractDocument) jtfFrmRDKKCari.getDocument()).setDocumentFilter(df);
        ((AbstractDocument) jtfInputRDKKNamaKoord.getDocument()).setDocumentFilter(df);
        ((AbstractDocument) jtfInputRDKKNamaPetani.getDocument()).setDocumentFilter(df);
        DocumentFilter numOnly = new NumberOnlyTextFilter(16);
        ((AbstractDocument) jtfInputNoKtpKoord.getDocument()).setDocumentFilter(numOnly);
        ((AbstractDocument) jtfFrmValidasiRDKK_SearchKoord.getDocument()).setDocumentFilter(df);
        ((AbstractDocument) jtfFrmPupuk_Permintaan_Cari.getDocument()).setDocumentFilter(df);
        ((AbstractDocument) jtfFrmBahanProduksi_NamaBahan.getDocument()).setDocumentFilter(df);
        ((AbstractDocument) jtfFrmPerawatan_Permintaan_Cari.getDocument()).setDocumentFilter(df);
        ((AbstractDocument) jtfMasterBiaya_Uraian.getDocument()).setDocumentFilter(df);
        ((AbstractDocument) jtfFrmTMA_Search.getDocument()).setDocumentFilter(df);
        ((AbstractDocument) jtfFrmBahanProduksi_NoKontrak.getDocument()).setDocumentFilter(df);
    }
    
    private void setTextFieldAutoClear(){
        
    }
    
    private void setTextAutoFilter(){
        KelTaniAutoFilter autoFilter = new KelTaniAutoFilter(tblKelompokTani);
        jtfFrmRDKKCari.addKeyListener(autoFilter);
        KelTaniAutoFilter validasiKoord = new KelTaniAutoFilter(tblValidasiRDKK);
        validasiKoord.setAffectedTable(tblValidasiRDKK_Petani);
        jtfFrmValidasiRDKK_SearchKoord.addKeyListener(validasiKoord);
        KelTaniAutoFilter autoFilterPupuk = new KelTaniAutoFilter(tblKelTani_Pupuk_Permintaan);
        jtfFrmPupuk_Permintaan_Cari.addKeyListener(autoFilterPupuk);
        KelTaniAutoFilter autoFilterPerawatan = new KelTaniAutoFilter(tblKelTani_Perawatan_Permintaan);
        jtfFrmPerawatan_Permintaan_Cari.addKeyListener(autoFilterPerawatan);
        KelTaniAutoFilter autoFilterTMA = new KelTaniAutoFilter(tblTMAKelTani);
        jtfFrmTMA_Search.addKeyListener(autoFilterTMA);
    }
    
    private void setComboBox(){
        setComboBoxListener();
        cc.populateComboBox(cbxKecamatan, rc.namaKecamatanList());
        cc.populateComboBox(cbxInputRDKKVarietas, rc.namaVarietasList());
    }
    
    private void setComboBoxListener(){
        cbl.ComboBoxListener(rc.namaKecamatanList());
        cbxKecamatan.addActionListener(cbl);
        cbl.ComboBoxListener(rc.namaVarietasList());
        cbxInputRDKKVarietas.addActionListener(cbl);
        jtpLoginPassword.addActionListener(tbl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAtas = new javax.swing.JPanel();
        judulUtama = new javax.swing.JLabel();
        pnlBawah = new javax.swing.JPanel();
        pnlTengah = new javax.swing.JPanel();
        pnlNavigasi = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblLoginDesc = new javax.swing.JLabel();
        lblMenuNav = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        pnlMenuUtama = new javax.swing.JPanel();
        lypMenuUtama = new javax.swing.JLayeredPane();
        pnlBackground = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pnlMenuHolder = new javax.swing.JPanel();
        pnlMenuRDKK = new javax.swing.JPanel();
        lblMenuRDKK = new javax.swing.JLabel();
        pnlSeparator1 = new javax.swing.JPanel();
        pnlMenuPupuk = new javax.swing.JPanel();
        lblMenuPupuk = new javax.swing.JLabel();
        pnlSeparator2 = new javax.swing.JPanel();
        pnlMenuPerawatan = new javax.swing.JPanel();
        lblMenuPerawatan = new javax.swing.JLabel();
        pnlSeparator3 = new javax.swing.JPanel();
        pnlMenuTMA = new javax.swing.JPanel();
        lblMenuTMA = new javax.swing.JLabel();
        pnlSeparator4 = new javax.swing.JPanel();
        pnlMenuPBH = new javax.swing.JPanel();
        lblMenuPBH = new javax.swing.JLabel();
        pnlSeparator6 = new javax.swing.JPanel();
        pnlMenuAdmin = new javax.swing.JPanel();
        lblMenuPBH1 = new javax.swing.JLabel();
        pnlSeparator7 = new javax.swing.JPanel();
        pnlMenuKeluar = new javax.swing.JPanel();
        lblMenuKeluar = new javax.swing.JLabel();
        pnlSubMenuHolder = new javax.swing.JPanel();
        pnlSubMenuRDKK = new javax.swing.JPanel();
        pnlWsRDKK = new javax.swing.JPanel();
        lblWsRDKK = new javax.swing.JLabel();
        pnlWsSeparator1 = new javax.swing.JPanel();
        pnlVerifikasiRdkk = new javax.swing.JPanel();
        lblVerifikasiRdkk = new javax.swing.JLabel();
        pnlSubMenuPerawatan = new javax.swing.JPanel();
        pnlSubMenuPerawatan_Permintaan = new javax.swing.JPanel();
        lblWsRDKK1 = new javax.swing.JLabel();
        pnlWsSeparator2 = new javax.swing.JPanel();
        pnlSubMenuPerawatan_Evaluasi = new javax.swing.JPanel();
        lblWsLKP1 = new javax.swing.JLabel();
        pnlSubMenuPupuk = new javax.swing.JPanel();
        pnlSubMenuPupuk_Permintaan = new javax.swing.JPanel();
        lblWsRDKK2 = new javax.swing.JLabel();
        pnlWsSeparator3 = new javax.swing.JPanel();
        pnlSubMenuPupuk_EvaluasiBiayaPupuk = new javax.swing.JPanel();
        lblWsLKP2 = new javax.swing.JLabel();
        pnlSubMenuAdmin = new javax.swing.JPanel();
        pnlSubMenuAdmin_UserData = new javax.swing.JPanel();
        lblWsRDKK3 = new javax.swing.JLabel();
        pnlWsSeparator4 = new javax.swing.JPanel();
        pnlSubMenuAdmin_BahanProduksi = new javax.swing.JPanel();
        lblWsLKP3 = new javax.swing.JLabel();
        pnlWsSeparator5 = new javax.swing.JPanel();
        pnlSubMenuAdmin_Biaya = new javax.swing.JPanel();
        lblWsLKP4 = new javax.swing.JLabel();
        pnlSubMenuTMA = new javax.swing.JPanel();
        pnlSubMenuTMA_Rekap = new javax.swing.JPanel();
        lblWsRDKK4 = new javax.swing.JLabel();
        pnlFrmRDKK = new javax.swing.JPanel();
        pnlFrmRDKKMenuHolder = new javax.swing.JPanel();
        pnlFrmRDKKBack = new javax.swing.JPanel();
        lblFrmRDKKBack = new javax.swing.JLabel();
        pnlFrmRDKKJudul = new javax.swing.JPanel();
        lblFrmRDKKJudul = new javax.swing.JLabel();
        pnlFrmRDKKContent = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKelompokTani = new javax.swing.JTable();
        pnlFrmRDKKJudulKelTani = new javax.swing.JPanel();
        lblDataKelTani = new javax.swing.JLabel();
        jtfFrmRDKKCari = new javax.swing.JTextField();
        lblSearchIcon = new javax.swing.JLabel();
        pnlFrmRDKKClearSearch = new javax.swing.JPanel();
        lblFrmRDKKClearSearch = new javax.swing.JLabel();
        pnlFrmInputRDKK = new javax.swing.JPanel();
        pnlFrmInputRDKK_MenuHolder = new javax.swing.JPanel();
        pnlFrmInputRDKK_Back = new javax.swing.JPanel();
        lblFrmInputRDKK_Back = new javax.swing.JLabel();
        pnlFrmRDKK_Title = new javax.swing.JPanel();
        lblFrmRDKK_Title = new javax.swing.JLabel();
        pnlFrmInputRDKK_Content = new javax.swing.JPanel();
        lblInputNamaKelTani = new javax.swing.JLabel();
        jtfInputRDKKNamaKoord = new javax.swing.JTextField();
        pnlUnderline1 = new javax.swing.JPanel();
        lblInputNamaKelTani1 = new javax.swing.JLabel();
        jtfInputNoKtpKoord = new javax.swing.JTextField();
        pnlUnderline2 = new javax.swing.JPanel();
        lblInputNamaKelTani2 = new javax.swing.JLabel();
        cbxKecamatan = new javax.swing.JComboBox<>();
        cbxDesa = new javax.swing.JComboBox<>();
        lblInputNamaKelTani3 = new javax.swing.JLabel();
        pnlFrmInputRDKK_LanjutKoord = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlFrmInputRDKK_BatalKoord = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblInputNamaKelTani8 = new javax.swing.JLabel();
        cbxKategoriTanaman = new javax.swing.JComboBox<>();
        lblInputNamaKelTani5 = new javax.swing.JLabel();
        cbxInputRDKKMasaTanam = new javax.swing.JComboBox<>();
        lblInputNamaKelTani19 = new javax.swing.JLabel();
        cbxFrmInputRDKK_Afdeling = new javax.swing.JComboBox<>();
        pnlFrmInputRDKK_ContainerInputPetani = new javax.swing.JPanel();
        pnlBlank = new javax.swing.JPanel();
        pnlTblInputPetani = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInputPetani = new javax.swing.JTable();
        lblInputNamaKelTani4 = new javax.swing.JLabel();
        jtfInputRDKKNamaPetani = new javax.swing.JTextField();
        pnlUnderline3 = new javax.swing.JPanel();
        lblInputNamaKelTani6 = new javax.swing.JLabel();
        cbxInputRDKKVarietas = new javax.swing.JComboBox<>();
        lblInputNamaKelTani7 = new javax.swing.JLabel();
        pnlUnderline4 = new javax.swing.JPanel();
        jftInputRDKKLuas = new javax.swing.JFormattedTextField();
        pnlFrmInputRDKK_TambahPetani = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnlFrmInputRDKK_Hapus = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblInputNamaKelTani9 = new javax.swing.JLabel();
        pnlFrmInputRDKK_SimpanData = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblInputNamaKelTani10 = new javax.swing.JLabel();
        jftInputRDKKEasting = new javax.swing.JFormattedTextField();
        pnlUnderline5 = new javax.swing.JPanel();
        lblInputNamaKelTani11 = new javax.swing.JLabel();
        jftInputRDKKNorthing = new javax.swing.JFormattedTextField();
        pnlUnderline6 = new javax.swing.JPanel();
        lblInputNamaKelTani12 = new javax.swing.JLabel();
        pnlFrmValidasiRDKK = new javax.swing.JPanel();
        pnlFrmInputRDKK_MenuHolder1 = new javax.swing.JPanel();
        pnlFrmValidasiRDKK_Back = new javax.swing.JPanel();
        lblFrmInputRDKK_Back1 = new javax.swing.JLabel();
        pnlFrmRDKK_Title1 = new javax.swing.JPanel();
        lblFrmRDKK_Title1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblValidasiRDKK = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtfFrmValidasiRDKK_SearchKoord = new javax.swing.JTextField();
        lblSearchIcon1 = new javax.swing.JLabel();
        pnlFrmValidasiRDKK_ClearKoord = new javax.swing.JPanel();
        lblFrmRDKKClearSearch1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblValidasiRDKK_Petani = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        pnlFrmValidasiRDKK_CetakDraft = new javax.swing.JPanel();
        lblFrmInputRDKK_Back4 = new javax.swing.JLabel();
        pnlFrmValidasiRDKK_CetakSKK = new javax.swing.JPanel();
        lblFrmInputRDKK_Back5 = new javax.swing.JLabel();
        pnlLogin = new javax.swing.JPanel();
        lypMenuLogin = new javax.swing.JLayeredPane();
        pnlBackgroundLogin = new javax.swing.JPanel();
        lblBackground1 = new javax.swing.JLabel();
        pnlHolderLogin = new javax.swing.JPanel();
        pnlLogoLogin = new javax.swing.JPanel();
        lblMenuRDKK1 = new javax.swing.JLabel();
        pnlUserLogin = new javax.swing.JPanel();
        lblLoginUsername = new javax.swing.JLabel();
        lblLoginPassword = new javax.swing.JLabel();
        jtfLoginUsername = new javax.swing.JTextField();
        jtpLoginPassword = new javax.swing.JPasswordField();
        pnlLoginLogin = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pnlLoginKeluar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pnlCetak = new javax.swing.JPanel();
        pnlFrmInputRDKK_MenuHolder2 = new javax.swing.JPanel();
        pnlCetak_Kembali = new javax.swing.JPanel();
        lblFrmInputRDKK_Back3 = new javax.swing.JLabel();
        pnlCetak_Cetak = new javax.swing.JPanel();
        lblFrmInputRDKK_Back6 = new javax.swing.JLabel();
        pnlCetak_Content = new javax.swing.JPanel();
        pnlFrmPupuk_Permintaan = new javax.swing.JPanel();
        pnlFrmInputRDKK_MenuHolder3 = new javax.swing.JPanel();
        pnlFrmPupuk_Permintaan_Kembali = new javax.swing.JPanel();
        lblFrmInputRDKK_Back7 = new javax.swing.JLabel();
        pnlFrmRDKK_Title2 = new javax.swing.JPanel();
        lblFrmRDKK_Title2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblKelTani_Pupuk_Permintaan = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jtfFrmPupuk_Permintaan_Cari = new javax.swing.JTextField();
        lblSearchIcon2 = new javax.swing.JLabel();
        pnlFrmPupuk_Permintaan_Clear = new javax.swing.JPanel();
        lblFrmRDKKClearSearch2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPetani_Pupuk_Permintaan = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        pnlFrmPupuk_Permintaan_TambahPupuk = new javax.swing.JPanel();
        lblFrmInputRDKK_Back8 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblJenisPupuk_Pupuk_Permintaan = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jcbFrmPupuk_PilihSemuaPetani = new javax.swing.JCheckBox();
        jcbFrmPupuk_PilihSemuaPupuk = new javax.swing.JCheckBox();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblBuffer_Pupuk_Permintaan = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        pnlFrmPupuk_Permintaan_Clear1 = new javax.swing.JPanel();
        dtpTglTransaksiPupuk = new org.jdesktop.swingx.JXDatePicker();
        pnlFrmPupuk_Permintaan_SimpanData = new javax.swing.JPanel();
        lblFrmInputRDKK_Back9 = new javax.swing.JLabel();
        pnlFrmPupuk_Permintaan_CetakPermintaan = new javax.swing.JPanel();
        lblFrmInputRDKK_Back23 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pnlAdminSistem_UserData = new javax.swing.JPanel();
        pnlFrmInputRDKK_MenuHolder4 = new javax.swing.JPanel();
        pnlAdminSistem_Kembali = new javax.swing.JPanel();
        lblFrmAdminSistem_Kembali = new javax.swing.JLabel();
        pnlFrmRDKK_Title3 = new javax.swing.JPanel();
        lblFrmRDKK_Title3 = new javax.swing.JLabel();
        pnlAdminSistem_Content = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblUserData = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        pnlAdminSistem_DeleteUser = new javax.swing.JPanel();
        lblFrmInputRDKK_Back10 = new javax.swing.JLabel();
        pnlAdminSistem_AddUser = new javax.swing.JPanel();
        lblFrmInputRDKK_Back11 = new javax.swing.JLabel();
        pnlAdminSistem_EditUser = new javax.swing.JPanel();
        lblFrmInputRDKK_Back12 = new javax.swing.JLabel();
        pnlFrmUserData = new javax.swing.JPanel();
        lblInputNamaKelTani13 = new javax.swing.JLabel();
        jtfFrmUserData_NamaLengkap = new javax.swing.JTextField();
        pnlUnderUserData1 = new javax.swing.JPanel();
        lblInputNamaKelTani14 = new javax.swing.JLabel();
        jtfFrmUserData_Username = new javax.swing.JTextField();
        pnlUnderUserData2 = new javax.swing.JPanel();
        lblInputNamaKelTani15 = new javax.swing.JLabel();
        jtfFrmUserData_Password = new javax.swing.JTextField();
        pnlUnderUserData3 = new javax.swing.JPanel();
        cbxFrmUserData_Level = new javax.swing.JComboBox<>();
        lblInputNamaKelTani16 = new javax.swing.JLabel();
        lblInputNamaKelTani17 = new javax.swing.JLabel();
        cbxFrmUserData_Afdeling = new javax.swing.JComboBox<>();
        pnlAdminSistem_Save = new javax.swing.JPanel();
        lblFrmInputRDKK_Back13 = new javax.swing.JLabel();
        pnlAdminSistem_Cancel = new javax.swing.JPanel();
        lblFrmInputRDKK_Back14 = new javax.swing.JLabel();
        pnlAdminSistem_BahanProduksi = new javax.swing.JPanel();
        pnlFrmInputRDKK_MenuHolder5 = new javax.swing.JPanel();
        pnlAdminSistem_BahanProduksi_Kembali = new javax.swing.JPanel();
        lblFrmAdminSistem_Kembali1 = new javax.swing.JLabel();
        pnlFrmRDKK_Title4 = new javax.swing.JPanel();
        lblFrmRDKK_Title4 = new javax.swing.JLabel();
        pnlAdminSistem_Content1 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblBahanProduksi = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        pnlAdminSistem_BahanProduksi_Delete = new javax.swing.JPanel();
        lblFrmInputRDKK_Back15 = new javax.swing.JLabel();
        pnlAdminSistem_BahanProduksi_Add = new javax.swing.JPanel();
        lblFrmInputRDKK_Back16 = new javax.swing.JLabel();
        pnlAdminSistem_BahanProduksi_Edit = new javax.swing.JPanel();
        lblFrmInputRDKK_Back17 = new javax.swing.JLabel();
        pnlFrmUserData1 = new javax.swing.JPanel();
        lblInputNamaKelTani18 = new javax.swing.JLabel();
        jtfFrmBahanProduksi_NamaBahan = new javax.swing.JTextField();
        pnlUnderUserData4 = new javax.swing.JPanel();
        lblInputNamaKelTani20 = new javax.swing.JLabel();
        cbxFrmBahanProduksi_JenisBahan = new javax.swing.JComboBox<>();
        lblInputNamaKelTani21 = new javax.swing.JLabel();
        lblInputNamaKelTani22 = new javax.swing.JLabel();
        cbxFrmBahanProduksi_Satuan = new javax.swing.JComboBox<>();
        pnlAdminSistem_BahanProduksi_Save = new javax.swing.JPanel();
        lblFrmInputRDKK_Back18 = new javax.swing.JLabel();
        pnlAdminSistem_BahanProduksi_Cancel = new javax.swing.JPanel();
        lblFrmInputRDKK_Back19 = new javax.swing.JLabel();
        jtfFrmBahanProduksi_Dosis = new javax.swing.JFormattedTextField();
        pnlUnderUserData5 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblMonitorBahanMasuk = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        pnlFrmUserData2 = new javax.swing.JPanel();
        lblInputNamaKelTani24 = new javax.swing.JLabel();
        lblInputNamaKelTani26 = new javax.swing.JLabel();
        cbxFrmBahanProduksi_SatuanMasuk = new javax.swing.JComboBox<>();
        pnlAdminSistem_BahanProduksi_SaveMasuk = new javax.swing.JPanel();
        lblFrmInputRDKK_Back20 = new javax.swing.JLabel();
        pnlAdminSistem_BahanProduksi_CancelMasuk = new javax.swing.JPanel();
        lblFrmInputRDKK_Back21 = new javax.swing.JLabel();
        jtfFrmBahanProduksi_KuantaMasuk = new javax.swing.JFormattedTextField();
        pnlUnderUserData7 = new javax.swing.JPanel();
        pnlUnderUserData8 = new javax.swing.JPanel();
        jtfFrmBahanProduksi_NilaiMasuk = new javax.swing.JFormattedTextField();
        lblInputNamaKelTani25 = new javax.swing.JLabel();
        jtfFrmBahanProduksi_NoKontrak = new javax.swing.JTextField();
        pnlUnderUserData12 = new javax.swing.JPanel();
        lblInputNamaKelTani33 = new javax.swing.JLabel();
        pnlAdminSistem_BahanProduksi_AddMasuk = new javax.swing.JPanel();
        lblFrmInputRDKK_Back22 = new javax.swing.JLabel();
        pnlFrmPupuk_EvaluasiBiayaPupuk = new javax.swing.JPanel();
        pnlFrmInputRDKK_MenuHolder6 = new javax.swing.JPanel();
        pnlFrmPupuk_EvaluasiBiayaPupuk_Back = new javax.swing.JPanel();
        lblFrmInputRDKK_Back24 = new javax.swing.JLabel();
        pnlFrmRDKK_Title5 = new javax.swing.JPanel();
        lblFrmRDKK_Title5 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lblFrmRDKK_Title6 = new javax.swing.JLabel();
        cbxFrmPupuk_EvaluasiBiayaPupuk_Afd = new javax.swing.JComboBox<>();
        dtpFrmPupuk_EvaluasiBiayaPupuk_Tgl1 = new org.jdesktop.swingx.JXDatePicker();
        lblFrmRDKK_Title7 = new javax.swing.JLabel();
        lblFrmRDKK_Title8 = new javax.swing.JLabel();
        dtpFrmPupuk_EvaluasiBiayaPupuk_Tgl2 = new org.jdesktop.swingx.JXDatePicker();
        pnlFrmPupuk_EvaluasiBiayaPupuk_View = new javax.swing.JPanel();
        lblFrmInputRDKK_Back25 = new javax.swing.JLabel();
        pnlFrmPerawatan_Permintaan = new javax.swing.JPanel();
        pnlFrmInputRDKK_MenuHolder7 = new javax.swing.JPanel();
        pnlFrmPerawatan_Permintaan_Back = new javax.swing.JPanel();
        lblFrmInputRDKK_Back26 = new javax.swing.JLabel();
        pnlFrmRDKK_Title6 = new javax.swing.JPanel();
        lblFrmRDKK_Title9 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblKelTani_Perawatan_Permintaan = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jtfFrmPerawatan_Permintaan_Cari = new javax.swing.JTextField();
        lblSearchIcon3 = new javax.swing.JLabel();
        pnlFrmPupuk_Permintaan_Clear2 = new javax.swing.JPanel();
        lblFrmRDKKClearSearch3 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblPetani_Perawatan_Permintaan = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        pnlFrmPerawatan_Permintaan_Tambah = new javax.swing.JPanel();
        lblFrmInputRDKK_Back27 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblPekerjaanKebun_Perawatan_Permintaan = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        dtpTglTransaksiPerawatan = new org.jdesktop.swingx.JXDatePicker();
        pnlFrmPerawatan_Permintaan_Simpan = new javax.swing.JPanel();
        lblFrmInputRDKK_Back28 = new javax.swing.JLabel();
        pnlFrmPerawatan_Permintaan_LihatData = new javax.swing.JPanel();
        lblFrmInputRDKK_Back29 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblBuffer_Perawatan_Permintaan = new javax.swing.JTable();
        pnlFrmPerawatan_BonDalam = new javax.swing.JPanel();
        pnlFrmInputRDKK_MenuHolder8 = new javax.swing.JPanel();
        pnlFrmPerawatan_BonDalam_Back = new javax.swing.JPanel();
        lblFrmInputRDKK_Back30 = new javax.swing.JLabel();
        pnlFrmRDKK_Title7 = new javax.swing.JPanel();
        lblFrmRDKK_Title10 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblPosting_Perawatan_Permintaan = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblDetail_Perawatan_Permintaan = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        lblFrmRDKK_Title11 = new javax.swing.JLabel();
        lblFrmRDKK_Title12 = new javax.swing.JLabel();
        lblFrmPosting_NamaKelompok = new javax.swing.JLabel();
        lblFrmPosting_NoKontrak = new javax.swing.JLabel();
        pnlFrmPerawatan_Permintaan_CetakBon = new javax.swing.JPanel();
        lblFrmInputRDKK_Back31 = new javax.swing.JLabel();
        pnlAdminSistem_Biaya = new javax.swing.JPanel();
        pnlFrmInputRDKK_MenuHolder9 = new javax.swing.JPanel();
        pnlAdminSistem_Biaya_Back = new javax.swing.JPanel();
        lblFrmAdminSistem_Kembali2 = new javax.swing.JLabel();
        pnlFrmRDKK_Title8 = new javax.swing.JPanel();
        lblFrmRDKK_Title13 = new javax.swing.JLabel();
        pnlAdminSistem_Content2 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblMasterBiaya = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        pnlAdminSistem_Biaya_Add = new javax.swing.JPanel();
        lblFrmInputRDKK_Back33 = new javax.swing.JLabel();
        pnlAdminSistem_Biaya_Edit = new javax.swing.JPanel();
        lblFrmInputRDKK_Back34 = new javax.swing.JLabel();
        pnlFrmUserData3 = new javax.swing.JPanel();
        lblInputNamaKelTani23 = new javax.swing.JLabel();
        lblInputNamaKelTani27 = new javax.swing.JLabel();
        lblInputNamaKelTani28 = new javax.swing.JLabel();
        lblInputNamaKelTani29 = new javax.swing.JLabel();
        pnlAdminSistem_Biaya_Save = new javax.swing.JPanel();
        lblFrmInputRDKK_Back35 = new javax.swing.JLabel();
        pnlAdminSistem_Biaya_Cancel = new javax.swing.JPanel();
        lblFrmInputRDKK_Back36 = new javax.swing.JLabel();
        jtfMasterBiaya_Harga = new javax.swing.JFormattedTextField();
        pnlUnderUserData9 = new javax.swing.JPanel();
        jtfMasterBiaya_Uraian = new javax.swing.JTextField();
        pnlUnderUserData10 = new javax.swing.JPanel();
        lblInputNamaKelTani30 = new javax.swing.JLabel();
        lblInputNamaKelTani31 = new javax.swing.JLabel();
        lblInputNamaKelTani32 = new javax.swing.JLabel();
        cbxMasterBiaya_JenisBiaya = new javax.swing.JComboBox<>();
        cbxMasterBiaya_Satuan = new javax.swing.JComboBox<>();
        cbxMasterBiaya_TahunGiling = new javax.swing.JComboBox<>();
        jtfMasterBiaya_KodeBiaya = new javax.swing.JTextField();
        pnlUnderUserData11 = new javax.swing.JPanel();
        cbxMasterBiaya_Kategori = new javax.swing.JComboBox<>();
        pnlFrmTMA = new javax.swing.JPanel();
        pnlFrmInputRDKK_MenuHolder10 = new javax.swing.JPanel();
        pnlFrmTMA_Back = new javax.swing.JPanel();
        lblFrmInputRDKK_Back2 = new javax.swing.JLabel();
        pnlFrmRDKK_Title9 = new javax.swing.JPanel();
        lblFrmRDKK_Title14 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tblTMAKelTani = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jtfFrmTMA_Search = new javax.swing.JTextField();
        lblSearchIcon4 = new javax.swing.JLabel();
        pnlFrmValidasiRDKK_ClearKoord1 = new javax.swing.JPanel();
        lblFrmRDKKClearSearch4 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tblTMADataTimbang = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        pnlFrmTMAPosting = new javax.swing.JPanel();
        lblFrmInputRDKK_Back32 = new javax.swing.JLabel();
        pnlFrmTMALihat = new javax.swing.JPanel();
        lblFrmInputRDKK_Back37 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Informasi Administrasi Tebu Rakyat");
        setBackground(new java.awt.Color(255, 255, 255));
        setName("frmUtama"); // NOI18N
        setUndecorated(true);

        pnlAtas.setBackground(new java.awt.Color(0, 153, 153));
        pnlAtas.setPreferredSize(new java.awt.Dimension(1366, 40));

        judulUtama.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        judulUtama.setForeground(new java.awt.Color(255, 255, 255));
        judulUtama.setText("Sistem Informasi Administrasi Tebu Rakyat");

        javax.swing.GroupLayout pnlAtasLayout = new javax.swing.GroupLayout(pnlAtas);
        pnlAtas.setLayout(pnlAtasLayout);
        pnlAtasLayout.setHorizontalGroup(
            pnlAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAtasLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(judulUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(763, Short.MAX_VALUE))
        );
        pnlAtasLayout.setVerticalGroup(
            pnlAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAtasLayout.createSequentialGroup()
                .addComponent(judulUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlBawah.setBackground(new java.awt.Color(0, 105, 105));

        javax.swing.GroupLayout pnlBawahLayout = new javax.swing.GroupLayout(pnlBawah);
        pnlBawah.setLayout(pnlBawahLayout);
        pnlBawahLayout.setHorizontalGroup(
            pnlBawahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        pnlBawahLayout.setVerticalGroup(
            pnlBawahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pnlTengah.setBackground(new java.awt.Color(255, 255, 255));
        pnlTengah.setPreferredSize(new java.awt.Dimension(1366, 698));

        pnlNavigasi.setBackground(new java.awt.Color(0, 105, 105));
        pnlNavigasi.setPreferredSize(new java.awt.Dimension(72, 30));

        lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblLoginDesc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLoginDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblLoginDesc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lblMenuNav.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMenuNav.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlNavigasiLayout = new javax.swing.GroupLayout(pnlNavigasi);
        pnlNavigasi.setLayout(pnlNavigasiLayout);
        pnlNavigasiLayout.setHorizontalGroup(
            pnlNavigasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNavigasiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMenuNav, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
                .addGap(260, 260, 260)
                .addComponent(lblLoginDesc)
                .addGap(18, 18, 18)
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlNavigasiLayout.setVerticalGroup(
            pnlNavigasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavigasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblLoginDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblMenuNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setPreferredSize(new java.awt.Dimension(1366, 750));
        pnlContent.setLayout(new java.awt.CardLayout());

        pnlMenuUtama.setBackground(new java.awt.Color(255, 255, 255));

        pnlBackground.setBackground(new java.awt.Color(102, 102, 102));
        pnlBackground.setName("pnlBackground"); // NOI18N
        pnlBackground.setPreferredSize(new java.awt.Dimension(1366, 698));
        pnlBackground.setLayout(new java.awt.BorderLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/sugarcane_5.jpg"))); // NOI18N
        jLabel12.setText("jLabel12");
        pnlBackground.add(jLabel12, java.awt.BorderLayout.CENTER);

        pnlMenuHolder.setBackground(new Color(255,255,255,100));
        pnlMenuHolder.setPreferredSize(new java.awt.Dimension(1366, 200));
        pnlMenuHolder.setLayout(new java.awt.GridBagLayout());

        pnlMenuRDKK.setBackground(new Color(34,59,14,50));
        pnlMenuRDKK.setName("pnlMenuRDKK"); // NOI18N
        pnlMenuRDKK.setPreferredSize(new java.awt.Dimension(150, 150));

        lblMenuRDKK.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMenuRDKK.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuRDKK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuRDKK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Increase_104px_1.png"))); // NOI18N
        lblMenuRDKK.setText("Kelompok Tani");
        lblMenuRDKK.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMenuRDKK.setIconTextGap(10);
        lblMenuRDKK.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlMenuRDKKLayout = new javax.swing.GroupLayout(pnlMenuRDKK);
        pnlMenuRDKK.setLayout(pnlMenuRDKKLayout);
        pnlMenuRDKKLayout.setHorizontalGroup(
            pnlMenuRDKKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuRDKK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMenuRDKKLayout.setVerticalGroup(
            pnlMenuRDKKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuRDKK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMenuHolder.add(pnlMenuRDKK, new java.awt.GridBagConstraints());

        pnlSeparator1.setBackground(new Color(255,255,255,0));
        pnlSeparator1.setPreferredSize(new java.awt.Dimension(10, 150));

        javax.swing.GroupLayout pnlSeparator1Layout = new javax.swing.GroupLayout(pnlSeparator1);
        pnlSeparator1.setLayout(pnlSeparator1Layout);
        pnlSeparator1Layout.setHorizontalGroup(
            pnlSeparator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnlSeparator1Layout.setVerticalGroup(
            pnlSeparator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        pnlMenuHolder.add(pnlSeparator1, new java.awt.GridBagConstraints());

        pnlMenuPupuk.setBackground(new Color(34,59,14,50));
        pnlMenuPupuk.setName("pnlMenuPupuk"); // NOI18N
        pnlMenuPupuk.setPreferredSize(new java.awt.Dimension(150, 150));

        lblMenuPupuk.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMenuPupuk.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuPupuk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuPupuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Seed_104px.png"))); // NOI18N
        lblMenuPupuk.setText("Pemupukan");
        lblMenuPupuk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMenuPupuk.setIconTextGap(10);
        lblMenuPupuk.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlMenuPupukLayout = new javax.swing.GroupLayout(pnlMenuPupuk);
        pnlMenuPupuk.setLayout(pnlMenuPupukLayout);
        pnlMenuPupukLayout.setHorizontalGroup(
            pnlMenuPupukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuPupuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMenuPupukLayout.setVerticalGroup(
            pnlMenuPupukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuPupuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMenuHolder.add(pnlMenuPupuk, new java.awt.GridBagConstraints());

        pnlSeparator2.setBackground(new Color(255,255,255,0));
        pnlSeparator2.setPreferredSize(new java.awt.Dimension(10, 150));

        javax.swing.GroupLayout pnlSeparator2Layout = new javax.swing.GroupLayout(pnlSeparator2);
        pnlSeparator2.setLayout(pnlSeparator2Layout);
        pnlSeparator2Layout.setHorizontalGroup(
            pnlSeparator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnlSeparator2Layout.setVerticalGroup(
            pnlSeparator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        pnlMenuHolder.add(pnlSeparator2, new java.awt.GridBagConstraints());

        pnlMenuPerawatan.setBackground(new Color(34,59,14,50));
        pnlMenuPerawatan.setName("pnlMenuPerawatan"); // NOI18N
        pnlMenuPerawatan.setPreferredSize(new java.awt.Dimension(150, 150));

        lblMenuPerawatan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMenuPerawatan.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuPerawatan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuPerawatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Grass_104px.png"))); // NOI18N
        lblMenuPerawatan.setText("Perawatan Tanaman");
        lblMenuPerawatan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMenuPerawatan.setIconTextGap(10);
        lblMenuPerawatan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlMenuPerawatanLayout = new javax.swing.GroupLayout(pnlMenuPerawatan);
        pnlMenuPerawatan.setLayout(pnlMenuPerawatanLayout);
        pnlMenuPerawatanLayout.setHorizontalGroup(
            pnlMenuPerawatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuPerawatan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMenuPerawatanLayout.setVerticalGroup(
            pnlMenuPerawatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuPerawatan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMenuHolder.add(pnlMenuPerawatan, new java.awt.GridBagConstraints());

        pnlSeparator3.setBackground(new Color(255,255,255,0));
        pnlSeparator3.setPreferredSize(new java.awt.Dimension(10, 150));

        javax.swing.GroupLayout pnlSeparator3Layout = new javax.swing.GroupLayout(pnlSeparator3);
        pnlSeparator3.setLayout(pnlSeparator3Layout);
        pnlSeparator3Layout.setHorizontalGroup(
            pnlSeparator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnlSeparator3Layout.setVerticalGroup(
            pnlSeparator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        pnlMenuHolder.add(pnlSeparator3, new java.awt.GridBagConstraints());

        pnlMenuTMA.setBackground(new Color(34,59,14,50));
        pnlMenuTMA.setName("pnlMenuTMA"); // NOI18N
        pnlMenuTMA.setPreferredSize(new java.awt.Dimension(150, 150));

        lblMenuTMA.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblMenuTMA.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuTMA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuTMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Harvester_104px.png"))); // NOI18N
        lblMenuTMA.setText("Tebang-Muat-Angkut");
        lblMenuTMA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMenuTMA.setIconTextGap(10);
        lblMenuTMA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlMenuTMALayout = new javax.swing.GroupLayout(pnlMenuTMA);
        pnlMenuTMA.setLayout(pnlMenuTMALayout);
        pnlMenuTMALayout.setHorizontalGroup(
            pnlMenuTMALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuTMA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMenuTMALayout.setVerticalGroup(
            pnlMenuTMALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuTMA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMenuHolder.add(pnlMenuTMA, new java.awt.GridBagConstraints());

        pnlSeparator4.setBackground(new Color(255,255,255,0));
        pnlSeparator4.setPreferredSize(new java.awt.Dimension(10, 150));

        javax.swing.GroupLayout pnlSeparator4Layout = new javax.swing.GroupLayout(pnlSeparator4);
        pnlSeparator4.setLayout(pnlSeparator4Layout);
        pnlSeparator4Layout.setHorizontalGroup(
            pnlSeparator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnlSeparator4Layout.setVerticalGroup(
            pnlSeparator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        pnlMenuHolder.add(pnlSeparator4, new java.awt.GridBagConstraints());

        pnlMenuPBH.setBackground(new Color(34,59,14,50));
        pnlMenuPBH.setName("pnlMenuPBH"); // NOI18N
        pnlMenuPBH.setPreferredSize(new java.awt.Dimension(150, 150));

        lblMenuPBH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMenuPBH.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuPBH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuPBH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Calculator_104px.png"))); // NOI18N
        lblMenuPBH.setText("Perhitungan Bagi Hasil");
        lblMenuPBH.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMenuPBH.setIconTextGap(10);
        lblMenuPBH.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlMenuPBHLayout = new javax.swing.GroupLayout(pnlMenuPBH);
        pnlMenuPBH.setLayout(pnlMenuPBHLayout);
        pnlMenuPBHLayout.setHorizontalGroup(
            pnlMenuPBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuPBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMenuPBHLayout.setVerticalGroup(
            pnlMenuPBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuPBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMenuHolder.add(pnlMenuPBH, new java.awt.GridBagConstraints());

        pnlSeparator6.setBackground(new Color(255,255,255,0));
        pnlSeparator6.setPreferredSize(new java.awt.Dimension(10, 150));

        javax.swing.GroupLayout pnlSeparator6Layout = new javax.swing.GroupLayout(pnlSeparator6);
        pnlSeparator6.setLayout(pnlSeparator6Layout);
        pnlSeparator6Layout.setHorizontalGroup(
            pnlSeparator6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnlSeparator6Layout.setVerticalGroup(
            pnlSeparator6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        pnlMenuHolder.add(pnlSeparator6, new java.awt.GridBagConstraints());

        pnlMenuAdmin.setBackground(new Color(34,59,14,50));
        pnlMenuAdmin.setName("pnlMenuAdmin"); // NOI18N
        pnlMenuAdmin.setPreferredSize(new java.awt.Dimension(150, 150));

        lblMenuPBH1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblMenuPBH1.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuPBH1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuPBH1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Administrative_Tools_104px.png"))); // NOI18N
        lblMenuPBH1.setText("Administrasi Sistem");
        lblMenuPBH1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMenuPBH1.setIconTextGap(10);
        lblMenuPBH1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlMenuAdminLayout = new javax.swing.GroupLayout(pnlMenuAdmin);
        pnlMenuAdmin.setLayout(pnlMenuAdminLayout);
        pnlMenuAdminLayout.setHorizontalGroup(
            pnlMenuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuPBH1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMenuAdminLayout.setVerticalGroup(
            pnlMenuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuPBH1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMenuHolder.add(pnlMenuAdmin, new java.awt.GridBagConstraints());

        pnlSeparator7.setBackground(new Color(255,255,255,0));
        pnlSeparator7.setPreferredSize(new java.awt.Dimension(10, 150));

        javax.swing.GroupLayout pnlSeparator7Layout = new javax.swing.GroupLayout(pnlSeparator7);
        pnlSeparator7.setLayout(pnlSeparator7Layout);
        pnlSeparator7Layout.setHorizontalGroup(
            pnlSeparator7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnlSeparator7Layout.setVerticalGroup(
            pnlSeparator7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        pnlMenuHolder.add(pnlSeparator7, new java.awt.GridBagConstraints());

        pnlMenuKeluar.setBackground(new Color(34,59,14,50));
        pnlMenuKeluar.setName("pnlMenuKeluar"); // NOI18N
        pnlMenuKeluar.setPreferredSize(new java.awt.Dimension(150, 150));

        lblMenuKeluar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblMenuKeluar.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuKeluar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Login_104px.png"))); // NOI18N
        lblMenuKeluar.setText("Keluar");
        lblMenuKeluar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMenuKeluar.setIconTextGap(10);
        lblMenuKeluar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlMenuKeluarLayout = new javax.swing.GroupLayout(pnlMenuKeluar);
        pnlMenuKeluar.setLayout(pnlMenuKeluarLayout);
        pnlMenuKeluarLayout.setHorizontalGroup(
            pnlMenuKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMenuKeluarLayout.setVerticalGroup(
            pnlMenuKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMenuHolder.add(pnlMenuKeluar, new java.awt.GridBagConstraints());

        pnlSubMenuHolder.setBackground(new Color(255,255,255,100));
        pnlSubMenuHolder.setLayout(new java.awt.CardLayout());

        pnlSubMenuRDKK.setBackground(new Color(255,255,255,150));
        pnlSubMenuRDKK.setLayout(new java.awt.GridBagLayout());

        pnlWsRDKK.setBackground(new Color(34,59,14,50));
        pnlWsRDKK.setName("pnlWsRDKK"); // NOI18N
        pnlWsRDKK.setPreferredSize(new java.awt.Dimension(250, 50));

        lblWsRDKK.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblWsRDKK.setForeground(new java.awt.Color(255, 255, 255));
        lblWsRDKK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWsRDKK.setText("Pendaftaran Kelompok Tani Baru");

        javax.swing.GroupLayout pnlWsRDKKLayout = new javax.swing.GroupLayout(pnlWsRDKK);
        pnlWsRDKK.setLayout(pnlWsRDKKLayout);
        pnlWsRDKKLayout.setHorizontalGroup(
            pnlWsRDKKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsRDKK, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        pnlWsRDKKLayout.setVerticalGroup(
            pnlWsRDKKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsRDKK, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlSubMenuRDKK.add(pnlWsRDKK, new java.awt.GridBagConstraints());

        pnlWsSeparator1.setBackground(new Color(255,255,255,0));
        pnlWsSeparator1.setPreferredSize(new java.awt.Dimension(10, 50));

        javax.swing.GroupLayout pnlWsSeparator1Layout = new javax.swing.GroupLayout(pnlWsSeparator1);
        pnlWsSeparator1.setLayout(pnlWsSeparator1Layout);
        pnlWsSeparator1Layout.setHorizontalGroup(
            pnlWsSeparator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnlWsSeparator1Layout.setVerticalGroup(
            pnlWsSeparator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        pnlSubMenuRDKK.add(pnlWsSeparator1, new java.awt.GridBagConstraints());

        pnlVerifikasiRdkk.setBackground(new Color(34,59,14,50));
        pnlVerifikasiRdkk.setName("pnlVerifikasiRdkk"); // NOI18N
        pnlVerifikasiRdkk.setPreferredSize(new java.awt.Dimension(250, 50));

        lblVerifikasiRdkk.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblVerifikasiRdkk.setForeground(new java.awt.Color(255, 255, 255));
        lblVerifikasiRdkk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVerifikasiRdkk.setText("Lihat Daftar Kelompok Tani");

        javax.swing.GroupLayout pnlVerifikasiRdkkLayout = new javax.swing.GroupLayout(pnlVerifikasiRdkk);
        pnlVerifikasiRdkk.setLayout(pnlVerifikasiRdkkLayout);
        pnlVerifikasiRdkkLayout.setHorizontalGroup(
            pnlVerifikasiRdkkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVerifikasiRdkk, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        pnlVerifikasiRdkkLayout.setVerticalGroup(
            pnlVerifikasiRdkkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVerifikasiRdkk, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlSubMenuRDKK.add(pnlVerifikasiRdkk, new java.awt.GridBagConstraints());

        pnlSubMenuHolder.add(pnlSubMenuRDKK, "crdSubMenuRDKK");

        pnlSubMenuPerawatan.setBackground(new Color(255,255,255,150));
        pnlSubMenuPerawatan.setLayout(new java.awt.GridBagLayout());

        pnlSubMenuPerawatan_Permintaan.setBackground(new Color(34,59,14,50));
        pnlSubMenuPerawatan_Permintaan.setName("pnlSubMenuPerawatan_Permintaan"); // NOI18N
        pnlSubMenuPerawatan_Permintaan.setPreferredSize(new java.awt.Dimension(250, 50));

        lblWsRDKK1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblWsRDKK1.setForeground(new java.awt.Color(255, 255, 255));
        lblWsRDKK1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWsRDKK1.setText("Permintaan Perawatan Tanaman");

        javax.swing.GroupLayout pnlSubMenuPerawatan_PermintaanLayout = new javax.swing.GroupLayout(pnlSubMenuPerawatan_Permintaan);
        pnlSubMenuPerawatan_Permintaan.setLayout(pnlSubMenuPerawatan_PermintaanLayout);
        pnlSubMenuPerawatan_PermintaanLayout.setHorizontalGroup(
            pnlSubMenuPerawatan_PermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsRDKK1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        pnlSubMenuPerawatan_PermintaanLayout.setVerticalGroup(
            pnlSubMenuPerawatan_PermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsRDKK1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlSubMenuPerawatan.add(pnlSubMenuPerawatan_Permintaan, new java.awt.GridBagConstraints());

        pnlWsSeparator2.setBackground(new Color(255,255,255,0));
        pnlWsSeparator2.setPreferredSize(new java.awt.Dimension(10, 50));

        javax.swing.GroupLayout pnlWsSeparator2Layout = new javax.swing.GroupLayout(pnlWsSeparator2);
        pnlWsSeparator2.setLayout(pnlWsSeparator2Layout);
        pnlWsSeparator2Layout.setHorizontalGroup(
            pnlWsSeparator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnlWsSeparator2Layout.setVerticalGroup(
            pnlWsSeparator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        pnlSubMenuPerawatan.add(pnlWsSeparator2, new java.awt.GridBagConstraints());

        pnlSubMenuPerawatan_Evaluasi.setBackground(new Color(34,59,14,50));
        pnlSubMenuPerawatan_Evaluasi.setName("pnlSubMenuPerawatan_Evaluasi"); // NOI18N
        pnlSubMenuPerawatan_Evaluasi.setPreferredSize(new java.awt.Dimension(250, 50));

        lblWsLKP1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblWsLKP1.setForeground(new java.awt.Color(255, 255, 255));
        lblWsLKP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWsLKP1.setText("Permintaan Bibit");

        javax.swing.GroupLayout pnlSubMenuPerawatan_EvaluasiLayout = new javax.swing.GroupLayout(pnlSubMenuPerawatan_Evaluasi);
        pnlSubMenuPerawatan_Evaluasi.setLayout(pnlSubMenuPerawatan_EvaluasiLayout);
        pnlSubMenuPerawatan_EvaluasiLayout.setHorizontalGroup(
            pnlSubMenuPerawatan_EvaluasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsLKP1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        pnlSubMenuPerawatan_EvaluasiLayout.setVerticalGroup(
            pnlSubMenuPerawatan_EvaluasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsLKP1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlSubMenuPerawatan.add(pnlSubMenuPerawatan_Evaluasi, new java.awt.GridBagConstraints());

        pnlSubMenuHolder.add(pnlSubMenuPerawatan, "crdSubMenuPerawatan");

        pnlSubMenuPupuk.setBackground(new Color(255,255,255,150));
        pnlSubMenuPupuk.setLayout(new java.awt.GridBagLayout());

        pnlSubMenuPupuk_Permintaan.setBackground(new Color(34,59,14,50));
        pnlSubMenuPupuk_Permintaan.setName("pnlSubMenuPupuk_Permintaan"); // NOI18N
        pnlSubMenuPupuk_Permintaan.setPreferredSize(new java.awt.Dimension(200, 50));

        lblWsRDKK2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblWsRDKK2.setForeground(new java.awt.Color(255, 255, 255));
        lblWsRDKK2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWsRDKK2.setText("Permintaan Pupuk");

        javax.swing.GroupLayout pnlSubMenuPupuk_PermintaanLayout = new javax.swing.GroupLayout(pnlSubMenuPupuk_Permintaan);
        pnlSubMenuPupuk_Permintaan.setLayout(pnlSubMenuPupuk_PermintaanLayout);
        pnlSubMenuPupuk_PermintaanLayout.setHorizontalGroup(
            pnlSubMenuPupuk_PermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsRDKK2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        pnlSubMenuPupuk_PermintaanLayout.setVerticalGroup(
            pnlSubMenuPupuk_PermintaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsRDKK2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlSubMenuPupuk.add(pnlSubMenuPupuk_Permintaan, new java.awt.GridBagConstraints());

        pnlWsSeparator3.setBackground(new Color(255,255,255,0));
        pnlWsSeparator3.setPreferredSize(new java.awt.Dimension(10, 50));

        javax.swing.GroupLayout pnlWsSeparator3Layout = new javax.swing.GroupLayout(pnlWsSeparator3);
        pnlWsSeparator3.setLayout(pnlWsSeparator3Layout);
        pnlWsSeparator3Layout.setHorizontalGroup(
            pnlWsSeparator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnlWsSeparator3Layout.setVerticalGroup(
            pnlWsSeparator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        pnlSubMenuPupuk.add(pnlWsSeparator3, new java.awt.GridBagConstraints());

        pnlSubMenuPupuk_EvaluasiBiayaPupuk.setBackground(new Color(34,59,14,50));
        pnlSubMenuPupuk_EvaluasiBiayaPupuk.setName("pnlSubMenuPupuk_EvaluasiBiayaPupuk"); // NOI18N
        pnlSubMenuPupuk_EvaluasiBiayaPupuk.setPreferredSize(new java.awt.Dimension(250, 50));

        lblWsLKP2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblWsLKP2.setForeground(new java.awt.Color(255, 255, 255));
        lblWsLKP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWsLKP2.setText("Evaluasi Biaya Pupuk");

        javax.swing.GroupLayout pnlSubMenuPupuk_EvaluasiBiayaPupukLayout = new javax.swing.GroupLayout(pnlSubMenuPupuk_EvaluasiBiayaPupuk);
        pnlSubMenuPupuk_EvaluasiBiayaPupuk.setLayout(pnlSubMenuPupuk_EvaluasiBiayaPupukLayout);
        pnlSubMenuPupuk_EvaluasiBiayaPupukLayout.setHorizontalGroup(
            pnlSubMenuPupuk_EvaluasiBiayaPupukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsLKP2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        pnlSubMenuPupuk_EvaluasiBiayaPupukLayout.setVerticalGroup(
            pnlSubMenuPupuk_EvaluasiBiayaPupukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsLKP2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlSubMenuPupuk.add(pnlSubMenuPupuk_EvaluasiBiayaPupuk, new java.awt.GridBagConstraints());

        pnlSubMenuHolder.add(pnlSubMenuPupuk, "crdSubMenuPupuk");

        pnlSubMenuAdmin.setBackground(new Color(255,255,255,150));
        pnlSubMenuAdmin.setName("pnlSubMenuAdmin"); // NOI18N
        pnlSubMenuAdmin.setLayout(new java.awt.GridBagLayout());

        pnlSubMenuAdmin_UserData.setBackground(new Color(34,59,14,50));
        pnlSubMenuAdmin_UserData.setName("pnlSubMenuAdmin_UserData"); // NOI18N
        pnlSubMenuAdmin_UserData.setPreferredSize(new java.awt.Dimension(200, 50));

        lblWsRDKK3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblWsRDKK3.setForeground(new java.awt.Color(255, 255, 255));
        lblWsRDKK3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWsRDKK3.setText("Pengguna Sistem");

        javax.swing.GroupLayout pnlSubMenuAdmin_UserDataLayout = new javax.swing.GroupLayout(pnlSubMenuAdmin_UserData);
        pnlSubMenuAdmin_UserData.setLayout(pnlSubMenuAdmin_UserDataLayout);
        pnlSubMenuAdmin_UserDataLayout.setHorizontalGroup(
            pnlSubMenuAdmin_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsRDKK3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        pnlSubMenuAdmin_UserDataLayout.setVerticalGroup(
            pnlSubMenuAdmin_UserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsRDKK3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlSubMenuAdmin.add(pnlSubMenuAdmin_UserData, new java.awt.GridBagConstraints());

        pnlWsSeparator4.setBackground(new Color(255,255,255,0));
        pnlWsSeparator4.setPreferredSize(new java.awt.Dimension(10, 50));

        javax.swing.GroupLayout pnlWsSeparator4Layout = new javax.swing.GroupLayout(pnlWsSeparator4);
        pnlWsSeparator4.setLayout(pnlWsSeparator4Layout);
        pnlWsSeparator4Layout.setHorizontalGroup(
            pnlWsSeparator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnlWsSeparator4Layout.setVerticalGroup(
            pnlWsSeparator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        pnlSubMenuAdmin.add(pnlWsSeparator4, new java.awt.GridBagConstraints());

        pnlSubMenuAdmin_BahanProduksi.setBackground(new Color(34,59,14,50));
        pnlSubMenuAdmin_BahanProduksi.setName("pnlSubMenuAdmin_BahanProduksi"); // NOI18N
        pnlSubMenuAdmin_BahanProduksi.setPreferredSize(new java.awt.Dimension(200, 50));

        lblWsLKP3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblWsLKP3.setForeground(new java.awt.Color(255, 255, 255));
        lblWsLKP3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWsLKP3.setText("Bahan Produksi");

        javax.swing.GroupLayout pnlSubMenuAdmin_BahanProduksiLayout = new javax.swing.GroupLayout(pnlSubMenuAdmin_BahanProduksi);
        pnlSubMenuAdmin_BahanProduksi.setLayout(pnlSubMenuAdmin_BahanProduksiLayout);
        pnlSubMenuAdmin_BahanProduksiLayout.setHorizontalGroup(
            pnlSubMenuAdmin_BahanProduksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsLKP3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        pnlSubMenuAdmin_BahanProduksiLayout.setVerticalGroup(
            pnlSubMenuAdmin_BahanProduksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsLKP3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlSubMenuAdmin.add(pnlSubMenuAdmin_BahanProduksi, new java.awt.GridBagConstraints());

        pnlWsSeparator5.setBackground(new Color(255,255,255,0));
        pnlWsSeparator5.setPreferredSize(new java.awt.Dimension(10, 50));

        javax.swing.GroupLayout pnlWsSeparator5Layout = new javax.swing.GroupLayout(pnlWsSeparator5);
        pnlWsSeparator5.setLayout(pnlWsSeparator5Layout);
        pnlWsSeparator5Layout.setHorizontalGroup(
            pnlWsSeparator5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        pnlWsSeparator5Layout.setVerticalGroup(
            pnlWsSeparator5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        pnlSubMenuAdmin.add(pnlWsSeparator5, new java.awt.GridBagConstraints());

        pnlSubMenuAdmin_Biaya.setBackground(new Color(34,59,14,50));
        pnlSubMenuAdmin_Biaya.setName("pnlSubMenuAdmin_Biaya"); // NOI18N
        pnlSubMenuAdmin_Biaya.setPreferredSize(new java.awt.Dimension(200, 50));

        lblWsLKP4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblWsLKP4.setForeground(new java.awt.Color(255, 255, 255));
        lblWsLKP4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWsLKP4.setText("Biaya Produksi");

        javax.swing.GroupLayout pnlSubMenuAdmin_BiayaLayout = new javax.swing.GroupLayout(pnlSubMenuAdmin_Biaya);
        pnlSubMenuAdmin_Biaya.setLayout(pnlSubMenuAdmin_BiayaLayout);
        pnlSubMenuAdmin_BiayaLayout.setHorizontalGroup(
            pnlSubMenuAdmin_BiayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsLKP4, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        pnlSubMenuAdmin_BiayaLayout.setVerticalGroup(
            pnlSubMenuAdmin_BiayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsLKP4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlSubMenuAdmin.add(pnlSubMenuAdmin_Biaya, new java.awt.GridBagConstraints());

        pnlSubMenuHolder.add(pnlSubMenuAdmin, "crdSubMenuAdmin");

        pnlSubMenuTMA.setBackground(new Color(255,255,255,150));
        pnlSubMenuTMA.setName("pnlSubMenuAdmin"); // NOI18N
        pnlSubMenuTMA.setLayout(new java.awt.GridBagLayout());

        pnlSubMenuTMA_Rekap.setBackground(new Color(34,59,14,50));
        pnlSubMenuTMA_Rekap.setName("pnlSubMenuTMA_Rekap"); // NOI18N
        pnlSubMenuTMA_Rekap.setPreferredSize(new java.awt.Dimension(200, 50));

        lblWsRDKK4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblWsRDKK4.setForeground(new java.awt.Color(255, 255, 255));
        lblWsRDKK4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWsRDKK4.setText("Rekapitulasi Biaya TMA");

        javax.swing.GroupLayout pnlSubMenuTMA_RekapLayout = new javax.swing.GroupLayout(pnlSubMenuTMA_Rekap);
        pnlSubMenuTMA_Rekap.setLayout(pnlSubMenuTMA_RekapLayout);
        pnlSubMenuTMA_RekapLayout.setHorizontalGroup(
            pnlSubMenuTMA_RekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsRDKK4, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        pnlSubMenuTMA_RekapLayout.setVerticalGroup(
            pnlSubMenuTMA_RekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsRDKK4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlSubMenuTMA.add(pnlSubMenuTMA_Rekap, new java.awt.GridBagConstraints());

        pnlSubMenuHolder.add(pnlSubMenuTMA, "crdSubMenuTMA");

        lypMenuUtama.setLayer(pnlBackground, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypMenuUtama.setLayer(pnlMenuHolder, javax.swing.JLayeredPane.PALETTE_LAYER);
        lypMenuUtama.setLayer(pnlSubMenuHolder, javax.swing.JLayeredPane.MODAL_LAYER);

        javax.swing.GroupLayout lypMenuUtamaLayout = new javax.swing.GroupLayout(lypMenuUtama);
        lypMenuUtama.setLayout(lypMenuUtamaLayout);
        lypMenuUtamaLayout.setHorizontalGroup(
            lypMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlSubMenuHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMenuHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lypMenuUtamaLayout.setVerticalGroup(
            lypMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lypMenuUtamaLayout.createSequentialGroup()
                .addGroup(lypMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lypMenuUtamaLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(pnlMenuHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lypMenuUtamaLayout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(pnlSubMenuHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMenuUtamaLayout = new javax.swing.GroupLayout(pnlMenuUtama);
        pnlMenuUtama.setLayout(pnlMenuUtamaLayout);
        pnlMenuUtamaLayout.setHorizontalGroup(
            pnlMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypMenuUtama)
        );
        pnlMenuUtamaLayout.setVerticalGroup(
            pnlMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypMenuUtama)
        );

        pnlContent.add(pnlMenuUtama, "crdPnlMenuUtama");

        pnlFrmRDKK.setBackground(new java.awt.Color(0, 70, 70));

        pnlFrmRDKKMenuHolder.setOpaque(false);

        pnlFrmRDKKBack.setBackground(new Color(255,255,255,0));
        pnlFrmRDKKBack.setName("pnlFrmRDKKBack"); // NOI18N
        pnlFrmRDKKBack.setPreferredSize(new java.awt.Dimension(140, 40));

        lblFrmRDKKBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmRDKKBack.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKKBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Back_To_26px.png"))); // NOI18N
        lblFrmRDKKBack.setText("Menu Utama");
        lblFrmRDKKBack.setIconTextGap(10);
        lblFrmRDKKBack.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlFrmRDKKBackLayout = new javax.swing.GroupLayout(pnlFrmRDKKBack);
        pnlFrmRDKKBack.setLayout(pnlFrmRDKKBackLayout);
        pnlFrmRDKKBackLayout.setHorizontalGroup(
            pnlFrmRDKKBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrmRDKKBackLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFrmRDKKBack, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );
        pnlFrmRDKKBackLayout.setVerticalGroup(
            pnlFrmRDKKBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFrmRDKKBack, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        pnlFrmRDKKJudul.setBackground(new java.awt.Color(0, 153, 153));
        pnlFrmRDKKJudul.setName("pnlFrmRDKKBack"); // NOI18N
        pnlFrmRDKKJudul.setOpaque(false);
        pnlFrmRDKKJudul.setPreferredSize(new java.awt.Dimension(140, 40));

        lblFrmRDKKJudul.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmRDKKJudul.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKKJudul.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblFrmRDKKJudul.setIconTextGap(0);
        lblFrmRDKKJudul.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlFrmRDKKJudulLayout = new javax.swing.GroupLayout(pnlFrmRDKKJudul);
        pnlFrmRDKKJudul.setLayout(pnlFrmRDKKJudulLayout);
        pnlFrmRDKKJudulLayout.setHorizontalGroup(
            pnlFrmRDKKJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrmRDKKJudulLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFrmRDKKJudul, javax.swing.GroupLayout.DEFAULT_SIZE, 1209, Short.MAX_VALUE))
        );
        pnlFrmRDKKJudulLayout.setVerticalGroup(
            pnlFrmRDKKJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFrmRDKKJudul, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlFrmRDKKMenuHolderLayout = new javax.swing.GroupLayout(pnlFrmRDKKMenuHolder);
        pnlFrmRDKKMenuHolder.setLayout(pnlFrmRDKKMenuHolderLayout);
        pnlFrmRDKKMenuHolderLayout.setHorizontalGroup(
            pnlFrmRDKKMenuHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrmRDKKMenuHolderLayout.createSequentialGroup()
                .addComponent(pnlFrmRDKKBack, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlFrmRDKKJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 1219, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlFrmRDKKMenuHolderLayout.setVerticalGroup(
            pnlFrmRDKKMenuHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrmRDKKBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlFrmRDKKJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlFrmRDKKContent.setBackground(new java.awt.Color(0, 23, 23));

        jScrollPane1.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane1.setBorder(null);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(0, 0));

        tblKelompokTani.setBackground(new java.awt.Color(245, 245, 245));
        tblKelompokTani.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80)));
        tblKelompokTani.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblKelompokTani.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblKelompokTani.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblKelompokTani.setAutoscrolls(false);
        tblKelompokTani.setGridColor(new java.awt.Color(255, 255, 255));
        tblKelompokTani.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblKelompokTani.setName("tblKelompokTani"); // NOI18N
        tblKelompokTani.setRowHeight(24);
        tblKelompokTani.setShowHorizontalLines(false);
        tblKelompokTani.setShowVerticalLines(false);
        tblKelompokTani.getTableHeader().setResizingAllowed(false);
        tblKelompokTani.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblKelompokTani);

        pnlFrmRDKKJudulKelTani.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmRDKKJudulKelTani.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDataKelTani.setBackground(new java.awt.Color(85, 131, 131));
        lblDataKelTani.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDataKelTani.setForeground(new java.awt.Color(255, 255, 255));
        lblDataKelTani.setText("Data Kelompok Tani");
        lblDataKelTani.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblDataKelTani.setOpaque(true);
        pnlFrmRDKKJudulKelTani.add(lblDataKelTani, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 28));

        jtfFrmRDKKCari.setBackground(new java.awt.Color(85, 131, 131));
        jtfFrmRDKKCari.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jtfFrmRDKKCari.setForeground(new java.awt.Color(255, 255, 255));
        jtfFrmRDKKCari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jtfFrmRDKKCari.setCaretColor(new java.awt.Color(255, 255, 255));
        jtfFrmRDKKCari.setMargin(new java.awt.Insets(2, 4, 2, 2));
        pnlFrmRDKKJudulKelTani.add(jtfFrmRDKKCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 4, 250, 20));

        lblSearchIcon.setBackground(new java.awt.Color(85, 131, 131));
        lblSearchIcon.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblSearchIcon.setForeground(new java.awt.Color(51, 51, 51));
        lblSearchIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Search_20px.png"))); // NOI18N
        lblSearchIcon.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 4));
        lblSearchIcon.setOpaque(true);
        pnlFrmRDKKJudulKelTani.add(lblSearchIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 30, 28));

        pnlFrmRDKKClearSearch.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmRDKKClearSearch.setName("pnlFrmRDKKClearSearch"); // NOI18N
        pnlFrmRDKKClearSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmRDKKClearSearch.setBackground(new java.awt.Color(141, 172, 172));
        lblFrmRDKKClearSearch.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblFrmRDKKClearSearch.setForeground(new java.awt.Color(51, 51, 51));
        lblFrmRDKKClearSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmRDKKClearSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Clear_Symbol_20px.png"))); // NOI18N
        lblFrmRDKKClearSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 4));
        pnlFrmRDKKClearSearch.add(lblFrmRDKKClearSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 28));

        pnlFrmRDKKJudulKelTani.add(pnlFrmRDKKClearSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, -1, -1));

        javax.swing.GroupLayout pnlFrmRDKKContentLayout = new javax.swing.GroupLayout(pnlFrmRDKKContent);
        pnlFrmRDKKContent.setLayout(pnlFrmRDKKContentLayout);
        pnlFrmRDKKContentLayout.setHorizontalGroup(
            pnlFrmRDKKContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrmRDKKContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFrmRDKKContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFrmRDKKJudulKelTani, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFrmRDKKContentLayout.setVerticalGroup(
            pnlFrmRDKKContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrmRDKKContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFrmRDKKJudulKelTani, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(403, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlFrmRDKKLayout = new javax.swing.GroupLayout(pnlFrmRDKK);
        pnlFrmRDKK.setLayout(pnlFrmRDKKLayout);
        pnlFrmRDKKLayout.setHorizontalGroup(
            pnlFrmRDKKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrmRDKKMenuHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlFrmRDKKContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlFrmRDKKLayout.setVerticalGroup(
            pnlFrmRDKKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrmRDKKLayout.createSequentialGroup()
                .addComponent(pnlFrmRDKKMenuHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlFrmRDKKContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pnlContent.add(pnlFrmRDKK, "crdDorman");

        pnlFrmInputRDKK.setBackground(new java.awt.Color(0, 23, 23));
        pnlFrmInputRDKK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmInputRDKK_MenuHolder.setBackground(new java.awt.Color(0, 70, 70));
        pnlFrmInputRDKK_MenuHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmInputRDKK_Back.setBackground(new Color(255,255,255,0));
        pnlFrmInputRDKK_Back.setName("pnlFrmInputRDKK_Back"); // NOI18N
        pnlFrmInputRDKK_Back.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlFrmInputRDKK_Back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmInputRDKK_Back.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Back_To_26px.png"))); // NOI18N
        lblFrmInputRDKK_Back.setText("Menu Utama");
        lblFrmInputRDKK_Back.setIconTextGap(10);
        lblFrmInputRDKK_Back.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmInputRDKK_Back.add(lblFrmInputRDKK_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        pnlFrmInputRDKK_MenuHolder.add(pnlFrmInputRDKK_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        pnlFrmRDKK_Title.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmRDKK_Title.setName("pnlFrmRDKKBack"); // NOI18N
        pnlFrmRDKK_Title.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlFrmRDKK_Title.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        lblFrmRDKK_Title.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmRDKK_Title.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKK_Title.setText("Pendaftaran Kelompok Tani Baru");
        lblFrmRDKK_Title.setPreferredSize(new java.awt.Dimension(300, 40));
        pnlFrmRDKK_Title.add(lblFrmRDKK_Title);

        pnlFrmInputRDKK_MenuHolder.add(pnlFrmRDKK_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 1190, -1));

        pnlFrmInputRDKK.add(pnlFrmInputRDKK_MenuHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1399, -1));

        pnlFrmInputRDKK_Content.setBackground(new java.awt.Color(35, 35, 0));
        pnlFrmInputRDKK_Content.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnlFrmInputRDKK_Content.setOpaque(false);

        lblInputNamaKelTani.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani.setText("Nama Ketua Kel.");

        jtfInputRDKKNamaKoord.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jtfInputRDKKNamaKoord.setForeground(new java.awt.Color(255, 255, 255));
        jtfInputRDKKNamaKoord.setBorder(null);
        jtfInputRDKKNamaKoord.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfInputRDKKNamaKoord.setOpaque(false);

        javax.swing.GroupLayout pnlUnderline1Layout = new javax.swing.GroupLayout(pnlUnderline1);
        pnlUnderline1.setLayout(pnlUnderline1Layout);
        pnlUnderline1Layout.setHorizontalGroup(
            pnlUnderline1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlUnderline1Layout.setVerticalGroup(
            pnlUnderline1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        lblInputNamaKelTani1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani1.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani1.setText("No. KTP Ketua Kel.");

        jtfInputNoKtpKoord.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jtfInputNoKtpKoord.setForeground(new java.awt.Color(255, 255, 255));
        jtfInputNoKtpKoord.setBorder(null);
        jtfInputNoKtpKoord.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfInputNoKtpKoord.setOpaque(false);

        javax.swing.GroupLayout pnlUnderline2Layout = new javax.swing.GroupLayout(pnlUnderline2);
        pnlUnderline2.setLayout(pnlUnderline2Layout);
        pnlUnderline2Layout.setHorizontalGroup(
            pnlUnderline2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        pnlUnderline2Layout.setVerticalGroup(
            pnlUnderline2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        lblInputNamaKelTani2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani2.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani2.setText("Kecamatan");

        cbxKecamatan.setBackground(new java.awt.Color(0, 102, 51));
        cbxKecamatan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxKecamatan.setBorder(null);
        cbxKecamatan.setName("cbxKecamatan"); // NOI18N

        cbxDesa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxDesa.setBorder(null);

        lblInputNamaKelTani3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani3.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani3.setText("Desa");

        pnlFrmInputRDKK_LanjutKoord.setBackground(new Color(255,255,255,0));
        pnlFrmInputRDKK_LanjutKoord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmInputRDKK_LanjutKoord.setName("pnlFrmInputRDKK_LanjutKoord"); // NOI18N
        pnlFrmInputRDKK_LanjutKoord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lanjutkan");
        pnlFrmInputRDKK_LanjutKoord.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlFrmInputRDKK_BatalKoord.setBackground(new Color(255,255,255,0));
        pnlFrmInputRDKK_BatalKoord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmInputRDKK_BatalKoord.setName("pnlFrmInputRDKK_BatalKoord"); // NOI18N
        pnlFrmInputRDKK_BatalKoord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Batal");
        pnlFrmInputRDKK_BatalKoord.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        lblInputNamaKelTani8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani8.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani8.setText("Kategori Tanaman");

        cbxKategoriTanaman.setBackground(new java.awt.Color(0, 102, 51));
        cbxKategoriTanaman.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxKategoriTanaman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TRIT I", "TRIT II", "TRIT III", "TRIT IV" }));
        cbxKategoriTanaman.setBorder(null);
        cbxKategoriTanaman.setName("cbxKategoriTanaman"); // NOI18N

        lblInputNamaKelTani5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani5.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani5.setText("Masa Tanam");

        cbxInputRDKKMasaTanam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxInputRDKKMasaTanam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1A", "1B", "2A", "2B", "3A", "3B", "4A", "4B", "5A", "5B", "6A", "6B", "7A", "7B", "8A", "8B", "9A", "9B", "10A", "10B", "11A", "11B", "12A", "12B" }));
        cbxInputRDKKMasaTanam.setSelectedIndex(-1);
        cbxInputRDKKMasaTanam.setToolTipText("");
        cbxInputRDKKMasaTanam.setBorder(null);

        lblInputNamaKelTani19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani19.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani19.setText("Afdeling");

        cbxFrmInputRDKK_Afdeling.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxFrmInputRDKK_Afdeling.setBorder(null);
        cbxFrmInputRDKK_Afdeling.setEnabled(false);

        javax.swing.GroupLayout pnlFrmInputRDKK_ContentLayout = new javax.swing.GroupLayout(pnlFrmInputRDKK_Content);
        pnlFrmInputRDKK_Content.setLayout(pnlFrmInputRDKK_ContentLayout);
        pnlFrmInputRDKK_ContentLayout.setHorizontalGroup(
            pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                        .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                                .addComponent(lblInputNamaKelTani)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfInputRDKKNamaKoord, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                    .addComponent(pnlUnderline1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                                .addComponent(lblInputNamaKelTani1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfInputNoKtpKoord)
                                    .addComponent(pnlUnderline2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                        .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                                .addComponent(lblInputNamaKelTani2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxKecamatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                                .addComponent(lblInputNamaKelTani3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                                        .addComponent(pnlFrmInputRDKK_LanjutKoord, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(pnlFrmInputRDKK_BatalKoord, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbxDesa, 0, 296, Short.MAX_VALUE)))
                            .addGroup(pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblInputNamaKelTani8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblInputNamaKelTani5))
                                .addGap(18, 18, 18)
                                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxKategoriTanaman, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                                        .addComponent(cbxInputRDKKMasaTanam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                                .addComponent(lblInputNamaKelTani19, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxFrmInputRDKK_Afdeling, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlFrmInputRDKK_ContentLayout.setVerticalGroup(
            pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblInputNamaKelTani)
                            .addComponent(jtfInputRDKKNamaKoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(pnlUnderline1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                        .addComponent(jtfInputNoKtpKoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(pnlUnderline2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblInputNamaKelTani1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInputNamaKelTani8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxKategoriTanaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInputNamaKelTani5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxInputRDKKMasaTanam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInputNamaKelTani2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxKecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInputNamaKelTani3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInputNamaKelTani19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFrmInputRDKK_Afdeling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFrmInputRDKK_BatalKoord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFrmInputRDKK_LanjutKoord, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(224, Short.MAX_VALUE))
        );

        pnlFrmInputRDKK.add(pnlFrmInputRDKK_Content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 470, 630));

        pnlFrmInputRDKK_ContainerInputPetani.setOpaque(false);
        pnlFrmInputRDKK_ContainerInputPetani.setPreferredSize(new java.awt.Dimension(444, 305));
        pnlFrmInputRDKK_ContainerInputPetani.setLayout(new java.awt.CardLayout());

        pnlBlank.setName(""); // NOI18N
        pnlBlank.setOpaque(false);

        javax.swing.GroupLayout pnlBlankLayout = new javax.swing.GroupLayout(pnlBlank);
        pnlBlank.setLayout(pnlBlankLayout);
        pnlBlankLayout.setHorizontalGroup(
            pnlBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );
        pnlBlankLayout.setVerticalGroup(
            pnlBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        pnlFrmInputRDKK_ContainerInputPetani.add(pnlBlank, "crdInputPetani_Blank");

        pnlTblInputPetani.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlTblInputPetani.setOpaque(false);

        tblInputPetani.setBackground(new java.awt.Color(245, 245, 245));
        tblInputPetani.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(80, 80, 80), 1, true));
        tblInputPetani.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblInputPetani.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblInputPetani.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblInputPetani.setAutoscrolls(false);
        tblInputPetani.setGridColor(new java.awt.Color(255, 255, 255));
        tblInputPetani.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblInputPetani.setName("tblInputPetani"); // NOI18N
        tblInputPetani.setRowHeight(24);
        tblInputPetani.setShowHorizontalLines(false);
        tblInputPetani.setShowVerticalLines(false);
        tblInputPetani.getTableHeader().setResizingAllowed(false);
        tblInputPetani.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblInputPetani);

        lblInputNamaKelTani4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani4.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani4.setText("Nama Petani");

        jtfInputRDKKNamaPetani.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfInputRDKKNamaPetani.setForeground(new java.awt.Color(255, 255, 255));
        jtfInputRDKKNamaPetani.setBorder(null);
        jtfInputRDKKNamaPetani.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfInputRDKKNamaPetani.setOpaque(false);

        javax.swing.GroupLayout pnlUnderline3Layout = new javax.swing.GroupLayout(pnlUnderline3);
        pnlUnderline3.setLayout(pnlUnderline3Layout);
        pnlUnderline3Layout.setHorizontalGroup(
            pnlUnderline3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        pnlUnderline3Layout.setVerticalGroup(
            pnlUnderline3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        lblInputNamaKelTani6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani6.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani6.setText("Varietas");

        cbxInputRDKKVarietas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxInputRDKKVarietas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1A", "1B", "2A", "2B", "3A", "3B", "4A", "4B", "5A", "5B", "6A", "6B", "7A", "7B", "8A", "8B", "9A", "9B", "10A", "10B", "11A", "11B", "12A", "12B" }));
        cbxInputRDKKVarietas.setSelectedIndex(-1);
        cbxInputRDKKVarietas.setBorder(null);
        cbxInputRDKKVarietas.setName("cbxInputRDKKVarietas"); // NOI18N

        lblInputNamaKelTani7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani7.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani7.setText("Luas Areal");

        javax.swing.GroupLayout pnlUnderline4Layout = new javax.swing.GroupLayout(pnlUnderline4);
        pnlUnderline4.setLayout(pnlUnderline4Layout);
        pnlUnderline4Layout.setHorizontalGroup(
            pnlUnderline4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnlUnderline4Layout.setVerticalGroup(
            pnlUnderline4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jftInputRDKKLuas.setBorder(null);
        jftInputRDKKLuas.setForeground(new java.awt.Color(255, 255, 255));
        jftInputRDKKLuas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.0#"))));
        jftInputRDKKLuas.setCaretColor(new java.awt.Color(204, 204, 204));
        jftInputRDKKLuas.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jftInputRDKKLuas.setOpaque(false);

        pnlFrmInputRDKK_TambahPetani.setBackground(new Color(255,255,255,0));
        pnlFrmInputRDKK_TambahPetani.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmInputRDKK_TambahPetani.setName("pnlFrmInputRDKK_TambahPetani"); // NOI18N
        pnlFrmInputRDKK_TambahPetani.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tambahkan");
        pnlFrmInputRDKK_TambahPetani.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlFrmInputRDKK_Hapus.setBackground(new Color(255,255,255,0));
        pnlFrmInputRDKK_Hapus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmInputRDKK_Hapus.setName("pnlFrmInputRDKK_Hapus"); // NOI18N
        pnlFrmInputRDKK_Hapus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Hapus");
        pnlFrmInputRDKK_Hapus.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jPanel1.setBackground(new java.awt.Color(85, 131, 131));
        jPanel1.setPreferredSize(new java.awt.Dimension(123, 28));

        lblInputNamaKelTani9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani9.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani9.setText("Detail Petani");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInputNamaKelTani9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblInputNamaKelTani9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        pnlFrmInputRDKK_SimpanData.setBackground(new Color(255,255,255,0));
        pnlFrmInputRDKK_SimpanData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmInputRDKK_SimpanData.setName("pnlFrmInputRDKK_SimpanData"); // NOI18N
        pnlFrmInputRDKK_SimpanData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Simpan Data");
        pnlFrmInputRDKK_SimpanData.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        lblInputNamaKelTani10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani10.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani10.setText("Easting");

        jftInputRDKKEasting.setBorder(null);
        jftInputRDKKEasting.setForeground(new java.awt.Color(255, 255, 255));
        jftInputRDKKEasting.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.0#"))));
        jftInputRDKKEasting.setCaretColor(new java.awt.Color(204, 204, 204));
        jftInputRDKKEasting.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jftInputRDKKEasting.setOpaque(false);

        javax.swing.GroupLayout pnlUnderline5Layout = new javax.swing.GroupLayout(pnlUnderline5);
        pnlUnderline5.setLayout(pnlUnderline5Layout);
        pnlUnderline5Layout.setHorizontalGroup(
            pnlUnderline5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlUnderline5Layout.setVerticalGroup(
            pnlUnderline5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        lblInputNamaKelTani11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani11.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani11.setText("Northing");

        jftInputRDKKNorthing.setBorder(null);
        jftInputRDKKNorthing.setForeground(new java.awt.Color(255, 255, 255));
        jftInputRDKKNorthing.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.0#"))));
        jftInputRDKKNorthing.setCaretColor(new java.awt.Color(204, 204, 204));
        jftInputRDKKNorthing.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jftInputRDKKNorthing.setOpaque(false);

        javax.swing.GroupLayout pnlUnderline6Layout = new javax.swing.GroupLayout(pnlUnderline6);
        pnlUnderline6.setLayout(pnlUnderline6Layout);
        pnlUnderline6Layout.setHorizontalGroup(
            pnlUnderline6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlUnderline6Layout.setVerticalGroup(
            pnlUnderline6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        lblInputNamaKelTani12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani12.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani12.setText("Koordinat Lokasi");

        javax.swing.GroupLayout pnlTblInputPetaniLayout = new javax.swing.GroupLayout(pnlTblInputPetani);
        pnlTblInputPetani.setLayout(pnlTblInputPetaniLayout);
        pnlTblInputPetaniLayout.setHorizontalGroup(
            pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTblInputPetaniLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)))
            .addGroup(pnlTblInputPetaniLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTblInputPetaniLayout.createSequentialGroup()
                            .addComponent(lblInputNamaKelTani7)
                            .addGap(33, 33, 33)
                            .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jftInputRDKKLuas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pnlUnderline4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(lblInputNamaKelTani6)
                            .addGap(18, 18, 18)
                            .addComponent(cbxInputRDKKVarietas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTblInputPetaniLayout.createSequentialGroup()
                            .addComponent(lblInputNamaKelTani4)
                            .addGap(18, 18, 18)
                            .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfInputRDKKNamaPetani)
                                .addComponent(pnlUnderline3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlTblInputPetaniLayout.createSequentialGroup()
                        .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInputNamaKelTani10)
                            .addComponent(lblInputNamaKelTani11))
                        .addGap(41, 41, 41)
                        .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pnlUnderline6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jftInputRDKKNorthing, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlTblInputPetaniLayout.createSequentialGroup()
                                .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(pnlUnderline5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jftInputRDKKEasting, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTblInputPetaniLayout.createSequentialGroup()
                                        .addComponent(pnlFrmInputRDKK_TambahPetani, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pnlFrmInputRDKK_Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlFrmInputRDKK_SimpanData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblInputNamaKelTani12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTblInputPetaniLayout.setVerticalGroup(
            pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTblInputPetaniLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfInputRDKKNamaPetani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTblInputPetaniLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(pnlUnderline3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblInputNamaKelTani4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblInputNamaKelTani6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxInputRDKKVarietas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTblInputPetaniLayout.createSequentialGroup()
                            .addComponent(jftInputRDKKLuas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(pnlUnderline4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblInputNamaKelTani7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(lblInputNamaKelTani12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlTblInputPetaniLayout.createSequentialGroup()
                        .addComponent(jftInputRDKKEasting, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(pnlUnderline5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblInputNamaKelTani10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblInputNamaKelTani11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTblInputPetaniLayout.createSequentialGroup()
                        .addComponent(jftInputRDKKNorthing, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnlUnderline6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFrmInputRDKK_TambahPetani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFrmInputRDKK_Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFrmInputRDKK_SimpanData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlFrmInputRDKK_ContainerInputPetani.add(pnlTblInputPetani, "crdInputPetani_Table");

        pnlFrmInputRDKK.add(pnlFrmInputRDKK_ContainerInputPetani, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 446, 470));

        pnlContent.add(pnlFrmInputRDKK, "crdFrmInputRDKK");

        pnlFrmValidasiRDKK.setBackground(new java.awt.Color(0, 23, 23));
        pnlFrmValidasiRDKK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmInputRDKK_MenuHolder1.setBackground(new java.awt.Color(0, 70, 70));
        pnlFrmInputRDKK_MenuHolder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmValidasiRDKK_Back.setBackground(new Color(255,255,255,0));
        pnlFrmValidasiRDKK_Back.setName("pnlFrmValidasiRDKK_Back"); // NOI18N
        pnlFrmValidasiRDKK_Back.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlFrmValidasiRDKK_Back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmInputRDKK_Back1.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Back_To_26px.png"))); // NOI18N
        lblFrmInputRDKK_Back1.setText("Menu Utama");
        lblFrmInputRDKK_Back1.setIconTextGap(10);
        lblFrmInputRDKK_Back1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmValidasiRDKK_Back.add(lblFrmInputRDKK_Back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        pnlFrmInputRDKK_MenuHolder1.add(pnlFrmValidasiRDKK_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        pnlFrmRDKK_Title1.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmRDKK_Title1.setName("pnlFrmRDKKBack"); // NOI18N
        pnlFrmRDKK_Title1.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlFrmRDKK_Title1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        lblFrmRDKK_Title1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmRDKK_Title1.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKK_Title1.setText("Validasi RDKK");
        lblFrmRDKK_Title1.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlFrmRDKK_Title1.add(lblFrmRDKK_Title1);

        pnlFrmInputRDKK_MenuHolder1.add(pnlFrmRDKK_Title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 1190, -1));

        pnlFrmValidasiRDKK.add(pnlFrmInputRDKK_MenuHolder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1399, -1));

        jScrollPane2.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane2.setBorder(null);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setMinimumSize(new java.awt.Dimension(0, 0));

        tblValidasiRDKK.setBackground(new java.awt.Color(170, 193, 193));
        tblValidasiRDKK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblValidasiRDKK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblValidasiRDKK.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblValidasiRDKK.setAutoscrolls(false);
        tblValidasiRDKK.setFillsViewportHeight(true);
        tblValidasiRDKK.setGridColor(new java.awt.Color(255, 255, 255));
        tblValidasiRDKK.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblValidasiRDKK.setName("tblValidasiRDKK"); // NOI18N
        tblValidasiRDKK.setOpaque(false);
        tblValidasiRDKK.setRowHeight(24);
        tblValidasiRDKK.setShowHorizontalLines(false);
        tblValidasiRDKK.setShowVerticalLines(false);
        tblValidasiRDKK.getTableHeader().setResizingAllowed(false);
        tblValidasiRDKK.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblValidasiRDKK);

        pnlFrmValidasiRDKK.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 629, 268));

        jPanel2.setBackground(new java.awt.Color(85, 131, 131));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Daftar Kelompok Tani");

        jtfFrmValidasiRDKK_SearchKoord.setBackground(new java.awt.Color(85, 131, 131));
        jtfFrmValidasiRDKK_SearchKoord.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfFrmValidasiRDKK_SearchKoord.setForeground(new java.awt.Color(255, 255, 255));
        jtfFrmValidasiRDKK_SearchKoord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jtfFrmValidasiRDKK_SearchKoord.setCaretColor(new java.awt.Color(255, 255, 255));
        jtfFrmValidasiRDKK_SearchKoord.setMargin(new java.awt.Insets(2, 4, 2, 2));

        lblSearchIcon1.setBackground(new java.awt.Color(85, 131, 131));
        lblSearchIcon1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblSearchIcon1.setForeground(new java.awt.Color(51, 51, 51));
        lblSearchIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Search_20px.png"))); // NOI18N
        lblSearchIcon1.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 4));
        lblSearchIcon1.setOpaque(true);

        pnlFrmValidasiRDKK_ClearKoord.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmValidasiRDKK_ClearKoord.setName("pnlFrmValidasiRDKK_ClearKoord"); // NOI18N
        pnlFrmValidasiRDKK_ClearKoord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmRDKKClearSearch1.setBackground(new java.awt.Color(141, 172, 172));
        lblFrmRDKKClearSearch1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblFrmRDKKClearSearch1.setForeground(new java.awt.Color(51, 51, 51));
        lblFrmRDKKClearSearch1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmRDKKClearSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Clear_Symbol_20px.png"))); // NOI18N
        lblFrmRDKKClearSearch1.setAlignmentY(0.0F);
        lblFrmRDKKClearSearch1.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 4));
        lblFrmRDKKClearSearch1.setIconTextGap(0);
        lblFrmRDKKClearSearch1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnlFrmValidasiRDKK_ClearKoord.add(lblFrmRDKKClearSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(lblSearchIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfFrmValidasiRDKK_SearchKoord, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFrmValidasiRDKK_ClearKoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSearchIcon1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlFrmValidasiRDKK_ClearKoord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jtfFrmValidasiRDKK_SearchKoord, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pnlFrmValidasiRDKK.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 629, 30));

        jScrollPane4.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane4.setBorder(null);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setMinimumSize(new java.awt.Dimension(0, 0));

        tblValidasiRDKK_Petani.setBackground(new java.awt.Color(170, 193, 193));
        tblValidasiRDKK_Petani.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblValidasiRDKK_Petani.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblValidasiRDKK_Petani.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblValidasiRDKK_Petani.setAutoscrolls(false);
        tblValidasiRDKK_Petani.setFillsViewportHeight(true);
        tblValidasiRDKK_Petani.setGridColor(new java.awt.Color(255, 255, 255));
        tblValidasiRDKK_Petani.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblValidasiRDKK_Petani.setName("tblKelompokTani"); // NOI18N
        tblValidasiRDKK_Petani.setOpaque(false);
        tblValidasiRDKK_Petani.setRowHeight(24);
        tblValidasiRDKK_Petani.setShowHorizontalLines(false);
        tblValidasiRDKK_Petani.setShowVerticalLines(false);
        tblValidasiRDKK_Petani.getTableHeader().setResizingAllowed(false);
        tblValidasiRDKK_Petani.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblValidasiRDKK_Petani);

        pnlFrmValidasiRDKK.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 443, 200));

        jPanel3.setBackground(new java.awt.Color(85, 131, 131));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Detail Petani");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlFrmValidasiRDKK.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 443, 30));

        jPanel4.setOpaque(false);

        pnlFrmValidasiRDKK_CetakDraft.setBackground(new Color(255,255,255,0));
        pnlFrmValidasiRDKK_CetakDraft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmValidasiRDKK_CetakDraft.setName("pnlFrmValidasiRDKK_CetakDraft"); // NOI18N
        pnlFrmValidasiRDKK_CetakDraft.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlFrmValidasiRDKK_CetakDraft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back4.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back4.setText("Cetak Kontrak");
        lblFrmInputRDKK_Back4.setIconTextGap(10);
        lblFrmInputRDKK_Back4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmValidasiRDKK_CetakDraft.add(lblFrmInputRDKK_Back4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlFrmValidasiRDKK_CetakSKK.setBackground(new Color(255,255,255,0));
        pnlFrmValidasiRDKK_CetakSKK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmValidasiRDKK_CetakSKK.setName("pnlFrmValidasiRDKK_CetakSKK"); // NOI18N
        pnlFrmValidasiRDKK_CetakSKK.setPreferredSize(new java.awt.Dimension(100, 40));
        pnlFrmValidasiRDKK_CetakSKK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back5.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back5.setText("Cetak BA SKK");
        lblFrmInputRDKK_Back5.setIconTextGap(10);
        lblFrmInputRDKK_Back5.setPreferredSize(new java.awt.Dimension(206, 20));
        lblFrmInputRDKK_Back5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmValidasiRDKK_CetakSKK.add(lblFrmInputRDKK_Back5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(pnlFrmValidasiRDKK_CetakDraft, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFrmValidasiRDKK_CetakSKK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 234, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFrmValidasiRDKK_CetakDraft, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFrmValidasiRDKK_CetakSKK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        pnlFrmValidasiRDKK.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 285, 440, 60));

        pnlContent.add(pnlFrmValidasiRDKK, "crdFrmValidasiRDKK");

        pnlLogin.setBackground(new java.awt.Color(0, 23, 23));
        pnlLogin.setName("pnlLogin"); // NOI18N
        pnlLogin.setOpaque(false);

        lypMenuLogin.setDoubleBuffered(true);

        pnlBackgroundLogin.setBackground(new java.awt.Color(102, 102, 102));
        pnlBackgroundLogin.setName("pnlBackground"); // NOI18N

        lblBackground1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/sugarcane_5.jpg"))); // NOI18N
        lblBackground1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlBackgroundLoginLayout = new javax.swing.GroupLayout(pnlBackgroundLogin);
        pnlBackgroundLogin.setLayout(pnlBackgroundLoginLayout);
        pnlBackgroundLoginLayout.setHorizontalGroup(
            pnlBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBackground1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBackgroundLoginLayout.setVerticalGroup(
            pnlBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBackground1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlHolderLogin.setBackground(new Color(255,255,255,100));
        pnlHolderLogin.setPreferredSize(new java.awt.Dimension(1366, 200));
        pnlHolderLogin.setLayout(new java.awt.GridBagLayout());

        pnlLogoLogin.setBackground(new Color(34,59,14,50));
        pnlLogoLogin.setName("pnlMenuRDKK"); // NOI18N
        pnlLogoLogin.setPreferredSize(new java.awt.Dimension(150, 150));

        lblMenuRDKK1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMenuRDKK1.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuRDKK1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuRDKK1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Name_104px.png"))); // NOI18N
        lblMenuRDKK1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMenuRDKK1.setIconTextGap(10);
        lblMenuRDKK1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlLogoLoginLayout = new javax.swing.GroupLayout(pnlLogoLogin);
        pnlLogoLogin.setLayout(pnlLogoLoginLayout);
        pnlLogoLoginLayout.setHorizontalGroup(
            pnlLogoLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuRDKK1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlLogoLoginLayout.setVerticalGroup(
            pnlLogoLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuRDKK1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlHolderLogin.add(pnlLogoLogin, new java.awt.GridBagConstraints());

        pnlUserLogin.setBackground(new Color(34,59,14,50));
        pnlUserLogin.setName("pnlMenuPupuk"); // NOI18N
        pnlUserLogin.setPreferredSize(new java.awt.Dimension(350, 150));

        lblLoginUsername.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblLoginUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblLoginUsername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoginUsername.setText("Username");
        lblLoginUsername.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblLoginUsername.setIconTextGap(10);
        lblLoginUsername.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblLoginPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblLoginPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblLoginPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoginPassword.setText("Password");
        lblLoginPassword.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblLoginPassword.setIconTextGap(10);
        lblLoginPassword.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jtfLoginUsername.setBackground(new java.awt.Color(70, 70, 0));
        jtfLoginUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfLoginUsername.setForeground(new java.awt.Color(255, 255, 255));
        jtfLoginUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jtfLoginUsername.setCaretColor(new java.awt.Color(255, 255, 255));
        jtfLoginUsername.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jtpLoginPassword.setBackground(new java.awt.Color(70, 70, 0));
        jtpLoginPassword.setForeground(new java.awt.Color(255, 255, 255));
        jtpLoginPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jtpLoginPassword.setCaretColor(new java.awt.Color(255, 255, 255));
        jtpLoginPassword.setName("jtfLoginPassword"); // NOI18N
        jtpLoginPassword.setNextFocusableComponent(jLabel8);

        pnlLoginLogin.setBackground(new Color(255,255,255,0));
        pnlLoginLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlLoginLogin.setName("pnlLoginLogin"); // NOI18N
        pnlLoginLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Login");
        pnlLoginLogin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlLoginKeluar.setBackground(new Color(255,255,255,0));
        pnlLoginKeluar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlLoginKeluar.setName("pnlLoginKeluar"); // NOI18N
        pnlLoginKeluar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Keluar");
        pnlLoginKeluar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        javax.swing.GroupLayout pnlUserLoginLayout = new javax.swing.GroupLayout(pnlUserLogin);
        pnlUserLogin.setLayout(pnlUserLoginLayout);
        pnlUserLoginLayout.setHorizontalGroup(
            pnlUserLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlUserLoginLayout.createSequentialGroup()
                        .addComponent(lblLoginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfLoginUsername))
                    .addGroup(pnlUserLoginLayout.createSequentialGroup()
                        .addComponent(lblLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlUserLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlUserLoginLayout.createSequentialGroup()
                                .addComponent(pnlLoginLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlLoginKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtpLoginPassword))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlUserLoginLayout.setVerticalGroup(
            pnlUserLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserLoginLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlUserLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoginUsername)
                    .addComponent(jtfLoginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlUserLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoginPassword)
                    .addComponent(jtpLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlUserLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLoginLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlLoginKeluar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pnlHolderLogin.add(pnlUserLogin, new java.awt.GridBagConstraints());

        lypMenuLogin.setLayer(pnlBackgroundLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypMenuLogin.setLayer(pnlHolderLogin, javax.swing.JLayeredPane.PALETTE_LAYER);

        javax.swing.GroupLayout lypMenuLoginLayout = new javax.swing.GroupLayout(lypMenuLogin);
        lypMenuLogin.setLayout(lypMenuLoginLayout);
        lypMenuLoginLayout.setHorizontalGroup(
            lypMenuLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackgroundLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlHolderLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 1399, Short.MAX_VALUE)
        );
        lypMenuLoginLayout.setVerticalGroup(
            lypMenuLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackgroundLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(lypMenuLoginLayout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(pnlHolderLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 354, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypMenuLogin)
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lypMenuLogin)
        );

        pnlContent.add(pnlLogin, "crdLogin");

        pnlCetak.setBackground(new java.awt.Color(0, 23, 23));
        pnlCetak.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmInputRDKK_MenuHolder2.setBackground(new java.awt.Color(0, 70, 70));
        pnlFrmInputRDKK_MenuHolder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCetak_Kembali.setBackground(new Color(255,255,255,0));
        pnlCetak_Kembali.setName("pnlCetak_Kembali"); // NOI18N
        pnlCetak_Kembali.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlCetak_Kembali.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmInputRDKK_Back3.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Back_To_26px.png"))); // NOI18N
        lblFrmInputRDKK_Back3.setText("Kembali");
        lblFrmInputRDKK_Back3.setIconTextGap(10);
        lblFrmInputRDKK_Back3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlCetak_Kembali.add(lblFrmInputRDKK_Back3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        pnlFrmInputRDKK_MenuHolder2.add(pnlCetak_Kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        pnlCetak_Cetak.setBackground(new Color(255,255,255,0));
        pnlCetak_Cetak.setName("pnlCetak_Cetak"); // NOI18N
        pnlCetak_Cetak.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlCetak_Cetak.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmInputRDKK_Back6.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Print_26px.png"))); // NOI18N
        lblFrmInputRDKK_Back6.setText("Cetak");
        lblFrmInputRDKK_Back6.setIconTextGap(10);
        lblFrmInputRDKK_Back6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlCetak_Cetak.add(lblFrmInputRDKK_Back6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        pnlFrmInputRDKK_MenuHolder2.add(pnlCetak_Cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 180, -1));

        pnlCetak.add(pnlFrmInputRDKK_MenuHolder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, -1));

        javax.swing.GroupLayout pnlCetak_ContentLayout = new javax.swing.GroupLayout(pnlCetak_Content);
        pnlCetak_Content.setLayout(pnlCetak_ContentLayout);
        pnlCetak_ContentLayout.setHorizontalGroup(
            pnlCetak_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        pnlCetak_ContentLayout.setVerticalGroup(
            pnlCetak_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pnlCetak.add(pnlCetak_Content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1366, 600));

        pnlContent.add(pnlCetak, "crdPnlCetak");

        pnlFrmPupuk_Permintaan.setBackground(new java.awt.Color(0, 23, 23));
        pnlFrmPupuk_Permintaan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmInputRDKK_MenuHolder3.setBackground(new java.awt.Color(0, 70, 70));
        pnlFrmInputRDKK_MenuHolder3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmPupuk_Permintaan_Kembali.setBackground(new Color(255,255,255,0));
        pnlFrmPupuk_Permintaan_Kembali.setName("pnlFrmPupuk_Permintaan_Kembali"); // NOI18N
        pnlFrmPupuk_Permintaan_Kembali.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlFrmPupuk_Permintaan_Kembali.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmInputRDKK_Back7.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Back_To_26px.png"))); // NOI18N
        lblFrmInputRDKK_Back7.setText("Menu Utama");
        lblFrmInputRDKK_Back7.setIconTextGap(10);
        lblFrmInputRDKK_Back7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmPupuk_Permintaan_Kembali.add(lblFrmInputRDKK_Back7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        pnlFrmInputRDKK_MenuHolder3.add(pnlFrmPupuk_Permintaan_Kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        pnlFrmRDKK_Title2.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmRDKK_Title2.setName("pnlFrmRDKKBack"); // NOI18N
        pnlFrmRDKK_Title2.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlFrmRDKK_Title2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        lblFrmRDKK_Title2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmRDKK_Title2.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKK_Title2.setText("Permintaan Pupuk");
        lblFrmRDKK_Title2.setPreferredSize(new java.awt.Dimension(300, 40));
        pnlFrmRDKK_Title2.add(lblFrmRDKK_Title2);

        pnlFrmInputRDKK_MenuHolder3.add(pnlFrmRDKK_Title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 1190, -1));

        pnlFrmPupuk_Permintaan.add(pnlFrmInputRDKK_MenuHolder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, -1));

        jScrollPane5.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane5.setBorder(null);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane5.setMinimumSize(new java.awt.Dimension(0, 0));

        tblKelTani_Pupuk_Permintaan.setBackground(new java.awt.Color(170, 193, 193));
        tblKelTani_Pupuk_Permintaan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblKelTani_Pupuk_Permintaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblKelTani_Pupuk_Permintaan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblKelTani_Pupuk_Permintaan.setAutoscrolls(false);
        tblKelTani_Pupuk_Permintaan.setFillsViewportHeight(true);
        tblKelTani_Pupuk_Permintaan.setGridColor(new java.awt.Color(255, 255, 255));
        tblKelTani_Pupuk_Permintaan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblKelTani_Pupuk_Permintaan.setName("tblValidasiRDKK"); // NOI18N
        tblKelTani_Pupuk_Permintaan.setOpaque(false);
        tblKelTani_Pupuk_Permintaan.setRowHeight(24);
        tblKelTani_Pupuk_Permintaan.setShowHorizontalLines(false);
        tblKelTani_Pupuk_Permintaan.setShowVerticalLines(false);
        tblKelTani_Pupuk_Permintaan.getTableHeader().setResizingAllowed(false);
        tblKelTani_Pupuk_Permintaan.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tblKelTani_Pupuk_Permintaan);

        pnlFrmPupuk_Permintaan.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 629, 268));

        jPanel5.setBackground(new java.awt.Color(85, 131, 131));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Daftar Kelompok Tani");

        jtfFrmPupuk_Permintaan_Cari.setBackground(new java.awt.Color(85, 131, 131));
        jtfFrmPupuk_Permintaan_Cari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfFrmPupuk_Permintaan_Cari.setForeground(new java.awt.Color(255, 255, 255));
        jtfFrmPupuk_Permintaan_Cari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jtfFrmPupuk_Permintaan_Cari.setCaretColor(new java.awt.Color(255, 255, 255));
        jtfFrmPupuk_Permintaan_Cari.setMargin(new java.awt.Insets(2, 4, 2, 2));
        jtfFrmPupuk_Permintaan_Cari.setName("jtfFrmPupuk_Permintaan_Cari"); // NOI18N

        lblSearchIcon2.setBackground(new java.awt.Color(85, 131, 131));
        lblSearchIcon2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblSearchIcon2.setForeground(new java.awt.Color(51, 51, 51));
        lblSearchIcon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Search_20px.png"))); // NOI18N
        lblSearchIcon2.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 4));
        lblSearchIcon2.setOpaque(true);

        pnlFrmPupuk_Permintaan_Clear.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmPupuk_Permintaan_Clear.setName("pnlFrmPupuk_Permintaan_Clear"); // NOI18N
        pnlFrmPupuk_Permintaan_Clear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmRDKKClearSearch2.setBackground(new java.awt.Color(141, 172, 172));
        lblFrmRDKKClearSearch2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblFrmRDKKClearSearch2.setForeground(new java.awt.Color(51, 51, 51));
        lblFrmRDKKClearSearch2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmRDKKClearSearch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Clear_Symbol_20px.png"))); // NOI18N
        lblFrmRDKKClearSearch2.setAlignmentY(0.0F);
        lblFrmRDKKClearSearch2.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 4));
        lblFrmRDKKClearSearch2.setIconTextGap(0);
        lblFrmRDKKClearSearch2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnlFrmPupuk_Permintaan_Clear.add(lblFrmRDKKClearSearch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(lblSearchIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfFrmPupuk_Permintaan_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFrmPupuk_Permintaan_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSearchIcon2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlFrmPupuk_Permintaan_Clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jtfFrmPupuk_Permintaan_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pnlFrmPupuk_Permintaan.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 629, 30));

        jScrollPane6.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane6.setBorder(null);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane6.setMinimumSize(new java.awt.Dimension(0, 0));

        tblPetani_Pupuk_Permintaan.setBackground(new java.awt.Color(170, 193, 193));
        tblPetani_Pupuk_Permintaan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblPetani_Pupuk_Permintaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPetani_Pupuk_Permintaan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblPetani_Pupuk_Permintaan.setAutoscrolls(false);
        tblPetani_Pupuk_Permintaan.setFillsViewportHeight(true);
        tblPetani_Pupuk_Permintaan.setGridColor(new java.awt.Color(255, 255, 255));
        tblPetani_Pupuk_Permintaan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblPetani_Pupuk_Permintaan.setName("tblPetani_Pupuk_Permintaan"); // NOI18N
        tblPetani_Pupuk_Permintaan.setOpaque(false);
        tblPetani_Pupuk_Permintaan.setRowHeight(24);
        tblPetani_Pupuk_Permintaan.setShowHorizontalLines(false);
        tblPetani_Pupuk_Permintaan.setShowVerticalLines(false);
        tblPetani_Pupuk_Permintaan.getTableHeader().setResizingAllowed(false);
        tblPetani_Pupuk_Permintaan.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tblPetani_Pupuk_Permintaan);

        pnlFrmPupuk_Permintaan.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 80, 443, 200));

        jPanel6.setBackground(new java.awt.Color(85, 131, 131));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Jenis dan Dosis Pupuk");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(136, 136, 136))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlFrmPupuk_Permintaan.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1078, 50, 250, 30));

        pnlFrmPupuk_Permintaan_TambahPupuk.setBackground(new Color(255,255,255,0));
        pnlFrmPupuk_Permintaan_TambahPupuk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmPupuk_Permintaan_TambahPupuk.setName("pnlFrmPupuk_Permintaan_TambahPupuk"); // NOI18N
        pnlFrmPupuk_Permintaan_TambahPupuk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back8.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Plus_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back8.setText("Tambah");
        lblFrmInputRDKK_Back8.setIconTextGap(10);
        lblFrmInputRDKK_Back8.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmPupuk_Permintaan_TambahPupuk.add(lblFrmInputRDKK_Back8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlFrmPupuk_Permintaan.add(pnlFrmPupuk_Permintaan_TambahPupuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 284, -1, -1));

        jScrollPane7.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane7.setBorder(null);
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane7.setMinimumSize(new java.awt.Dimension(0, 0));

        tblJenisPupuk_Pupuk_Permintaan.setBackground(new java.awt.Color(170, 193, 193));
        tblJenisPupuk_Pupuk_Permintaan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblJenisPupuk_Pupuk_Permintaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblJenisPupuk_Pupuk_Permintaan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblJenisPupuk_Pupuk_Permintaan.setAutoscrolls(false);
        tblJenisPupuk_Pupuk_Permintaan.setFillsViewportHeight(true);
        tblJenisPupuk_Pupuk_Permintaan.setGridColor(new java.awt.Color(255, 255, 255));
        tblJenisPupuk_Pupuk_Permintaan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblJenisPupuk_Pupuk_Permintaan.setName("tblPetani_Pupuk_Permintaan"); // NOI18N
        tblJenisPupuk_Pupuk_Permintaan.setOpaque(false);
        tblJenisPupuk_Pupuk_Permintaan.setRowHeight(24);
        tblJenisPupuk_Pupuk_Permintaan.setShowHorizontalLines(false);
        tblJenisPupuk_Pupuk_Permintaan.setShowVerticalLines(false);
        tblJenisPupuk_Pupuk_Permintaan.getTableHeader().setResizingAllowed(false);
        tblJenisPupuk_Pupuk_Permintaan.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tblJenisPupuk_Pupuk_Permintaan);

        pnlFrmPupuk_Permintaan.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1078, 80, 250, 200));

        jPanel7.setBackground(new java.awt.Color(85, 131, 131));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Detail Petani");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlFrmPupuk_Permintaan.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 50, 443, 30));

        jcbFrmPupuk_PilihSemuaPetani.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jcbFrmPupuk_PilihSemuaPetani.setForeground(new java.awt.Color(255, 255, 255));
        jcbFrmPupuk_PilihSemuaPetani.setText("Pilih semua petani");
        jcbFrmPupuk_PilihSemuaPetani.setName("jcbFrmPupuk_PilihSemuaPetani"); // NOI18N
        jcbFrmPupuk_PilihSemuaPetani.setOpaque(false);
        pnlFrmPupuk_Permintaan.add(jcbFrmPupuk_PilihSemuaPetani, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 310, 150, 30));

        jcbFrmPupuk_PilihSemuaPupuk.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jcbFrmPupuk_PilihSemuaPupuk.setForeground(new java.awt.Color(255, 255, 255));
        jcbFrmPupuk_PilihSemuaPupuk.setText("Pilih semua jenis pupuk");
        jcbFrmPupuk_PilihSemuaPupuk.setName("jcbFrmPupuk_PilihSemuaPupuk"); // NOI18N
        jcbFrmPupuk_PilihSemuaPupuk.setOpaque(false);
        pnlFrmPupuk_Permintaan.add(jcbFrmPupuk_PilihSemuaPupuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 284, -1, 30));

        jScrollPane8.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane8.setBorder(null);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane8.setMinimumSize(new java.awt.Dimension(0, 0));

        tblBuffer_Pupuk_Permintaan.setBackground(new java.awt.Color(170, 193, 193));
        tblBuffer_Pupuk_Permintaan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblBuffer_Pupuk_Permintaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblBuffer_Pupuk_Permintaan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblBuffer_Pupuk_Permintaan.setAutoscrolls(false);
        tblBuffer_Pupuk_Permintaan.setFillsViewportHeight(true);
        tblBuffer_Pupuk_Permintaan.setGridColor(new java.awt.Color(255, 255, 255));
        tblBuffer_Pupuk_Permintaan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblBuffer_Pupuk_Permintaan.setName("tblValidasiRDKK"); // NOI18N
        tblBuffer_Pupuk_Permintaan.setOpaque(false);
        tblBuffer_Pupuk_Permintaan.setRowHeight(24);
        tblBuffer_Pupuk_Permintaan.setShowHorizontalLines(false);
        tblBuffer_Pupuk_Permintaan.setShowVerticalLines(false);
        tblBuffer_Pupuk_Permintaan.getTableHeader().setResizingAllowed(false);
        tblBuffer_Pupuk_Permintaan.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(tblBuffer_Pupuk_Permintaan);

        pnlFrmPupuk_Permintaan.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 383, 629, 268));

        jPanel8.setBackground(new java.awt.Color(85, 131, 131));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Daftar Permintaan Pupuk");

        pnlFrmPupuk_Permintaan_Clear1.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmPupuk_Permintaan_Clear1.setName("pnlFrmPupuk_Permintaan_Clear"); // NOI18N
        pnlFrmPupuk_Permintaan_Clear1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(pnlFrmPupuk_Permintaan_Clear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFrmPupuk_Permintaan_Clear1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlFrmPupuk_Permintaan.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 353, 629, 30));

        dtpTglTransaksiPupuk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlFrmPupuk_Permintaan.add(dtpTglTransaksiPupuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(955, 284, 120, 30));

        pnlFrmPupuk_Permintaan_SimpanData.setBackground(new Color(255,255,255,0));
        pnlFrmPupuk_Permintaan_SimpanData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmPupuk_Permintaan_SimpanData.setName("pnlFrmPupuk_Permintaan_SimpanData"); // NOI18N
        pnlFrmPupuk_Permintaan_SimpanData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back9.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Save_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back9.setText("Simpan");
        lblFrmInputRDKK_Back9.setIconTextGap(10);
        lblFrmInputRDKK_Back9.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmPupuk_Permintaan_SimpanData.add(lblFrmInputRDKK_Back9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlFrmPupuk_Permintaan.add(pnlFrmPupuk_Permintaan_SimpanData, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 284, -1, -1));

        pnlFrmPupuk_Permintaan_CetakPermintaan.setBackground(new Color(255,255,255,0));
        pnlFrmPupuk_Permintaan_CetakPermintaan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmPupuk_Permintaan_CetakPermintaan.setName("pnlFrmPupuk_Permintaan_CetakPermintaan"); // NOI18N
        pnlFrmPupuk_Permintaan_CetakPermintaan.setPreferredSize(new java.awt.Dimension(203, 30));
        pnlFrmPupuk_Permintaan_CetakPermintaan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back23.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Print_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back23.setText("Cetak Permintaan Pupuk");
        lblFrmInputRDKK_Back23.setIconTextGap(10);
        lblFrmInputRDKK_Back23.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmPupuk_Permintaan_CetakPermintaan.add(lblFrmInputRDKK_Back23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 205, 30));

        pnlFrmPupuk_Permintaan.add(pnlFrmPupuk_Permintaan_CetakPermintaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 317, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel18.setText("Tanggal Transaksi");
        pnlFrmPupuk_Permintaan.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 290, -1, -1));

        pnlContent.add(pnlFrmPupuk_Permintaan, "crdFrmPupuk_Permintaan");

        pnlAdminSistem_UserData.setBackground(new java.awt.Color(0, 23, 23));
        pnlAdminSistem_UserData.setName("pnlAdminSistem_UserData"); // NOI18N
        pnlAdminSistem_UserData.setOpaque(false);
        pnlAdminSistem_UserData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmInputRDKK_MenuHolder4.setBackground(new java.awt.Color(0, 70, 70));
        pnlFrmInputRDKK_MenuHolder4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAdminSistem_Kembali.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_Kembali.setName("pnlAdminSistem_Kembali"); // NOI18N
        pnlAdminSistem_Kembali.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlAdminSistem_Kembali.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmAdminSistem_Kembali.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmAdminSistem_Kembali.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmAdminSistem_Kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Back_To_26px.png"))); // NOI18N
        lblFrmAdminSistem_Kembali.setText("Kembali");
        lblFrmAdminSistem_Kembali.setIconTextGap(10);
        lblFrmAdminSistem_Kembali.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_Kembali.add(lblFrmAdminSistem_Kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        pnlFrmInputRDKK_MenuHolder4.add(pnlAdminSistem_Kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        pnlFrmRDKK_Title3.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmRDKK_Title3.setName("pnlFrmRDKKBack"); // NOI18N
        pnlFrmRDKK_Title3.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlFrmRDKK_Title3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        lblFrmRDKK_Title3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmRDKK_Title3.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKK_Title3.setText("Manajemen Pengguna");
        lblFrmRDKK_Title3.setPreferredSize(new java.awt.Dimension(400, 40));
        pnlFrmRDKK_Title3.add(lblFrmRDKK_Title3);

        pnlFrmInputRDKK_MenuHolder4.add(pnlFrmRDKK_Title3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 1190, -1));

        pnlAdminSistem_UserData.add(pnlFrmInputRDKK_MenuHolder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, -1));

        pnlAdminSistem_Content.setBackground(new java.awt.Color(0, 23, 23));
        pnlAdminSistem_Content.setName(""); // NOI18N

        jScrollPane9.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane9.setBorder(null);
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane9.setMinimumSize(new java.awt.Dimension(0, 0));

        tblUserData.setBackground(new java.awt.Color(170, 193, 193));
        tblUserData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblUserData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblUserData.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblUserData.setAutoscrolls(false);
        tblUserData.setFillsViewportHeight(true);
        tblUserData.setGridColor(new java.awt.Color(255, 255, 255));
        tblUserData.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblUserData.setName("tblKelompokTani"); // NOI18N
        tblUserData.setOpaque(false);
        tblUserData.setRowHeight(24);
        tblUserData.setShowHorizontalLines(false);
        tblUserData.setShowVerticalLines(false);
        tblUserData.getTableHeader().setResizingAllowed(false);
        tblUserData.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(tblUserData);

        jPanel9.setBackground(new java.awt.Color(85, 131, 131));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel15.setText("Data Pengguna");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlAdminSistem_DeleteUser.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_DeleteUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_DeleteUser.setName("pnlAdminSistem_DeleteUser"); // NOI18N
        pnlAdminSistem_DeleteUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back10.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Denied_26px.png"))); // NOI18N
        lblFrmInputRDKK_Back10.setIconTextGap(10);
        lblFrmInputRDKK_Back10.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_DeleteUser.add(lblFrmInputRDKK_Back10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlAdminSistem_AddUser.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_AddUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_AddUser.setName("pnlAdminSistem_AddUser"); // NOI18N
        pnlAdminSistem_AddUser.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlAdminSistem_AddUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back11.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Add_User_Male_26px.png"))); // NOI18N
        lblFrmInputRDKK_Back11.setIconTextGap(10);
        lblFrmInputRDKK_Back11.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_AddUser.add(lblFrmInputRDKK_Back11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlAdminSistem_EditUser.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_EditUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_EditUser.setName("pnlAdminSistem_EditUser"); // NOI18N
        pnlAdminSistem_EditUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back12.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Registration_26px.png"))); // NOI18N
        lblFrmInputRDKK_Back12.setIconTextGap(10);
        lblFrmInputRDKK_Back12.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_EditUser.add(lblFrmInputRDKK_Back12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlFrmUserData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmUserData.setOpaque(false);
        pnlFrmUserData.setPreferredSize(new java.awt.Dimension(500, 340));

        lblInputNamaKelTani13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani13.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani13.setText("Nama Lengkap");

        jtfFrmUserData_NamaLengkap.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfFrmUserData_NamaLengkap.setForeground(new java.awt.Color(255, 255, 255));
        jtfFrmUserData_NamaLengkap.setBorder(null);
        jtfFrmUserData_NamaLengkap.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfFrmUserData_NamaLengkap.setOpaque(false);

        javax.swing.GroupLayout pnlUnderUserData1Layout = new javax.swing.GroupLayout(pnlUnderUserData1);
        pnlUnderUserData1.setLayout(pnlUnderUserData1Layout);
        pnlUnderUserData1Layout.setHorizontalGroup(
            pnlUnderUserData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlUnderUserData1Layout.setVerticalGroup(
            pnlUnderUserData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        lblInputNamaKelTani14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani14.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani14.setText("Username");

        jtfFrmUserData_Username.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfFrmUserData_Username.setForeground(new java.awt.Color(255, 255, 255));
        jtfFrmUserData_Username.setBorder(null);
        jtfFrmUserData_Username.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfFrmUserData_Username.setOpaque(false);

        javax.swing.GroupLayout pnlUnderUserData2Layout = new javax.swing.GroupLayout(pnlUnderUserData2);
        pnlUnderUserData2.setLayout(pnlUnderUserData2Layout);
        pnlUnderUserData2Layout.setHorizontalGroup(
            pnlUnderUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        pnlUnderUserData2Layout.setVerticalGroup(
            pnlUnderUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        lblInputNamaKelTani15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani15.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani15.setText("Password");

        jtfFrmUserData_Password.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfFrmUserData_Password.setForeground(new java.awt.Color(255, 255, 255));
        jtfFrmUserData_Password.setBorder(null);
        jtfFrmUserData_Password.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfFrmUserData_Password.setOpaque(false);

        javax.swing.GroupLayout pnlUnderUserData3Layout = new javax.swing.GroupLayout(pnlUnderUserData3);
        pnlUnderUserData3.setLayout(pnlUnderUserData3Layout);
        pnlUnderUserData3Layout.setHorizontalGroup(
            pnlUnderUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        pnlUnderUserData3Layout.setVerticalGroup(
            pnlUnderUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        cbxFrmUserData_Level.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxFrmUserData_Level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 1 - System Administrator", "Level 2 - Penanggungjawab", "Level 3 - Operator" }));

        lblInputNamaKelTani16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani16.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani16.setText("Level Pengguna");

        lblInputNamaKelTani17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani17.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani17.setText("Afdeling");

        cbxFrmUserData_Afdeling.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxFrmUserData_Afdeling.setName("cbxUserData_Afdeling"); // NOI18N

        pnlAdminSistem_Save.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_Save.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_Save.setName("pnlAdminSistem_Save"); // NOI18N
        pnlAdminSistem_Save.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back13.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Save_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back13.setIconTextGap(10);
        lblFrmInputRDKK_Back13.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_Save.add(lblFrmInputRDKK_Back13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlAdminSistem_Cancel.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_Cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_Cancel.setName("pnlAdminSistem_Cancel"); // NOI18N
        pnlAdminSistem_Cancel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back14.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Cancel_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back14.setIconTextGap(10);
        lblFrmInputRDKK_Back14.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_Cancel.add(lblFrmInputRDKK_Back14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        javax.swing.GroupLayout pnlFrmUserDataLayout = new javax.swing.GroupLayout(pnlFrmUserData);
        pnlFrmUserData.setLayout(pnlFrmUserDataLayout);
        pnlFrmUserDataLayout.setHorizontalGroup(
            pnlFrmUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrmUserDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFrmUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFrmUserDataLayout.createSequentialGroup()
                        .addGroup(pnlFrmUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFrmUserDataLayout.createSequentialGroup()
                                .addComponent(lblInputNamaKelTani13)
                                .addGap(90, 90, 90)
                                .addComponent(jtfFrmUserData_NamaLengkap, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFrmUserDataLayout.createSequentialGroup()
                                .addComponent(lblInputNamaKelTani15)
                                .addGap(124, 124, 124)
                                .addGroup(pnlFrmUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfFrmUserData_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnlUnderUserData3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrmUserDataLayout.createSequentialGroup()
                        .addGroup(pnlFrmUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrmUserDataLayout.createSequentialGroup()
                                .addComponent(lblInputNamaKelTani14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlFrmUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(pnlUnderUserData1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfFrmUserData_Username, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrmUserDataLayout.createSequentialGroup()
                                .addComponent(lblInputNamaKelTani16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlFrmUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pnlUnderUserData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxFrmUserData_Level, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxFrmUserData_Afdeling, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrmUserDataLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(pnlAdminSistem_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlAdminSistem_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))
                    .addGroup(pnlFrmUserDataLayout.createSequentialGroup()
                        .addComponent(lblInputNamaKelTani17)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlFrmUserDataLayout.setVerticalGroup(
            pnlFrmUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrmUserDataLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlFrmUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInputNamaKelTani13)
                    .addComponent(jtfFrmUserData_NamaLengkap, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(pnlUnderUserData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFrmUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInputNamaKelTani14)
                    .addComponent(jtfFrmUserData_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(pnlUnderUserData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFrmUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInputNamaKelTani15)
                    .addGroup(pnlFrmUserDataLayout.createSequentialGroup()
                        .addComponent(jtfFrmUserData_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(pnlUnderUserData3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlFrmUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFrmUserData_Level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInputNamaKelTani16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFrmUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFrmUserData_Afdeling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInputNamaKelTani17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(pnlFrmUserDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAdminSistem_Save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAdminSistem_Cancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlAdminSistem_ContentLayout = new javax.swing.GroupLayout(pnlAdminSistem_Content);
        pnlAdminSistem_Content.setLayout(pnlAdminSistem_ContentLayout);
        pnlAdminSistem_ContentLayout.setHorizontalGroup(
            pnlAdminSistem_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminSistem_ContentLayout.createSequentialGroup()
                .addGroup(pnlAdminSistem_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlAdminSistem_ContentLayout.createSequentialGroup()
                        .addComponent(pnlAdminSistem_AddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlAdminSistem_EditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlAdminSistem_DeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFrmUserData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 866, Short.MAX_VALUE))
        );
        pnlAdminSistem_ContentLayout.setVerticalGroup(
            pnlAdminSistem_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminSistem_ContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAdminSistem_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAdminSistem_DeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAdminSistem_AddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAdminSistem_EditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFrmUserData, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlAdminSistem_UserData.add(pnlAdminSistem_Content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1366, 630));

        pnlContent.add(pnlAdminSistem_UserData, "crdPnlAdminSistem_UserData");

        pnlAdminSistem_BahanProduksi.setBackground(new java.awt.Color(0, 23, 23));
        pnlAdminSistem_BahanProduksi.setName("pnlAdminSistem_UserData"); // NOI18N
        pnlAdminSistem_BahanProduksi.setOpaque(false);
        pnlAdminSistem_BahanProduksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmInputRDKK_MenuHolder5.setBackground(new java.awt.Color(0, 70, 70));
        pnlFrmInputRDKK_MenuHolder5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAdminSistem_BahanProduksi_Kembali.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_BahanProduksi_Kembali.setName("pnlAdminSistem_BahanProduksi_Kembali"); // NOI18N
        pnlAdminSistem_BahanProduksi_Kembali.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlAdminSistem_BahanProduksi_Kembali.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmAdminSistem_Kembali1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmAdminSistem_Kembali1.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmAdminSistem_Kembali1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Back_To_26px.png"))); // NOI18N
        lblFrmAdminSistem_Kembali1.setText("Kembali");
        lblFrmAdminSistem_Kembali1.setIconTextGap(10);
        lblFrmAdminSistem_Kembali1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_BahanProduksi_Kembali.add(lblFrmAdminSistem_Kembali1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        pnlFrmInputRDKK_MenuHolder5.add(pnlAdminSistem_BahanProduksi_Kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        pnlFrmRDKK_Title4.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmRDKK_Title4.setName("pnlFrmRDKKBack"); // NOI18N
        pnlFrmRDKK_Title4.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlFrmRDKK_Title4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        lblFrmRDKK_Title4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmRDKK_Title4.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKK_Title4.setText("Manajemen Bahan Produksi");
        lblFrmRDKK_Title4.setPreferredSize(new java.awt.Dimension(400, 40));
        pnlFrmRDKK_Title4.add(lblFrmRDKK_Title4);

        pnlFrmInputRDKK_MenuHolder5.add(pnlFrmRDKK_Title4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 1190, -1));

        pnlAdminSistem_BahanProduksi.add(pnlFrmInputRDKK_MenuHolder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, -1));

        pnlAdminSistem_Content1.setBackground(new java.awt.Color(0, 23, 23));
        pnlAdminSistem_Content1.setName(""); // NOI18N

        jScrollPane10.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane10.setBorder(null);
        jScrollPane10.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane10.setMinimumSize(new java.awt.Dimension(0, 0));

        tblBahanProduksi.setBackground(new java.awt.Color(170, 193, 193));
        tblBahanProduksi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblBahanProduksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblBahanProduksi.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblBahanProduksi.setAutoscrolls(false);
        tblBahanProduksi.setFillsViewportHeight(true);
        tblBahanProduksi.setGridColor(new java.awt.Color(255, 255, 255));
        tblBahanProduksi.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblBahanProduksi.setName("tblKelompokTani"); // NOI18N
        tblBahanProduksi.setOpaque(false);
        tblBahanProduksi.setRowHeight(24);
        tblBahanProduksi.setShowHorizontalLines(false);
        tblBahanProduksi.setShowVerticalLines(false);
        tblBahanProduksi.getTableHeader().setResizingAllowed(false);
        tblBahanProduksi.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(tblBahanProduksi);

        jPanel10.setBackground(new java.awt.Color(85, 131, 131));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel16.setText("Data Bahan Produksi");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlAdminSistem_BahanProduksi_Delete.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_BahanProduksi_Delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_BahanProduksi_Delete.setName("pnlAdminSistem_BahanProduksi_Delete"); // NOI18N
        pnlAdminSistem_BahanProduksi_Delete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back15.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Trash_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back15.setIconTextGap(10);
        lblFrmInputRDKK_Back15.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_BahanProduksi_Delete.add(lblFrmInputRDKK_Back15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlAdminSistem_BahanProduksi_Add.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_BahanProduksi_Add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_BahanProduksi_Add.setName("pnlAdminSistem_BahanProduksi_Add"); // NOI18N
        pnlAdminSistem_BahanProduksi_Add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back16.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Plus_26px.png"))); // NOI18N
        lblFrmInputRDKK_Back16.setIconTextGap(10);
        lblFrmInputRDKK_Back16.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_BahanProduksi_Add.add(lblFrmInputRDKK_Back16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlAdminSistem_BahanProduksi_Edit.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_BahanProduksi_Edit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_BahanProduksi_Edit.setName("pnlAdminSistem_BahanProduksi_Edit"); // NOI18N
        pnlAdminSistem_BahanProduksi_Edit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back17.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Pencil_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back17.setIconTextGap(10);
        lblFrmInputRDKK_Back17.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_BahanProduksi_Edit.add(lblFrmInputRDKK_Back17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlFrmUserData1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmUserData1.setOpaque(false);
        pnlFrmUserData1.setPreferredSize(new java.awt.Dimension(500, 340));

        lblInputNamaKelTani18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani18.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani18.setText("Nama Bahan");

        jtfFrmBahanProduksi_NamaBahan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfFrmBahanProduksi_NamaBahan.setForeground(new java.awt.Color(255, 255, 255));
        jtfFrmBahanProduksi_NamaBahan.setBorder(null);
        jtfFrmBahanProduksi_NamaBahan.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfFrmBahanProduksi_NamaBahan.setEnabled(false);
        jtfFrmBahanProduksi_NamaBahan.setOpaque(false);

        pnlUnderUserData4.setPreferredSize(new java.awt.Dimension(290, 1));

        javax.swing.GroupLayout pnlUnderUserData4Layout = new javax.swing.GroupLayout(pnlUnderUserData4);
        pnlUnderUserData4.setLayout(pnlUnderUserData4Layout);
        pnlUnderUserData4Layout.setHorizontalGroup(
            pnlUnderUserData4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        pnlUnderUserData4Layout.setVerticalGroup(
            pnlUnderUserData4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        lblInputNamaKelTani20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani20.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani20.setText("Dosis per hektar");

        cbxFrmBahanProduksi_JenisBahan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxFrmBahanProduksi_JenisBahan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PUPUK", "HERBISIDA", "ZAT PEMACU KEMASAKAN", "NUTRISI TANAH" }));
        cbxFrmBahanProduksi_JenisBahan.setSelectedIndex(-1);
        cbxFrmBahanProduksi_JenisBahan.setEnabled(false);

        lblInputNamaKelTani21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani21.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani21.setText("Jenis Bahan");

        lblInputNamaKelTani22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani22.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani22.setText("Satuan");

        cbxFrmBahanProduksi_Satuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxFrmBahanProduksi_Satuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KG", "LITER", "BUAH" }));
        cbxFrmBahanProduksi_Satuan.setSelectedIndex(-1);
        cbxFrmBahanProduksi_Satuan.setEnabled(false);
        cbxFrmBahanProduksi_Satuan.setName("cbxUserData_Afdeling"); // NOI18N

        pnlAdminSistem_BahanProduksi_Save.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_BahanProduksi_Save.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_BahanProduksi_Save.setName("pnlAdminSistem_BahanProduksi_Save"); // NOI18N
        pnlAdminSistem_BahanProduksi_Save.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back18.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Save_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back18.setIconTextGap(10);
        lblFrmInputRDKK_Back18.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_BahanProduksi_Save.add(lblFrmInputRDKK_Back18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlAdminSistem_BahanProduksi_Cancel.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_BahanProduksi_Cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_BahanProduksi_Cancel.setName("pnlAdminSistem_BahanProduksi_Cancel"); // NOI18N
        pnlAdminSistem_BahanProduksi_Cancel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back19.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Cancel_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back19.setIconTextGap(10);
        lblFrmInputRDKK_Back19.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_BahanProduksi_Cancel.add(lblFrmInputRDKK_Back19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jtfFrmBahanProduksi_Dosis.setBorder(null);
        jtfFrmBahanProduksi_Dosis.setForeground(new java.awt.Color(255, 255, 255));
        jtfFrmBahanProduksi_Dosis.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        jtfFrmBahanProduksi_Dosis.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfFrmBahanProduksi_Dosis.setEnabled(false);
        jtfFrmBahanProduksi_Dosis.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfFrmBahanProduksi_Dosis.setOpaque(false);

        pnlUnderUserData5.setPreferredSize(new java.awt.Dimension(290, 1));

        javax.swing.GroupLayout pnlUnderUserData5Layout = new javax.swing.GroupLayout(pnlUnderUserData5);
        pnlUnderUserData5.setLayout(pnlUnderUserData5Layout);
        pnlUnderUserData5Layout.setHorizontalGroup(
            pnlUnderUserData5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        pnlUnderUserData5Layout.setVerticalGroup(
            pnlUnderUserData5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlFrmUserData1Layout = new javax.swing.GroupLayout(pnlFrmUserData1);
        pnlFrmUserData1.setLayout(pnlFrmUserData1Layout);
        pnlFrmUserData1Layout.setHorizontalGroup(
            pnlFrmUserData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrmUserData1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFrmUserData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrmUserData1Layout.createSequentialGroup()
                        .addGroup(pnlFrmUserData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInputNamaKelTani21)
                            .addComponent(lblInputNamaKelTani18)
                            .addComponent(lblInputNamaKelTani20)
                            .addComponent(lblInputNamaKelTani22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addGroup(pnlFrmUserData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxFrmBahanProduksi_JenisBahan, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxFrmBahanProduksi_Satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFrmBahanProduksi_NamaBahan, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlUnderUserData4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFrmBahanProduksi_Dosis, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlUnderUserData5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrmUserData1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlAdminSistem_BahanProduksi_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlAdminSistem_BahanProduksi_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        pnlFrmUserData1Layout.setVerticalGroup(
            pnlFrmUserData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrmUserData1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlFrmUserData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFrmBahanProduksi_JenisBahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInputNamaKelTani21))
                .addGap(18, 18, 18)
                .addGroup(pnlFrmUserData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFrmUserData1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblInputNamaKelTani18))
                    .addComponent(jtfFrmBahanProduksi_NamaBahan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(pnlUnderUserData4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlFrmUserData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfFrmBahanProduksi_Dosis, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInputNamaKelTani20))
                .addGap(1, 1, 1)
                .addComponent(pnlUnderUserData5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlFrmUserData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFrmBahanProduksi_Satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInputNamaKelTani22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(pnlFrmUserData1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAdminSistem_BahanProduksi_Save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAdminSistem_BahanProduksi_Cancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane11.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane11.setBorder(null);
        jScrollPane11.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane11.setMinimumSize(new java.awt.Dimension(0, 0));
        jScrollPane11.setPreferredSize(new java.awt.Dimension(567, 400));

        tblMonitorBahanMasuk.setBackground(new java.awt.Color(170, 193, 193));
        tblMonitorBahanMasuk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblMonitorBahanMasuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMonitorBahanMasuk.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblMonitorBahanMasuk.setAutoscrolls(false);
        tblMonitorBahanMasuk.setFillsViewportHeight(true);
        tblMonitorBahanMasuk.setGridColor(new java.awt.Color(255, 255, 255));
        tblMonitorBahanMasuk.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblMonitorBahanMasuk.setName("tblKelompokTani"); // NOI18N
        tblMonitorBahanMasuk.setOpaque(false);
        tblMonitorBahanMasuk.setRowHeight(24);
        tblMonitorBahanMasuk.setShowHorizontalLines(false);
        tblMonitorBahanMasuk.setShowVerticalLines(false);
        tblMonitorBahanMasuk.getTableHeader().setResizingAllowed(false);
        tblMonitorBahanMasuk.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(tblMonitorBahanMasuk);

        jPanel11.setBackground(new java.awt.Color(85, 131, 131));
        jPanel11.setPreferredSize(new java.awt.Dimension(550, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel17.setText("Ringkasan Transaksi Bahan Produksi");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlFrmUserData2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmUserData2.setOpaque(false);
        pnlFrmUserData2.setPreferredSize(new java.awt.Dimension(500, 340));

        lblInputNamaKelTani24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani24.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani24.setText("Jumlah bahan masuk");

        lblInputNamaKelTani26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani26.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani26.setText("Satuan");

        cbxFrmBahanProduksi_SatuanMasuk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxFrmBahanProduksi_SatuanMasuk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KG", "LITER", "BUAH" }));
        cbxFrmBahanProduksi_SatuanMasuk.setSelectedIndex(-1);
        cbxFrmBahanProduksi_SatuanMasuk.setEnabled(false);
        cbxFrmBahanProduksi_SatuanMasuk.setName("cbxUserData_Afdeling"); // NOI18N

        pnlAdminSistem_BahanProduksi_SaveMasuk.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_BahanProduksi_SaveMasuk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_BahanProduksi_SaveMasuk.setName("pnlAdminSistem_BahanProduksi_SaveMasuk"); // NOI18N
        pnlAdminSistem_BahanProduksi_SaveMasuk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back20.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Save_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back20.setIconTextGap(10);
        lblFrmInputRDKK_Back20.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_BahanProduksi_SaveMasuk.add(lblFrmInputRDKK_Back20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlAdminSistem_BahanProduksi_CancelMasuk.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_BahanProduksi_CancelMasuk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_BahanProduksi_CancelMasuk.setName("pnlAdminSistem_BahanProduksi_CancelMasuk"); // NOI18N
        pnlAdminSistem_BahanProduksi_CancelMasuk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back21.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Cancel_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back21.setIconTextGap(10);
        lblFrmInputRDKK_Back21.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_BahanProduksi_CancelMasuk.add(lblFrmInputRDKK_Back21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jtfFrmBahanProduksi_KuantaMasuk.setBorder(null);
        jtfFrmBahanProduksi_KuantaMasuk.setForeground(new java.awt.Color(255, 255, 255));
        jtfFrmBahanProduksi_KuantaMasuk.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.###"))));
        jtfFrmBahanProduksi_KuantaMasuk.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfFrmBahanProduksi_KuantaMasuk.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfFrmBahanProduksi_KuantaMasuk.setEnabled(false);
        jtfFrmBahanProduksi_KuantaMasuk.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfFrmBahanProduksi_KuantaMasuk.setOpaque(false);

        pnlUnderUserData7.setPreferredSize(new java.awt.Dimension(290, 1));

        javax.swing.GroupLayout pnlUnderUserData7Layout = new javax.swing.GroupLayout(pnlUnderUserData7);
        pnlUnderUserData7.setLayout(pnlUnderUserData7Layout);
        pnlUnderUserData7Layout.setHorizontalGroup(
            pnlUnderUserData7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        pnlUnderUserData7Layout.setVerticalGroup(
            pnlUnderUserData7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        pnlUnderUserData8.setPreferredSize(new java.awt.Dimension(290, 1));

        javax.swing.GroupLayout pnlUnderUserData8Layout = new javax.swing.GroupLayout(pnlUnderUserData8);
        pnlUnderUserData8.setLayout(pnlUnderUserData8Layout);
        pnlUnderUserData8Layout.setHorizontalGroup(
            pnlUnderUserData8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        pnlUnderUserData8Layout.setVerticalGroup(
            pnlUnderUserData8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jtfFrmBahanProduksi_NilaiMasuk.setBorder(null);
        jtfFrmBahanProduksi_NilaiMasuk.setForeground(new java.awt.Color(255, 255, 255));
        jtfFrmBahanProduksi_NilaiMasuk.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.###"))));
        jtfFrmBahanProduksi_NilaiMasuk.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfFrmBahanProduksi_NilaiMasuk.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfFrmBahanProduksi_NilaiMasuk.setEnabled(false);
        jtfFrmBahanProduksi_NilaiMasuk.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfFrmBahanProduksi_NilaiMasuk.setOpaque(false);

        lblInputNamaKelTani25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani25.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani25.setText("Nilai bahan masuk (Rp)");

        jtfFrmBahanProduksi_NoKontrak.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfFrmBahanProduksi_NoKontrak.setForeground(new java.awt.Color(255, 255, 255));
        jtfFrmBahanProduksi_NoKontrak.setBorder(null);
        jtfFrmBahanProduksi_NoKontrak.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfFrmBahanProduksi_NoKontrak.setEnabled(false);
        jtfFrmBahanProduksi_NoKontrak.setOpaque(false);

        pnlUnderUserData12.setPreferredSize(new java.awt.Dimension(290, 1));

        javax.swing.GroupLayout pnlUnderUserData12Layout = new javax.swing.GroupLayout(pnlUnderUserData12);
        pnlUnderUserData12.setLayout(pnlUnderUserData12Layout);
        pnlUnderUserData12Layout.setHorizontalGroup(
            pnlUnderUserData12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        pnlUnderUserData12Layout.setVerticalGroup(
            pnlUnderUserData12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        lblInputNamaKelTani33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani33.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani33.setText("Nomor Kontrak");

        javax.swing.GroupLayout pnlFrmUserData2Layout = new javax.swing.GroupLayout(pnlFrmUserData2);
        pnlFrmUserData2.setLayout(pnlFrmUserData2Layout);
        pnlFrmUserData2Layout.setHorizontalGroup(
            pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrmUserData2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFrmUserData2Layout.createSequentialGroup()
                        .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInputNamaKelTani24)
                            .addComponent(lblInputNamaKelTani26)
                            .addComponent(lblInputNamaKelTani25)
                            .addComponent(lblInputNamaKelTani33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxFrmBahanProduksi_SatuanMasuk, 0, 290, Short.MAX_VALUE)
                            .addComponent(jtfFrmBahanProduksi_KuantaMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(pnlUnderUserData7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlUnderUserData8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfFrmBahanProduksi_NilaiMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(jtfFrmBahanProduksi_NoKontrak)))
                    .addGroup(pnlFrmUserData2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlUnderUserData12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlFrmUserData2Layout.createSequentialGroup()
                                .addComponent(pnlAdminSistem_BahanProduksi_CancelMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlAdminSistem_BahanProduksi_SaveMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16))
        );
        pnlFrmUserData2Layout.setVerticalGroup(
            pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrmUserData2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfFrmBahanProduksi_KuantaMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInputNamaKelTani24))
                .addGap(1, 1, 1)
                .addComponent(pnlUnderUserData7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFrmBahanProduksi_SatuanMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInputNamaKelTani26))
                .addGap(18, 18, 18)
                .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfFrmBahanProduksi_NilaiMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInputNamaKelTani25))
                .addGap(1, 1, 1)
                .addComponent(pnlUnderUserData8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfFrmBahanProduksi_NoKontrak, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInputNamaKelTani33))
                .addGap(2, 2, 2)
                .addComponent(pnlUnderUserData12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAdminSistem_BahanProduksi_SaveMasuk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAdminSistem_BahanProduksi_CancelMasuk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlAdminSistem_BahanProduksi_AddMasuk.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_BahanProduksi_AddMasuk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_BahanProduksi_AddMasuk.setName("pnlAdminSistem_BahanProduksi_AddMasuk"); // NOI18N
        pnlAdminSistem_BahanProduksi_AddMasuk.setPreferredSize(new java.awt.Dimension(100, 32));
        pnlAdminSistem_BahanProduksi_AddMasuk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back22.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Plus_26px.png"))); // NOI18N
        lblFrmInputRDKK_Back22.setIconTextGap(10);
        lblFrmInputRDKK_Back22.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_BahanProduksi_AddMasuk.add(lblFrmInputRDKK_Back22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        javax.swing.GroupLayout pnlAdminSistem_Content1Layout = new javax.swing.GroupLayout(pnlAdminSistem_Content1);
        pnlAdminSistem_Content1.setLayout(pnlAdminSistem_Content1Layout);
        pnlAdminSistem_Content1Layout.setHorizontalGroup(
            pnlAdminSistem_Content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminSistem_Content1Layout.createSequentialGroup()
                .addGroup(pnlAdminSistem_Content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlAdminSistem_Content1Layout.createSequentialGroup()
                        .addComponent(pnlFrmUserData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlFrmUserData2, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAdminSistem_Content1Layout.createSequentialGroup()
                        .addGroup(pnlAdminSistem_Content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlAdminSistem_Content1Layout.createSequentialGroup()
                                .addComponent(pnlAdminSistem_BahanProduksi_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlAdminSistem_BahanProduksi_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlAdminSistem_BahanProduksi_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAdminSistem_Content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlAdminSistem_Content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
                            .addComponent(pnlAdminSistem_BahanProduksi_AddMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 310, Short.MAX_VALUE))
        );
        pnlAdminSistem_Content1Layout.setVerticalGroup(
            pnlAdminSistem_Content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminSistem_Content1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAdminSistem_Content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAdminSistem_Content1Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAdminSistem_Content1Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlAdminSistem_Content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAdminSistem_Content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlAdminSistem_BahanProduksi_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlAdminSistem_BahanProduksi_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlAdminSistem_BahanProduksi_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlAdminSistem_BahanProduksi_AddMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAdminSistem_Content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlFrmUserData1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFrmUserData2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        pnlAdminSistem_BahanProduksi.add(pnlAdminSistem_Content1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1366, 630));

        pnlContent.add(pnlAdminSistem_BahanProduksi, "crdPnlAdminSistem_BahanProduksi");

        pnlFrmPupuk_EvaluasiBiayaPupuk.setBackground(new java.awt.Color(0, 23, 23));
        pnlFrmPupuk_EvaluasiBiayaPupuk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmInputRDKK_MenuHolder6.setBackground(new java.awt.Color(0, 70, 70));
        pnlFrmInputRDKK_MenuHolder6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmPupuk_EvaluasiBiayaPupuk_Back.setBackground(new Color(255,255,255,0));
        pnlFrmPupuk_EvaluasiBiayaPupuk_Back.setName("pnlFrmPupuk_EvaluasiBiayaPupuk_Back"); // NOI18N
        pnlFrmPupuk_EvaluasiBiayaPupuk_Back.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlFrmPupuk_EvaluasiBiayaPupuk_Back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmInputRDKK_Back24.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Back_To_26px.png"))); // NOI18N
        lblFrmInputRDKK_Back24.setText("Menu Utama");
        lblFrmInputRDKK_Back24.setIconTextGap(10);
        lblFrmInputRDKK_Back24.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmPupuk_EvaluasiBiayaPupuk_Back.add(lblFrmInputRDKK_Back24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        pnlFrmInputRDKK_MenuHolder6.add(pnlFrmPupuk_EvaluasiBiayaPupuk_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        pnlFrmRDKK_Title5.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmRDKK_Title5.setName("pnlFrmRDKKBack"); // NOI18N
        pnlFrmRDKK_Title5.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlFrmRDKK_Title5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        lblFrmRDKK_Title5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmRDKK_Title5.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKK_Title5.setText("Evaluasi Biaya Pupuk");
        lblFrmRDKK_Title5.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlFrmRDKK_Title5.add(lblFrmRDKK_Title5);

        pnlFrmInputRDKK_MenuHolder6.add(pnlFrmRDKK_Title5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 1190, -1));

        pnlFrmPupuk_EvaluasiBiayaPupuk.add(pnlFrmInputRDKK_MenuHolder6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1399, -1));

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel12.setOpaque(false);

        lblFrmRDKK_Title6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmRDKK_Title6.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKK_Title6.setText("Afdeling");
        lblFrmRDKK_Title6.setPreferredSize(new java.awt.Dimension(200, 40));

        cbxFrmPupuk_EvaluasiBiayaPupuk_Afd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxFrmPupuk_EvaluasiBiayaPupuk_Afd.setBorder(null);

        dtpFrmPupuk_EvaluasiBiayaPupuk_Tgl1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dtpFrmPupuk_EvaluasiBiayaPupuk_Tgl1.setFormats("dd-MM-yyyy");

        lblFrmRDKK_Title7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmRDKK_Title7.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKK_Title7.setText("Periode");
        lblFrmRDKK_Title7.setPreferredSize(new java.awt.Dimension(200, 40));

        lblFrmRDKK_Title8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmRDKK_Title8.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKK_Title8.setText("sampai dengan");
        lblFrmRDKK_Title8.setPreferredSize(new java.awt.Dimension(200, 40));

        dtpFrmPupuk_EvaluasiBiayaPupuk_Tgl2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dtpFrmPupuk_EvaluasiBiayaPupuk_Tgl2.setFormats("dd-MM-yyyy");

        pnlFrmPupuk_EvaluasiBiayaPupuk_View.setBackground(new Color(255,255,255,0));
        pnlFrmPupuk_EvaluasiBiayaPupuk_View.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmPupuk_EvaluasiBiayaPupuk_View.setName("pnlFrmPupuk_EvaluasiBiayaPupuk_View"); // NOI18N
        pnlFrmPupuk_EvaluasiBiayaPupuk_View.setPreferredSize(new java.awt.Dimension(203, 30));
        pnlFrmPupuk_EvaluasiBiayaPupuk_View.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back25.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Print_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back25.setText("Preview Biaya Pupuk");
        lblFrmInputRDKK_Back25.setIconTextGap(10);
        lblFrmInputRDKK_Back25.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmPupuk_EvaluasiBiayaPupuk_View.add(lblFrmInputRDKK_Back25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(lblFrmRDKK_Title6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxFrmPupuk_EvaluasiBiayaPupuk_Afd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(lblFrmRDKK_Title7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dtpFrmPupuk_EvaluasiBiayaPupuk_Tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblFrmRDKK_Title8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dtpFrmPupuk_EvaluasiBiayaPupuk_Tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlFrmPupuk_EvaluasiBiayaPupuk_View, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFrmRDKK_Title6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFrmPupuk_EvaluasiBiayaPupuk_Afd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtpFrmPupuk_EvaluasiBiayaPupuk_Tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFrmRDKK_Title7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFrmRDKK_Title8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpFrmPupuk_EvaluasiBiayaPupuk_Tgl2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlFrmPupuk_EvaluasiBiayaPupuk_View, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFrmPupuk_EvaluasiBiayaPupuk.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, 560, 140));

        pnlContent.add(pnlFrmPupuk_EvaluasiBiayaPupuk, "crdFrmPupuk_EvaluasiBiayaPupuk");

        pnlFrmPerawatan_Permintaan.setBackground(new java.awt.Color(0, 23, 23));
        pnlFrmPerawatan_Permintaan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmInputRDKK_MenuHolder7.setBackground(new java.awt.Color(0, 70, 70));
        pnlFrmInputRDKK_MenuHolder7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmPerawatan_Permintaan_Back.setBackground(new Color(255,255,255,0));
        pnlFrmPerawatan_Permintaan_Back.setName("pnlFrmPerawatan_Permintaan_Back"); // NOI18N
        pnlFrmPerawatan_Permintaan_Back.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlFrmPerawatan_Permintaan_Back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmInputRDKK_Back26.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Back_To_26px.png"))); // NOI18N
        lblFrmInputRDKK_Back26.setText("Menu Utama");
        lblFrmInputRDKK_Back26.setIconTextGap(10);
        lblFrmInputRDKK_Back26.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmPerawatan_Permintaan_Back.add(lblFrmInputRDKK_Back26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        pnlFrmInputRDKK_MenuHolder7.add(pnlFrmPerawatan_Permintaan_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        pnlFrmRDKK_Title6.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmRDKK_Title6.setName("pnlFrmRDKKBack"); // NOI18N
        pnlFrmRDKK_Title6.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlFrmRDKK_Title6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        lblFrmRDKK_Title9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmRDKK_Title9.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKK_Title9.setText("Permintaan Perawatan Tanaman");
        lblFrmRDKK_Title9.setPreferredSize(new java.awt.Dimension(300, 40));
        pnlFrmRDKK_Title6.add(lblFrmRDKK_Title9);

        pnlFrmInputRDKK_MenuHolder7.add(pnlFrmRDKK_Title6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 1190, -1));

        pnlFrmPerawatan_Permintaan.add(pnlFrmInputRDKK_MenuHolder7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, -1));

        jScrollPane12.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane12.setBorder(null);
        jScrollPane12.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane12.setMinimumSize(new java.awt.Dimension(0, 0));

        tblKelTani_Perawatan_Permintaan.setBackground(new java.awt.Color(170, 193, 193));
        tblKelTani_Perawatan_Permintaan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblKelTani_Perawatan_Permintaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblKelTani_Perawatan_Permintaan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblKelTani_Perawatan_Permintaan.setAutoscrolls(false);
        tblKelTani_Perawatan_Permintaan.setFillsViewportHeight(true);
        tblKelTani_Perawatan_Permintaan.setGridColor(new java.awt.Color(255, 255, 255));
        tblKelTani_Perawatan_Permintaan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblKelTani_Perawatan_Permintaan.setName("tblValidasiRDKK"); // NOI18N
        tblKelTani_Perawatan_Permintaan.setOpaque(false);
        tblKelTani_Perawatan_Permintaan.setRowHeight(24);
        tblKelTani_Perawatan_Permintaan.setShowHorizontalLines(false);
        tblKelTani_Perawatan_Permintaan.setShowVerticalLines(false);
        tblKelTani_Perawatan_Permintaan.getTableHeader().setResizingAllowed(false);
        tblKelTani_Perawatan_Permintaan.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(tblKelTani_Perawatan_Permintaan);

        pnlFrmPerawatan_Permintaan.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 629, 268));

        jPanel13.setBackground(new java.awt.Color(85, 131, 131));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel19.setText("Daftar Kelompok Tani");

        jtfFrmPerawatan_Permintaan_Cari.setBackground(new java.awt.Color(85, 131, 131));
        jtfFrmPerawatan_Permintaan_Cari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfFrmPerawatan_Permintaan_Cari.setForeground(new java.awt.Color(255, 255, 255));
        jtfFrmPerawatan_Permintaan_Cari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jtfFrmPerawatan_Permintaan_Cari.setCaretColor(new java.awt.Color(255, 255, 255));
        jtfFrmPerawatan_Permintaan_Cari.setMargin(new java.awt.Insets(2, 4, 2, 2));
        jtfFrmPerawatan_Permintaan_Cari.setName("jtfFrmPerawatan_Permintaan_Cari"); // NOI18N

        lblSearchIcon3.setBackground(new java.awt.Color(85, 131, 131));
        lblSearchIcon3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblSearchIcon3.setForeground(new java.awt.Color(51, 51, 51));
        lblSearchIcon3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Search_20px.png"))); // NOI18N
        lblSearchIcon3.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 4));
        lblSearchIcon3.setOpaque(true);

        pnlFrmPupuk_Permintaan_Clear2.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmPupuk_Permintaan_Clear2.setName("pnlFrmPupuk_Permintaan_Clear"); // NOI18N
        pnlFrmPupuk_Permintaan_Clear2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmRDKKClearSearch3.setBackground(new java.awt.Color(141, 172, 172));
        lblFrmRDKKClearSearch3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblFrmRDKKClearSearch3.setForeground(new java.awt.Color(51, 51, 51));
        lblFrmRDKKClearSearch3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmRDKKClearSearch3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Clear_Symbol_20px.png"))); // NOI18N
        lblFrmRDKKClearSearch3.setAlignmentY(0.0F);
        lblFrmRDKKClearSearch3.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 4));
        lblFrmRDKKClearSearch3.setIconTextGap(0);
        lblFrmRDKKClearSearch3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnlFrmPupuk_Permintaan_Clear2.add(lblFrmRDKKClearSearch3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(lblSearchIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfFrmPerawatan_Permintaan_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFrmPupuk_Permintaan_Clear2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSearchIcon3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlFrmPupuk_Permintaan_Clear2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jtfFrmPerawatan_Permintaan_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pnlFrmPerawatan_Permintaan.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 629, 30));

        jScrollPane13.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane13.setBorder(null);
        jScrollPane13.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane13.setMinimumSize(new java.awt.Dimension(0, 0));

        tblPetani_Perawatan_Permintaan.setBackground(new java.awt.Color(170, 193, 193));
        tblPetani_Perawatan_Permintaan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblPetani_Perawatan_Permintaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPetani_Perawatan_Permintaan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblPetani_Perawatan_Permintaan.setAutoscrolls(false);
        tblPetani_Perawatan_Permintaan.setFillsViewportHeight(true);
        tblPetani_Perawatan_Permintaan.setGridColor(new java.awt.Color(255, 255, 255));
        tblPetani_Perawatan_Permintaan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblPetani_Perawatan_Permintaan.setName("tblPetani_Pupuk_Permintaan"); // NOI18N
        tblPetani_Perawatan_Permintaan.setOpaque(false);
        tblPetani_Perawatan_Permintaan.setRowHeight(24);
        tblPetani_Perawatan_Permintaan.setShowHorizontalLines(false);
        tblPetani_Perawatan_Permintaan.setShowVerticalLines(false);
        tblPetani_Perawatan_Permintaan.getTableHeader().setResizingAllowed(false);
        tblPetani_Perawatan_Permintaan.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(tblPetani_Perawatan_Permintaan);

        pnlFrmPerawatan_Permintaan.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 80, 630, 224));

        jPanel14.setBackground(new java.awt.Color(85, 131, 131));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel20.setText("Paket Pekerjaan Perawatan");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlFrmPerawatan_Permintaan.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 629, 30));

        pnlFrmPerawatan_Permintaan_Tambah.setBackground(new Color(255,255,255,0));
        pnlFrmPerawatan_Permintaan_Tambah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmPerawatan_Permintaan_Tambah.setName("pnlFrmPerawatan_Permintaan_Tambah"); // NOI18N
        pnlFrmPerawatan_Permintaan_Tambah.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back27.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Plus_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back27.setText("Tambah");
        lblFrmInputRDKK_Back27.setIconTextGap(10);
        lblFrmInputRDKK_Back27.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmPerawatan_Permintaan_Tambah.add(lblFrmInputRDKK_Back27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlFrmPerawatan_Permintaan.add(pnlFrmPerawatan_Permintaan_Tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 316, -1, -1));

        jScrollPane14.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane14.setBorder(null);
        jScrollPane14.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane14.setMinimumSize(new java.awt.Dimension(0, 0));

        tblPekerjaanKebun_Perawatan_Permintaan.setBackground(new java.awt.Color(170, 193, 193));
        tblPekerjaanKebun_Perawatan_Permintaan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblPekerjaanKebun_Perawatan_Permintaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPekerjaanKebun_Perawatan_Permintaan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblPekerjaanKebun_Perawatan_Permintaan.setAutoscrolls(false);
        tblPekerjaanKebun_Perawatan_Permintaan.setFillsViewportHeight(true);
        tblPekerjaanKebun_Perawatan_Permintaan.setGridColor(new java.awt.Color(255, 255, 255));
        tblPekerjaanKebun_Perawatan_Permintaan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblPekerjaanKebun_Perawatan_Permintaan.setName("tblPetani_Pupuk_Permintaan"); // NOI18N
        tblPekerjaanKebun_Perawatan_Permintaan.setOpaque(false);
        tblPekerjaanKebun_Perawatan_Permintaan.setRowHeight(24);
        tblPekerjaanKebun_Perawatan_Permintaan.setShowHorizontalLines(false);
        tblPekerjaanKebun_Perawatan_Permintaan.setShowVerticalLines(false);
        tblPekerjaanKebun_Perawatan_Permintaan.getTableHeader().setResizingAllowed(false);
        tblPekerjaanKebun_Perawatan_Permintaan.getTableHeader().setReorderingAllowed(false);
        jScrollPane14.setViewportView(tblPekerjaanKebun_Perawatan_Permintaan);

        pnlFrmPerawatan_Permintaan.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 630, 268));

        jPanel15.setBackground(new java.awt.Color(85, 131, 131));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel21.setText("Detail Petani");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlFrmPerawatan_Permintaan.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 50, 630, 30));

        dtpTglTransaksiPerawatan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dtpTglTransaksiPerawatan.setFormats("dd-MM-yyyy");
        pnlFrmPerawatan_Permintaan.add(dtpTglTransaksiPerawatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 316, 120, 30));

        pnlFrmPerawatan_Permintaan_Simpan.setBackground(new Color(255,255,255,0));
        pnlFrmPerawatan_Permintaan_Simpan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmPerawatan_Permintaan_Simpan.setName("pnlFrmPerawatan_Permintaan_Simpan"); // NOI18N
        pnlFrmPerawatan_Permintaan_Simpan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back28.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Save_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back28.setText("Simpan");
        lblFrmInputRDKK_Back28.setIconTextGap(10);
        lblFrmInputRDKK_Back28.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmPerawatan_Permintaan_Simpan.add(lblFrmInputRDKK_Back28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlFrmPerawatan_Permintaan.add(pnlFrmPerawatan_Permintaan_Simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 316, -1, -1));

        pnlFrmPerawatan_Permintaan_LihatData.setBackground(new Color(255,255,255,0));
        pnlFrmPerawatan_Permintaan_LihatData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmPerawatan_Permintaan_LihatData.setName("pnlFrmPerawatan_Permintaan_LihatData"); // NOI18N
        pnlFrmPerawatan_Permintaan_LihatData.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlFrmPerawatan_Permintaan_LihatData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back29.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_View_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back29.setText("Lihat");
        lblFrmInputRDKK_Back29.setIconTextGap(10);
        lblFrmInputRDKK_Back29.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmPerawatan_Permintaan_LihatData.add(lblFrmInputRDKK_Back29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlFrmPerawatan_Permintaan.add(pnlFrmPerawatan_Permintaan_LihatData, new org.netbeans.lib.awtextra.AbsoluteConstraints(838, 316, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel23.setText("Tanggal Transaksi");
        pnlFrmPerawatan_Permintaan.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 320, -1, -1));

        jPanel16.setBackground(new java.awt.Color(85, 131, 131));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel22.setText("Permintaan Pekerjaan Perawatan");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlFrmPerawatan_Permintaan.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 360, 630, 30));

        jScrollPane15.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane15.setBorder(null);
        jScrollPane15.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane15.setMinimumSize(new java.awt.Dimension(0, 0));

        tblBuffer_Perawatan_Permintaan.setBackground(new java.awt.Color(170, 193, 193));
        tblBuffer_Perawatan_Permintaan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblBuffer_Perawatan_Permintaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblBuffer_Perawatan_Permintaan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblBuffer_Perawatan_Permintaan.setAutoscrolls(false);
        tblBuffer_Perawatan_Permintaan.setFillsViewportHeight(true);
        tblBuffer_Perawatan_Permintaan.setGridColor(new java.awt.Color(255, 255, 255));
        tblBuffer_Perawatan_Permintaan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblBuffer_Perawatan_Permintaan.setName("tblPetani_Pupuk_Permintaan"); // NOI18N
        tblBuffer_Perawatan_Permintaan.setOpaque(false);
        tblBuffer_Perawatan_Permintaan.setRowHeight(24);
        tblBuffer_Perawatan_Permintaan.setShowHorizontalLines(false);
        tblBuffer_Perawatan_Permintaan.setShowVerticalLines(false);
        tblBuffer_Perawatan_Permintaan.getTableHeader().setResizingAllowed(false);
        tblBuffer_Perawatan_Permintaan.getTableHeader().setReorderingAllowed(false);
        jScrollPane15.setViewportView(tblBuffer_Perawatan_Permintaan);

        pnlFrmPerawatan_Permintaan.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 390, 630, 268));

        pnlContent.add(pnlFrmPerawatan_Permintaan, "crdFrmPerawatan_Permintaan");

        pnlFrmPerawatan_BonDalam.setBackground(new java.awt.Color(0, 23, 23));
        pnlFrmPerawatan_BonDalam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmInputRDKK_MenuHolder8.setBackground(new java.awt.Color(0, 70, 70));
        pnlFrmInputRDKK_MenuHolder8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmPerawatan_BonDalam_Back.setBackground(new Color(255,255,255,0));
        pnlFrmPerawatan_BonDalam_Back.setName("pnlFrmPerawatan_BonDalam_Back"); // NOI18N
        pnlFrmPerawatan_BonDalam_Back.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlFrmPerawatan_BonDalam_Back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmInputRDKK_Back30.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Back_To_26px.png"))); // NOI18N
        lblFrmInputRDKK_Back30.setText("Permintaan Perawatan");
        lblFrmInputRDKK_Back30.setIconTextGap(10);
        lblFrmInputRDKK_Back30.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmPerawatan_BonDalam_Back.add(lblFrmInputRDKK_Back30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, 40));

        pnlFrmInputRDKK_MenuHolder8.add(pnlFrmPerawatan_BonDalam_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, -1));

        pnlFrmRDKK_Title7.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmRDKK_Title7.setName("pnlFrmRDKKBack"); // NOI18N
        pnlFrmRDKK_Title7.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlFrmRDKK_Title7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        lblFrmRDKK_Title10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmRDKK_Title10.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKK_Title10.setText("Data Transaksi");
        lblFrmRDKK_Title10.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlFrmRDKK_Title7.add(lblFrmRDKK_Title10);

        pnlFrmInputRDKK_MenuHolder8.add(pnlFrmRDKK_Title7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1100, -1));

        pnlFrmPerawatan_BonDalam.add(pnlFrmInputRDKK_MenuHolder8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1399, -1));

        jScrollPane16.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane16.setBorder(null);
        jScrollPane16.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane16.setMinimumSize(new java.awt.Dimension(0, 0));

        tblPosting_Perawatan_Permintaan.setBackground(new java.awt.Color(170, 193, 193));
        tblPosting_Perawatan_Permintaan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblPosting_Perawatan_Permintaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPosting_Perawatan_Permintaan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblPosting_Perawatan_Permintaan.setAutoscrolls(false);
        tblPosting_Perawatan_Permintaan.setFillsViewportHeight(true);
        tblPosting_Perawatan_Permintaan.setGridColor(new java.awt.Color(255, 255, 255));
        tblPosting_Perawatan_Permintaan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblPosting_Perawatan_Permintaan.setName("tblPetani_Pupuk_Permintaan"); // NOI18N
        tblPosting_Perawatan_Permintaan.setOpaque(false);
        tblPosting_Perawatan_Permintaan.setRowHeight(24);
        tblPosting_Perawatan_Permintaan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPosting_Perawatan_Permintaan.setShowHorizontalLines(false);
        tblPosting_Perawatan_Permintaan.setShowVerticalLines(false);
        tblPosting_Perawatan_Permintaan.getTableHeader().setResizingAllowed(false);
        tblPosting_Perawatan_Permintaan.getTableHeader().setReorderingAllowed(false);
        jScrollPane16.setViewportView(tblPosting_Perawatan_Permintaan);

        pnlFrmPerawatan_BonDalam.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 380, 200));

        jPanel17.setBackground(new java.awt.Color(85, 131, 131));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel24.setText("Daftar Permintaan Biaya Perawatan");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(182, 182, 182))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlFrmPerawatan_BonDalam.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 380, 30));

        jScrollPane17.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane17.setBorder(null);
        jScrollPane17.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane17.setMinimumSize(new java.awt.Dimension(0, 0));

        tblDetail_Perawatan_Permintaan.setBackground(new java.awt.Color(170, 193, 193));
        tblDetail_Perawatan_Permintaan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblDetail_Perawatan_Permintaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDetail_Perawatan_Permintaan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblDetail_Perawatan_Permintaan.setAutoscrolls(false);
        tblDetail_Perawatan_Permintaan.setFillsViewportHeight(true);
        tblDetail_Perawatan_Permintaan.setGridColor(new java.awt.Color(255, 255, 255));
        tblDetail_Perawatan_Permintaan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblDetail_Perawatan_Permintaan.setName("tblPetani_Pupuk_Permintaan"); // NOI18N
        tblDetail_Perawatan_Permintaan.setOpaque(false);
        tblDetail_Perawatan_Permintaan.setRowHeight(24);
        tblDetail_Perawatan_Permintaan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDetail_Perawatan_Permintaan.setShowHorizontalLines(false);
        tblDetail_Perawatan_Permintaan.setShowVerticalLines(false);
        tblDetail_Perawatan_Permintaan.getTableHeader().setResizingAllowed(false);
        tblDetail_Perawatan_Permintaan.getTableHeader().setReorderingAllowed(false);
        jScrollPane17.setViewportView(tblDetail_Perawatan_Permintaan);

        pnlFrmPerawatan_BonDalam.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 150, 830, 200));

        jPanel18.setBackground(new java.awt.Color(85, 131, 131));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel25.setText("Detail Permintaan Perawatan");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlFrmPerawatan_BonDalam.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 120, 830, 30));

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel19.setOpaque(false);

        lblFrmRDKK_Title11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmRDKK_Title11.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKK_Title11.setText("Nama Kelompok");
        lblFrmRDKK_Title11.setPreferredSize(new java.awt.Dimension(200, 40));

        lblFrmRDKK_Title12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmRDKK_Title12.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKK_Title12.setText("Nomor Kontrak");
        lblFrmRDKK_Title12.setPreferredSize(new java.awt.Dimension(200, 40));

        lblFrmPosting_NamaKelompok.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFrmPosting_NamaKelompok.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmPosting_NamaKelompok.setText("Nama Kelompok");
        lblFrmPosting_NamaKelompok.setPreferredSize(new java.awt.Dimension(200, 40));

        lblFrmPosting_NoKontrak.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFrmPosting_NoKontrak.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmPosting_NoKontrak.setText("Nomor Kontrak");
        lblFrmPosting_NoKontrak.setPreferredSize(new java.awt.Dimension(200, 40));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(lblFrmRDKK_Title11, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFrmPosting_NamaKelompok, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(lblFrmRDKK_Title12, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFrmPosting_NoKontrak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFrmRDKK_Title11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFrmPosting_NamaKelompok, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFrmRDKK_Title12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFrmPosting_NoKontrak, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        pnlFrmPerawatan_BonDalam.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 380, 60));

        pnlFrmPerawatan_Permintaan_CetakBon.setBackground(new Color(255,255,255,0));
        pnlFrmPerawatan_Permintaan_CetakBon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmPerawatan_Permintaan_CetakBon.setName("pnlFrmPerawatan_Permintaan_CetakBon"); // NOI18N
        pnlFrmPerawatan_Permintaan_CetakBon.setPreferredSize(new java.awt.Dimension(150, 30));
        pnlFrmPerawatan_Permintaan_CetakBon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back31.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Print_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back31.setText("Cetak Bon");
        lblFrmInputRDKK_Back31.setIconTextGap(10);
        lblFrmInputRDKK_Back31.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmPerawatan_Permintaan_CetakBon.add(lblFrmInputRDKK_Back31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        pnlFrmPerawatan_BonDalam.add(pnlFrmPerawatan_Permintaan_CetakBon, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 355, -1, -1));

        pnlContent.add(pnlFrmPerawatan_BonDalam, "crdFrmPerawatan_BonDalam");

        pnlAdminSistem_Biaya.setBackground(new java.awt.Color(0, 23, 23));
        pnlAdminSistem_Biaya.setName("pnlAdminSistem_Biaya"); // NOI18N
        pnlAdminSistem_Biaya.setOpaque(false);
        pnlAdminSistem_Biaya.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmInputRDKK_MenuHolder9.setBackground(new java.awt.Color(0, 70, 70));
        pnlFrmInputRDKK_MenuHolder9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAdminSistem_Biaya_Back.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_Biaya_Back.setName("pnlAdminSistem_Biaya_Back"); // NOI18N
        pnlAdminSistem_Biaya_Back.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlAdminSistem_Biaya_Back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmAdminSistem_Kembali2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmAdminSistem_Kembali2.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmAdminSistem_Kembali2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Back_To_26px.png"))); // NOI18N
        lblFrmAdminSistem_Kembali2.setText("Kembali");
        lblFrmAdminSistem_Kembali2.setIconTextGap(10);
        lblFrmAdminSistem_Kembali2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_Biaya_Back.add(lblFrmAdminSistem_Kembali2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        pnlFrmInputRDKK_MenuHolder9.add(pnlAdminSistem_Biaya_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        pnlFrmRDKK_Title8.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmRDKK_Title8.setName("pnlFrmRDKKBack"); // NOI18N
        pnlFrmRDKK_Title8.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlFrmRDKK_Title8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        lblFrmRDKK_Title13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmRDKK_Title13.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKK_Title13.setText("Manajemen Biaya Produksi");
        lblFrmRDKK_Title13.setPreferredSize(new java.awt.Dimension(400, 40));
        pnlFrmRDKK_Title8.add(lblFrmRDKK_Title13);

        pnlFrmInputRDKK_MenuHolder9.add(pnlFrmRDKK_Title8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 1190, -1));

        pnlAdminSistem_Biaya.add(pnlFrmInputRDKK_MenuHolder9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, -1));

        pnlAdminSistem_Content2.setBackground(new java.awt.Color(0, 23, 23));
        pnlAdminSistem_Content2.setName(""); // NOI18N

        jScrollPane18.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane18.setBorder(null);
        jScrollPane18.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane18.setMinimumSize(new java.awt.Dimension(0, 0));
        jScrollPane18.setPreferredSize(new java.awt.Dimension(466, 400));

        tblMasterBiaya.setBackground(new java.awt.Color(170, 193, 193));
        tblMasterBiaya.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblMasterBiaya.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMasterBiaya.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblMasterBiaya.setFillsViewportHeight(true);
        tblMasterBiaya.setGridColor(new java.awt.Color(255, 255, 255));
        tblMasterBiaya.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblMasterBiaya.setName("tblKelompokTani"); // NOI18N
        tblMasterBiaya.setOpaque(false);
        tblMasterBiaya.setRowHeight(24);
        tblMasterBiaya.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblMasterBiaya.setShowHorizontalLines(false);
        tblMasterBiaya.setShowVerticalLines(false);
        tblMasterBiaya.getTableHeader().setResizingAllowed(false);
        tblMasterBiaya.getTableHeader().setReorderingAllowed(false);
        jScrollPane18.setViewportView(tblMasterBiaya);

        jPanel20.setBackground(new java.awt.Color(85, 131, 131));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel26.setText("Data Biaya Produksi");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlAdminSistem_Biaya_Add.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_Biaya_Add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_Biaya_Add.setName("pnlAdminSistem_Biaya_Add"); // NOI18N
        pnlAdminSistem_Biaya_Add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back33.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Plus_26px.png"))); // NOI18N
        lblFrmInputRDKK_Back33.setIconTextGap(10);
        lblFrmInputRDKK_Back33.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_Biaya_Add.add(lblFrmInputRDKK_Back33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlAdminSistem_Biaya_Edit.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_Biaya_Edit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_Biaya_Edit.setName("pnlAdminSistem_Biaya_Edit"); // NOI18N
        pnlAdminSistem_Biaya_Edit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back34.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Pencil_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back34.setIconTextGap(10);
        lblFrmInputRDKK_Back34.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_Biaya_Edit.add(lblFrmInputRDKK_Back34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlFrmUserData3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmUserData3.setOpaque(false);
        pnlFrmUserData3.setPreferredSize(new java.awt.Dimension(500, 340));

        lblInputNamaKelTani23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani23.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani23.setText("Kategori Tanaman");

        lblInputNamaKelTani27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani27.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani27.setText("Jenis Biaya");

        lblInputNamaKelTani28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani28.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani28.setText("Kode Biaya");

        lblInputNamaKelTani29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani29.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani29.setText("Uraian");

        pnlAdminSistem_Biaya_Save.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_Biaya_Save.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_Biaya_Save.setName("pnlAdminSistem_Biaya_Save"); // NOI18N
        pnlAdminSistem_Biaya_Save.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back35.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Save_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back35.setIconTextGap(10);
        lblFrmInputRDKK_Back35.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_Biaya_Save.add(lblFrmInputRDKK_Back35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlAdminSistem_Biaya_Cancel.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_Biaya_Cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_Biaya_Cancel.setName("pnlAdminSistem_Biaya_Cancel"); // NOI18N
        pnlAdminSistem_Biaya_Cancel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back36.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Cancel_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back36.setIconTextGap(10);
        lblFrmInputRDKK_Back36.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_Biaya_Cancel.add(lblFrmInputRDKK_Back36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jtfMasterBiaya_Harga.setBorder(null);
        jtfMasterBiaya_Harga.setForeground(new java.awt.Color(255, 255, 255));
        jtfMasterBiaya_Harga.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        jtfMasterBiaya_Harga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfMasterBiaya_Harga.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfMasterBiaya_Harga.setEnabled(false);
        jtfMasterBiaya_Harga.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfMasterBiaya_Harga.setOpaque(false);

        pnlUnderUserData9.setPreferredSize(new java.awt.Dimension(290, 1));

        javax.swing.GroupLayout pnlUnderUserData9Layout = new javax.swing.GroupLayout(pnlUnderUserData9);
        pnlUnderUserData9.setLayout(pnlUnderUserData9Layout);
        pnlUnderUserData9Layout.setHorizontalGroup(
            pnlUnderUserData9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );
        pnlUnderUserData9Layout.setVerticalGroup(
            pnlUnderUserData9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jtfMasterBiaya_Uraian.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfMasterBiaya_Uraian.setForeground(new java.awt.Color(255, 255, 255));
        jtfMasterBiaya_Uraian.setBorder(null);
        jtfMasterBiaya_Uraian.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfMasterBiaya_Uraian.setEnabled(false);
        jtfMasterBiaya_Uraian.setOpaque(false);

        pnlUnderUserData10.setPreferredSize(new java.awt.Dimension(290, 1));

        javax.swing.GroupLayout pnlUnderUserData10Layout = new javax.swing.GroupLayout(pnlUnderUserData10);
        pnlUnderUserData10.setLayout(pnlUnderUserData10Layout);
        pnlUnderUserData10Layout.setHorizontalGroup(
            pnlUnderUserData10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlUnderUserData10Layout.setVerticalGroup(
            pnlUnderUserData10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        lblInputNamaKelTani30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani30.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani30.setText("Satuan");

        lblInputNamaKelTani31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani31.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani31.setText("T/G");

        lblInputNamaKelTani32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani32.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani32.setText("Harga Satuan");

        cbxMasterBiaya_JenisBiaya.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMasterBiaya_JenisBiaya.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UPAH", "BAHAN" }));
        cbxMasterBiaya_JenisBiaya.setSelectedIndex(-1);
        cbxMasterBiaya_JenisBiaya.setEnabled(false);

        cbxMasterBiaya_Satuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMasterBiaya_Satuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HA", "KG" }));
        cbxMasterBiaya_Satuan.setSelectedIndex(-1);
        cbxMasterBiaya_Satuan.setEnabled(false);

        cbxMasterBiaya_TahunGiling.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMasterBiaya_TahunGiling.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HA", "KG" }));
        cbxMasterBiaya_TahunGiling.setSelectedIndex(-1);
        cbxMasterBiaya_TahunGiling.setEnabled(false);

        jtfMasterBiaya_KodeBiaya.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfMasterBiaya_KodeBiaya.setForeground(new java.awt.Color(255, 255, 255));
        jtfMasterBiaya_KodeBiaya.setBorder(null);
        jtfMasterBiaya_KodeBiaya.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfMasterBiaya_KodeBiaya.setEnabled(false);
        jtfMasterBiaya_KodeBiaya.setOpaque(false);

        pnlUnderUserData11.setPreferredSize(new java.awt.Dimension(290, 1));

        javax.swing.GroupLayout pnlUnderUserData11Layout = new javax.swing.GroupLayout(pnlUnderUserData11);
        pnlUnderUserData11.setLayout(pnlUnderUserData11Layout);
        pnlUnderUserData11Layout.setHorizontalGroup(
            pnlUnderUserData11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        pnlUnderUserData11Layout.setVerticalGroup(
            pnlUnderUserData11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        cbxMasterBiaya_Kategori.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMasterBiaya_Kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PC", "RT", "NN" }));
        cbxMasterBiaya_Kategori.setSelectedIndex(-1);
        cbxMasterBiaya_Kategori.setEnabled(false);

        javax.swing.GroupLayout pnlFrmUserData3Layout = new javax.swing.GroupLayout(pnlFrmUserData3);
        pnlFrmUserData3.setLayout(pnlFrmUserData3Layout);
        pnlFrmUserData3Layout.setHorizontalGroup(
            pnlFrmUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrmUserData3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFrmUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrmUserData3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlAdminSistem_Biaya_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlAdminSistem_Biaya_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFrmUserData3Layout.createSequentialGroup()
                        .addGroup(pnlFrmUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFrmUserData3Layout.createSequentialGroup()
                                .addComponent(lblInputNamaKelTani30)
                                .addGap(85, 85, 85)
                                .addComponent(cbxMasterBiaya_Satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFrmUserData3Layout.createSequentialGroup()
                                .addGroup(pnlFrmUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblInputNamaKelTani23)
                                    .addComponent(lblInputNamaKelTani27)
                                    .addComponent(lblInputNamaKelTani29)
                                    .addComponent(lblInputNamaKelTani32)
                                    .addComponent(lblInputNamaKelTani28))
                                .addGap(18, 18, 18)
                                .addGroup(pnlFrmUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pnlUnderUserData10, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                    .addComponent(cbxMasterBiaya_JenisBiaya, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnlFrmUserData3Layout.createSequentialGroup()
                                        .addComponent(cbxMasterBiaya_Kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblInputNamaKelTani31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxMasterBiaya_TahunGiling, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(pnlFrmUserData3Layout.createSequentialGroup()
                                        .addGroup(pnlFrmUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pnlUnderUserData9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfMasterBiaya_KodeBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pnlUnderUserData11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfMasterBiaya_Uraian, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfMasterBiaya_Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 2, Short.MAX_VALUE)))))
                        .addGap(551, 551, 551)))
                .addGap(16, 16, 16))
        );
        pnlFrmUserData3Layout.setVerticalGroup(
            pnlFrmUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrmUserData3Layout.createSequentialGroup()
                .addGroup(pnlFrmUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFrmUserData3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblInputNamaKelTani28)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrmUserData3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtfMasterBiaya_KodeBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(pnlUnderUserData11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(pnlFrmUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFrmUserData3Layout.createSequentialGroup()
                        .addGroup(pnlFrmUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlFrmUserData3Layout.createSequentialGroup()
                                .addGroup(pnlFrmUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlFrmUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblInputNamaKelTani31)
                                        .addComponent(cbxMasterBiaya_TahunGiling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlFrmUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblInputNamaKelTani23)
                                        .addComponent(cbxMasterBiaya_Kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19)
                                .addComponent(lblInputNamaKelTani27)
                                .addGap(20, 20, 20)
                                .addComponent(lblInputNamaKelTani29))
                            .addGroup(pnlFrmUserData3Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(cbxMasterBiaya_JenisBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfMasterBiaya_Uraian, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(pnlUnderUserData10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlFrmUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblInputNamaKelTani30)
                            .addComponent(cbxMasterBiaya_Satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblInputNamaKelTani32))
                    .addGroup(pnlFrmUserData3Layout.createSequentialGroup()
                        .addComponent(jtfMasterBiaya_Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(pnlUnderUserData9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(pnlFrmUserData3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAdminSistem_Biaya_Save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAdminSistem_Biaya_Cancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlAdminSistem_Content2Layout = new javax.swing.GroupLayout(pnlAdminSistem_Content2);
        pnlAdminSistem_Content2.setLayout(pnlAdminSistem_Content2Layout);
        pnlAdminSistem_Content2Layout.setHorizontalGroup(
            pnlAdminSistem_Content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminSistem_Content2Layout.createSequentialGroup()
                .addGroup(pnlAdminSistem_Content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlFrmUserData3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAdminSistem_Content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnlAdminSistem_Content2Layout.createSequentialGroup()
                            .addComponent(pnlAdminSistem_Biaya_Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(pnlAdminSistem_Biaya_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 366, Short.MAX_VALUE))
        );
        pnlAdminSistem_Content2Layout.setVerticalGroup(
            pnlAdminSistem_Content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminSistem_Content2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlAdminSistem_Content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAdminSistem_Biaya_Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAdminSistem_Biaya_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFrmUserData3, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pnlAdminSistem_Biaya.add(pnlAdminSistem_Content2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1366, 630));

        pnlContent.add(pnlAdminSistem_Biaya, "crdPnlAdminSistem_Biaya");

        pnlFrmTMA.setBackground(new java.awt.Color(0, 23, 23));
        pnlFrmTMA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmInputRDKK_MenuHolder10.setBackground(new java.awt.Color(0, 70, 70));
        pnlFrmInputRDKK_MenuHolder10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFrmTMA_Back.setBackground(new Color(255,255,255,0));
        pnlFrmTMA_Back.setName("pnlFrmTMA_Back"); // NOI18N
        pnlFrmTMA_Back.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlFrmTMA_Back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmInputRDKK_Back2.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Back_To_26px.png"))); // NOI18N
        lblFrmInputRDKK_Back2.setText("Menu Utama");
        lblFrmInputRDKK_Back2.setIconTextGap(10);
        lblFrmInputRDKK_Back2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmTMA_Back.add(lblFrmInputRDKK_Back2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 40));

        pnlFrmInputRDKK_MenuHolder10.add(pnlFrmTMA_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        pnlFrmRDKK_Title9.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmRDKK_Title9.setName("pnlFrmRDKKBack"); // NOI18N
        pnlFrmRDKK_Title9.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlFrmRDKK_Title9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        lblFrmRDKK_Title14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFrmRDKK_Title14.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmRDKK_Title14.setText("Tebang-Muat-Angkut");
        lblFrmRDKK_Title14.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlFrmRDKK_Title9.add(lblFrmRDKK_Title14);

        pnlFrmInputRDKK_MenuHolder10.add(pnlFrmRDKK_Title9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 1190, -1));

        pnlFrmTMA.add(pnlFrmInputRDKK_MenuHolder10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1399, -1));

        jScrollPane19.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane19.setBorder(null);
        jScrollPane19.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane19.setMinimumSize(new java.awt.Dimension(0, 0));

        tblTMAKelTani.setBackground(new java.awt.Color(170, 193, 193));
        tblTMAKelTani.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblTMAKelTani.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTMAKelTani.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblTMAKelTani.setFillsViewportHeight(true);
        tblTMAKelTani.setGridColor(new java.awt.Color(255, 255, 255));
        tblTMAKelTani.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblTMAKelTani.setName("tblValidasiRDKK"); // NOI18N
        tblTMAKelTani.setOpaque(false);
        tblTMAKelTani.setRowHeight(24);
        tblTMAKelTani.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTMAKelTani.setShowHorizontalLines(false);
        tblTMAKelTani.setShowVerticalLines(false);
        tblTMAKelTani.getTableHeader().setResizingAllowed(false);
        tblTMAKelTani.getTableHeader().setReorderingAllowed(false);
        jScrollPane19.setViewportView(tblTMAKelTani);

        pnlFrmTMA.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 629, 268));

        jPanel21.setBackground(new java.awt.Color(85, 131, 131));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel27.setText("Daftar Kelompok Tani");

        jtfFrmTMA_Search.setBackground(new java.awt.Color(85, 131, 131));
        jtfFrmTMA_Search.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfFrmTMA_Search.setForeground(new java.awt.Color(255, 255, 255));
        jtfFrmTMA_Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jtfFrmTMA_Search.setCaretColor(new java.awt.Color(255, 255, 255));
        jtfFrmTMA_Search.setMargin(new java.awt.Insets(2, 4, 2, 2));

        lblSearchIcon4.setBackground(new java.awt.Color(85, 131, 131));
        lblSearchIcon4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblSearchIcon4.setForeground(new java.awt.Color(51, 51, 51));
        lblSearchIcon4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchIcon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Search_20px.png"))); // NOI18N
        lblSearchIcon4.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 4));
        lblSearchIcon4.setOpaque(true);

        pnlFrmValidasiRDKK_ClearKoord1.setBackground(new java.awt.Color(85, 131, 131));
        pnlFrmValidasiRDKK_ClearKoord1.setName("pnlFrmValidasiRDKK_ClearKoord"); // NOI18N
        pnlFrmValidasiRDKK_ClearKoord1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmRDKKClearSearch4.setBackground(new java.awt.Color(141, 172, 172));
        lblFrmRDKKClearSearch4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblFrmRDKKClearSearch4.setForeground(new java.awt.Color(51, 51, 51));
        lblFrmRDKKClearSearch4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmRDKKClearSearch4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Clear_Symbol_20px.png"))); // NOI18N
        lblFrmRDKKClearSearch4.setAlignmentY(0.0F);
        lblFrmRDKKClearSearch4.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 4));
        lblFrmRDKKClearSearch4.setIconTextGap(0);
        lblFrmRDKKClearSearch4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnlFrmValidasiRDKK_ClearKoord1.add(lblFrmRDKKClearSearch4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(lblSearchIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfFrmTMA_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFrmValidasiRDKK_ClearKoord1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSearchIcon4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlFrmValidasiRDKK_ClearKoord1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jtfFrmTMA_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pnlFrmTMA.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 629, 30));

        jScrollPane20.setBackground(new java.awt.Color(170, 193, 193));
        jScrollPane20.setBorder(null);
        jScrollPane20.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane20.setMinimumSize(new java.awt.Dimension(0, 0));

        tblTMADataTimbang.setBackground(new java.awt.Color(170, 193, 193));
        tblTMADataTimbang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblTMADataTimbang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTMADataTimbang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblTMADataTimbang.setFillsViewportHeight(true);
        tblTMADataTimbang.setGridColor(new java.awt.Color(255, 255, 255));
        tblTMADataTimbang.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblTMADataTimbang.setName("tblKelompokTani"); // NOI18N
        tblTMADataTimbang.setOpaque(false);
        tblTMADataTimbang.setRowHeight(24);
        tblTMADataTimbang.setShowHorizontalLines(false);
        tblTMADataTimbang.setShowVerticalLines(false);
        tblTMADataTimbang.getTableHeader().setResizingAllowed(false);
        tblTMADataTimbang.getTableHeader().setReorderingAllowed(false);
        jScrollPane20.setViewportView(tblTMADataTimbang);

        pnlFrmTMA.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 650, 200));

        jPanel22.setBackground(new java.awt.Color(85, 131, 131));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel28.setText("Data Timbang");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlFrmTMA.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 650, 30));

        jPanel23.setOpaque(false);

        pnlFrmTMAPosting.setBackground(new Color(255,255,255,0));
        pnlFrmTMAPosting.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmTMAPosting.setName("pnlFrmTMAPosting"); // NOI18N
        pnlFrmTMAPosting.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlFrmTMAPosting.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back32.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Save_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back32.setText("Posting Biaya");
        lblFrmInputRDKK_Back32.setIconTextGap(10);
        lblFrmInputRDKK_Back32.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmTMAPosting.add(lblFrmInputRDKK_Back32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 30));

        pnlFrmTMALihat.setBackground(new Color(255,255,255,0));
        pnlFrmTMALihat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmTMALihat.setName("pnlFrmTMALihat"); // NOI18N
        pnlFrmTMALihat.setPreferredSize(new java.awt.Dimension(100, 40));
        pnlFrmTMALihat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back37.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Search_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back37.setText("Lihat Data");
        lblFrmInputRDKK_Back37.setIconTextGap(10);
        lblFrmInputRDKK_Back37.setPreferredSize(new java.awt.Dimension(206, 20));
        lblFrmInputRDKK_Back37.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmTMALihat.add(lblFrmInputRDKK_Back37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 30));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(pnlFrmTMAPosting, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFrmTMALihat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 194, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFrmTMAPosting, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFrmTMALihat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        pnlFrmTMA.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 285, 440, 60));

        pnlContent.add(pnlFrmTMA, "crdFrmTMA");

        javax.swing.GroupLayout pnlTengahLayout = new javax.swing.GroupLayout(pnlTengah);
        pnlTengah.setLayout(pnlTengahLayout);
        pnlTengahLayout.setHorizontalGroup(
            pnlTengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNavigasi, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlTengahLayout.setVerticalGroup(
            pnlTengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTengahLayout.createSequentialGroup()
                .addComponent(pnlNavigasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBawah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlAtas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlTengah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlAtas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlTengah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlBawah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxDesa;
    private javax.swing.JComboBox<String> cbxFrmBahanProduksi_JenisBahan;
    private javax.swing.JComboBox<String> cbxFrmBahanProduksi_Satuan;
    private javax.swing.JComboBox<String> cbxFrmBahanProduksi_SatuanMasuk;
    private javax.swing.JComboBox<String> cbxFrmInputRDKK_Afdeling;
    private javax.swing.JComboBox<String> cbxFrmPupuk_EvaluasiBiayaPupuk_Afd;
    private javax.swing.JComboBox<String> cbxFrmUserData_Afdeling;
    private javax.swing.JComboBox<String> cbxFrmUserData_Level;
    private javax.swing.JComboBox<String> cbxInputRDKKMasaTanam;
    private javax.swing.JComboBox<String> cbxInputRDKKVarietas;
    private javax.swing.JComboBox<String> cbxKategoriTanaman;
    private javax.swing.JComboBox<String> cbxKecamatan;
    private javax.swing.JComboBox<String> cbxMasterBiaya_JenisBiaya;
    private javax.swing.JComboBox<String> cbxMasterBiaya_Kategori;
    private javax.swing.JComboBox<String> cbxMasterBiaya_Satuan;
    private javax.swing.JComboBox<String> cbxMasterBiaya_TahunGiling;
    private org.jdesktop.swingx.JXDatePicker dtpFrmPupuk_EvaluasiBiayaPupuk_Tgl1;
    private org.jdesktop.swingx.JXDatePicker dtpFrmPupuk_EvaluasiBiayaPupuk_Tgl2;
    private org.jdesktop.swingx.JXDatePicker dtpTglTransaksiPerawatan;
    private org.jdesktop.swingx.JXDatePicker dtpTglTransaksiPupuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JCheckBox jcbFrmPupuk_PilihSemuaPetani;
    private javax.swing.JCheckBox jcbFrmPupuk_PilihSemuaPupuk;
    private javax.swing.JFormattedTextField jftInputRDKKEasting;
    private javax.swing.JFormattedTextField jftInputRDKKLuas;
    private javax.swing.JFormattedTextField jftInputRDKKNorthing;
    private javax.swing.JFormattedTextField jtfFrmBahanProduksi_Dosis;
    private javax.swing.JFormattedTextField jtfFrmBahanProduksi_KuantaMasuk;
    private javax.swing.JTextField jtfFrmBahanProduksi_NamaBahan;
    private javax.swing.JFormattedTextField jtfFrmBahanProduksi_NilaiMasuk;
    private javax.swing.JTextField jtfFrmBahanProduksi_NoKontrak;
    private javax.swing.JTextField jtfFrmPerawatan_Permintaan_Cari;
    private javax.swing.JTextField jtfFrmPupuk_Permintaan_Cari;
    private javax.swing.JTextField jtfFrmRDKKCari;
    private javax.swing.JTextField jtfFrmTMA_Search;
    private javax.swing.JTextField jtfFrmUserData_NamaLengkap;
    private javax.swing.JTextField jtfFrmUserData_Password;
    private javax.swing.JTextField jtfFrmUserData_Username;
    private javax.swing.JTextField jtfFrmValidasiRDKK_SearchKoord;
    private javax.swing.JTextField jtfInputNoKtpKoord;
    private javax.swing.JTextField jtfInputRDKKNamaKoord;
    private javax.swing.JTextField jtfInputRDKKNamaPetani;
    private javax.swing.JTextField jtfLoginUsername;
    private javax.swing.JFormattedTextField jtfMasterBiaya_Harga;
    private javax.swing.JTextField jtfMasterBiaya_KodeBiaya;
    private javax.swing.JTextField jtfMasterBiaya_Uraian;
    private javax.swing.JPasswordField jtpLoginPassword;
    private javax.swing.JLabel judulUtama;
    private javax.swing.JLabel lblBackground1;
    private javax.swing.JLabel lblDataKelTani;
    private javax.swing.JLabel lblFrmAdminSistem_Kembali;
    private javax.swing.JLabel lblFrmAdminSistem_Kembali1;
    private javax.swing.JLabel lblFrmAdminSistem_Kembali2;
    private javax.swing.JLabel lblFrmInputRDKK_Back;
    private javax.swing.JLabel lblFrmInputRDKK_Back1;
    private javax.swing.JLabel lblFrmInputRDKK_Back10;
    private javax.swing.JLabel lblFrmInputRDKK_Back11;
    private javax.swing.JLabel lblFrmInputRDKK_Back12;
    private javax.swing.JLabel lblFrmInputRDKK_Back13;
    private javax.swing.JLabel lblFrmInputRDKK_Back14;
    private javax.swing.JLabel lblFrmInputRDKK_Back15;
    private javax.swing.JLabel lblFrmInputRDKK_Back16;
    private javax.swing.JLabel lblFrmInputRDKK_Back17;
    private javax.swing.JLabel lblFrmInputRDKK_Back18;
    private javax.swing.JLabel lblFrmInputRDKK_Back19;
    private javax.swing.JLabel lblFrmInputRDKK_Back2;
    private javax.swing.JLabel lblFrmInputRDKK_Back20;
    private javax.swing.JLabel lblFrmInputRDKK_Back21;
    private javax.swing.JLabel lblFrmInputRDKK_Back22;
    private javax.swing.JLabel lblFrmInputRDKK_Back23;
    private javax.swing.JLabel lblFrmInputRDKK_Back24;
    private javax.swing.JLabel lblFrmInputRDKK_Back25;
    private javax.swing.JLabel lblFrmInputRDKK_Back26;
    private javax.swing.JLabel lblFrmInputRDKK_Back27;
    private javax.swing.JLabel lblFrmInputRDKK_Back28;
    private javax.swing.JLabel lblFrmInputRDKK_Back29;
    private javax.swing.JLabel lblFrmInputRDKK_Back3;
    private javax.swing.JLabel lblFrmInputRDKK_Back30;
    private javax.swing.JLabel lblFrmInputRDKK_Back31;
    private javax.swing.JLabel lblFrmInputRDKK_Back32;
    private javax.swing.JLabel lblFrmInputRDKK_Back33;
    private javax.swing.JLabel lblFrmInputRDKK_Back34;
    private javax.swing.JLabel lblFrmInputRDKK_Back35;
    private javax.swing.JLabel lblFrmInputRDKK_Back36;
    private javax.swing.JLabel lblFrmInputRDKK_Back37;
    private javax.swing.JLabel lblFrmInputRDKK_Back4;
    private javax.swing.JLabel lblFrmInputRDKK_Back5;
    private javax.swing.JLabel lblFrmInputRDKK_Back6;
    private javax.swing.JLabel lblFrmInputRDKK_Back7;
    private javax.swing.JLabel lblFrmInputRDKK_Back8;
    private javax.swing.JLabel lblFrmInputRDKK_Back9;
    private javax.swing.JLabel lblFrmPosting_NamaKelompok;
    private javax.swing.JLabel lblFrmPosting_NoKontrak;
    private javax.swing.JLabel lblFrmRDKKBack;
    private javax.swing.JLabel lblFrmRDKKClearSearch;
    private javax.swing.JLabel lblFrmRDKKClearSearch1;
    private javax.swing.JLabel lblFrmRDKKClearSearch2;
    private javax.swing.JLabel lblFrmRDKKClearSearch3;
    private javax.swing.JLabel lblFrmRDKKClearSearch4;
    private javax.swing.JLabel lblFrmRDKKJudul;
    private javax.swing.JLabel lblFrmRDKK_Title;
    private javax.swing.JLabel lblFrmRDKK_Title1;
    private javax.swing.JLabel lblFrmRDKK_Title10;
    private javax.swing.JLabel lblFrmRDKK_Title11;
    private javax.swing.JLabel lblFrmRDKK_Title12;
    private javax.swing.JLabel lblFrmRDKK_Title13;
    private javax.swing.JLabel lblFrmRDKK_Title14;
    private javax.swing.JLabel lblFrmRDKK_Title2;
    private javax.swing.JLabel lblFrmRDKK_Title3;
    private javax.swing.JLabel lblFrmRDKK_Title4;
    private javax.swing.JLabel lblFrmRDKK_Title5;
    private javax.swing.JLabel lblFrmRDKK_Title6;
    private javax.swing.JLabel lblFrmRDKK_Title7;
    private javax.swing.JLabel lblFrmRDKK_Title8;
    private javax.swing.JLabel lblFrmRDKK_Title9;
    private javax.swing.JLabel lblInputNamaKelTani;
    private javax.swing.JLabel lblInputNamaKelTani1;
    private javax.swing.JLabel lblInputNamaKelTani10;
    private javax.swing.JLabel lblInputNamaKelTani11;
    private javax.swing.JLabel lblInputNamaKelTani12;
    private javax.swing.JLabel lblInputNamaKelTani13;
    private javax.swing.JLabel lblInputNamaKelTani14;
    private javax.swing.JLabel lblInputNamaKelTani15;
    private javax.swing.JLabel lblInputNamaKelTani16;
    private javax.swing.JLabel lblInputNamaKelTani17;
    private javax.swing.JLabel lblInputNamaKelTani18;
    private javax.swing.JLabel lblInputNamaKelTani19;
    private javax.swing.JLabel lblInputNamaKelTani2;
    private javax.swing.JLabel lblInputNamaKelTani20;
    private javax.swing.JLabel lblInputNamaKelTani21;
    private javax.swing.JLabel lblInputNamaKelTani22;
    private javax.swing.JLabel lblInputNamaKelTani23;
    private javax.swing.JLabel lblInputNamaKelTani24;
    private javax.swing.JLabel lblInputNamaKelTani25;
    private javax.swing.JLabel lblInputNamaKelTani26;
    private javax.swing.JLabel lblInputNamaKelTani27;
    private javax.swing.JLabel lblInputNamaKelTani28;
    private javax.swing.JLabel lblInputNamaKelTani29;
    private javax.swing.JLabel lblInputNamaKelTani3;
    private javax.swing.JLabel lblInputNamaKelTani30;
    private javax.swing.JLabel lblInputNamaKelTani31;
    private javax.swing.JLabel lblInputNamaKelTani32;
    private javax.swing.JLabel lblInputNamaKelTani33;
    private javax.swing.JLabel lblInputNamaKelTani4;
    private javax.swing.JLabel lblInputNamaKelTani5;
    private javax.swing.JLabel lblInputNamaKelTani6;
    private javax.swing.JLabel lblInputNamaKelTani7;
    private javax.swing.JLabel lblInputNamaKelTani8;
    private javax.swing.JLabel lblInputNamaKelTani9;
    private javax.swing.JLabel lblLoginDesc;
    private javax.swing.JLabel lblLoginPassword;
    private javax.swing.JLabel lblLoginUsername;
    private javax.swing.JLabel lblMenuKeluar;
    private javax.swing.JLabel lblMenuNav;
    private javax.swing.JLabel lblMenuPBH;
    private javax.swing.JLabel lblMenuPBH1;
    private javax.swing.JLabel lblMenuPerawatan;
    private javax.swing.JLabel lblMenuPupuk;
    private javax.swing.JLabel lblMenuRDKK;
    private javax.swing.JLabel lblMenuRDKK1;
    private javax.swing.JLabel lblMenuTMA;
    private javax.swing.JLabel lblSearchIcon;
    private javax.swing.JLabel lblSearchIcon1;
    private javax.swing.JLabel lblSearchIcon2;
    private javax.swing.JLabel lblSearchIcon3;
    private javax.swing.JLabel lblSearchIcon4;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblVerifikasiRdkk;
    private javax.swing.JLabel lblWsLKP1;
    private javax.swing.JLabel lblWsLKP2;
    private javax.swing.JLabel lblWsLKP3;
    private javax.swing.JLabel lblWsLKP4;
    private javax.swing.JLabel lblWsRDKK;
    private javax.swing.JLabel lblWsRDKK1;
    private javax.swing.JLabel lblWsRDKK2;
    private javax.swing.JLabel lblWsRDKK3;
    private javax.swing.JLabel lblWsRDKK4;
    private javax.swing.JLayeredPane lypMenuLogin;
    private javax.swing.JLayeredPane lypMenuUtama;
    private javax.swing.JPanel pnlAdminSistem_AddUser;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_Add;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_AddMasuk;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_Cancel;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_CancelMasuk;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_Delete;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_Edit;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_Kembali;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_Save;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_SaveMasuk;
    private javax.swing.JPanel pnlAdminSistem_Biaya;
    private javax.swing.JPanel pnlAdminSistem_Biaya_Add;
    private javax.swing.JPanel pnlAdminSistem_Biaya_Back;
    private javax.swing.JPanel pnlAdminSistem_Biaya_Cancel;
    private javax.swing.JPanel pnlAdminSistem_Biaya_Edit;
    private javax.swing.JPanel pnlAdminSistem_Biaya_Save;
    private javax.swing.JPanel pnlAdminSistem_Cancel;
    private javax.swing.JPanel pnlAdminSistem_Content;
    private javax.swing.JPanel pnlAdminSistem_Content1;
    private javax.swing.JPanel pnlAdminSistem_Content2;
    private javax.swing.JPanel pnlAdminSistem_DeleteUser;
    private javax.swing.JPanel pnlAdminSistem_EditUser;
    private javax.swing.JPanel pnlAdminSistem_Kembali;
    private javax.swing.JPanel pnlAdminSistem_Save;
    private javax.swing.JPanel pnlAdminSistem_UserData;
    private javax.swing.JPanel pnlAtas;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlBackgroundLogin;
    private javax.swing.JPanel pnlBawah;
    private javax.swing.JPanel pnlBlank;
    private javax.swing.JPanel pnlCetak;
    private javax.swing.JPanel pnlCetak_Cetak;
    private javax.swing.JPanel pnlCetak_Content;
    private javax.swing.JPanel pnlCetak_Kembali;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlFrmInputRDKK;
    private javax.swing.JPanel pnlFrmInputRDKK_Back;
    private javax.swing.JPanel pnlFrmInputRDKK_BatalKoord;
    private javax.swing.JPanel pnlFrmInputRDKK_ContainerInputPetani;
    private javax.swing.JPanel pnlFrmInputRDKK_Content;
    private javax.swing.JPanel pnlFrmInputRDKK_Hapus;
    private javax.swing.JPanel pnlFrmInputRDKK_LanjutKoord;
    private javax.swing.JPanel pnlFrmInputRDKK_MenuHolder;
    private javax.swing.JPanel pnlFrmInputRDKK_MenuHolder1;
    private javax.swing.JPanel pnlFrmInputRDKK_MenuHolder10;
    private javax.swing.JPanel pnlFrmInputRDKK_MenuHolder2;
    private javax.swing.JPanel pnlFrmInputRDKK_MenuHolder3;
    private javax.swing.JPanel pnlFrmInputRDKK_MenuHolder4;
    private javax.swing.JPanel pnlFrmInputRDKK_MenuHolder5;
    private javax.swing.JPanel pnlFrmInputRDKK_MenuHolder6;
    private javax.swing.JPanel pnlFrmInputRDKK_MenuHolder7;
    private javax.swing.JPanel pnlFrmInputRDKK_MenuHolder8;
    private javax.swing.JPanel pnlFrmInputRDKK_MenuHolder9;
    private javax.swing.JPanel pnlFrmInputRDKK_SimpanData;
    private javax.swing.JPanel pnlFrmInputRDKK_TambahPetani;
    private javax.swing.JPanel pnlFrmPerawatan_BonDalam;
    private javax.swing.JPanel pnlFrmPerawatan_BonDalam_Back;
    private javax.swing.JPanel pnlFrmPerawatan_Permintaan;
    private javax.swing.JPanel pnlFrmPerawatan_Permintaan_Back;
    private javax.swing.JPanel pnlFrmPerawatan_Permintaan_CetakBon;
    private javax.swing.JPanel pnlFrmPerawatan_Permintaan_LihatData;
    private javax.swing.JPanel pnlFrmPerawatan_Permintaan_Simpan;
    private javax.swing.JPanel pnlFrmPerawatan_Permintaan_Tambah;
    private javax.swing.JPanel pnlFrmPupuk_EvaluasiBiayaPupuk;
    private javax.swing.JPanel pnlFrmPupuk_EvaluasiBiayaPupuk_Back;
    private javax.swing.JPanel pnlFrmPupuk_EvaluasiBiayaPupuk_View;
    private javax.swing.JPanel pnlFrmPupuk_Permintaan;
    private javax.swing.JPanel pnlFrmPupuk_Permintaan_CetakPermintaan;
    private javax.swing.JPanel pnlFrmPupuk_Permintaan_Clear;
    private javax.swing.JPanel pnlFrmPupuk_Permintaan_Clear1;
    private javax.swing.JPanel pnlFrmPupuk_Permintaan_Clear2;
    private javax.swing.JPanel pnlFrmPupuk_Permintaan_Kembali;
    private javax.swing.JPanel pnlFrmPupuk_Permintaan_SimpanData;
    private javax.swing.JPanel pnlFrmPupuk_Permintaan_TambahPupuk;
    private javax.swing.JPanel pnlFrmRDKK;
    private javax.swing.JPanel pnlFrmRDKKBack;
    private javax.swing.JPanel pnlFrmRDKKClearSearch;
    private javax.swing.JPanel pnlFrmRDKKContent;
    private javax.swing.JPanel pnlFrmRDKKJudul;
    private javax.swing.JPanel pnlFrmRDKKJudulKelTani;
    private javax.swing.JPanel pnlFrmRDKKMenuHolder;
    private javax.swing.JPanel pnlFrmRDKK_Title;
    private javax.swing.JPanel pnlFrmRDKK_Title1;
    private javax.swing.JPanel pnlFrmRDKK_Title2;
    private javax.swing.JPanel pnlFrmRDKK_Title3;
    private javax.swing.JPanel pnlFrmRDKK_Title4;
    private javax.swing.JPanel pnlFrmRDKK_Title5;
    private javax.swing.JPanel pnlFrmRDKK_Title6;
    private javax.swing.JPanel pnlFrmRDKK_Title7;
    private javax.swing.JPanel pnlFrmRDKK_Title8;
    private javax.swing.JPanel pnlFrmRDKK_Title9;
    private javax.swing.JPanel pnlFrmTMA;
    private javax.swing.JPanel pnlFrmTMALihat;
    private javax.swing.JPanel pnlFrmTMAPosting;
    private javax.swing.JPanel pnlFrmTMA_Back;
    private javax.swing.JPanel pnlFrmUserData;
    private javax.swing.JPanel pnlFrmUserData1;
    private javax.swing.JPanel pnlFrmUserData2;
    private javax.swing.JPanel pnlFrmUserData3;
    private javax.swing.JPanel pnlFrmValidasiRDKK;
    private javax.swing.JPanel pnlFrmValidasiRDKK_Back;
    private javax.swing.JPanel pnlFrmValidasiRDKK_CetakDraft;
    private javax.swing.JPanel pnlFrmValidasiRDKK_CetakSKK;
    private javax.swing.JPanel pnlFrmValidasiRDKK_ClearKoord;
    private javax.swing.JPanel pnlFrmValidasiRDKK_ClearKoord1;
    private javax.swing.JPanel pnlHolderLogin;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlLoginKeluar;
    private javax.swing.JPanel pnlLoginLogin;
    private javax.swing.JPanel pnlLogoLogin;
    private javax.swing.JPanel pnlMenuAdmin;
    private javax.swing.JPanel pnlMenuHolder;
    private javax.swing.JPanel pnlMenuKeluar;
    private javax.swing.JPanel pnlMenuPBH;
    private javax.swing.JPanel pnlMenuPerawatan;
    private javax.swing.JPanel pnlMenuPupuk;
    private javax.swing.JPanel pnlMenuRDKK;
    private javax.swing.JPanel pnlMenuTMA;
    private javax.swing.JPanel pnlMenuUtama;
    private javax.swing.JPanel pnlNavigasi;
    private javax.swing.JPanel pnlSeparator1;
    private javax.swing.JPanel pnlSeparator2;
    private javax.swing.JPanel pnlSeparator3;
    private javax.swing.JPanel pnlSeparator4;
    private javax.swing.JPanel pnlSeparator6;
    private javax.swing.JPanel pnlSeparator7;
    private javax.swing.JPanel pnlSubMenuAdmin;
    private javax.swing.JPanel pnlSubMenuAdmin_BahanProduksi;
    private javax.swing.JPanel pnlSubMenuAdmin_Biaya;
    private javax.swing.JPanel pnlSubMenuAdmin_UserData;
    private javax.swing.JPanel pnlSubMenuHolder;
    private javax.swing.JPanel pnlSubMenuPerawatan;
    private javax.swing.JPanel pnlSubMenuPerawatan_Evaluasi;
    private javax.swing.JPanel pnlSubMenuPerawatan_Permintaan;
    private javax.swing.JPanel pnlSubMenuPupuk;
    private javax.swing.JPanel pnlSubMenuPupuk_EvaluasiBiayaPupuk;
    private javax.swing.JPanel pnlSubMenuPupuk_Permintaan;
    private javax.swing.JPanel pnlSubMenuRDKK;
    private javax.swing.JPanel pnlSubMenuTMA;
    private javax.swing.JPanel pnlSubMenuTMA_Rekap;
    private javax.swing.JPanel pnlTblInputPetani;
    private javax.swing.JPanel pnlTengah;
    private javax.swing.JPanel pnlUnderUserData1;
    private javax.swing.JPanel pnlUnderUserData10;
    private javax.swing.JPanel pnlUnderUserData11;
    private javax.swing.JPanel pnlUnderUserData12;
    private javax.swing.JPanel pnlUnderUserData2;
    private javax.swing.JPanel pnlUnderUserData3;
    private javax.swing.JPanel pnlUnderUserData4;
    private javax.swing.JPanel pnlUnderUserData5;
    private javax.swing.JPanel pnlUnderUserData7;
    private javax.swing.JPanel pnlUnderUserData8;
    private javax.swing.JPanel pnlUnderUserData9;
    private javax.swing.JPanel pnlUnderline1;
    private javax.swing.JPanel pnlUnderline2;
    private javax.swing.JPanel pnlUnderline3;
    private javax.swing.JPanel pnlUnderline4;
    private javax.swing.JPanel pnlUnderline5;
    private javax.swing.JPanel pnlUnderline6;
    private javax.swing.JPanel pnlUserLogin;
    private javax.swing.JPanel pnlVerifikasiRdkk;
    private javax.swing.JPanel pnlWsRDKK;
    private javax.swing.JPanel pnlWsSeparator1;
    private javax.swing.JPanel pnlWsSeparator2;
    private javax.swing.JPanel pnlWsSeparator3;
    private javax.swing.JPanel pnlWsSeparator4;
    private javax.swing.JPanel pnlWsSeparator5;
    private javax.swing.JTable tblBahanProduksi;
    private javax.swing.JTable tblBuffer_Perawatan_Permintaan;
    private javax.swing.JTable tblBuffer_Pupuk_Permintaan;
    private javax.swing.JTable tblDetail_Perawatan_Permintaan;
    private javax.swing.JTable tblInputPetani;
    private javax.swing.JTable tblJenisPupuk_Pupuk_Permintaan;
    private javax.swing.JTable tblKelTani_Perawatan_Permintaan;
    private javax.swing.JTable tblKelTani_Pupuk_Permintaan;
    private javax.swing.JTable tblKelompokTani;
    private javax.swing.JTable tblMasterBiaya;
    private javax.swing.JTable tblMonitorBahanMasuk;
    private javax.swing.JTable tblPekerjaanKebun_Perawatan_Permintaan;
    private javax.swing.JTable tblPetani_Perawatan_Permintaan;
    private javax.swing.JTable tblPetani_Pupuk_Permintaan;
    private javax.swing.JTable tblPosting_Perawatan_Permintaan;
    private javax.swing.JTable tblTMADataTimbang;
    private javax.swing.JTable tblTMAKelTani;
    private javax.swing.JTable tblUserData;
    private javax.swing.JTable tblValidasiRDKK;
    private javax.swing.JTable tblValidasiRDKK_Petani;
    // End of variables declaration//GEN-END:variables
    
    public JPanel getPnlMenuHolder(){
        return pnlMenuHolder;
    }
    
    public JPanel getPnlSubMenuHolder(){
        return pnlSubMenuHolder;
    }
    
    public JPanel getPnlContent(){
        return pnlContent;
    }
    
    public JLabel getLblFrmRDKKBack(){
        return lblFrmRDKKBack;
    }

    public JLabel getLblMenuNav(){
        return lblMenuNav;
    }
    
    public JTextField getJtfFrmRDKKCari(){
        return jtfFrmRDKKCari;
    }
    
    public JTable getTblKelompokTani(){
        return tblKelompokTani;
    }
    
    public JTable getTblInputPetani(){
        return tblInputPetani;
    }
    
    public JPanel getPnlFrmRDKKClearSearch(){
        return pnlFrmRDKKClearSearch;
    }
    
    public JLabel getLblFrmRDKK_Title(){
        return lblFrmRDKK_Title;
    }
    
    public javax.swing.JComboBox<String> getCbxDesa(){
        return cbxDesa;
    }
    
    public javax.swing.JComboBox<String> getCbxKec(){
        return cbxKecamatan;
    }
   
    public JTextField getJtfInputRDKKNamaKoord(){
        return jtfInputRDKKNamaKoord;
    }
    
    public JTextField getJtfNoKtpKoord(){
        return jtfInputNoKtpKoord;
    }
    
    public JPanel getPnlFrmInputRDKK_ContainerInputPetani(){
        return pnlFrmInputRDKK_ContainerInputPetani;
    }
    
    public JComboBox getCbxInputRDKKVarietas(){
        return cbxInputRDKKVarietas;
    }
    
    public JTextField getJtfInputRDKKNamaPetani(){
        return jtfInputRDKKNamaPetani;
    }
    
    public JComboBox getCbxInputRDKKMasaTanam(){
        return cbxInputRDKKMasaTanam;
    }
    
    public JFormattedTextField getJftInputRDKKLuas(){
        return jftInputRDKKLuas;
    }
    
    public JTable getTblValidasiRDKK(){
        return tblValidasiRDKK;
    }
    
    public JScrollPane getScrollPaneTblValidasi(){
        return jScrollPane2;
    }
    
    public JPanel getPnlFrmValidasiRDKK_ClearKoord(){
        return pnlFrmValidasiRDKK_ClearKoord;
    }
    
    public JTextField getJtfFrmValidasiRDKK_SearchKoord(){
        return jtfFrmValidasiRDKK_SearchKoord;
    }
    
    public JTable getTblValidasiRDKK_Petani(){
        return tblValidasiRDKK_Petani;
    }
    
    public JScrollPane getJScrollPaneTblValidasiRDKK_Petani(){
        return jScrollPane4;
    }
    
    public JComboBox getCbxKategoriTanaman(){
        return cbxKategoriTanaman;
    }
    
    public JTextField getJtfLoginUsername(){
        return jtfLoginUsername;
    }
    
    public JPasswordField getJtpLoginPassword(){
        return jtpLoginPassword;
    }
    
    public JLabel getLblUsername(){
        return lblUsername;
    }
    
    public JLabel getLblLoginDesc(){
        return lblLoginDesc;
    }
    
    public JFormattedTextField getJftEasting(){
        return jftInputRDKKEasting;
    }
    
    public JFormattedTextField getJftNorthing(){
        return jftInputRDKKNorthing;
    }
    
    public JPanel getPnlCetak(){
        return pnlCetak;
    }
    
    public JPanel getPnlCetak_Content(){
        return pnlCetak_Content;
    }
    
    public JTable getTblPupukKelTani(){
        return tblKelTani_Pupuk_Permintaan;
    }
    
    public JTable getTblPupukPetani(){
        return tblPetani_Pupuk_Permintaan;
    }
    
    public JTextField getJtfFrmPupuk_Permintaan_Cari(){
        return jtfFrmPupuk_Permintaan_Cari;
    }
    
    public JTable getTblJenisPupuk_Pupuk_Permintaan(){
        return tblJenisPupuk_Pupuk_Permintaan;
    }
    
    public JCheckBox getJcbFrmPupuk_PilihSemuaPetani(){
        return jcbFrmPupuk_PilihSemuaPetani;
    }
    
    public JXDatePicker getDtpTglTransaksiPupuk(){
        return dtpTglTransaksiPupuk;
    }
    
    public JTable getTblBuffer_Pupuk_Permintaan(){
        return tblBuffer_Pupuk_Permintaan;
    }
    
    public JPanel getPnlFrmPupuk_Permintaan_SimpanData(){
        return pnlFrmPupuk_Permintaan_SimpanData;
    }
    
    public JTextField getJtfFrmUserData_NamaLengkap(){
        return jtfFrmUserData_NamaLengkap;
    }
    
    public JTextField getJtfFrmUserData_Username(){
        return jtfFrmUserData_Username;
    }
    
    public JTextField getJtfFrmUserData_Password(){
        return jtfFrmUserData_Password;
    }
    
    public JTable getTblUserData(){
        return tblUserData;
    }
    
    public JComboBox getCbxFrmUserData_Level(){
        return cbxFrmUserData_Level;
    }
    
    public JComboBox getCbxFrmUserData_Afdeling(){
        return cbxFrmUserData_Afdeling;
    }
    
    public JPanel getPnlAdminSistem_AddUser(){
        return pnlAdminSistem_AddUser;
    }
    
    public JPanel getPnlAdminSistem_EditUser(){
        return pnlAdminSistem_EditUser;
    }
    
    public JPanel getPnlAdminSistem_DeleteUser(){
        return pnlAdminSistem_DeleteUser;
    }
    
    public JPanel getPnlAdminSistem_Save(){
        return pnlAdminSistem_Save;
    }
    
    public JPanel getPnlAdminSistem_Cancel(){
        return pnlAdminSistem_Cancel;
    }
    
    public JTable getTblBahanProduksi(){
        return tblBahanProduksi;
    }
    
    public JTextField getJtfFrmBahanProduksi_NamaBahan(){
        return jtfFrmBahanProduksi_NamaBahan;
    }
    
    public JComboBox getCbxFrmBahanProduksi_JenisBahan(){
        return cbxFrmBahanProduksi_JenisBahan;
    }
    
    public JTextField getJtfFrmBahanProduksi_Dosis(){
        return jtfFrmBahanProduksi_Dosis;
    }
    
    public JComboBox getCbxFrmBahanProduksi_Satuan(){
        return cbxFrmBahanProduksi_Satuan;
    }
    
    public JPanel getPnlAdminSistem_BahanProduksi_Save(){
        return pnlAdminSistem_BahanProduksi_Save;
    }
    
    public JPanel getPnlAdminSistem_BahanProduksi_Cancel(){
        return pnlAdminSistem_BahanProduksi_Cancel;
    }
    
    public JPanel getPnlAdminSistem_BahanProduksi_Add(){
        return pnlAdminSistem_BahanProduksi_Add;
    }
    
    public JPanel getPnlAdminSistem_BahanProduksi_Edit(){
        return pnlAdminSistem_BahanProduksi_Edit;
    }
    
    public JPanel getPnlAdminSistem_BahanProduksi_Delete(){
        return pnlAdminSistem_BahanProduksi_Delete;
    }
    
    public JComboBox getCbxFrmInputRDKK_Afdeling(){
        return cbxFrmInputRDKK_Afdeling;
    }
    
    public JComboBox getCbxFrmBahanProduksi_SatuanMasuk(){
        return cbxFrmBahanProduksi_SatuanMasuk;
    }
    
    public JTextField getJtfFrmBahanProduksi_KuantaMasuk(){
        return jtfFrmBahanProduksi_KuantaMasuk;
    }
    
    public JTextField getJtfFrmBahanProduksi_NilaiMasuk(){
        return jtfFrmBahanProduksi_NilaiMasuk;
    }
    
    public JPanel getPnlAdminSistem_BahanProduksi_CancelMasuk(){
        return pnlAdminSistem_BahanProduksi_CancelMasuk;
    }
    
    public JPanel getPnlAdminSistem_BahanProduksi_SaveMasuk(){
        return pnlAdminSistem_BahanProduksi_SaveMasuk;
    }
    
    public JPanel getPnlAdminSistem_BahanProduksi_AddMasuk(){
        return pnlAdminSistem_BahanProduksi_AddMasuk;
    }
    
    public JTable getTblMonitorBahanMasuk(){
        return tblMonitorBahanMasuk;
    }
    
    public JPanel getPnlSubMenuPupuk_EvaluasiBiayaPupuk(){
        return pnlSubMenuPupuk_EvaluasiBiayaPupuk;
    }
    
    public JPanel getPnlFrmPupuk_EvaluasiBiayaPupuk_Back(){
        return pnlFrmPupuk_EvaluasiBiayaPupuk_Back;
    }
    
    public JComboBox getCbxFrmPupuk_EvaluasiBiayaPupuk(){
        return cbxFrmPupuk_EvaluasiBiayaPupuk_Afd;
    }
    
    public JPanel getPnlFrmPupuk_EvaluasiBiayaPupuk_View(){
        return pnlFrmPupuk_EvaluasiBiayaPupuk_View;
    }
    
    public JXDatePicker getDtpFrmPupuk_EvaluasiBiayaPupuk_Tgl1(){
        return dtpFrmPupuk_EvaluasiBiayaPupuk_Tgl1;
    }
    
    public JXDatePicker getDtpFrmPupuk_EvaluasiBiayaPupuk_Tgl2(){
        return dtpFrmPupuk_EvaluasiBiayaPupuk_Tgl2;
    }
    
    public JPanel getPnlSubMenuPerawatan_Permintaan(){
        return pnlSubMenuPerawatan_Permintaan;
    }
    
    public JPanel getPnlSubMenuPerawatan_Evaluasi(){
        return pnlSubMenuPerawatan_Evaluasi;
    }
    
    public JTable getTblKelTani_Perawatan_Permintaan(){
        return tblKelTani_Perawatan_Permintaan;
    }
    
    public JTable getTblPetani_Perawatan_Permintaan(){
        return tblPetani_Perawatan_Permintaan;
    }
    
    public JTable getTblPekerjaanKebun_Perawatan_Permintaan(){
        return tblPekerjaanKebun_Perawatan_Permintaan;
    }
    
    public JTable getTblBuffer_Perawatan_Permintaan(){
        return tblBuffer_Perawatan_Permintaan;
    }
    
    public JXDatePicker getDtpTglTransaksiPerawatan(){
        return dtpTglTransaksiPerawatan;
    }
    
    public JPanel getPnlFrmPerawatan_Permintaan_CetakBon(){
        return pnlFrmPerawatan_Permintaan_LihatData;
    }
    
    public JPanel getPnlFrmPerawatan_BonDalam_Back(){
        return pnlFrmPupuk_EvaluasiBiayaPupuk_Back;
    }
    
    public JTable getTblPosting_Perawatan_Permintaan(){
        return tblPosting_Perawatan_Permintaan;
    }
    
    public JTable getTblDetailPerawatanPermintaan(){
        return tblDetail_Perawatan_Permintaan;
    }
    
    public JLabel getLblFrmPosting_NamaKelompok(){
        return lblFrmPosting_NamaKelompok;
    }
    
    public JLabel getLblFrmPosting_NoKontrak(){
        return lblFrmPosting_NoKontrak;
    }
    
    public JTable getTblMasterBiaya(){
        return tblMasterBiaya;
    }
    
    public JTextField getJtfMasterBiaya_KodeBiaya(){
        return jtfMasterBiaya_KodeBiaya;
    }
    
    public JTextField getJtfMasterBiaya_Uraian(){
        return jtfMasterBiaya_Uraian;
    }
    
    public JFormattedTextField getJtfMasterBiaya_Harga(){
        return jtfMasterBiaya_Harga;
    }
    
    public JComboBox getCbxMasterBiaya_Kategori(){
        return cbxMasterBiaya_Kategori;
    }
    
    public JComboBox getCbxMasterBiaya_TahunGiling(){
        return cbxMasterBiaya_TahunGiling;
    }
    
    public JComboBox getCbxMasterBiaya_JenisBiaya(){
        return cbxMasterBiaya_JenisBiaya;
    }
    
    public JComboBox getCbxMasterBiaya_Satuan(){
        return cbxMasterBiaya_Satuan;
    }
    
    public JPanel getPnlAdminSistem_Biaya_Save(){
        return pnlAdminSistem_Biaya_Save;
    }
    
    public JPanel getPnlAdminSistem_Biaya_Cancel(){
        return pnlAdminSistem_Biaya_Cancel;
    }
    
    public JPanel getPnlAdminSistem_Biaya_Add(){
        return pnlAdminSistem_Biaya_Add;
    }
    
    public JPanel getPnlAdminSistem_Biaya_Edit(){
        return pnlAdminSistem_Biaya_Edit;
    }
    
    public JTable getTblTMAKelTani(){
        return tblTMAKelTani;
    }
    
    public JTable getTblTMADataTimbang(){
        return tblTMADataTimbang;
    }
    
    public JPanel getPnlFrmTMAPosting(){
        return pnlFrmTMAPosting;
    }
    
    public JPanel getPnlFrmTMALihat(){
        return pnlFrmTMALihat;
    }
    
    public JTextField getJtfFrmBahanProduksi_NoKontrak(){
        return jtfFrmBahanProduksi_NoKontrak;
    }
    
}
