package zxykj;

import java.util.ArrayList;
import java.util.List;

/**
 * - （选答）有趣的两位数
 * 有数学家发现⼀一些两位数很有意思，
 * ⽐比如， 34 * 86 = 43 * 68 也就是说，
 * 如果把他们的⼗十位数和个位数交换，⼆二者乘积不不变。
 * 编程求出满⾜足该性质的两位数组合。
 * 提示，暴暴⼒力力解法⾮非最优解
 */
public class Test4 {
    /**
     * 1.解析每个位上的数字进行组合判断
     * 2.添加到数组
     * @param args
     */
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        for (int i = 1000; i < 9999; i++) {
            if (analyzeNum(i)) {
                int num1 = i / 100;
                int num2 = i % 100;
                int[] arr = {num1, num2};
                list.add(arr);
//                System.out.println(num1 + " " + num2);
            }
        }
        list.forEach(ar -> {
            System.out.println(ar[0] + "-" + ar[1]);
        });


    }



    private static boolean analyzeNum(int num) {
        int a = num / 1000; //千位
        int b = (num - 1000 * a) / 100; //百位
        int c = (num - 1000 * a - 100 * b) / 10;    //十位
        int d = num % 10;   //个位
        if (a == 0 || b == 0 || c == 0 || d == 0) return false;
        int num1 = (10 * a + b);
        int num2 = (10 * c + d);
        int num3 = (10 * b + a);
        int num4 = (10 * d + c);
        // num1*num2 == num3*num4
        // num1 <= num2 避免重复
        if (num1 <= num2 && num1 * num2 == num3 * num4) {
            return true;
        }
        return false;
    }


}
