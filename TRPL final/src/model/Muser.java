package model;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Muser extends modelmaster {

    public Muser() throws SQLException {
        super();
    }

    public DefaultTableModel getdatapengguna() throws SQLException {
        String kolom[] = {"id_user", "user", "password", "id_jabatan"};
        String query = "select * from pengguna;";
        return getDatatotal(query, kolom);
    }

    public boolean insertdatauserbaru(String[] data) {
        String query = "INSERT INTO `pengguna` ( `user`, `password`, `id_jabatan`) VALUES ('"+data[1]+"', '" + data[2] + "', "+data[3]+");";
        return execute(query);
    }

    public boolean updatedatauser(String[] data) throws SQLException {
        String query = "UPDATE `pengguna` SET `user`='"+data[1]+"',`password`='"+data[2]+"',`id_jabatan`="+data[3]+" WHERE id_user= "+data[0]+" ";
        return execute(query);
    }

}
