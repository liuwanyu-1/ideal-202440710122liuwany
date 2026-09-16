package org.example.ch2.q9;

import java.util.List;

public class TestDouDiZhu {
    public static void main(String[] args) {
        DouDiZhuPoker poker = new DouDiZhuPoker();
        poker.createPoker();
        poker.shuffle();
        List<String>[] players = poker.deal();

        System.out.println("玩家1：");
        poker.show(players[0]);
        System.out.println("玩家2：");
        poker.show(players[1]);
        System.out.println("玩家3：");
        poker.show(players[2]);
        System.out.println("底牌：");
        poker.show(players[3]);
    }
}