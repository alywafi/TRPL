/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import view.viewadmin;

/**
 *
 * @author acer
 */
public class c_viewadmin {

    viewadmin view;

    public c_viewadmin(viewadmin view) {
        this.view = view;
        view.setVisible(true);
    }
}
