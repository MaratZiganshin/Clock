package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.arrows.HourArrow;
import sample.arrows.MinuteArrow;
import sample.arrows.SecondsArrow;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Main extends Application {

    public static final double CLOCKSIZE = 300.0;

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        Node clock = new Clock();
        Node hourArrow = new HourArrow();
        Node minuteArrow = new MinuteArrow();
        Node secondsArrow = new SecondsArrow();

        root.getChildren().addAll(
                clock, hourArrow, minuteArrow, secondsArrow
        );

        ChangeTimeHandler timeHandler = new ChangeTimeHandler(secondsArrow, minuteArrow, hourArrow);
        timeHandler.start();


        Scene scene = new Scene(root);
        stage.setTitle("Clock");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
