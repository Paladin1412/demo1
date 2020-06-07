package thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test03 {
    //可打断锁  ,进入阻塞，可调用interrupt()进行打断，进入异常
    Lock lock = new ReentrantLock();
    void m1(){
        lock.lock();
        System.out.println("m1 lock");
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("m1 - " + i);
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
        System.out.println("m1 unlock");
        lock.unlock();
    }
    void m2(){
        try {
            lock.lockInterruptibly();
            System.out.println("m2");
        } catch (InterruptedException e) {
            System.out.println("m2 exception");
        }
    }

    public static void main(String[] args) throws Exception {
        Test03 test03 = new Test03();
        new Thread(()->{
            test03.m1();
        }).start();
        Thread.sleep(1000);
        Thread thread = new Thread(() -> {
            test03.m2();
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

}
