package com.hakim.hakimtools.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AudioPlayer {

    private Clip audioClip;
    private AudioInputStream audioStream;
    private boolean isPlaying = false;
    private boolean isPaused = false;

    private JButton playButton;
    private JButton pauseButton;
    private JButton resumeButton;

    public static void start() {
        SwingUtilities.invokeLater(() -> new AudioPlayer().createGUI());
    }

    public void createGUI() {

        // Set up the main JFrame
        JFrame frame = new JFrame("Audio Player");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);

        // Create components
        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        resumeButton = new JButton("Resume");
        JButton fileChooserButton = new JButton("Choose Audio File");
        JLabel statusLabel = new JLabel("Status: Idle");

        // Layout setup
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(fileChooserButton);
        panel.add(playButton);
        panel.add(pauseButton);
        panel.add(resumeButton);
        panel.add(statusLabel);
        frame.add(panel);

        // Action listeners for buttons
        fileChooserButton.addActionListener(e -> chooseFile(statusLabel));
        playButton.addActionListener(e -> playAudio(statusLabel));
        pauseButton.addActionListener(e -> pauseAudio(statusLabel));
        resumeButton.addActionListener(e -> resumeAudio(statusLabel));

        // Disable pause and resume initially
        pauseButton.setEnabled(false);
        resumeButton.setEnabled(false);

        // Show the frame
        frame.setVisible(true);
    }

    private void chooseFile(JLabel statusLabel) {
        // Open file chooser for audio files
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Audio Files", "wav", "mp3", "ogg", "aiff"));

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {

                // Load the selected audio file
                audioStream = AudioSystem.getAudioInputStream(selectedFile);
                audioClip = AudioSystem.getClip();
                audioClip.open(audioStream);
                statusLabel.setText("Status: Ready to Play");
            } catch (Exception ex) {
                statusLabel.setText("Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    private void playAudio(JLabel statusLabel) {
        if (audioClip == null) {
            statusLabel.setText("Error: No audio file loaded");
            return;
        }

        if (!isPlaying) {
            audioClip.start();
            isPlaying = true;
            statusLabel.setText("Status: Playing");

            playButton.setEnabled(false);
            pauseButton.setEnabled(true);
        }
    }

    private void pauseAudio(JLabel statusLabel) {
        if (isPlaying && !isPaused) {
            audioClip.stop();
            isPaused = true;
            statusLabel.setText("Status: Paused");

            pauseButton.setEnabled(false);
            resumeButton.setEnabled(true);
        }
    }

    private void resumeAudio(JLabel statusLabel) {
        if (isPlaying && isPaused) {
            audioClip.start();
            isPaused = false;
            statusLabel.setText("Status: Resumed");

            pauseButton.setEnabled(true);
            resumeButton.setEnabled(false);
        }
    }
}
