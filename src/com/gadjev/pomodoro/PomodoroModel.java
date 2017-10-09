package com.gadjev.pomodoro;


import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.concurrent.*;

public class PomodoroModel {

    private ExecutorService executorService = new ThreadPoolExecutor(
            1, 1,
            60, TimeUnit.SECONDS,
            new SynchronousQueue<>());

    public void start(final Pomodoro pomodoro, final Label timeLabel, final Label messageLabel) {

        messageLabel.setText("");
    try {
        executorService.execute(() -> {
            int time = convertToSeconds(pomodoro.getMinutes());
            long delay = time * 1000;

            do {
                final int minutes = time / 60;
                final int seconds = time % 60;
                Platform.runLater(() -> {

                    timeLabel.setText("" + minutes + ":" + seconds);

                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted: " + e);
                    stop();
                }
                time -= 1;
                delay -= 1000;
            } while (delay != 0);
            Platform.runLater(() -> {
                messageLabel.setText("Time is up");
                pomodoro.ring();
            });
        });
    } catch (RejectedExecutionException e) {
        messageLabel.setText("Wait for current pomodoro to finish");
    }

    }

    public void stop() {
        executorService.shutdownNow();
    }

    private int convertToSeconds(int minutes) {
        return minutes * 60;
    }
}
