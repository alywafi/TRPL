/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class viewHasilPeramalan extends javax.swing.JFrame {

    /**
     * Creates new form view_peminjaman
     */
    public viewHasilPeramalan() {
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
    public JTable tablePanen (){
        return tableHasilPanen ;
    }
    public JTable tableKebutuhamPemeliharaan (){
        return tableKebutuhanPemeliharaan ;
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
        Nametag = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHasilPanen = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKebutuhanPemeliharaan = new javax.swing.JTable();
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

        tableHasilPanen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableHasilPanen.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableHasilPanen);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Hasil Panen Lele", jPanel1);

        tableKebutuhanPemeliharaan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableKebutuhanPemeliharaan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableKebutuhanPemeliharaan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Kebutuhan Pemeliharaan", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 1140, 450));

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
            java.util.logging.Logger.getLogger(viewHasilPeramalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewHasilPeramalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewHasilPeramalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewHasilPeramalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new viewHasilPeramalan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nametag;
    private javax.swing.JLabel background;
    private javax.swing.JButton btnback;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableHasilPanen;
    private javax.swing.JTable tableKebutuhanPemeliharaan;
    private javax.swing.JButton tombolexit;
    private javax.swing.JButton tombolminimize;
    // End of variables declaration//GEN-END:variables
}
