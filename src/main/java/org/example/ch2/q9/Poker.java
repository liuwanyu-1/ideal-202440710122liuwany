package org.example.ch2.q9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Poker {
    protected List<String> pokerList;

    public Poker() {
        pokerList = new ArrayList<>();
    }

    public void createPoker() {
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (String c : colors) {
            for (String n : numbers) {
                pokerList.add(c + n);
            }
        }
        pokerList.add("小王");
        pokerList.add("大王");
    }

    public void shuffle() {
        Collections.shuffle(pokerList);
    }

    public List<String>[] deal() {
        List<String> player1 = new ArrayList<>();
        List<String> player2 = new ArrayList<>();
        List<String> player3 = new ArrayList<>();
        List<String> diPai = new ArrayList<>();

        for (int i = 0; i < pokerList.size() - 3; i++) {
            if (i % 3 == 0) {
                player1.add(pokerList.get(i));
            } else if (i % 3 == 1) {
                player2.add(pokerList.get(i));
            } else {
                player3.add(pokerList.get(i));
            }
        }
        diPai.add(pokerList.get(pokerList.size() - 3));
        diPai.add(pokerList.get(pokerList.size() - 2));
        diPai.add(pokerList.get(pokerList.size() - 1));

        return new List[]{player1, player2, player3, diPai};
    }

    public void show(List<String> list) {
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}