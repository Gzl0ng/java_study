package com.Gzl0ng.exer2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 1.请从键盘随机输入10个整数保存到List中，并按倒序、从大
 到小的顺序显示出来
 */
public class ArrayTest {
    public static void main(String[] args) {
        Scanner sacn = new Scanner(System.in);
        ArrayList list = new ArrayList();
        for(int i = 0;i < 10;i++){
            System.out.println("请输入第" + (i+1) + "数字：");
            list.add(sacn.nextInt());
        }

        Collections.reverse(list);
        System.out.println(list);

        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer a = (Integer)o1;
                Integer b = (Integer)o2;
                return -a.compareTo(b);
            }
        };
        Collections.sort(list,com);
        System.out.println(list);
    }
}
