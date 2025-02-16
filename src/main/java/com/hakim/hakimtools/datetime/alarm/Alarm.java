package com.hakim.hakimtools.datetime.alarm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Alarm extends JFrame {
    private final JComboBox<Object> zoneChooser;
    private final JComboBox<Integer> hourChooser;
    private final JComboBox<Integer> minuteChooser;
    private final JComboBox<Integer> secondChooser;
    private final JLabel dateTimeLabel;

    private final JTable table;
    private final JScrollPane scrollPane;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a z");
    private static final Font DEFULT_FONT = new Font("Fira Code", Font.PLAIN, 14);

    private static final Map<String, Thread> THREAD_MAP = new ConcurrentHashMap<>();

    public Alarm() {
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        setTitle("Alarm Clock");


        // Zone Chooser Label'
        JLabel zoneChooserLabel = new JLabel("Zone Chooser");
        zoneChooserLabel.setSize(100, 20);
        zoneChooserLabel.setLocation(20, 20);
        zoneChooserLabel.setFont(DEFULT_FONT);
        add(zoneChooserLabel);

        // Zone Chooser
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        Object[] ids = zoneIds.stream().sorted().toArray();
        zoneChooser = new JComboBox<>(ids);
        zoneChooser.setLocation(20, 50);
        zoneChooser.setSize(200, 30);
        zoneChooser.addActionListener(this::displayDate);
        zoneChooser.setFont(DEFULT_FONT);
        zoneChooser.setSelectedItem(ZoneId.systemDefault().getId());
        add(zoneChooser);

        // Display Date
        dateTimeLabel = new JLabel(DATE_TIME_FORMATTER.format(ZonedDateTime.now()));
        dateTimeLabel.setSize(350, 30);
        dateTimeLabel.setLocation(20, 80);
        dateTimeLabel.setFont(DEFULT_FONT);
        add(dateTimeLabel);

        // Date Label
        JLabel dateTimeChooserLabel = new JLabel("Time Chooser");
        dateTimeChooserLabel.setSize(100, 20);
        dateTimeChooserLabel.setLocation(250, 20);
        dateTimeChooserLabel.setFont(DEFULT_FONT);
        add(dateTimeChooserLabel);


        // Hour Chooser
        hourChooser = new JComboBox<>(getArray(24));
        hourChooser.setLocation(250, 50);
        hourChooser.setSize(60, 30);
        hourChooser.setFont(DEFULT_FONT);
        add(hourChooser);

        // Minute Chooser
        minuteChooser = new JComboBox<>(getArray(60));
        minuteChooser.setLocation(320, 50);
        minuteChooser.setSize(60, 30);
        minuteChooser.setFont(DEFULT_FONT);
        add(minuteChooser);

        // Minute Chooser
        secondChooser = new JComboBox<>(getArray(60));
        secondChooser.setLocation(390, 50);
        secondChooser.setSize(60, 30);
        secondChooser.setFont(DEFULT_FONT);
        add(secondChooser);

        // Add Button
        JButton addButton = new JButton("Add");
        addButton.setFont(DEFULT_FONT);
        addButton.setBackground(new Color(25, 120, 199));
        addButton.setLocation(470, 50);
        addButton.setSize(60, 30);
        addButton.setForeground(Color.white);
        addButton.addActionListener(this::addAlarm);
        add(addButton);

        table = new JTable();
        var model = new DefaultTableModel(new String[]{"Time", "Action"}, 1);
        table.setModel(model);

        scrollPane = new JScrollPane();
        scrollPane.setSize(560, 320);
        scrollPane.setLocation(10, 120);

        scrollPane.add(table);
        add(scrollPane);
    }

    private void addAlarm(ActionEvent actionEvent) {
        String zone = (String) zoneChooser.getSelectedItem();
        int hour = (int) hourChooser.getSelectedItem();
        int minute = (int) minuteChooser.getSelectedItem();
        int second = (int) secondChooser.getSelectedItem();

        ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of(zone))
                .withHour(hour)
                .withMinute(minute)
                .withSecond(second);

        Thread alarmThread = Thread.ofVirtual().name("AlarmThread").start(new AlarmClock(dateTime));
        THREAD_MAP.put(DATE_TIME_FORMATTER.format(dateTime), alarmThread);
    }

    private void addTimeInTable(String time){
        DefaultTableModel model = new DefaultTableModel(new String[]{"Time", "Action"}, 1);
        for (Map.Entry<String, Thread> entry : THREAD_MAP.entrySet()) {

        }
    }

    private void displayDate(ActionEvent actionEvent) {
        String zone = (String) zoneChooser.getSelectedItem();
        assert zone != null;
        ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of(zone));
        String dateText = DATE_TIME_FORMATTER.format(dateTime);

        if (dateTimeLabel != null)
            dateTimeLabel.setText("Now : " + dateText);
    }

    private Integer[] getArray(int end) {
        Integer[] array = new Integer[end];
        for (int i = 0; i < end; i++) {
            array[i] = i;
        }

        return array;
    }
}
