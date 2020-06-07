package zxykj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * - （选答）计算最大差值
 * 有两组数，第一组数顺序固定，
 * 请编程实现让第二组数 相邻数字间的大小关系和第一组数相同，
 * 且 第二组相邻数字间的差值之和最大
 * 下面给出一个示例例
 * 第一组数： 5 7 4 9
 * 第二组数：1 2 3  4
 * 第二组数排序结果：2 4 1 3    //2 3 1 4
 * 第二组数排序后的差值之和：7  = abs(2-4) + abs(4-1) + abs(1-3)
 */
public class Test5 {
    public static boolean[] arrayBool = null;   //存储数组1中相邻的大小比较 i>i+1?true:false    size=array1.length-1
    static int[] result;    //存储排序后的数组2
    static int max_sum;     //存储排序后的数组2的差值之和

    /**
     * 1.保存数组1中相邻数的大小比较
     * 2.使用递归，找出数组2所有的排序组合
     * 3.在递归头中打印出当前的排序，并根据（步骤1）的比较结果判断此排序是否符合条件
     * 4.计算当前符合条件的数组的差值只和，比较并保存（bug：默认最大差值之和只有一组排序；只进行>比较，忽略=）
     * @param args
     */
    public static void main(String[] args) {
        int[] array1 = {5, 7, 4, 9};
        int[] array2 = {1, 2, 3, 4};
        arrayBool = new boolean[array1.length - 1];
        result = new int[array2.length];
        for (int i = 0; i < array1.length - 1; i++) {
            arrayBool[i] = array1[i] > array1[i + 1];
        }
        allSort(array2, 0, array2.length - 1);

        System.out.println("result->"+Arrays.toString(result));
        System.out.println("max_sum->"+max_sum);
    }

    static void allSort(int[] array, int begin, int end) {
//    ／／打印数组的内容
        if (begin == end) {
//            System.out.println(Arrays.toString(array));

            if (sortByArray1(array)) {
                int sum = getSum(array);
                if(sum>max_sum){
                    max_sum=sum;
                    for (int i = 0;i<result.length;i++){
                        result[i] = array[i];
                    }
                }
            }
            return;
        }
//    ／／把子数组的第一个元素依次和第二个、第三个元素交换位置
        for (int i = begin; i <= end; i++) {
            swap(array, begin, i);
            allSort(array, begin + 1, end);
//        ／／交换回来
            swap(array, begin, i);
        }
    }

    static void swap(int[] array, int a, int b) {
        int tem = array[a];
        array[a] = array[b];
        array[b] = tem;
    }

    //判断是否按数组1的大小顺序进行
    static boolean sortByArray1(int[] array) {
        boolean flag = true;
        for (int i = 0; i < array.length - 1; i++) {
            if ((array[i] > array[i + 1]) != arrayBool[i]) {
                flag = false;
            }
        }
        return flag;
    }

    static int getSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            sum += array[i] > array[i + 1] ? array[i] - array[i + 1] : array[i + 1] - array[i];
        }
        return sum;
    }
}
