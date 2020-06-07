package thread.lock;

public class Test01 {
    public static void main(String[] args) throws Exception {

        Thread thread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(Integer.MAX_VALUE);
                System.out.println("be interrupt");
            } catch (InterruptedException e) {
                System.out.println("InterruptedException e");
            }

        },"thread-01");
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();



    }
}
