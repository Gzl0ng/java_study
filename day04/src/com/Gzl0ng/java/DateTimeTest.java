package com.Gzl0ng.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8之前的日期时间的API测试
 * 1.System类中的currenttimeMillis（）；
 * 2.2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 */

public class DateTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.二个操作：
    1.1 格式化：日期 ---> 字符串
    1.2 解析：格式化的逆过程，字符串 ---> 日期

    2.SimpleDateFormat的实例化

     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 ---> 字符串
        Date date = new Date();
//        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串 ---> 日期
        String str = "21-5-18 下午7:29";

        Date date1 = sdf.parse(str);
        System.out.println();

        //********************安装指定的方式格式化和解析：调用带参的构造器*************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);//2021-05-18 07:38:44
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）
        //否则抛异常
        Date date2 = sdf1.parse("2021-05-18 07:38:44");
        System.out.println(date2);

        /*
        练习一：字符串“2020-09-08”转换为java.sql.Date
         */

    }

    /*
        练习一：字符串“2020-09-08”转换为java.sql.Date

        练习二："三天打鱼二天晒网“ 1990-01-01 xxxx-xx-xx 打渔？晒网？

        举例：2020-09-08？

        总天数 % 5 == 1，2，3：打渔
        总天数 % 5 == 0，4：晒网

        总天数的计算？
        方式一：(date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) % 5
        方式二：1990-01-01 --> 2019-12-31 + 2020-01-01 --> 2020-09-08
         */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birth);
//        System.out.println(date);
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);
    }
    @Test
    public void testexer1() throws ParseException {
        String d1 = "1990-01-01";
        String d2 = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse1 = sdf.parse(d1);
        Date parse2 = sdf.parse(d2);
        System.out.println((parse2.getTime() - parse1.getTime()) / (1000 * 60 * 60 * 24) % 5);

    }

    /*
    Calendar日历类(抽象类)的使用
     */
    @Test
    public void testCalendar(){
        //1.实例化
        //方式一：创建子类（GregorianCalendar）的对象
        //方式二：调用其静态方法（getInstance（））
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类 ->Date
        Date time = calendar.getTime();
        System.out.println(time);

        //setTime()：Date->日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }
}
