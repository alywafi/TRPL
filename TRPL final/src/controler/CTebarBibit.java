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
import model.MBibit;
import view.popup_tebar;
import view.viewTebarBibit;

/**
 *
 * @author acer
 */
public class CTebarBibit {

    viewTebarBibit view;
    MBibit model;
    popup_tebar popup;
    String username;

    public CTebarBibit(viewTebarBibit view, MBibit model, popup_tebar popup, String Username) throws SQLException {
        this.view = view;
        this.model = model;
        this.popup = popup;
        this.username = Username;
        view.setVisible(true);
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.kliktambah(new tambahdata());
        view.setTableModel(gettabel());
        view.SetName(Username);
        popup.simpan(new kliksimpan());
        view.KlikBack(new BackAction());
        view.setVisible(true);
    }

    public DefaultTableModel gettabel() throws SQLException {
        String idjabatan = model.getJabatan(username);
        DefaultTableModel tabel = new DefaultTableModel();
        if (idjabatan.equalsIgnoreCase("1") || idjabatan.equalsIgnoreCase("2")) {
            tabel = model.getDatatebar();
        }
        if (idjabatan.equalsIgnoreCase("3") || idjabatan.equalsIgnoreCase("4")) {
            tabel = model.getDatatebar(model.getidwithusername(username));
        }
        return tabel;
    }

    private class tambahdata implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            popup.setnama(view.getName());
            popup.setVisible(true);
        }
    }

    private class BackAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            try {
                if (model.getJabatan(username).equals("4")) {
                    controler.CHomeUser d = new controler.CHomeUser(new view.viewHomeUser(), username);
                } 
                if (model.getJabatan(username).equals("1"))
                {
                    controler.CHomeAdmin e = new controler.CHomeAdmin(new view.viewHomeAdmin(), username);
                }
                if (model.getJabatan(username).equals("2")) {
                    controler.CHomeKetuaUmum f = new controler.CHomeKetuaUmum(new view.viewHomeKetuaUmum(), username);
                }
                if (model.getJabatan(username).equals("3")) {
                    controler.CHomeKetuaSub g = new controler.CHomeKetuaSub(new view.viewHomeKetuaSub(),username);
                }
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Cforum.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class kliksimpan implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String[] data = popup.getdata();
                System.out.println("data kolam " + data[4]);
                if (model.insertDatatebar(model.getidwithusername(view.getName()), data[2], data[4])) {
                    view.message("input data tebar berhasil");
                } else {
                    view.message("input data tebar gagal cek kembali inputan anda");
                }
                view.setTableModel(gettabel());
                popup.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CTebarBibit.class.getName()).log(Level.SEVERE, null, ex);
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