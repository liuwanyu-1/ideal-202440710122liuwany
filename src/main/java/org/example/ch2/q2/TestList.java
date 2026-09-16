package org.example.ch2.q2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("program");
        list.add("test");
        list.add("abcdefg");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.length() > 5) {
                it.remove();
            }
        }

        System.out.println(list);
    }
}
