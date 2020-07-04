package thread.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test05 {
    static AtomicInteger i = new AtomicInteger(0);
    int k = 0;
    Lock lock = new ReentrantLock();


    public static void add() {
        i.addAndGet(1);

    }

    public void add1() {
        lock.lock();
        try {
            Thread.sleep(1000);
            System.out.println("add1 " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void add2() {
        lock.lock();
        try {
            System.out.println("add2 " + Thread.currentThread().getName());
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test05 test05 = new Test05();
        new Thread(() -> {
            test05.add1();
        }, "t1").start();
        System.out.println(test05.k);
        new Thread(() -> {
            test05.add1();
        }, "t2").start();
        new Thread(() -> {
            test05.add2();
        }, "t3").start();

    }

    public static void test02() {


    }

    public static void test01() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield(); //线程暂停，放弃CPU资源
        }
        System.out.println(i);
    }

    public static void threadTest() throws InterruptedException {
        Thread thread = Thread.currentThread();
        thread.start();
        thread.interrupt();
        thread.join();
        thread.getName();
        thread.getId();
        thread.getState();
        thread.isAlive();
    }


}
