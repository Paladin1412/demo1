package thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * volatile:通知OS底层，在CPU计算过程中，都要检查内存中数据的有效性，保证最新的内存数据被使用
 *
 * 2.1 volatile 的特性
 *
 *     保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。（实现可见性）
 *     禁止进行指令重排序。（实现有序性）
 *     volatile 只能保证对单次读/写的原子性。i++ 这种操作不能保证原子性
 *
 */
public class Test01 {
    String string = "aaa";
    boolean flag = true;
    void setString(String bbb){
        string = bbb;
    }
    public void show() {
        System.out.println("start");
        while (flag) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("123");
            System.out.println(string);
        }
        System.out.println("end");
    }

    public static void main(String[] args) throws Exception {
        final Test01 test01 = new Test01();
        new Thread(() -> test01.show()).start();
        TimeUnit.SECONDS.sleep(3);
//        test01.flag = false;
//        test01.string = "bbb";
        test01.setString("asd");
    }
}
