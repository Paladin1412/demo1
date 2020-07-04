/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package test;

import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @FileName: aaaaaaaaaaa.java
 * @Description: aaaaaaaaaaa.java类说明
 * @Author: wei.tang
 * @Date: 2020/7/2 11:34
 */
public class aaaaaaaaaaa {
    public static void main(String[] args) {
        A a = new A();
        a.aa_bb = "hello";
        B b = new B();
        BeanUtils.copyProperties(a,b);
        System.out.println(b.aa_bb);
    }
    @Data
    static class A{
        String aa_bb;
    }
    @Data
    static class B{
        String aa_bb;
    }
}
