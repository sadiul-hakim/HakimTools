package com.hakim.hakimtools.drawing;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

public class Paint extends JFrame {
    private Color selectedColor = Color.BLACK;
    private int brushSize = 5;

    public Paint() {
        setTitle("Drawing App");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        DrawCanvas canvas = new DrawCanvas();
        add(canvas, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JButton colorButton = new JButton("Select Color");
        colorButton.setBackground(new Color(23, 34, 56));
        colorButton.setForeground(Color.white);
        colorButton.addActionListener(e -> {
            Color color = JColorChooser.showDialog(null, "Choose Color", selectedColor);
            if (color != null) selectedColor = color;
        });
        controlPanel.add(colorButton);

        JLabel brushLabel = new JLabel("Brush Size");
        controlPanel.add(brushLabel);
        JComboBox<Integer> brushSizeComboBox = new JComboBox<>(new Integer[]{2, 5, 10, 20});
        brushSizeComboBox.setSelectedItem(brushSize);
        brushSizeComboBox.addActionListener(e -> brushSize = (Integer) brushSizeComboBox.getSelectedItem());
        controlPanel.add(brushSizeComboBox);

        add(controlPanel, BorderLayout.NORTH);

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        var window = new Paint();
        window.setTitle("Window");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setVisible(true);
    }

    private class DrawCanvas extends JPanel {
        private List<DrawPoint> points = new ArrayList<>();

        public DrawCanvas() {
            setBackground(Color.white);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    points.add(new DrawPoint(e.getPoint(), selectedColor, brushSize));
                    repaint();
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    points.add(new DrawPoint(e.getPoint(), selectedColor, brushSize));
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D graphics = (Graphics2D) g;
            for (DrawPoint point : points) {
                graphics.setColor(point.color);
                graphics.fillOval(point.position.x - point.size / 2, point.position.y - point.size / 2, point.size, point.size);
            }
        }
    }

    private static class DrawPoint {
        Point position;
        Color color;
        int size;

        public DrawPoint(Point point, Color color, int size) {
            this.position = point;
            this.color = color;
            this.size = size;
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(Paint::new);
        }
    }
}
