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
import model.m_inventaris;
import view.popup_inputpinjaman;
import view.view_inventaris;

/**
 *
 * @author acer
 */
public class c_viewinventaris {

    view_inventaris view;
    m_inventaris model;
    popup_inputpinjaman popup;

    public c_viewinventaris(view_inventaris view, m_inventaris model, popup_inputpinjaman popup, String Username) throws SQLException {
        this.view = view;
        this.model = model;
        this.popup = popup;
        this.view.setVisible(true);
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.klikpinjam(new pinjambarang());
        view.klikdaftar(new DaftarAction());
        popup.simpan(new simpanAction());
        this.view.setTableModel(model.getDatainventaris());
        view.KlikBack(new BackAction());
        view.SetName(Username);
        popup.setVisible(false);
    }

    private class simpanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            try {
                System.out.println((model.getIDwithData(view.Getname())));
                model.setDataPeminjaman(popup.getdata(), (model.getIDwithData(view.Getname())));
            } catch (SQLException ex) {
                Logger.getLogger(c_viewinventaris.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class DaftarAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            if (view.getButtonText().equals("daftar pinjaman")) {
                view.setButtonText("List Inventaris");
                view.setEditable(false);
                try {
                    view.setTableModel(model.getDataDaftarPeminjaman(model.getIDwithData(view.Getname())));
                } catch (SQLException ex) {
                    Logger.getLogger(c_viewinventaris.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                view.setButtonText("daftar pinjaman");
                view.setEditable(true);
                try {
                    view.setTableModel(model.getDatainventaris());
                } catch (SQLException ex) {
                    Logger.getLogger(c_viewinventaris.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private class BackAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            view.dispose();
            controler.c_viewuser d = new controler.c_viewuser(new view.viewuser(), view.Getname());
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
                    popup.setidpeminjam(model.getIDwithData(view.Getname()));
                    popup.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(c_viewinventaris.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    private class exitaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           controler.c_viewuser d = new controler.c_viewuser(new view.viewuser(),view.getName());
            view.dispose();
        }

    }

    private class minimizeaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setState(Frame.ICONIFIED);
        }

    }
}
