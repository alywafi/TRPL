/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.login;

/**
 *
 * @author acer
 */
public class c_login {
    login view ;
    public c_login (login view){
    this.view=view;
    view.kliklogin(new loginaction());
    view.setVisible(true);
    }
    private class loginaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controler.c_viewadmin a = new controler.c_viewadmin(new view.viewadmin());
        }
    
    }
    
}
