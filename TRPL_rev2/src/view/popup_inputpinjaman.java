/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author acer
 */
public class popup_inputpinjaman extends javax.swing.JFrame {

    /**
     * Creates new form popup_inputpinjaman
     */
    public popup_inputpinjaman() {
        this.setLocationRelativeTo(this);
        initComponents();
    }

    public String[] getdata() {
        String[] data = new String[5];
        data[0] = id_inventaris.getText();
        data[1] = Jumlah.getText();
        data[2] = Durasi_Pinjam.getText();
        data[3] = IdPengguna.getText();
        return data;

    }

    public void setdata(String[] data) {
        id_peminjaman.setText("1");
        id_inventaris.setText(data[0]);
        nama.setText(data[1]);
        Date s = new Date();
        SimpleDateFormat kal = new SimpleDateFormat("yyyy-dd-MM");
        tanggal_pinjam.setText(kal.format(s));
    }
    public void setidpeminjam (String a){
        IdPengguna.setText(a);
    }
    public void simpan (ActionListener a) {
        btnSimpan.addActionListener(a);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        id_peminjaman = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        id_inventaris = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Jumlah = new javax.swing.JTextField();
        Durasi_Pinjam = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        tanggal_pinjam = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        IdPengguna = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Isikan ketentuan Berikut Ini");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 27, -1, -1));

        id_peminjaman.setEditable(false);
        getContentPane().add(id_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 60, 251, -1));

        jLabel2.setText("id peminjaman");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 62, -1, -1));

        jLabel3.setText("id_inventaris");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 62, -1, -1));

        id_inventaris.setEditable(false);
        getContentPane().add(id_inventaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 60, 143, -1));

        jLabel4.setText("Jumlah");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 141, -1, -1));
        getContentPane().add(Jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 139, 251, -1));
        getContentPane().add(Durasi_Pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 164, 251, -1));

        jLabel5.setText("Durasi Pinjam");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 166, -1, -1));

        jLabel6.setText("Tanggal Pinjam");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 218, -1, -1));

        jLabel7.setText("nama");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 93, -1, -1));

        nama.setEditable(false);
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 91, 143, -1));

        tanggal_pinjam.setEditable(false);
        getContentPane().add(tanggal_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 216, 246, -1));

        btnSimpan.setText("Simpan Peminjaman");
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 313, -1, -1));

        IdPengguna.setEditable(false);
        getContentPane().add(IdPengguna, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 91, 251, -1));

        jLabel8.setText("id_Pengguna");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 93, -1, -1));

        jLabel9.setText("pcs");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 141, -1, -1));

        jLabel10.setText("hari");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, -1));

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
            java.util.logging.Logger.getLogger(popup_inputpinjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(popup_inputpinjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(popup_inputpinjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(popup_inputpinjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new popup_inputpinjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Durasi_Pinjam;
    private javax.swing.JTextField IdPengguna;
    private javax.swing.JTextField Jumlah;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JTextField id_inventaris;
    private javax.swing.JTextField id_peminjaman;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField tanggal_pinjam;
    // End of variables declaration//GEN-END:variables
}
