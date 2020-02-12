package com.neuedu.test;

import java.io.Serializable;

public class MyLibrary implements Serializable {
    private static final long serialVersionUID =1L;
    private String name;
    private Double price;
    private String press;
    private String author;
    private String bookSIBN;

    public MyLibrary(String name, Double price, String press, String author, String bookSIBN) {
        this.name = name;
        this.price = price;
        this.press = press;
        this.author = author;
        this.bookSIBN = bookSIBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookSIBN() {
        return bookSIBN;
    }

    public void setBookSIBN(String bookSIBN) {
        this.bookSIBN = bookSIBN;
    }

    @Override
    public String toString() {
        return "MyLibrary{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                ", author='" + author + '\'' +
                ", bookSIBN='" + bookSIBN + '\'' +
                '}';
    }
}
