/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MInventaris;
import model.Muser;
import view.popup_inputpinjaman;
import view.popup_manageuser;
import view.popup_verifikasi;
import view.viewInventaris;
import view.viewmanageuser;

/**
 *
 * @author acer
 */
public class Cmanageuser {

    viewmanageuser view;
    Muser model;
    popup_manageuser popup;
    String jabatan;
    String username;

    public Cmanageuser(viewmanageuser view, Muser model, popup_manageuser popup,String Username) throws SQLException {
        this.view = view;
        this.model = model;
        this.popup = popup;
        this.username = Username;
        view.setTableModel(model.getdatapengguna());
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.kliktambah(new kliktambah());
        view.klikubah(new klikupdate());
        popup.simpan(new simpanVerAction());
        view.KlikBack(new BackAction());
        view.SetName(Username);
        popup.setVisible(false);
        view.setVisible(true);
    }

    private class simpanVerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (popup.getButtonText().equalsIgnoreCase("simpan")) {
                    if (model.insertdatauserbaru(popup.getdata())==true) {
                        popup.message("berhasil input user baru");
                    }
                    else {
                        popup.message("gagal input user baru");
                    }
                }
                else{
                        if (model.updatedatauser(popup.getdata())==true) {
                            popup.message("data berhasil di update");
                        }else{
                            popup.message("data gagal di update");
                    } 
                }
                view.setTableModel(model.getdatapengguna());
            } catch (SQLException ex) {
                Logger.getLogger(Cmanageuser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    private class kliktambah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            popup.setButtonText("simpan");
            popup.setVisible(true);
        }
    }


    private class BackAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            try {
                System.out.println("username" + username);
                if (model.getJabatan(username).equalsIgnoreCase("4")) {
                    controler.CHomeUser d = new controler.CHomeUser(new view.viewHomeUser(), username);
                }
                if (model.getJabatan(username).equalsIgnoreCase("1")) {
                    controler.CHomeAdmin e = new controler.CHomeAdmin(new view.viewHomeAdmin(), username);
                }
                if (model.getJabatan(username).equalsIgnoreCase("2")) {
                    controler.CHomeKetuaUmum f = new controler.CHomeKetuaUmum(new view.viewHomeKetuaUmum(), username);
                }
                if (model.getJabatan(username).equalsIgnoreCase("3")) {
                    controler.CHomeKetuaSub g = new controler.CHomeKetuaSub(new view.viewHomeKetuaSub(), username);
                }
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Cforum.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class klikupdate implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getSelectedRow() == -1) {
                view.message("silahkan pilih user terlebih dahulu");
            } else {
                    popup.setdata(view.getdata());
                    popup.setVisible(true);
               popup.setButtonText("update");
            }
        }
    }

    private class exitaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

    private class minimizeaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setState(Frame.ICONIFIED);
        }

    }
}
