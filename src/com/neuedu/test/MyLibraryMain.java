package com.neuedu.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyLibraryMain {
    public static MyBook[] books=new MyBook[200];
    public static  List<MyLibrary> list=new ArrayList<>();
    public static File file = new File("h:/books");

    public static void main(String[] args) {
        if (!file.exists()){
            inputData(list);
            save();
        }else {
            read();
        }

//        print(list);
//        addbook(list);
//        print(list);
        menu();
        Scanner scanner =new Scanner(System.in);
        int i=scanner.nextInt();
        switch (i){
            case 1:
                addbook(list);
                break;
            case 2:
                System.out.println("请输入要删除的书名");
                String name=scanner.next();
                deleteName(list,name);
                break;
            case 3:
                System.out.println("请输入要查找的书名");
                String searchName=scanner.next();
                searchName(list,searchName);
                break;
            case 4:
                print(list);
                break;
            default:
                System.exit(1);
                break;
        }


    }
    public static void menu(){
        System.out.println("1.添加图书");
        System.out.println("2.删除图书");
        System.out.println("3.查找图书（根据书名）");
        System.out.println("4.查看全部图书");
        System.out.println("5.退出");
        Scanner scanner =new Scanner(System.in);
        int i=scanner.nextInt();
        switch (i){
            case 1:
                addbook(list);
                break;
            case 2:
                System.out.println("请输入要删除的书名");
                String name=scanner.next();
                deleteName(list,name);
                break;
            case 3:
                System.out.println("请输入要删除的书名");
                String searchName=scanner.next();
                searchName(list,searchName);
                break;
            case 4:
                print(list);
                break;
            default:
                System.exit(1);
                break;
        }


    }
    public static void inputData(List<MyLibrary> libraries){
        System.out.println("首次运行系统请输入初始化图书数量");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=0; i<=n;i++){
            MyLibrary myLibrary=new MyLibrary("书名"+i,Double.valueOf(String.valueOf(i)),"出版社"+i,"作者"+i,"ISBN号"+i);
            libraries.add(myLibrary);
        }
    }
    public static void print(List<MyLibrary> libraries){
        for (int i=0;i<libraries.size();i++){
            System.out.println(libraries.get(i));
        }
        menu();
    }
    public static void searchName(List<MyLibrary> libraries,String name){
        for (int i=0;i<libraries.size();i++){
            MyLibrary myLibrary=libraries.get(i);
            if (myLibrary.getName().equals(name)){
                System.out.println(myLibrary);
                menu();
                return;
            }
        }
        System.out.println("此书不存在");
        menu();
    }
    public static void deleteName(List<MyLibrary> libraries,String name){
        for (int i=0;i<libraries.size();i++){
            MyLibrary myLibrary=libraries.get(i);
            if (myLibrary.getName().equals(name)){
                libraries.remove(i);
                System.out.println("删除失败");
                save();
                menu();
                return;
            }
        }
        System.out.println("此书删除成功");
        menu();
    }
    public static void addbook(List<MyLibrary> libraries){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入书名");
        String name=scanner.next();
        System.out.println("请输入价格");
        Double price=scanner.nextDouble();
        System.out.println("请输入出版社");
        String press=scanner.next();
        System.out.println("请输入作者");
        String author=scanner.next();
        System.out.println("请输入ISBN");
        String bookISBN=scanner.next();
        MyLibrary myLibrary=new MyLibrary(name,price,press,author,bookISBN);
        libraries.add(myLibrary);
        save();
        menu();
    }
    public static void save(){
        OutputStream out=null;
        ObjectOutputStream objectout=null;

        try {
            out = new FileOutputStream(file);
            objectout=new ObjectOutputStream(out);
            objectout.writeObject(list);
            objectout.flush();
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
         catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(objectout!=null);
                    objectout.close();
                if(out!=null);
                    out.close();
            } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    public static void read(){
        InputStream inputStream=null;
        ObjectInputStream objectInputStream=null;
        try {
            inputStream=new FileInputStream(file);
            objectInputStream=new ObjectInputStream(inputStream);

                list= (List<MyLibrary>)objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(objectInputStream!=null);
                    objectInputStream.close();
                if (inputStream!=null);
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}
