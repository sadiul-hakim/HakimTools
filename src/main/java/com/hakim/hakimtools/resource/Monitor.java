package com.hakim.hakimtools.resource;

import com.sun.management.OperatingSystemMXBean;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.management.ManagementFactory;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Monitor extends JFrame {

    private final JTable table;

    private static final DefaultTableModel model = new DefaultTableModel(
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
        table.setFont(new Font("Fira Code",Font.PLAIN,15));

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
            updateOrAddRow("System Load Average", bean.getSystemLoadAverage());
            updateOrAddRow("Committed Virtual Memory", bean.getCommittedVirtualMemorySize());
            updateOrAddRow("Cpu Load", bean.getCpuLoad());
            updateOrAddRow("Free Memory Size", bean.getFreeMemorySize());
            updateOrAddRow("Free Swap Space Size", bean.getFreeSwapSpaceSize());
            updateOrAddRow("Process CPU Load", bean.getProcessCpuLoad());
            updateOrAddRow("Process CPU Time", bean.getProcessCpuTime());
            updateOrAddRow("Total Memory Size", bean.getTotalMemorySize());
            updateOrAddRow("Total Swap Memory Size", bean.getTotalSwapSpaceSize());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
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
