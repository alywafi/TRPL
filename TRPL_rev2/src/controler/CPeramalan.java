/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.MPeramalan;
import model.modelmaster;
import view.viewHasilPeramalan;
import view.viewPeramalan;
import view.popup_inputpinjaman;
import view.viewHomeKetuaSub;
import view.viewHomeKetuaUmum;
import view.viewHomeUser;

/**
 *
 * @author acer
 */
public class CPeramalan {

    viewPeramalan view;
    viewHasilPeramalan view2;
    MPeramalan model ;

    public CPeramalan(viewPeramalan view1, viewHasilPeramalan View2, MPeramalan Model, String Username) throws SQLException {
        view = view1;
        view2 = View2;
        model = Model ;
        view.setVisible(true);
        view.klikexit(new exitaction());
        view2.klikexit(new exitaction());
        view.klikminimize(new minimizeaction());
        view2.klikminimize(new minimizeaction());
        view.KlikBack(new BackAction());
        view2.KlikBack(new BackAction2());
        view.klikRamal(new RamalAction());
        view.SetName(Username);
    }

    private class RamalAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String DataRamal[] = new String[2];
            DataRamal = view.getDataRamal();
            view2.setVisible(true);
            int RataTebar = Integer.valueOf(DataRamal[0]) / Integer.valueOf(DataRamal[1]);
            float koefKecil = (float) 0.11;
            float KelangsunganHidup = (float) 0.6;
            if (RataTebar < 1000) {
                koefKecil = (float) 0.12;
                KelangsunganHidup = (float) 0.7;
            }
            if (RataTebar < 900) {
                koefKecil = (float) 0.13;
                KelangsunganHidup = (float) 0.75;
                if (RataTebar < 800) {
                    koefKecil = (float) 0.14;
                    KelangsunganHidup = (float) 0.77;
                    if (RataTebar < 700) {
                        koefKecil = (float) 0.15;
                        KelangsunganHidup = (float) 0.817;
                        if (RataTebar < 600) {
                            koefKecil = (float) 0.16;
                            KelangsunganHidup = (float) 0.83;
                            if (RataTebar < 400) {
                                koefKecil = (float) 0.17;
                                KelangsunganHidup = (float) 0.85;
                                if (RataTebar < 300) {
                                    koefKecil = (float) 0.18;
                                    KelangsunganHidup = (float) 0.867;
                                    if (RataTebar < 200) {
                                        koefKecil = (float) 0.19;
                                        KelangsunganHidup = (float) 0.88;
                                        if (RataTebar < 100) {
                                            koefKecil = (float) 0.2;
                                            KelangsunganHidup = (float) 0.9;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            float awal = 3;
            int hari = 120;
            int minggu = hari / 7;
            float tampungan = 0;
//Ramal Panjang
            String kolom[] = {"Keterangan", "Bulan Pertama", "Bulan Kedua", "Bulan Ketiga", "Bulan Keempat"};
            DefaultTableModel table = new DefaultTableModel(null, kolom);
            String row[] = new String[kolom.length];
            row[0] = "Panjang Lele";
            int Penandakolom = 1;

            for (int i = 1; i < hari + 1; i++) {
                tampungan = (koefKecil * i) + awal;
                if (i % 30 == 0) {
                    row[Penandakolom] = String.valueOf(tampungan) + " cm";
                    Penandakolom++;
                }
            }
            table.addRow(row);
//Kelangsungan Hidup
            int lelehidup[] = new int[4]; //untuk perhitungan pakan lele
            row[0] = "Perkiraan Lele Hidup";
            int perkiraan = (int) ((1 - KelangsunganHidup) * Integer.valueOf(DataRamal[0]));
            for (int i = 1; i < 5; i++) {
                if (i == 1) {
                    row[i] = String.valueOf(Integer.valueOf(DataRamal[0]) - (perkiraan * 0.6));
                    lelehidup[i - 1] = (int) (Integer.valueOf(DataRamal[0]) - (perkiraan * 0.6));
//                    lelehidup[0] = Integer.valueOf(row[i]);
                } else if (i == 2) {
                    row[i] = String.valueOf(Integer.valueOf(DataRamal[0]) - (perkiraan * 0.85));
                    lelehidup[i - 1] = (int) (Integer.valueOf(DataRamal[0]) - (perkiraan * 0.85));
                } else if (i == 3) {
                    row[i] = String.valueOf(Integer.valueOf(DataRamal[0]) - (perkiraan * 0.92));
                    lelehidup[i - 1] = (int) (Integer.valueOf(DataRamal[0]) - (perkiraan * 0.92));
                } else if (i == 4) {
                    row[i] = String.valueOf(Integer.valueOf(DataRamal[0]) - (perkiraan * 0.96));
                    lelehidup[i - 1] = (int) (Integer.valueOf(DataRamal[0]) - (perkiraan * 0.96));
                }
            }
            table.addRow(row);
//Bulan Panen
            row[0] = "Tanggal Panen";
            for (int i = 1; i < 5; i++) {
                row[i] = GetBulanTanggal(i);
            }
            table.addRow(row);
            view2.tablePanen().setModel(table);

//kebutuhan  Pemeliharaan
//pakan
            String kolom2[] = {"Keterangan", "Bulan Pertama", "Bulan Kedua", "Bulan Ketiga", "Bulan Keempat"};
            DefaultTableModel table2 = new DefaultTableModel(null, kolom);
            String row2[] = new String[kolom.length];
            row2[0] = "Jenis Pakan";
            row2[1] = "Pellet F999";
            row2[2] = "Pellet 781-1 / cacah jeroan ikan";
            row2[3] = "Pellet 781-2 / jeroan ikan";
            row2[4] = "Pellet 782 / jeroan ayam dan ikan";
            table2.addRow(row2);

//Frekuensi Pemakanan
            row2[0] = "Frekuensi Pemakanan";
            row2[1] = "3 Kali/hari";
            row2[2] = "3 kali/hari";
            row2[3] = "2 kali / hari";
            row2[4] = "1 kali/hari";
            table2.addRow(row2);
//Vitamin
            row2[0] = "Vitamin";
            row2[1] = "minaraya, ton";
            row2[2] = "minaraya";
            row2[3] = "minaraya";
            row2[4] = "-";
            table2.addRow(row2);
//frekuensi ganti air
            row2[0] = "Frekuensi Ganti air/bulan";
            row2[1] = "Kolam Sirkulasi : 1 Kali\n NonSirkulasi 3kali";
            row2[2] = "Kolam Sirkulasi : 1 Kali\n NonSirkulasi 3kali";
            row2[3] = "Kolam Sirkulasi : 1 Kali\n NonSirkulasi 2kali";
            row2[4] = "Kolam Sirkulasi : - \n NonSirkulasi 1kali";
            table2.addRow(row2);
//Biaya
            row2[0] = "Biaya ";
            for (int i = 1; i < 5; i++) {
                row2[i] = " ";
            }
            table2.addRow(row2);
            //Bibit
            row2[0] = "Bibit @200 ";
            row2[1] = String.valueOf(Integer.valueOf(DataRamal[0]) * 200);
            for (int i = 2; i < 5; i++) {
                row2[i] = " ";
            }
            table2.addRow(row2);
            // Pakan
            row2[0] = "Pakan";
            row2[1] = String.valueOf(3 * 30 * 0.2 * 10000);
            row2[2] = String.valueOf(3 * 30 * 1 * 6000);
            row2[3] = String.valueOf(2 * 30 *  4 * 4000);
            row2[4] = String.valueOf(1 * 30 *  8 * 3000);
            table2.addRow(row2);
            view2.tableKebutuhamPemeliharaan().setModel(table2);

        }
    }

    private class BackAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            try {
                if (model.getidwithusername(view.Getname()).equals("4") ) {
                    controler.CHomeUser d = new controler.CHomeUser(new viewHomeUser(), view.Getname());
                }else if (model.getidwithusername(view.Getname()).equals("3")) {
                    CHomeKetuaSub b = new CHomeKetuaSub(new viewHomeKetuaSub());
                }else {
                    CHomeKetuaUmum c = new CHomeKetuaUmum(new viewHomeKetuaUmum(), view.Getname());
                }
            } catch (SQLException ex) {
                Logger.getLogger(CPeramalan.class.getName()).log(Level.SEVERE, null, ex);
            }
            view.dispose();
        }
    }

    private class BackAction2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent a) {
            view2.dispose();
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

    private String GetBulanTanggal(int bulan) {
        Calendar now = Calendar.getInstance();
        int bln = now.get(Calendar.MONTH) + bulan;
        if (bln > 12) {
            bln = bln - 12;
        }
        String valid = String.valueOf(now.get(Calendar.DATE)) + " - " + String.valueOf(bln) + " - " + String.valueOf(now.get(Calendar.YEAR));
        return valid;
    }
}
