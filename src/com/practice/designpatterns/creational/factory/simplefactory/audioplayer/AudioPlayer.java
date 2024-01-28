package com.practice.designpatterns.creational.factory.simplefactory.audioplayer;

public abstract class AudioPlayer {
    protected int volume;
    protected double playBackRate;
    public abstract void play();
    public abstract void pause();
    public abstract void stop();
    public abstract int getVolume();
    public abstract void setVolume(int volume);
    public abstract double getPlayBackRate();
    public abstract MediaFormat supportsType();
}
