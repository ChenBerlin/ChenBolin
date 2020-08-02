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
        sort(arr);
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static void sort(double[] arr) {
        //将待排序序列初始化成大根堆
        //i=(arr.length-1)/2  -->对于二叉树，满足父节点个数+1=叶节点个数||父节点个数=叶节点个数。
        //(arr.length-1)/2  -->保证了从最后一个非叶子节点索引开始
        //i--  -->从最后一个父节点索引往前调整
        //i取整：若有小数，直接舍弃小数部分。
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (double a:arr
             ) {
            System.out.print(a+" ");
        }
        System.out.println();
        //开始排序
        double temp = 0;
        for (int i = arr.length-1; i > 0; i--) {
            //大根堆最大值永远是arr[0]
            //将最大值和末尾值互换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //length=i -->排除已排序的元素再调整大根堆
            adjustHeap(arr, 0, i);
        }
    }
    /**
     * 调整堆
     * @param arr 待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private static void adjustHeap(double[] arr, int parent, int length) {
        //temp暂存父节点的值
        double temp = arr[parent];
        //设左子节点索引为child
        //则左节点在数组中索引为2*parent+1
        int child = 2*parent + 1;
        while (child < length){
            //child+1为右子节点索引
            //如果有右子节点，从左子节点和右子节点中选取较大的
            if (child+1<length && arr[child]<arr[child+1]){
                child++;
            }
            //如果父节点的值已经大于子结点的值，则直接结束
            if (temp>=arr[child]){
                break;
            }
            //此时父节点值小于所选取的子节点的值
            //将父节点与较大的子节点进行交换
            arr[parent] = arr[child];
            parent = child;
            child = 2*child + 1;
        }
        arr[parent] = temp;
    }
}
