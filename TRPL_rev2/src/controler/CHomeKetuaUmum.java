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
import model.MBibit;
import view.viewHasilPeramalan;
import view.viewPeramalan;
import view.popup_verifikasi;
import view.viewHomeKetuaUmum;
import view.viewLihatDataTebar;

/**
 *
 * @author acer
 */
public class CHomeKetuaUmum {

    viewHomeKetuaUmum view;

    public CHomeKetuaUmum(viewHomeKetuaUmum view, String Username) {
        this.view = view;
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.klikLihatinventaris(new LihatInventarisAction());
        view.kliktebar(new TebarAction());
        view.klikramalan(new ramalanAction());
        view.setVisible(true);
        view.SetName(Username);
    }

    private class TebarAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                view.dispose();
                CLihatDataTebar a = new CLihatDataTebar(new viewLihatDataTebar(), new MBibit(), view.Getname());
            } catch (SQLException ex) {
                Logger.getLogger(CHomeKetuaUmum.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class ramalanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            try {
                CPeramalan a = new CPeramalan(new viewPeramalan(), new viewHasilPeramalan(), view.Getname());
            } catch (SQLException ex) {
                Logger.getLogger(CHomeKetuaUmum.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class LihatInventarisAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                controler.CInventaris a = new controler.CInventaris(new view.viewPeminjamanInventaris(), new model.MInventaris(), new view.popup_inputpinjaman(), new popup_verifikasi(), view.Getname());
            } catch (SQLException ex) {
                Logger.getLogger(CHomeKetuaUmum.class.getName()).log(Level.SEVERE, null, ex);
            }
            view.dispose();
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
