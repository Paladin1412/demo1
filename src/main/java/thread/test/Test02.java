package thread.test;

import java.util.concurrent.CountDownLatch;

public class Test02 {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Test01 test01 = new Test01();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                test01.add(i);
                System.out.println("add num " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {

                int i = test01.size();
                System.out.println("size - " + i);
                if (i == 5) {

                    countDownLatch.countDown();
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        countDownLatch.await();
        System.out.println("长度为：5");
    }
}
