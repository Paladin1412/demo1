package thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁：
 *  建议应用的同步方式，相对效率比synchronized高，量级较轻
 *
 *
 *
 */
public class Test_Reentrelock {
    public static void main(String[] args) throws Exception {
        //重入锁、尝试锁、可打断锁、公平锁(带参数true)
        Lock lock = new ReentrantLock();
        lock.lock();    //开始锁
        lock.unlock();  //结束锁，如果没有持有锁标记，一定会抛出异常

        lock.tryLock(); //尝试锁
        lock.tryLock(5, TimeUnit.SECONDS);  //尝试5次，每次1秒


        Thread thread = new Thread(() -> {
            try {
                lock.lockInterruptibly();   //可尝试打断，进入阻塞状态
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        thread.start();
        thread.interrupt(); //强制打断线程，打断后，直接抛出异常
    }
}
