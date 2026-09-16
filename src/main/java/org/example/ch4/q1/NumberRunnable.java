package org.example.ch4.q1;

import java.util.Random;

public class NumberRunnable implements Runnable {
    private MusicThread musicThread;

    public NumberRunnable(MusicThread musicThread) {
        this.musicThread = musicThread;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 1; i <= 10000; i++) {
            int num = random.nextInt(100) + 1;
            System.out.println(i + ": " + num);
            if (i % 20 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
        musicThread.stopMusic();// 线程2执行结束后调用 stopMusic()，把线程1的循环标志改为 false，使线程1结束。
    }
}
