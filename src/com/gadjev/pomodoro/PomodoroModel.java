package com.gadjev.pomodoro;


import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Label;

public class PomodoroModel {

    public void start(final Pomodoro pomodoro, final Label timeLabel, final Label messageLabel) {
        messageLabel.setText("");
       Task task = new Task<Void>() {
           @Override
           public Void call() throws Exception {
            int time = convertToSeconds(pomodoro.getMinutes());
            long delay = time * 1000;

            do {
                final int minutes = time / 60;
                final int seconds = time % 60;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        timeLabel.setText("" + minutes + ":" + seconds);
                    }
                });
                Thread.sleep(1000);
                time -= 1;
                delay -= 1000;
            } while (delay != 0);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    messageLabel.setText("Time is up");
                    pomodoro.ring();
                }
            });
            return null;
           }
       };

       Thread thread = new Thread(task);
       thread.setDaemon(true);
       thread.start();
    }

    private int convertToSeconds(int minutes) {
        return minutes * 60;
    }
}
