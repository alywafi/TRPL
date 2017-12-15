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
public class viewInventaris extends javax.swing.JFrame {

    /**
     * Creates new form view_peminjaman
     */
    public viewInventaris() {
        initComponents();
    }
    
    public void SetName(String text) {
        Nametag.setText(text);
    }
    
    public void KlikBack(ActionListener a) {
        btnback.addActionListener(a);
    }
    
    public String Getname() {
        return Nametag.getText();
    }
    
    public void setenablebtnpinjam(boolean x) {
        btnpinjam.setEnabled(x);
    }
    
    public void setTableModel(DefaultTableModel table) {
        this.tabel.setModel(table);
    }
    
    public int getSelectedRow() {
        return this.tabel.getSelectedRow();
    }
    
    public String[] getdata() {
        String data[] = new String[5];
        data[0] = this.tabel.getValueAt(this.getSelectedRow(), 0).toString();//idpeminjaman
        data[1] = this.tabel.getValueAt(this.getSelectedRow(), 1).toString();//nama_user
        data[2] = this.tabel.getValueAt(this.getSelectedRow(), 2).toString();//nama_barang
        data[3] = this.tabel.getValueAt(this.getSelectedRow(), 3).toString();//stock_ready
        data[4] = this.tabel.getValueAt(this.getSelectedRow(), 4).toString();//barang yg di pinjam
        return data;
    }
    
    public String GetIDTable() {
        return this.tabel.getValueAt(this.getSelectedRow(), 0).toString();
    }
    
    public String GetNamaBarang() {
        return this.tabel.getValueAt(this.getSelectedRow(), 2).toString();
    }
    
    public String GetStatusTable() {
        return this.tabel.getValueAt(this.getSelectedRow(), 4).toString();
    }
    
    public void klikexit(ActionListener action) {
        tombolexit.addActionListener(action);
    }
    
    public void klikminimize(ActionListener action) {
        tombolminimize.addActionListener(action);
    }
    
    public void klikpinjam(ActionListener action) {
        btnpinjam.addActionListener(action);
    }

    
    public void klikVerifikasipeminjaman(ActionListener action) {
        ver_peminjaman.addActionListener(action);
    }
    
    public void klikVerifikasipengembalian(ActionListener action) {
        ver_pengembalian.addActionListener(action);
    }
    
    public void klikdaftar(ActionListener action) {
        btndaftar.addActionListener(action);
    }
    public void klikselesai(ActionListener action) {
        selesai.addActionListener(action);
    }

    public void setenablepeminjaman(boolean set) {
        ver_peminjaman.setEnabled(set);
    }

    public void setenablepengembalian(boolean set) {
        ver_pengembalian.setEnabled(set);
    }
    public void setenableselesai(boolean set) {
        selesai.setEnabled(set);
    }

    public void klikverifi(ActionListener action) {
        btnverifi.addActionListener(action);
    }
    
    public void setvisiblPeminjaman(boolean set) {
        btnpinjam.setVisible(set);
        btndaftar.setVisible(set);
    }
    public void setvisibletombolverifikasi (boolean set){
     ver_peminjaman.setVisible(set);
     ver_pengembalian.setVisible(set);
        selesai.setVisible(set);
        btnverifi.setVisible(set);
    }
    public void setvisibleverifi (boolean set){
    selesai.setVisible(set);
    }
    public String getButtonText() {
        String text = btndaftar.getText();
        return text;
    }
    
    public void setButtonText(String t) {
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
        btndaftar = new javax.swing.JButton();
        Nametag = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        ver_peminjaman = new javax.swing.JButton();
        ver_pengembalian = new javax.swing.JButton();
        btnverifi = new javax.swing.JButton();
        selesai = new javax.swing.JButton();
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
        tabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 820, 380));

        btnpinjam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pinjambarang.png"))); // NOI18N
        btnpinjam.setBorderPainted(false);
        btnpinjam.setContentAreaFilled(false);
        btnpinjam.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pinjambarang_mouseover.png"))); // NOI18N
        btnpinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpinjamActionPerformed(evt);
            }
        });
        getContentPane().add(btnpinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 310, 50));

        btndaftar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/daftarpinjaman.png"))); // NOI18N
        btndaftar.setBorderPainted(false);
        btndaftar.setContentAreaFilled(false);
        btndaftar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/daftarpinjaman_mouseover.png"))); // NOI18N
        btndaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndaftarActionPerformed(evt);
            }
        });
        getContentPane().add(btndaftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, -1));

        Nametag.setFont(new java.awt.Font("Caviar Dreams", 0, 18)); // NOI18N
        Nametag.setForeground(new java.awt.Color(255, 255, 255));
        Nametag.setToolTipText("");
        getContentPane().add(Nametag, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 140, -1, -1));

        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/back.png"))); // NOI18N
        btnback.setBorder(null);
        btnback.setBorderPainted(false);
        btnback.setContentAreaFilled(false);
        btnback.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/backmouseover.png"))); // NOI18N
        getContentPane().add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        ver_peminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/verifikasipeminjaman.png"))); // NOI18N
        ver_peminjaman.setBorderPainted(false);
        ver_peminjaman.setContentAreaFilled(false);
        ver_peminjaman.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/verifikasipeminjaman_mouseover.png"))); // NOI18N
        getContentPane().add(ver_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 370, 40));

        ver_pengembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/verifikasipengembalian.png"))); // NOI18N
        ver_pengembalian.setBorderPainted(false);
        ver_pengembalian.setContentAreaFilled(false);
        ver_pengembalian.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/verifikasipengembalian_mouseover.png"))); // NOI18N
        getContentPane().add(ver_pengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 370, 40));

        btnverifi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/verifi.png"))); // NOI18N
        btnverifi.setBorderPainted(false);
        btnverifi.setContentAreaFilled(false);
        btnverifi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/verifi_mouseover.png"))); // NOI18N
        getContentPane().add(btnverifi, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, 180, 40));

        selesai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/selesai.png"))); // NOI18N
        selesai.setBorderPainted(false);
        selesai.setContentAreaFilled(false);
        selesai.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/selesai_mouseover.png"))); // NOI18N
        getContentPane().add(selesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(973, 200, 180, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/HomeAnggotaKelompok.png"))); // NOI18N
        background.setText("jLabel1");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnpinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpinjamActionPerformed

    private void btndaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndaftarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndaftarActionPerformed

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
            java.util.logging.Logger.getLogger(viewInventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewInventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewInventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewInventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewInventaris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nametag;
    private javax.swing.JLabel background;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btndaftar;
    private javax.swing.JButton btnpinjam;
    private javax.swing.JButton btnverifi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton selesai;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tombolexit;
    private javax.swing.JButton tombolminimize;
    private javax.swing.JButton ver_peminjaman;
    private javax.swing.JButton ver_pengembalian;
    // End of variables declaration//GEN-END:variables
}