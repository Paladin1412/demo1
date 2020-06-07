package test;

import java.util.Date;

public class Test01 {
    final int aaa = 11;

    public static void main(String[] args) {
        int i = 2;
        int j, k;
        k = i++;

        j = ++i;
        System.out.println(k + " " + j);
        Date date = new Date();
        System.out.println(date.toString());
    }


}
