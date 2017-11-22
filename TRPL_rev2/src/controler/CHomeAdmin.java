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
import view.popup_detailinvntaris;
import view.viewLogin;
import view.popup_verifikasi;
import view.viewDetailInventaris;
import view.viewHomeAdmin;

/**
 *
 * @author acer
 */
public class CHomeAdmin {

    viewHomeAdmin view;
    viewLogin Vlogin;

    public CHomeAdmin(viewHomeAdmin view, String Username) {
        this.view = view;
        view.klikexit(new exitaction());
        view.klikLogout(new logoutAction());
        view.klikminimize(new minimizeaction());
        view.klikDetailInventaris(new DetailListener());
        System.out.println(Username);
        view.SetName(Username);
        view.setVisible(true);
    }

    private class DetailListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                CDetailInventaris a = new CDetailInventaris(new viewDetailInventaris(), new MInventaris(), new popup_detailinvntaris(),view.Getname());
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CHomeAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class logoutAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            try {
                controler.CLogin a = new controler.CLogin(new view.viewLogin(), new model.MLogin());
            } catch (SQLException ex) {
                Logger.getLogger(CHomeAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
