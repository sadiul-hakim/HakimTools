package com.hakim.hakimtools.file;

import com.formdev.flatlaf.FlatLightLaf;
import com.hakim.hakimtools.util.ExcelUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Hakim
 */
public class FileConverter extends javax.swing.JFrame {

    private List<List<Object>> data = new ArrayList<>();

    /**
     * Creates new form FileConverter
     */
    public FileConverter() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        chooserBtn = new javax.swing.JButton();
        msgLabel = new javax.swing.JLabel();
        downloadBtn = new javax.swing.JButton();
        sheetName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("File Converter");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Fira Code Medium", 0, 14)); // NOI18N
        jLabel1.setText("Choose Input File");

        chooserBtn.setFont(new java.awt.Font("Fira Code", 0, 14)); // NOI18N
        chooserBtn.setText("Choose");
        chooserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooserBtnActionPerformed(evt);
            }
        });

        msgLabel.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        msgLabel.setPreferredSize(new java.awt.Dimension(200, 30));

        downloadBtn.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        downloadBtn.setText("Download");
        downloadBtn.setEnabled(false);
        downloadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadBtnActionPerformed(evt);
            }
        });

        sheetName.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53)
                        .addComponent(sheetName, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chooserBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(msgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(downloadBtn)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(chooserBtn)
                    .addComponent(sheetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(downloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(msgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooserBtnActionPerformed

        fileChooser = new JFileChooser();

        File selctedFile = null;
        int openSelection = fileChooser.showOpenDialog(null);

        if (openSelection != JFileChooser.APPROVE_OPTION) {
            return;
        } else {
            selctedFile = fileChooser.getSelectedFile();
        }

        String[] fileName = selctedFile.getName().split("\\.");
        if (!(fileName[fileName.length - 1].equals("xlsx") || fileName[fileName.length - 1].equals("xls"))) {
            return;
        }
        
        String sheetNameText = sheetName.getText();
        if(sheetNameText.isEmpty()){
            JOptionPane.showMessageDialog(null, "Sheet name can not be empty!");
            return;
        }

        data = ExcelUtil.readExcel(selctedFile.getAbsolutePath(),sheetNameText);
        msgLabel.setText("File is ready to Download.");
        downloadBtn.setEnabled(true);

    }//GEN-LAST:event_chooserBtnActionPerformed

    private void downloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadBtnActionPerformed

        if (fileChooser == null) {
            fileChooser = new JFileChooser();
        }

        File selectedFile = null;
        int selectedOption = fileChooser.showSaveDialog(null);
        if (selectedOption != JFileChooser.APPROVE_OPTION) {
            return;
        } else {
            selectedFile = fileChooser.getSelectedFile();
        }

        if (!selectedFile.exists()) {
            try {
                selectedFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        ExcelUtil.writeToCsv(data, selectedFile.getAbsolutePath());
        JOptionPane.showConfirmDialog(null, "File saved at "+ selectedFile.getAbsolutePath());
        msgLabel.setText("");
        downloadBtn.setEnabled(false);
    }//GEN-LAST:event_downloadBtnActionPerformed

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
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileConverter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooserBtn;
    private javax.swing.JButton downloadBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel msgLabel;
    private javax.swing.JTextField sheetName;
    // End of variables declaration//GEN-END:variables
    private JFileChooser fileChooser;
}
