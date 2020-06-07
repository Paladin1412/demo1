package thread;

import com.netty08.Person;

import java.util.Arrays;

public class ThreadLocaltest1 {
    public static ThreadLocal<Person> threadLocal = new ThreadLocal<Person>(){
        @Override
        protected Person initialValue() {
            Person person = new Person();
            person.setName("张三");
            person.setAge(10);
            person.setAddress("湖北");
            return person;
        }
    };


    public static void main(String[] args) {

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            int i1 = i;
            threads[i] = new Thread(() -> {
                Person person = threadLocal.get();
                person.setAge(person.getAge()+5);
                person.setName(person.getAddress()+i1);
                person.setAddress(person.getAddress()+i1);
                threadLocal.set(person);
                Utils1.operation1();
                System.out.println(Thread.currentThread().getName() + " - " + threadLocal.get());
            }, "thread-" + i);
            ;
        }

        Arrays.asList(threads).forEach(thread -> {
            thread.start();
        });


    }
}

class Utils1 {
    public static void operation1() {
        ThreadLocal<Person> threadLocal = ThreadLocaltest1.threadLocal;
        Person person = threadLocal.get();
        System.out.println(Thread.currentThread().getName()+" operation1 "+person);
        person.setName(person.getName()+Thread.currentThread().getName());
        person.setAge(person.getAge()+3);
        person.setAddress(person.getAddress()+Thread.currentThread().getName());
        threadLocal.set(person);
    }
}
