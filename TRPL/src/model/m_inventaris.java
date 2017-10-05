
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class m_inventaris {

    private koneksi con;

    public DefaultTableModel getDatatotal(String query, String kolom[]) throws SQLException {
        DefaultTableModel table = new DefaultTableModel(null, kolom);
        ResultSet rs = con.getResult(query);
        while (rs.next()) {
            String row[] = new String[kolom.length];
            for (int i = 0; i < row.length; i++) {
                row[i] = rs.getString(i + 1);
            }
            table.addRow(row);
        }
        return table;
    }

    public DefaultTableModel getDatainventaris() throws SQLException {
        String kolom[] = {"id_inventaris", "nama", "banyak", "kondisi"};
        String query = "SELECT * from inventaris;";
        return getDatatotal(query, kolom);
    }

}
