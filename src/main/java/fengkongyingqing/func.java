/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package fengkongyingqing;

import com.netty08.Person;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @FileName: func.java
 * @Description: func.java类说明
 * @Author: wei.tang
 * @Date: 2020/5/31 9:45
 */
public class func {

    public static void main(String[] args) {
        DecimalFormat format = new DecimalFormat("0.00");
//        AAA a = Utils::print;
//        a.aaa("asd");
//        String a = "";
//        System.out.println();
        double d1 = 2.22;
        double d2 = 3.33;
//        System.out.println(d1);
//        System.out.println(getDouble(d1));
//        double d3 = d1+d2;
//        System.out.println(d3);
//        System.out.println(getDouble(d3));
//        double d4 = getDouble(d1)+getDouble(d2);
//        System.out.println(d4);
//        System.out.println(getDouble(d4));

//        BigDecimal b1 = new BigDecimal(d1);

//        System.out.println(b1);
//        System.out.println(d1+d2);

        String format1 = format.format(d1);
        Double aDouble = Double.valueOf(format.format(d1));
        System.out.println(aDouble);
        System.out.println(format1);


    }


    private static Double getDouble(Double d){
        return Double.valueOf(String.format("%.2f", d));
    }




    public static void main4(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("asdfa");
        list.add("asdc");
        list.stream().forEach(Utils::print);


    }

    public static void main3(String[] args) {




        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("asdfa");
        list.add("asdc");
//        long count = list.stream().filter(t1 -> {
//            return false;
//        }).count();
//        System.out.println(count);
        list.stream().filter(s->s.length()>3).forEach(a->System.out.println(a));
        String collect1 = list.stream().filter(s -> s.length() > 3).collect(Collectors.joining());
        System.out.println(collect1);
        Stream<String> stringStream = list.stream().filter(s -> s.length() > 3);
        List<String> collect = stringStream.collect(Collectors.toList());
        System.out.println(collect);
        Collection<String> collect2;

    }

//    @SuppressWarnings("")
    public static void main2(String[] args) {
        PersonUtil util = new PersonUtil() {
            @Override
            public boolean add(List<Person> list) {
                System.out.println("aaaaaaaaaa");
                return false;
            }
        };

        util.add(null);

    }

    //函数式编程
    public static void main1(String[] args) {
        List<Person> list = new ArrayList<>();
//        System.out.println(PersonUtil::add);
        Person person = new Person();
        person.setName("asd");
        PersonInter inter = person1 -> {
            System.out.println(person1);
            return false;
        };
        System.out.println(inter.add(person));
    }


}
