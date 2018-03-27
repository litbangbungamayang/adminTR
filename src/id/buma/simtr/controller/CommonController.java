/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.dao.KelompokTaniDAO;
import id.buma.simtr.dao.KelompokTaniDAOSQL;
import id.buma.simtr.dao.SistemDAOSQL;
import id.buma.simtr.dao.UserDAO;
import id.buma.simtr.dao.UserDAOSQL;
import id.buma.simtr.model.KelompokTani;
import id.buma.simtr.model.Koordinat;
import id.buma.simtr.model.PetaniTebu;
import id.buma.simtr.model.User;
import id.buma.simtr.view.BahanProduksi_PupukRowRenderer;
import id.buma.simtr.view.BahanProduksi_PupukTableModel;
import id.buma.simtr.view.KelompokTaniHeaderRenderer;
import id.buma.simtr.view.KelompokTaniRowRenderer;
import id.buma.simtr.view.KelompokTaniSelectionModel;
import id.buma.simtr.view.KelompokTaniTableModel;
import id.buma.simtr.view.MainWindow;
import id.buma.simtr.view.PetaniHeaderRenderer;
import id.buma.simtr.view.PetaniRowRenderer;
import id.buma.simtr.view.PetaniTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class CommonController {
    
    private MainWindow mw;
    
    private final KelompokTaniHeaderRenderer kelTaniHR = new KelompokTaniHeaderRenderer();
    
    private final KelompokTaniRowRenderer kelTaniRR = new KelompokTaniRowRenderer();
    
    private final KelompokTaniDAO kelompokTaniDao = new KelompokTaniDAOSQL();
    
    private final UserDAO userDao = new UserDAOSQL();
    
    private final KelompokTaniSelectionModel ktsm = new KelompokTaniSelectionModel();
    
    private final PetaniHeaderRenderer petaniHR = new PetaniHeaderRenderer();
    
    private final PetaniRowRenderer petaniRR = new PetaniRowRenderer();
    
    private final BahanProduksi_PupukRowRenderer pupukRR = new BahanProduksi_PupukRowRenderer();
    
    public static List<PetaniTebu> inputPetani = new ArrayList<>();
    
    public static List<Koordinat> inputKoordinat = new ArrayList<>();
    
    public static SistemDAOSQL sistemDao = new SistemDAOSQL();
    
    public static String lastPage = null;
    
    private final LoginEncryption le = new LoginEncryption();
    
    public static User user = null;
    
    public static JasperPrint jasperPrint = null;
    
    
    
    public CommonController(MainWindow mw){
        this.mw = mw;
    }
    
    //*************************************************************************//
    //************************ SETTING TABLE **********************************//
    
    public void setTableHeaderKelTani(JTableHeader th){
        th.setDefaultRenderer(kelTaniHR);
    }
    
    public void setTableRowRendererKelTani(JTable tbl){
        tbl.setDefaultRenderer(Object.class, kelTaniRR);
    }
    
    public void setTableModelKelTani(JTable tbl){
        KelompokTaniTableModel kttm = new KelompokTaniTableModel(kelompokTaniDao.getAllKelompokTaniByTahun(2018,user.getIdAfd()));
        tbl.setModel(kttm);
    }
    
    public void setTableSelectionModel(JTable tbl){
        tbl.setSelectionModel(ktsm);
    }
    
    public void setTableHeaderPetani(JTableHeader th){
        th.setDefaultRenderer(petaniHR);
    }
    
    public void setTableRowRendererPetani(JTable tbl){
        tbl.setDefaultRenderer(Object.class, petaniRR);
    }
    
    public void setTableRowRendererJenisPupuk(JTable tbl){
        tbl.setDefaultRenderer(Object.class, pupukRR);
    }
    
    public void setTableModelPetani(JTable tbl, PetaniTableModel ptm){
        tbl.setModel(ptm);
    }
    
    public void setTableModelPupuk(JTable tbl, BahanProduksi_PupukTableModel bpptm){
        tbl.setModel(bpptm);
    }
        
    public void insertBufferPetani(PetaniTebu pt){
        inputPetani.add(pt);
    }
    
    public void insertBufferKoordinat(Koordinat kd){
        inputKoordinat.add(kd);
    }
    
    public int getSizeArrayPetani(){
        return inputPetani.size();
    }
    
    public int getSizeArrayKoordinat(){
        return inputKoordinat.size();
    }
    
    public void hapusElemenArrayPetani(int index){
        inputPetani.remove(index);
    }
    
    public void hapusElementArrayKoordinat(int index){
        inputKoordinat.remove(index);
    }
    
    public void refreshBufferTablePetani(JTable tbl){
        PetaniTableModel ptm = new PetaniTableModel(inputPetani);
        tbl.setModel(ptm);
    }
    
    //*************************************************************************//
    
    public void kelTaniAutoFilter(JTable tbl, String keyword){
        List<KelompokTani> lkt = kelompokTaniDao.getAllKelompokTaniByMultipleField(keyword, 
                sistemDao.getTahunGiling(), user.getIdAfd());
        KelompokTaniTableModel kttm = new KelompokTaniTableModel(lkt);
        tbl.setModel(kttm);
    }
    
    public void populateComboBox(JComboBox cbx, List<String> content){
        List<String> contentList = new ArrayList<>();
        contentList.add("");
        content.forEach((contentElement) -> {
            contentList.add(contentElement);
        });
        cbx.setModel(new DefaultComboBoxModel(contentList.toArray()));
    }
    
    public void showErrorMsg(String title,String msg){
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
    }
    
    public void showInfoMsg(String title, String msg){
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void prepareTableInputPetani(JTable tabel){
        setTableHeaderPetani(tabel.getTableHeader());
        setTableRowRendererPetani(tabel);
        setTableSelectionModel(tabel);
        refreshBufferTablePetani(tabel);
    }
    
    public List<PetaniTebu> getBufferArrayPetani(){
        return inputPetani;
    }
    
    public List<Koordinat> getBufferKoordinat(){
        return inputKoordinat;
    }
    
    public boolean cekLogin(){
        if (!mw.getJtfLoginUsername().getText().isEmpty() && mw.getJtpLoginPassword().getPassword().length > 0){
            String hashedUsername = le.hashingText(mw.getJtfLoginUsername().getText());
            String passStr = new String(mw.getJtpLoginPassword().getPassword());
            String hashedPassword = le.hashingText(passStr);
            user = userDao.getUserData(hashedUsername, hashedPassword);
            if (user != null){
                mw.getLblLoginDesc().setText("Selamat datang, ");
                mw.getLblUsername().setText(user.getNamaLengkap());
                return true;
            }
        } else {
            if (mw.getJtfLoginUsername().getText().isEmpty()) showErrorMsg("Error", "Username belum terisi!");
            if (mw.getJtpLoginPassword().getPassword().length == 0) showErrorMsg("Error", "Password belum terisi!");
        }
        mw.getJtfLoginUsername().setText(null);
        mw.getJtpLoginPassword().setText(null);
        mw.getJtfLoginUsername().requestFocus();
        showErrorMsg("Error", "Username atau password yang Anda masukkan salah!");
        return false;
    }
    
    public String getLastPage(){
        return lastPage;
    }
    
    public void setLastPage(String lastPage){
        CommonController.lastPage = lastPage;
    }
    
    public JasperPrint getJasperPrint(){
        return jasperPrint;
    }
    
    public void setJasperPrint(JasperPrint jp){
        CommonController.jasperPrint = jp;
    }
}
