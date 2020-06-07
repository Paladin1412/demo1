package thread;

import java.util.Arrays;

public class ThreadLocaltest {
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    public static Integer number = 0;

    public static void main(String[] args) {

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                threadLocal.remove();
                int intValue = threadLocal.get();
                intValue += 5;
                threadLocal.set(intValue);
                Utils.operation1();
                System.out.println(Thread.currentThread().getName() + " - " + threadLocal.get());
//                synchronized (number){
//                    number += 5;
//                }
//                System.out.println(Thread.currentThread().getName() + " - " + number);
            }, "thread-" + i);
            ;
        }

        Arrays.asList(threads).forEach(thread -> {
            thread.start();
        });


    }
}

class Utils {
    public static void operation1() {
        ThreadLocal<Integer> threadLocal = ThreadLocaltest.threadLocal;
        Integer value = threadLocal.get();
        System.out.println(Thread.currentThread().getName()+" operation1 "+value);
        value += 3;
        threadLocal.set(value);

    }
}
