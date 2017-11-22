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
            try {
                if (model.getJabatan(username).equalsIgnoreCase("4")) {
                    controler.CHomeUser d = new controler.CHomeUser(new view.viewHomeUser(), username);
                } 
                if (model.getJabatan(username).equalsIgnoreCase("1"))
                {
                    controler.CHomeAdmin e = new controler.CHomeAdmin(new view.viewHomeAdmin(), username);
                }
                if (model.getJabatan(username).equalsIgnoreCase("2")) {
                    controler.CHomeKetuaUmum f = new controler.CHomeKetuaUmum(new view.viewHomeKetuaUmum(), username);
                }
                if (model.getJabatan(username).equalsIgnoreCase("3")) {
                    controler.CHomeKetuaSub g = new controler.CHomeKetuaSub(new view.viewHomeKetuaSub(),username);
                }
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Cforum.class.getName()).log(Level.SEVERE, null, ex);
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
