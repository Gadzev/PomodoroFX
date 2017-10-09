package com.gadjev.pomodoro;


import javafx.application.Platform;
import javafx.scene.control.Label;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PomodoroModel {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void start(final Pomodoro pomodoro, final Label timeLabel, final Label messageLabel) {
        messageLabel.setText("");
      executorService.execute(() -> {
              int time = convertToSeconds(pomodoro.getMinutes());
              long delay = time * 1000;

              do {
                  final int minutes = time / 60;
                  final int seconds = time % 60;
                  Platform.runLater(()  -> {

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
    }

    public void stop() {
        executorService.shutdownNow();
    }

    private int convertToSeconds(int minutes) {
        return minutes * 60;
    }
}
