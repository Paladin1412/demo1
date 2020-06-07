package com.test;


import redis.clients.jedis.Jedis;
import sun.security.ec.SunEC;

public class Test04 {
    private static int num=1;
    private static int number=10;

    static {
        num = 2;
        number=20;
        System.out.println(num+" - "+number);
    }

    public static void main(String[] args){
        System.out.println(num);
        System.out.println(number);




//        char[] c = "0123456789".toCharArray();
//        String s = new String(0,10, c);
//        String s = new String(c,0,10);
//        System.out.println(s);
//        Integer i = new Integer(1);
//        System.out.println(i.getClass().getClassLoader());
//        System.out.println(s.getClass().getClassLoader());
//        Test04 test04 = new Test04();
//        System.out.println(test04.getClass().getClassLoader());
//        Jedis jedis = new Jedis();
//        System.out.println(jedis.getClass().getClassLoader());
//        Runtime runtime = Runtime.getRuntime();
//        System.out.println(runtime.getClass().getClassLoader());

//        ClassLoader classLoader = SunEC.class.getClassLoader();
//        System.out.println(classLoader);
//        System.out.println(classLoader.getParent());
    }

}
