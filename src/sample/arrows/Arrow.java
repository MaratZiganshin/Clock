package sample.arrows;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Arrow extends Pane {
    public static int speed = 1;
    protected Node node;
    public void Rotate(){
        RotateTransition rt = new RotateTransition(new Duration(100), node);
        rt.setFromAngle(node.getRotate());
        rt.setByAngle(6);
        rt.setCycleCount(1);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.play();
    }
}
