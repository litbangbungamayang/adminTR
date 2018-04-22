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
import id.buma.simtr.dao.KoordinatDAOSQL;
import id.buma.simtr.dao.PetaniDAOSQL;
import id.buma.simtr.dao.SistemDAOSQL;
import id.buma.simtr.dao.VarietasTebuDAOSQL;
import id.buma.simtr.model.Desa;
import id.buma.simtr.model.IdNoKontrak;
import id.buma.simtr.model.Kecamatan;
import id.buma.simtr.model.KelompokTani;
import id.buma.simtr.model.Koordinat;
import id.buma.simtr.model.PetaniTebu;
import id.buma.simtr.model.VarietasTebu;
import id.buma.simtr.view.KelompokTaniTableModel;
import id.buma.simtr.view.MainWindow;
import id.buma.simtr.view.PetaniTableModel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.text.BadLocationException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimplePrintServiceExporterConfiguration;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.swing.JRViewerToolbar;
import net.sf.jasperreports.view.JasperViewer;

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
    
    private final KoordinatDAOSQL koordinatDao = new KoordinatDAOSQL();
    
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
        int selectedIndexCbxKec = mw.getCbxKec().getSelectedIndex() - 1;
        int selectedIndexCbxDesa = mw.getCbxDesa().getSelectedIndex() - 1;
        int selectedIndexCbxKatg = mw.getCbxKategoriTanaman().getSelectedIndex();
        if (noKtp.isEmpty() == false && namaKoord.isEmpty() == false && noKtp.isEmpty() == false
                && selectedIndexCbxDesa >= 0 && selectedIndexCbxKec >= 0 && selectedIndexCbxKatg >= 0){
            return true;
        } else {
            if (noKtp.isEmpty() == true) cc.showErrorMsg("Validasi", "Nomor KTP harus diisi!");
            if (namaKoord.isEmpty() == true) cc.showErrorMsg("Validasi", "Nama Koordinator harus diisi!");
            if (selectedIndexCbxKec < 0) cc.showErrorMsg("Validasi", "Kecamatan harus dipilih!");
            if (selectedIndexCbxDesa < 0) cc.showErrorMsg("Validasi", "Desa harus dipilih!");
            if (selectedIndexCbxKatg < 0) cc.showErrorMsg("Validasi", "Kategori tanaman harus diisi!");
        }
        return false;
    }
    
    public void statusIsianKoord(boolean status){
        mw.getJtfInputRDKKNamaKoord().setEnabled(status);
        mw.getJtfNoKtpKoord().setEnabled(status);
        mw.getCbxKategoriTanaman().setEnabled(status);
        mw.getCbxKec().setEnabled(status);
        mw.getCbxDesa().setEnabled(status);
        mw.getCbxInputRDKKMasaTanam().setEnabled(status);
        if (CommonController.user.getPrivLevel() == 3){
            mw.getCbxFrmInputRDKK_Afdeling().setEnabled(false);
        } else {
            mw.getCbxFrmInputRDKK_Afdeling().setEnabled(status);
        }
    }
    
    public boolean validasiInputPetani(){
        String namaPetani = mw.getJtfInputRDKKNamaPetani().getText();
        String luas = mw.getJftInputRDKKLuas().getText();
        String easting = mw.getJftEasting().getText();
        String northing = mw.getJftNorthing().getText();
        int selectedIndexMasaTanam = mw.getCbxInputRDKKMasaTanam().getSelectedIndex();
        int selecTedIndexVarietas = mw.getCbxInputRDKKVarietas().getSelectedIndex() - 1;
        if (!namaPetani.isEmpty() && !luas.isEmpty() && 
                selectedIndexMasaTanam >= 0 && selecTedIndexVarietas >=0 && 
                !easting.isEmpty() && !northing.isEmpty()){
            return true;
        } else {
            if (namaPetani.isEmpty()) cc.showErrorMsg("Validasi", "Nama petani harus diisi!");
            if (luas.isEmpty()) cc.showErrorMsg("Validasi", "Luas areal harus diisi!");
            if (selectedIndexMasaTanam < 0) cc.showErrorMsg("Validasi", "Masa tanam harus dipilih!");
            if (selecTedIndexVarietas < 0) cc.showErrorMsg("Validasi", "Varietas harus dipilih!");
            if (easting.isEmpty()) cc.showErrorMsg("Validasi", "Anda belum memasukkan koordinat!");
            if (northing.isEmpty()) cc.showErrorMsg("Validasi", "Anda belum memasukkan koordinat!");
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
    }
    
    public void insertBufferKoordinat(){
        String eastingStr = mw.getJftEasting().getText();
        float eastingF = Float.parseFloat(eastingStr);
        String northingStr = mw.getJftNorthing().getText();
        float northingF = Float.parseFloat(northingStr);
        String gridZone = "48M";
        Koordinat koord = new Koordinat("", eastingF, northingF, gridZone);
        cc.insertBufferKoordinat(koord);
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
        mw.getCbxInputRDKKVarietas().setSelectedIndex(-1);
        mw.getJftInputRDKKLuas().setValue(null);
        mw.getJftEasting().setValue(null);
        mw.getJftNorthing().setValue(null);
    }
    
    public void clearInputKoordinator(){
        mw.getJtfInputRDKKNamaKoord().setText("");
        try {
            mw.getJtfNoKtpKoord().getDocument().remove(0, mw.getJtfNoKtpKoord().getDocument().getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(RDKKController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mw.getCbxInputRDKKMasaTanam().setSelectedIndex(-1);
        mw.getCbxKategoriTanaman().setSelectedIndex(-1);
        mw.getCbxKec().setSelectedIndex(0);
        mw.getCbxDesa().setSelectedItem(null);
        if (CommonController.user.getPrivLevel() == 2 || CommonController.user.getPrivLevel() == 1){           
            mw.getCbxFrmInputRDKK_Afdeling().setEnabled(true);
            mw.getCbxFrmInputRDKK_Afdeling().setSelectedIndex(-1);
        } else {
            mw.getCbxFrmInputRDKK_Afdeling().setSelectedItem(CommonController.user.getIdAfd());
            mw.getCbxFrmInputRDKK_Afdeling().setEnabled(false);
        }
        statusIsianKoord(true);
    }
    
    public void konfirmasiSimpanData(){
        if (cc.getBufferArrayPetani().size() > 0){
            List<PetaniTebu> arrayPetani = cc.getBufferArrayPetani();
            List<Kecamatan> arrayKecamatan = kecDao.getAllKecamatan();
            List<Koordinat> arrayKoordinat = cc.getBufferKoordinat();
            String namaKoord = mw.getJtfInputRDKKNamaKoord().getText();
            String noKtp = mw.getJtfNoKtpKoord().getText();
            java.sql.Date tglRdkk = new java.sql.Date(new java.util.Date().getTime());
            int selectedKec = mw.getCbxKec().getSelectedIndex() - 1;
            int selectedDesa = mw.getCbxDesa().getSelectedIndex() - 1;
            int selectedKategori = mw.getCbxKategoriTanaman().getSelectedIndex() + 1;
            String selectedKategoriTxt = mw.getCbxKategoriTanaman().getSelectedItem().toString();
            String kategori = "";
            switch (selectedKategoriTxt){
                case "TRIT I":
                    kategori = "PC";
                    break;
                case "TRIT II":
                    kategori = "R1";
                    break;
                case "TRIT III":
                    kategori = "R2";
                    break;
                case "TRIT IV":
                    kategori = "R3";
                    break;
            }
            String idKecamatan = arrayKecamatan.get(selectedKec).getIdKecamatan();
            List<Desa> arrayDesa = desaDao.getDesaByIdKecamatan(idKecamatan);
            int idDesa = arrayDesa.get(selectedDesa).getIdDesa();
            int tahunGiling = sistDao.getTahunGiling();
            int jmlPetani = arrayPetani.size();
            String afd;
            if (CommonController.user.getPrivLevel() == 2 || CommonController.user.getPrivLevel() == 1){
                afd = mw.getCbxFrmInputRDKK_Afdeling().getSelectedItem().toString();
            } else {
                afd = CommonController.user.getIdAfd();
            }
            float jmlLuas = 0.00f;
            for (PetaniTebu petani : arrayPetani){
                jmlLuas = jmlLuas + petani.getLuas();
            }
            if (jmlLuas >= 5.00){
                if (JOptionPane.showConfirmDialog(null, "Anda akan mendaftarkan RDKK Kelompok " + namaKoord + " \n - Jumlah petani sebanyak " + 
                        String.valueOf(jmlPetani) + " petani \n - Total luas areal seluas " + 
                        String.valueOf(jmlLuas) + " Ha. \nApakah data tersebut benar?", "Konfirmasi Data", 
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    IdNoKontrak newIdNoKontrak = cntDao.getNewIdKelompok(Integer.valueOf(afd), selectedKategori);
                    String idKelompok = newIdNoKontrak.getIdKelompok();
                    String noKontrak = newIdNoKontrak.getNoKontrak();
                    KelompokTani kt = new KelompokTani(idKelompok, tahunGiling, namaKoord, noKontrak, kategori, 
                            afd, idDesa, "N", noKtp, "", tglRdkk);
                    keltanDao.insertKelompokTani(kt);
                    int index = 0;
                    for (PetaniTebu pt : arrayPetani){
                        pt.setIdKelompok(idKelompok);
                        pt.setIdPetani(cntDao.getNewIdPetani(idKelompok));
                        pt.setIdKelompok(idKelompok);
                        arrayKoordinat.get(index).setIdPetani(pt.getIdPetani());
                        koordinatDao.insertNewKoordinat(arrayKoordinat.get(index));
                        petaniDao.insertPetaniTebu(pt);
                        index++;
                    }
                    cc.getBufferArrayPetani().clear();
                    cc.getBufferKoordinat().clear();
                    clearInputPetani();
                    clearInputKoordinator();
                    mc.pageSwitcher(mw.getPnlFrmInputRDKK_ContainerInputPetani(), "crdInputPetani_Blank");
                    mw.getJtfInputRDKKNamaKoord().requestFocus();
                }
            } else {
                cc.showErrorMsg("Error", "Luas areal kelompok minimal 5.00 Ha! \nLuas areal yang Anda daftarkan hanya " + String.valueOf(jmlLuas) + " Ha.");
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
        HandlerSeleksiTabel hst = new HandlerSeleksiTabel(mw,"KelompokTani-Petani",mw.getTblValidasiRDKK());
        mw.getTblValidasiRDKK().getSelectionModel().addListSelectionListener(hst);
    }
    
    public void resetTablePetani(JTable tbl){
        List<PetaniTebu> lst = new ArrayList<>();
        PetaniTableModel ptm = new PetaniTableModel(lst);
        tbl.setModel(ptm);
    }
    
    public void populateTablePetaniByIdKelompok(JTable tbl,String idKelompok){
        PetaniTableModel ptm = new PetaniTableModel(petaniDao.getAllPetaniTebuByIdKelompok(idKelompok));
        cc.prepareTableInputPetani(tbl);
        cc.setTableModelPetani(tbl, ptm);
    }
    
    public void cetakDraftRdkk(JTable tbl){
        if (tbl.getRowCount() >= 1 && tbl.getSelectedRow() > -1){
            KelompokTaniTableModel kttm = (KelompokTaniTableModel) tbl.getModel();
            List<KelompokTani> lst = kttm.getContentList();
            int selectedRow = tbl.getSelectedRow();
            String idKelompok = lst.get(selectedRow).getIdKelompok();
            keltanDao.cetakRdkk(idKelompok);
        } else {
            if (tbl.getSelectedRow() == -1){
                cc.showErrorMsg("Cetak Draft", "Anda belum memilih kelompok");
            }
        }
    }
    
    public void cetakBaSKK(JTable tbl){
        if (tbl.getRowCount() >= 1 && tbl.getSelectedRow() > -1){
            KelompokTaniTableModel kttm = (KelompokTaniTableModel) tbl.getModel();
            List<KelompokTani> lstKelTani = kttm.getContentList();
            int selectedRow = tbl.getSelectedRow();
            String idKelompok = lstKelTani.get(selectedRow).getIdKelompok();
            cc.setLastPage("validasi_rdkk");
            JasperPrint jp = keltanDao.cetakSKK_JP(idKelompok);
            formCetakCustom(jp);
            cc.setJasperPrint(jp);
        } else {
            if (tbl.getSelectedRow() == -1) cc.showErrorMsg("Cetak BA SKK", "Anda belum memilih kelompok!");
        }
    }
    
    public void cetakKontrak(JTable tbl){
        if (tbl.getRowCount() >= 1 && tbl.getSelectedRow() > -1){
            KelompokTaniTableModel kttm = (KelompokTaniTableModel) tbl.getModel();
            List<KelompokTani> lstKel = kttm.getContentList();
            int selectedRow = tbl.getSelectedRow();
            String idKelompok = lstKel.get(selectedRow).getIdKelompok();
            cc.setLastPage("validasi_rdkk");
            JasperPrint jp = keltanDao.cetakKontrak_JP(idKelompok);
            formCetakCustom(jp);
            cc.setJasperPrint(jp);
        } else {
            if (tbl.getSelectedRow() == -1) cc.showErrorMsg("Cetak Kontrak TR", "Anda belum memilih kelompok!");
        }
    }
    
    public void formCetak(JRViewer jrv){
        mc.pageSwitcher(mw.getPnlContent(), "crdPnlCetak");
        JPanel pnlCetak = mw.getPnlCetak_Content();
        pnlCetak.setLayout(new BorderLayout());
        pnlCetak.repaint();
        pnlCetak.removeAll();
        ((JPanel)jrv.getComponent(0)).remove(1); //btnSave
        ((JPanel)jrv.getComponent(0)).remove(0);
        pnlCetak.add(jrv);
        pnlCetak.revalidate();
    }
    
    public void testFormCetak(JasperPrint jp){
        mc.pageSwitcher(mw.getPnlContent(), "crdPnlCetak");
        JPanel pnlCetak = mw.getPnlCetak_Content();
        pnlCetak.setLayout(new BorderLayout());
        pnlCetak.repaint();
        pnlCetak.removeAll();
        JasperViewer jv = new JasperViewer(jp);
        Container contentPane = jv.getContentPane();
        JRViewerToolbar toolbar = (JRViewerToolbar) ((JRViewer)((JPanel)contentPane.getComponents()[0]).getComponent(0)).getComponent(0);
        JButton btnPrint = (JButton) toolbar.getComponent(1);
        btnPrint.setVisible(false);
        toolbar.setVisible(true);
        pnlCetak.add(contentPane);
        pnlCetak.revalidate();
    }
    
    public void formCetakCustom(JasperPrint jp){
        JRViewer jrv = new JRViewer(jp);
        mc.pageSwitcher(mw.getPnlContent(), "crdPnlCetak");
        JPanel pnlCetak = mw.getPnlCetak_Content();
        pnlCetak.setLayout(new BorderLayout());
        pnlCetak.repaint();
        pnlCetak.removeAll();
        ((JPanel)jrv.getComponent(0)).remove(1);
        ((JPanel)jrv.getComponent(0)).remove(0);
        ((JPanel)jrv.getComponent(0)).remove(2);
        pnlCetak.add(jrv);
        pnlCetak.revalidate();        
    }
    
    public void preparePrint(){
        JasperPrint jp = cc.getJasperPrint();
        if (jp != null){
            try {
                JRPrintServiceExporter jex = new JRPrintServiceExporter();
                jex.setExporterInput(new SimpleExporterInput(jp));
                SimplePrintServiceExporterConfiguration config = new SimplePrintServiceExporterConfiguration();
                config.setDisplayPrintDialog(true);
                //config.setDisplayPageDialog(true);
                jex.setConfiguration(config);
                jex.exportReport();
                //cc.showErrorMsg("Tes", "1 = "+jex.getPrintStatus()[0].toString());
            } catch (JRException ex) {
                Logger.getLogger(RDKKController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
