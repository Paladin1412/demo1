package fengkongyingqing;

import com.netty08.Person;

/**
 * @FileName: PersonInter.java
 * @Description: PersonInter.java类说明
 * @Author: wei.tang
 * @Date: 2020/5/31 10:09
 */
@FunctionalInterface  //jdk提供，只能有一个抽象方法
public interface PersonInter {
    boolean add(Person person);
//    boolean add1(Person person);
}
