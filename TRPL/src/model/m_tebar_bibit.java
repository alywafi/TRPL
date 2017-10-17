package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class m_tebar_bibit extends modelmaster {

    public m_tebar_bibit() throws SQLException {
        super();
    }

    public DefaultTableModel getDatatebar() throws SQLException {
        String kolom[] = {"id_tebar", "id_user", "jumlah", "tanggal"};
        String query = "select * from tebar_bibit;";
        return getDatatotal(query, kolom);
    }
 public boolean insertDatatebar(String iduser,int jumlah){
        String query = "INSERT INTO `tebar_bibit` (id_tebar, id_user, jumlah, tanggal) VALUES (null, "+iduser+","+jumlah+", 'GetDate()')";
        return execute(query);
  }
 public String[] getDataWithID(String ID) throws SQLException {
        String data[] = new String[4];
        String query = "select * from tebar_bibit where id_user = " + ID + ";";
        return getdataid(query, data);
    }
}
