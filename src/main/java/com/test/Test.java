package com.test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "We provide high-quality medical institutions with integrated information solutions including HIS, EMR, HRP, CRM, focusing on the core needs of the two industries: improving medical quality and enhancing medical trust";
        char[] chars = s.toCharArray();
        int cha = 0;
        int mark = 0;
        int space = 0;
        System.out.println(chars.length);
        for (char ch:chars ){
//            System.out.println((int)ch);
            if((ch >= 'a' && ch <= 'z') || (ch>='A' && ch<= 'Z')){
                cha++;
            }else if(ch == ' '){
                space++;
            }else {
                mark++;
            }
        }
        System.out.println("C "+cha);
        System.out.println("H "+mark);
        System.out.println("e "+space);


    }
}
