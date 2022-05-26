package com.Gzl0ng.java1;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;

/**
 * 注解的使用
 *
 * 1.理解Annotation：
 *      jdk5.0新增的功能
 *
 *      Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加
 载, 运行时被读取, 并执行相应的处理。
        程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。

        在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，
 忽略警告等。在JavaEE/Android中注解占据了更重要的角色，例如
 用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗
 代码和XML配置等。

    2.Annotation的示例
        示例一：生成文档相关的注解
        示例二：在编译时进行格式检查，该注解只能用于方法
  @Override: 限定重写父类方法, 该注解只能用于方法
  @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
  @SuppressWarnings: 抑制编译器警告

        示例三：跟踪代码依赖性，实现替代配置文件功能

    3.如何自定义注解:参照SuppressWarnings
        1注解声明为:@interface
        2内部定义成员，通常使用value表示
        3可以指定成员的默认值，使用default定义
        4.如果自定义注解没有成员，标明是一个标识作用

    如果注解有成员，在使用注解时，需要指定成员的值。
    自定义注解必须配上注解的信息处理流程（使用反射）才有意义
    自定义注解通常都会指明二个元注解：Retention，Target
    4.jdk提供的4种元注解
        元注解：对现有的注解进行解释说明
        Retention：指定所修饰的Annotation的生命周期：SOURCE/CLASS(默认行为)/RUNTIME
                只有声明为RUNTIME生命周期的注解，才能通过反射获取。
        Target: 用于指定被修饰的 Annotation 能用于修饰哪些程序元素。

        Documented：表示所修饰的注解在被javadoc解析时，保留下来
        Inherited：被它修饰的Annotation将具有继承性

    5.通过反射获取注解信息 ---到反射内容时系统讲解

    6.JDK8中注解的新特性：可重复注解，类型注解

    6.1 可重复注解:1在MyAnnotation上声明@Repearable，成员值为MyAnnotations.class
                    MyAnnotation的Target和Retention等元注解和MyAnnotations相同。

    6.2 类型注解：
    ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
    ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。


 */
public class AnnotationTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.walk();

        Date date = new Date(2020, 10, 11);
        System.out.println(date);

        @SuppressWarnings("unused")
        int num = 10;
//        System.out.println(num);
        @SuppressWarnings({ "unused","rawtypes" })
        ArrayList list = new ArrayList();
    }

    @Test
    public void testGetAnnotation(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();

        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }
}


//jdk8之前的写法
//@MyAnnotations({@MyAnnotation(value = "hi"),@MyAnnotation(value = "abc")})
@MyAnnotation(value = "hi")
@MyAnnotation(value = "abc")
class Person{
    private String name;
    private int age;

    public Person() {
    }
    @MyAnnotation
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    public void walk(){
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人吃饭");
    }
}


interface Info{
    void show();
}

class Student extends Person implements Info{

    @Override
    public void walk() {
        System.out.println("学生走路");
    }


    public void show() {

    }
}

class Generic<@MyAnnotation T>{

    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int)10L;
    }
}

