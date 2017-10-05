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
import model.m_inventaris;
import view.view_inventaris;

/**
 *
 * @author acer
 */
public class c_viewinventaris {
view_inventaris view;
m_inventaris model;

    public c_viewinventaris(view_inventaris view, m_inventaris model) throws SQLException {
        this.view = view;
        this.view.setTableModel(this.model.getDatainventaris());
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.setVisible(true);
    }
    
private class exitaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             try {
                controler.c_login a = new controler.c_login(new view.login(),new model.m_login());
                view.dispose();
            } catch (SQLException ex) {
            }
        }

}
private class minimizeaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setState(Frame.ICONIFIED);
        }

}
}