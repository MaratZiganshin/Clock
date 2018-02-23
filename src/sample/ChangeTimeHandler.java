package sample;

import javafx.scene.Node;
import sample.arrows.HourArrow;
import sample.arrows.MinuteArrow;
import sample.arrows.SecondsArrow;

import java.time.LocalTime;

public class ChangeTimeHandler extends Thread {
    private int second = LocalTime.now().getSecond();
    private int minute= LocalTime.now().getMinute();
    private int hour= LocalTime.now().getHour();
    private SecondsArrow secondArrow;
    private MinuteArrow minuteArrow;
    private HourArrow hourArrow;

    public ChangeTimeHandler(Node secondArrow, Node minuteArrow, Node hourArrow) {
        this.secondArrow = (SecondsArrow) secondArrow;
        this.minuteArrow = (MinuteArrow) minuteArrow;
        this.hourArrow = (HourArrow) hourArrow;
    }

    @Override
    public void run() {
        while (true) {
            LocalTime localTime = LocalTime.now();
            if (second != localTime.getSecond()) {
                secondArrow.Rotate();
                second = localTime.getSecond();
                if (minute != localTime.getMinute()) {
                    minuteArrow.Rotate();
                    minute = localTime.getMinute();
                    if (hour != localTime.getHour()) {
                        hourArrow.Rotate();
                        hour = localTime.getHour();
                    }
                }
            }
        }
    }
}
