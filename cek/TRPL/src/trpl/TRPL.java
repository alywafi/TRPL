/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trpl;

import java.sql.SQLException;

/**
 *
 * @author acer
 */
public class TRPL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        controler.c_login a = new controler.c_login(new view.login(),new model.m_login());
    }
    
}
