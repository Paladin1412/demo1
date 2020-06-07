package thread.sync;

public class Test02 {
    synchronized void m1(){
        System.out.println("m1 start");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("m1 end");
    }
    synchronized void m2() throws InterruptedException {
        System.out.println("m2 start");
        try {
//            Thread.sleep(Integer.MAX_VALUE);
            System.out.println("m2 run");
        } catch (Exception e) {
            Thread.sleep(1000);
            e.printStackTrace();
        }
        System.out.println("m2 end");
    }
    public static void main(String[] args) throws Exception {
        Test02 test02 = new Test02();
        Thread thread = new Thread(() -> {
            test02.m1();
        });
        thread.start();

        Thread.sleep(1000);
        thread.interrupt();
        test02.m2();
    }
}
