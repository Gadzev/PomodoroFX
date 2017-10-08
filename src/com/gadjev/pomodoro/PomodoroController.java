package com.gadjev.pomodoro;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PomodoroController {

    @FXML
    private Label timerLabel;

    public void initialize() {
        timerLabel.setText("Testing");
    }
}
