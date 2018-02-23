package sample.arrows;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import sample.Angle;

import java.time.LocalTime;

import static sample.Main.CLOCKSIZE;

public class MinuteArrow extends Arrow{

    public MinuteArrow() {
        this.setPrefSize(CLOCKSIZE * 2, CLOCKSIZE * 2);
        Path path = new Path(
                new MoveTo(CLOCKSIZE , CLOCKSIZE ),
                new LineTo(CLOCKSIZE  * 0.95, CLOCKSIZE  * 0.5),
                new LineTo(CLOCKSIZE , CLOCKSIZE*0.1),
                new LineTo(CLOCKSIZE  * 1.05, CLOCKSIZE  * 0.5),
                new LineTo(CLOCKSIZE , CLOCKSIZE )
        );
        path.setFill(Color.BLACK);
        path.setStroke(Color.TRANSPARENT);
        this.getChildren().add(path);
        super.node = this;
        Angle angle = new Angle(LocalTime.now());
        this.setRotate(angle.minutes());
    }

}
