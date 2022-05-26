package com.Gzl0ng.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(343);
        coll.add(343);


        coll.forEach(System.out::println);
    }


    //练习：在List内去除重复数字值，要求尽量简单
    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }

    @Test
    public void test3(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);
        System.out.println(set);//[Person{id=1002, name='BB'}, Person{id=1001, name='AA'}]

        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);//[Person{id=1002, name='BB'}, Person{id=1001, name='CC'}]
        //1001 AA计算哈希值后放入了一个位置，更改里面的值不影响位置，但是去remove 1001 CC 哈希值指定的位置没有元素，所有删除不了

        //同理放入1001 CC的哈希值算出的位置没有元素，添加成功
        set.add(new Person(1001,"CC"));
        System.out.println(set);//[Person{id=1002, name='BB'}, Person{id=1001, name='CC'}，Person{id=1001,'CC'}]

        //同理放入1001 AA的哈希值计算的位置上有元素1001 CC，判断equals不相等，添加成功
        set.add(new Person(1001,"AA"));
        System.out.println(set);//[Person{id=1002, name='BB'}, Person{id=1001, name='CC'}，Person{id=1001,'CC'},Person{id=1001,'AA'}]

    }
}
