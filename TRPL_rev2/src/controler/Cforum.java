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
import model.Mforum;
import view.popup_inputdataforum;
import view.viewHomeKetuaUmum;
import view.viewforum;

/**
 *
 * @author acer
 */
public class Cforum {

    viewforum view;
    Mforum model;
    popup_inputdataforum popup;
    String jabatan;
    String username;

    public Cforum(viewforum view, Mforum model, popup_inputdataforum popup, String Username) throws SQLException {
        this.view = view;
        this.model = model;
        this.popup = popup;
        this.username = Username;
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.kliktambah(new kliktambah());
        popup.simpan(new simpanAction());
        setvisibleforum(Username);
        view.KlikBack(new BackAction());
        view.SetName(Username);
        popup.setVisible(false);
        view.setVisible(true);
    }

    public void setvisibleforum(String Username) throws SQLException {
        if (model.getJabatan(Username).equals("4")) {
            view.setTableModel(model.getDataforumwithid(model.getidwithusername(Username)));
        } else {
            view.setTableModel(model.getDataforum());
        }
    }

   
    private class simpanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            try {
                System.out.println((model.getidwithusername(username)));
                if (model.setDataforum(popup.getdata()) == true) {
                    view.message("data berhasil di inputkan");
                } else {
                    view.message("data gagal di inputkan");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cforum.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class kliktambah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String[] data= {};
            popup.setdata(data);
            popup.setVisible(true);
        }
    
    }

    private class BackAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            view.dispose();
            try {
                if (model.getJabatan(username).equals("4")) {
                    controler.CHomeUser d = new controler.CHomeUser(new view.viewHomeUser(), username);
                } else {
                    controler.CHomeKetuaUmum d = new controler.CHomeKetuaUmum(new viewHomeKetuaUmum(), username);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cforum.class.getName()).log(Level.SEVERE, null, ex);
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
