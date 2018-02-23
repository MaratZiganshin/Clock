package sample;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;


import java.util.ArrayList;
import java.util.List;

import static sample.Main.CLOCKSIZE;

public class Clock extends Pane {
    public Clock(){
        Circle smallCircle = new Circle(CLOCKSIZE, CLOCKSIZE, CLOCKSIZE * 0.04, Color.BLACK);
        /*RadialGradient gradient = new RadialGradient(
                0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE,
                new Stop(0.8, Color.WHITE), new Stop(0.95, Color.WHITE), new Stop(1.0, Color.BLACK)
        );*/
        Circle circle = new Circle(CLOCKSIZE, CLOCKSIZE, CLOCKSIZE);
        circle.setFill(new ImagePattern(new Image(getClass().getResource("lena.jpg").toExternalForm())));
        //circle.setStyle("-fx-border-color: black; -fx-background-image: url(lena.jpg)");

        Group tickMarkGroup = new Group();
        List<Node> tickMarks = new ArrayList<>();
        for (int n = 0; n < 60; n++) {

            if (n % 5 == 0) {
                //line = new Line(CLOCKSIZE, CLOCKSIZE * 0, CLOCKSIZE, CLOCKSIZE * 0.1);
                Text label = new Text(CLOCKSIZE, CLOCKSIZE*0.2, ""+n/5);
                label.getTransforms().add(new Rotate(360 / 60 * n - 2.5, CLOCKSIZE, CLOCKSIZE));
                label.setFont(new Font(CLOCKSIZE/10));
                label.setTextAlignment(TextAlignment.CENTER);
                tickMarks.add(label);
            } else {
                Line line = new Line(CLOCKSIZE, CLOCKSIZE * 0.08, CLOCKSIZE, CLOCKSIZE * 0.1);
                line.getTransforms().add(new Rotate(360 / 60 * n, CLOCKSIZE, CLOCKSIZE));
                line.setStrokeWidth(3);
                tickMarks.add(line);
            }

        }
        tickMarkGroup.getChildren().addAll(tickMarks);

        this.getChildren().addAll(circle, tickMarkGroup, smallCircle);
    }
}
