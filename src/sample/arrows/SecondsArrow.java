package sample.arrows;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import sample.Angle;

import java.time.LocalTime;

import static sample.Main.CLOCKSIZE;

public class SecondsArrow extends Arrow{

    public SecondsArrow() {
        this.setPrefSize(CLOCKSIZE * 2, CLOCKSIZE * 2);
        Line line = new Line(CLOCKSIZE, CLOCKSIZE * 1.1, CLOCKSIZE, CLOCKSIZE * 0.2);
        line.setStrokeWidth(5);
        line.setStroke(Color.RED);
        this.getChildren().add(line);
        super.node = this;
        Angle angle = new Angle(LocalTime.now());
        node.setRotate(angle.seconds());
    }

}
