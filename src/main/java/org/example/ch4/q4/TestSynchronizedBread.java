package org.example.ch4.q4;

public class TestSynchronizedBread {
    public static void main(String[] args) {
        SynchronizedPlate plate = new SynchronizedPlate();

        Runnable maker = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    plate.put(Thread.currentThread().getName());
                }
            }
        };

        Runnable eater = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 12; i++) {
                    plate.take(Thread.currentThread().getName());
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
