/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.model.KelompokTani;
import java.util.List;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public interface KelompokTaniDAO {
    
    public boolean insertKelompokTani(KelompokTani kt);
    
    public List<KelompokTani> getKelompokTaniByTahun(int tahun, String idAfd);
    
    public List<KelompokTani> getAllKelompokTaniByMultipleField(String keyword, int tahun, String idAfd);
    
    public KelompokTani getKelompokTaniByIdKelompok(String idKelompok);
    
    public void cetakRdkk(String idKelompok);
    
    public JRViewer cetakSKK(String idKelompok);
    
    public JRViewer cetakKontrak(String idKelompok);
    
    public JRViewer testCetakSKK(String idKelompok);
    
    public JasperPrint testCetakLagi(String idKelompok);
    
    public JasperPrint cetakSKK_JP(String idKelompok);
    
    public JasperPrint cetakKontrak_JP(String idKelompok);
    
    public List<KelompokTani> getAllKelompokTaniByTahun(int tahun);
    
}
