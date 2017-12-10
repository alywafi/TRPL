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
import model.Mforum;
import view.popup_inputdataforum;
import view.popup_inputhasilforum;
import view.viewforum;

/**
 *
 * @author acer
 */
public class Cforum {

    viewforum view;
    Mforum model;
    popup_inputdataforum popup;
    popup_inputhasilforum popuphasil;
    String jabatan;
    String username;
    String id;

    public Cforum(viewforum view, Mforum model, popup_inputdataforum popup, popup_inputhasilforum popuphasil, String Username) throws SQLException {
        this.view = view;
        this.model = model;
        this.popup = popup;
        this.popuphasil = popuphasil;
        this.username = Username;
        this.id = model.getidwithusername(Username);
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.kliktambah(new kliktambah());
        view.Klikbelum(new klikbelum());
        view.Klikselesai(new klikselesai());
        popup.simpan(new simpanAction());
        popuphasil.simpan(new klikubahadmin());
        setvisibleforum(username);
        view.KlikBack(new BackAction());
        view.SetName(Username);
        view.klikubah(new klikubah());
        popup.setVisible(false);
        view.setVisible(true);
    }

    public void setvisibleforum(String Username) throws SQLException {
        System.out.println("username = " + Username);
        if (model.getJabatan(Username).equalsIgnoreCase("4") || model.getJabatan(Username).equalsIgnoreCase("3")) {
            view.setTableModel(model.getDataforumwithid(id));
        } else {
            view.setTableModel(model.getDataforum());
        }
    }

    private class simpanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            try {
                if (popup.getbtnsimpan().equalsIgnoreCase("simpan")) {
                    System.out.println((model.getidwithusername(username)));
                    if (model.setDataforum(popup.getdata()) == true) {
                        view.message("data berhasil di inputkan");
                        popup.dispose();
                    } else {
                        view.message("data gagal di inputkan");
                        popup.dispose();
                    }
                } else {
                    if (model.updateDataforum(popup.getdata()) == true) {
                        view.message("data berhasil di update");
                        popup.dispose();
                        setvisibleforum(username);
                    } else {
                        view.message("data gagal di update");
                        popup.dispose();
                    }
                    popup.setsimpan("simpan");
                }
                setvisibleforum(username);

            } catch (SQLException ex) {
                Logger.getLogger(Cforum.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class klikubahadmin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (model.updateDataforumadmin(popuphasil.getdata()) == true) {
                    view.message("data berhasil di update");
                    popuphasil.dispose();
                    setvisibleforum(username);
                } else {
                    view.message("data gagal di update");
                    popuphasil.dispose();
                }
                popup.setsimpan("simpan");

                setvisibleforum(username);
            } catch (SQLException ex) {
                Logger.getLogger(Cforum.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class klikubah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String a[] = view.getDataOnTable();
                for (int i = 0; i < a.length; i++) {
                    String string = a[i];
                    System.out.println("dapat " + string);
                }
                String jabatan = model.getJabatan(username);
                System.out.println("jabatan = "+jabatan);
                System.out.println("jabatan = "+jabatan);
                if (jabatan.equalsIgnoreCase("2")) {
                    System.out.println("enable hasil");
                    popuphasil.setenablehasil(true);
                }
                popuphasil.setdataubah(a, username);
                popuphasil.setsimpan("update");
                popuphasil.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Cforum.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class kliktambah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String[] data = new String[4];
                data[0] = model.getidwithusername(username);
                data[1] = model.gettanggal();
                data[2] = "0";
                data[3] = username;
                popup.setdatainput(data);
                popup.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Cforum.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private class BackAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            try {
                if (model.getJabatan(username).equalsIgnoreCase("4")) {
                    controler.CHomeUser d = new controler.CHomeUser(new view.viewHomeUser(), username);
                }
                if (model.getJabatan(username).equalsIgnoreCase("1")) {
                    controler.CHomeAdmin e = new controler.CHomeAdmin(new view.viewHomeAdmin(), username);
                }
                if (model.getJabatan(username).equalsIgnoreCase("2")) {
                    controler.CHomeKetuaUmum f = new controler.CHomeKetuaUmum(new view.viewHomeKetuaUmum(), username);
                }
                if (model.getJabatan(username).equalsIgnoreCase("3")) {
                    controler.CHomeKetuaSub g = new controler.CHomeKetuaSub(new view.viewHomeKetuaSub(), username);
                }
                view.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Cforum.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class klikselesai implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (id.equals("1") || id.equals("2")) {
                    view.setTableModel(model.getDataforumselesai());
                } else {
                    System.out.println("id nya =" + id);
                    view.setTableModel(model.getDataforumselesaiwithid(id));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cforum.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class klikbelum implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (id.equals("1") || id.equals("2")) {
                    view.setTableModel(model.getDataforumbelum());
                } else {
                    view.setTableModel(model.getDataforumbelumwithid(id));
                }
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
