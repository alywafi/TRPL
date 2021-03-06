/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class view_inventaris extends javax.swing.JFrame {

    /**
     * Creates new form view_peminjaman
     */
    public view_inventaris() {
        initComponents();
    }

    public void SetName(String text) {
        Nametag.setText(text);
    }

    public void KlikBack(ActionListener a) {
        btnback.addActionListener(a);
    }

    public String Getname() {
        String name;
        name = Nametag.getText();
        return name;
    }
    public void setEditable (boolean x) {
        btnpinjam.setEnabled(x);
    }

    public void setTableModel(DefaultTableModel table) {
        this.tabel.setModel(table);
    }

    public int getSelectedRow() {
        return this.tabel.getSelectedRow();
    }

    public String GetIDTable() {
        return this.tabel.getValueAt(this.getSelectedRow(), 0).toString();
    }
// public String[] GetData() {
//        String Data[] = new String[6];
//        Data[0] = this.id_transpinjaman.getText();
//        Data[1] = this.tgl_pinjaman.getText();
//        Data[2] = this.id_nasabah.getText();
//        Data[3] = this.besar_pinjaman.getText();
//        Data[4] = clogin.datapetugas[0];
//        Data[5] = this.cicil.getText();
//        return Data;
//    }

    public void klikexit(ActionListener action) {
        tombolexit.addActionListener(action);
    }

    public void klikminimize(ActionListener action) {
        tombolminimize.addActionListener(action);
    }

    public void klikpinjam(ActionListener action) {
        btnpinjam.addActionListener(action);
    }

    public void klikcari(ActionListener action) {
        btncari.addActionListener(action);
    }

    public void klikdaftar(ActionListener action) {
        btndaftar.addActionListener(action);
    }

    public String getButtonText() {
        String text = btndaftar.getText();
        return text;
    }
    public void setButtonText(String t){
        btndaftar.setText(t);
    }

    public void message(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tombolexit = new javax.swing.JButton();
        tombolminimize = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnpinjam = new javax.swing.JButton();
        btncari = new javax.swing.JButton();
        btndaftar = new javax.swing.JButton();
        Nametag = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tombolexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Login_Close.png"))); // NOI18N
        tombolexit.setBorderPainted(false);
        tombolexit.setContentAreaFilled(false);
        tombolexit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Login_CloseMouseOver.png"))); // NOI18N
        getContentPane().add(tombolexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 50, 20));

        tombolminimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/All_Minimize.png"))); // NOI18N
        tombolminimize.setBorder(null);
        tombolminimize.setBorderPainted(false);
        tombolminimize.setContentAreaFilled(false);
        tombolminimize.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/All_MinimizeMouseOver.png"))); // NOI18N
        getContentPane().add(tombolminimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 0, -1, 20));

        tabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.setOpaque(false);
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 820, 380));

        btnpinjam.setText("pinjam barang");
        getContentPane().add(btnpinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        btncari.setText("cari");
        getContentPane().add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        btndaftar.setText("daftar pinjaman");
        getContentPane().add(btndaftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        Nametag.setFont(new java.awt.Font("Caviar Dreams", 0, 18)); // NOI18N
        Nametag.setForeground(new java.awt.Color(255, 255, 255));
        Nametag.setToolTipText("");
        getContentPane().add(Nametag, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 140, 120, 20));

        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/back.png"))); // NOI18N
        btnback.setBorder(null);
        btnback.setBorderPainted(false);
        btnback.setContentAreaFilled(false);
        btnback.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/backmouseover.png"))); // NOI18N
        getContentPane().add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/HomeAnggotaKelompok.png"))); // NOI18N
        background.setText("jLabel1");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(view_inventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_inventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_inventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_inventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_inventaris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nametag;
    private javax.swing.JLabel background;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btndaftar;
    private javax.swing.JButton btnpinjam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tombolexit;
    private javax.swing.JButton tombolminimize;
    // End of variables declaration//GEN-END:variables
}
