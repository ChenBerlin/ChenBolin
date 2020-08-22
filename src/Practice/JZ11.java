package Practice;
//二进制中1的个数
//题目描述
//输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
//知识点：进制转换、位运算
//思路：n&1求最低位，再右移1位；
public class JZ11 {
    public int NumberOf1(int n) {
        int num = 0;
        while (n!=0){
            num = (n&1)==1?num+1:num;
            n = n >>> 1;
        }
        return num;
    }
}
