package com.gadjev.pomodoro;

import javafx.application.Platform;
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

    private PomodoroModel pomodoroModel;

    public PomodoroController(PomodoroModel pomodoroModel) {
        this.pomodoroModel = pomodoroModel;
    }

    public void initialize() {

    }

    public void onStart() {
        try {
            if (minutesField.getText() == null || !minutesField.getText().trim().isEmpty()) {
                pomodoroModel.start(new Pomodoro(Integer.parseInt(minutesField.getText())), timerLabel, messageLabel);
            } else {
                messageLabel.setText("Please enter minutes for pomodoro");
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Please enter a valid number");
        }
    }

    public void onExit() {
        pomodoroModel.stop();
        Platform.exit();
    }
}
