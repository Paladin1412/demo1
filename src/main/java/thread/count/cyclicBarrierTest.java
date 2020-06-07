/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package thread.count;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @FileName: cyclicBarrierTest.java
 * @Description: cyclicBarrierTest.java类说明
 * @Author: wei.tang
 * @Date: 2020/5/19 7:52
 */
public class cyclicBarrierTest {
    public static void main(String[] args) {
        bbb();
    }

    private static void bbb() {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(temp);
                    Thread.sleep(3000);
                } catch (Exception e) {
                } finally {
                    semaphore.release();
                }


            }, String.valueOf(i)).start();
        }
    }

    private void aaa() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            System.out.println("aaaaaaa");
        });
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
