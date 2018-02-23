package sample;

import java.time.LocalTime;

public class Angle {
    private LocalTime localTime;

    public Angle(LocalTime localTime) {
        this.localTime = localTime;
    }

    public int seconds() {
        return localTime.getSecond() * 6;
    }

    public int minutes() {
        return localTime.getMinute() * 6;
    }

    public int hours() {
        int hour = localTime.getHour() % 12;
        return hour * 30;
    }
}
