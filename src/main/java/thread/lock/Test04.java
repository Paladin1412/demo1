package thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test04 {
    public static void main(String[] args) throws Exception {
//        Lock lock = new ReentrantLock();
        Test_ReenLock lock1 = new Test_ReenLock();
        Thread thread1 = new Thread(lock1);
        Thread thread2 = new Thread(lock1);
        thread1.start();
        thread2.start();
//        for (int i = 0; i < 10; i++) {
//            System.out.println("--- " + i);
//            lock.lock();
//            System.out.println(Thread.currentThread().getName() + " - " + i);
//            lock.unlock();
//        }


    }
}

 class  Test_ReenLock implements Runnable {
    Lock lock = new ReentrantLock(true);

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            lock.lock();
            System.out.println(Thread.currentThread().getName() +" - "+i);
            lock.unlock();
        }
    }
}
