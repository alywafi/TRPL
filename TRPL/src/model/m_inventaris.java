package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class m_inventaris extends modelmaster {

    public m_inventaris() throws SQLException {
        super();
    }

    public DefaultTableModel getDatainventaris() throws SQLException {
        String kolom[] = {"id_inventaris", "nama", "banyak", "kondisi"};
        String query = "select * from inventaris;";
        return getDatatotal(query, kolom);
    }
 public boolean insertDatapeminjaman(String id) {
        String query = "INSERT INTO `peminjaman_barang` (`id_peminjaman`, `id_user`, `id_inventaris`, `tanggal`) VALUES (null, '1', '"+id+"', '2017-10-03');";
        return execute(query);
  }
 public String[] getDataWithID(String ID) throws SQLException {
        String data[] = new String[4];
        String query = "select * from inventaris where id_inventaris = " + ID + ";";
        return getdataid(query, data);
    }
}
