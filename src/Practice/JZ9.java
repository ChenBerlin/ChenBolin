package Practice;
//变态跳台阶
//题目描述
//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
//知识点：贪心、递归、排列组合
//思路：等价于从n个数中任取m个数（所取的m个数，即为青蛙落脚的台阶），一共有多少种取法。Cn1+Cn2+...+Cnn=2^n
public class JZ9 {
    public int JumpFloorII(int target) {
        int result = 1;
        for (int i = 0; i < target-1; i++){
            result *= 2;
        }
        return result;
    }
}
