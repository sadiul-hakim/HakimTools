package com.hakim.hakimtools.datetime.alarm;

import javax.swing.*;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class AlarmClock implements Runnable {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a z");
    private final ZonedDateTime dateTime;

    public AlarmClock(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public void run() {
        ZoneId zone = dateTime.getZone();
        ZonedDateTime now = ZonedDateTime.now(zone);
        Duration between = Duration.between(now, dateTime);

        if (now.isAfter(dateTime)) {
            SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "Time Passed!"));
            return;
        }

        long millis = between.toMillis();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "Alarm is closed for time " + DATE_TIME_FORMATTER.format(dateTime)));
            Thread.currentThread().interrupt();
            return;
        }

        System.out.println("*Alarm Ring*");
    }
}
