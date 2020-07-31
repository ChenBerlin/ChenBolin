package Sort;

import java.util.Scanner;
//选择排序
//稳定性：不稳定 数据规模越小越好
//最佳情况：T(n) = O(n^2)
//最差情况：T(n) = O(n^2)
//平均情况：T(n) = O(n^2)
//空间复杂度：O(1)
public class SelectionSort {
    public static void main(String[] args) {
        int length = 0;
        Scanner scanner = new Scanner(System.in);
        length = scanner.nextInt();
        double arr[] = new double[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextDouble();
        }
        for (int i = 0; i < length; i++) {
            System.out.print(sort(arr)[i]+" ");
        }
    }

    private static double[] sort(double[] arr) {
        //记录最小值下标
        int index = 0;
        for (int i = 0; i < arr.length-1; i++) {
            //从第i个元素开始比较
            index = i;
            //遍历数组找出最小值下标
            for (int j = i+1; j < arr.length; j++) {
                if (arr[index]>arr[j]){
                    index = j;
                }
            }
            //将每次遍历的最小值和第i个元素交换位置
            double temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
