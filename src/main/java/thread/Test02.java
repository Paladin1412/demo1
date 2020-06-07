package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic***
 * 同步类型
 * 原子操作类型，其中每个方法都是原子性，可以保证线程安全
 */
public class Test02 {
    AtomicInteger count = new AtomicInteger(0);

    void plus(){
        for (int i = 0; i < 1000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args)  throws Exception{
        Test02 test02 = new Test02();
//        List<Thread> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            Thread thread = new Thread(()->{
                test02.plus();
            });
            thread.start();
            thread.join();
        }
//        for (int i = 0; i <10 ; i++) {
//            list.add(new Thread(()->{
//                test02.plus();
//            }));
//        }
//        list.forEach(thread -> {
//            thread.start();
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });

        System.out.println("ending---");
        System.out.println(test02.count);

    }
}
