/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DBConnection;
import id.buma.simtr.model.KelompokTani;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class KelompokTaniDAOSQL implements KelompokTaniDAO {

    @Override
    public boolean insertKelompokTani(KelompokTani kt) {
        Connection conn = new DBConnection().getConn();
        try {
            /******
                1 = iD Kelompok
                2 = Nama Kelompok
                3 = No Kontrak
                4 = Kategori
                5 = ID Afd
                6 = Tahun
                7 = ID Desa
                8 = No KTP
                9 = No RDKK
                10 = Tanggal RDKK
            ******/
            String callSQL = "CALL INSERT_KELOMPOKTANIH(?,?,?,?,?,?,?,?,?,?)";
            try (CallableStatement cst = conn.prepareCall(callSQL)) {
                cst.setString(1, kt.getIdKelompok());
                cst.setString(2, kt.getNamaKelompok());
                cst.setString(3, kt.getNoKontrak());
                cst.setString(4, kt.getKategori());
                cst.setString(5, kt.getIdAfd());
                cst.setInt(6, kt.getTahun());
                cst.setInt(7, kt.getIdDesa());
                cst.setString(8, kt.getNoKtp());
                cst.setString(9, kt.getNoRdkk());
                cst.setDate(10, kt.getTglRdkk());
                cst.execute();
                if (cst.getUpdateCount() == 1){
                    return true;
                }
            } finally {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<KelompokTani> getKelompokTaniByTahun(int tahun, String idAfd) {
        Connection conn = new DBConnection().getConn();
        List<KelompokTani> lkt = new ArrayList<>();
        try {
            String callSQL = "CALL GET_KELOMPOKTANIH_BY_TAHUN(?,?)";
            CallableStatement cst = conn.prepareCall(callSQL,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cst.setInt(1, tahun);
            cst.setString(2, idAfd);
            lkt = commonGetDataKelompokTani(cst);
        } catch (SQLException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lkt;
    }
    
    @Override
    public List<KelompokTani> getAllKelompokTaniByMultipleField(String keyword, int tahun, String idAfd) {
        Connection conn = new DBConnection().getConn();
        List<KelompokTani> lkt = new ArrayList<>();
        try {
            String callSQL = "CALL GET_KELOMPOKTANIH_BY_MULTIFIELD_1(?,?,?)";
            CallableStatement cst = conn.prepareCall(callSQL,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cst.setString(1, keyword);
            cst.setInt(2, tahun);
            cst.setString(3, idAfd);
            lkt = commonGetDataKelompokTani(cst);
        } catch (SQLException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lkt;
    }
    
    public List<KelompokTani> commonGetDataKelompokTani(CallableStatement cst) throws SQLException{
        List<KelompokTani> lkt = new ArrayList<>();
        try {
            boolean result = cst.execute();
            ResultSet rs = null;
            while (result){
                if (result){
                    rs = cst.getResultSet();
                    break;
                }
                result = cst.getMoreResults();
            }
            while (rs.next()){
                KelompokTani kt = new KelompokTani(
                        rs.getString("IDKELOMPOK"), 
                        rs.getInt("TAHUN"),
                        rs.getString("NAMAKELOMPOK"), 
                        rs.getString("NOKONTRAK"),
                        rs.getString("KATEGORI"),
                        rs.getString("IDAFD"),
                        rs.getInt("ID_DESA"),
                        rs.getString("VERIFIKASI"),
                        rs.getString("NOKTP"),
                        rs.getString("NORDKK"),
                        rs.getDate("TGLRDKK")
                );
                lkt.add(kt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lkt;
    }

    @Override
    public void cetakRdkk(String idKelompok) {
        Connection conn = new DBConnection().getConn();
            try {
                String fileName = "./reports/draft_rdkk.jasper";
                Map map = new HashMap();
                map.put("IDKELOMPOK", idKelompok);
                JasperPrint jp = JasperFillManager.fillReport(fileName, map, conn);
                JasperViewer.viewReport(jp,false);
            } catch (JRException ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }

    @Override
    public JRViewer cetakSKK(String idKelompok) {
        JRViewer jrv = null;
        Connection con = new DBConnection().getConn();
        try {
            String fileName = "./reports/BA_SKK.jasper";
            Map map = new HashMap();
            map.put("IDKELOMPOK", idKelompok);
            JasperPrint jp = JasperFillManager.fillReport(fileName, map, con);
            jrv = new JRViewer(jp);
        } catch (JRException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jrv;
    }

    @Override
    public JRViewer cetakKontrak(String idKelompok) {
        JRViewer jrv = null;
        Connection conn = new DBConnection().getConn();
        try {
            String fileName = "./reports/KontrakTR.jasper";
            Map map = new HashMap();
            map.put("IDKELOMPOK", idKelompok);
            JasperPrint jp = JasperFillManager.fillReport(fileName, map, conn);
            jrv = new JRViewer(jp);
            /*
            JRPrintServiceExporter jex = new JRPrintServiceExporter();
            jex.setExporterInput(new SimpleExporterInput(jp));
            SimplePrintServiceExporterConfiguration config = new SimplePrintServiceExporterConfiguration();
            config.setDisplayPrintDialog(true);
            config.setDisplayPageDialog(true);
            jex.setConfiguration(config);
            jex.exportReport();
            */
        } catch (JRException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jrv;
    }

    @Override
    public JRViewer testCetakSKK(String idKelompok) {
        JRViewer jrv = null;
        Connection conn = new DBConnection().getConn();
        try {
            String fileName = "./reports/BA_SKK.jasper";
            Map map = new HashMap();
            map.put("IDKELOMPOK", idKelompok);
            JasperPrint jp = JasperFillManager.fillReport(fileName, map, conn);
            jrv = new JRViewer(jp);
        } catch (JRException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jrv;
    }

    @Override
    public JasperPrint testCetakLagi(String idKelompok) {
        JasperPrint jp = null;
        Connection conn = new DBConnection().getConn();
        try {
            String fileName = "./reports/BA_SKK.jasper";
            Map map = new HashMap();
            map.put("IDKELOMPOK", idKelompok);
            jp = JasperFillManager.fillReport(fileName, map, conn);
        } catch (JRException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jp;
    }

    @Override
    public JasperPrint cetakSKK_JP(String idKelompok) {
        Connection conn = new DBConnection().getConn();
        JasperPrint jp = null;
        try {
            String fileName = "./reports/BA_SKK.jasper";
            Map map = new HashMap();
            map.put("IDKELOMPOK", idKelompok);
            jp = JasperFillManager.fillReport(fileName, map, conn);
        } catch (JRException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jp;
    }

    @Override
    public JasperPrint cetakKontrak_JP(String idKelompok) {
        Connection conn = new DBConnection().getConn();
        JasperPrint jp = null;
        try {
            String fileName = "./reports/KontrakTR.jasper";
            Map map = new HashMap();
            map.put("IDKELOMPOK", idKelompok);
            jp = JasperFillManager.fillReport(fileName, map, conn);
        } catch (JRException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jp;
    }

    @Override
    public List<KelompokTani> getAllKelompokTaniByTahun(int tahun) {
        Connection conn = new DBConnection().getConn();
        List<KelompokTani> lkt = new ArrayList<>();
        try {
            String callSQL = "CALL GET_ALL_KELOMPOKTANIH_BY_TAHUN(?)";
            CallableStatement cst = conn.prepareCall(callSQL,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cst.setInt(1, tahun);
            lkt = commonGetDataKelompokTani(cst);
        } catch (SQLException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lkt;
    }

    @Override
    public KelompokTani getKelompokTaniByIdKelompok(String idKelompok) {
        Connection conn = new DBConnection().getConn();
        List<KelompokTani> lkt = new ArrayList<>();
        String callSQL = "CALL GET_KELOMPOKTANIH_BY_IDKELOMPOK(?)";
        try (CallableStatement cst = conn.prepareCall(callSQL)){
            cst.setString(1, idKelompok);
            lkt = commonGetDataKelompokTani(cst);
            if (lkt.size() == 1) return lkt.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
