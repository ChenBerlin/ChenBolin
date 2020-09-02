package Practice;
//最小的K个数
//题目描述
//输入n个整数，找出其中最小的K个数。
//知识点：数组、排序
//思路：一、快排 二、堆排
import java.util.ArrayList;
import static java.util.Arrays.sort;

public class JZ29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input==null || input.length==0 || k<=0 || k > input.length)
            return list;
        sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
    /* HeapSort
    public int[] sort(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (double a:arr
        ) {
            System.out.print(a+" ");
        }
        System.out.println();
        //开始排序
        int temp = 0;
        for (int i = arr.length-1; i > 0; i--) {
            //大根堆最大值永远是arr[0]
            //将最大值和末尾值互换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //length=i -->排除已排序的元素再调整大根堆
            adjustHeap(arr, 0, i);
        }
        return arr;
    }
    private void adjustHeap(int[] arr, int parent, int length) {
        //temp暂存父节点的值
        int temp = arr[parent];
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
    }*/
}
