package Practice;

import java.util.Scanner;

//不用加减乘除做加法
//题目描述
//写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
//知识点：进制转换、数学
//思路：使用位运算
public class JZ48 {
    public static int Add(int num1,int num2) {
        int temp;
        while (num2!=0){
            //异或运算保存本位
            temp = num1 ^ num2;
            //与运算并左移一位保存进位
            num2 = (num1 & num2)<<1;
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println(Add(num1,num2));
    }
}
