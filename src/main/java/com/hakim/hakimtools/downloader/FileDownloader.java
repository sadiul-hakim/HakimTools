package com.hakim.hakimtools.downloader;

import com.hakim.hakimtools.util.DownloadManager;
import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileDownloader extends JFrame {
    private static final String ROOT_PATH = "D:\\downloaded_files";
    private final JPanel titlePanel;
    private final JPanel bodyPanel;
    private final JLabel title;
    private final JTextField urlField;
    private final JTextField fileNameFiled;
    private final JButton button;

    public FileDownloader() {
        titlePanel = new JPanel();
        titlePanel.setBackground(new Color(16, 146, 166));
        bodyPanel = new JPanel();
        bodyPanel.setLayout(null);

        title = new JLabel("File Downloader");
        title.setFont(new Font("Fira Code", Font.PLAIN, 12));
        title.setForeground(Color.white);

        urlField = new JTextField();
        urlField.setBounds(10, 10, 230, 30);
        urlField.setToolTipText("Enter Url");

        fileNameFiled = new JTextField();
        fileNameFiled.setBounds(250, 10, 110, 30);
        fileNameFiled.setToolTipText("Enter File Name");

        button = new JButton("Download");
        button.setBounds(10, 50, 120, 30);
        button.setBackground(new Color(16, 146, 166));
        button.setForeground(Color.white);

        ExecutorService downloadService = Executors.newFixedThreadPool(4);

        button.addActionListener((e) -> {
            String filename = fileNameFiled.getText();
            String url = urlField.getText();

            try{
                Future<Boolean> downloaded = downloadService.submit(new DownloadManager(url, getRealPath(filename)));
            try {
                if (downloaded.get()) {
                    JOptionPane.showMessageDialog(null, filename + " is downloaded.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            }catch(IOException ex){
                ex.printStackTrace();
            }
        });

        downloadService.shutdown();

        titlePanel.add(title);
        bodyPanel.add(urlField);
        bodyPanel.add(fileNameFiled);
        bodyPanel.add(button);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 300);
        setResizable(false);

        setLayout(new BorderLayout());
        add(titlePanel, BorderLayout.WEST);
        add(bodyPanel);
    }

    public static void main(String[] args) {
        FileDownloader fileDownloader = new FileDownloader();

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        fileDownloader.setTitle("File Downloader");
        fileDownloader.setVisible(true);
    }

    private String getRealPath(String fileName) throws IOException {
        
        File file = new File(ROOT_PATH);
        if(file.exists()){
            boolean createNewFile = file.createNewFile();
        }
        return ROOT_PATH + File.separator + fileName;
    }
}