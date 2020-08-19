package Practice;
//和为S的连续正数数列
//题目描述
//小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
//输出描述:输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序。
//知识点：穷举、等差数列
//思路：1、从两个连续正数开始遍历，求得中位数，遍历至中位数减位数的一半小于0为止
//     2、sum除位数，满足除奇余0或除偶余位数一半时加入结果数组。
//     3、反序输出
import java.util.ArrayList;
import java.util.Collections;

public class JZ41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 2; i < (sum/i)*2+1; i++) {
            //余数
            int temp = sum%i;
            //除奇余0
            if (i%2==1&&temp==0){
                ArrayList<Integer> arr = new ArrayList<>();
                int mid = sum/i;
                for (int j = 1; j < (i+1)/2; j++) {
                    arr.add(mid-(i+1)/2+j);
                }
                arr.add(mid);
                for (int j = 1; j < (i+1)/2; j++) {
                    arr.add(mid+j);
                }
                result.add(arr);
            }
            //除偶余半
            if (i%2==0&&temp==i/2){
                ArrayList<Integer> arr = new ArrayList<>();
                int mid = sum/i;
                for (int j = 1; j < temp+1; j++) {
                    arr.add(mid-temp+j);
                }
                for (int j = 1; j < temp+1; j++) {
                    arr.add(mid+j);
                }
                result.add(arr);

            }
        }
        //反转数组，从小到大排序。
        Collections.reverse(result);
        return result;
    }
}
