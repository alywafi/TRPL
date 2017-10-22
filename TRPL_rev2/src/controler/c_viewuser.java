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
import view.login;
import view.popup_inputpinjaman;
import view.viewuser;

/**
 *
 * @author acer
 */
public class c_viewuser {

    viewuser view;
    login Vlogin ;

    public c_viewuser(viewuser view, String Username) {
        this.view = view;
        this.Vlogin =Vlogin;
        view.klikexit(new exitaction());
        view.klikLogout(new logoutAction());
        view.klikminimize(new minimizeaction());
        view.klikinventaris(new klikinventaris());
        view.kliktebar(new kliktebar());
        view.setVisible(true);
        System.out.println(Username);
        view.SetName(Username);
    }

    private class logoutAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                view.dispose();
            try {
                controler.c_login a = new controler.c_login(new view.login(), new model.m_login());
            } catch (SQLException ex) {
                Logger.getLogger(c_viewuser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class klikinventaris implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                controler.c_viewinventaris a = new controler.c_viewinventaris(new view.view_inventaris(), new model.m_inventaris(),new view.popup_inputpinjaman(),view.Getname());
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
                controler.c_tebarbibit a = new controler.c_tebarbibit(new view.view_tebar_bibit(), new model.m_tebar_bibit(), view.Getname());
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(c_viewuser.class.getName()).log(Level.SEVERE, null, ex);
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
