package Practice;
//圆圈中最后剩下的数
//题目描述
//首先,让小朋友们围成一个大圈。然后,随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列并且不再回到圈中,从下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友。(注：小朋友的编号是从0到n-1)
//如果没有小朋友，请返回-1
//知识点：链表、迭代
//思路：一、迭代
//     二、链表模拟
public class JZ46 {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1){
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
