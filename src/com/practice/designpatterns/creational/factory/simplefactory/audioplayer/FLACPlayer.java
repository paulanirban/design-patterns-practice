package com.practice.designpatterns.creational.factory.simplefactory.audioplayer;

public class FLACPlayer extends AudioPlayer {
    private int volume;
    private final double playBackRate;

    public FLACPlayer(int volume, double playBackRate) {
        this.volume = volume;
        this.playBackRate = playBackRate;
    }
    @Override
    public void play() {
        // Simulate playing audio in FLAC format
        // Each media format will have its own implementation
        System.out.println("Playing FLAC audio");
    }

    @Override
    public void pause() {
        // Simulate pausing audio in FLAC format
        // Each media format will have its own implementation
        System.out.println("Pausing FLAC audio");
    }

    @Override
    public void stop() {
        // Simulate stopping audio in FLAC format
        // Each media format will have its own implementation
        System.out.println("Stopping FLAC audio");
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
        return MediaFormat.FLAC;
    }
}
