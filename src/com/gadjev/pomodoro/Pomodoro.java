package com.gadjev.pomodoro;

import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Pomodoro {

    private int minutes;

    public Pomodoro(int mins) {
        this.minutes = mins;
    }

    public int getMinutes() {
        return minutes;
    }

    public void ring() {

        Platform.runLater(() -> {
            String soundFile = getClass().getResource("raw/beep.mp3").toString();

            Media beep = new Media(soundFile);
            MediaPlayer mediaPlayer = new MediaPlayer(beep);
            mediaPlayer.play();
        });

    }
}
