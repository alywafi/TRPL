/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public class m_login {
     private koneksi con;

    public m_login() throws SQLException {
        con = new koneksi();
    }

    public boolean cekusername(String user) throws SQLException {
        boolean username;
        String query = "SELECT user FROM `pengguna` WHERE user = '" + user + "' ; ";
        ResultSet hasil = con.getResult(query);
        if (hasil.next()) {
            username = true;
            System.out.println("ada");
        } else {
            username = false;
            System.out.println("tidak ada");
        }
        return username;
    }

    public boolean cekpassword(String user, String password) throws SQLException {
        String query = "select password from pengguna where user = '" + user + "' ;";
        ResultSet hasil = con.getResult(query);
        String dbPassword = null;
        if (hasil.next()) {
            dbPassword = hasil.getString(1);
        }
        if (dbPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public String getJabatan(String id) throws SQLException {
        String query = "select jabatan from pengguna where user = '" + id + "' ;";
        ResultSet hasil = con.getResult(query);
        String jabatan = null;
        if (hasil.next()) {
            jabatan = hasil.getString(1);
        }
        return jabatan;
    }

    public String getidakun(String user) throws SQLException {
        String data = "";
        String query = "select * from pengguna where user = '" + user + " '";
        ResultSet rs = con.getResult(query);
        if (rs.next()) {
            data = rs.getString(4);
        }
        return data;
    }

    public String[] getinfonasabah(String id) throws SQLException {
        String[] data = new String[12];
        String query = "select * from nasabah where id_akun = " + id;
        ResultSet rs = con.getResult(query);
        if (rs.next()) {
            for (int i = 0; i < data.length; i++) {
                data[i] = rs.getString(i + 1);
            }
        }
        return data;
    }

    public String[] getinfopetugas(String id) throws SQLException {
        String[] data = new String[10];
        String query = "select * from petugas where id_akun = " + id;
        ResultSet rs = con.getResult(query);
        if (rs.next()) {
            for (int i = 0; i < data.length; i++) {
                data[i] = rs.getString(i + 1);
            }
        }
        return data;
    }

    public String[] getinfoadmin() throws SQLException {
        String[] data = new String[7];
        String query = "select * from admin";
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
}
