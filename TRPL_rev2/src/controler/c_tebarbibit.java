package controler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import model.m_tebar_bibit;
import view.view_tebar_bibit;

/**
 *
 * @author acer
 */
public class c_tebarbibit {
    c_viewuser view2;
    view_tebar_bibit view;
    m_tebar_bibit model;

    public c_tebarbibit(view_tebar_bibit view, m_tebar_bibit model, String Username) throws SQLException {
        this.view = view;
        this.model = model;
        view.setVisible(true);
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.kliktambah(new tambahdata());
        view.setTableModel(model.getDatatebar()); 
        view.SetName(Username);
        System.out.println(Username);
        view.setVisible(true);
    }

    private class tambahdata implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getSelectedRow() == -1) {
                view.message("Pilih Dulu Gan");
            } else {
                model.insertDatatebar("1", 100);
                try {
                    view.setTableModel(model.getDatatebar());
                } catch (SQLException ex) {
                }
            }
        }
    }

    private class exitaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controler.c_viewuser d = new controler.c_viewuser(new view.viewuser(),view.getName());
            view.dispose();
        }
    }

    private class minimizeaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setState(Frame.ICONIFIED);
        }
    }
}
