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
import model.MPeramalan;
import model.Mforum;
import view.popup_inputdataforum;
import view.popup_inputhasilforum;
import view.viewHasilPeramalan;
import view.viewPeramalan;
import view.popup_verifikasi;
import view.viewHomeKetuaUmum;
import view.viewLihatDataTebar;
import view.viewforum;

/**
 *
 * @author acer
 */
public class CHomeKetuaUmum {

    viewHomeKetuaUmum view;
    String username;

    public CHomeKetuaUmum(viewHomeKetuaUmum view, String Username) {
        this.view = view;
        this.username=Username;
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.klikLihatinventaris(new LihatInventarisAction());
        view.klikLogout(new LogoutAction());
        view.kliktebar(new TebarAction());
        view.klikramalan(new ramalanAction());
        view.klikforum(new lihatfotum());
        view.setVisible(true);
        view.SetName(Username);
    }

    private class LogoutAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                controler.CLogin a = new controler.CLogin(new view.viewLogin(), new model.MLogin());
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CHomeAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class TebarAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
               
                CLihatDataTebar a = new CLihatDataTebar(new viewLihatDataTebar(), new MBibit(), view.Getname());
                 view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CHomeKetuaUmum.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class ramalanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
       
            try {
                CPeramalan a = new CPeramalan(new viewPeramalan(), new viewHasilPeramalan(), new MPeramalan(), username);
                     view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CHomeKetuaUmum.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class LihatInventarisAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                controler.CInventaris a = new controler.CInventaris(new view.viewInventaris(), new model.MInventaris(), new view.popup_inputpinjaman(), new popup_verifikasi(), username);
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(CHomeKetuaUmum.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    private class lihatfotum implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
               Cforum a = new Cforum(new viewforum(), new Mforum(),new popup_inputdataforum(),new popup_inputhasilforum() ,username);
                view.dispose();
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
