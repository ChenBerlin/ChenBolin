package Practice;
//和为S的两个数字
//题目描述
//输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
//知识点：双指针
//思路：头尾指针
import java.util.ArrayList;

public class JZ42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length-1; j > i; j--) {
                if (array[i]+array[j]==sum){
                    if (temp==0||temp>array[i]*array[j]){
                        temp = array[i]*array[j];
                        result.clear();
                        result.add(array[i]);
                        result.add(array[j]);
                    }
                }
            }
        }
        return result;
    }
}
