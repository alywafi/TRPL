package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class MInventaris extends modelmaster {

    public MInventaris() throws SQLException {
        super();
    }

    public DefaultTableModel getDatainventaris() throws SQLException {
        String kolom[] = {"id_inventaris", "nama", "Stok Total", "Tersedia"};
        String query = "select * from inventaris;";
        return getDatatotal(query, kolom);
    }

    public boolean insertDatapeminjaman(String id) {
        String query = "INSERT INTO `peminjaman_barang` (`id_peminjaman`, `id_user`, `id_inventaris`, `tanggal`) VALUES (null, 1, " + id + ", '2017-10-03');";
        return execute(query);
    }

    public boolean insertDataInventaris(String[] data) {
//        String query = "INSERT INTO `inventaris` ( `id_inventaris` , `nama_barang` , `stok` ) VALUES ( "+data[0]+" , '"+data[1] +"' , " + data[2] +");" ;
        String query = "INSERT INTO `inventaris`(`id_inventaris`, `nama_barang`, `Stok`, `Stok_Ready`) VALUES (null,'" + data[1] + "'," + data[2] + "," + data[2] + ")";
        return execute(query);
    }

    public boolean updateDataInventaris(String[] data) throws SQLException {
        String query = "UPDATE `inventaris` SET `nama_barang`='" + data[1] + "',`Stok`= " + data[2] + ",`Stok_Ready`=" + data[3] + " WHERE `id_inventaris`= " + data[0] + ";";
return execute(query);
    }

    public boolean updateVerifikasi(String id, int index, String operasi, String namabarang) throws SQLException {
        boolean hasil = false;
        System.out.println("ind "+id);
        String query = "UPDATE `peminjaman_inventaris` SET `id_status` = " + index + " WHERE id_peminjaman = '" + id + "'";
        String query2 = "UPDATE `inventaris` SET `Stok_Ready`= Stok_Ready"+operasi+" WHERE nama_barang = '"+ namabarang + "'" ;
        if (execute(query2) == true) {
            hasil = execute(query);
        }
        return hasil;
    }

    public String[] getDataWithID(String ID) throws SQLException {

        String data[] = new String[2];
        String query = "select `id_inventaris`,`nama_barang` from inventaris where `id_inventaris` = " + ID + ";";
        return getdataid(query, data);
    }
    public String getStatusWithID(String ID) throws SQLException {

        String data = null;
        String query = "select `status` from status_peminjaman s join peminjaman_inventaris p on s.id_status = p.id_status where `p.id_peminjaman` = " + ID + ";";
        return getdataidNoaray(query, data);
    }

    public DefaultTableModel getDataDaftarPeminjaman(String ID) throws SQLException {

        String data[] = {"id_peminjaman","nama_barang","jumlah","tanggal_kembali", "status"};
String query = "SELECT `id_peminjaman`, `nama_barang`, `jumlah`,`tanggal_kembali`, `status` FROM `peminjaman_inventaris` p join status_peminjaman s on (p.id_status=s.id_status) join inventaris i on (p.id_inventaris=i.id_inventaris) WHERE `id_user` = "+ID;
        return getDatatotal(query, data);
    }

    public DefaultTableModel getDataDaftarPeminjamantotal() throws SQLException {

        String data[] = {"id_peminjaman", "nama_user", "nama_barang", "stock_ready", "barang yg di pinjam"};
        String query = "SELECT `id_peminjaman`, `user`, `nama_barang`, `stok_ready`, `jumlah`, `status` FROM `peminjaman_inventaris` p join inventaris i on (p.id_inventaris=i.id_inventaris) join status_peminjaman s on (p.id_status=s.id_status) join pengguna pe on (p.id_user=pe.id_user)";
        return getDatatotal(query, data);
    }
    public DefaultTableModel getDataDaftarPeminjamanbelumterverifikasi() throws SQLException {

        String data[] = {"id_peminjaman", "nama_user", "nama_barang", "stock_ready", "barang yg di pinjam"};
        String query = "SELECT `id_peminjaman`, `user`, `nama_barang`, `stok_ready`, `jumlah`, `status` FROM `peminjaman_inventaris` p join inventaris i on "
                + "(p.id_inventaris=i.id_inventaris) join status_peminjaman s on (p.id_status=s.id_status) join pengguna pe on (p.id_user=pe.id_user) where p.id_status=1";
        return getDatatotal(query, data);
    }
    public DefaultTableModel getDataDaftarPeminjamanterverifikasi() throws SQLException {

        String data[] = {"id_peminjaman", "nama_user", "nama_barang", "stock_ready", "barang yg di pinjam"};
        String query = "SELECT `id_peminjaman`, `user`, `nama_barang`, `stok_ready`, `jumlah`, `status` FROM `peminjaman_inventaris` p join inventaris i on (p.id_inventaris=i.id_inventaris) "
                + "join status_peminjaman s on (p.id_status=s.id_status) join pengguna pe on (p.id_user=pe.id_user) where p.id_status = 2";
        return getDatatotal(query, data);
    }
    public DefaultTableModel getDataDaftarPeminjamanselesai() throws SQLException {

        String data[] = {"id_peminjaman", "nama_user", "nama_barang", "stock_ready", "barang yg di pinjam"};
        String query = "SELECT `id_peminjaman`, `user`, `nama_barang`, `stok_ready`, `jumlah`, `status` FROM `peminjaman_inventaris` p join inventaris i on "
                + "(p.id_inventaris=i.id_inventaris) join status_peminjaman s on (p.id_status=s.id_status) join pengguna pe on (p.id_user=pe.id_user) where p.id_status = 3 ";
        return getDatatotal(query, data);
    }
    public DefaultTableModel getDataDaftarPeminjamangagal() throws SQLException {

        String data[] = {"id_peminjaman", "nama_user", "nama_barang", "stock_ready", "barang yg di pinjam"};
        String query = "SELECT `id_peminjaman`, `user`, `nama_barang`, `stok_ready`, `jumlah`, `status` FROM `peminjaman_inventaris` p join inventaris i on "
                + "(p.id_inventaris=i.id_inventaris) join status_peminjaman s on (p.id_status=s.id_status) join pengguna pe on (p.id_user=pe.id_user) where status=4";
        return getDatatotal(query, data);
    }

    public boolean setDataPeminjaman(String[] data) throws SQLException {
        String query = "INSERT INTO `peminjaman_inventaris` (`id_peminjaman`, `id_user`, `id_inventaris`, `jumlah`, `tanggal_pinjam`, `tanggal_kembali`) "
                + "VALUES (NULL, '" + data[3] + "', '" + data[0] + "', '" + data[1] + "', CURRENT_DATE, (SELECT CURRENT_DATE + INTERVAL " + data[2] + " day));";
        return execute(query);
    }
}
