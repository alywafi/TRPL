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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.MBibit;
import view.viewHomeKetuaUmum;
import view.viewLihatDataTebar;

/**
 *
 * @author acer
 */
public class CLihatDataTebar {

    viewLihatDataTebar view;
    MBibit model;
    String username;

    public CLihatDataTebar(viewLihatDataTebar view, MBibit model, String Username) throws SQLException {
        this.view = view;
        this.model = model;
        this.username = Username;
        view.setVisible(true);
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.setTableModel(model.getDatatebar(model.getidwithusername(username)));

        view.SetName(Username);
        view.KlikBack(new BackAction());
        view.setVisible(true);
    }

    private class BackAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            CHomeKetuaUmum x = new CHomeKetuaUmum(new viewHomeKetuaUmum(), view.getName());
            view.dispose();
        }
    }

    private class exitaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controler.CHomeUser d = new controler.CHomeUser(new view.viewHomeUser(), view.getName());
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
