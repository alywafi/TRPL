package model;



import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class MBibit extends modelmaster {

    public MBibit() throws SQLException {
        super();
    }

    public DefaultTableModel getDatatebar() throws SQLException {
        String kolom[] = {"id_tebar", "nama user", "jumlah bibit", "tanggal tebar","luas kolam"};
        String query = "SELECT `id_tebar`, `user`, `jumlah`, `tanggal`, `kolam` FROM `tebar_bibit` t join pengguna p on (t.id_user=p.id_user)";
        return getDatatotal(query, kolom);
    }
    public DefaultTableModel getDatatebar(String id) throws SQLException {
        String kolom[] = {"id_tebar", "id_user", "jumlah", "tanggal","kolam"};
        String query = "select * from tebar_bibit where id_user = "+id+";";
        return getDatatotal(query, kolom);
    }
 public boolean insertDatatebar(String iduser,String jumlah,String lebarkolam){
     System.out.println("id user = "+iduser);
     System.out.println("jumlah = "+jumlah);
        String query = "INSERT INTO `tebar_bibit` ( id_user, jumlah, tanggal,kolam) VALUES (" +iduser+ "," +jumlah+ ", CURRENT_DATE,"+lebarkolam+");";
        return execute(query);
  }
 public String[] DefaultTableModel(String ID) throws SQLException {
        String data[] = new String[4];
        String query = "select * from tebar_bibit where id_user = " + ID + ";";
        return getdataid(query, data);
    }
}
