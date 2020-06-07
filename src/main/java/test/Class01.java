package test;

import com.netty08.Person;

import java.util.ArrayList;
import java.util.List;

public class Class01<T>  {
    Class<T> clazz;
    List<T> list;
    Class01(){
        this.list = new ArrayList<>();
    }
    Class01(List<T> list){
        this.list = list;
    }
    public void show(){
        System.out.println(clazz);
    }
    public Class01<T> add(T tt){
        System.out.println(tt.toString());
        this.list.add(tt);
        return this;
    }
    public int size(){
        return list.size();
    }
    public Class01<T> slice(){
        return new Class01<>(list);
    }

    public static void main(String[] args) {
        Class01<Person> class01 = new Class01<>();
        class01.show();
        Person person = new Person();
        person.setName("张三");
        class01.add(person).add(person);
        System.out.println(class01.size());

        Class01<Person> slice = class01.slice();
        slice.add(person);
        System.out.println(class01.size());

    }
}
