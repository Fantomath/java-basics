package org.example.task3.adapter;

public class MediaAdapter implements MediaPlayer {
    private final AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        } else {
            throw new UnsupportedOperationException("Формат не поддерживается");
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        advancedMediaPlayer.playMp4(fileName);
    }
}
