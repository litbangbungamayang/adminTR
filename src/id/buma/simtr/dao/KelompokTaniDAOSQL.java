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
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
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
                    3 = ID Afd
                    4 = Tahun
                    5 = ID Desa
                    6 = No KTP
                    7 = No RDKK
                    8 = Tanggal RDKK
                ******/
                String callSQL = "exec INSERT_KELOMPOKTANIH ?,?,?,?,?,?,?,?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSQL);
                cst.setString(1, kt.getIdKelompok());
                cst.setString(2, kt.getNamaKelompok());
                cst.setString(3, kt.getIdAfd());
                cst.setInt(4, kt.getTahun());
                cst.setInt(5, kt.getIdDesa());
                cst.setString(6, kt.getNoKtp());
                cst.setString(7, kt.getNoRdkk());
                cst.setDate(8, kt.getTglRdkk());
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
    public List<KelompokTani> getAllKelompokTaniByTahun(int tahun) {
        List<KelompokTani> lkt = new ArrayList<>();
        if (DbConnectionManager.isConnect() == true){
            try {
                String callSQL = "exec GET_KELOMPOKTANIH_BY_TAHUN ?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSQL,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                cst.setInt(1, tahun);
                lkt = commonGetDataKelompokTani(cst);
            } catch (Exception ex) {
                Logger.getLogger(KelompokTaniDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lkt;
    }
    
    @Override
    public List<KelompokTani> getAllKelompokTaniByMultipleField(String keyword, int tahun) {
        List<KelompokTani> lkt = new ArrayList<>();
        if (DbConnectionManager.isConnect() == true){
            try {
                String callSQL = "exec GET_KELOMPOKTANIH_BY_MULTIFIELD_1 ?,?";
                CallableStatement cst = DbConnectionManager.getConnection().prepareCall(callSQL,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                cst.setString(1, keyword);
                cst.setInt(2, tahun);
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
                        "", "", 0, "", "","",null);
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
    
}
