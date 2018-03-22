/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.dao;

import id.buma.simtr.database.DbConnectionManager;
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
import javax.swing.JFrame;
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
        if (DbConnectionManager.isConnect() == true){
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
                String callSQL = "exec INSERT_KELOMPOKTANIH ?,?,?,?,?,?,?,?,?,?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSQL);
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
            } catch (Exception ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }      
        }
        return false;
    }

    @Override
    public List<KelompokTani> getAllKelompokTaniByTahun(int tahun, String idAfd) {
        List<KelompokTani> lkt = new ArrayList<>();
        if (DbConnectionManager.isConnect() == true){
            try {
                String callSQL = "exec GET_KELOMPOKTANIH_BY_TAHUN ?,?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSQL,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                cst.setInt(1, tahun);
                cst.setString(2, idAfd);
                lkt = commonGetDataKelompokTani(cst);
            } catch (Exception ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lkt;
    }
    
    @Override
    public List<KelompokTani> getAllKelompokTaniByMultipleField(String keyword, int tahun, String idAfd) {
        List<KelompokTani> lkt = new ArrayList<>();
        if (DbConnectionManager.isConnect() == true){
            try {
                String callSQL = "exec GET_KELOMPOKTANIH_BY_MULTIFIELD_1 ?,?,?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSQL,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                cst.setString(1, keyword);
                cst.setInt(2, tahun);
                cst.setString(3, idAfd);
                lkt = commonGetDataKelompokTani(cst);
            } catch (Exception ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lkt;
    }
    
    public List<KelompokTani> commonGetDataKelompokTani(CallableStatement callSQL){
        CallableStatement cst = callSQL;
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
            if (lkt.isEmpty()){
                KelompokTani ktKsg = new KelompokTani("", 0, "Data tidak tersedia",
                        "", "", "", 0, "", "","",null);
                lkt.add(ktKsg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lkt;
    }

    @Override
    public void cetakRdkk(String idKelompok) {
        if (DbConnectionManager.isConnect()){
            try {
                Connection con = DbConnectionManager.getConnection();
                String fileName = "./reports/draft_rdkk.jasper";
                Map map = new HashMap();
                map.put("IDKELOMPOK", idKelompok);
                JasperPrint jp = JasperFillManager.fillReport(fileName, map, con);
                JasperViewer.viewReport(jp,false);
            } catch (Exception ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public JRViewer cetakSKK(String idKelompok) {
        JRViewer jrv = null;
        if (DbConnectionManager.isConnect()){
            try {
                Connection con = DbConnectionManager.getConnection();
                String fileName = "./reports/BA_SKK.jasper";
                Map map = new HashMap();
                map.put("IDKELOMPOK", idKelompok);
                JasperPrint jp = JasperFillManager.fillReport(fileName, map, con);
                jrv = new JRViewer(jp);
            } catch (Exception ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jrv;
    }

    @Override
    public JRViewer cetakKontrak(String idKelompok) {
        JRViewer jrv = null;
        if (DbConnectionManager.isConnect()){
            try {
                Connection con = DbConnectionManager.getConnection();
                String fileName = "./reports/KontrakTR.jasper";
                Map map = new HashMap();
                map.put("IDKELOMPOK", idKelompok);
                JasperPrint jp = JasperFillManager.fillReport(fileName, map, con);
                jrv = new JRViewer(jp);
            } catch (Exception ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jrv;
    }

    @Override
    public JRViewer testCetakSKK(String idKelompok) {
        JRViewer jrv = null;
        if (DbConnectionManager.isConnect()){
            try {
                Connection con = DbConnectionManager.getConnection();
                String fileName = "./reports/BA_SKK.jasper";
                Map map = new HashMap();
                map.put("IDKELOMPOK", idKelompok);
                JasperPrint jp = JasperFillManager.fillReport(fileName, map, con);
                jrv = new JRViewer(jp);
            } catch (Exception ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jrv;
    }
    
}
