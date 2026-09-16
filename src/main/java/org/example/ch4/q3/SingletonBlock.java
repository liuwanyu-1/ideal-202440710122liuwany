package org.example.ch4.q3;

public class SingletonBlock {
    private static SingletonBlock instance;

    private SingletonBlock() {
    }

    public static SingletonBlock getInstance() {
        if (instance == null) {
            synchronized (SingletonBlock.class) {
                if (instance == null) {
                    instance = new SingletonBlock();
                }
            }
        }
        return instance;
    }
}
