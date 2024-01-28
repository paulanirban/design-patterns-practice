package com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise;

import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.decoder.AudioDecoder;
import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.player.AudioPlayer;
import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.processor.AudioProcessor;

public abstract class AudioFactory {
    public abstract MediaFormat supportsFormat();
    public abstract AudioDecoder createAudioDecoder(byte[] audioData);
    public abstract AudioProcessor createAudioProcessors(byte[] audioData);
    public abstract AudioPlayer createAudioPlayer(int volume, double playbackRate);
}
