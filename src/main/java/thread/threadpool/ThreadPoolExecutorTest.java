/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package thread.threadpool;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        int cpuNum = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = new ThreadPoolExecutor(
                cpuNum,
                (int) (cpuNum / (1 - 0.9)),
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>((int) (cpuNum / (1 - 0.9))),
                new ThreadFactory() {
                    private final AtomicInteger atomicInteger = new AtomicInteger(1);

                    @Override
                    public Thread newThread(@NotNull Runnable r) {
                        Thread t = new Thread(r);
                        t.setName("ThreadPoolExecutorTest-" + atomicInteger.getAndIncrement());
                        t.setDaemon(false);
                        t.setPriority(Thread.NORM_PRIORITY);
                        return t;
                    }
                },
                //jdk提供四种handler，默认是抛出异常
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(executor.toString() + "拒绝创建线程");
                    }
                });
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "   hello");
            });
        }
        executorService.shutdown();
    }

    private void createThreadPool() {
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(10);
        Executors.newSingleThreadExecutor();
    }

}
