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
import model.MLogin;
import view.viewLogin;

/**
 *
 * @author acer
 */
public class CLogin {

    viewLogin view;
    MLogin model;

    public CLogin(viewLogin view, MLogin model) {
        this.view = view;
        this.model = model;
        view.setVisible(true);
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.kliklogin(new loginaction());
    }
private class exitaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

}
private class minimizeaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setState(Frame.ICONIFIED);
        }

}
    private class loginaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if (model.cekusername(view.getusername())) {
                    if (model.cekpassword(view.getusername(), view.getpassword()) == true) {
                        switch (model.getJabatan(view.getusername())) {
                            case "1":
                                view.dispose();
                                controler.CHomeAdmin a = new controler.CHomeAdmin(new view.viewHomeAdmin(),view.getusername());
                                break;
                            case "2":
                                view.dispose();
                                controler.CHomeKetuaUmum b = new controler.CHomeKetuaUmum(new view.viewHomeKetuaUmum(), view.getusername());
                                break;
                            case "3":
                                view.dispose();
                                controler.CHomeKetuaSub c = new controler.CHomeKetuaSub(new view.viewHomeKetuaSub());
                                break;
                            case "4":
                                view.dispose();
                                controler.CHomeUser d = new controler.CHomeUser(new view.viewHomeUser(),view.getusername());
                                break;
                        }
                    } else {
                        view.message("password salah");
                    }
                } else {
                    if (view.getusername().equalsIgnoreCase("")||view.getpassword().equalsIgnoreCase("")) {
                        view.message("username dan password kosong");
                    } else {
                        view.message("username salah");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(CLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
