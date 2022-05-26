package com.Gzl0ng.java;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class FileUtilesTest {
    public static void main(String[] args) {
        File srcFile = new File("day10\\彩虹六号.jpg");
        File destFile = new File("day10\\彩虹六号2.jpg");
        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
