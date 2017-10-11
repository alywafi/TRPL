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
import view.popup_inputpinjaman;
import view.viewuser;

/**
 *
 * @author acer
 */
public class c_viewuser {

    viewuser view;

    public c_viewuser(viewuser view) {
        this.view = view;
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.klikinventaris(new klikinventaris());
        view.setVisible(true);
    }

    public class klikinventaris implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                controler.c_viewinventaris a = new controler.c_viewinventaris(new view.view_inventaris(), new model.m_inventaris(),new view.popup_inputpinjaman());
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
