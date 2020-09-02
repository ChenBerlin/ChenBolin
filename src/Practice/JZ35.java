package Practice;
//数组中的逆序对
//题目描述
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
//知识点：数组
//思路：

public class JZ35 {
    public int InversePairs(int [] array) {
        if (array == null)
            return 0;
        int[] temp = new int[array.length];
        int sum = mergeSort(array, temp, 0, array.length-1);
        return sum;
        /*冒泡排序时间复杂度太高
        int temp = 0;
        //记录排好序的个数
        for (int i = 0; i < array.length-1; i++) {
            //遍历比较并排序。
            // arr.length-1-i表示排除数组末尾已排序的元素
            for (int j = 0; j < array.length-1-i; j++){
                //如果是 ...，5，4，x...
                if (array[j]>array[j+1]){
                    sum++;
                    temp = array[j];//...，5，4，x...  排序指针指向5
                    array[j] = array[j+1];//...，4，4，x...  排序指针指向第一个4
                    array[j+1] = temp;//...，4，5，x...  排序指针指向4，j++后继续比较5
                }
            }
        }
        return sum%1000000007;
        */
    }

    private int mergeSort(int[] array, int[] temp, int low, int high) {
        if (low >= high)
            return 0;
        int res = 0;
        int mid = low + (high - low) / 2;
        res += mergeSort(array, temp, low, mid);
        res += mergeSort(array, temp, mid + 1, high);
        res += merge(array, temp, low, mid, high);
        return res%1000000007;
    }

    private int merge(int[] array, int[] temp, int low, int mid, int high) {
        int res = 0;
        int h = low, h1 = low, h2 = mid + 1;
        while (h1 <= mid && h2 <= high) {
            if (array[h1] > array[h2]) {
                res += mid - h1 + 1;
                res %= 1000000007;
                temp[h++] = array[h2++];
            }
            else {
                temp[h++] = array[h1++];
            }
        }
        while (h1 <= mid) {
            temp[h++] = array[h1++];
        }
        while (h2 <= high) {
            temp[h++] = array[h2++];
        }
        for (int i = low; i <= high; i++) {
            array[i] = temp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        JZ35 jz35 = new JZ35();
        int[] a = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println(jz35.InversePairs(a));
    }
}
