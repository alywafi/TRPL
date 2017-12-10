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
//    String jabatan;
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
        tampiltombol();
        view.KlikBack(new BackAction());
        view.SetName(Username);
        popup.setVisible(false);
        view.setVisible(true);
        view.klikVerifikasipeminjaman(new verifikasipeminjaman());
    }

    public void tampiltombol() throws SQLException {
        String jabatan = model.getJabatan(username);
        if (jabatan.equalsIgnoreCase("2")) {
            view.setTableModel(model.getDataDaftarPeminjamantotal());
            view.setvisibletombolverifikasi(true);
            
        } else {
            view.setTableModel(model.getDatainventaris());
            view.setvisibletombolverifikasi(false);
        }
    }

    private class simpanVerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String data[] = view.getdata();
                if (popupver.getstatus().equalsIgnoreCase("verifikasi peminjaman")) {
                    if (Integer.parseInt(data[4]) <= Integer.parseInt(data[3])) {
                        String jumlahbarang = "-" + popupver.getjumlahbarangpinjam();
                        System.out.println("jumlah yg di pinjam = " + jumlahbarang);
                        if (model.updateVerifikasi(view.GetIDTable(), popupver.getComboBox(), jumlahbarang, view.GetNamaBarang()) == true) {
                            view.message("verivikaasi sukses");
                            popupver.dispose();
                        } else {
                            view.message("Verivikasi gagal");
                        }
                        System.out.println("jalannnnn");
//                        view.setvisibletombolverifikasi(true);
                        popupver.dispose();
                        view.setTableModel(model.getDataDaftarPeminjamantotal());
                    } else {
                        view.message("stock yang anda pinjam kurang");
                    }
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
//                    view.setvisibleverifikasi(true);
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
                view.setenableselesai(true);
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
                view.setenableselesai(true);
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
                view.setenableselesai(false);
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
                    popup.clear();
                } else {
                    view.message("data gagal di inputkan \n mohon periksa kembali inputan anda");
                }
//                view.setvisibleverifikasi(true);
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
            if (view.getSelectedRow() == -1) {
                view.message("silahkan pilih barang terlebih dahulu");
            } else {
                try {
                    popup.setdata(model.getDataWithID(view.GetIDTable()));
                    popup.setidpeminjam(model.getidwithusername(username));
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
