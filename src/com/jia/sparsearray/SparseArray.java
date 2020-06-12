package com.jia.sparsearray;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ButterflyStars
 * @DateTime: 2020/6/13 0:31
 * Description: No Description
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0 表示没有棋子 1 表示黑子 2 表示蓝子
        int[][] chessArry1= new int[11][11];
        chessArry1[1][2] = 1;
        chessArry1[2][3] = 2;
        // 循环遍历取到了每一行
        System.out.println("原始数组：");
        for (int[] row: chessArry1) {
            for( int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        // 二维数组转稀疏数组思路：1. 先遍历原始数组，得到非0数据的个数
        int sum = 0;
        for (int[] row: chessArry1) {
            for( int data : row){
               if (data != 0){
                   sum++;
               }
            }
        }
        // 2. 创建相应的稀疏数组
      int[][] sparseArry= new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArry[0][0] = 11;
        sparseArry[0][1] = 11;
        sparseArry[0][2] = sum;
        // 遍历二维数组，将非0值放入稀疏数组中
        int count = 0;  // count 用于记录是第几个非零数据
        for (int i = 0; i < chessArry1.length; i++){
            for (int j = 0; j < chessArry1[i].length; j++){
                if (chessArry1[i][j] != 0){
                    count++;
                    sparseArry[count][0] = i;
                    sparseArry[count][1] = j;
                    sparseArry[count][2] = chessArry1[i][j];
                }
            }
        }

        System.out.println("得到的稀疏数组为：");
        for (int i = 0; i < sparseArry.length; i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArry[i][0],sparseArry[i][1],sparseArry[i][2]);
        }
        System.out.println();

        /**
         * 将稀疏数组恢复为原始数组
         * 1.读取稀疏数组第一行，根据第一行的数据创建原始数组
         * 2.再读取稀疏数组后几行(从第二行开始遍历）的数据并赋值给原始的二维数组即可
         */

        int[][] chessArry2= new int[sparseArry[0][0]][sparseArry[0][1]];
        for (int i = 1; i < sparseArry.length; i++){
            chessArry2[sparseArry[i][0]][sparseArry[i][1]] = sparseArry[i][2];
        }
        // 输出恢复后的原始数组
        for (int[] row: chessArry2) {
            for( int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }
}
