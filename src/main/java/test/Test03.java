package test;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Test03 {
    public static void main(String[] args) {
//        test01();
//        test02();
        test03();
    }

    private static void test03() {
        Dog dog = new Dog();
        List<Dog> dogs = new ArrayList<>();

        Long t1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
        Long t2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            dogs.add(dog);
        }
        Long t3 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println();
        }
        Long t4 = System.currentTimeMillis();

        System.out.println((t2 - t1) + " - " + (t3 - t2) + " - " + (t4 - t3));
    }

    private static void test01() {
        Dog dog = new Dog();
        dog.setId(1);
        dog.setName("dog1");
        dog.setDate(new Date());
        Dog dog1 = new Dog();
        dog1.setId(2);
        dog1.setName("dog2");
        dog1.setDate(new Date());
        List<Dog> dogs = Arrays.asList(dog, dog1);
        Cat cat = new Cat();
        List<Cat> cats = new ArrayList<>();
        BeanUtils.copyProperties(dog, cat);
//        BeanUtils.copyProperties(dogs,cats);

        System.out.println(cat);
        dogs.forEach(dog2 -> {
            Cat cat1 = new Cat();
            System.out.println(dog2 + "   -");
            BeanUtils.copyProperties(dog2, cat1);
            cats.add(cat1);
        });
        cats.forEach(ca -> {
            System.out.println(ca + "  -");
        });
    }

    private static void test02() {
        Dog dog = new Dog();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        String name = new String("dog");
        dog.setName(name);
        dog.setList(list);
        System.out.println(dog);
        String name1 = dog.getName() + "123";
        dog.getList().add(4);
        System.out.println(dog);
    }
}

@Data
class Dog {
    private int id;
    private String name;
    private Date date;
    private List<Integer> list;
}

@Data
class Cat {
    private int id;
    private String name;
}
@Data
class At {
    private int id;
    private String name;
}
