package controler;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.MPeramalan;
import view.viewFormulasi;
import view.viewHasilFormulasi;

public class CFormulasi {

    viewFormulasi view1;
    viewHasilFormulasi viewhasil;
    MPeramalan model;
    String username ;

    public CFormulasi(String Username) throws SQLException {
        this.username = Username ;
        this.model = new MPeramalan();
        this.view1 = new viewFormulasi();
        this.viewhasil = new viewHasilFormulasi();
        view1.klikexit(new CFormulasi.exitaction());
        viewhasil.klikexit(new CFormulasi.exitaction());
        view1.klikminimize(new CFormulasi.minimizeaction());
        viewhasil.klikminimize(new CFormulasi.minimizeaction2());
        view1.KlikBack(new CFormulasi.BackAction());
        viewhasil.KlikBack(new CFormulasi.BackAction2());
        view1.setVisible(true);

        view1.getHitung().addActionListener(new HitungAction());

    }

    private class HitungAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("data basal = " + view1.getDataBasal());
            System.out.println("data supp = " + view1.getDataSuplement());
            System.out.println("bobot = " + view1.getBobot());
            if (view1.getDataBasal() != 0) {
                if (view1.getDataSuplement() != 0) {
                    if (view1.getBobot() != 0) {
                        DecimalFormat df = new DecimalFormat("#.##");
                        String[] dataBasal = view1.getDataBasalterpilih();
                        String[] dataSupp = view1.getDataSuplementterpilih();
                        double basal;
                        double supp;
                        double basalsupp;
                        double kebutuhanBasal;
                        double kebutuhanSupp;
                        double perbahanbasal;
                        double perbahanSupp;
                        String kolom[] = {"Bahan Baku", "Kuantitas"};
                        DefaultTableModel a = new DefaultTableModel(null, kolom);

                        basal = view1.getDataSuplement() - view1.getProtein();
                        supp = view1.getProtein() - view1.getDataBasal();

                        basalsupp = basal + supp;
                        kebutuhanBasal = basal / basalsupp * (view1.getBobot() * 0.9);
                        kebutuhanSupp = supp / basalsupp * (view1.getBobot() * 0.9);

                        perbahanbasal = kebutuhanBasal / dataBasal.length;
                        perbahanSupp = kebutuhanSupp / dataSupp.length;

                        System.out.println("basal " + basal);
                        System.out.println("supp" + supp);

                        for (int i = 0; i < dataBasal.length; i++) {
                            String[] row = new String[2];
                            row[0] = dataBasal[i];
                            row[1] = String.valueOf(df.format(perbahanbasal));
                            a.addRow(row);
                        }

                        for (int i = 0; i < dataSupp.length; i++) {
                            String[] row = new String[2];
                            row[0] = dataSupp[i];
                            row[1] = String.valueOf(df.format(perbahanSupp));
                            a.addRow(row);
                        }
                        viewhasil.setmodel(a);
                        viewhasil.setVisible(true);
                        view1.dispose();
                    } else {
                        view1.message("Input data tidak boleh kosong, silahkan dicek kembali");
                    }
                } else {
                    view1.message("Input data tidak boleh kosong, silahkan dicek kembali");
                }
            } else {
                view1.message("Input data tidak boleh kosong, silahkan dicek kembali");
            }

        }
    }

       private class BackAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            try {
                System.out.println("jabatanya = " + model.getJabatan(username));
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
                view1.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Cforum.class.getName()).log(Level.SEVERE, null, ex);
            }
            view1.dispose();
        }
    }

    private class BackAction2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            viewhasil.dispose();
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
            view1.setState(Frame.ICONIFIED);
        }

    }
    private class minimizeaction2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewhasil.setState(Frame.ICONIFIED);
        }

    }

}
