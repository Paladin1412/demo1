package groovy

import com.netty08.Person
import groovy.transform.TypeChecked


/**
 * @FileName: Test01.java* @Description: Test01.java类说明* @Author: wei.tang* @Date: 2020/5/24 12:05
 */
class Test01 {
    static void main() {



        def aa = new Person()
        aa.setName("张三")
        println aa
        println("aaaaaa")
        def num = 1
        println num == 1 ? true : false
    }

    static void file() {
        def file = new File("C:/Users/lenovo/Desktop/groovy.txt")
        println file

//        10.times {println(it)}
        println "-------------------------------"

        Person person = new Person()
        person.name = "zs"
        person.address = "湖北"
        person.age = 12
        println person

        println "-------------------------------"

        def a = "hello"
        def b = "Tom"
        def c = 1
        println("${a},$b,${c + 1}")

        def arr = ["aa", "bb"]
        def newList = []
        arr.collect(newList, {
            it.toUpperCase()
        })
        println(newList)


    }


    static void test() {
        def a = {
            println "a "+this
            println "a "+owner
            println "a "+delegate.toString()


            def b = {
                def i = 0
//                def arr = delegate
                arr.each {println(it)}
                println "b "+this
                println "b "+owner
                println "b "+delegate
            }

            b.setDelegate("aaaaaaaaa")
            b.call()
        }
        a.call()
        def arr = ['a', 'b']
        Closure closure

        arr.each {
            itt ->
                {
                    println itt
                }
        }
    }

    static void test2(){
        String.metaClass.upp = {
            -> "ssss"
            return "aaaaaa"
        }
        println "hello".upp()
        Person.metaClass.say = {
            -> Person person = new Person()
            person.name = "Tom"
            person.age = 18
            person.address = "湖北"
            return  "${"i'm "+person.name},i'm from $person.address,i'm $person.age"
//            return person
        }
        println new Person().say()
        Person.metaClass.run = {
            (Integer ina)->
            println ina
//            println owner.say()
            return "run"
        }
        new Person().run(12)
        println new Person().run(1)
    }

    @TypeChecked   //类型检查
    static void  test3(){
        def a = 12
//        int  qq = 1.1
        println a
//        println qq
        println( 1==1 ?:false)
        def person
        println person?.toString()

        println person.toString()


    }

    static void main(String[] args) {
//        main()
//        file()
//        test()
//        test2()
//        Person person = new Person()
test3()
    }
}
