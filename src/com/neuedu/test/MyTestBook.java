package com.neuedu.test;
import java.util.ArrayList;
import java.util.Scanner;

public class MyTestBook {
        ArrayList<MyTestBook>list=new ArrayList<>();
        Scanner in=new Scanner(System.in);
        private int id;
        private String name;
        private String anthor;
        private String Publishing;
        public MyTestBook(int id, String name, String anthor, String publishing) {
            super();
            this.id = id;
            this.name = name;
            this.anthor = anthor;
            Publishing = publishing;
        }
        public MyTestBook(){}

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getAnthor() {
            return anthor;
        }
        public void setAnthor(String anthor) {
            this.anthor = anthor;
        }
        public String getPublishing() {
            return Publishing;
        }
        public void setPublishing(String publishing) {
            Publishing = publishing;
        }


        public void addbook(){//增加
            MyTestBook bo=new MyTestBook();
            System.out.print("书id：");
            bo.setId(in.nextInt());
            Scanner s = new Scanner(System.in);
            System.out.print("书名：");
            bo.setName(s.nextLine());
            System.out.print("作者：");
            bo.setAnthor(s.nextLine());
            System.out.print("出版社：");
            bo.setPublishing(s.nextLine());
            list.add(bo);
            System.out.println("添加成功");
            System.out.println("-----------------------------");
            menu();
        }
        public void getById(){//通过书id
            System.out.println("输入查询的id");
            int id =in.nextInt();
            int i=0;
            for( i=0;i<list.size();i++){
                if(list.get(i).getId()==id){
                    System.out.println("查询成功");
                    System.out.println("书Id："+list.get(i).getId()+"  书名："+list.get(i).getName()+"  作者："+list.get(i).getAnthor()+"  出版社："+list.get(i).getPublishing());
                    break;
                }
            }
            if(i==list.size()){System.out.println("查无此书");}
            System.out.println("任意键继续");
            int ting=in.nextInt();//停一下
            menu();
        }
        public void getByName(){//根据书名
            System.out.println("请输入需要查询的书名：");
            Scanner in = new Scanner(System.in);
            String n=in.nextLine();
            System.out.println("所有可能的书籍为：");
            for(int i=0;i<list.size();i++){
                if(list.get(i).getName().contains(n)){
                    System.out.println("书Id："+list.get(i).getId()+"  书名："+list.get(i).getName()+"  作者："+list.get(i).getAnthor()+"  出版社："+list.get(i).getPublishing());
                }
            }
            System.out.println("任意键继续");
            int ting=in.nextInt();//停一下
            menu();
        }
        public void listall(){//所有书
            for(int i=0;i<list.size();i++){
                System.out.println("书Id："+list.get(i).getId()+"  书名："+list.get(i).getName()+"  作者："+list.get(i).getAnthor()+"  出版社："+list.get(i).getPublishing());
            }
            System.out.println("任意键继续");
            int ting=in.nextInt();//停一下
            menu();
        }
        public void menu(){
            System.out.println("请选择菜单");
            System.out.println("0-退出");
            System.out.println("1-增加一本书");
            System.out.println("2-根据id查找");
            System.out.println("3-根据书名模糊查找");
            System.out.println("4-查看所有书");
            System.out.println("-----------------------------");
            int menu=in.nextInt();
            switch(menu){
                case 0:
                    System.exit(0);
                case 1:
                    addbook();
                    break;
                case 2:
                    getById();
                    break;
                case 3:
                    getByName();
                    break;
                case 4:
                    listall();
                    break;
            }
        }

    }


