package com.Gzl0ng.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 参数FileInputStream和OutputStream的使用
 * <p>
 * 结论：
 * 1.对于文本文件（.txt,.java,.c,.cpp），使用字符流处理
 * 2.对于非文本文件（.jpg,.mp3,.mp4,.avi,.doc,.ppt,...），使用字节流处理
 */
public class FileInputOutputStreamTest {

    //使用字节流FileInputStream处理字符，可能出现乱码
    @Test
    public void testFileInputStreamTest() {
        FileInputStream fis = null;
        try {
            //1.造文件
            File file = new File("hello.txt");

            //2.造流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] buffer = new byte[5];
            int len;//记录每次读取的字节的个数
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                //关流
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    实现对图片的复制操作
     */
    @Test
    public void testFileInputOutputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("彩虹六号.jpg");
            File destFile = new File("彩虹六号1.jpg");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] b = new byte[5];
            int len;
            while ((len = fis.read(b)) != -1){
                fos.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //指定路径下文件的复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] b = new byte[5];
            int len;
            while ((len = fis.read(b)) != -1){
                fos.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();

        String srcPth = "C:\\Users\\13290\\Desktop\\01-视频.mp4";
        String destPath = "C:\\Users\\13290\\Desktop\\02-视频.mp4";

//        String srcPth = "hello.txt";
//        String destPath = "hello3.txt";

        copyFile(srcPth,destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));//8199
    }
}
