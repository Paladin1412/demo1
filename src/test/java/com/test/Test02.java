package com.test;

import org.springframework.scheduling.annotation.Async;

import java.util.Date;

public class Test02 {
    public static void main(String[] args) {
        Test02 test02 = new Test02();
        test02.async();
        while (true){
            System.out.println(Thread.currentThread().getName()+" * "+new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Async
    public void async(){
        while (true){
            System.out.println(Thread.currentThread().getName()+" - "+new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
