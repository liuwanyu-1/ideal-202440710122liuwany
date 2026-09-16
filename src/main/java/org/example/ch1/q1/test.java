package org.example.ch1.q1;

public class test {
    public static void main(String[] args) {
        Mpoint p1 = new Mpoint(3,5);
        Mpoint p2 = new Mpoint(3,5);
        Mpoint p3 = new Mpoint(4,6);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
    }
}
