package Sort;

import java.util.Scanner;
//冒泡排序
//稳定性：稳定
//最佳情况：T(n) = O(n)
//最差情况：T(n) = O(n^2)
//平均情况：T(n) = O(n^2)
//空间复杂度：O(n)
public class BubbleSort {
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
        double temp = 0;
        //记录排好序的个数
        for (int i = 0; i < arr.length-1; i++) {
            //遍历比较并排序。
            // arr.length-1-i表示排除数组末尾已排序的元素
            for (int j = 0; j < arr.length-1-i; j++){
                //如果是 ...，5，4，x...
                if (arr[j]>arr[j+1]){
                    temp = arr[j];//...，5，4，x...  排序指针指向5
                    arr[j] = arr[j+1];//...，4，4，x...  排序指针指向第一个4
                    arr[j+1] = temp;//...，4，5，x...  排序指针指向4，j++后继续比较5
                }
            }
        }
        return arr;
    }

}
