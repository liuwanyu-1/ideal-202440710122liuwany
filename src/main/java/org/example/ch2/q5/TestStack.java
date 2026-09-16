package org.example.ch2.q5;

public class TestStack {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack.empty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}