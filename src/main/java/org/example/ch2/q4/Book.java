package org.example.ch2.q4;

public class Book {
    private String name;
    private double price;
    private String publisher;
    private String author;

    public Book(){}

    public Book(String name,double price,String publisher,String author){
        this.name=name;
        this.price=price;
        this.publisher=publisher;
        this.author=author;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public String getPublisher(){
        return publisher;
    }
    public void setPublisher(String publisher){
        this.publisher=publisher;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author=author;
    }

    @Override
    public String toString() {
        return "书名："+name+" 价格："+price+" 出版社："+publisher+" 作者："+author;
    }
}