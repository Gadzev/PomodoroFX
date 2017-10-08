package com.gadjev.pomodoro;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PomodoroController {

    @FXML
    private Label timerLabel;

    @FXML
    private TextField minutesField;

    @FXML
    private Label messageLabel;

    private PomodoroModel pomodoroModel = new PomodoroModel();

    public void initialize() {

    }

    public void onStart() {
        pomodoroModel.start(new Pomodoro(Integer.parseInt(minutesField.getText())), timerLabel, messageLabel);
    }
}
