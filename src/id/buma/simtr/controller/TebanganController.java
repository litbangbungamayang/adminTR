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
import id.buma.simtr.model.BuktiTransaksi;
import id.buma.simtr.model.DataTimbang;
import id.buma.simtr.model.Transaksi;
import id.buma.simtr.view.DataTimbang_RowRenderer;
import id.buma.simtr.view.DataTimbang_TableModel;
import id.buma.simtr.view.KelompokTaniTableModel;
import id.buma.simtr.view.MainWindow;
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
        cc.setTableHeaderKelTani(tblDataTimbang.getTableHeader());
        tblDataTimbang.setModel(dttm);
        DataTimbang_RowRenderer dtrr = new DataTimbang_RowRenderer();
        tblDataTimbang.setDefaultRenderer(Object.class, dtrr);
    }
    
    public boolean validasiPostingData(){
        return mw.getTblTMADataTimbang().getSelectedRowCount() > 0;
    }
    
    public void konfirmasiPostingData(){
        if (validasiPostingData()){
            KelompokTaniTableModel kttm = (KelompokTaniTableModel) mw.getTblTMAKelTani().getModel();
            String idKelompok = kttm.getContentList().get(mw.getTblTMAKelTani().getSelectedRow()).getIdKelompok();
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
            int biayaTMA = pekDao.getBiayaTMAByTahunGiling(tahunGiling).getRupiahBiaya();
            int[] selectedTimbang = mw.getTblTMADataTimbang().getSelectedRows();
            for (int i = 0; i < selectedTimbang.length; i++){
                lsDtSelected.add(lsDtBuffer.get(selectedTimbang[i]));
            }
            for (DataTimbang dt : lsDtSelected){
                Transaksi tr = new Transaksi(
                        0, 
                        dt.getPetani().getIdPetani(), 
                        0, 
                        0, 
                        dt.getIdTimbangan(), 
                        new java.sql.Date(dt.getTglNetto().getTime()), 
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
