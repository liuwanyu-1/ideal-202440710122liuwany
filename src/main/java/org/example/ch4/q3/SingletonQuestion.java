package org.example.ch4.q3;

public class SingletonQuestion {
    public static void main(String[] args) {
        System.out.println("题中懒汉式单例存在线程安全问题。");
        System.out.println("原因：多个线程可能同时判断 instance == null，结果创建多个对象。");
        System.out.println("解决方法可以使用同步代码块、同步方法或Lock锁，见本包中的三个类。");
    }
}
