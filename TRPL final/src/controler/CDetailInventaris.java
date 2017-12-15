package controler;

/*
wkwkwkwk
 */
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MInventaris;
import view.popup_detailinvntaris;
import view.viewDetailInventaris;

/**
 *
 * @author acer
 */
public class CDetailInventaris {

    viewDetailInventaris view;
    MInventaris model;
    popup_detailinvntaris popup;
    String username;

    public CDetailInventaris(viewDetailInventaris view, MInventaris model, popup_detailinvntaris popup, String Username) throws SQLException {
        this.view = view;
        this.model = model;
        this.popup = popup;
        this.username = Username;
        view.setVisible(true);
        view.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view.klikubah(new ubahAction());
        view.kliktambah(new tambahAction());
        view.setTableModel(model.getDatainventaris());
        view.SetName(Username);
        popup.simpan(new kliksimpan());
        view.KlikBack(new BackAction());
        view.setVisible(true);
    }

    private class tambahAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            popup.IdEditable();
            popup.setButtonText("save");
            popup.setVisible(true);
        }
    }

    private class ubahAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            popup.IdEditable();
            popup.setButtonText("update");
            popup.setdata(view.getDataOnTable());;
            popup.setVisible(true);
        }
    }

    private class BackAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            controler.CHomeAdmin e = new controler.CHomeAdmin(new view.viewHomeAdmin(), username);
            view.dispose();
        }
    }

    private class kliksimpan implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!popup.getdata()[0].equals("") || !popup.getdata()[0].equals("") || !popup.getdata()[1].equals("")
                    || !popup.getdata()[2].equals("") || !popup.getdata()[3].equals("")) {
                try {
                    if (Integer.parseInt(popup.getdata()[2]) >= Integer.parseInt(popup.getdata()[3])) {
                        if (popup.getButtonText().equals("save")) {
                            if (model.insertDataInventaris(popup.getdata())) {
                                view.message("insert data Inventaris berhasil");
                            } else {
                                view.message("insert data Inventaris gagal cek kembali inputan anda");
                            }
                            try {
                                view.setTableModel(model.getDatainventaris());
                            } catch (SQLException ex) {
                                Logger.getLogger(CDetailInventaris.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            popup.dispose();
                        } else {
                            try {
                                if (model.updateDataInventaris(popup.getdata())) {
                                    view.message("update data Inventaris berhasil");
                                } else {
                                    view.message("update data Inventaris gagal cek kembali inputan anda");
                                }
                                view.setTableModel(model.getDatainventaris());
                                popup.dispose();
                            } catch (SQLException ex) {
                                Logger.getLogger(CDetailInventaris.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else {
                        view.message("inputan stock salah");
                    }
                } catch (NumberFormatException ex) {
                    view.message("salah type data");
                }
            } else {
                view.message("data yang anda inputkan kosong");
            }
            String data[] = {"", "", "", ""};
            popup.setdata(data);
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
