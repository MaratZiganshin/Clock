package sample.arrows;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import sample.Angle;
import static sample.Main.CLOCKSIZE;
import java.time.LocalTime;

public class HourArrow extends Arrow {
    public HourArrow() {
        this.setPrefSize(CLOCKSIZE * 2, CLOCKSIZE * 2);
        Path path = new Path(
                new MoveTo(CLOCKSIZE, CLOCKSIZE),
                new LineTo(CLOCKSIZE * 0.95, CLOCKSIZE * 0.7),
                new LineTo(CLOCKSIZE, CLOCKSIZE*0.4),
                new LineTo(CLOCKSIZE * 1.05, CLOCKSIZE * 0.7),
                new LineTo(CLOCKSIZE, CLOCKSIZE)
        );
        path.setFill(Color.BLACK);
        path.setStroke(Color.TRANSPARENT);
        this.getChildren().add(path);

        super.node = this;
        Angle angle = new Angle(LocalTime.now());
        this.setRotate(angle.hours());
    }

    @Override
    public void Rotate(){
        RotateTransition rt = new RotateTransition(new Duration(30), node);
        rt.setFromAngle(node.getRotate());
        rt.setByAngle(30);
        rt.setCycleCount(1);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.play();
    }
}
