package com.Gzl0ng.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历，使用迭代器Iterator接口
 * 1.内部的方法：hasNext（）和next（）
 * 2.集合对象每次调用iterator（）方法都得到一个全新的迭代器对象，
 *  默认游标都在集合的第一个元素之前。
 * 3.内部定义了一个remove（），可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove（）
 */
public class IteratorTest {
    @Test
    public void teat1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new java.lang.String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //报异常：集合中只有5个元素NoSuchElementException
//        System.out.println(iterator.next());
        //方式二：
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //方式三：推荐
        //hasNext():判断是否还有下一个元素
        while (iterator.hasNext()){
            //next():1指针下移2将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new java.lang.String("Tom"));
        coll.add(false);

        //错误方式一：跳一个输出，并且会报异常
//        Iterator iterator = coll.iterator();
//        while ((iterator.next()) != null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：每次循环创建的iterator是新的对象始终指向第一个对象，一直输出123
        while (coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }

    }

    //测试Iterator中的remove（）
    //如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
    //再调用remove都会报IllegalStateException。
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new java.lang.String("Tom"));
        coll.add(false);

        //删除集合中“Tom”
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
//            iterator.remove();//IllegalStateException
            Object obj = iterator.next();
            if ("Tom".equals(obj)){
                iterator.remove();
//                iterator.remove();//IllegalStateException
            }
        }

        //遍历集合
        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
