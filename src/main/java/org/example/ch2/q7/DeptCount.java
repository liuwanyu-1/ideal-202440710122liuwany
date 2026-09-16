package org.example.ch2.q7;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class DeptCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,List<String>> map = new HashMap<>();
        System.out.println("请输入学生信息(输入exit结束)：");
        while(true){
            String line = sc.nextLine();
            if("exit".equals(line)){
                break;
            }
            String[] arr = line.trim().split("\\s+");
            String name = arr[0];
            String dept = arr[1];
            if(!map.containsKey(dept)){
                map.put(dept,new ArrayList<>());
            }
            map.get(dept).add(name);
        }
        for(String key : map.keySet()){
            List<String> list = map.get(key);
            System.out.print(key + "：" + list.size() + "人，");
            for(int i = 0;i < list.size();i++){
                if(i == list.size() - 1){
                    System.out.print(list.get(i));
                }else{
                    System.out.print(list.get(i) + ",");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}