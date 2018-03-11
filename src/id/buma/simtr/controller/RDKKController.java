/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.dao.CounterDAOSQL;
import id.buma.simtr.dao.DesaDAOSQL;
import id.buma.simtr.dao.KecamatanDAOSQL;
import id.buma.simtr.dao.KelompokTaniDAOSQL;
import id.buma.simtr.dao.PetaniDAOSQL;
import id.buma.simtr.dao.SistemDAOSQL;
import id.buma.simtr.dao.VarietasTebuDAOSQL;
import id.buma.simtr.model.Desa;
import id.buma.simtr.model.Kecamatan;
import id.buma.simtr.model.KelompokTani;
import id.buma.simtr.model.PetaniTebu;
import id.buma.simtr.model.VarietasTebu;
import id.buma.simtr.view.KelompokTaniTableModel;
import id.buma.simtr.view.MainWindow;
import id.buma.simtr.view.PetaniTableModel;
import java.awt.Color;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class RDKKController {
    
    private MainWindow mw;
    
    private final CommonController cc = new CommonController(mw);
    
    private final KecamatanDAOSQL kecDao = new KecamatanDAOSQL();
    
    private final DesaDAOSQL desaDao = new DesaDAOSQL();
    
    private final SistemDAOSQL sistDao = new SistemDAOSQL();
    
    private final CounterDAOSQL cntDao = new CounterDAOSQL();
    
    private final KelompokTaniDAOSQL keltanDao = new KelompokTaniDAOSQL();
    
    private final PetaniDAOSQL petaniDao = new PetaniDAOSQL();
    
    private final MenuController mc = new MenuController(mw);
    
    public RDKKController(MainWindow mw){
        this.mw = mw;
    }
    
    public List<String> namaKecamatanList(){
        List<Kecamatan> lsKec = kecDao.getAllKecamatan();
        List<String> lsNamaKec = new ArrayList<>();
        lsKec.forEach((satKec) -> {
            lsNamaKec.add(satKec.getNamaKecamatan());
        });
        return lsNamaKec;
    }
    
    public List<String> namaVarietasList(){
        VarietasTebuDAOSQL varDAO = new VarietasTebuDAOSQL();
        List<VarietasTebu> lsVar = varDAO.getAllVarietasTebu();
        List<String> lsNamaVar = new ArrayList<>();
        lsVar.forEach((satVar) -> {
            lsNamaVar.add(satVar.getNamaRilis());
        });
        return lsNamaVar;
    }
    
    public List<String> namaDesaList(List<Desa> listDesa){
        List<String> lsNamaDesa = new ArrayList<>();
        listDesa.forEach((satDesa) -> {
            lsNamaDesa.add(satDesa.getNamaDesa());
        });
        return lsNamaDesa;
    }
    
    public void getDetailDesa(int selectedIndexKecamatan){
        KecamatanDAOSQL kecDAO = new KecamatanDAOSQL();
        DesaDAOSQL dsDAO = new DesaDAOSQL();
        List<Kecamatan> lsKec = kecDAO.getAllKecamatan();
        String idKec = lsKec.get(selectedIndexKecamatan).getIdKecamatan();
        List<Desa> lsDesa = dsDAO.getDesaByIdKecamatan(idKec);
        List<String> lsNamaDesa = namaDesaList(lsDesa);
        cc.populateComboBox(mw.getCbxDesa(), lsNamaDesa);
    }
    
    public void populateVarietas(JComboBox combobox){
        VarietasTebuDAOSQL varDAO = new VarietasTebuDAOSQL();
        List<VarietasTebu> lsVarteb = varDAO.getAllVarietasTebu();
        List<String> lsNamaVar = new ArrayList<>();
        lsVarteb.forEach((satVar) -> {
            lsNamaVar.add(satVar.getNamaRilis());
        });
        cc.populateComboBox(combobox, lsNamaVar);
    }
    
    public boolean validasiKoordinatorBaru(){
        String noKtp = mw.getJtfNoKtpKoord().getText();
        String namaKoord = mw.getJtfInputRDKKNamaKoord().getText();
        String noRdkk = mw.getJtfInputNoRdkk().getText();
        int selectedIndexCbxKec = mw.getCbxKec().getSelectedIndex() - 1;
        int selectedIndexCbxDesa = mw.getCbxDesa().getSelectedIndex() - 1;
        if (noKtp.isEmpty() == false && namaKoord.isEmpty() == false && noKtp.isEmpty() == false
                && selectedIndexCbxDesa >= 0 && selectedIndexCbxKec >= 0){
            return true;
        } else {
            if (noKtp.isEmpty() == true) cc.showErrorMsg("Validasi", "Nomor KTP harus diisi!");
            if (namaKoord.isEmpty() == true) cc.showErrorMsg("Validasi", "Nama Koordinator harus diisi!");
            if (selectedIndexCbxKec < 0) cc.showErrorMsg("Validasi", "Kecamatan harus dipilih!");
            if (selectedIndexCbxDesa < 0) cc.showErrorMsg("Validasi", "Desa harus dipilih!");
            if (noRdkk.isEmpty() == true) cc.showErrorMsg("Validasi", "Nomor RDKK harus diisi!");
        }
        return false;
    }
    
    public void statusIsianKoord(boolean status){
        mw.getJtfInputRDKKNamaKoord().setEnabled(status);
        mw.getJtfNoKtpKoord().setEnabled(status);
        mw.getJtfInputNoRdkk().setEnabled(status);
        mw.getCbxKec().setEnabled(status);
        mw.getCbxDesa().setEnabled(status);
    }
    
    public boolean validasiInputPetani(){
        String namaPetani = mw.getJtfInputRDKKNamaPetani().getText();
        String luas = mw.getJftInputRDKKLuas().getText();
        int selectedIndexMasaTanam = mw.getCbxInputRDKKMasaTanam().getSelectedIndex();
        int selecTedIndexVarietas = mw.getCbxInputRDKKVarietas().getSelectedIndex() - 1;
        if (namaPetani.isEmpty() == false && luas.isEmpty() == false && 
                selectedIndexMasaTanam >= 0 && selecTedIndexVarietas >=0){
            return true;
        } else {
            if (namaPetani.isEmpty()) cc.showErrorMsg("Validasi", "Nama petani harus diisi!");
            if (luas.isEmpty()) cc.showErrorMsg("Validasi", "Luas areal harus diisi!");
            if (selectedIndexMasaTanam < 0) cc.showErrorMsg("Validasi", "Masa tanam harus dipilih!");
            if (selecTedIndexVarietas < 0) cc.showErrorMsg("Validasi", "Varietas harus dipilih!");
        }
        return false;
    }
    
    public void insertBufferPetani(){
        String namaPetani = mw.getJtfInputRDKKNamaPetani().getText();
        String luas = mw.getJftInputRDKKLuas().getText();
        float luasFloat = Float.parseFloat(luas);
        String masaTanam = mw.getCbxInputRDKKMasaTanam().getSelectedItem().toString();
        int selecTedIndexVarietas = mw.getCbxInputRDKKVarietas().getSelectedIndex() - 1;
        List<VarietasTebu> lsVar = new VarietasTebuDAOSQL().getAllVarietasTebu();
        String idVar = lsVar.get(selecTedIndexVarietas).getIdVarietas();
        PetaniTebu pt = new PetaniTebu("", sistDao.getTahunGiling(), "", namaPetani, masaTanam, luasFloat, idVar);
        cc.insertBufferPetani(pt);
        cc.refreshBufferTablePetani(mw.getTblInputPetani());
        clearInputPetani();
    }
    
    public void testRow(){
        int rowNum = mw.getTblInputPetani().getSelectedRow();
        cc.showErrorMsg("Tes", String.valueOf(rowNum));
    }
    
    public void hapusBarisTabelPetani(int baris){
        if (cc.getSizeArrayPetani() > 0){
            cc.hapusElemenArrayPetani(baris);
            cc.refreshBufferTablePetani(mw.getTblInputPetani());
        } else {
            cc.showErrorMsg("Error", "Anda belum menambahkan petani!");
        }
    }
    
    public void clearInputPetani(){
        mw.getJtfInputRDKKNamaPetani().setText("");
        mw.getCbxInputRDKKMasaTanam().setSelectedIndex(-1);
        mw.getCbxInputRDKKVarietas().setSelectedIndex(-1);
        mw.getJftInputRDKKLuas().setValue(null);
    }
    
    public void clearInputKoordinator(){
        statusIsianKoord(true);
        mw.getJtfInputRDKKNamaKoord().setText("");
        mw.getJtfNoKtpKoord().setText("");
        mw.getJtfInputNoRdkk().setText("");
        mw.getCbxKec().setSelectedIndex(0);
        mw.getCbxDesa().setSelectedItem(null);
    }
    
    public void konfirmasiSimpanData(){
        if (cc.getBufferArrayPetani().size() > 0){
            List<PetaniTebu> arrayPetani = cc.getBufferArrayPetani();
            List<Kecamatan> arrayKecamatan = kecDao.getAllKecamatan();
            String namaKoord = mw.getJtfInputRDKKNamaKoord().getText();
            String noKtp = mw.getJtfNoKtpKoord().getText();
            String noRdkk = mw.getJtfInputNoRdkk().getText();
            java.sql.Date tglRdkk = new java.sql.Date(new java.util.Date().getTime());
            int selectedKec = mw.getCbxKec().getSelectedIndex() - 1;
            int selectedDesa = mw.getCbxDesa().getSelectedIndex() - 1;
            String idKecamatan = arrayKecamatan.get(selectedKec).getIdKecamatan();
            List<Desa> arrayDesa = desaDao.getDesaByIdKecamatan(idKecamatan);
            int idDesa = arrayDesa.get(selectedDesa).getIdDesa();
            int tahunGiling = sistDao.getTahunGiling();
            int jmlPetani = arrayPetani.size();
            int afdeling = 20; // COBA
            float jmlLuas = 0.00f;
            for (PetaniTebu petani : arrayPetani){
                jmlLuas = jmlLuas + petani.getLuas();
            }
            if (JOptionPane.showConfirmDialog(null, "Anda akan mendaftarkan RDKK Kelompok " + namaKoord + " \n - Jumlah petani sebanyak " + 
                    String.valueOf(jmlPetani) + " petani \n - Total luas areal seluas " + 
                    String.valueOf(jmlLuas) + " Ha. \nApakah data tersebut benar?", "Konfirmasi Data", 
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                String idKelompok = cntDao.getNewIdKelompok(afdeling);
                KelompokTani kt = new KelompokTani(idKelompok, tahunGiling, namaKoord, "", 
                        String.valueOf(afdeling), idDesa, "N", noKtp, noRdkk, tglRdkk);
                keltanDao.insertKelompokTani(kt);
                for (PetaniTebu pt : arrayPetani){
                    pt.setIdKelompok(idKelompok);
                    pt.setIdPetani(cntDao.getNewIdPetani(idKelompok));
                    pt.setIdKelompok(idKelompok);
                    petaniDao.insertPetaniTebu(pt);
                }
                cc.getBufferArrayPetani().clear();
                clearInputPetani();
                clearInputKoordinator();
                mc.pageSwitcher(mw.getPnlFrmInputRDKK_ContainerInputPetani(), "crdInputPetani_Blank");
                mw.getJtfInputRDKKNamaKoord().requestFocus();
            }
        } else {
            cc.showErrorMsg("Error", "Anda belum menambahkan petani! \nSetiap kelompok minimal memiliki 1 petani!");
        }
    }
    
    public void refreshTableValidasiRDKK(){
        cc.setTableHeaderKelTani(mw.getTblValidasiRDKK().getTableHeader());
        cc.setTableRowRendererKelTani(mw.getTblValidasiRDKK());
        cc.setTableSelectionModel(mw.getTblValidasiRDKK());
        cc.setTableModelKelTani(mw.getTblValidasiRDKK());
        mw.getScrollPaneTblValidasi().getViewport().setBackground(new Color(170,193,193));
    }
    
    public void populateTablePetaniByIdKelompok(JTable tbl,String idKelompok){
        PetaniTableModel ptm = new PetaniTableModel(petaniDao.getAllPetaniTebuByIdKelompok(idKelompok));
        cc.prepareTableInputPetani(tbl);
        cc.setTableModelPetani(tbl, ptm);
        mw.getJScrollPaneTblValidasiRDKK_Petani().getViewport().setBackground(new Color(170,193,193));
    }
    
    public void cetakDraftRdkk(JTable tbl){
        if (tbl.getRowCount() > 1 && tbl.getSelectedRow() > -1){
            KelompokTaniTableModel kttm = (KelompokTaniTableModel) tbl.getModel();
            List<KelompokTani> lst = kttm.getContentList();
            int selectedRow = tbl.getSelectedRow();
            String idKelompok = lst.get(selectedRow).getIdKelompok();
            keltanDao.cetakRdkk(idKelompok);
        } else {
            cc.showErrorMsg("Cetak Draft", "Anda belum memilih kelompok");
        }
    }
    
}
