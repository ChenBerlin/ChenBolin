package Practice;
//从1到n中1出现的次数
//题目描述
//求出任意非负整数区间中1出现的次数
//知识点：数学
//思路：
public class JZ31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0)
                res += high * digit;
            else if(cur == 1)
                res += high * digit + low + 1;
            else
                res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
