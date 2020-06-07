package jdk8;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionTest {

    private static List<Student> students;


    private static void init() {
        students = new ArrayList<>();
        students.add(new Student(1, "张三", 43, "恩施"));
        students.add(new Student(2, "李四", 44, "安阳"));
        students.add(new Student(3, "王五", 42, "北京"));
        students.add(new Student(4, "赵六", 45, "重庆"));
        students.add(new Student(5, "韩七", 41, "当阳"));
    }

    public static void main(String[] args) {
        init();
        sort(students);


        students.forEach(student -> System.out.println(student));
    }

    public static void sort(List<Student> list) {
        Collections.sort(list, (student1, student2) -> (student1.getAge() - student2.getAge()));
//        Collections.sort(list, (student1, student2) -> student1.getAddress().compareTo(student2.getAddress()));
    }

}
