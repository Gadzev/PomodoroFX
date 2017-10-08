package com.gadjev.pomodoro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PomodoroApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent loader = FXMLLoader.load((getClass().getResource("ui.fxml")));
        stage.setTitle("PomodoroFX");
        stage.getIcons().add(new Image(getClass().getResource("images/pomodoro-ico.png").toExternalForm()));

        stage.setScene(new Scene(loader));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
