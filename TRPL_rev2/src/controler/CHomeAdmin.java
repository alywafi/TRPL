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
import view.viewLogin;
import view.popup_verifikasi;
import view.viewHomeAdmin;

/**
 *
 * @author acer
 */
public class CHomeAdmin {

    viewHomeAdmin view;
    viewLogin Vlogin ;

    public CHomeAdmin(viewHomeAdmin view, String Username) {
        this.view = view;
        view.klikexit(new exitaction());
        view.klikLogout(new logoutAction());
        view.klikminimize(new minimizeaction());
        System.out.println(Username);
        view.SetName(Username);
        view.setVisible(true);
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

    private class klikinventaris implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                System.out.println("masuk ke inventaris");
                controler.CInventaris a = new controler.CInventaris(new view.viewPeminjamanInventaris(), new model.MInventaris(),new view.popup_inputpinjaman(),new popup_verifikasi() ,view.Getname());
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
                System.out.println("getnama view user "+view.Getname());
                view.dispose();
                controler.CTebarBibit a = new controler.CTebarBibit(new view.viewTebarBibit(), new model.MBibit(),new view.popup_tebar(), view.Getname());
                
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
