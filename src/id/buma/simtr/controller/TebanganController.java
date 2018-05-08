/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.dao.DataTimbangDAOSQL;
import id.buma.simtr.dao.PekerjaanKebunDAOSQL;
import id.buma.simtr.dao.SistemDAOSQL;
import id.buma.simtr.dao.TransaksiDAOSQL;
import id.buma.simtr.model.BiayaTMA;
import id.buma.simtr.model.BuktiTransaksi;
import id.buma.simtr.model.DataTimbang;
import id.buma.simtr.model.DetailPostingTransaksi;
import id.buma.simtr.model.KelompokTani;
import id.buma.simtr.model.Transaksi;
import id.buma.simtr.view.DataTimbang_RowRenderer;
import id.buma.simtr.view.DataTimbang_TableModel;
import id.buma.simtr.view.DetailPostingPerawatan_Permintaan_RowRenderer;
import id.buma.simtr.view.DetailPostingTMA_HeaderRenderer;
import id.buma.simtr.view.DetailPostingTMA_RowRenderer;
import id.buma.simtr.view.DetailPostingTMA_TableModel;
import id.buma.simtr.view.KelompokTaniTableModel;
import id.buma.simtr.view.MainWindow;
import id.buma.simtr.view.PostingPerawatan_Permintaan_RowRenderer;
import id.buma.simtr.view.PostingPerawatan_Permintaan_TableModel;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Bayu Anandvi Muhardika
 * 
 */

public class TebanganController {
    
    private MainWindow mw;
    private final CommonController cc = new CommonController(mw);
    
    public TebanganController(MainWindow mw){
        this.mw = mw;
    }
    
    public void prepareTableTMAKelTani(){
        JTable tblKelTani = mw.getTblTMAKelTani();
        cc.setTableHeaderKelTani(tblKelTani.getTableHeader());
        cc.setTableModelKelTani(tblKelTani);
        cc.setTableRowRendererKelTani(tblKelTani);
        HandlerSeleksiTabel hst = new HandlerSeleksiTabel(mw, "KelTani-Timbangan", tblKelTani);
        tblKelTani.getSelectionModel().addListSelectionListener(hst);
    }
    
    public void showDetailDataTimbang (String idKelompok){
        DataTimbangDAOSQL timDao = new DataTimbangDAOSQL();
        List<DataTimbang> lsDt = timDao.getDataTimbangByIdKelompok(idKelompok);
        DataTimbang_TableModel dttm = new DataTimbang_TableModel(lsDt);
        JTable tblDataTimbang = mw.getTblTMADataTimbang();
        DetailPostingTMA_HeaderRenderer dpthr = new DetailPostingTMA_HeaderRenderer();
        tblDataTimbang.getTableHeader().setDefaultRenderer(dpthr);
        tblDataTimbang.setModel(dttm);
        DataTimbang_RowRenderer dtrr = new DataTimbang_RowRenderer();
        tblDataTimbang.setDefaultRenderer(Object.class, dtrr);
    }
    
    public boolean validasiPostingData(){
        return mw.getTblTMADataTimbang().getSelectedRowCount() > 0;
    }
    
    public void clearTblTimbang(){
        List<DataTimbang> lsDt = new ArrayList<>();
        DataTimbang_TableModel dttm = new DataTimbang_TableModel(lsDt);
        mw.getTblTMADataTimbang().setModel(dttm);
    }
    
    public void clearTblDetailPosting(){
        List<DetailPostingTransaksi> lsDpt = new ArrayList<>();
        DetailPostingTMA_TableModel dpttm = new DetailPostingTMA_TableModel(lsDpt);
        mw.getTblDetail_TMA().setModel(dpttm);
    }
    
    public boolean prepareFormBonTMA(){
        if (mw.getTblTMAKelTani().getSelectedRow() > -1){
            PostingPerawatan_Permintaan_RowRenderer ppprr = new PostingPerawatan_Permintaan_RowRenderer();
            DetailPostingTMA_RowRenderer dptrr = new DetailPostingTMA_RowRenderer();
            JTable tblPosting = mw.getTblPosting_TMA();
            JTable tblDetail = mw.getTblDetail_TMA();
            DetailPostingTMA_HeaderRenderer dpthr = new DetailPostingTMA_HeaderRenderer();
            cc.setTableHeaderKelTani(tblPosting.getTableHeader());
            tblDetail.getTableHeader().setDefaultRenderer(dpthr);
            tblPosting.setDefaultRenderer(Object.class, ppprr);
            tblDetail.setDefaultRenderer(Object.class, dptrr);
            getPostingTMA();
            HandlerSeleksiTabel hst = new HandlerSeleksiTabel(mw, "PostingTMA-DetailTMA", tblPosting);
            tblPosting.getSelectionModel().addListSelectionListener(hst);
            return true;
        } else {
            cc.showErrorMsg("Data Permintaan Biaya TMA", "Pilih satu nama kelompok!");
        }
        return false;
    }
    
    public void getPostingTMA(){
        KelompokTaniTableModel kttm = (KelompokTaniTableModel) mw.getTblTMAKelTani().getModel();
        KelompokTani kt =  kttm.getContentList().get(mw.getTblTMAKelTani().getSelectedRow());
        TransaksiDAOSQL transDao = new TransaksiDAOSQL();
        List<Transaksi> lsTrn = transDao.getDataTMAByIdKelompokGrouped(kt.getIdKelompok());
        PostingPerawatan_Permintaan_TableModel ppptm = new PostingPerawatan_Permintaan_TableModel(lsTrn);
        mw.getTblPosting_TMA().setModel(ppptm);
        mw.getLblFrmTMA_NamaKelompok().setText(kt.getNamaKelompok());
        mw.getLblFrmTMA_NoKontrak().setText(kt.getNoKontrak());
    }
    
    public void showDetailPosting(String idDokumen){
        TransaksiDAOSQL transDao = new TransaksiDAOSQL();
        JTable tblDetail = mw.getTblDetail_TMA();
        List<DetailPostingTransaksi> lsDpt = transDao.getDetailPostingTransaksiTMAByIdDokumen(idDokumen);
        DetailPostingTMA_TableModel dpttm = new DetailPostingTMA_TableModel(lsDpt);
        tblDetail.setModel(dpttm);
    }
    
    public void konfirmasiPostingData(){
        if (validasiPostingData()){
            KelompokTaniTableModel kttm = (KelompokTaniTableModel) mw.getTblTMAKelTani().getModel();
            KelompokTani kt = kttm.getContentList().get(mw.getTblTMAKelTani().getSelectedRow());
            String idKelompok = kt.getIdKelompok();
            TransaksiDAOSQL transDao = new TransaksiDAOSQL();
            SistemDAOSQL sisDao = new SistemDAOSQL();
            int tahunGiling = sisDao.getTahunGiling();
            String noBukti = transDao.getNewNomorBuktiTransaksi(idKelompok);
            BuktiTransaksi bt = new BuktiTransaksi(noBukti, cc.getUserId(), cc.getTimestamp());
            List<Transaksi> lsTr = new ArrayList<>();
            List<DataTimbang> lsDtBuffer = new ArrayList<>();
            List<DataTimbang> lsDtSelected = new ArrayList<>();
            DataTimbang_TableModel dttm = (DataTimbang_TableModel) mw.getTblTMADataTimbang().getModel();
            lsDtBuffer = dttm.getContentList();
            PekerjaanKebunDAOSQL pekDao = new PekerjaanKebunDAOSQL();
            BiayaTMA bTMA = pekDao.getBiayaTMAByIdKelompokTahunGiling(idKelompok, tahunGiling);
            int biayaTebangMuat = bTMA.getBiayaTebang();
            int biayaAngkut = bTMA.getBiayaAngkut();
            int biayaTMA = biayaAngkut + biayaTebangMuat;
            int[] selectedTimbang = mw.getTblTMADataTimbang().getSelectedRows();
            for (int i = 0; i < selectedTimbang.length; i++){
                lsDtSelected.add(lsDtBuffer.get(selectedTimbang[i]));
            }
            for (DataTimbang dt : lsDtSelected){
                Transaksi tr = new Transaksi(
                        0, 
                        dt.getPetani().getIdPetani(), 
                        0, 
                        15, //TODO : hardcoded
                        dt.getIdTimbangan(), 
                        //new java.sql.Date(dt.getTglNetto().getTime()), 
                        new java.sql.Date(cc.getTimestamp().getTime()),
                        "D", 
                        dt.getNetto(), 
                        cc.getUserId(), 
                        cc.getTimestamp(), 
                        tahunGiling, 
                        BigInteger.valueOf(dt.getNetto()*biayaTMA), 
                        noBukti
                );
                lsTr.add(tr);
            }
            
            if (JOptionPane.showConfirmDialog(mw, "Anda yakin akan melakukan posting data timbang tersebut?", 
                    "Data Transaksi Timbang", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION){
                if (transDao.insertBatchTransaksi(lsTr, bt)){
                    cc.showInfoMsg("Data Transaksi Timbang", "Data telah tersimpan dengan nomor bukti <b>" + noBukti + "</b>");
                    dttm = new DataTimbang_TableModel(lsDtBuffer);
                    mw.getTblTMADataTimbang().setModel(dttm);
                    for (int i = 0; i < lsDtBuffer.size(); i++){
                        for (int j = 0; j < lsDtSelected.size(); j++){
                            if(lsDtSelected.get(j).getIdTimbangan() == lsDtBuffer.get(i).getIdTimbangan()){
                                lsDtBuffer.remove(i);
                            }
                        }
                    }   
                }
            } 
        }
    }
    
}
