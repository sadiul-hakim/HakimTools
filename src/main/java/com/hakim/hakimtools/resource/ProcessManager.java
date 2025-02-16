package com.hakim.hakimtools.resource;

import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.List;

public class ProcessManager extends JFrame {

    private final JTable processTable;
    private final DefaultTableModel tableModel;
    private final OperatingSystem os;

    public ProcessManager() {
        setTitle("Task Manager");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        SystemInfo systemInfo = new SystemInfo();
        os = systemInfo.getOperatingSystem();

        // Set up table
        tableModel = new DefaultTableModel(
                new String[]{"PID", "Process Name", "CPU Usage", "Memory Usage"}, 0
        );
        processTable = new JTable(tableModel);
        processTable.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(processTable);
        add(scrollPane, BorderLayout.CENTER);

        // Button to refresh
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshProcessTable());
        add(refreshButton, BorderLayout.SOUTH);

        // Refresh data at startup
        refreshProcessTable();
    }

    private void refreshProcessTable() {
        // Clear current rows
        tableModel.setRowCount(0);

        // Get system metrics
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();

        // Get processes
        List<OSProcess> processes = os.getProcesses();

        for (OSProcess process : processes) {
            long pid = process.getProcessID();
            String name = process.getName();
            long memoryUsage = process.getResidentSetSize();
            double cpuUsage = 100.0 * process.getProcessCpuLoadCumulative();

            tableModel.addRow(new Object[]{
                    pid, name, formatBytes(memoryUsage), String.format("%.2f%%", cpuUsage)
            });
        }
    }

    private String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        char unit = "KMGTPE".charAt(exp - 1);
        return String.format("%.2f %sB", bytes / Math.pow(1024, exp), unit);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProcessManager taskManager = new ProcessManager();
            taskManager.setVisible(true);
        });
    }
}
