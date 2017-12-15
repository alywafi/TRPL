package model;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Mforum extends modelmaster {

    public Mforum() throws SQLException {
        super();
    }

    public DefaultTableModel getDataforumwithid(String ID) throws SQLException {
        String kolom[] = {"id_masalah", "id_user", "judul", "isi", "tgl_masalah", "selesai", "hasil"};
        String query = "SELECT `id_masalah`, `id_user`, `judul`, `isi`, `tgl_masalah`, `status`, `hasil` FROM `forum` f join selesai s ON (f.selesai=s.id) where `id_user` = " + ID + ";";
        return getDatatotal(query, kolom);
    }

    public DefaultTableModel getDataforum() throws SQLException {
        String kolom[] = {"id_masalah", "id_user", "judul", "isi", "tgl_masalah", "selesai", "hasil"};
        String query = "SELECT `id_masalah`, `id_user`, `judul`, `isi`, `tgl_masalah`, `status`, `hasil` FROM `forum` f join selesai s ON (f.selesai=s.id)";
        return getDatatotal(query, kolom);
    }

    public DefaultTableModel getDataforumselesai() throws SQLException {
        String kolom[] = {"id_masalah", "id_user", "judul", "isi", "tgl_masalah ", "selesai", "hasil"};
        String query = "SELECT `id_masalah`, `id_user`, `judul`, `isi`, `tgl_masalah`, `status`, `hasil` FROM `forum` f join selesai s ON (f.selesai=s.id) WHERE selesai = 1  ";
        return getDatatotal(query, kolom);
    }

    public DefaultTableModel getDataforumbelum() throws SQLException {
        String kolom[] = {"id_masalah", "id_user", "judul", "isi", "tgl_masalah", "selesai", "hasil"};
        String query = "SELECT `id_masalah`, `id_user`, `judul`, `isi`, `tgl_masalah`, `status`, `hasil` FROM `forum` f join selesai s ON (f.selesai=s.id) WHERE selesai = 0 ";
        return getDatatotal(query, kolom);
    }

    public DefaultTableModel getDataforumselesaiwithid(String id) throws SQLException {
        String kolom[] = {"id_masalah", "judul", "isi", "tgl_masalah", "selesai","hasil"};
        String query = "SELECT id_masalah, judul, isi, tgl_masalah , selesai ,hasil FROM forum WHERE id_user = " + id + " and selesai = 1 ";
        return getDatatotal(query, kolom);
    }

    public DefaultTableModel getDataforumbelumwithid(String id) throws SQLException {
        String kolom[] = {"id_masalah", "judul", "isi", "tgl_masalah", "selesai","hasil"};
        String query = "SELECT id_masalah, judul, isi, tgl_masalah , `status`, `hasil` FROM `forum` f join selesai s ON (f.selesai=s.id) WHERE id_user = " + id + " and selesai = 0 ";
        return getDatatotal(query, kolom);
    }


    public boolean updateDataforum(String[] data) {
        String query = "UPDATE `forum` SET `judul`='" + data[0] + "',`isi`='" + data[1] + "',`selesai`= " + data[3] + " WHERE `id_masalah` = " + data[0];
        return execute(query);
    }

    public boolean updateDataforumadmin(String[] data) {
        String query = "UPDATE `forum` SET `judul`='" + data[0] + "',`isi`='" + data[1] + "', `selesai`= " + data[3] + ",`hasil`='" + data[5] + "' WHERE `id_masalah` = " + data[4];
        return execute(query);
    }


    public boolean setDataforum(String[] data) throws SQLException {
        String query = "INSERT INTO `forum`(`id_user`, `judul`, `isi`, `tgl_masalah`, `selesai`) VALUES (" + data[2] + ",'" + data[0] + "','" + data[1] + "',CURRENT_DATE,0)";
        return execute(query);
    }
}
