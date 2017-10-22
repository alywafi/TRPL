package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class m_inventaris extends modelmaster {

    public m_inventaris() throws SQLException {
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

    public String[] getDataWithID(String ID) throws SQLException {

        String data[] = new String[2];
        String query = "select `id_inventaris`,`nama_barang` from inventaris where `id_inventaris` = " + ID + ";";
        return getdataid(query, data);
    }

    public DefaultTableModel getDataDaftarPeminjaman(String ID) throws SQLException {

        String data[] = new String[4];
        String query = "select i.nama_barang, p.Jumlah, p.Durasi_Pinjam, p.Tanggal_Kembali from peminjaman_inventaris p join inventaris i on p.id_inventaris = i.id_inventaris where p.id_user = " + ID;
        return getDatatotal(query, data);
    }

    public String getIDwithData(String Nama) throws SQLException {
        String data = null;
        String query = "Select id_user from pengguna where user = '" +Nama +"'" ;
        return getdataidNoaray(query, data);
    }
    public boolean setDataPeminjaman(String[] data) throws SQLException {
        for (int i = 0; i < data.length; i++) {
        System.out.println("index ke "+(i+1)+ "  "+data[i]);
            
        }
        String query = "INSERT INTO `peminjaman_inventaris` (`id_peminjaman`, `id_user`, `id_inventaris`, `jumlah`, `tanggal_pinjam`, `tanggal_kembali`) "
                + "VALUES (NULL, '"+data[3]+"', '"+data[0]+"', '"+data[1]+"', CURRENT_DATE, (SELECT CURRENT_DATE + INTERVAL "+data[2]+" day));";
        return execute(query);
    }
}
