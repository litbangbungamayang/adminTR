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
        //*******************************************************//
        /*
        cc.setTableHeaderKelTani(tblKelompokTani.getTableHeader());
        cc.setTableRowRendererKelTani(tblKelompokTani);
        cc.setTableModelKelTani(tblKelompokTani);
        cc.setTableSelectionModel(tblKelompokTani);
        */
        //******************************************************//
        /*
        cc.setTableHeaderPetani(tblInputPetani.getTableHeader());
        cc.setTableRowRendererPetani(tblInputPetani);
        cc.setTableModelPetani(tblInputPetani);
        cc.setTableSelectionModel(tblInputPetani);
        */
        //******************************************************//
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
        pnlFrmValidasiRDKK_EditData.addMouseListener(mc);
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
        autoFilterPupuk.setAffectedTable(tblPetani_Pupuk_Permintaan);
        jtfFrmPupuk_Permintaan_Cari.addKeyListener(autoFilterPupuk);
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
        pnlWsRDKK1 = new javax.swing.JPanel();
        lblWsRDKK1 = new javax.swing.JLabel();
        pnlWsSeparator2 = new javax.swing.JPanel();
        pnlWsLKP1 = new javax.swing.JPanel();
        lblWsLKP1 = new javax.swing.JLabel();
        pnlSubMenuPupuk = new javax.swing.JPanel();
        pnlSubMenuPupuk_Permintaan = new javax.swing.JPanel();
        lblWsRDKK2 = new javax.swing.JLabel();
        pnlWsSeparator3 = new javax.swing.JPanel();
        pnlWsLKP2 = new javax.swing.JPanel();
        lblWsLKP2 = new javax.swing.JLabel();
        pnlSubMenuAdmin = new javax.swing.JPanel();
        pnlSubMenuAdmin_UserData = new javax.swing.JPanel();
        lblWsRDKK3 = new javax.swing.JLabel();
        pnlWsSeparator4 = new javax.swing.JPanel();
        pnlSubMenuAdmin_BahanProduksi = new javax.swing.JPanel();
        lblWsLKP3 = new javax.swing.JLabel();
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
        pnlFrmValidasiRDKK_EditData = new javax.swing.JPanel();
        lblFrmInputRDKK_Back2 = new javax.swing.JLabel();
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
        lblInputNamaKelTani23 = new javax.swing.JLabel();
        jtfFrmBahanProduksi_NamaBahan1 = new javax.swing.JTextField();
        pnlUnderUserData6 = new javax.swing.JPanel();
        lblInputNamaKelTani24 = new javax.swing.JLabel();
        cbxFrmBahanProduksi_JenisBahan1 = new javax.swing.JComboBox<>();
        lblInputNamaKelTani25 = new javax.swing.JLabel();
        lblInputNamaKelTani26 = new javax.swing.JLabel();
        cbxFrmBahanProduksi_Satuan1 = new javax.swing.JComboBox<>();
        pnlAdminSistem_BahanProduksi_Save1 = new javax.swing.JPanel();
        lblFrmInputRDKK_Back20 = new javax.swing.JLabel();
        pnlAdminSistem_BahanProduksi_Cancel1 = new javax.swing.JPanel();
        lblFrmInputRDKK_Back21 = new javax.swing.JLabel();
        jtfFrmBahanProduksi_Dosis1 = new javax.swing.JFormattedTextField();
        pnlUnderUserData7 = new javax.swing.JPanel();

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
        lblMenuPBH1.setText("Administrator Sistem");
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

        pnlWsRDKK1.setBackground(new Color(34,59,14,50));
        pnlWsRDKK1.setName("pnlWsRDKK"); // NOI18N
        pnlWsRDKK1.setPreferredSize(new java.awt.Dimension(250, 50));

        lblWsRDKK1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblWsRDKK1.setForeground(new java.awt.Color(255, 255, 255));
        lblWsRDKK1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWsRDKK1.setText("Kertas Kerja RDKK");

        javax.swing.GroupLayout pnlWsRDKK1Layout = new javax.swing.GroupLayout(pnlWsRDKK1);
        pnlWsRDKK1.setLayout(pnlWsRDKK1Layout);
        pnlWsRDKK1Layout.setHorizontalGroup(
            pnlWsRDKK1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsRDKK1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        pnlWsRDKK1Layout.setVerticalGroup(
            pnlWsRDKK1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsRDKK1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlSubMenuPerawatan.add(pnlWsRDKK1, new java.awt.GridBagConstraints());

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

        pnlWsLKP1.setBackground(new Color(34,59,14,50));
        pnlWsLKP1.setName("pnlWsLKP"); // NOI18N
        pnlWsLKP1.setPreferredSize(new java.awt.Dimension(250, 50));

        lblWsLKP1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblWsLKP1.setForeground(new java.awt.Color(255, 255, 255));
        lblWsLKP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWsLKP1.setText("LKP per Periode");

        javax.swing.GroupLayout pnlWsLKP1Layout = new javax.swing.GroupLayout(pnlWsLKP1);
        pnlWsLKP1.setLayout(pnlWsLKP1Layout);
        pnlWsLKP1Layout.setHorizontalGroup(
            pnlWsLKP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsLKP1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        pnlWsLKP1Layout.setVerticalGroup(
            pnlWsLKP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsLKP1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlSubMenuPerawatan.add(pnlWsLKP1, new java.awt.GridBagConstraints());

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

        pnlWsLKP2.setBackground(new Color(34,59,14,50));
        pnlWsLKP2.setName("pnlWsLKP"); // NOI18N
        pnlWsLKP2.setPreferredSize(new java.awt.Dimension(250, 50));

        lblWsLKP2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblWsLKP2.setForeground(new java.awt.Color(255, 255, 255));
        lblWsLKP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWsLKP2.setText("LKP per Periode");

        javax.swing.GroupLayout pnlWsLKP2Layout = new javax.swing.GroupLayout(pnlWsLKP2);
        pnlWsLKP2.setLayout(pnlWsLKP2Layout);
        pnlWsLKP2Layout.setHorizontalGroup(
            pnlWsLKP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsLKP2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        pnlWsLKP2Layout.setVerticalGroup(
            pnlWsLKP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWsLKP2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlSubMenuPupuk.add(pnlWsLKP2, new java.awt.GridBagConstraints());

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

        pnlSubMenuHolder.add(pnlSubMenuAdmin, "crdSubMenuAdmin");

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

        pnlFrmValidasiRDKK_EditData.setBackground(new Color(255,255,255,0));
        pnlFrmValidasiRDKK_EditData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmValidasiRDKK_EditData.setName("pnlFrmValidasiRDKK_EditData"); // NOI18N
        pnlFrmValidasiRDKK_EditData.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlFrmValidasiRDKK_EditData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back2.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back2.setText("Edit Data");
        lblFrmInputRDKK_Back2.setIconTextGap(10);
        lblFrmInputRDKK_Back2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmValidasiRDKK_EditData.add(lblFrmInputRDKK_Back2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

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
                .addComponent(pnlFrmValidasiRDKK_EditData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFrmValidasiRDKK_CetakDraft, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFrmValidasiRDKK_CetakSKK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 128, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFrmValidasiRDKK_EditData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        pnlFrmPupuk_Permintaan.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 80, 443, 235));

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
        lblFrmInputRDKK_Back8.setText("Tambahkan");
        lblFrmInputRDKK_Back8.setIconTextGap(10);
        lblFrmInputRDKK_Back8.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmPupuk_Permintaan_TambahPupuk.add(lblFrmInputRDKK_Back8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlFrmPupuk_Permintaan.add(pnlFrmPupuk_Permintaan_TambahPupuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 317, -1, -1));

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

        pnlFrmPupuk_Permintaan.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1078, 80, 250, 235));

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
        pnlFrmPupuk_Permintaan.add(jcbFrmPupuk_PilihSemuaPetani, new org.netbeans.lib.awtextra.AbsoluteConstraints(1051, 317, -1, 30));

        jcbFrmPupuk_PilihSemuaPupuk.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jcbFrmPupuk_PilihSemuaPupuk.setForeground(new java.awt.Color(255, 255, 255));
        jcbFrmPupuk_PilihSemuaPupuk.setText("Pilih semua jenis pupuk");
        jcbFrmPupuk_PilihSemuaPupuk.setName("jcbFrmPupuk_PilihSemuaPupuk"); // NOI18N
        jcbFrmPupuk_PilihSemuaPupuk.setOpaque(false);
        pnlFrmPupuk_Permintaan.add(jcbFrmPupuk_PilihSemuaPupuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 317, -1, 30));

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

        pnlFrmPupuk_Permintaan.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 629, 268));

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

        pnlFrmPupuk_Permintaan.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 629, 30));

        dtpTglTransaksiPupuk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlFrmPupuk_Permintaan.add(dtpTglTransaksiPupuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(838, 317, 120, 30));

        pnlFrmPupuk_Permintaan_SimpanData.setBackground(new Color(255,255,255,0));
        pnlFrmPupuk_Permintaan_SimpanData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmPupuk_Permintaan_SimpanData.setName("pnlFrmPupuk_Permintaan_SimpanData"); // NOI18N
        pnlFrmPupuk_Permintaan_SimpanData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back9.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back9.setText("Simpan Data");
        lblFrmInputRDKK_Back9.setIconTextGap(10);
        lblFrmInputRDKK_Back9.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmPupuk_Permintaan_SimpanData.add(lblFrmInputRDKK_Back9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlFrmPupuk_Permintaan.add(pnlFrmPupuk_Permintaan_SimpanData, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 317, -1, -1));

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

        lblInputNamaKelTani23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani23.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani23.setText("Nama Bahan");

        jtfFrmBahanProduksi_NamaBahan1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfFrmBahanProduksi_NamaBahan1.setForeground(new java.awt.Color(255, 255, 255));
        jtfFrmBahanProduksi_NamaBahan1.setBorder(null);
        jtfFrmBahanProduksi_NamaBahan1.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfFrmBahanProduksi_NamaBahan1.setEnabled(false);
        jtfFrmBahanProduksi_NamaBahan1.setOpaque(false);

        pnlUnderUserData6.setPreferredSize(new java.awt.Dimension(290, 1));

        javax.swing.GroupLayout pnlUnderUserData6Layout = new javax.swing.GroupLayout(pnlUnderUserData6);
        pnlUnderUserData6.setLayout(pnlUnderUserData6Layout);
        pnlUnderUserData6Layout.setHorizontalGroup(
            pnlUnderUserData6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        pnlUnderUserData6Layout.setVerticalGroup(
            pnlUnderUserData6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        lblInputNamaKelTani24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani24.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani24.setText("Dosis per hektar");

        cbxFrmBahanProduksi_JenisBahan1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxFrmBahanProduksi_JenisBahan1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PUPUK", "HERBISIDA", "ZAT PEMACU KEMASAKAN", "NUTRISI TANAH" }));
        cbxFrmBahanProduksi_JenisBahan1.setSelectedIndex(-1);
        cbxFrmBahanProduksi_JenisBahan1.setEnabled(false);

        lblInputNamaKelTani25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani25.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani25.setText("Jenis Bahan");

        lblInputNamaKelTani26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani26.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani26.setText("Satuan");

        cbxFrmBahanProduksi_Satuan1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxFrmBahanProduksi_Satuan1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KG", "LITER", "BUAH" }));
        cbxFrmBahanProduksi_Satuan1.setSelectedIndex(-1);
        cbxFrmBahanProduksi_Satuan1.setEnabled(false);
        cbxFrmBahanProduksi_Satuan1.setName("cbxUserData_Afdeling"); // NOI18N

        pnlAdminSistem_BahanProduksi_Save1.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_BahanProduksi_Save1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_BahanProduksi_Save1.setName("pnlAdminSistem_BahanProduksi_Save"); // NOI18N
        pnlAdminSistem_BahanProduksi_Save1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back20.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Save_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back20.setIconTextGap(10);
        lblFrmInputRDKK_Back20.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_BahanProduksi_Save1.add(lblFrmInputRDKK_Back20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlAdminSistem_BahanProduksi_Cancel1.setBackground(new Color(255,255,255,0));
        pnlAdminSistem_BahanProduksi_Cancel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlAdminSistem_BahanProduksi_Cancel1.setName("pnlAdminSistem_BahanProduksi_Cancel"); // NOI18N
        pnlAdminSistem_BahanProduksi_Cancel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back21.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_Cancel_20px.png"))); // NOI18N
        lblFrmInputRDKK_Back21.setIconTextGap(10);
        lblFrmInputRDKK_Back21.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlAdminSistem_BahanProduksi_Cancel1.add(lblFrmInputRDKK_Back21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jtfFrmBahanProduksi_Dosis1.setBorder(null);
        jtfFrmBahanProduksi_Dosis1.setForeground(new java.awt.Color(255, 255, 255));
        jtfFrmBahanProduksi_Dosis1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        jtfFrmBahanProduksi_Dosis1.setCaretColor(new java.awt.Color(204, 204, 204));
        jtfFrmBahanProduksi_Dosis1.setEnabled(false);
        jtfFrmBahanProduksi_Dosis1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfFrmBahanProduksi_Dosis1.setOpaque(false);

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

        javax.swing.GroupLayout pnlFrmUserData2Layout = new javax.swing.GroupLayout(pnlFrmUserData2);
        pnlFrmUserData2.setLayout(pnlFrmUserData2Layout);
        pnlFrmUserData2Layout.setHorizontalGroup(
            pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrmUserData2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrmUserData2Layout.createSequentialGroup()
                        .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInputNamaKelTani25)
                            .addComponent(lblInputNamaKelTani23)
                            .addComponent(lblInputNamaKelTani24)
                            .addComponent(lblInputNamaKelTani26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxFrmBahanProduksi_JenisBahan1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxFrmBahanProduksi_Satuan1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFrmBahanProduksi_NamaBahan1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlUnderUserData6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFrmBahanProduksi_Dosis1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlUnderUserData7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrmUserData2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlAdminSistem_BahanProduksi_Cancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlAdminSistem_BahanProduksi_Save1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        pnlFrmUserData2Layout.setVerticalGroup(
            pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrmUserData2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFrmBahanProduksi_JenisBahan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInputNamaKelTani25))
                .addGap(18, 18, 18)
                .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFrmUserData2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblInputNamaKelTani23))
                    .addComponent(jtfFrmBahanProduksi_NamaBahan1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(pnlUnderUserData6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfFrmBahanProduksi_Dosis1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInputNamaKelTani24))
                .addGap(1, 1, 1)
                .addComponent(pnlUnderUserData7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFrmBahanProduksi_Satuan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInputNamaKelTani26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(pnlFrmUserData2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAdminSistem_BahanProduksi_Save1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAdminSistem_BahanProduksi_Cancel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlAdminSistem_Content1Layout = new javax.swing.GroupLayout(pnlAdminSistem_Content1);
        pnlAdminSistem_Content1.setLayout(pnlAdminSistem_Content1Layout);
        pnlAdminSistem_Content1Layout.setHorizontalGroup(
            pnlAdminSistem_Content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminSistem_Content1Layout.createSequentialGroup()
                .addGroup(pnlAdminSistem_Content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlAdminSistem_Content1Layout.createSequentialGroup()
                        .addComponent(pnlAdminSistem_BahanProduksi_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlAdminSistem_BahanProduksi_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlAdminSistem_BahanProduksi_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFrmUserData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAdminSistem_Content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(pnlFrmUserData2, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
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
                .addGap(5, 5, 5)
                .addGroup(pnlAdminSistem_Content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlAdminSistem_Content1Layout.createSequentialGroup()
                        .addGroup(pnlAdminSistem_Content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlAdminSistem_BahanProduksi_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlAdminSistem_BahanProduksi_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlAdminSistem_BahanProduksi_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlFrmUserData1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlFrmUserData2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlAdminSistem_BahanProduksi.add(pnlAdminSistem_Content1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1366, 630));

        pnlContent.add(pnlAdminSistem_BahanProduksi, "crdPnlAdminSistem_BahanProduksi");

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
    private javax.swing.JComboBox<String> cbxFrmBahanProduksi_JenisBahan1;
    private javax.swing.JComboBox<String> cbxFrmBahanProduksi_Satuan;
    private javax.swing.JComboBox<String> cbxFrmBahanProduksi_Satuan1;
    private javax.swing.JComboBox<String> cbxFrmInputRDKK_Afdeling;
    private javax.swing.JComboBox<String> cbxFrmUserData_Afdeling;
    private javax.swing.JComboBox<String> cbxFrmUserData_Level;
    private javax.swing.JComboBox<String> cbxInputRDKKMasaTanam;
    private javax.swing.JComboBox<String> cbxInputRDKKVarietas;
    private javax.swing.JComboBox<String> cbxKategoriTanaman;
    private javax.swing.JComboBox<String> cbxKecamatan;
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
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JFormattedTextField jtfFrmBahanProduksi_Dosis1;
    private javax.swing.JTextField jtfFrmBahanProduksi_NamaBahan;
    private javax.swing.JTextField jtfFrmBahanProduksi_NamaBahan1;
    private javax.swing.JTextField jtfFrmPupuk_Permintaan_Cari;
    private javax.swing.JTextField jtfFrmRDKKCari;
    private javax.swing.JTextField jtfFrmUserData_NamaLengkap;
    private javax.swing.JTextField jtfFrmUserData_Password;
    private javax.swing.JTextField jtfFrmUserData_Username;
    private javax.swing.JTextField jtfFrmValidasiRDKK_SearchKoord;
    private javax.swing.JTextField jtfInputNoKtpKoord;
    private javax.swing.JTextField jtfInputRDKKNamaKoord;
    private javax.swing.JTextField jtfInputRDKKNamaPetani;
    private javax.swing.JTextField jtfLoginUsername;
    private javax.swing.JPasswordField jtpLoginPassword;
    private javax.swing.JLabel judulUtama;
    private javax.swing.JLabel lblBackground1;
    private javax.swing.JLabel lblDataKelTani;
    private javax.swing.JLabel lblFrmAdminSistem_Kembali;
    private javax.swing.JLabel lblFrmAdminSistem_Kembali1;
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
    private javax.swing.JLabel lblFrmInputRDKK_Back3;
    private javax.swing.JLabel lblFrmInputRDKK_Back4;
    private javax.swing.JLabel lblFrmInputRDKK_Back5;
    private javax.swing.JLabel lblFrmInputRDKK_Back6;
    private javax.swing.JLabel lblFrmInputRDKK_Back7;
    private javax.swing.JLabel lblFrmInputRDKK_Back8;
    private javax.swing.JLabel lblFrmInputRDKK_Back9;
    private javax.swing.JLabel lblFrmRDKKBack;
    private javax.swing.JLabel lblFrmRDKKClearSearch;
    private javax.swing.JLabel lblFrmRDKKClearSearch1;
    private javax.swing.JLabel lblFrmRDKKClearSearch2;
    private javax.swing.JLabel lblFrmRDKKJudul;
    private javax.swing.JLabel lblFrmRDKK_Title;
    private javax.swing.JLabel lblFrmRDKK_Title1;
    private javax.swing.JLabel lblFrmRDKK_Title2;
    private javax.swing.JLabel lblFrmRDKK_Title3;
    private javax.swing.JLabel lblFrmRDKK_Title4;
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
    private javax.swing.JLabel lblInputNamaKelTani3;
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
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblVerifikasiRdkk;
    private javax.swing.JLabel lblWsLKP1;
    private javax.swing.JLabel lblWsLKP2;
    private javax.swing.JLabel lblWsLKP3;
    private javax.swing.JLabel lblWsRDKK;
    private javax.swing.JLabel lblWsRDKK1;
    private javax.swing.JLabel lblWsRDKK2;
    private javax.swing.JLabel lblWsRDKK3;
    private javax.swing.JLayeredPane lypMenuLogin;
    private javax.swing.JLayeredPane lypMenuUtama;
    private javax.swing.JPanel pnlAdminSistem_AddUser;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_Add;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_Cancel;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_Cancel1;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_Delete;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_Edit;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_Kembali;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_Save;
    private javax.swing.JPanel pnlAdminSistem_BahanProduksi_Save1;
    private javax.swing.JPanel pnlAdminSistem_Cancel;
    private javax.swing.JPanel pnlAdminSistem_Content;
    private javax.swing.JPanel pnlAdminSistem_Content1;
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
    private javax.swing.JPanel pnlFrmInputRDKK_MenuHolder2;
    private javax.swing.JPanel pnlFrmInputRDKK_MenuHolder3;
    private javax.swing.JPanel pnlFrmInputRDKK_MenuHolder4;
    private javax.swing.JPanel pnlFrmInputRDKK_MenuHolder5;
    private javax.swing.JPanel pnlFrmInputRDKK_SimpanData;
    private javax.swing.JPanel pnlFrmInputRDKK_TambahPetani;
    private javax.swing.JPanel pnlFrmPupuk_Permintaan;
    private javax.swing.JPanel pnlFrmPupuk_Permintaan_Clear;
    private javax.swing.JPanel pnlFrmPupuk_Permintaan_Clear1;
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
    private javax.swing.JPanel pnlFrmUserData;
    private javax.swing.JPanel pnlFrmUserData1;
    private javax.swing.JPanel pnlFrmUserData2;
    private javax.swing.JPanel pnlFrmValidasiRDKK;
    private javax.swing.JPanel pnlFrmValidasiRDKK_Back;
    private javax.swing.JPanel pnlFrmValidasiRDKK_CetakDraft;
    private javax.swing.JPanel pnlFrmValidasiRDKK_CetakSKK;
    private javax.swing.JPanel pnlFrmValidasiRDKK_ClearKoord;
    private javax.swing.JPanel pnlFrmValidasiRDKK_EditData;
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
    private javax.swing.JPanel pnlSubMenuAdmin_UserData;
    private javax.swing.JPanel pnlSubMenuHolder;
    private javax.swing.JPanel pnlSubMenuPerawatan;
    private javax.swing.JPanel pnlSubMenuPupuk;
    private javax.swing.JPanel pnlSubMenuPupuk_Permintaan;
    private javax.swing.JPanel pnlSubMenuRDKK;
    private javax.swing.JPanel pnlTblInputPetani;
    private javax.swing.JPanel pnlTengah;
    private javax.swing.JPanel pnlUnderUserData1;
    private javax.swing.JPanel pnlUnderUserData2;
    private javax.swing.JPanel pnlUnderUserData3;
    private javax.swing.JPanel pnlUnderUserData4;
    private javax.swing.JPanel pnlUnderUserData5;
    private javax.swing.JPanel pnlUnderUserData6;
    private javax.swing.JPanel pnlUnderUserData7;
    private javax.swing.JPanel pnlUnderline1;
    private javax.swing.JPanel pnlUnderline2;
    private javax.swing.JPanel pnlUnderline3;
    private javax.swing.JPanel pnlUnderline4;
    private javax.swing.JPanel pnlUnderline5;
    private javax.swing.JPanel pnlUnderline6;
    private javax.swing.JPanel pnlUserLogin;
    private javax.swing.JPanel pnlVerifikasiRdkk;
    private javax.swing.JPanel pnlWsLKP1;
    private javax.swing.JPanel pnlWsLKP2;
    private javax.swing.JPanel pnlWsRDKK;
    private javax.swing.JPanel pnlWsRDKK1;
    private javax.swing.JPanel pnlWsSeparator1;
    private javax.swing.JPanel pnlWsSeparator2;
    private javax.swing.JPanel pnlWsSeparator3;
    private javax.swing.JPanel pnlWsSeparator4;
    private javax.swing.JTable tblBahanProduksi;
    private javax.swing.JTable tblBuffer_Pupuk_Permintaan;
    private javax.swing.JTable tblInputPetani;
    private javax.swing.JTable tblJenisPupuk_Pupuk_Permintaan;
    private javax.swing.JTable tblKelTani_Pupuk_Permintaan;
    private javax.swing.JTable tblKelompokTani;
    private javax.swing.JTable tblMonitorBahanMasuk;
    private javax.swing.JTable tblPetani_Pupuk_Permintaan;
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
    
}
