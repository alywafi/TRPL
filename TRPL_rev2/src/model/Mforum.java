package model;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Mforum extends modelmaster {

    public Mforum() throws SQLException {
        super();
    }

    public DefaultTableModel getDataforumwithid(String ID) throws SQLException {
        String kolom[] = {"id_masalah", "id_user", "judul", "isi", "tgl_masalah", "selesai", "hasil"};
        String query = "select * from forum where `id_user` = " + ID + ";";
        return getDatatotal(query, kolom);
    }

    public DefaultTableModel getDataforum() throws SQLException {
        String kolom[] = {"id_masalah", "id_user", "judul", "isi", "tgl_masalah", "selesai", "hasil"};
        String query = "select * from forum";
        return getDatatotal(query, kolom);
    }

    public DefaultTableModel getDataforumselesai() throws SQLException {
        String kolom[] = {"id_masalah", "id_user", "judul", "isi", "tgl_masalah ", "selesai", "hasil"};
        String query = "SELECT * FROM forum WHERE selesai = 1  ";
        return getDatatotal(query, kolom);
    }

    public DefaultTableModel getDataforumbelum() throws SQLException {
        String kolom[] = {"id_masalah", "id_user", "judul", "isi", "tgl_masalah", "selesai", "hasil"};
        String query = "SELECT * FROM forum WHERE selesai = 0 ";
        return getDatatotal(query, kolom);
    }

    public DefaultTableModel getDataforumselesaiwithid(String id) throws SQLException {
        String kolom[] = {"id_masalah", "judul", "isi", "tgl_masalah", "selesai","hasil"};
        String query = "SELECT id_masalah, judul, isi, tgl_masalah , selesai ,hasil FROM forum WHERE id_user = " + id + " and selesai = 1 ";
        return getDatatotal(query, kolom);
    }

    public DefaultTableModel getDataforumbelumwithid(String id) throws SQLException {
        String kolom[] = {"id_masalah", "judul", "isi", "tgl_masalah", "selesai","hasil"};
        String query = "SELECT id_masalah, judul, isi, tgl_masalah , selesai ,hasil FROM forum WHERE id_user = " + id + " and selesai = 0 ";
        return getDatatotal(query, kolom);
    }

    public boolean insertDataforum(String[] data) {
        String query = "INSERT INTO `inventaris` (`id_inventaris`, `nama_barang`, `stok`) VALUES (" + data[0] + "," + data[1] + "," + data[2];
        return execute(query);
    }

    public boolean updateDataforum(String[] data) {
        String query = "UPDATE `forum` SET `judul`='" + data[0] + "',`isi`='" + data[1] + "',`selesai`= " + data[3] + " WHERE `id_masalah` = " + data[0];
        return execute(query);
    }

    public boolean updateDataforumadmin(String[] data) {
//        String query = "UPDATE `forum` SET `judul`='"+data[0]+"',`isi`='"+data[1]+"',`selesai`= "+data[3]+" , hasil = "+data[5]+" WHERE `id_masalah` = "+data[0];
System.out.println("judul = "+data[0]);
        System.out.println("isi " +data[1]);
        System.out.println("selesai "+data[3]);
        System.out.println("hasil "+data[3]);
        System.out.println("id maslah"+data[4]);
        String query = "UPDATE `forum` SET `judul`='" + data[0] + "',`isi`='" + data[1] + "', `selesai`= " + data[3] + ",`hasil`='" + data[5] + "' WHERE `id_masalah` = " + data[4];
        return execute(query);
    }

    public boolean updateVerifikasi(String id, int index) {
        System.out.println(id);
        System.out.println(index);
        String query = "UPDATE `peminjaman_inventaris` SET `id_status` = '" + index + "' WHERE id_peminjaman = '" + id + "'";
        return execute(query);
    }

    public boolean setDataforum(String[] data) throws SQLException {
        System.out.println("id user = " + data[2]);
        System.out.println("judul " + data[0]);
        System.out.println("isi " + data[1]);
        String query = "INSERT INTO `forum`(`id_user`, `judul`, `isi`, `tgl_masalah`, `selesai`) VALUES (" + data[2] + ",'" + data[0] + "','" + data[1] + "',CURRENT_DATE,0)";
        return execute(query);
    }
}
