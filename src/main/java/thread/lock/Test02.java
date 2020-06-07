package thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test02 {
    //重入锁
    Lock lock = new ReentrantLock();

    void m1() {
        lock.lock();
        System.out.println("m1 lock");
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("m1 - " + i);
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
        ;
        System.out.println("m1 unlock");
        lock.unlock();
    }

    void m2() {

        lock.lock();
        try {

            System.out.println("m2 lock");
            Thread.sleep(1000);
            System.out.println("m2 unlock");

        } catch (Exception e) {
        }
        lock.unlock();
    }
    void m3(){
        System.out.println("m3");
        lock.unlock();
        System.out.println("m3 unlock");
    }

    public static void main(String[] args) throws Exception {
        Test02 test02 = new Test02();
        new Thread(() -> {
            test02.m1();
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            test02.m2();
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
//            test02.m3();
        }).start();
    }
}
