package com.practice.designpatterns.creational.factory.simplefactory.audioplayer;

public class WAVPlayer extends AudioPlayer {
    private int volume;
    private final double playBackRate;

    public WAVPlayer(int volume, double playBackRate) {
        this.volume = volume;
        this.playBackRate = playBackRate;
    }

    @Override
    public void play() {
        // Simulate playing audio in WAV format
        // Each media format will have its own implementation
        System.out.println("Playing WAV audio");
    }

    @Override
    public void pause() {
        // Simulate pausing audio in WAV format
        // Each media format will have its own implementation
        System.out.println("Pausing WAV audio");
    }

    @Override
    public void stop() {
        // Simulate stopping audio in WAV format
        // Each media format will have its own implementation
        System.out.println("Stopping WAV audio");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("Volume set to " + volume);
        } else {
            System.out.println("Invalid volume level");
        }
    }

    @Override
    public double getPlayBackRate() {
        return playBackRate;
    }

    @Override
    public MediaFormat supportsType() {
        return MediaFormat.WAV;
    }
}
