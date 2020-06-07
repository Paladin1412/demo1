package com.shejimoshi.danli;

/**
 * @FileName: Single4.java
 * @Description: Single4.java类说明
 * @Author: wei.tang
 * @Date: 2020/6/5 21:30
 */
public enum Single4 {
    SINGLE;
    public void print(){
        System.out.println("hello - "+Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Single4.SINGLE.hashCode());
            }).start();
        }
    }
}
