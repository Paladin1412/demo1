/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package com.shejimoshi.danli;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Comparator;

/**
 * @FileName: celue.java
 * @Description: celue.java类说明
 * @Author: wei.tang
 * @Date: 2020/6/5 21:54
 */
 public class Dog implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        return 0;
    }

    public static void main(String[] args) {
        Integer q = new Integer(99);
        Integer w = new Integer(99);
        int a = 99;
        System.out.println(q.equals(w));
        System.out.println(q==(int)w);
        System.out.println(q==w);
        System.out.println(q==a);
//        BigDecimal bigDecimal = new BigDecimal(1.1);
//        System.out.println(bigDecimal);
//        NumberFormat currency = NumberFormat.getCurrencyInstance();
//        System.out.println(currency.format(bigDecimal));
//        double a = 1.1344444444444;
//        double b = 2.2;
//        double c = a+b;
//        System.out.println(c);
//        System.out.println(Double.valueOf(String.format("%.2f", c)));
    }
}
