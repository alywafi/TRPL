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
import view.popup_inputpinjaman;
import view.popup_verifikasi;
import view.viewHomeKetuaUmum;
import view.viewPeminjamanInventaris;

/**
 *
 * @author acer
 */
public class CInventaris {

    viewPeminjamanInventaris view;
    MInventaris model;
    popup_inputpinjaman popup;
    popup_verifikasi popupver;
    String jabatan;
    String username;

    public CInventaris(viewPeminjamanInventaris view, MInventaris model, popup_inputpinjaman popup, popup_verifikasi popupver, String Username) throws SQLException {
        this.view = view;
        this.model = model;
        this.popup = popup;
        this.popupver = popupver;
        this.username = Username;
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.klikpinjam(new pinjambarang());
        view.klikdaftar(new daftarpinjamanaction());
        popup.simpan(new simpanAction());
        popupver.simpan(new simpanVerAction());
        if (model.getJabatan(Username).equals("4")) {
            view.setvisibleverifikasi(false);
            view.setvisiblPeminjaman(true);
            view.setTableModel(model.getDatainventaris());
        } else {
            view.setTableModel(model.getDataDaftarPeminjaman());
            view.setvisibleverifikasi(true);
            view.setvisiblPeminjaman(false);
        }
        view.KlikBack(new BackAction());
        view.SetName(Username);
        popup.setVisible(false);
        view.setVisible(true);
        view.klikVerifikasi(new VerifikasiAction());
    }

    private class simpanVerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (model.updateVerifikasi(view.GetIDTable(), popupver.getComboBox()) == true) {
                view.message("verivikaasi sukses");
                popupver.dispose();
            } else {
                view.message("Verivikasi gagal");
            }
            try {
                view.setTableModel(model.getDataDaftarPeminjaman());
            } catch (SQLException ex) {
                Logger.getLogger(CInventaris.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class VerifikasiAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            popupver.setVisible(true);
            popupver.SetJCombo(view.GetStatusTable());
            popupver.setId(view.GetIDTable());
        }
    }

    private class simpanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            try {
                System.out.println((model.getidwithusername(view.Getname())));
                if (model.setDataPeminjaman(popup.getdata()) == true) {
                    view.message("data berhasil di inputkan");
                } else {
                    view.message("data gagal di inputkan");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CInventaris.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class daftarpinjamanaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            try {
                if (view.getButtonText().equals("daftar pinjaman")) {
                    view.setButtonText("List Inventaris");
                    view.setenablebtnpinjam(false);
                    view.setTableModel(model.getDataDaftarPeminjaman(model.getidwithusername(view.Getname())));

                } else {
                    view.setButtonText("daftar pinjaman");
                    view.setenablebtnpinjam(true);
                    view.setTableModel(model.getDatainventaris());
                }
            } catch (SQLException ex) {
                Logger.getLogger(CInventaris.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class BackAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            view.dispose();
            try {
                if (model.getJabatan(view.Getname()).equals("4")) {
                    controler.CHomeUser d = new controler.CHomeUser(new view.viewHomeUser(), view.Getname());
                } else {
                    controler.CHomeKetuaUmum d = new controler.CHomeKetuaUmum(new viewHomeKetuaUmum(), view.Getname());
                }
            } catch (SQLException ex) {
                Logger.getLogger(CInventaris.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class pinjambarang implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String a[] = new String[2];
            if (view.getSelectedRow() == -1) {
                view.message("Pilih Dulu Gan");
            } else {
                try {
                    popup.setdata(model.getDataWithID(view.GetIDTable()));
                    popup.setidpeminjam(model.getidwithusername(view.Getname()));
                    popup.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CInventaris.class.getName()).log(Level.SEVERE, null, ex);
                }

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
