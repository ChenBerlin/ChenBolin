package Sort;

import java.util.Scanner;
//快速排序
//稳定性：不稳定
//最佳情况：T(n) = O(nlog n)
//最差情况：T(n) = O(n2)
//平均情况：T(n) = O(nlog n)
//空间复杂度：
//平均：O(log n)
//最差：O(n)
public class QuickSort {
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

    private static void sort(double[] arr, int start, int end) {
        if (arr == null || start>=end){
            return ;
        }
        else {
            //分区
            int position = partition(arr, start, end);
            //对左分区递归
            sort(arr, start, position-1);
            //对右分区递归
            sort(arr, position+1, end);
        }
    }

    private static int partition(double[] arr, int start, int end) {
        //保留基准副本
        double temp = arr[start];
        //当头下标<尾下标时
        while (start<end){
            //从尾部开始比较
            //若尾部元素大于基准，则继续。
            while (start<end&&temp<arr[end]){
                end--;
            }
            //否则把尾部元素赋值给基准
            //此时arr[start]存有一份，arr[end]存有两份。
            arr[start]=arr[end];
            //从头部再次比较
            //若头部元素小于基准，则继续。
            while (start<end&&arr[start]<temp){
                start++;
            }
            //否则把头部元素赋值给上次while停止时的尾部。
            //此时arr[start]存有两份，arr[end]存有一份。
            arr[end]=arr[start];
        }
        //把基准副本赋值给arr[start]
        arr[start] = temp;
        //此时start=end，返回值二者取其一就可。
        return end;
    }
}
