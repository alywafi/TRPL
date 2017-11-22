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
import view.viewHasilPeramalan;
import view.viewPeramalan;
import view.viewHomeKetuaSub;

/**
 *
 * @author acer
 */
public class CHomeKetuaSub {

    viewHomeKetuaSub view;

    public CHomeKetuaSub(viewHomeKetuaSub view) {
        this.view = view;
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.klikRamalan(new ramalanAction());
        view.klikLogout(new LogoutAtion());
        view.setVisible(true);
    }

    private class LogoutAtion implements ActionListener {

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

    private class ramalanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            try {
                CPeramalan a = new CPeramalan(new viewPeramalan(), new viewHasilPeramalan(), new MPeramalan(), view.Getname());
            } catch (SQLException ex) {
                Logger.getLogger(CHomeKetuaUmum.class.getName()).log(Level.SEVERE, null, ex);
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
