package thread.sync;

import java.util.concurrent.ConcurrentHashMap;

public class Test01 {
    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        objectObjectConcurrentHashMap.put("","");
        Sync_Test sync_test = new Sync_Test();
        Sync_Test sync_test2 = new Sync_Test();
        new Thread(()->{sync_test.m1();}).start();
        new Thread(()->{sync_test2.m1();}).start();
        new StringBuilder();
    }
}
class Sync_Test{

     synchronized void m1(){
        System.out.println("m1 begin");
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 end");

    }

}
