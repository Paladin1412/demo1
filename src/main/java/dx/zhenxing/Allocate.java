/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package dx.zhenxing;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 分配任务模拟场景：
 * 1、将n件待分配的事件，平均分配给每个员工
 * 2、分配采取最优分配，即当前所分配事件最少的员工最先分配
 * 3、可以设置每个员工的事件分配上限
 *
 * 逻辑：
 * 1、获取到所有的员工信息、待分配事件信息
 * 2、循环遍历待分配事件，并将其分配给当前事件量最少的员工
 */
public class Allocate {
    private static List<Person> persons = new ArrayList<>();
    private static List<Cases> cases = new ArrayList<>();
    private static int maxCases;

    private static void init(int caseNum, int maxCase) {
        maxCases = maxCase;
        Person person1 = new Person(1L, "张三", 15);
        Person person2 = new Person(2L, "李四", 10);
        Person person3 = new Person(3L, "王五", 5);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        for (int i = 1; i <= caseNum; i++) {
            cases.add(new Cases(Long.valueOf(i), 0));
        }
    }

    private static void allocate() {
        cases.forEach(cases1 -> {
            //todo 获取当前事件量最少的员工
            Optional<Person> min = persons.stream().
                    filter(person1 -> person1.caseNum < maxCases).
                    min((p1, p2) -> p1.caseNum > p2.caseNum ? 1 : -1);
            if (!min.isPresent()) {
                return;
            }
            //todo 任务分配
            Person person = min.get();
            cases1.setStatus(1);
            cases1.setPerson(person);
            person.setCaseNum(person.getCaseNum() + 1);
        });
    }


    public static void main(String[] args) {
        int caseNum = 10;   //待分配的事件
        int maxCase = 13;   //每个员工所分配事件的上限数
        init(caseNum, maxCase);
        allocate();
        print();
    }

    private static void print() {
        cases.forEach(System.out::println);
        System.out.println();
        persons.forEach(System.out::println);
    }


    @Setter
    @Getter
    static class Cases {
        Cases() {
        }

        Cases(Long caseId, Integer status) {
            this.caseId = caseId;
            this.status = status;
        }

        Long caseId;
        Integer status;
        Person person;

        @Override
        public String toString() {
            return "Cases{" +
                    "caseId=" + caseId +
                    ", status=" + status +
                    ", person=" + person +
                    '}';
        }
    }


    @Getter
    @Setter
    static class Person {
        public Person() {
        }

        public Person(Long id, String name, Integer caseNum) {
            this.id = id;
            this.name = name;
            this.caseNum = caseNum;
        }

        Long id;
        String name;
        Integer caseNum;

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", caseNum=" + caseNum +
                    '}';
        }
    }


}
