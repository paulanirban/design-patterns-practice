package com.practice.designpatterns.creational.factory.simplefactory.audioplayer;

public class MP3Player extends AudioPlayer {
    private int volume;
    private final double playBackRate;

    public MP3Player(int volume, double playBackRate) {
        this.volume = volume;
        this.playBackRate = playBackRate;
    }

    @Override
    public void play() {
        // Simulate playing audio in FLAC format
        // Each media format will have its own implementation
        System.out.println("Playing MP3 audio");
    }

    @Override
    public void pause() {
        // Simulate pausing audio in FLAC format
        // Each media format will have its own implementation
        System.out.println("Pausing MP3 audio");
    }

    @Override
    public void stop() {
        // Simulate stopping audio in FLAC format
        // Each media format will have its own implementation
        System.out.println("Stopping MP3 audio");
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
        return MediaFormat.MP3;
    }
}
