package controler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.MInventaris;
import view.popup_detailinvntaris;
import view.viewDetailInventaris;

/**
 *
 * @author acer
 */
public class CDetailInventaris {

    viewDetailInventaris view;
    MInventaris model;
    popup_detailinvntaris popup;
    String username;

    public CDetailInventaris(viewDetailInventaris view, MInventaris model, popup_detailinvntaris popup, String Username) throws SQLException {
        this.view = view;
        this.model = model;
        this.popup = popup;
        this.username = Username;
        view.setVisible(true);
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.kliktambah(new tambahdata());
        view.setTableModel(model.getDatainventaris());
        view.SetName(Username);
        popup.simpan(new kliksimpan());
        view.KlikBack(new BackAction());
        view.setVisible(true);
    }

    private class tambahdata implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            popup.IdEditable();
            popup.setdata(view.getDataOnTable());;
            popup.setVisible(true);
        }
    }

    private class BackAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            controler.CHomeUser d = new controler.CHomeUser(new view.viewHomeUser(), view.getName());
            view.dispose();
        }
    }

    private class kliksimpan implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (model.insertDataInventaris(popup.getdata())) {
                    view.message("input data Inventaris berhasil");
                } else {
                    view.message("input data Inventaris gagal cek kembali inputan anda");
                }
                view.setTableModel(model.getDatainventaris());
                popup.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CDetailInventaris.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private class exitaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controler.CHomeUser d = new controler.CHomeUser(new view.viewHomeUser(), view.getName());
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
