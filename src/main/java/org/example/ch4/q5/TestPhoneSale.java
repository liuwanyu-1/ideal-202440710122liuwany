package org.example.ch4.q5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPhoneSale {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 100; i++) {
            pool.execute(new PhoneSale("用户" + i));
        }

        pool.shutdown();
    }
}
