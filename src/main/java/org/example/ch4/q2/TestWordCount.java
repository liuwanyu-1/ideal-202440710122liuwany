package org.example.ch4.q2;

public class TestWordCount {
    public static void main(String[] args) throws InterruptedException {
        String text = "Java is easy and Java is useful for students";
        WordCountThread thread = new WordCountThread(text);
        thread.start();
        thread.join();
        System.out.println("单词个数：" + thread.getCount());
    }
}
