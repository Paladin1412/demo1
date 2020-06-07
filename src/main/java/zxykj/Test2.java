package zxykj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * - （必答）邀请码检测
 * 某产品的⽤用户注册邀请码为⼀一串串有⼩小写字⺟母和数字组成的字符串串，
 * 字符串串⻓长度为16。
 * 当⽤用户数据邀 请码的时候，系统需要对邀请码做有效性验证，假设验证规则如下：
 * 1、 从序列列号最后⼀一位字符开始，逆向将奇数位(1、3、5等等)相加；
 * 2、从序列列号最后⼀一位数字开始，逆向将偶数位数字，先乘以2（如果乘积为两位数，则将其减去 9）
 * ，再求和；
 * 3、将奇数位总和加上偶数位总和，结果可以被10整除；
 * 4、⼩小写字⺟母对应数值，可由下⾯面键值对确定；
 * [(a,1), (b,2), (c,3)…,(i,9), (j,1), (k, 2)…]，亦即，按字⺟母顺序，1-9循环。
 * 输⼊入：输⼊入16位字符串串，表示邀请码 输出：输出“ok”或者“error”
 */
public class Test2 {
    private static Map<Character, Integer> map = new HashMap<>();


    /**
     * 1.初始化 k-v
     * 2.判断条件，逆向筛选奇偶
     * @param args
     */
    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            boolean result = analyzeCode(scanner.nextLine());
            System.out.println(result ? "ok" : "error");
        }
    }

    private static void init() {
        for (char i = 'a'; i <= 'z'; i++) {
            int val = (i - ('a' - 1)) % 9;
            map.put(i, val == 0 ? 9 : val);
        }
    }

    public static boolean analyzeCode(String code) {
        try {
            code = code.toLowerCase();
            char[] codes = code.toCharArray();
            int len = codes.length;
            if (len != 16) return false;
            int oddSum = 0; //奇数
            int evenSum = 0; //偶数

            for (int i = 1; i <= len; i++) {
                char char1 = codes[len - i];
                int num1 = map.get(char1);
                if (i % 2 == 1) {
                    oddSum += num1;  //逆向奇位数和
                } else {
                    //逆向偶位
                    int num3 = num1 * 2;
                    if (num3 >= 10 && num3 <= 99) {
                        evenSum += num3 - 9;
                    }
                }
            }
            if ((oddSum + evenSum) % 10 == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return false;
    }
}
