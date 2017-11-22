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
//        String row [] = {"stok","stok_ready"};
//        String queryb = " select stok, stok_ready from inventaris where id_inventaris = "+ data[0] ;
//        String a[] = getdataid(queryb, row);
//        int stok = Integer.valueOf(a[0]) + Integer.valueOf(data [2]);
//        int stok_Ready = Integer.valueOf(a[1]) + Integer.valueOf(data [2]);
            String query = "UPDATE `inventaris` SET `nama_barang`='"+data[1]+"',`Stok`= "+data[2]+",`Stok_Ready`="+data[3]+" WHERE `id_inventaris`= "+data[0]+";";
////        String query = "UPDATE `inventaris` SET `nama_barang`='obeng',`Stok`=100,`Stok_Ready`=100 WHERE `id_inventaris`=1";
        return execute(query);
    }

    public boolean updateVerifikasi(String id, int index) throws SQLException {
        String query = "UPDATE `peminjaman_inventaris` SET `id_status` = '" + index + "' WHERE id_peminjaman = '" + id + "'";
        String querya = "select id_status from peminjaman_inventaris where id_peminjaman = " + id + "'";
        if (index==5 ) {
            
        }else if (index == 1) {
            
        }else {
            
        }
        return execute(query);
    }

    public String[] getDataWithID(String ID) throws SQLException {

        String data[] = new String[2];
        String query = "select `id_inventaris`,`nama_barang` from inventaris where `id_inventaris` = " + ID + ";";
        return getdataid(query, data);
    }

    public DefaultTableModel getDataDaftarPeminjaman(String ID) throws SQLException {

        String data[] = new String[4];
        String query = "SELECT * FROM `peminjaman_inventaris` WHERE `id_user` = " + ID;
        return getDatatotal(query, data);
    }

    public DefaultTableModel getDataDaftarPeminjaman() throws SQLException {

        String data[] = new String[5];
        String query = "select id_peminjaman, id_inventaris,id_user,tanggal_kembali,s.status from peminjaman_inventaris p join status_peminjaman s on s.id_status = p.id_status";
        return getDatatotal(query, data);
    }

    public boolean setDataPeminjaman(String[] data) throws SQLException {
        for (int i = 0; i < data.length; i++) {

        }
        String query = "INSERT INTO `peminjaman_inventaris` (`id_peminjaman`, `id_user`, `id_inventaris`, `jumlah`, `tanggal_pinjam`, `tanggal_kembali`) "
                + "VALUES (NULL, '" + data[3] + "', '" + data[0] + "', '" + data[1] + "', CURRENT_DATE, (SELECT CURRENT_DATE + INTERVAL " + data[2] + " day));";
        return execute(query);
    }
}
