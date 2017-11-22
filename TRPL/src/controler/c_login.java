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
import model.m_login;
import view.login;

/**
 *
 * @author acer
 */
public class c_login {

    login view;
    m_login model;

    public c_login(login view, m_login model) {
        this.view = view;
        this.model = model;
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.kliklogin(new loginaction());
        view.setVisible(true);
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
            
        System.out.println(view.getusername());
        System.out.println(view.getpassword());
            try {
                if (model.cekusername(view.getusername())) {
                    if (model.cekpassword(view.getusername(), view.getpassword()) == true) {
                        switch (model.getJabatan(view.getusername())) {
                            case "admin":
                                controler.c_viewadmin a = new controler.c_viewadmin(new view.viewadmin());
                                view.dispose();
                                break;
                            case "ketuaumum":
                                controler.c_viewketuaumum b = new controler.c_viewketuaumum(new view.viewketuaumum());
                                view.dispose();
                                break;
                            case "ketuasub":
                                controler.c_viewketuasub c = new controler.c_viewketuasub(new view.viewketuasub());
                                view.dispose();
                                break;
                            case "anggota kelompok":
                                controler.c_viewuser d = new controler.c_viewuser(new view.viewuser(),view.getusername());
                                view.dispose();
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
                Logger.getLogger(c_login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
