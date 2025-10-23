package org.example.task3.adapter;

public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("Проигрывание mp4 файла: " + fileName);
    }
}
