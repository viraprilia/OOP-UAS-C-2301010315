package uas.oop.c.pkg2301010315;


import static uas.oop.c.pkg2301010315.dbkoneksi.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 * @author Wihelmina Aprilia
 * TGL : 28 Juni 2025
 */
public class fBuah extends javax.swing.JFrame {
    DefaultTableModel DTM = new DefaultTableModel();
    private Object cTUTUP;

    /**
     * Creates new form fBuah
     */
    public fBuah() throws SQLException {
    initComponents();

    tblbuah.setModel(DTM);
    DTM.addColumn("ID Buah");
    DTM.addColumn("Nama Buah");
    DTM.addColumn("Kategori");
    DTM.addColumn("Harga");
    DTM.addColumn("Jumlah");
    
    String[] opsikategori = {"Pilih Kategori", "Buah Import", "Buah Lokal"};
        cbkategori.removeAllItems();
       for (String item : opsikategori) {
    cbkategori.addItem(item);
}


    // Setup combobox kategori
    tampildata();
        clearForm();
        tombol(false);
        cBARU.setEnabled(true);
        cTUTUP.setEnabled(true);
        fieldAktif(false);
       
    }

    private void tampildata() {
        try {
            DTM.setRowCount(0);
            String sql = "SELECT * FROM buah";
            Connection conn = koneksi();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DTM.addRow(new Object[]{
                    rs.getString("id_buah"),
                    rs.getString("nama_buah"),
                    rs.getString("kategori"),
                    rs.getString("harga"),
                    rs.getString("jumlah")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error menampilkan data: " + ex.getMessage());
        }
    }

    private void clearForm() {
        txid.setText("");
        txnama.setText("");
        txkategori.setText("");
        txharga.setText("");
        txjumlah.setText("");
        cbkategori.setSelectedIndex(0);
    }

    private void tombol(boolean opsi) {
        cBARU.setEnabled(opsi);
        cUBAH.setEnabled(opsi);
        cHAPUS.setEnabled(opsi);
        cTUTUP.setEnabled(true);
    }

    private void fieldAktif(boolean opsi) {
        txid.setEditable(opsi);
        txnama.setEditable(opsi);
        txkategori.setEditable(opsi);
        txharga.setEditable(opsi);
        txjumlah.setEditable(opsi);
    }

    private void simpanData() {
        try {
            String sql = "INSERT INTO buah (id_buah, nama_buah, kategori, harga, jumlah) VALUES (?, ?, ?, ?, ?)";
            Connection conn = koneksi();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txid.getText());
            pst.setString(2, txnama.getText());
            pst.setString(3, txkategori.getText());
            pst.setString(4, txharga.getText());
            pst.setString(5, txjumlah.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan.");
            tampildata();
            clearForm();
            tombol(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + ex.getMessage());
        }
    }

    private void ubahData() {
        try {
            String sql = "UPDATE buah SET nama_buah=?, kategori=?, harga=?, jumlah=? WHERE id_buah=?";
            Connection conn = koneksi();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txnama.getText());
            pst.setString(2, txkategori.getText());
            pst.setString(3, txharga.getText());
            pst.setString(4, txjumlah.getText());
            pst.setString(5, txid.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil diubah.");
            tampildata();
            clearForm();
            tombol(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal mengubah data: " + ex.getMessage());
        }
    }

    private void hapusData() {
        try {
            String sql = "DELETE FROM buah WHERE id_buah=?";
            Connection conn = koneksi();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txid.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
            tampildata();
            clearForm();
            tombol(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + ex.getMessage());
        }
    }


 
    // GUI Components
    private javax.swing.JButton cBARU;
    private javax.swing.JButton cHAPUS;
    private javax.swing.JButton cSIMPAN;
    private javax.swing.JButton cUBAH;
    private javax.swing.JComboBox<String> cbkategori;
    private javax.swing.JTable tblbuah;
    private javax.swing.JTextField txid;
    private javax.swing.JTextField txnama;
    private javax.swing.JTextField txharga;
    private javax.swing.JTextField txjumlah;

    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbuah = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txnama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txkategori = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txharga = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txjumlah = new javax.swing.JTextField();
        cBARU = new javax.swing.JButton();
        cUBAH = new javax.swing.JButton();
        cHAPUS = new javax.swing.JButton();
        cTUTUP = new javax.swing.JButton();
        cbkategori = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 0));
        jLabel1.setText("DATA BUAH");

        tblbuah.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_buah", "nama_buah", "kategori", "harga", "jumlah"
            }
        ));
        jScrollPane1.setViewportView(tblbuah);

        jLabel2.setText("id_buah");

        txid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txidActionPerformed(evt);
            }
        });

        jLabel3.setText("nama_buah");

        txnama.setText(" ");
        txnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnamaActionPerformed(evt);
            }
        });

        jLabel4.setText("kategori");

        jLabel5.setText("harga");

        jLabel6.setText("jumlah");

        cBARU.setText("Baru");
        cBARU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBARUActionPerformed(evt);
            }
        });

        cUBAH.setText("Ubah");
        cUBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cUBAHActionPerformed(evt);
            }
        });

        cHAPUS.setText("Hapus");
        cHAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cHAPUSActionPerformed(evt);
            }
        });

        cTUTUP.setText("Tutup");
        cTUTUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTUTUPActionPerformed(evt);
            }
        });

        cbkategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkategoriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cBARU)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cUBAH)
                                .addGap(18, 18, 18)
                                .addComponent(cHAPUS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cTUTUP))
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbkategori, javax.swing.GroupLayout.Alignment.LEADING, 0, 322, Short.MAX_VALUE)
                                .addComponent(txjumlah, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txharga, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txkategori, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txnama, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txid, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(txid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(cbkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cBARU)
                            .addComponent(cUBAH)
                            .addComponent(cHAPUS)
                            .addComponent(cTUTUP))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txidActionPerformed

    private void txnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnamaActionPerformed

    private void cUBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cUBAHActionPerformed
         try {
             Connection cnn = koneksi(); // method koneksi() harus kamu buat
        PreparedStatement ps = cnn.prepareStatement(
            "UPDATE buah SET nama_buah = ?, kategori = ?, harga = ?, jumlah = ? WHERE id_buah = ?"
        );

        ps.setString(1, txnama.getText());
        ps.setString(2, String.valueOf(cbkategori.getSelectedItem()));
        ps.setString(3, txharga.getText());
        ps.setString(4, txjumlah.getText());
        ps.setString(5, txid.getText());

        ps.executeUpdate();
        cnn.close();

        JOptionPane.showMessageDialog(this, "Data Berhasil Diubah!");
        tampildata();
        clearForm();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal Ubah: " + e.getMessage());
    }//GEN-LAST:event_cUBAHActionPerformed

    private void cBARUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBARUActionPerformed
        try {
            Connection cnn = koneksi();
        PreparedStatement pst = cnn.prepareStatement("INSERT INTO buah VALUES (?, ?, ?, ?, ?)");
        pst.setString(1, txid.getText());
        pst.setString(2, txnama.getText());
        pst.setString(3, txkategori.getText());
        pst.setString(4, txharga.getText());
        pst.setString(5, txjumlah.getText());
        
        pst.executeUpdate();
        cnn.close();
        
        clearForm();
        tampildata();
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal Simpan: " + e.getMessage());
    }
        }
            
    }//GEN-LAST:event_cBARUActionPerformed

    private void cHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cHAPUSActionPerformed
          try {
        Connection cnn = koneksi();
        PreparedStatement pst = cnn.prepareStatement("DELETE FROM buah WHERE id_buah = ?");
        pst.setString(1, txid.getText());
        
        pst.executeUpdate();
        cnn.close();

        clearForm();
        tampildata();
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal Hapus: " + e.getMessage());
    }
        }
            
        
    }//GEN-LAST:event_cHAPUSActionPerformed

    private void cTUTUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTUTUPActionPerformed
          if (cTUTUP.getText().equals("Tutup") ){
            
            int opsi = JOptionPane.showOptionDialog(this, "Yakin akan menutup Aplikasi ?", "Konfirmasi Tutup Aplikasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(opsi==JOptionPane.YES_NO_OPTION){
            System.exit(0);
            }
            
        }else{
            cTUTUP.setText("Tutup");
            cBARU.setText("Baru");
            cUBAH.setText("Ubah");
            cBARU.setEnabled(true);
            cUBAH.setEnabled(false);
            cbkategori.setVisible(false);
            txkategori.setVisible(true);
            fieldAktif(false);
            clearForm();
        }
    }//GEN-LAST:event_cTUTUPActionPerformed
    
     private void tblbuahMouseClicked(java.awt.event.MouseEvent evt) {                                      
    int baris = tblbuah.getSelectedRow();

    txid.setText(tblbuah.getValueAt(baris, 0).toString());
    txnama.setText(tblbuah.getValueAt(baris, 1).toString());
    txkategori.setText(tblbuah.getValueAt(baris, 2).toString());
    txharga.setText(tblbuah.getValueAt(baris, 3).toString());
    txjumlah.setText(tblbuah.getValueAt(baris, 4).toString());

    fieldAktif(true);
    tombol(true); // aktifkan semua tombol
}
 
    private void cbkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkategoriActionPerformed
         String selectedKategori = String.valueOf(cbkategori.getSelectedItem());
          txkategori.setText(selectedKategori); // set isi
    txkategori.setEditable(false);        // kunci agar tidak bisa diubah manual
    }//GEN-LAST:event_cbkategoriActionPerformed
    public static void main(String args[]) {
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(fBuah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    java.awt.EventQueue.invokeLater(() -> {
        try {
            new fBuah().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(fBuah.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cBARU;
    private javax.swing.JButton cHAPUS;
    private javax.swing.JButton cTUTUP;
    private javax.swing.JButton cUBAH;
    private javax.swing.JComboBox<String> cbkategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblbuah;
    private javax.swing.JTextField txharga;
    private javax.swing.JTextField txid;
    private javax.swing.JTextField txjumlah;
    private javax.swing.JTextField txkategori;
    private javax.swing.JTextField txnama;
    // End of variables declaration//GEN-END:variables

    
   private void updateData() throws SQLException {
    Connection cnn = dbkoneksi.koneksi();  // pastikan sesuai dengan class dbkoneksi

    String id_buah = txid.getText();
    String nama_buah = txnama.getText();
    String kategori = String.valueOf(cbkategori.getSelectedItem());
    String harga = txharga.getText();
    String jumlah = txjumlah.getText();

    if (!cnn.isClosed()) {
        PreparedStatement PS = cnn.prepareStatement(
            "UPDATE buah SET nama_buah=?, kategori=?, harga=?, jumlah=? WHERE id_buah=?"
        );

        PS.setString(1, nama_buah);
        PS.setString(2, kategori);
        PS.setString(3, harga);
        PS.setString(4, jumlah);
        PS.setString(5, id_buah);

        PS.executeUpdate();
        cnn.close();

        JOptionPane.showMessageDialog(null, "Data berhasil diperbarui!");
        tampildata();
        clearForm();
    }
}

private void tampildata() {
    try {
        DTM.setRowCount(0);

        String sql = "SELECT * FROM buah";
        Connection conn = dbkoneksi.koneksi();
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            DTM.addRow(new Object[]{
                rs.getString("id_buah"),
                rs.getString("nama_buah"),
                rs.getString("kategori"),
                rs.getString("harga"),
                rs.getString("jumlah")
            });
        }

        conn.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error menampilkan data: " + ex.getMessage());
    }
}


