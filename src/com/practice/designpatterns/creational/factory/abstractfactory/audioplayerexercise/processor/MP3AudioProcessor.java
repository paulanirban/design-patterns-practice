package com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.processor;

import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.MediaFormat;

public class MP3AudioProcessor extends AudioProcessor {
    public MP3AudioProcessor(byte[] audioData) {
        super(audioData);
    }

    @Override
    public MediaFormat supportsFormat() {
        return null;
    }

    @Override
    public byte[] process() {
        return new byte[0];
    }
}
