package thread;

import java.util.List;
import java.util.concurrent.*;

public class Thread1 {
    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(10);
        Future<?> future = executorService.submit(() -> {
            System.out.println("业务逻辑");
            try {
//                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        System.out.println("主线程---");
        System.out.println("future:"+future.get());
//        executorService.shutdown();
        List<Runnable> runnables = executorService.shutdownNow();
        System.out.println(runnables);

    }
}
