/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.model.BuktiTransaksi;
import id.buma.simtr.model.DetailPostingTransaksi;
import id.buma.simtr.model.Transaksi;
import java.util.List;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public interface TransaksiDAO {
    
    public boolean insertNewTransaksiPupuk(Transaksi tp);
    
    public boolean cekDuplikatTransaksiPupuk(String idPetani, int idBahan);
    
    public boolean cekBarangMasuk(int idBahan);
    
    public boolean cekDuplikatTransaksiPekerjaan(String idPetani, int idBiaya);
    
    public List<Transaksi> cekStokBahanProduksi(int idBahan);
    
    public boolean cekTransaksiPupukByIdKelompokJenisBahan(String idKelompok, String jenisBahan);
    
    public JasperPrint cetakPermintaanPupuk(String idKelompok);
    
    public JasperPrint cetakEvaluasiPupuk(String idAfd, java.sql.Date tgl1, java.sql.Date tgl2);
    
    public JasperPrint cetakBonDalam(String idKelompok, String idDokumen);
    
    public boolean insertBatchTransaksi(List<Transaksi> listTp, BuktiTransaksi buktiTrans);
    
    public boolean insertBuktiTransaksiPupuk(BuktiTransaksi bk);
    
    public String getNewNomorBuktiTransaksi(String idKelompok);
    
    public List<Transaksi> getDataTransaksiByIdKelompokGrouped(String idKelompok);
    
    public List<Transaksi> getDataTMAByIdKelompokGrouped(String idKelompok);
    
    public List<DetailPostingTransaksi> getDetailPostingTransaksiByIdDokumen(String idDokumen);
    
    public List<DetailPostingTransaksi> getDetailPostingTransaksiTMAByIdDokumen(String idDokumen);
    
}
