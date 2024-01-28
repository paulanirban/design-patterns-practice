package com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.decoder;

import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.MediaFormat;

public abstract class AudioDecoder {
    private final byte[] audioData;

    public AudioDecoder(byte[] audioData) {
        this.audioData = audioData;
    }

    public byte[] getAudioData() {
        return audioData;
    }

    public abstract MediaFormat supportsFormat();

    public abstract byte[] decode();
}
