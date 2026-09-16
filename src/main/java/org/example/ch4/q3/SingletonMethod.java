package org.example.ch4.q3;

public class SingletonMethod {
    private static SingletonMethod instance;

    private SingletonMethod() {
    }

    public static synchronized SingletonMethod getInstance() {
        if (instance == null) {
            instance = new SingletonMethod();
        }
        return instance;
    }
}
