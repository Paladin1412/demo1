package thread.test;

public class Test03 {
    public static void main(String[] args) {
        Object object = new Object();
        Test01 test01 = new Test01();

        new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName());
                try {
                    if (test01.size() != 5) {
                        object.wait();
                    }
                    System.out.println("size -> 5");
                    object.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName());
                try {
                    for (int i = 0; i < 10; i++) {
                        test01.add(i);
                        System.out.println("add num : "+i);
                        if(test01.size()==5){
                            object.notifyAll();
                            object.wait();
                        }
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
