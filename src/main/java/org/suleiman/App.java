package org.suleiman;

import CustomControl.TouchControl;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        TouchControl touchControl = new TouchControl();
        stage.setScene(new Scene(touchControl));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}