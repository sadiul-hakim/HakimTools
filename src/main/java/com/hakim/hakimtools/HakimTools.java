package com.hakim.hakimtools;

import com.hakim.hakimtools.audio.AudioPlayer;
import com.hakim.hakimtools.audio.AudioRecorder;
import com.hakim.hakimtools.datetime.alarm.Alarm;
import com.hakim.hakimtools.design.ColorChooser;
import com.hakim.hakimtools.drawing.Paint;
import com.hakim.hakimtools.encryption.Encryptor;
import com.hakim.hakimtools.file.FileConverter;
import com.hakim.hakimtools.file.FileReader;
import com.hakim.hakimtools.resource.Monitor;
import com.hakim.hakimtools.text.ReaderApp;
import com.hakim.hakimtools.restClient.RestClient;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.hakim.hakimtools.datetime.AgeCalculator;
import com.hakim.hakimtools.datetime.EpochTimeConverter;
import com.hakim.hakimtools.datetime.ZoneTime;
import com.hakim.hakimtools.downloader.FileDownloader;
import com.hakim.hakimtools.generator.QRCodeGeneratorUI;
import com.hakim.hakimtools.text.CommaSeparator;
import com.hakim.hakimtools.text.Counter;
import com.hakim.hakimtools.text.Finder;
import com.hakim.hakimtools.text.FinderAndReplacer;
import com.hakim.hakimtools.text.RandomTextGenerator;
import com.hakim.hakimtools.text.Separator;
import com.hakim.hakimtools.text.Sorter;

import java.awt.event.ActionEvent;
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
        restClientItem = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        resourceMenu = new javax.swing.JMenu();
        colorPicker = new javax.swing.JMenuItem();
        textMenu = new javax.swing.JMenu();
        audioMenu = new javax.swing.JMenu();
        finderItem = new javax.swing.JMenuItem();
        findAndReplaceItem = new javax.swing.JMenuItem();
        sorterItem = new javax.swing.JMenuItem();
        itemCounterItem = new javax.swing.JMenuItem();
        readerItem = new javax.swing.JMenuItem();
        uniqueItemFinder = new javax.swing.JMenuItem();
        commaSeparatorItem = new javax.swing.JMenuItem();
        randomTextGeneratorItem = new javax.swing.JMenuItem();
        internetMenu = new javax.swing.JMenu();
        downloaderItem = new javax.swing.JMenuItem();
        alarmItem = new javax.swing.JMenuItem();
        dateMenu = new javax.swing.JMenu();
        ageCalculatorItem = new javax.swing.JMenuItem();
        zonedDateTimeItem = new javax.swing.JMenuItem();
        paint = new javax.swing.JMenuItem();
        monitor = new javax.swing.JMenuItem();
        audioRecorder = new javax.swing.JMenuItem();
        audioPlayer = new javax.swing.JMenuItem();
        epochTimeItem = new javax.swing.JMenuItem();
        generatorMenu = new javax.swing.JMenu();
        qrCodeGenerator = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        lightTheme = new javax.swing.JMenuItem();
        darkTheme = new javax.swing.JMenuItem();
        draculaTheme = new javax.swing.JMenuItem();
        intelijTheme = new javax.swing.JMenuItem();
        macDarkTheme = new javax.swing.JMenuItem();
        macLightTheme = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        meItem = new javax.swing.JMenuItem();

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

        newItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newItem.setText("New");
        newItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemActionPerformed(evt);
            }
        });
        fileMenu.add(newItem);

        saveItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveItem.setText("Save");
        saveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveItem);

        openItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openItem.setText("Open");
        openItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openItemActionPerformed(evt);
            }
        });
        fileMenu.add(openItem);

        converterMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        converterMenu.setText("Converter");
        converterMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                converterMenuActionPerformed(evt);
            }
        });
        fileMenu.add(converterMenu);

        specialFileReaderItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        specialFileReaderItem.setText("Special File Reader");
        specialFileReaderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialFileReaderItemActionPerformed(evt);
            }
        });
        fileMenu.add(specialFileReaderItem);

        jMenuBar1.add(fileMenu);

        jMenu3.setText("Development");

        encryptor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        encryptor.setText("Encryptor");
        encryptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptorActionPerformed(evt);
            }
        });
        jMenu3.add(encryptor);

        restClientItem.setText("Rest Client");
        restClientItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restClientItemActionPerformed(evt);
            }
        });
        jMenu3.add(restClientItem);

        jMenuBar1.add(jMenu3);
        jMenuBar1.add(resourceMenu);

        jMenu4.setText("Design");
        resourceMenu.setText("Resource");

        colorPicker.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        colorPicker.setText("Color Picker");
        colorPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorPickerActionPerformed(evt);
            }
        });
        jMenu4.add(colorPicker);

        paint.setText("Paint");
        paint.addActionListener(this::paintActionPerformed);
        jMenu4.add(paint);

        audioPlayer.setText("Player");
        audioPlayer.addActionListener(this::playAudio);

        audioRecorder.setText("Record");
        audioRecorder.addActionListener(this::recordAudio);

        monitor.setText("Monitor");
        monitor.addActionListener(this::monitorActionPerformed);
        resourceMenu.add(monitor);

        jMenuBar1.add(jMenu4);

        textMenu.setText("Text");
        audioMenu.setText("Audio");

        audioMenu.add(audioRecorder);
        audioMenu.add(audioPlayer);

        finderItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        finderItem.setText("Find");
        finderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finderItemActionPerformed(evt);
            }
        });
        textMenu.add(finderItem);

        findAndReplaceItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        findAndReplaceItem.setText("Find/Replace");
        findAndReplaceItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findAndReplaceItemActionPerformed(evt);
            }
        });
        textMenu.add(findAndReplaceItem);

        sorterItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        sorterItem.setText("Sorter");
        sorterItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sorterItemActionPerformed(evt);
            }
        });
        textMenu.add(sorterItem);

        itemCounterItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemCounterItem.setText("Counter");
        itemCounterItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCounterItemActionPerformed(evt);
            }
        });
        textMenu.add(itemCounterItem);

        readerItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        readerItem.setText("Reader");
        readerItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readerItemActionPerformed(evt);
            }
        });
        textMenu.add(readerItem);

        uniqueItemFinder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        uniqueItemFinder.setText("Unique Item Finder");
        uniqueItemFinder.addActionListener(this::uniqueItemFinderActionPerformed);
        textMenu.add(uniqueItemFinder);

        commaSeparatorItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        commaSeparatorItem.setText("CommaSeparator");
        commaSeparatorItem.addActionListener(this::commaSeparatorItemActionPerformed);
        textMenu.add(commaSeparatorItem);

        randomTextGeneratorItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        randomTextGeneratorItem.setText("Random Text Generator");
        randomTextGeneratorItem.addActionListener(this::randomTextGeneratorItemActionPerformed);
        textMenu.add(randomTextGeneratorItem);

        jMenuBar1.add(textMenu);
        jMenuBar1.add(audioMenu);

        internetMenu.setText("Internet");

        downloaderItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        downloaderItem.setText("downloader");
        downloaderItem.addActionListener(this::downloaderItemActionPerformed);
        internetMenu.add(downloaderItem);

        alarmItem.setText("Alarm");
        dateMenu.add(alarmItem);
        alarmItem.addActionListener((e) -> {
            var alarm = new Alarm();
            alarm.setVisible(true);
        });

        jMenuBar1.add(internetMenu);

        dateMenu.setText("Date");

        ageCalculatorItem.setText("Age Calculator");
        ageCalculatorItem.addActionListener(this::ageCalculatorItemActionPerformed);
        dateMenu.add(ageCalculatorItem);

        zonedDateTimeItem.setText("Zoned Date Time");
        zonedDateTimeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zonedDateTimeItemActionPerformed(evt);
            }
        });
        dateMenu.add(zonedDateTimeItem);

        epochTimeItem.setText("Epoch Time");
        epochTimeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                epochTimeItemActionPerformed(evt);
            }
        });
        dateMenu.add(epochTimeItem);

        jMenuBar1.add(dateMenu);

        generatorMenu.setText("Generator");

        qrCodeGenerator.setText("QR Code");
        qrCodeGenerator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qrCodeGeneratorActionPerformed(evt);
            }
        });
        generatorMenu.add(qrCodeGenerator);

        jMenuBar1.add(generatorMenu);

        jMenu2.setText("Theme");

        lightTheme.setText("Light");
        lightTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lightThemeActionPerformed(evt);
            }
        });
        jMenu2.add(lightTheme);

        darkTheme.setText("Dark");
        darkTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkThemeActionPerformed(evt);
            }
        });
        jMenu2.add(darkTheme);

        draculaTheme.setText("Dracula");
        draculaTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                draculaThemeActionPerformed(evt);
            }
        });
        jMenu2.add(draculaTheme);

        intelijTheme.setText("Intelij");
        intelijTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intelijThemeActionPerformed(evt);
            }
        });
        jMenu2.add(intelijTheme);

        macDarkTheme.setText("Mac Dark");
        macDarkTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                macDarkThemeActionPerformed(evt);
            }
        });
        jMenu2.add(macDarkTheme);

        macLightTheme.setText("Mac Light");
        macLightTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                macLightThemeActionPerformed(evt);
            }
        });
        jMenu2.add(macLightTheme);

        jMenuBar1.add(jMenu2);

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
    }

    private void playAudio(ActionEvent actionEvent) {
        AudioPlayer.start();
    }

    private void recordAudio(ActionEvent actionEvent) {
        AudioRecorder.start();
    }

    private void monitorActionPerformed(ActionEvent actionEvent) {
        Monitor monitorObj = new Monitor();
        monitorObj.setTitle("Resource Monitor");
        monitorObj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        monitorObj.setVisible(true);
    }

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

    private void randomTextGeneratorItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomTextGeneratorItemActionPerformed

        RandomTextGenerator randomTextGenerator = new RandomTextGenerator();
        randomTextGenerator.setVisible(true);
    }//GEN-LAST:event_randomTextGeneratorItemActionPerformed

    private void finderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finderItemActionPerformed

        Finder finder = new Finder();
        finder.setVisible(true);
    }//GEN-LAST:event_finderItemActionPerformed

    private void zonedDateTimeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zonedDateTimeItemActionPerformed

        ZoneTime zoneTime = new ZoneTime();
        zoneTime.setVisible(true);
    }

    private void paintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zonedDateTimeItemActionPerformed

        var paint = new Paint();
        paint.setVisible(true);
    }

    private void epochTimeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_epochTimeItemActionPerformed

        EpochTimeConverter converter = new EpochTimeConverter();
        converter.setVisible(true);
    }//GEN-LAST:event_epochTimeItemActionPerformed

    private void itemCounterItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCounterItemActionPerformed

        Counter counter = new Counter();
        counter.setVisible(true);
    }//GEN-LAST:event_itemCounterItemActionPerformed

    private void ageCalculatorItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageCalculatorItemActionPerformed

        AgeCalculator ageCalculator = new AgeCalculator();
        ageCalculator.setVisible(true);
    }//GEN-LAST:event_ageCalculatorItemActionPerformed

    private void qrCodeGeneratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qrCodeGeneratorActionPerformed
        new QRCodeGeneratorUI().setVisible(true);
    }//GEN-LAST:event_qrCodeGeneratorActionPerformed

    private void lightThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lightThemeActionPerformed
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            createAndDisplay();
            this.dispose();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_lightThemeActionPerformed

    private void darkThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkThemeActionPerformed
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            createAndDisplay();
            this.dispose();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_darkThemeActionPerformed

    private void draculaThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_draculaThemeActionPerformed
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
            createAndDisplay();
            this.dispose();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_draculaThemeActionPerformed

    private void intelijThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intelijThemeActionPerformed
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            createAndDisplay();
            this.dispose();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_intelijThemeActionPerformed

    private void macDarkThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_macDarkThemeActionPerformed
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
            createAndDisplay();
            this.dispose();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_macDarkThemeActionPerformed

    private void macLightThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_macLightThemeActionPerformed
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            createAndDisplay();
            this.dispose();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_macLightThemeActionPerformed

    private void restClientItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restClientItemActionPerformed
        RestClient client = new RestClient();
        client.setVisible(true);
    }//GEN-LAST:event_restClientItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        createAndDisplay();
    }

    private static void createAndDisplay() {
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
    private javax.swing.JMenuItem ageCalculatorItem;
    private javax.swing.JMenuItem colorPicker;
    private javax.swing.JMenuItem commaSeparatorItem;
    private javax.swing.JMenuItem converterMenu;
    private javax.swing.JMenuItem darkTheme;
    private javax.swing.JMenu dateMenu;
    private javax.swing.JMenuItem alarmItem;
    private javax.swing.JMenuItem downloaderItem;
    private javax.swing.JMenuItem draculaTheme;
    private javax.swing.JMenuItem encryptor;
    private javax.swing.JMenuItem epochTimeItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem findAndReplaceItem;
    private javax.swing.JMenuItem finderItem;
    private javax.swing.JMenu generatorMenu;
    private javax.swing.JMenuItem intelijTheme;
    private javax.swing.JMenu internetMenu;
    private javax.swing.JMenuItem itemCounterItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu resourceMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem lightTheme;
    private javax.swing.JMenuItem macDarkTheme;
    private javax.swing.JMenuItem macLightTheme;
    private javax.swing.JEditorPane mainEditorArea;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem meItem;
    private javax.swing.JMenuItem newItem;
    private javax.swing.JMenuItem openItem;
    private javax.swing.JMenuItem qrCodeGenerator;
    private javax.swing.JMenuItem randomTextGeneratorItem;
    private javax.swing.JMenuItem readerItem;
    private javax.swing.JMenuItem restClientItem;
    private javax.swing.JMenuItem saveItem;
    private javax.swing.JMenuItem sorterItem;
    private javax.swing.JMenuItem specialFileReaderItem;
    private javax.swing.JMenu textMenu;
    private javax.swing.JMenuItem uniqueItemFinder;
    private javax.swing.JMenuItem zonedDateTimeItem;
    private javax.swing.JMenuItem paint;
    private javax.swing.JMenuItem monitor;
    // End of variables declaration//GEN-END:variables
    private JFileChooser fileChooser;
    private javax.swing.JMenu audioMenu;
    private javax.swing.JMenuItem audioRecorder;
    private javax.swing.JMenuItem audioPlayer;
}
