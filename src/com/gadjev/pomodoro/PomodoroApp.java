package com.gadjev.pomodoro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PomodoroApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader((getClass().getResource("ui.fxml")));
        stage.setTitle("PomodoroFX");
        stage.getIcons().add(new Image(getClass().getResource("images/pomodoro-ico.png").toExternalForm()));

        PomodoroController pomodoroController = new PomodoroController(new PomodoroModel());

        loader.setController(pomodoroController);



        stage.setScene(new Scene(loader.load()));
        stage.setOnCloseRequest(e -> pomodoroController.onExit());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
