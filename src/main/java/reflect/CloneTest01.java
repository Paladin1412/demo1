package reflect;

import com.netty08.Person;
import test.Test03;

import java.lang.reflect.Method;

public class CloneTest01 {
    public static void main(String[] args) throws Exception {

        Person person = new Person();
        person.setName("张三");
        person.setAddress("湖北武汉");
        person.setAge(20);
        System.out.println(person);
        Person person1 = person;
        Person clone = (Person) person.clone();
        clone.setName("王五");
        person1.setName("李四");
        System.out.println(person);
        System.out.println(person1);
        System.out.println(clone);

    }
}
