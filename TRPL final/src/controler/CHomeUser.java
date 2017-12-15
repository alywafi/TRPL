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
import model.MPeramalan;
import view.popup_inputhasilforum;
import view.viewHasilPeramalan;
import view.viewPeramalan;
import view.viewLogin;
import view.popup_verifikasi;
import view.viewHomeUser;

/**
 *
 * @author acer
 */
public class CHomeUser {

    viewHomeUser view;
    viewLogin Vlogin;
    String username;

    public CHomeUser(viewHomeUser view, String Username) {
        this.view = view;
        this.username = Username;
        view.klikexit(new exitaction());
        view.klikLogout(new logoutAction());
        view.klikminimize(new minimizeaction());
        view.klikinventaris(new klikinventaris());
        view.klikramalan(new ramalanAction());
        view.kliktebar(new kliktebar());
        view.klikforum(new klikforum());
        view.getBtnFormulasi().addActionListener(new formulasiAction());
        view.setVisible(true);
        System.out.println(Username);
        view.SetName(Username);
    }
private class formulasiAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                CFormulasi a = new CFormulasi(username);
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CHomeUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private class ramalanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                CPeramalan a = new CPeramalan(new viewPeramalan(), new viewHasilPeramalan(), new MPeramalan(), view.Getname());
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CHomeKetuaUmum.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class logoutAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                controler.CLogin a = new controler.CLogin(new view.viewLogin(), new model.MLogin());
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CHomeUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class klikinventaris implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                controler.CInventaris a = new controler.CInventaris(new view.viewInventaris(), new model.MInventaris(), new view.popup_inputpinjaman(), new popup_verifikasi(), username);
                view.dispose();
            } catch (SQLException ex) {
                ex.getStackTrace();
            }
        }
    }

    private class kliktebar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                controler.CTebarBibit a = new controler.CTebarBibit(new view.viewTebarBibit(), new model.MBibit(), new view.popup_tebar(), view.Getname());
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CHomeUser.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class klikforum implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                controler.Cforum a = new controler.Cforum(new view.viewforum(), new model.Mforum(), new view.popup_inputdataforum(), new popup_inputhasilforum() ,view.Getname());
                view.dispose();
            } catch (SQLException ex) {
                ex.getStackTrace();
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
