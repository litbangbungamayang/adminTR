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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.print.PrinterJob;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.Attribute;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintServiceAttribute;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.PrinterState;
import javax.print.attribute.standard.PrinterStateReason;
import javax.print.event.PrintServiceAttributeEvent;
import javax.print.event.PrintServiceAttributeListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimplePrintServiceExporterConfiguration;
import net.sf.jasperreports.swing.JRViewer;

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
    
    public CommonController(){
        
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
        if (user.getPrivLevel() == 3){
            KelompokTaniTableModel kttm = new KelompokTaniTableModel(kelompokTaniDao.getKelompokTaniByTahun(sistemDao.getTahunGiling(),user.getIdAfd()));
            tbl.setModel(kttm);
        } else {
            if (user.getPrivLevel() == 1 || user.getPrivLevel() == 2){
                KelompokTaniTableModel kttm = new KelompokTaniTableModel(kelompokTaniDao.getAllKelompokTaniByTahun(sistemDao.getTahunGiling()));
                tbl.setModel(kttm);
            }
        }
    }
    
    public List<PetaniTebu> getInputPetani(){
        return inputPetani;
    }
    
    public void setInputPetani(List<PetaniTebu> lsPt){
        inputPetani = lsPt;
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

    public void disableButton(JPanel pnl){
        if (pnl.getMouseListeners().length == 1){
            pnl.setBackground(new Color(255,255,255,180));
            MouseListener ml = pnl.getMouseListeners()[0];
            pnl.removeMouseListener(ml);
        }
    }
    
    public void enableButton(JPanel pnl, MainWindow mw){
        if (pnl.getMouseListeners().length == 0){
            MenuController mc = new MenuController(mw);
            pnl.addMouseListener(mc);
        }
        pnl.setBackground(new Color(255,255,255,0));
    }
    
    public void kelTaniAutoFilter(JTable tbl, String keyword){
        String idAfd;
        if (CommonController.user.getPrivLevel() == 1 || CommonController.user.getPrivLevel() == 2){
            idAfd = "";
        } else {
            idAfd = CommonController.user.getIdAfd();
        }
        List<KelompokTani> lkt = kelompokTaniDao.getAllKelompokTaniByMultipleField(keyword, 
                sistemDao.getTahunGiling(), idAfd);
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
        JOptionPane.showMessageDialog(null, "<html><font face=\"Calibri\" size=\"4\">" + msg + "</html>", title, JOptionPane.ERROR_MESSAGE);
    }
    
    public void showInfoMsg(String title, String msg){
        JOptionPane.showMessageDialog(null, "<html><font face=\"Calibri\" size=\"4\">" + msg + "</html>", title, JOptionPane.INFORMATION_MESSAGE);
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
    
    public int getUserId(){
        if (user != null){
            return user.getUserId();
        }
        return 0;
    }
    
    public int getPrivLevel(){
        if (user != null){
            return user.getPrivLevel();
        }
        return 0;
    }
    
    public Timestamp getTimestamp(){
        return new java.sql.Timestamp(new java.util.Date().getTime());
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
    
    public void prepareFormCetak(JPanel pnlCetak){ //---BELUM KEPAKE
        if (jasperPrint != null){
            JRViewer jrv = new JRViewer(jasperPrint);
            pnlCetak.setLayout(new BorderLayout());
            pnlCetak.repaint();
            pnlCetak.removeAll();
            ((JPanel)jrv.getComponent(0)).remove(1);
            ((JPanel)jrv.getComponent(0)).remove(0);
            ((JPanel)jrv.getComponent(0)).remove(2);
            pnlCetak.add(jrv);
            pnlCetak.revalidate();
        }
    }
    
    public boolean startPrinting(){
        if (jasperPrint != null){
            /*
            PrintCompleteMonitor pcm = new PrintCompleteMonitor();
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            //DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
            PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            DocPrintJob printJob = service.createPrintJob();
            printJob.addPrintJobListener(pcm);
            File tempFile = File.createTempFile("tempPrint", ".pdf", new File("D:/"));
            showInfoMsg("Tes", tempFile.getPath());
            //JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(tempFile));
            byte[] source = JasperExportManager.exportReportToPdf(jasperPrint);
            JasperExportManager.exportReportToHtmlFile(jasperPrint, tempFile.getPath());
            ByteArrayInputStream bais = new ByteArrayInputStream(source);
            //Doc doc = new SimpleDoc(tempFile, flavor, null);
            InputStream is = new FileInputStream(tempFile.getPath());
            InputStream is2 = bais;
            //showErrorMsg("Test", is.toString());
            Doc doc = new SimpleDoc(is2, flavor, null);
            //Doc doc = new SimpleDoc(tempFile, flavor, null);
            printJob.print(doc, null);
            pcm.waitForComplete();
            is.close();
            tempFile.deleteOnExit();
            return true;
            */
            
            if (jasperPrint != null){
                try {
                    if (JasperPrintManager.printReport(jasperPrint, true)) return true;
                } catch (JRException ex) {
                    Logger.getLogger(CommonController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            showErrorMsg("Transaksi Pupuk", "Tidak ada data!");
        }
        return false;
    }
    
    public void testFlavor(){
        /*
        PrintService[] allServices = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService ps : allServices)
        {
            System.out.println(ps + " supports :");
            DocFlavor[] flavors = ps.getSupportedDocFlavors();
            for (int i = 0; i < flavors.length; i++)
            {
                System.out.println("\t" + flavors[i].getMediaSubtype());
                
            }
        }
        */
        PrintService ps2 = PrintServiceLookup.lookupDefaultPrintService();
        System.out.println(ps2 + " supports : ");
        DocFlavor[] flavors = ps2.getSupportedDocFlavors();
        flavors = ps2.getSupportedDocFlavors();
        for (int i = 0; i < flavors.length; i++){
            System.out.println("\t" + flavors[i].getMediaType() + ":" + 
                    flavors[i].getMimeType() + ":" + 
                    flavors[i].getRepresentationClassName());
        }
    }
    
    public boolean testPrint2(){
        if (jasperPrint != null){
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            PrintService selectedService = PrintServiceLookup.lookupDefaultPrintService();
            PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();
            JRPrintServiceExporter exporter = new JRPrintServiceExporter();
            SimplePrintServiceExporterConfiguration configuration = new SimplePrintServiceExporterConfiguration();
            configuration.setDisplayPageDialog(false);
            configuration.setDisplayPrintDialog(false);
            configuration.setPrintService(selectedService);
            configuration.setPrintServiceAttributeSet(printServiceAttributeSet);
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setConfiguration(configuration);
            selectedService.addPrintServiceAttributeListener(new PrintServiceAttributeListener() {
                @Override
                public void attributeUpdate(PrintServiceAttributeEvent psae) {
                    PrintServiceAttributeSet serviceAttributeSet  = psae.getAttributes();
                    StringBuilder s = new StringBuilder();
                    s.append("PrintServiveAttributEvent\n");
                    for (Attribute attribute : serviceAttributeSet.toArray()){
                        PrintServiceAttribute psa = (PrintServiceAttribute) attribute;
                        s.append(psa.getCategory().getName()).append("/").append(psa.getName()).append("=").append(psa.toString());
                    }
                    System.out.println(s.toString());
                }
            });
            try {
                AttributeSet attribute = selectedService.getAttributes();
                String printerState = attribute.get(PrinterState.class).toString();
                String printerStateReason = attribute.get(PrinterStateReason.class).toString();
                System.out.println("Printer State = " + printerState);
                System.out.println("Reason = " + printerStateReason);
                exporter.exportReport();
                
                return true;
            } catch (JRException ex) {
                Logger.getLogger(CommonController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public String formatAngka(long inputAngka, String formatAngka){
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat(formatAngka, dfs);
        return df.format(inputAngka);
    }
    
    public String formatAngkaUS(long inputAngka, String formatAngka){
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        dfs.setGroupingSeparator(',');
        DecimalFormat df = new DecimalFormat(formatAngka, dfs);
        return df.format(inputAngka);
    }
}
