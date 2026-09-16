package org.example.ch2.q5;

import java.util.ArrayList;

public class MyStack<E> {
    private ArrayList<E> data;

    public MyStack() {
        data = new ArrayList<>();
    }

    public boolean empty() {
        return data.isEmpty();
    }

    public E peek() {
        return data.get(data.size() - 1);
    }

    public E pop() {
        return data.remove(data.size() - 1);
    }

    public E push(E item) {
        data.add(item);
        return item;
    }
}