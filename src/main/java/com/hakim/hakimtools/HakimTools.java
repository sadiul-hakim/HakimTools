package com.hakim.hakimtools;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.hakim.hakimtools.downloader.FileDownloader;
import com.hakim.hakimtools.text.CommaSeparator;
import com.hakim.hakimtools.text.FinderAndReplacer;
import com.hakim.hakimtools.text.Separator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.xmlbeans.ResourceLoader;

/**
 *
 * @author Hakim
 */
public class HakimTools extends javax.swing.JFrame {

    /**
     * Creates new form HakimTools
     */
    public HakimTools() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainEditorArea = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newItem = new javax.swing.JMenuItem();
        saveItem = new javax.swing.JMenuItem();
        openItem = new javax.swing.JMenuItem();
        converterMenu = new javax.swing.JMenuItem();
        specialFileReaderItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        encryptor = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        colorPicker = new javax.swing.JMenuItem();
        textMenu = new javax.swing.JMenu();
        uniqueItemFinder = new javax.swing.JMenuItem();
        findAndReplaceItem = new javax.swing.JMenuItem();
        sorterItem = new javax.swing.JMenuItem();
        readerItem = new javax.swing.JMenuItem();
        commaSeparatorItem = new javax.swing.JMenuItem();
        internetMenu = new javax.swing.JMenu();
        downloaderItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        meItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hakim - Tools");
        setLocationByPlatform(true);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        mainEditorArea.setFont(new java.awt.Font("Fira Code", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(mainEditorArea);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );

        fileMenu.setText("File");

        newItem.setText("New");
        newItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemActionPerformed(evt);
            }
        });
        fileMenu.add(newItem);

        saveItem.setText("Save");
        saveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveItem);

        openItem.setText("Open");
        openItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openItemActionPerformed(evt);
            }
        });
        fileMenu.add(openItem);

        converterMenu.setText("Converter");
        converterMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                converterMenuActionPerformed(evt);
            }
        });
        fileMenu.add(converterMenu);

        specialFileReaderItem.setText("Special File Reader");
        specialFileReaderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialFileReaderItemActionPerformed(evt);
            }
        });
        fileMenu.add(specialFileReaderItem);

        jMenuBar1.add(fileMenu);

        jMenu3.setText("Development Tools");

        encryptor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        encryptor.setText("Encryptor");
        encryptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptorActionPerformed(evt);
            }
        });
        jMenu3.add(encryptor);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Design Tools");

        colorPicker.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        colorPicker.setText("Color Picker");
        colorPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorPickerActionPerformed(evt);
            }
        });
        jMenu4.add(colorPicker);

        jMenuBar1.add(jMenu4);

        textMenu.setText("Text");

        uniqueItemFinder.setText("Unique Item Finder");
        uniqueItemFinder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uniqueItemFinderActionPerformed(evt);
            }
        });
        textMenu.add(uniqueItemFinder);

        findAndReplaceItem.setText("Find/Replace");
        findAndReplaceItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findAndReplaceItemActionPerformed(evt);
            }
        });
        textMenu.add(findAndReplaceItem);

        sorterItem.setText("Sorter");
        sorterItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sorterItemActionPerformed(evt);
            }
        });
        textMenu.add(sorterItem);

        readerItem.setText("Reader");
        readerItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readerItemActionPerformed(evt);
            }
        });
        textMenu.add(readerItem);

        commaSeparatorItem.setText("CommaSeparator");
        commaSeparatorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commaSeparatorItemActionPerformed(evt);
            }
        });
        textMenu.add(commaSeparatorItem);

        jMenuBar1.add(textMenu);

        internetMenu.setText("Internet");

        downloaderItem.setText("downloader");
        downloaderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloaderItemActionPerformed(evt);
            }
        });
        internetMenu.add(downloaderItem);

        jMenuBar1.add(internetMenu);

        jMenu1.setText("About");

        meItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        meItem.setText("Me");
        meItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meItemActionPerformed(evt);
            }
        });
        jMenu1.add(meItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meItemActionPerformed

        Me me = new Me();
        me.setVisible(true);
    }//GEN-LAST:event_meItemActionPerformed

    private void colorPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorPickerActionPerformed

        ColorChooser chooser = new ColorChooser();
        chooser.setVisible(true);
    }//GEN-LAST:event_colorPickerActionPerformed

    private void encryptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptorActionPerformed

        Encryptor encryptorClass = new Encryptor();
        encryptorClass.setVisible(true);
    }//GEN-LAST:event_encryptorActionPerformed

    private void uniqueItemFinderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uniqueItemFinderActionPerformed

        Separator separator = new Separator();
        separator.setVisible(true);
    }//GEN-LAST:event_uniqueItemFinderActionPerformed

    private void findAndReplaceItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findAndReplaceItemActionPerformed

        FinderAndReplacer finderAndReplacer = new FinderAndReplacer();
        finderAndReplacer.setVisible(true);
    }//GEN-LAST:event_findAndReplaceItemActionPerformed

    private void downloaderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloaderItemActionPerformed

        FileDownloader fileDownloader = new FileDownloader();
        fileDownloader.setVisible(true);
    }//GEN-LAST:event_downloaderItemActionPerformed

    private void sorterItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sorterItemActionPerformed

        Sorter sorter = new Sorter();
        sorter.setVisible(true);
    }//GEN-LAST:event_sorterItemActionPerformed

    private void readerItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readerItemActionPerformed

        ReaderApp readerApp = new ReaderApp();
        readerApp.setVisible(true);
    }//GEN-LAST:event_readerItemActionPerformed

    private void commaSeparatorItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commaSeparatorItemActionPerformed

        CommaSeparator commaSeparator = new CommaSeparator();
        commaSeparator.setVisible(true);
    }//GEN-LAST:event_commaSeparatorItemActionPerformed

    private void converterMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_converterMenuActionPerformed

        FileConverter fileConverter = new FileConverter();
        fileConverter.setVisible(true);
    }//GEN-LAST:event_converterMenuActionPerformed

    private void specialFileReaderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialFileReaderItemActionPerformed

        FileReader fileReader = new FileReader();
        fileReader.setVisible(true);
    }//GEN-LAST:event_specialFileReaderItemActionPerformed

    private void newItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemActionPerformed

        mainEditorArea.setText("");
    }//GEN-LAST:event_newItemActionPerformed

    private void saveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemActionPerformed

        if (fileChooser == null) {
            fileChooser = new JFileChooser();
        }

        File selctedFile = null;
        int openSelection = fileChooser.showOpenDialog(null);

        if (openSelection != JFileChooser.APPROVE_OPTION) {
            return;
        } else {
            selctedFile = fileChooser.getSelectedFile();
        }

        if (!selctedFile.exists()) {
            try {
                boolean createNewFile = selctedFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(HakimTools.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String text = mainEditorArea.getText();
        try {
            Files.write(selctedFile.toPath(), text.getBytes(), StandardOpenOption.WRITE);
        } catch (IOException ex) {
            Logger.getLogger(HakimTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveItemActionPerformed

    private void openItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openItemActionPerformed
        
        if (fileChooser == null) {
            fileChooser = new JFileChooser();
        }

        File selctedFile = null;
        int openSelection = fileChooser.showOpenDialog(null);

        if (openSelection != JFileChooser.APPROVE_OPTION) {
            return;
        } else {
            selctedFile = fileChooser.getSelectedFile();
        }
        
        try {
            
            String readString = Files.readString(selctedFile.toPath());
            mainEditorArea.setText(readString);
        } catch (IOException ex) {
            Logger.getLogger(HakimTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_openItemActionPerformed

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
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                HakimTools frame = new HakimTools();
                
                ClassLoader classLoader = ResourceLoader.class.getClassLoader();
                InputStream resourceAsStream = classLoader.getResourceAsStream("img/tools.png");
                ImageIcon frameIcon = new ImageIcon(resourceAsStream.readAllBytes());
                
                frame.setIconImage(frameIcon.getImage());
                frame.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(HakimTools.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem colorPicker;
    private javax.swing.JMenuItem commaSeparatorItem;
    private javax.swing.JMenuItem converterMenu;
    private javax.swing.JMenuItem downloaderItem;
    private javax.swing.JMenuItem encryptor;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem findAndReplaceItem;
    private javax.swing.JMenu internetMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane mainEditorArea;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem meItem;
    private javax.swing.JMenuItem newItem;
    private javax.swing.JMenuItem openItem;
    private javax.swing.JMenuItem readerItem;
    private javax.swing.JMenuItem saveItem;
    private javax.swing.JMenuItem sorterItem;
    private javax.swing.JMenuItem specialFileReaderItem;
    private javax.swing.JMenu textMenu;
    private javax.swing.JMenuItem uniqueItemFinder;
    // End of variables declaration//GEN-END:variables
    private JFileChooser fileChooser;
}
