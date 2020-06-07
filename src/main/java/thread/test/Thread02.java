package thread.test;

public class Thread02 implements Runnable {
    private Test06 test06;

    Thread02(Test06 test06) {
        this.test06 = test06;

    }

    @Override
    public void run() {
        try {
            synchronized (test06) {
                System.out.println("Thread02  唤醒其他线程");
                test06.notifyAll();
                test06.add0();

                System.out.println("Thread02  进入等待");
                test06.wait();
                System.out.println("Thread02  被唤醒");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
