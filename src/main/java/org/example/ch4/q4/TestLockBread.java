package org.example.ch4.q4;

public class TestLockBread {
    public static void main(String[] args) {
        LockPlate plate = new LockPlate();

        for (int i = 1; i <= 2; i++) {
            String name = i == 1 ? "爸爸" : "妈妈";
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 20; j++) {
                        plate.put(Thread.currentThread().getName());
                    }
                }
            }, name).start();
        }

        for (int i = 1; i <= 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 12; j++) {
                        plate.take(Thread.currentThread().getName());
                    }
                }
            }, i + "儿子").start();
        }
    }
}
