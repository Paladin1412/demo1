package thread.volatil;

public class VolatileTest02 {
    private static volatile VolatileTest02 instance = null;
    private VolatileTest02(){
        System.out.println(Thread.currentThread().getName()+"  VolatileTest02()");
    }
    public static VolatileTest02 getInstance(){
        if (instance==null){
            synchronized (VolatileTest02.class){
                if (instance == null){
                    instance = new VolatileTest02();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {

        for (int i = 0; i < 10000*100; i++) {
            new Thread(()->{
                VolatileTest02.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
