package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class koneksi {

    Connection con;
    Statement stm;

    public koneksi() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ikan"; //url DB
        String username = "root"; //username DB
        String pass = ""; //password DB, Jika tidak di Password silahkan di Kosongkan.

        //membuat koneksi ke DB
        this.con = (Connection) DriverManager.getConnection(url, username, pass);
        this.stm = (Statement) this.con.createStatement();
    }

    //method untuk ekesekusi query Insert, Update, dan Delete
    public void executeQuery(String query) throws SQLException {
        this.stm.execute(query);
    }
    //method untuk ekesekusi query Select
    public ResultSet getResult(String query) throws SQLException {
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }
}
