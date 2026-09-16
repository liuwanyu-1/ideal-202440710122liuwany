package org.example.ch3.q3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookIOTest {
    public static void main(String[] args) throws Exception {
        List<Book> books = BookData.getBooks();

        // (1) 字节流对象读写
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books_obj.dat"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books_obj.dat"))) {
            oos.writeObject(books);
            List<Book> read1 = (List<Book>) ois.readObject();
            System.out.println("(1) 字节流对象读取：" + read1.size());
        }

        // (2) 按类型字节流读写
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("books_type.dat"));
             DataInputStream dis = new DataInputStream(new FileInputStream("books_type.dat"))) {
            for (Book b : books) {
                dos.writeUTF(b.getId());
                dos.writeUTF(b.getName());
                dos.writeUTF(b.getAuthor());
                dos.writeDouble(b.getPrice());
                dos.writeUTF(b.getPress());
                dos.writeInt(b.getYear());
            }
            List<Book> read2 = new ArrayList<>();
            while (dis.available() > 0) {
                read2.add(new Book(dis.readUTF(), dis.readUTF(), dis.readUTF(), dis.readDouble(), dis.readUTF(), dis.readInt()));
            }
            System.out.println("(2) 按类型读取：" + read2.size());
        }

        // (3) 字符流读写文本
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("books_text.txt"));
             BufferedReader br = new BufferedReader(new FileReader("books_text.txt"))) {
            for (Book b : books) bw.write(b + "\n");
            List<Book> read3 = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split(",");
                read3.add(new Book(s[0], s[1], s[2], Double.parseDouble(s[3]), s[4], Integer.parseInt(s[5])));
            }
            System.out.println("(3) 字符流读取：" + read3.size());
        }

        // (4) 对象存入文件读入List
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books_list.dat"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books_list.dat"))) {
            oos.writeObject(books);
            List<Book> read4 = (List<Book>) ois.readObject();
            System.out.println("(4) 对象List读取：" + read4.size());
        }

        // (5) 存入CSV(Excel) 读取List
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("books_excel.csv"));
             BufferedReader br = new BufferedReader(new FileReader("books_excel.csv"))) {
            for (Book b : books) bw.write(b + "\n");
            List<Book> read5 = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split(",");
                read5.add(new Book(s[0], s[1], s[2], Double.parseDouble(s[3]), s[4], Integer.parseInt(s[5])));
            }
            System.out.println("(5) Excel读取：" + read5.size());
        }

        // (6) JSON存入与读取
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("books_json.json"));
             BufferedReader br = new BufferedReader(new FileReader("books_json.json"))) {
            for (Book b : books) {
                bw.write("{\"id\":\"" + b.getId() + "\",\"name\":\"" + b.getName() + "\",\"author\":\"" + b.getAuthor() + "\",\"price\":" + b.getPrice() + ",\"press\":\"" + b.getPress() + "\",\"year\":" + b.getYear() + "}\n");
            }
            List<Book> read6 = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replace("{", "").replace("}", "").replace("\"", "");
                String[] kv = line.split(",");
                read6.add(new Book(
                        kv[0].split(":")[1],
                        kv[1].split(":")[1],
                        kv[2].split(":")[1],
                        Double.parseDouble(kv[3].split(":")[1]),
                        kv[4].split(":")[1],
                        Integer.parseInt(kv[5].split(":")[1])
                ));
            }
            System.out.println("(6) JSON读取：" + read6.size());
        }
    }
}