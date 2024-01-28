package com.practice.designpatterns.creational.factory.simplefactory.audioplayer;

public class AudioPlayerFactory {
    public static AudioPlayer getAudioPlayer(MediaFormat format, int volume, double playBackRate) {
        switch (format) {
            case WAV: return new WAVPlayer(volume, playBackRate);
            case MP3: return new MP3Player(volume, playBackRate);
            case FLAC: return new FLACPlayer(volume, playBackRate);
        }
        return null;
    }
}
