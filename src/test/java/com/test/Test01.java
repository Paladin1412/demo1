package com.test;


import com.sdk.PermissionTag;
import com.sun.deploy.net.HttpUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test01 {
    public static void main(String[] args) {
//        String aa = "　";
//        String bb = " ";
//        System.out.println(aa.length());
//        System.out.println(bb.length());
//        System.out.println(aa.equals(bb));
        testAnnotation();

//        Stu stu = new Stu();
//        stu.setId(1);
//        stu.setName("张三");
//        Stu stu2 = new Stu();
//        stu2.setId(1);
//        stu2.setName("张三");
//        change(stu);
//        change(stu2);
//        stu.setId(2);
//        System.out.println(stu.canEqual(Integer.class));
//        System.out.println(stu);
//        System.out.println(stu2);


//        System.out.println(1);
//        if (1 == 11) System.out.println("======");
//        else
//            throw new AAAAAException("aaaaaaaaa");
//        SimpleDateFormat format = new SimpleDateFormat();
//        format.format(new Date());
//        System.out.println(2);
//        System.out.println(3);


//        method();
//        PermissionInter permissionInter = new Permission();
//        System.out.println(permissionInter.message());
//        System.out.println(permissionInter.annotationType());
//
//        Test01 t = new Test01();
//        System.out.println(get(-1));
//        System.out.println("1111111111111111111111");
//        try {
//            Thread.sleep(Integer.MAX_VALUE);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static void change(Stu a) {
        a.setName("李四");
    }

    public static void testAnnotation() {
        Test01 test01 = new Test01();
        Class<? extends Test01> aClass = test01.getClass();
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
//            AnnotatedType annotatedReturnType = method.getAnnotatedReturnType();
//            System.out.println(annotatedReturnType);

//            System.out.println(method.isAnnotationPresent(PermissionTag.class) + "  -  " + method.getName());
            if(method.isAnnotationPresent(PermissionTag.class)){
                PermissionTag permissionTag = method.getAnnotation(PermissionTag.class);
                String message = permissionTag.message();
                System.out.println(message);
            }
        }
    }

    @PermissionTag(message = "aaa")
    public void tag() {

    }

    public static String get(int num) {
        try {
            if (num >= 0) {
                return "true";
            } else {
                throw new RuntimeException();
            }
        } finally {

        }
    }

}

class AAAAAException extends RuntimeException {
    public AAAAAException() {
    }

    public AAAAAException(String exception) {
        super(exception);
    }
}

//@Setter
//@Getter
@Data
class Stu {
    private int id;
    private String name;
}
