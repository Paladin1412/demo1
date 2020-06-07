package groovy

import com.netty08.Person

/**
 * @FileName: Test02.java* @Description: Test02.java类说明* @Author: wei.tang* @Date: 2020/5/24 19:06
 */
class Test02 {

    static void test1() {
        def arr1 = [3, 1, 24, 5, 2]
//        def sort = arr1.sort()
//        arr1.sort()
        arr1.sort({
            c, d -> c < d ? -1 : 1
        })
        println arr1
        def a = {
            it < 5
        }
        def find = arr1.findAll(a)
        def find1 = arr1.findAll(q -> { q < 10 })
        println(find)
        println(find1)
//        println sort
    }

    static void test2() {
        Person person = new Person()
        person.age = 12
        Person person1 = new Person()
        person1.age = 10
        Person person2 = new Person()
        person2.age = 15
        def arr = []
        arr.add(person)
        arr.add(person1)
        arr.add(person2)
        def so = {
            p1, p2 ->
                {
                    p1.age < p2.age ? -1 : 1
                }
        }
        arr.sort(so)
        println arr

        def arr1 = [1,2,3]
        def arr1_copy
        arr1_copy = arr1.collect({ it * it })
        println arr1_copy

    }


    public static void main(String[] args) {
//        test1()
        test2()
    }

}
