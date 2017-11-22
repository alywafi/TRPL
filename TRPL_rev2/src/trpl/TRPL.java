/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trpl;

import controler.CLogin;
import java.sql.SQLException;
import model.MLogin;
import view.viewLogin;

/**
 *
 * @author acer
 */
public class TRPL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        CLogin a = new CLogin(new viewLogin(), new MLogin());
    }
    
}
