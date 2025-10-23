package org.example.task3.adapter;

public class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Проигрывание mp3 файла: " + fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            new MediaAdapter(audioType).play(audioType, fileName);
        } else {
            System.out.println("Неподдерживаемый формат: " + audioType);
        }
    }
}
