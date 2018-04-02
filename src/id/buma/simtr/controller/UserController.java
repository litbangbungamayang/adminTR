/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

import id.buma.simtr.dao.AfdelingDAOSQL;
import id.buma.simtr.dao.UserDAOSQL;
import id.buma.simtr.model.Afdeling;
import id.buma.simtr.model.User;
import id.buma.simtr.view.MainWindow;
import id.buma.simtr.view.UserDataRowRenderer;
import id.buma.simtr.view.UserDataTableModel;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class UserController {
    
    private MainWindow mw;    
    private final UserDAOSQL userDao = new UserDAOSQL();
    private final CommonController cc = new CommonController(mw);
    private final AfdelingDAOSQL afdDao = new AfdelingDAOSQL();
    private static String menuStatus = "";
    
    public UserController(MainWindow mw){
        this.mw = mw;
    }
    
    public void insertNewUser(){
        User newUser = new User(0, "byshn910???", "bayu", 1, "Bayu Muhardika","19");
        userDao.addNewUser(newUser);
    }
    
    public void resetTable(){
        mw.getTblUserData().getSelectionModel().clearSelection();
    }
    
    public void setStatusForm(boolean statusForm){
        mw.getJtfFrmUserData_NamaLengkap().setEnabled(statusForm);
        mw.getJtfFrmUserData_Username().setEnabled(statusForm);
        mw.getJtfFrmUserData_Password().setEnabled(statusForm);
        mw.getCbxFrmUserData_Level().setEnabled(statusForm);
        mw.getCbxFrmUserData_Afdeling().setEnabled(statusForm);
        mw.getPnlAdminSistem_Save().setEnabled(statusForm);
        mw.getPnlAdminSistem_Cancel().setEnabled(statusForm);
        if (!statusForm){
            mw.getCbxFrmUserData_Level().setSelectedIndex(-1);
            mw.getCbxFrmUserData_Afdeling().setSelectedIndex(-1);
            mw.getJtfFrmUserData_NamaLengkap().setText("");
            mw.getJtfFrmUserData_Password().setText("");
            mw.getJtfFrmUserData_Username().setText("");
            disablePanelButton(mw.getPnlAdminSistem_Save());
            disablePanelButton(mw.getPnlAdminSistem_Cancel());
        }
    }
    
    public void setMenuButton(String inputStatusMenu){
        switch(inputStatusMenu){
            case "edit":
                mw.getTblUserData().clearSelection();
                mw.getTblUserData().setEnabled(false);
                disablePanelButton(mw.getPnlAdminSistem_AddUser());
                disablePanelButton(mw.getPnlAdminSistem_DeleteUser());
                disablePanelButton(mw.getPnlAdminSistem_EditUser());
                enablePanelButton(mw.getPnlAdminSistem_Save());
                enablePanelButton(mw.getPnlAdminSistem_Cancel());
                mw.getJtfFrmUserData_Username().setText("");
                mw.getJtfFrmUserData_Password().setText("");
                setStatusForm(true);
                menuStatus = "edit";
                break;
            case "cancel":
                enablePanelButton(mw.getPnlAdminSistem_AddUser());
                enablePanelButton(mw.getPnlAdminSistem_DeleteUser());
                enablePanelButton(mw.getPnlAdminSistem_EditUser());
                disablePanelButton(mw.getPnlAdminSistem_Cancel());
                disablePanelButton(mw.getPnlAdminSistem_Save());
                mw.getTblUserData().setEnabled(true);
                prepareTableUser(mw.getTblUserData());
                setStatusForm(false);
                menuStatus = "";
                break;
            case "delete":
                UserDataTableModel udtm = (UserDataTableModel) mw.getTblUserData().getModel();
                List<User> lstUser = udtm.getContentList();
                User usr = lstUser.get(mw.getTblUserData().getSelectedRow());
                if (usr.getUserId() == CommonController.user.getUserId()){
                    cc.showErrorMsg("Manajemen Pengguna", "Tidak dapat menghapus data pengguna! \nAnda sedang login menggunakan id ini.");
                } else {
                    if (JOptionPane.showConfirmDialog(null, "Anda akan menghapus akun pengguna " + usr.getNamaLengkap(), "Konfirmasi Hapus Akun Pengguna", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                        if (userDao.deleteUserData(usr)) cc.showInfoMsg("Manajemen Pengguna", "Akun telah berhasil dihapus!");
                        prepareTableUser(mw.getTblUserData());
                    }
                }
                break;
            case "add":
                setStatusForm(true);
                mw.getJtfFrmUserData_NamaLengkap().setText("");
                mw.getJtfFrmUserData_Password().setText("");
                mw.getJtfFrmUserData_Username().setText("");
                mw.getCbxFrmUserData_Afdeling().setSelectedIndex(-1);
                mw.getCbxFrmUserData_Level().setSelectedIndex(-1);
                prepareTableUser(mw.getTblUserData());
                mw.getTblUserData().setEnabled(false);
                disablePanelButton(mw.getPnlAdminSistem_AddUser());
                disablePanelButton(mw.getPnlAdminSistem_DeleteUser());
                disablePanelButton(mw.getPnlAdminSistem_EditUser());
                enablePanelButton(mw.getPnlAdminSistem_Save());
                enablePanelButton(mw.getPnlAdminSistem_Cancel());               
                menuStatus = "add";
                mw.getJtfFrmUserData_NamaLengkap().requestFocus();
                break;
        }
    }
    
    public void saveUpdateData(){
        if (menuStatus.equals("edit")){
            if (cekInputUserData()){
                UserDataTableModel udtm = (UserDataTableModel) mw.getTblUserData().getModel();
                List<User> lstUser = udtm.getContentList();
                User usr = lstUser.get(mw.getTblUserData().getSelectedRow());
                usr.setNamaLengkap(mw.getJtfFrmUserData_NamaLengkap().getText());
                usr.setUsername(mw.getJtfFrmUserData_Username().getText());
                usr.setPassword(mw.getJtfFrmUserData_Password().getText());
                usr.setPrivLevel(mw.getCbxFrmUserData_Level().getSelectedIndex() + 1);
                usr.setIdAfd(mw.getCbxFrmUserData_Afdeling().getSelectedItem().toString());
                if (userDao.updateUserData(usr)){
                    if (usr.getUserId() == CommonController.user.getUserId()){
                        CommonController.user = usr;
                        mw.getLblLoginDesc().setText("Selamat datang, ");
                        mw.getLblUsername().setText(usr.getNamaLengkap());
                    }
                    prepareTableUser(mw.getTblUserData());
                    menuStatus = "";
                    setMenuButton("cancel");
                    cc.showInfoMsg("Manajemen Pengguna", "Data pengguna berhasil diubah.");
                }
            }
        } else {
            if (menuStatus.equals("add")){
                if (cekInputUserData()){
                    User usr = new User(
                            0, 
                            mw.getJtfFrmUserData_Password().getText(), 
                            mw.getJtfFrmUserData_Username().getText(), 
                            mw.getCbxFrmUserData_Level().getSelectedIndex() + 1, 
                            mw.getJtfFrmUserData_NamaLengkap().getText(), 
                            mw.getCbxFrmUserData_Afdeling().getSelectedItem().toString()
                    );
                    if (userDao.addNewUser(usr)){
                        cc.showInfoMsg("Manajemen Pengguna", "Data pengguna berhasil ditambahkan!");
                        menuStatus = "";
                        setMenuButton("cancel");
                    }
                }
            }
        }
    }
    
    
    public boolean cekInputUserData(){
        return !mw.getJtfFrmUserData_NamaLengkap().getText().isEmpty() &&
                !mw.getJtfFrmUserData_Username().getText().isEmpty() &&
                !mw.getJtfFrmUserData_Password().getText().isEmpty() &&
                mw.getCbxFrmUserData_Afdeling().getSelectedIndex() > -1 &&
                mw.getCbxFrmUserData_Level().getSelectedIndex() > -1;
    }
    
    public void disablePanelButton(JPanel pnl){
        if (pnl.getMouseListeners().length == 1){
            MouseListener ml = pnl.getMouseListeners()[0];
            pnl.removeMouseListener(ml);
        }
    }
    
    public void enablePanelButton(JPanel pnl){
        MenuController mc = new MenuController(mw);
        pnl.addMouseListener(mc);
    }
    
    public void prepareTableUser(JTable tbl){
        UserDataRowRenderer udrr = new UserDataRowRenderer();
        cc.setTableHeaderKelTani(tbl.getTableHeader());
        mw.getTblUserData().setDefaultRenderer(Object.class, udrr);
        cc.setTableSelectionModel(tbl);
        UserDataTableModel udtm = new UserDataTableModel(userDao.getAllUser());
        mw.getTblUserData().setModel(udtm);
        HandlerSeleksiTabel hst = new HandlerSeleksiTabel(mw, "UserData-FormUserData", tbl);
        mw.getTblUserData().getSelectionModel().addListSelectionListener(hst);
    }
    
    public void getUserDetail(User userData){
        if (userData != null){
            mw.getJtfFrmUserData_NamaLengkap().setText(userData.getNamaLengkap());
            mw.getJtfFrmUserData_Username().setText(userData.getUsername());
            mw.getJtfFrmUserData_Password().setText(userData.getPassword());
            mw.getCbxFrmUserData_Level().setSelectedIndex(userData.getPrivLevel()-1);
        }
    }
    
    public List<String> namaAfdelingList(){
        List<Afdeling> lstAfd = afdDao.getAllAfdeling();
        List<String> lsAfd = new ArrayList<>();
        lstAfd.forEach((satUser)->{
            lsAfd.add(satUser.getIdAfd());
        });
        return lsAfd;
    }
    
}
