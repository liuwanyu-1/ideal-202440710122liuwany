package org.example.ch3.q1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DirCommand {
    public static void main(String[] args) {
        String path = "C:\\Windows";
        File dir = new File(path);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("目录不存在或不是有效目录");
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("无法读取目录内容");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        for (File f : files) {
            String dateStr = sdf.format(new Date(f.lastModified()));
            String typeOrSize;

            if (f.isDirectory()) {
                typeOrSize = "<DIR>";
            } else {
                typeOrSize = String.format("%,d", f.length());
            }

            System.out.printf("%s    %8s    %s%n", dateStr, typeOrSize, f.getName());
        }
    }
}
