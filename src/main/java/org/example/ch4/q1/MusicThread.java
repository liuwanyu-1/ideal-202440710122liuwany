package org.example.ch4.q1;

public class MusicThread extends Thread {
    private boolean running = true;

    public void stopMusic() {
        running = false;
    }

    @Override
    public void run() {
        String[] lyrics = {
                "Welcome to New York!",
                "欢迎来到纽约，城市正在发光。",
                "A new soundtrack starts tonight.",
                "新的节拍响起，脚步也变轻快。",
                "The lights are bright, but I keep my eyes clear.",
                "霓虹很亮，但梦想更清楚。"
        };
        int index = 0;

        while (running) {
            System.out.println("播放歌词：" + lyrics[index]);
            index = (index + 1) % lyrics.length;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                running = false;
            }
        }
        System.out.println("音乐线程结束");
    }
}
