package com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.decoder;

import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.MediaFormat;

public class MP3Decoder extends AudioDecoder {
    public MP3Decoder(byte[] audioData) {
        super(audioData);
    }

    @Override
    public MediaFormat supportsFormat() {
        return MediaFormat.MP3;
    }

    @Override
    public byte[] decode() {
        // Implement MP3 decoding logic
        System.out.println("Decoding MP3 audio data...");
        // Decoding process
        return getAudioData();
    }
}
