/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.dao.BahanProduksiDAOSQL;
import id.buma.simtr.dao.PetaniDAOSQL;
import id.buma.simtr.dao.SistemDAOSQL;
import id.buma.simtr.dao.TransaksiPupukDAOSQL;
import id.buma.simtr.model.BahanProduksi;
import id.buma.simtr.model.BufferTable_TransaksiPupuk;
import id.buma.simtr.model.BuktiTransaksi;
import id.buma.simtr.model.KelompokTani;
import id.buma.simtr.model.PetaniTebu;
import id.buma.simtr.model.TransaksiPupuk;
import id.buma.simtr.view.BahanProduksi_PupukTableModel;
import id.buma.simtr.view.BufferTransaksi_PupukRowRenderer;
import id.buma.simtr.view.BufferTransaksi_PupukTableModel;
import id.buma.simtr.view.KelompokTaniTableModel;
import id.buma.simtr.view.MainWindow;
import id.buma.simtr.view.PetaniTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class PupukController implements ActionListener{
    
    private MainWindow mw;
    
    private final CommonController cc = new CommonController(mw);
    
    private final TransaksiPupukDAOSQL transPupukDao = new TransaksiPupukDAOSQL();
    
    private final PetaniDAOSQL petaniDao = new PetaniDAOSQL();
    
    private final BahanProduksiDAOSQL pupukDao = new BahanProduksiDAOSQL();
    
    public static List<TransaksiPupuk> transPupuk = new ArrayList<>();
    
    public static BuktiTransaksi buktiTransaksi;
        
    private final BufferTransaksi_PupukRowRenderer bufferRR = new BufferTransaksi_PupukRowRenderer();
    
    public PupukController(MainWindow mw){
        this.mw = mw;
    }
    
    public void getDaftarPetaniDanPupuk(JTable tblPetani, JTable tblPupuk){
        if (tblPetani.getSelectedRowCount() > 0 && tblPupuk.getSelectedRowCount() > 0){
            
            /* Tabel model PETANI */
            PetaniTableModel ptm = (PetaniTableModel) tblPetani.getModel();
            List<PetaniTebu> listTablePetani = ptm.getContentList();
            List<PetaniTebu> selectedListPetani = new ArrayList<>();
            int[] selectedIndexPetani = tblPetani.getSelectedRows();
            for (int i = 0; i < selectedIndexPetani.length; i++){
                selectedListPetani.add(listTablePetani.get(selectedIndexPetani[i]));
            }

            /*  Tabel model PUPUK */
            BahanProduksi_PupukTableModel bpptm = (BahanProduksi_PupukTableModel) tblPupuk.getModel();
            List<BahanProduksi> listTablePupuk = bpptm.getContentList();
            List<BahanProduksi> selectedListPupuk = new ArrayList<>();
            int[] selectedIndexPupuk = tblPupuk.getSelectedRows();
            for (int i = 0; i < selectedIndexPupuk.length; i++){
                selectedListPupuk.add(listTablePupuk.get(selectedIndexPupuk[i]));
            }

            List<BahanProduksi> listSemuaPupuk = pupukDao.getAllBahanProduksiByJenis("PUPUK");

            List<BufferTable_TransaksiPupuk> lbt = new ArrayList<>();
            if (mw.getDtpTglTransaksiPupuk().getDate() != null){
                transPupuk.clear();
                String idKelompok = selectedListPetani.get(0).getIdKelompok();
                int idBahan = selectedListPupuk.get(0).getIdBahan();
                String noBukti = transPupukDao.getNewNomorBuktiTransaksi(idKelompok,idBahan);
                buktiTransaksi = new BuktiTransaksi(noBukti, cc.getUserId(), cc.getTimestamp());
                
                for (int i = 0; i < selectedListPetani.size(); i++){
                    float[] kuantaArray = new float[listSemuaPupuk.size()];
                    for (int j = 0; j < selectedListPupuk.size(); j++){
                        
                        /* VALIDASI BUFFER UTK DISIMPAN KE DATABASE */
                        java.sql.Date tglTransaksi = new java.sql.Date(mw.getDtpTglTransaksiPupuk().getDate().getTime());
                        String idPetani_Selected = selectedListPetani.get(i).getIdPetani();
                        int idBahan_Selected = selectedListPupuk.get(j).getIdBahan();
                        SistemDAOSQL sisDao = new SistemDAOSQL();
                        int tahunGiling = sisDao.getTahunGiling();
                        boolean cekBarangMasuk = transPupukDao.cekBarangMasuk(idBahan_Selected);
                        boolean cekStatus = transPupukDao.cekDuplicateTransaksiPupuk(idPetani_Selected, idBahan_Selected);
                        if (cekStatus && cekBarangMasuk){
                            float kuantaDb = selectedListPetani.get(i).getLuas()*selectedListPupuk.get(j).getDosisPerHa();
                            TransaksiPupuk tp = new TransaksiPupuk(
                                    0, 
                                    idPetani_Selected, 
                                    idBahan_Selected, 
                                    tglTransaksi,
                                    "D",
                                    kuantaDb, 
                                    cc.getUserId(), 
                                    cc.getTimestamp(),
                                    tahunGiling,
                                    BigInteger.valueOf(0),
                                    noBukti
                            );
                            transPupuk.add(tp);
                        } else {
                            if (!cekStatus){
                                cc.showErrorMsg("Error Transaksi Pupuk", "Sudah ada transaksi pupuk berikut : " + '\n' + "Nama petani : " + 
                                    selectedListPetani.get(i).getNamaPetani() + '\n' + "Bahan pupuk : " + selectedListPupuk.get(j).getNamaBahan());
                            }
                            if (!cekBarangMasuk){
                                cc.showErrorMsg("Error Transaksi Pupuk", "Belum ada transaksi barang masuk untuk : " + selectedListPupuk.get(j).getNamaBahan());
                            }
                        }
                        /*******************/    
                        /* BUFFER UNTUK DITAMPILKAN DI TABEL */
                        float kuanta;
                        for (int k = 0; k < listSemuaPupuk.size(); k++){                       
                            int idBahan_selected = selectedListPupuk.get(j).getIdBahan();
                            float dosisBahanSelected = selectedListPupuk.get(j).getDosisPerHa();
                            float luasPetaniSelected = selectedListPetani.get(i).getLuas();
                            int idBahan_existing = listSemuaPupuk.get(k).getIdBahan();
                            if (idBahan_existing == idBahan_selected && cekStatus && cekBarangMasuk){
                                kuanta = dosisBahanSelected*luasPetaniSelected;
                                kuantaArray[k] = kuanta;
                            }
                        }
                        /*************************************/
                    }
                    BufferTable_TransaksiPupuk bt = new BufferTable_TransaksiPupuk(selectedListPetani.get(i).getNamaPetani(),kuantaArray);
                    lbt.add(bt);
                }
                BufferTransaksi_PupukTableModel btptm = new BufferTransaksi_PupukTableModel(lbt);
                mw.getTblBuffer_Pupuk_Permintaan().setModel(btptm);
                cc.setTableHeaderKelTani(mw.getTblBuffer_Pupuk_Permintaan().getTableHeader());
                mw.getTblBuffer_Pupuk_Permintaan().setDefaultRenderer(Object.class, bufferRR);
            }
        } else {
            if (tblPetani.getSelectedRowCount() == 0) cc.showErrorMsg("Error Transaksi Pupuk", "Pilihlah minimal 1 (satu) nama petani.");
            if (tblPupuk.getSelectedRowCount() == 0) cc.showErrorMsg("Error Transaksi Pupuk", "Pilihlah minimal 1 (satu) jenis pupuk.");
        }
    }
    
    public void insertNewTransaksiPupuk(){
        if (transPupuk.size() > 0 && buktiTransaksi != null){
            if (transPupukDao.insertBatchTransaksiPupuk(transPupuk)){
                transPupukDao.insertBuktiTransaksiPupuk(buktiTransaksi);
                cc.showInfoMsg("Transaksi Pupuk", "Data transaksi telah tersimpan dengan nomor : \n" +
                        "<html><b>" + buktiTransaksi.getNoBukti() + "</b></html>");
                clearTable();
            } else {
                cc.showErrorMsg("Transaksi Pupuk", "Data transaksi pupuk GAGAL!");
            }
        } else {
            clearTable();
        }
    }
    
    public void clearTable(){
        prepareDatePicker();
        transPupuk.clear();
        mw.getTblPupukPetani().clearSelection();
        mw.getTblJenisPupuk_Pupuk_Permintaan().clearSelection();
        mw.getTblPupukKelTani().clearSelection();
        List<BufferTable_TransaksiPupuk> lbt = new ArrayList<>();
        BufferTransaksi_PupukTableModel btptm = new BufferTransaksi_PupukTableModel(lbt);
        mw.getTblBuffer_Pupuk_Permintaan().setModel(btptm);
        cc.setTableHeaderKelTani(mw.getTblBuffer_Pupuk_Permintaan().getTableHeader());
        mw.getTblBuffer_Pupuk_Permintaan().setDefaultRenderer(Object.class, bufferRR);
    }
    
    public void prepareTablePupukKelTani(){
        JTable tbl = mw.getTblPupukKelTani();
        cc.setTableHeaderKelTani(tbl.getTableHeader());
        cc.setTableModelKelTani(tbl);
        cc.setTableRowRendererKelTani(tbl);
        cc.setTableSelectionModel(tbl);
        HandlerSeleksiTabel hst = new HandlerSeleksiTabel(mw, "PupukKelTani-Petani", tbl);
        tbl.getSelectionModel().addListSelectionListener(hst);
    }
    
    public void prepareTablePupukPetani(){
        JTable tbl = mw.getTblPupukPetani();
        cc.setTableHeaderPetani(tbl.getTableHeader());
        List<PetaniTebu> lst = new ArrayList<>();
        PetaniTableModel ptm = new PetaniTableModel(lst);
        cc.setTableModelPetani(tbl, ptm);
        cc.setTableRowRendererPetani(tbl);
    }
    
    public void prepareDatePicker(){
        mw.getDtpTglTransaksiPupuk().setFormats("dd-MMM-yyyy");
        mw.getDtpTglTransaksiPupuk().setDate(new java.util.Date());
    }
    
    public void populateTblPupukPetaniByIdKelompok(JTable tbl, String idKelompok){
        PetaniTableModel ptm = new PetaniTableModel(petaniDao.getAllPetaniTebuByIdKelompok(idKelompok));
        tbl.setModel(ptm);
    }
    
    public void prepareTablePupukJenisPupuk(){
        JTable tbl = mw.getTblJenisPupuk_Pupuk_Permintaan();
        cc.setTableRowRendererJenisPupuk(tbl);
        cc.setTableHeaderKelTani(tbl.getTableHeader());
        List<BahanProduksi> lbp = pupukDao.getAllBahanProduksiByJenis("PUPUK");
        BahanProduksi_PupukTableModel bpptm = new BahanProduksi_PupukTableModel(lbp);
        cc.setTableModelPupuk(tbl, bpptm);
    }
    
    public void selectAllRows(JTable tbl){
        if (tbl.getRowCount() > 0){
            tbl.setRowSelectionInterval(0, tbl.getRowCount() - 1);
            tbl.setEnabled(false);
        }
    }
    
    public void deselectAllRows(JTable tbl){
        tbl.clearSelection();
        tbl.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource().getClass();
        if (obj == JCheckBox.class){
            JCheckBox chkBox = (JCheckBox) e.getSource();
            String chkBoxName = chkBox.getName();
            switch(chkBoxName){
                case "jcbFrmPupuk_PilihSemuaPetani":
                    if (chkBox.isSelected()) 
                        selectAllRows(mw.getTblPupukPetani()); 
                    else
                        deselectAllRows(mw.getTblPupukPetani());
                    break;
                case "jcbFrmPupuk_PilihSemuaPupuk":
                    if (chkBox.isSelected()) 
                        selectAllRows(mw.getTblJenisPupuk_Pupuk_Permintaan());
                    else
                        deselectAllRows(mw.getTblJenisPupuk_Pupuk_Permintaan());
                    break;
            }
        }
    }
    
    public void cetakPermintaanPupuk(JTable tbl){
        MenuController mc = new MenuController(mw);
        if (tbl.getRowCount() >= 1 && tbl.getSelectedRowCount() == 1){
            KelompokTaniTableModel kttm = (KelompokTaniTableModel) tbl.getModel();
            List<KelompokTani> lsKt = kttm.getContentList();
            String idKelompok = lsKt.get(tbl.getSelectedRow()).getIdKelompok();
            String namaKelompok = lsKt.get(tbl.getSelectedRow()).getNamaKelompok();
            if (transPupukDao.cekTransaksiPupukByIdKelompokJenisBahan(idKelompok, "PUPUK")){
                cc.setLastPage("permintaan_pupuk");
                mc.pageSwitcher(mw.getPnlContent(), "crdPnlCetak");
                JasperPrint jp = transPupukDao.cetakPermintaanPupuk(idKelompok);
                cc.setJasperPrint(jp);
                cc.prepareFormCetak(mw.getPnlCetak_Content());
                /*
                JPanel pnlCetak = mw.getPnlCetak_Content();
                JRViewer jrv = new JRViewer(jp);
                pnlCetak.setLayout(new BorderLayout());
                pnlCetak.repaint();
                pnlCetak.removeAll();
                ((JPanel)jrv.getComponent(0)).remove(1);
                ((JPanel)jrv.getComponent(0)).remove(0);
                ((JPanel)jrv.getComponent(0)).remove(2);
                pnlCetak.add(jrv);
                pnlCetak.revalidate();  
                */
            } else {
                cc.showInfoMsg("Permintaan Pupuk", "Tidak ada transaksi pupuk untuk kelompok " + namaKelompok + "! ");
            }
        }
    }
    
    public void cetakEvaluasiPupuk(){
        int selectedIndex = mw.getCbxFrmPupuk_EvaluasiBiayaPupuk().getSelectedIndex() - 1;
        if (selectedIndex > -1 && 
                mw.getDtpFrmPupuk_EvaluasiBiayaPupuk_Tgl1().getDate() != null &&
                mw.getDtpFrmPupuk_EvaluasiBiayaPupuk_Tgl2().getDate() != null){
            java.sql.Date tgl1 = new java.sql.Date(mw.getDtpFrmPupuk_EvaluasiBiayaPupuk_Tgl1().getDate().getTime());
            java.sql.Date tgl2 = new java.sql.Date(mw.getDtpFrmPupuk_EvaluasiBiayaPupuk_Tgl2().getDate().getTime());
            String idafd = mw.getCbxFrmPupuk_EvaluasiBiayaPupuk().getSelectedItem().toString();
            JasperPrint jp = transPupukDao.cetakEvaluasiPupuk(idafd, tgl1, tgl2);
            cc.setLastPage("evaluasi_pupuk");
            MenuController mc = new MenuController(mw);
            mc.pageSwitcher(mw.getPnlContent(), "crdPnlCetak");
            cc.setJasperPrint(jp);
            cc.prepareFormCetak(mw.getPnlCetak_Content());
        } else {
            if (selectedIndex == -1) 
                cc.showErrorMsg("Evaluasi Biaya Pupuk", "Pilih salah satu afdeling!");
            if (mw.getDtpFrmPupuk_EvaluasiBiayaPupuk_Tgl1().getDate() == null) 
                cc.showErrorMsg("Evaluasi Biaya Pupuk", "Pilih tanggal periode awal!");
            if (mw.getDtpFrmPupuk_EvaluasiBiayaPupuk_Tgl2().getDate() == null) 
                cc.showErrorMsg("Evaluasi Biaya Pupuk", "Pilih tanggal periode akhir!");
        }
    }
    
    public void prepareFrmEvaluasiPupuk(){
        int privLevel = CommonController.user.getPrivLevel();
        String afd = CommonController.user.getIdAfd();
        if (privLevel == 1 || privLevel == 2){
            mw.getCbxFrmPupuk_EvaluasiBiayaPupuk().setSelectedIndex(0);
            mw.getCbxFrmPupuk_EvaluasiBiayaPupuk().setEnabled(true);
        } else {
            if (privLevel == 3){
                mw.getCbxFrmPupuk_EvaluasiBiayaPupuk().setSelectedItem(afd);
                mw.getCbxFrmPupuk_EvaluasiBiayaPupuk().setEnabled(false);
            }
        }
    }
    
    public void resetFormEvaluasiPupuk(){
        mw.getDtpFrmPupuk_EvaluasiBiayaPupuk_Tgl1().setDate(null);
        mw.getDtpFrmPupuk_EvaluasiBiayaPupuk_Tgl2().setDate(null);
        mw.getCbxFrmPupuk_EvaluasiBiayaPupuk().setSelectedIndex(0);
    }
    
    public void cetakPrinter(){
        
        if (cc.startPrinting()) cc.showInfoMsg("Transaksi Pupuk", "Print berhasil!");
        else cc.showErrorMsg("Transaksi Pupuk", "Print gagal!");
        
        /*
        if (cc.testPrint2())
            cc.showInfoMsg("Test", "Print OK");
        else
            cc.showErrorMsg("Test", "Failed");
        */
    }
}
