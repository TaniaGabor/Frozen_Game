package sample;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Shadow;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.util.Pair;

import java.io.FileInputStream;
import java.util.Stack;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Stack<Pair<ImageView, Blocks>> blocksPressed = new Stack<>();
        Game game = new Game();
        Group group = new Group();

        int x = 20;
        int y = 20;

        for (int i = 0; i < Game.rows; i++) {
            x = 20;
            for (int j = 0; j < Game.cols; j++) {
                Blocks block = game.getElement(i, j);
                Image img;
                if (block.isVisible()) {
                    img = new Image(new FileInputStream(block.getPath()));
                } else {
                    img = new Image(new FileInputStream(block.getBlankPath()));
                }

                ImageView imgView = new ImageView(img);
                imgView.setFitWidth(80);
                imgView.setFitHeight(80);
                imgView.setX(x);
                imgView.setY(y);
                imgView.setPickOnBounds(true);

                x += 100;

                ClickEvent event = new ClickEvent(block, imgView, blocksPressed);
                imgView.addEventFilter(MouseEvent.MOUSE_CLICKED, event);

                group.getChildren().add(imgView);
            }

            y += 100;
        }

        Scene scene = new Scene(group, 610, 610);

        stage.setScene(scene);
        stage.setTitle("MemoryFrozen");
        stage.setResizable(false);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
