package org.example.ch4.q3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingletonLock {
    private static SingletonLock instance;
    private static Lock lock = new ReentrantLock();

    private SingletonLock() {
    }

    public static SingletonLock getInstance() {
        if (instance == null) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new SingletonLock();
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }
}
