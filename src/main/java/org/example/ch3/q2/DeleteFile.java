package org.example.ch3.q2;

import java.io.File;

public class DeleteFile {

    public static void delete(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    delete(f);
                }
            }
        }
        file.delete();
    }

    public static void main(String[] args) {
        File file = new File("D:\\test");
        delete(file);
        System.out.println("删除成功！");
    }
}