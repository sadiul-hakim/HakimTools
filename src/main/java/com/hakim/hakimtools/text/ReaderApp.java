package com.hakim.hakimtools.text;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ReaderApp extends JFrame {
    private final String SCRIPT_TEXT = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('%s')\"\n";

    private final JPanel mainPanel;
    private final JTextPane textPane;
    private final JButton readButton;
    private final JButton clearButton;
    private final JScrollPane scrollPane;


    public ReaderApp(){
        mainPanel = new JPanel(null);
        textPane = new JTextPane();
        readButton = new JButton("Read");
        clearButton = new JButton("Clear");
        scrollPane = new JScrollPane(textPane);

        scrollPane.setBounds(20,20,550,300);
        textPane.setBounds(0,0,550,300);
        textPane.setFont(new Font("Fira Code",Font.PLAIN,14));

        readButton.setBounds(20,350,100,40);
        clearButton.setBounds(150,350,100,40);

        readButton.setFont(new Font("Fira Code",Font.PLAIN,14));
        clearButton.setFont(new Font("Fira Code",Font.PLAIN,14));

        readButton.addActionListener(e->{
            read();
        });

        clearButton.addActionListener(e->{
            clear();
        });

        mainPanel.add(readButton);
        mainPanel.add(clearButton);
        mainPanel.add(scrollPane);
        add(mainPanel);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600,450);
        setResizable(false);
    }

    public static void main(String[] args) {
        
        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        }catch(Exception ex){
            ex.printStackTrace();
        }

        ReaderApp readerApp = new ReaderApp();
        readerApp.setTitle("Reader App");
        readerApp.setVisible(true);
    }

    private void read(){
        String text = textPane.getText();
        String formattedScript = String.format(SCRIPT_TEXT, text);

        try {
            Runtime.getRuntime().exec(formattedScript);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void clear(){
        textPane.setText("");
    }
}
