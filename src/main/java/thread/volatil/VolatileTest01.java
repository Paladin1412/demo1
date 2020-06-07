package thread.volatil;

public class VolatileTest01 {
    private  boolean shutdown = false;
    public void dowork(){
        int i = 0;
        while (!shutdown){
//            work();
            System.out.println("work "+(++i));
        }
        System.out.println("stop work");
    }
    private void work(){
        System.out.println("work");
    }

    public void stop(){
        this.shutdown = true;
    }

    public static void main(String[] args) {
        VolatileTest01 test = new VolatileTest01();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test.stop();
        }).start();
        test.dowork();

    }

}
