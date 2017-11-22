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
import javax.swing.JOptionPane;
import view.viewadmin;

/**
 *
 * @author acer
 */
public class c_viewadmin {

    viewadmin view;
    c_login login;

    public c_viewadmin(viewadmin view) {
        this.view = view;
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.setVisible(true);
    }

    private class exitaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int dialogbutton = JOptionPane.YES_NO_OPTION;
                JOptionPane.showConfirmDialog(null, "apakah anda yakin logout", "Warning", dialogbutton);
                if (dialogbutton == JOptionPane.YES_OPTION) {
                    controler.c_login a = new controler.c_login(new view.login(), new model.m_login());
                    view.dispose();
                }

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
