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
import id.buma.simtr.controller.RDKKController;
import id.buma.simtr.controller.TableSelectionController;
import id.buma.simtr.controller.UppercaseTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

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
    
    private final TableSelectionController tsl = new TableSelectionController(this);
        
    
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
        setTableListener();
        //*******************************************************//
        cc.setTableHeaderKelTani(tblKelompokTani.getTableHeader());
        cc.setTableRowRendererKelTani(tblKelompokTani);
        cc.setTableModelKelTani(tblKelompokTani);
        cc.setTableSelectionModel(tblKelompokTani);
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
       tblValidasiRDKK.addMouseListener(tsl);
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
        pnlFrmValidasiRDKK_BatalDraft.addMouseListener(mc);
        pnlFrmValidasiRDKK_CetakDraft.addMouseListener(mc);
        pnlFrmValidasiRDKK_ValidasiDraft.addMouseListener(mc);
    }
    
    private void setTextFieldUppercase(){
        ((AbstractDocument) jtfFrmRDKKCari.getDocument()).setDocumentFilter(df);
        ((AbstractDocument) jtfInputRDKKNamaKoord.getDocument()).setDocumentFilter(df);
        ((AbstractDocument) jtfInputRDKKNamaPetani.getDocument()).setDocumentFilter(df);
        DocumentFilter numOnly = new NumberOnlyTextFilter(16);
        ((AbstractDocument) jtfInputNoKtpKoord.getDocument()).setDocumentFilter(numOnly);
        ((AbstractDocument) jtfFrmValidasiRDKK_SearchKoord.getDocument()).setDocumentFilter(df);
    }
    
    private void setTextFieldAutoClear(){
        
    }
    
    private void setTextAutoFilter(){
        KelTaniAutoFilter autoFilter = new KelTaniAutoFilter(tblKelompokTani);
        jtfFrmRDKKCari.addKeyListener(autoFilter);
        KelTaniAutoFilter validasiKoord = new KelTaniAutoFilter(tblValidasiRDKK);
        jtfFrmValidasiRDKK_SearchKoord.addKeyListener(validasiKoord);
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
        lblBackground = new javax.swing.JLabel();
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
        pnlSubMenuHolder = new javax.swing.JPanel();
        pnlSubMenuLKP = new javax.swing.JPanel();
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
        pnlFrmInputRDKK_ContainerInputPetani = new javax.swing.JPanel();
        pnlBlank = new javax.swing.JPanel();
        pnlTblInputPetani = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInputPetani = new javax.swing.JTable();
        lblInputNamaKelTani4 = new javax.swing.JLabel();
        jtfInputRDKKNamaPetani = new javax.swing.JTextField();
        pnlUnderline3 = new javax.swing.JPanel();
        lblInputNamaKelTani5 = new javax.swing.JLabel();
        cbxInputRDKKMasaTanam = new javax.swing.JComboBox<>();
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
        pnlFrmValidasiRDKK_BatalDraft = new javax.swing.JPanel();
        lblFrmInputRDKK_Back3 = new javax.swing.JLabel();
        pnlFrmValidasiRDKK_CetakDraft = new javax.swing.JPanel();
        lblFrmInputRDKK_Back4 = new javax.swing.JLabel();
        pnlFrmValidasiRDKK_ValidasiDraft = new javax.swing.JPanel();
        lblFrmInputRDKK_Back5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Informasi Administrasi Tebu Rakyat");
        setBackground(new java.awt.Color(255, 255, 255));
        setName("frmUtama"); // NOI18N
        setUndecorated(true);

        pnlAtas.setBackground(new java.awt.Color(0, 153, 153));
        pnlAtas.setPreferredSize(new java.awt.Dimension(1366, 70));

        judulUtama.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
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
            .addGroup(pnlAtasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulUtama, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
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
        pnlTengah.setPreferredSize(new java.awt.Dimension(1366, 668));

        pnlNavigasi.setBackground(new java.awt.Color(0, 105, 105));
        pnlNavigasi.setPreferredSize(new java.awt.Dimension(72, 30));

        lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUsername.setText("Bayu Anandavi Muhardika");

        lblLoginDesc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLoginDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblLoginDesc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLoginDesc.setText("Anda login sebagai");

        lblMenuNav.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMenuNav.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlNavigasiLayout = new javax.swing.GroupLayout(pnlNavigasi);
        pnlNavigasi.setLayout(pnlNavigasiLayout);
        pnlNavigasiLayout.setHorizontalGroup(
            pnlNavigasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNavigasiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMenuNav, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
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

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/sugarcane_4.jpg"))); // NOI18N
        lblBackground.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
        lblMenuRDKK.setText("RDKK");
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
        lblMenuPupuk.setText("Pemakaian Pupuk");
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

        pnlSubMenuHolder.setBackground(new Color(255,255,255,100));
        pnlSubMenuHolder.setLayout(new java.awt.CardLayout());

        pnlSubMenuLKP.setBackground(new Color(255,255,255,150));
        pnlSubMenuLKP.setLayout(new java.awt.GridBagLayout());

        pnlWsRDKK.setBackground(new Color(34,59,14,50));
        pnlWsRDKK.setName("pnlWsRDKK"); // NOI18N
        pnlWsRDKK.setPreferredSize(new java.awt.Dimension(250, 50));

        lblWsRDKK.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblWsRDKK.setForeground(new java.awt.Color(255, 255, 255));
        lblWsRDKK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWsRDKK.setText("Daftar RDKK Baru");

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

        pnlSubMenuLKP.add(pnlWsRDKK, new java.awt.GridBagConstraints());

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

        pnlSubMenuLKP.add(pnlWsSeparator1, new java.awt.GridBagConstraints());

        pnlVerifikasiRdkk.setBackground(new Color(34,59,14,50));
        pnlVerifikasiRdkk.setName("pnlVerifikasiRdkk"); // NOI18N
        pnlVerifikasiRdkk.setPreferredSize(new java.awt.Dimension(250, 50));

        lblVerifikasiRdkk.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblVerifikasiRdkk.setForeground(new java.awt.Color(255, 255, 255));
        lblVerifikasiRdkk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVerifikasiRdkk.setText("Verifikasi RDKK");

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

        pnlSubMenuLKP.add(pnlVerifikasiRdkk, new java.awt.GridBagConstraints());

        pnlSubMenuHolder.add(pnlSubMenuLKP, "crdSubMenuLKP");

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

        lypMenuUtama.setLayer(pnlBackground, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lypMenuUtama.setLayer(pnlMenuHolder, javax.swing.JLayeredPane.PALETTE_LAYER);
        lypMenuUtama.setLayer(pnlSubMenuHolder, javax.swing.JLayeredPane.MODAL_LAYER);

        javax.swing.GroupLayout lypMenuUtamaLayout = new javax.swing.GroupLayout(lypMenuUtama);
        lypMenuUtama.setLayout(lypMenuUtamaLayout);
        lypMenuUtamaLayout.setHorizontalGroup(
            lypMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlSubMenuHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMenuHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lypMenuUtamaLayout.setVerticalGroup(
            lypMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(lypMenuUtamaLayout.createSequentialGroup()
                .addGroup(lypMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lypMenuUtamaLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(pnlMenuHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lypMenuUtamaLayout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(pnlSubMenuHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
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

        pnlFrmRDKKContent.setBackground(new java.awt.Color(0, 70, 70));

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
        lblFrmRDKK_Title.setText("Pendaftaran Draft RDKK");
        lblFrmRDKK_Title.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlFrmRDKK_Title.add(lblFrmRDKK_Title);

        pnlFrmInputRDKK_MenuHolder.add(pnlFrmRDKK_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 1190, -1));

        pnlFrmInputRDKK.add(pnlFrmInputRDKK_MenuHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1399, -1));

        pnlFrmInputRDKK_Content.setBackground(new java.awt.Color(35, 35, 0));
        pnlFrmInputRDKK_Content.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnlFrmInputRDKK_Content.setOpaque(false);

        lblInputNamaKelTani.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani.setText("Nama Ketua Kel.");

        jtfInputRDKKNamaKoord.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
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

        jtfInputNoKtpKoord.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
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
                        .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                                .addComponent(lblInputNamaKelTani2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxKecamatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                                .addComponent(lblInputNamaKelTani8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxKategoriTanaman, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                                .addComponent(lblInputNamaKelTani3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlFrmInputRDKK_ContentLayout.createSequentialGroup()
                                        .addComponent(pnlFrmInputRDKK_LanjutKoord, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(pnlFrmInputRDKK_BatalKoord, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbxDesa, 0, 296, Short.MAX_VALUE))))
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
                .addGap(19, 19, 19)
                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInputNamaKelTani2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxKecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInputNamaKelTani3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFrmInputRDKK_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFrmInputRDKK_BatalKoord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFrmInputRDKK_LanjutKoord, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(344, Short.MAX_VALUE))
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
            .addGap(0, 380, Short.MAX_VALUE)
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

        lblInputNamaKelTani5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInputNamaKelTani5.setForeground(new java.awt.Color(255, 255, 255));
        lblInputNamaKelTani5.setText("Masa Tanam");

        cbxInputRDKKMasaTanam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxInputRDKKMasaTanam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1A", "1B", "2A", "2B", "3A", "3B", "4A", "4B", "5A", "5B", "6A", "6B", "7A", "7B", "8A", "8B", "9A", "9B", "10A", "10B", "11A", "11B", "12A", "12B" }));
        cbxInputRDKKMasaTanam.setSelectedIndex(-1);
        cbxInputRDKKMasaTanam.setToolTipText("");
        cbxInputRDKKMasaTanam.setBorder(null);

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
            .addGap(0, 0, Short.MAX_VALUE)
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

        javax.swing.GroupLayout pnlTblInputPetaniLayout = new javax.swing.GroupLayout(pnlTblInputPetani);
        pnlTblInputPetani.setLayout(pnlTblInputPetaniLayout);
        pnlTblInputPetaniLayout.setHorizontalGroup(
            pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTblInputPetaniLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTblInputPetaniLayout.createSequentialGroup()
                        .addComponent(lblInputNamaKelTani7)
                        .addGap(33, 33, 33)
                        .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jftInputRDKKLuas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pnlUnderline4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlTblInputPetaniLayout.createSequentialGroup()
                                .addComponent(pnlFrmInputRDKK_TambahPetani, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlFrmInputRDKK_Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlFrmInputRDKK_SimpanData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTblInputPetaniLayout.createSequentialGroup()
                            .addComponent(lblInputNamaKelTani5)
                            .addGap(18, 18, 18)
                            .addComponent(cbxInputRDKKMasaTanam, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInputNamaKelTani6)
                            .addGap(18, 18, 18)
                            .addComponent(cbxInputRDKKVarietas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTblInputPetaniLayout.createSequentialGroup()
                            .addComponent(lblInputNamaKelTani4)
                            .addGap(18, 18, 18)
                            .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfInputRDKKNamaPetani)
                                .addComponent(pnlUnderline3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
        );
        pnlTblInputPetaniLayout.setVerticalGroup(
            pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTblInputPetaniLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfInputRDKKNamaPetani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTblInputPetaniLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(pnlUnderline3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblInputNamaKelTani4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInputNamaKelTani5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxInputRDKKMasaTanam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInputNamaKelTani6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxInputRDKKVarietas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTblInputPetaniLayout.createSequentialGroup()
                        .addComponent(jftInputRDKKLuas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(pnlUnderline4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblInputNamaKelTani7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTblInputPetaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFrmInputRDKK_TambahPetani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFrmInputRDKK_Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFrmInputRDKK_SimpanData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 28, Short.MAX_VALUE))
        );

        pnlFrmInputRDKK_ContainerInputPetani.add(pnlTblInputPetani, "crdInputPetani_Table");

        pnlFrmInputRDKK.add(pnlFrmInputRDKK_ContainerInputPetani, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 446, 380));

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

        pnlFrmValidasiRDKK.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 690, 268));

        jPanel2.setBackground(new java.awt.Color(85, 131, 131));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Daftar Draft RDKK");

        jtfFrmValidasiRDKK_SearchKoord.setBackground(new java.awt.Color(85, 131, 131));
        jtfFrmValidasiRDKK_SearchKoord.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSearchIcon1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlFrmValidasiRDKK_ClearKoord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jtfFrmValidasiRDKK_SearchKoord, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlFrmValidasiRDKK.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 690, 30));

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

        pnlFrmValidasiRDKK.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 443, 196));

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

        pnlFrmValidasiRDKK.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 443, 30));

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

        pnlFrmValidasiRDKK_BatalDraft.setBackground(new Color(255,255,255,0));
        pnlFrmValidasiRDKK_BatalDraft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmValidasiRDKK_BatalDraft.setName("pnlFrmValidasiRDKK_BatalDraft"); // NOI18N
        pnlFrmValidasiRDKK_BatalDraft.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlFrmValidasiRDKK_BatalDraft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back3.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back3.setText("Batalkan Draft");
        lblFrmInputRDKK_Back3.setIconTextGap(10);
        lblFrmInputRDKK_Back3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmValidasiRDKK_BatalDraft.add(lblFrmInputRDKK_Back3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        pnlFrmValidasiRDKK_CetakDraft.setBackground(new Color(255,255,255,0));
        pnlFrmValidasiRDKK_CetakDraft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmValidasiRDKK_CetakDraft.setName("pnlFrmValidasiRDKK_CetakDraft"); // NOI18N
        pnlFrmValidasiRDKK_CetakDraft.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlFrmValidasiRDKK_CetakDraft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back4.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back4.setText("Cetak Draft RDKK");
        lblFrmInputRDKK_Back4.setIconTextGap(10);
        lblFrmInputRDKK_Back4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmValidasiRDKK_CetakDraft.add(lblFrmInputRDKK_Back4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 30));

        pnlFrmValidasiRDKK_ValidasiDraft.setBackground(new Color(255,255,255,0));
        pnlFrmValidasiRDKK_ValidasiDraft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlFrmValidasiRDKK_ValidasiDraft.setName("pnlFrmValidasiRDKK_ValidasiDraft"); // NOI18N
        pnlFrmValidasiRDKK_ValidasiDraft.setPreferredSize(new java.awt.Dimension(140, 40));
        pnlFrmValidasiRDKK_ValidasiDraft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFrmInputRDKK_Back5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFrmInputRDKK_Back5.setForeground(new java.awt.Color(255, 255, 255));
        lblFrmInputRDKK_Back5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFrmInputRDKK_Back5.setText("Validasi & Cetak BA SKK");
        lblFrmInputRDKK_Back5.setIconTextGap(10);
        lblFrmInputRDKK_Back5.setPreferredSize(new java.awt.Dimension(206, 20));
        lblFrmInputRDKK_Back5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlFrmValidasiRDKK_ValidasiDraft.add(lblFrmInputRDKK_Back5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 206, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(pnlFrmValidasiRDKK_EditData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlFrmValidasiRDKK_BatalDraft, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlFrmValidasiRDKK_ValidasiDraft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFrmValidasiRDKK_CetakDraft, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 108, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFrmValidasiRDKK_EditData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFrmValidasiRDKK_BatalDraft, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFrmValidasiRDKK_CetakDraft, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(pnlFrmValidasiRDKK_ValidasiDraft, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlFrmValidasiRDKK.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 280, 440, 65));

        pnlContent.add(pnlFrmValidasiRDKK, "crdFrmValidasiRDKK");

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
    private javax.swing.JComboBox<String> cbxInputRDKKMasaTanam;
    private javax.swing.JComboBox<String> cbxInputRDKKVarietas;
    private javax.swing.JComboBox<String> cbxKategoriTanaman;
    private javax.swing.JComboBox<String> cbxKecamatan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JFormattedTextField jftInputRDKKLuas;
    private javax.swing.JTextField jtfFrmRDKKCari;
    private javax.swing.JTextField jtfFrmValidasiRDKK_SearchKoord;
    private javax.swing.JTextField jtfInputNoKtpKoord;
    private javax.swing.JTextField jtfInputRDKKNamaKoord;
    private javax.swing.JTextField jtfInputRDKKNamaPetani;
    private javax.swing.JLabel judulUtama;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblDataKelTani;
    private javax.swing.JLabel lblFrmInputRDKK_Back;
    private javax.swing.JLabel lblFrmInputRDKK_Back1;
    private javax.swing.JLabel lblFrmInputRDKK_Back2;
    private javax.swing.JLabel lblFrmInputRDKK_Back3;
    private javax.swing.JLabel lblFrmInputRDKK_Back4;
    private javax.swing.JLabel lblFrmInputRDKK_Back5;
    private javax.swing.JLabel lblFrmRDKKBack;
    private javax.swing.JLabel lblFrmRDKKClearSearch;
    private javax.swing.JLabel lblFrmRDKKClearSearch1;
    private javax.swing.JLabel lblFrmRDKKJudul;
    private javax.swing.JLabel lblFrmRDKK_Title;
    private javax.swing.JLabel lblFrmRDKK_Title1;
    private javax.swing.JLabel lblInputNamaKelTani;
    private javax.swing.JLabel lblInputNamaKelTani1;
    private javax.swing.JLabel lblInputNamaKelTani2;
    private javax.swing.JLabel lblInputNamaKelTani3;
    private javax.swing.JLabel lblInputNamaKelTani4;
    private javax.swing.JLabel lblInputNamaKelTani5;
    private javax.swing.JLabel lblInputNamaKelTani6;
    private javax.swing.JLabel lblInputNamaKelTani7;
    private javax.swing.JLabel lblInputNamaKelTani8;
    private javax.swing.JLabel lblInputNamaKelTani9;
    private javax.swing.JLabel lblLoginDesc;
    private javax.swing.JLabel lblMenuNav;
    private javax.swing.JLabel lblMenuPBH;
    private javax.swing.JLabel lblMenuPBH1;
    private javax.swing.JLabel lblMenuPerawatan;
    private javax.swing.JLabel lblMenuPupuk;
    private javax.swing.JLabel lblMenuRDKK;
    private javax.swing.JLabel lblMenuTMA;
    private javax.swing.JLabel lblSearchIcon;
    private javax.swing.JLabel lblSearchIcon1;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblVerifikasiRdkk;
    private javax.swing.JLabel lblWsLKP1;
    private javax.swing.JLabel lblWsRDKK;
    private javax.swing.JLabel lblWsRDKK1;
    private javax.swing.JLayeredPane lypMenuUtama;
    private javax.swing.JPanel pnlAtas;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlBawah;
    private javax.swing.JPanel pnlBlank;
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
    private javax.swing.JPanel pnlFrmInputRDKK_SimpanData;
    private javax.swing.JPanel pnlFrmInputRDKK_TambahPetani;
    private javax.swing.JPanel pnlFrmRDKK;
    private javax.swing.JPanel pnlFrmRDKKBack;
    private javax.swing.JPanel pnlFrmRDKKClearSearch;
    private javax.swing.JPanel pnlFrmRDKKContent;
    private javax.swing.JPanel pnlFrmRDKKJudul;
    private javax.swing.JPanel pnlFrmRDKKJudulKelTani;
    private javax.swing.JPanel pnlFrmRDKKMenuHolder;
    private javax.swing.JPanel pnlFrmRDKK_Title;
    private javax.swing.JPanel pnlFrmRDKK_Title1;
    private javax.swing.JPanel pnlFrmValidasiRDKK;
    private javax.swing.JPanel pnlFrmValidasiRDKK_Back;
    private javax.swing.JPanel pnlFrmValidasiRDKK_BatalDraft;
    private javax.swing.JPanel pnlFrmValidasiRDKK_CetakDraft;
    private javax.swing.JPanel pnlFrmValidasiRDKK_ClearKoord;
    private javax.swing.JPanel pnlFrmValidasiRDKK_EditData;
    private javax.swing.JPanel pnlFrmValidasiRDKK_ValidasiDraft;
    private javax.swing.JPanel pnlMenuAdmin;
    private javax.swing.JPanel pnlMenuHolder;
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
    private javax.swing.JPanel pnlSubMenuHolder;
    private javax.swing.JPanel pnlSubMenuLKP;
    private javax.swing.JPanel pnlSubMenuPerawatan;
    private javax.swing.JPanel pnlTblInputPetani;
    private javax.swing.JPanel pnlTengah;
    private javax.swing.JPanel pnlUnderline1;
    private javax.swing.JPanel pnlUnderline2;
    private javax.swing.JPanel pnlUnderline3;
    private javax.swing.JPanel pnlUnderline4;
    private javax.swing.JPanel pnlVerifikasiRdkk;
    private javax.swing.JPanel pnlWsLKP1;
    private javax.swing.JPanel pnlWsRDKK;
    private javax.swing.JPanel pnlWsRDKK1;
    private javax.swing.JPanel pnlWsSeparator1;
    private javax.swing.JPanel pnlWsSeparator2;
    private javax.swing.JTable tblInputPetani;
    private javax.swing.JTable tblKelompokTani;
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
    
}
