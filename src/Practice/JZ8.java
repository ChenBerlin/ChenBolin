package Practice;
//跳台阶
//题目描述
//一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
//知识点：递归、动态规划
//思路：一、递归（时间复杂度2^n)
//     二、动态规划（时间复杂度n）
public class JZ8 {
    public int JumpFloor(int target) {
        if (target <= 2)
            return target;
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= target; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
        /*递归
        if (target<=2){
            return target;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
        */
    }
}
