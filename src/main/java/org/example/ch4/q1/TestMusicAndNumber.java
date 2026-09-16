package org.example.ch4.q1;

public class TestMusicAndNumber {
    public static void main(String[] args) {
        MusicThread musicThread = new MusicThread();
        Thread numberThread = new Thread(new NumberRunnable(musicThread));

        musicThread.start();
        numberThread.start();
    }
}
