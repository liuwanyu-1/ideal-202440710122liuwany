package org.example.ch4.q5;

public class PhoneSale implements Runnable {
    private static int phoneCount = 20;
    private String userName;

    public PhoneSale(String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {
        synchronized (PhoneSale.class) {
            if (phoneCount > 0) {
                System.out.println(userName + "抢到手机，剩余" + (phoneCount - 1) + "部");
                phoneCount--;
            } else {
                System.out.println(userName + "没有抢到手机");
            }
        }
    }
}
