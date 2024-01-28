package com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.processor;

import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.MediaFormat;

public abstract class AudioProcessor {
    private final byte[] audioData;

    public AudioProcessor(byte[] audioData) {
        this.audioData = audioData;
    }

    public byte[] getAudioData() {
        return audioData;
    }

    public abstract MediaFormat supportsFormat();

    public abstract byte[] process();
}
