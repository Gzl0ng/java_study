package com.Gzl0ng.exer2;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 请把学生名与考试分数录入到集合中，并按分数显示前三名
 成绩学员的名字。

 */
public class ScoreTest {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        set.add(new Student("Tom",88));
        set.add(new Student("Jeck",55));
        set.add(new Student("Rose",77));
        set.add(new Student("Aisi",90));


        Iterator iterator = set.iterator();
        for (int i = 0; i < 3; i++) {
            System.out.println(iterator.next());
        }
    }
}
