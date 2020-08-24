package Practice;
//调整数组顺序使奇数在偶数前面
//题目描述
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
//知识点：数组
//思路：
public class JZ13 {
    public static void reOrderArray(int[] array) {
        int odd[] = new int[array.length];
        int oddindex = 0;
        int even[] = new int[array.length];
        int evenindex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                odd[oddindex] = array[i];
                oddindex++;
            }
            else {
                even[evenindex] = array[i];
                evenindex++;
            }
        }
        int index = 0;
        for (int i = 0; i < oddindex; i++,index++) {
            array[index] = odd[i];
        }
        for (int i = 0; i < evenindex; i++,index++) {
            array[index] = even[i];
        }

    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7};
        reOrderArray(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
