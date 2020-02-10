package com.neuedu.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyBook {
    private String name;
    private double price;
    private String press;
    private String author;
    private String bookISBN;
    private ArrayList books;


    public ArrayList inputData(ArrayList<MyBook>books,int n){
        Scanner scanner = new Scanner(System.in);
        MyBook myBook = new MyBook();
        for (int i=0;i<n;i++){
            System.out.println("请输入第"+(i+1)+"本书信息");
            System.out.println("书名");
            myBook.name=scanner.next();
            System.out.println("价格");
            myBook.price=Double.valueOf(scanner.next());
            System.out.println("出版社");
            myBook.press=scanner.next();
            System.out.println("作者");
            myBook.author=scanner.next();
            System.out.println("ISBN");
            myBook.bookISBN=scanner.next();
            books.add(myBook);
            System.out.println("添加成功");
            System.out.println("-----------------------");
        }
        return books;

    }
    public void print(ArrayList<MyBook>books){
        for (MyBook book:books){
            System.out.println(book.name);
            System.out.println(book.price);
            System.out.println(book.press);
            System.out.println(book.author);
            System.out.println(book.bookISBN);
        }
    }
    public void searchName(ArrayList<MyBook> books,String name){
        int flag = 1;
        for (MyBook book : books){
            if (book.name.equals(name)){
                System.out.println(book.name);
                System.out.println(book.price);
                System.out.println(book.press);
                System.out.println(book.author);
                System.out.println(book.bookISBN);
                flag = 0;
            }
        }
        if (flag == 1){
            System.out.println("此书不存在");
        }
    }
    public void delete(ArrayList<MyBook> books,String name){
        int flag = 1;
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).name.equals(name)){
                books.remove(i);
                System.out.println("此书删除成功");
                flag = 0;
            }
        }
        if (flag == 1){
            System.out.println("没有此书，删除失败");
        }
    }
    public void menu(){
        MyBook myBook = new MyBook();
        myBook.books = new ArrayList();
        int flag = 0;
        Scanner scanner = new Scanner(System.in);
        while (flag == 0){
            System.out.println("请输入1-4中的任一个数字");
            int a = scanner.nextInt();
            if (a == 1){
                System.out.println("请输入要输入的个数");
                int n = scanner.nextInt();
                inputData(myBook.books,n);
            }else if (a==2){
                System.out.println("请输入要删除的名字");
                String name =scanner.next();
                delete(myBook.books,name);
            }
            else if (a==3){
                System.out.println("请输入要查找的名字");
                String name = scanner.next();
                searchName(myBook.books,name);
            }else if (a==4){
                System.out.println("退出系统");
                System.exit(4);

            }else {
                flag = 1;
            }
        }


    }


}
