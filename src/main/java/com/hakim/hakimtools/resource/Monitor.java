package com.hakim.hakimtools.resource;

import com.sun.management.OperatingSystemMXBean;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Monitor extends JFrame {

    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private final JTable table;

    private final DefaultTableModel model = new DefaultTableModel(
            new String[]{
                    "Name", "Value"
            }, 0
    );

    public Monitor() {
        setSize(650, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        table = new JTable();
        table.setModel(model);
        table.setShowGrid(true);
        table.setGridColor(new java.awt.Color(0, 153, 153));
        table.setFont(new Font("Fira Code", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        Thread.ofPlatform().start(this::showResource);
    }

    private void showResource() {
        var bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a z");

        while (true) {
            updateOrAddRow("Date Time", ZonedDateTime.now().format(formatter));
            updateOrAddRow("Name", bean.getName());
            updateOrAddRow("Arch", bean.getArch());
            updateOrAddRow("Version", bean.getVersion());

            updateOrAddRow("Available Processors", bean.getAvailableProcessors());
            updateOrAddRow("System Load Average", formatDouble(bean.getSystemLoadAverage()));
            updateOrAddRow("Committed Virtual Memory", formatBytes(bean.getCommittedVirtualMemorySize()));
            updateOrAddRow("CPU Load", formatPercentage(bean.getCpuLoad()));
            updateOrAddRow("Free Memory Size", formatBytes(bean.getFreeMemorySize()));
            updateOrAddRow("Free Swap Space Size", formatBytes(bean.getFreeSwapSpaceSize()));
            updateOrAddRow("Process CPU Load", formatPercentage(bean.getProcessCpuLoad()));
            updateOrAddRow("Process CPU Time", formatTime(bean.getProcessCpuTime()));
            updateOrAddRow("Total Memory Size", formatBytes(bean.getTotalMemorySize()));
            updateOrAddRow("Total Swap Memory Size", formatBytes(bean.getTotalSwapSpaceSize()));

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        char unit = "KMGTPE".charAt(exp - 1);
        return String.format("%.2f %sB", bytes / Math.pow(1024, exp), unit);
    }

    private String formatPercentage(double value) {
        if (value < 0) return "N/A";
        return decimalFormat.format(value * 100) + " %";
    }

    private String formatDouble(double value) {
        if (value < 0) return "N/A";
        return decimalFormat.format(value);
    }

    private String formatTime(long nanos) {
        if (nanos < 0) return "N/A";
        long seconds = nanos / 1_000_000_000;
        return seconds + " sec";
    }

    private void updateOrAddRow(String key, Object value) {
        boolean rowUpdated = false;

        // Loop through the table model to find the row with the key
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0) != null && model.getValueAt(i, 0).equals(key)) {
                model.setValueAt(value, i, 1); // Update the value at column 1
                rowUpdated = true;
                break;
            }
        }

        // If the key doesn't exist, add a new row
        if (!rowUpdated) {
            model.addRow(new Object[]{key, value});
        }
    }

}
