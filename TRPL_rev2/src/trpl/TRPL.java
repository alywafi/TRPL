/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trpl;

import controler.c_login;
import java.sql.SQLException;
import model.m_login;
import view.login;

/**
 *
 * @author acer
 */
public class TRPL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        c_login a = new c_login(new login(), new m_login());
    }
    
}
