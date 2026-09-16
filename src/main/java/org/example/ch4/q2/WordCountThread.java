package org.example.ch4.q2;

public class WordCountThread extends Thread {
    private String text;
    private int count;

    public WordCountThread(String text) {
        this.text = text;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        String[] words = text.trim().split("\\s+");
        if (text.trim().length() == 0) {
            count = 0;
        } else {
            count = words.length;
        }
    }
}
