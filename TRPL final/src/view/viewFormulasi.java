/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class viewFormulasi extends javax.swing.JFrame {

    /**
     * Creates new form view_peminjaman
     */
    public viewFormulasi() {
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

    public void klikRamal(ActionListener action) {
        btnHitung.addActionListener(action);
    }

    public double getDataBasal() {
        boolean[] basal = new boolean[9];

        double koefbasal[] = {7.8, 13.8, 15, 13.86, 14.10, 13.03, 4.23, 12, 3.97};
        int countbasal = 0;

        basal[0] = jCheckBox1.isSelected();
        basal[1] = jCheckBox2.isSelected();
        basal[2] = jCheckBox3.isSelected();
        basal[3] = jCheckBox4.isSelected();
        basal[4] = jCheckBox5.isSelected();
        basal[5] = jCheckBox6.isSelected();
        basal[6] = jCheckBox7.isSelected();
        basal[7] = jCheckBox8.isSelected();
        basal[8] = jCheckBox9.isSelected();
        for (int i = 0; i < 9; i++) {
            if (basal[i] == true) {
                countbasal++;
            }
        }
        if (countbasal == 0) {
            return countbasal;
        } else {

            int count = 0;
            double[] DataBasal = new double[countbasal];
            for (int i = 0; i < 9; i++) {
                if (basal[i] == true) {
                    DataBasal[count] = koefbasal[i];
                    count++;

                }
            }
            double datafix = 0;
            for (int i = 0; i < DataBasal.length; i++) {
                datafix += DataBasal[i];
            }
            return datafix / DataBasal.length;
        }

    }

    public String[] getDataBasalterpilih() {
        boolean[] basal = new boolean[9];

        String koefbasal[] = {"Tepung Jagung", "Dedak", "Bungkil Kelapa Sawit", "Ampas Tahu", "Daun Lamtoro", "Enceng Gondok", "Tepung sagu", "Tepung tulang", "Kelit Kepiting"};
        int countbasal = 0;

        basal[0] = jCheckBox1.isSelected();
        basal[1] = jCheckBox2.isSelected();
        basal[2] = jCheckBox3.isSelected();
        basal[3] = jCheckBox4.isSelected();
        basal[4] = jCheckBox5.isSelected();
        basal[5] = jCheckBox6.isSelected();
        basal[6] = jCheckBox7.isSelected();
        basal[7] = jCheckBox8.isSelected();
        basal[8] = jCheckBox9.isSelected();
        for (int i = 0; i < 9; i++) {
            if (basal[i] == true) {
                countbasal++;
            }
        }
        String[] DataBasal = new String[countbasal];
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (basal[i] == true) {
                DataBasal[count] = koefbasal[i];
                count++;

            }
        }

        return DataBasal;

    }

    public double getDataSuplement() {
        boolean[] suplement = new boolean[10];
        double koefsuplement[] = {41.7, 27.6, 40.20, 20.5, 24.2, 43.9, 60.9, 41.7, 80.1, 52.76};
        int countsuplement = 0;

        suplement[0] = jCheckBox11.isSelected();
        suplement[1] = jCheckBox12.isSelected();
        suplement[2] = jCheckBox13.isSelected();
        suplement[3] = jCheckBox14.isSelected();
        suplement[4] = jCheckBox15.isSelected();
        suplement[5] = jCheckBox16.isSelected();
        suplement[6] = jCheckBox17.isSelected();
        suplement[7] = jCheckBox18.isSelected();
        suplement[8] = jCheckBox19.isSelected();
        suplement[9] = jCheckBox20.isSelected();
        for (int i = 0; i < 10; i++) {
            if (suplement[i] == true) {
                countsuplement++;
            }
        }
        if (countsuplement == 0) {
            return countsuplement;
        } else {
            int count = 0;
            double[] Datasupp = new double[countsuplement];
            for (int i = 0; i < 10; i++) {
                if (suplement[i] == true) {
                    Datasupp[count] = koefsuplement[i];
                    count++;

                }
            }
            double datafix = 0;
            for (int i = 0; i < Datasupp.length; i++) {
                datafix += Datasupp[i];
            }
            return datafix / Datasupp.length;
        }
    }

    public String[] getDataSuplementterpilih() {
        boolean[] suplement = new boolean[10];
        String koefsuplement[] = {"Bungkil Kedelai", "Daun/Buah Singkong", "Bungkil Kacang Tanah", "Bungkil Kelapa Kopra", "Kacang Hijau", "Tepung Ikan", "Tepung daging Bekicot", "Tepung Cangkang Udang", "Tepung darah Ternak", "Tepung Keong Mas"};
        int countsuplement = 0;

        suplement[0] = jCheckBox11.isSelected();
        suplement[1] = jCheckBox12.isSelected();
        suplement[2] = jCheckBox13.isSelected();
        suplement[3] = jCheckBox14.isSelected();
        suplement[4] = jCheckBox15.isSelected();
        suplement[5] = jCheckBox16.isSelected();
        suplement[6] = jCheckBox17.isSelected();
        suplement[7] = jCheckBox18.isSelected();
        suplement[8] = jCheckBox19.isSelected();
        suplement[9] = jCheckBox20.isSelected();
        for (int i = 0; i < 10; i++) {
            if (suplement[i] == true) {
                countsuplement++;
            }
        }
        String[] Datasupp = new String[countsuplement];
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (suplement[i] == true) {
                Datasupp[count] = koefsuplement[i];
                count++;

            }
        }

        return Datasupp;

    }

    public int getProtein() {
        int pro = 0;
        if (jComboBox1.getSelectedIndex() == 0) {
            pro = 22;
        } else if (jComboBox1.getSelectedIndex() == 1) {
            pro = 28;
        } else {
            pro = 32;
        }
        return pro;
    }

    public int getBobot() {
        int bobot ;
        if (InputBobot.getText().isEmpty() ) {
            bobot = 0;
        } else {
            try {
            bobot = Integer.valueOf(InputBobot.getText());
            } catch (NumberFormatException a) {
               bobot = 0 ; 
            }
        }
        return bobot;
    }

    public JButton getHitung() {
        return btnHitung;
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
        Nametag = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        btnHitung = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox<>();
        InputBobot = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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

        btnHitung.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHitung.setText("Hitung Formula");
        getContentPane().add(btnHitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 620, 170, 50));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("Tepung Jagung = 7.8");
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Dedak = 13.8");
        getContentPane().add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("Bungkil Kelapa Sawit = 15");
        getContentPane().add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setText("Ampas Tahu = 13.86");
        getContentPane().add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("Daun Lamtoro = 14.1");
        getContentPane().add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("Enceng Gondok = 13.03");
        getContentPane().add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));

        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setText("Tepung Sagu = 4.23");
        getContentPane().add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, -1, -1));

        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("Tepung Tulang = 12");
        getContentPane().add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, -1, -1));

        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setText("Kulit Kepiting = 3.97");
        getContentPane().add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, -1));

        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setText("Bungkil kedelai = 41.7");
        getContentPane().add(jCheckBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        jCheckBox12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox12.setText("Daun / Buah Singkong = 27.6");
        getContentPane().add(jCheckBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, -1, -1));

        jCheckBox13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox13.setText("Bungkil kacang Tanah = 40.2");
        getContentPane().add(jCheckBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, -1, -1));

        jCheckBox14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox14.setText("Bungkil kelapa Kopra = 20.5");
        getContentPane().add(jCheckBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, -1, -1));

        jCheckBox15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox15.setText("Kacang Hijau = 24.2");
        getContentPane().add(jCheckBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, -1, -1));

        jCheckBox16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox16.setText("Tepung Ikan = 43.9");
        getContentPane().add(jCheckBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, -1, -1));

        jCheckBox17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox17.setText("Tepung Daging Bekicot = 60.9");
        getContentPane().add(jCheckBox17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, -1, -1));

        jCheckBox18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox18.setText("Tepung Cangkang Udang = 41.7");
        getContentPane().add(jCheckBox18, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, -1, -1));

        jCheckBox19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox19.setText("Tepung Darah ternak = 80.1");
        getContentPane().add(jCheckBox19, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, -1, -1));

        jCheckBox20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox20.setText("Tepung Keong Mas = 52.76");
        getContentPane().add(jCheckBox20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 580, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Protein Rendah (22%)", "Protein Sedang (28%)", "Protein Tinggi (32%)" }));
        jComboBox1.setToolTipText("");
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, -1, -1));

        InputBobot.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(InputBobot, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 460, 250, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Bahan Baku Basal");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Bahan Baku Supplement");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Tingkat Protein");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Jumlah Yang Diinginkan");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 420, -1, -1));

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
            java.util.logging.Logger.getLogger(viewFormulasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewFormulasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewFormulasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewFormulasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new viewFormulasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField InputBobot;
    private javax.swing.JLabel Nametag;
    private javax.swing.JLabel background;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnback;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton tombolexit;
    private javax.swing.JButton tombolminimize;
    // End of variables declaration//GEN-END:variables
}
