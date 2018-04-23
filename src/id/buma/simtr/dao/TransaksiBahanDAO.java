/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.model.BuktiTransaksi;
import id.buma.simtr.model.TransaksiBahan;
import java.util.List;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public interface TransaksiBahanDAO {
    
    public boolean insertNewTransaksiPupuk(TransaksiBahan tp);
    
    public boolean cekDuplicateTransaksiPupuk(String idPetani, int idBahan);
    
    public boolean cekBarangMasuk(int idBahan);
    
    public List<TransaksiBahan> cekStokBahanProduksi(int idBahan);
    
    public boolean cekTransaksiPupukByIdKelompokJenisBahan(String idKelompok, String jenisBahan);
    
    public JasperPrint cetakPermintaanPupuk(String idKelompok);
    
    public JasperPrint cetakEvaluasiPupuk(String idAfd, java.sql.Date tgl1, java.sql.Date tgl2);
    
    public boolean insertBatchTransaksi(List<TransaksiBahan> listTp, BuktiTransaksi buktiTrans);
    
    public boolean insertBuktiTransaksiPupuk(BuktiTransaksi bk);
    
    public String getNewNomorBuktiTransaksi(String idKelompok, int idBahan);
}
