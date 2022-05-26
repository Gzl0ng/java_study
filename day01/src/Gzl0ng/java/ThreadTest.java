package Gzl0ng.java;

/**
 * 多线程的创建：
 * 1.方式一：继承于Thread的子类
 * 2.重写Thread中的run方法 -->将此线程执行的操作声明在run（）中
 * 3.创建子类对象
 * 4.通过此对象调用start
 *
 * 例子：遍历100以内的偶数
 *
 *
 */

class MyThread extends Thread{
    //2.重写Thread类的run（）
    @Override
    public void run() {
            for (int i = 0;i < 100;i++ ){
                if (i % 2 == 0){
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3。创建子类对象
        MyThread t1 = new MyThread();

        //4.通过对象调start:1.启动当前线程2.调用当前线程的run方法
        t1.start();
        //问题一：我们不能直接通过直接调用run（）的方式启动线程。
//        t1.run();

        //问题二：在启动一个线程，遍历100以内的偶数.不可以让已经start的线程去执行回报IllegalThreadStateExcept异常
//        t1.start();
        //我们需要重新创建一个线程对象
        MyThread t2 = new MyThread();
        t2.start();

        //如下操作仍然是在main线程中执行的。
        for (int i = 0;i < 100;i++ ){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + "***************main()*************");
            }
        }
    }
}
