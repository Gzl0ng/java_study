package com.Gzl0ng.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端给服务端发送文本，服务端会将文本转成大写在返回给客户端。
 */
public class TCPTest5 {
    @Test
    public void client(){

        Socket socket = null;
        FileReader fr = null;
        FileWriter fw = null;
        OutputStreamWriter osw = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),8090);
            OutputStream os = socket.getOutputStream();
            fr = new FileReader("hello.txt");
            osw = new OutputStreamWriter(os);
            int len;
            char[] buffer = new char[5];
            while ((len = fr.read(buffer)) != -1){
                osw.write(new String(buffer,0,len));
            }
            socket.shutdownOutput();

            InputStream is = socket.getInputStream();
            fw = new FileWriter("hello2.txt");
            int len1;
            byte[] bufferr = new byte[20];
            while ((len1 = is.read(bufferr)) != -1){
                fw.write(new String(bufferr,0,len1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            ss = new ServerSocket(8090);
            socket = ss.accept();
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            isr = new InputStreamReader(is);
            osw = new OutputStreamWriter(os);

            int len;
            char[] buffer = new char[5];
            while ((len = isr.read(buffer)) != -1){
                osw.write(new String(buffer,0,len).toUpperCase());
            }

            System.out.println("处理好了");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
