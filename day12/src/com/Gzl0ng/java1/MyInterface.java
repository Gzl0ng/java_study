package com.Gzl0ng.java1;

/**
 *
 * 自定义函数式接口
 */

@FunctionalInterface
public interface MyInterface {

    void method1();

    //加了注解后自动检查是否满足函数式接口的形式，一个抽象方法
//    void method2();
}
