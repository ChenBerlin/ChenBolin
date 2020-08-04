package Sort;

import java.util.Scanner;

//冒归并排序
//稳定性：稳定
//最佳情况：T(n) = O(nlog n)
//最差情况：T(n) = O(nlog n)
//平均情况：T(n) = O(nlog n)
//空间复杂度：O(n)
public class MergeSort {

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
    private static void sort(double[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边递归
            sort(a, low, mid);
            // 右边递归
            sort(a, mid + 1, high);
            // 左右归并
            merge(a, low, mid, high);
        }

    }

    private static void merge(double[] a, int low, int mid, int high) {
        double[] temp = new double[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }
    }
}
