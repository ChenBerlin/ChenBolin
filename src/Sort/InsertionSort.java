package Sort;

import java.util.Scanner;
//插入排序
//稳定性：稳定
//最佳情况：T(n) = O(n)
//最坏情况：T(n) = O(n^2)
//平均情况：T(n) = O(n^2)
//空间复杂度：O(1)
public class InsertionSort {
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
        //arr[0]已经排好序，从arr[1]开始。
        for (int i = 1; i < arr.length; i++) {
            //取出当前arr[i]的值
            double temp = arr[i];
            //往前比较
            //j=i-1：当前下标元素的前一个元素
            for (int j = i-1; j > 0; j--) {
                //如果arr[i]<arr[j]，则arr[j]后移，继续往前比较。
                if (temp < arr[j]){
                    arr[j+1]=arr[j];
                }
                //如果arr[i]>=arr[j],则令当前下标元素值为temp，结束本次遍历。
                else {
                    arr[j+1]=temp;
                    break;
                }
            }
        }
        return arr;
    }
}
