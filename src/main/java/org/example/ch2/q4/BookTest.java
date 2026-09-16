package org.example.ch2.q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class BookTest {
    public static void main(String[] args) {
        List<Book> bookList=new ArrayList<>();
        bookList.add(new Book("Java编程基础",59.9,"机械工业出版社","张三"));
        bookList.add(new Book("Python入门",45.5,"人民邮电出版社","李四"));
        bookList.add(new Book("Java高级开发",79.0,"电子工业出版社","王五"));
        bookList.add(new Book("C语言教程",39.8,"高等教育出版社","赵六"));
        bookList.add(new Book("数据库原理",52.6,"清华大学出版社","钱七"));
        bookList.add(new Book("Web前端开发",49.0,"机械工业出版社","孙八"));
        bookList.add(new Book("Java框架实战",85.2,"电子工业出版社","周九"));
        bookList.add(new Book("网络安全",63.7,"人民邮电出版社","吴十"));
        bookList.add(new Book("数据结构",55.3,"清华大学出版社","郑一"));
        bookList.add(new Book("软件工程",42.9,"高等教育出版社","王二"));

        bookList.sort(Comparator.comparingDouble(Book::getPrice));
        System.out.println("=====按价格升序排序=====");
        for(Book b:bookList){
            System.out.println(b);
        }

        System.out.println("\n=====书名包含java的书籍=====");
        for(Book b:bookList){
            if(b.getName().toLowerCase().contains("java")){
                System.out.println(b);
            }
        }
    }
}