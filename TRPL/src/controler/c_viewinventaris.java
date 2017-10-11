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

    public c_viewinventaris(view_inventaris view, m_inventaris model, popup_inputpinjaman popup) throws SQLException {
        this.view = view;
        this.view.setVisible(true);
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.klikpinjam(new pinjambarang());
        this.view.setTableModel(model.getDatainventaris());
        view.setVisible(true);
//        popup.setVisible(true);
    }

    public void viewpopup() {
        this.popup.setVisible(true);
    }

    private class pinjambarang implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getSelectedRow() == -1) {
                view.message("Pilih Dulu Gan");
            } else {
                viewpopup();
            }
        }
    }

    private class exitaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controler.c_viewuser a = new controler.c_viewuser(new view.viewuser());
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
