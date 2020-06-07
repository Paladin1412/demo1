package thread.test;

public class Thread01 implements Runnable {
    private Test06 test06;

    Thread01(Test06 test06) {
        this.test06 = test06;
    }

    @Override
    public void run() {
        try {
            synchronized (test06) {
                Thread.sleep(2000);
                System.out.println("Thread01 进入等待");
                test06.wait();
                System.out.println("Thread01 被唤醒");
                test06.add0();
                Thread.sleep(1000);

                System.out.println("Thread01 唤醒其他线程");
                test06.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
