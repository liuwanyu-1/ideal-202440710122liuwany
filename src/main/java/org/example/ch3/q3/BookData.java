package org.example.ch3.q3;

import java.util.ArrayList;
import java.util.List;

public class BookData {
    public static List<Book> getBooks() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("1001","Java基础","张三",59.9,"机械工业",2020));
        list.add(new Book("1002","Python入门","李四",49.9,"人民邮电",2021));
        list.add(new Book("1003","C语言","王五",39.9,"高等教育",2019));
        list.add(new Book("1004","MySQL","赵六",69.9,"清华大学",2022));
        list.add(new Book("1005","SpringBoot","钱七",89.9,"电子工业",2023));
        list.add(new Book("1006","Vue教程","孙八",45.5,"机械工业",2021));
        list.add(new Book("1007","Linux","周九",55.5,"人民邮电",2020));
        list.add(new Book("1008","Docker","吴十",66.6,"电子工业",2022));
        list.add(new Book("1009","Redis","郑一",77.7,"清华大学",2023));
        list.add(new Book("1010","SpringCloud","王二",99.9,"机械工业",2024));
        return list;
    }
}