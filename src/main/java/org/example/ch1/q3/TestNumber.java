package org.example.ch1.q3;

import java.util.Scanner;

public class TestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入数字字符串：");
        String s = sc.next();

        if(s.matches("-?\\d+")){
            System.out.println("整数");
        }else if(s.matches("-?\\d+\\.\\d+")){
            System.out.println("小数");
        }else{
            System.out.println("非数字");
        }
        sc.close();
    }
}