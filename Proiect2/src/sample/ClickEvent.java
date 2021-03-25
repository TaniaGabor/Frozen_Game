package sample;

import javafx.animation.FadeTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javafx.util.Pair;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Stack;

public class ClickEvent implements EventHandler<MouseEvent> {
    private Blocks block;
    private ImageView imgView;
    private Stack<Pair<ImageView, Blocks>> blocksPresed;
    private FadeTransition fadeTransition;

    ClickEvent(Blocks block, ImageView imgView, Stack<Pair<ImageView, Blocks>> blocksStack) {
        this.block = block;
        this.imgView = imgView;
        this.blocksPresed = blocksStack;

        fadeTransition = new FadeTransition(Duration.millis(1000), this.imgView);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (block.isVisible()) {
            return;
        }

        fadeTransition.setFromValue(0.5);
        fadeTransition.setToValue(1);

        if (blocksPresed.size() != 2) {
            blocksPresed.push(new Pair<>(this.imgView, this.block));

            try {
                imgView.setImage(new Image(new FileInputStream(block.getPath())));
                block.setVisible(true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            fadeTransition.play();

            return;
        }

        Pair<ImageView, Blocks> p1;
        Pair<ImageView, Blocks> p2;

        p1 = blocksPresed.pop();
        p2 = blocksPresed.pop();

        ImageView imgView1 = p1.getKey();
        Blocks b1 = p1.getValue();

        ImageView imgView2 = p2.getKey();
        Blocks b2 = p2.getValue();

        if (!b1.equals(b2)) {
            // not matching
            b1.setVisible(false);
            b2.setVisible(false);

            try {
                imgView1.setImage(new Image(new FileInputStream(b1.getBlankPath())));
                imgView2.setImage(new Image(new FileInputStream(b2.getBlankPath())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
