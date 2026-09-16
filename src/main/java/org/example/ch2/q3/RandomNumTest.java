package org.example.ch2.q3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomNumTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        while (list.size() < 10) {
            int num = random.nextInt(100) + 1;
            if (!list.contains(num)) {
                list.add(num);
            }
        }

        Collections.sort(list);
        System.out.println(list);
    }
}