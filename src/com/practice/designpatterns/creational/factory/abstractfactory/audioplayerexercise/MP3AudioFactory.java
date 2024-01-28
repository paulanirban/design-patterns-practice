package com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise;

import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.decoder.AudioDecoder;
import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.decoder.MP3Decoder;
import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.player.AudioPlayer;
import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.player.MP3Player;
import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.processor.AudioProcessor;
import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.processor.MP3AudioProcessor;

public class MP3AudioFactory extends AudioFactory {
    @Override
    public MediaFormat supportsFormat() {
        return MediaFormat.MP3;
    }

    @Override
    public AudioDecoder createAudioDecoder(byte[] audioData) {
        return new MP3Decoder(audioData);
    }

    @Override
    public AudioProcessor createAudioProcessors(byte[] audioData) {
        return new MP3AudioProcessor(audioData);
    }

    @Override
    public AudioPlayer createAudioPlayer(int volume, double playbackRate) {
        return new MP3Player(volume, playbackRate);
    }
}
