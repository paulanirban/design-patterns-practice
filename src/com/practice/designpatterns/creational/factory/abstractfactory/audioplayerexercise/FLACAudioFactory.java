package com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise;

import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.decoder.AudioDecoder;
import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.decoder.FLACDecoder;
import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.player.AudioPlayer;
import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.player.FLACPlayer;
import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.processor.AudioProcessor;
import com.practice.designpatterns.creational.factory.abstractfactory.audioplayerexercise.processor.FLACAudioProcessor;

public class FLACAudioFactory extends AudioFactory {
    @Override
    public MediaFormat supportsFormat() {
        return MediaFormat.FLAC;
    }

    @Override
    public AudioDecoder createAudioDecoder(byte[] audioData) {
        return new FLACDecoder(audioData);
    }

    @Override
    public AudioProcessor createAudioProcessors(byte[] audioData) {
        return new FLACAudioProcessor(audioData);
    }

    @Override
    public AudioPlayer createAudioPlayer(int volume, double playbackRate) {
        return new FLACPlayer(volume, playbackRate);
    }
}
