package com.Gzl0ng.java;

import org.junit.Test;

import java.util.Date;

/**
 *
 * JDK8之前日期和时间api测试
 */
public class DateTimeTest {
    /*
    java.util.Date类
            |---java.sql.Date类
    1.二个构造器的使用
        >构造器一：Date（）:创建一个对应当前时间的Date对象
        >构造器二：创建指定毫秒数的Date对象

    2.二个方法的使用
        >toString():显示当前的年，月，日，时，分，秒
        >getTime():获取当前Date对象对应的时间戳。

    3.java.sql.Date对应数据库中的日期类型的变量
        >如何实例化
        >sql.Date --> util.Date对象  多态
        >如何java.util.Date对象转换为java.sql.Date对象

     */
    @Test
    public void test2(){
        //构造器一：Date（）:创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Mon May 17 20:10:27 CST 2021

        System.out.println(date1.getTime());//1621253498121

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1621253603499L);
        System.out.println(date1.toString());

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(1621253798812L);
        System.out.println(date3.toString());//2021-05-17

        //如何java.util.Date对象转换为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(1621254100868L);
//        java.sql.Date date 5 = (java.sql.Date)date4;
        //情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }

    //1.System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //时间戳：用来返回当前时
        //间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        System.out.println(time);
    }


}
