package com.Gzl0ng.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/*
1. 利用File构造器，new 一个文件目录file
1)在其中创建多个文件和目录
2)编写方法，实现删除file中指定文件的操作
2. 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
拓展1：并计算指定目录占用空间的大小
拓展2：删除指定文件目录及其下的所有文件

 */
public class FileDemo {

    //1. 利用File构造器，new 一个文件目录file
    @Test
    public void test1() throws IOException {
        File file =new File("E:\\IO\\io1");
        //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File destfile = new File(file.getParent(),"haha.txt");
        boolean newFile = destfile.createNewFile();
        if (newFile){
            System.out.println("创建成功！");
        }
        File file1 = new File("E:\\IO\\io1","io5");
        System.out.println(file1.mkdir());

        File file2 = new File("E:\\IO\\io1\\io6");
        System.out.println(file2.mkdir());

        file1 = new File("E:\\IO\\io1","io5.txt");
        System.out.println(file1.createNewFile());

        System.out.println(file1.delete());
    }

    //2. 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
    @Test
    public void test2(){
        //放指定位置的文件对象
        File file = new File("E:\\IO\\io1");
        //创建一个String数组存放文件名称（不考虑其目录下有文件夹）
        String[] list = file.list();
        for (String s : list){
            if (s.endsWith(".jpg")){
                System.out.println(s);
            }
        }

        //考虑其目录下有文件夹
        method(file);
    }
    public void method(File file){
        File[] files = file.listFiles();
        for (File f : files){
            if (f.isDirectory()){
                method(f);
            }else {
                if (f.getName().endsWith(".jpg")){
                    System.out.println(f);
                }
            }
        }
    }


    //3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
    //拓展1：并计算指定目录占用空间的大小
    //拓展2：删除指定文件目录及其下的所有文件
    @Test
    public void test3(){
        //创建指定目录的文件对象
        File file = new File("E:\\IO");

        //递归调用返回子层的文件
        method1(file);

        //拓展1：并计算指定目录占用空间的大小
        long l = method2(file);
        System.out.println(l);

        //拓展2：删除指定文件目录及其下的所有文件
        System.out.println(method3(file));
    }

    public static long length = 0;

    public void method1(File file){
        File[] files = file.listFiles();
        for (File f : files){
            if (f.isDirectory()){
                method1(f);
            }else {
                System.out.println(f);
            }
        }
    }

    public long method2(File file){
        File[] files = file.listFiles();
        for (File f : files){
            if (f.isDirectory()){
                method2(f);
            }else {
                length += f.length();
            }
        }
        return length;
    }

    public boolean method3(File file){
        File[] files = file.listFiles();
        for (File f : files){
            if (f.isDirectory()){
                method3(f);
            }else {
                f.delete();
            }
        }
        return true;
    }
}
