package org.example.ch4.q4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPlate {
    private int breadCount = 0;
    private final int max = 10;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void put(String name) {
        lock.lock();
        try {
            while (breadCount >= max) {
                notFull.await();
            }
            breadCount++;
            System.out.println(name + "做了一个面包，盘子中有" + breadCount + "个");
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void take(String name) {
        lock.lock();
        try {
            while (breadCount <= 0) {
                notEmpty.await();
            }
            breadCount--;
            System.out.println(name + "吃了一个面包，盘子中有" + breadCount + "个");
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
