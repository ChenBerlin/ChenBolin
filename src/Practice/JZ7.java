package Practice;
//斐波那契数列
//题目描述
//要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
//知识点：数组、递归
//思路：一、for循环
//     二、递归（时间复杂度较高）
public class JZ7 {
    public int Fibonacci(int n) {
        if (n <= 1){
            return n;
        }
        int a = 0;
        int b = 1;
        int result = 0;
        for (int i = 1; i < n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}
