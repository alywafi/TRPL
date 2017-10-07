/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public abstract class modelmaster {

    koneksi con;

    public modelmaster() throws SQLException {
        con = new koneksi();
    }

    public String gettanggal() {
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateformat.format(date);
    }

    public String getwaktu() {
        DateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        System.out.println(date);
        return dateformat.format(date);
    }

    public String gettgl() {
        String tanggal = gettanggal() + " " + getwaktu() + ".0";
        return tanggal;
    }

    public boolean execute(String query) {
        boolean succesDelete;
        try {
            con.executeQuery(query);
            succesDelete = true;
            System.out.println("query berhasil");
        } catch (SQLException ex) {
            succesDelete = false;
            System.out.println("query salah");
        }
        return succesDelete;
    }

    public String[] getdataid(String query, String data[]) throws SQLException {
        ResultSet rs = con.getResult(query);
        if (rs.next()) {
            for (int i = 0; i < data.length; i++) {
                data[i] = rs.getString(i + 1);
            }
        }
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
        return data;
    }

    public DefaultTableModel getDatatotal(String query, String kolom[]) throws SQLException {
        DefaultTableModel table = new DefaultTableModel(null, kolom);
        ResultSet rs = con.getResult(query);
        while (rs.next()) {
            String row[] = new String[kolom.length];
            for (int i = 0; i < row.length; i++) {
                row[i] = rs.getString(i + 1);
            }
            table.addRow(row);
        }
        return table;
    }
}
