package org.example.ch4.q4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestBlockingQueueBread {
    public static void main(String[] args) {
        BlockingQueue<String> plate = new ArrayBlockingQueue<String>(10);

        Runnable maker = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        plate.put("面包");
                        System.out.println(Thread.currentThread().getName() + "做了一个面包，盘子中有" + plate.size() + "个");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable eater = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 12; i++) {
                    try {
                        plate.take();
                        System.out.println(Thread.currentThread().getName() + "吃了一个面包，盘子中有" + plate.size() + "个");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(maker, "爸爸").start();
        new Thread(maker, "妈妈").start();
        new Thread(eater, "大儿子").start();
        new Thread(eater, "二儿子").start();
        new Thread(eater, "三儿子").start();
    }
}
