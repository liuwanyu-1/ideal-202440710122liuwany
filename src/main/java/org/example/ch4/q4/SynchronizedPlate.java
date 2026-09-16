package org.example.ch4.q4;

public class SynchronizedPlate {
    private int breadCount = 0;
    private final int max = 10;

    public synchronized void put(String name) {
        while (breadCount >= max) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        breadCount++;
        System.out.println(name + "做了一个面包，盘子中有" + breadCount + "个");
        notifyAll();
    }

    public synchronized void take(String name) {
        while (breadCount <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        breadCount--;
        System.out.println(name + "吃了一个面包，盘子中有" + breadCount + "个");
        notifyAll();
    }
}
