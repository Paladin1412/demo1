package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {



        int matrix = 0;
        int count = 0;
        Scanner scanner = new Scanner(System.in);

        int matrix_n = scanner.nextInt();
        matrix = matrix_n;

        int[][] matrixArr = new int[matrix][matrix];
//        List<Integer> list = new ArrayList<>();
//        while (scanner.hasNextInt()){
//            System.out.println("aaa");
//            list.add(scanner.nextInt());
//        }
//        System.out.println(list);


        for (int i = 0;i< matrix;i++){
            for (int j=i;j< matrix;j++){
                while (true){
                    System.out.print("matrixArr["+i+"]["+j+"]:");
                    int i1 = scanner.nextInt();
                    matrixArr[i][j] = i1;
                    matrixArr[j][i] = matrixArr[i][j];
                    if(i1 ==0 || i1==1){
                        break;
                    }
                }
            }
        }
        System.out.println("矩阵：");
        for (int i = 0;i< matrix;i++){
            for (int j=0;j<matrix;j++){
                System.out.print(matrixArr[i][j]+" ");
            }
            System.out.println();
        }


        for (int i=0;i<matrix;i++){
            if(matrixArr[i][i] == 0){
                count++;
            }
            if(i==matrix-1){
                continue;
            }
            for (int j=i+1;j<matrix;j++){
                if(matrixArr[i][j] == 0){
                    count++;
                }
            }
        }
        System.out.println(count+"台");
    }

}
