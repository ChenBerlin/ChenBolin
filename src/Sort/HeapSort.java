package Sort;

import java.util.Scanner;
//堆排序
//稳定性：不稳定
//最佳情况：T(n) = O(nlog n)
//最差情况：T(n) = O(nlog n)
//平均情况：T(n) = O(nlog n)
//空间复杂度：O(1)
public class HeapSort {
    public static void main(String[] args) {
        int length = 0;
        Scanner scanner = new Scanner(System.in);
        length = scanner.nextInt();
        double arr[] = new double[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextDouble();
        }
        sort(arr,0,arr.length-1);
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static void sort(double[] arr, int i, int i1) {

    }
}
