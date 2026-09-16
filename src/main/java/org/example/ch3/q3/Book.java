package org.example.ch3.q3;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String author;
    private double price;
    private String press;
    private int year;

    public Book() {}

    public Book(String id, String name, String author, double price, String press, int year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.press = press;
        this.year = year;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getPress() { return press; }
    public void setPress(String press) { this.press = press; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return id + "," + name + "," + author + "," + price + "," + press + "," + year;
    }
}
