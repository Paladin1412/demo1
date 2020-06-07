package zxykj;

import java.util.Scanner;

/**
 * - （必答）游戏币组合
 * ⼩小明的抽屉⾥里里有n个游戏币，总⾯面值m，
 * 游戏币的设置有1分的，2分的，5分的，10分的，
 * ⽽而在⼩小明 所拥有的游戏币中有些⾯面值的游戏币可能没有，
 * 求⼀一共有多少种可能的游戏币组合⽅方式？
 * 输⼊入：输⼊入两个数n(游戏币的个数)，m(总⾯面值)。
 * 输出：请输出可能的组合⽅方式数；
 */
public class Test3 {
    /**
     * @param args
     */
    public static void main(String[] args) {
//        int n = 6;
//        int m = 16;
//        1分:2  2分:2  5分:2  10分0
//        1分:4  2分:1  5分:0  10分1

        while (true) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int m = scanner.nextInt();
//            System.out.println(n + " - " + m);

            for (int num_1 = 0; num_1 <= n; num_1++) {//最大值，就算全为1分的，最多只有m个
                for (int num_2 = 0; num_2 <= n - num_1; num_2++) {
                    for (int num_5 = 0; num_5 <= n - num_1 - num_2; num_5++) {
//                        for (int num_10 = 0; num_10 <= n-num_1-num_2-num_5; num_10++) {
                            int num_10 = n - num_1 - num_2 - num_5;
                            int i = num_1 * 1 + num_2 * 2 + num_5 * 5 + num_10 * 10;    //总面值
                            int i1 = num_1 + num_2 + num_5 + num_10;    //游戏币的个数
                            if (i == m && i1 == n) {        //与输出的n、m进行比较
                                System.out.println("1分:" + num_1 + "  2分:" + num_2 + "  5分:" + num_5 + "  10分" + num_10);
                            }
//                        }
                    }
                }
            }

        }
    }
}
