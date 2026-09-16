package org.example.ch2.q6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请粘贴你要统计的英语段子：");
        String content=sc.nextLine().toLowerCase();
        content=content.replaceAll("[^a-zA-Z ]","");
        String[] words=content.split(" +");

        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
            if(word.isEmpty()){
                continue;
            }
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            }else{
                map.put(word,1);
            }
        }

        for(String key:map.keySet()){
            System.out.println(key+" ："+map.get(key)+" 次");
        }
        sc.close();
    }
}