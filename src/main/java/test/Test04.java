package test;

public class Test04 {
    public static void main(String[] args) throws Exception {
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024/1024.0);
        System.out.println("main.start");
        new Thread(()->{
            System.out.println("thread.start");
            try {
                Thread.sleep(5000);
                System.out.println("thread.end");
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(3000);
        System.out.println("main.end");


    }
}
