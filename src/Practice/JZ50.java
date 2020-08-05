package Practice;
//数组中重复的数字
//题目描述
//在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
//知识点：数组
//思路：一、把numbers[i]依次传入list，传入前调用contains。
//     二、理论上将i放在numbers[i]的位置，若位置上有值则重复。（空间复杂度O(1)，待实现）
import java.util.ArrayList;
import java.util.List;

public class JZ50 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length <= 0)
            return false;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (!list.contains(numbers[i])) {
                list.add(numbers[i]);
            }
            else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
        /*以下方法二代码有BUG
        Integer num = null;
        int temp = 0;
        for (int i = 0; i < numbers.length;i++) {
            if (numbers[i]==i){
                continue;
            }
            temp = numbers[i];
            while (temp!=numbers[numbers[i]]&&i!=temp) {
                numbers[i] = i;
                temp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
            }
            num = temp;
            break;
        }
        return num!=null?true:false;*/
    }
}
