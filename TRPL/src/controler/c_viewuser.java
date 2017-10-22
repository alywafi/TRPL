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
import model.m_tebar_bibit;
import view.login;
import view.popup_inputpinjaman;
import view.view_tebar_bibit;
import view.viewuser;

/**
 *
 * @author acer
 */
public class c_viewuser {

    viewuser view;
    login Vlogin;

    public c_viewuser(viewuser view, String Username) {
        this.view = view;
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.klikinventaris(new klikinventaris());
        view.kliktebar(new kliktebar());
        System.out.println(Username);
        view.SetName(Username);
        view.setVisible(true);
    }

    public class klikinventaris implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                controler.c_viewinventaris a = new controler.c_viewinventaris(new view.view_inventaris(), new model.m_inventaris(), new view.popup_inputpinjaman(), view.Getname());
                view.dispose();
            } catch (SQLException ex) {
                ex.getStackTrace();
            }

        }

    }

    public class kliktebar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                controler.c_tebarbibit a = new controler.c_tebarbibit(new view.view_tebar_bibit(), new model.m_tebar_bibit(), view.getName());
                view.dispose();
            } catch (SQLException ex) {
                ex.getStackTrace();
            }

        }

    }

    private class exitaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                controler.c_login a = new controler.c_login(new view.login(), new model.m_login());
                view.dispose();
            } catch (SQLException ex) {
            }
        }

    }

    private class minimizeaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setState(Frame.ICONIFIED);
        }

    }
}
