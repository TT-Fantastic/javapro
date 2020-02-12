package com.neuedu.test;

import java.io.*;

public class Testhomework {
    public static void main(String[] args) {
        Politician politician =new Politician();
        politician.setName("稻上飞");
        politician.setId(286);
        politician.setAge(88);
        politician.setNation("康华帝国");

//        File file = new File("h:/Tset.java");
/*
        System.out.println(file.getName());
        System.out.println(file.length());
        System.out.println(file.exists());
        System.out.println(file.getPath());
        try {
//            System.out.println(file.createNewFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
     /* try {
                OutputStream outputStream = new FileOutputStream(file,true);
                String a = "\n11111111111";
                outputStream.write(a.getBytes());将a转为byte，写入流中
                outputStream.flush();//压入到文件中
                outputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }*/

 /*       try {
            InputStream inputStream=new FileInputStream(file);
            byte[] a=new byte[200];
            System.out.println(inputStream.read(a));//read的返回值类型为int，如果返回-1则代表什么也没读取到
            inputStream.close();
            System.out.println(new String(a));//new String(a)将byte型数组转化称为String
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        /*安全的写法*/
//        InputStream inputStream=null;
//        try {
//               inputStream=new FileInputStream(file);
//                byte[] a=new byte[200];
//                System.out.println(inputStream.read(a));//read的返回值类型为int，如果返回-1则代表什么也没读取到
//
//                System.out.println(new String(a));//new String(a)将byte型数组转化称为String
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally {
//            try {
//                if (inputStream!=null);
//                    inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
       /* InputStream inputStream=null;
        try {
            inputStream=new FileInputStream(file);
            byte[] a=new byte[10];
            int b=inputStream.read(a);
            while (b!=-1){
                System.out.println("读取的字数"+b);
                System.out.println(new String(a,0,b));//new String(a,offset:0,b)从第0位读取，读取到剩余存储数位
                b=inputStream.read(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (inputStream!=null);
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
      /*  char[] a=new char[10];
        Reader reader=null;//如果写在try{}内 finally获取不到reader（所有域问题）
        try {
            reader =new FileReader(file);
            int b= reader.read(a);
            while (b!=-1){
                System.out.println("读取的字符数"+b);
                b=reader.read();
                System.out.println(new String(a,0,b));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader!=null);
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
      //按行读取 BufferedReader
       /* Reader reader=null;
        BufferedReader bufferedReader=null;
        try {
            reader =new FileReader(file);
            bufferedReader=new BufferedReader(reader);
            String str=bufferedReader.readLine();//按行读取
            while (str!=null){
                System.out.println("读取的字符数"+str);
                str=bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
            if (bufferedReader!=null)
                bufferedReader.close();
            if(reader!=null);
                reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/
     /*  Writer writer= null;
        try {
            writer=new FileWriter(file,true);
            writer.write("\nshfafagygy");
            writer.flush();
            System.out.println("添加成功");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (writer!=null);
                     writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
     /*File from=new File("h:/Tset.java");
     File parents= new File("h:/a");
     if (!parents.exists()){
         parents.mkdirs();

     }
        System.out.println(parents.exists());
     File to =new File("h:/a/"+from.getName());
     byte[] b=new byte[10];
     InputStream inputStream=null;
     OutputStream outputStream=null;
        try {
            inputStream=new FileInputStream(from);
            outputStream=new FileOutputStream(to);
            int len=inputStream.read(b);
            while (len!=-1){
                outputStream.write(b,0,len);
                outputStream.flush();
                len=inputStream.read(b);

            }
            System.out.println("复制成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (outputStream!=null)
                    outputStream.close();
                if (inputStream!=null);
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(from.delete());*/
    /* File file=new File("h:/Student");
        OutputStream outputStream= null;
        ObjectOutputStream objectOutputStream=null;
        try {
            outputStream = new FileOutputStream(file);
            objectOutputStream=new ObjectOutputStream(outputStream);//需要裹一个输出流
            objectOutputStream.writeObject(politician);
            objectOutputStream.flush();
            outputStream.flush();
            System.out.println("保存完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (objectOutputStream!=null)
                    objectOutputStream.close();
                if (outputStream!=null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    File file=new File("h:/Student");

        InputStream inputStream=null;
        ObjectInputStream objectInputStream=null;
        try {
             inputStream=new FileInputStream(file);
             objectInputStream=new ObjectInputStream(inputStream);
             Politician politician1=(Politician)objectInputStream.readObject();
            System.out.println(politician1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (objectInputStream!=null)
                     objectInputStream.close();
                if(inputStream!=null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
