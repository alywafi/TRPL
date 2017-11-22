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
import javax.swing.text.StyleConstants;
import model.MInventaris;
import view.popup_inputpinjaman;
import view.popup_verifikasi;
import view.viewHomeKetuaUmum;
import view.viewInventaris;

/**
 *
 * @author acer
 */
public class CInventaris {

    viewInventaris view;
    MInventaris model;
    popup_inputpinjaman popup;
    popup_verifikasi popupver;
    String jabatan;
    String username;

    public CInventaris(viewInventaris view, MInventaris model, popup_inputpinjaman popup, popup_verifikasi popupver, String Username) throws SQLException {
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
        view.klikverifi(new klikverifipeminjaman());
        view.klikVerifikasipengembalian(new verifikasipengembalian());
        view.klikselesai(new selesai());
        popupver.simpan(new simpanVerAction());
        if (model.getJabatan(Username).equalsIgnoreCase("4")) {
            view.setvisibleverifikasi(false);
            view.setvisiblPeminjaman(true);
            view.setTableModel(model.getDatainventaris());
        } else {
            view.setTableModel(model.getDataDaftarPeminjamantotal());
            view.setvisibleverifikasi(true);
            view.setvisiblPeminjaman(false);
        }
        view.KlikBack(new BackAction());
        view.SetName(Username);
        popup.setVisible(false);
        view.setVisible(true);
        view.klikVerifikasipeminjaman(new verifikasipeminjaman());
    }

    private class simpanVerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (popupver.getstatus().equalsIgnoreCase("verifikasi peminjaman")) {
                    String jumlahbarang = "-" + popupver.getjumlahbarangpinjam();
                    System.out.println("jumlah yg di pinjam = " + jumlahbarang);
                    if (model.updateVerifikasi(view.GetIDTable(), popupver.getComboBox(), jumlahbarang, view.GetNamaBarang()) == true) {
                        view.message("verivikaasi sukses");
                        popupver.dispose();
                    } else {
                        view.message("Verivikasi gagal");
                    }
                    System.out.println("jalannnnn");
                    view.setvisibleverifikasi(true);
                    popupver.dispose();
                    view.setTableModel(model.getDataDaftarPeminjamantotal());
                } else {
                    String jumlahbarang = "+" + popupver.getjumlahbarangpinjam();
                    System.out.println("jumlah yg di pinjam = " + jumlahbarang);
                    if (model.updateVerifikasi(view.GetIDTable(), popupver.getComboBox(), jumlahbarang, view.GetNamaBarang()) == true) {
                        view.message("verivikaasi sukses");
                        popupver.dispose();
                    } else {
                        view.message("Verivikasi gagal");
                    }
                    System.out.println("jalannnnn");
                    view.setvisibleverifikasi(true);
                    popupver.dispose();
                    view.setTableModel(model.getDataDaftarPeminjamantotal());

                }

            } catch (SQLException ex) {
                Logger.getLogger(CInventaris.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

        private class verifikasipeminjaman implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    popupver.setstatus("verifikasi peminjaman");
                    view.setenablepeminjaman(false);
                    view.setenablepengembalian(true);
                    view.setvisibleverifi(true);
                    view.setenableselesi(true);
                    view.setTableModel(model.getDataDaftarPeminjamanbelumterverifikasi());
                } catch (SQLException ex) {
                    Logger.getLogger(CInventaris.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        private class verifikasipengembalian implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    popupver.setstatus("verifikasi pengembalian");
                    view.setenablepengembalian(false);
                    view.setenablepeminjaman(true);
                    view.setvisibleverifi(true);
                    view.setenableselesi(true);
                    view.setTableModel(model.getDataDaftarPeminjamanterverifikasi());
                } catch (SQLException ex) {
                    Logger.getLogger(CInventaris.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        private class klikverifipeminjaman implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                popupver.setVisible(true);
                System.out.println("wkwkwkwk" + view.GetIDTable());
                popupver.SetJCombo("gagal diverifikasi");
                popupver.setdata(view.getdata());

            }
        }

        private class selesai implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    view.setenablepengembalian(true);
                    view.setenablepeminjaman(true);
                    view.setenableselesi(false);
                    view.setvisibleverifi(false);
                    view.setTableModel(model.getDataDaftarPeminjamanselesai());
                } catch (SQLException ex) {
                    Logger.getLogger(CInventaris.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        private class simpanAction implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent a) {
                try {
                    System.out.println((model.getidwithusername(view.Getname())));
                    if (model.setDataPeminjaman(popup.getdata())) {
                        view.message("data berhasil di inputkan");
                        popup.dispose();
                    } else {
                        view.message("data gagal di inputkan \n mohon periksa kembali inputan anda");
                    }
                    view.setvisibleverifikasi(true);
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

        private class pinjambarang implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String a[] = new String[2];
                if (view.getSelectedRow() == -1) {
                    view.message("silahkan pilih barang terlebih dahulu");
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
