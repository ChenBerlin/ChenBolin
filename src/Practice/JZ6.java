package Practice;
//旋转数组的最小数字
//题目描述
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
//NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
//知识点：二分
//思路：有序=>二分查找
public class JZ6 {
    public static int minNumberInRotateArray(int [] array) {
        if (array==null)
            return 1;
        int head = 0;
        int tail = array.length-1;
        int index = (head+tail)/2;
        while (head<=tail) {
            if (array[index]>array[index+1]) {
                return array[index+1];
            }
            if (array[index]<array[index-1]) {
                return array[index];
            }
            if (array[index]<array[tail]) {
                tail = index - 1;
            }
            else {
                head = index + 1;
            }
            index = (head+tail)/2;
        }
        return 0;
    }

    public static void main(String[] args) {
        int a[] = new int[10];
        minNumberInRotateArray(a);
    }
}
