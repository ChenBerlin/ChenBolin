package Practice;
//数值的整数次方
//题目描述
//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。保证base和exponent不同时为0
//知识点：循环
//思路：base==0;
//     exponent==0、exponent>0、exponent<0;
public class JZ12 {
    public static double Power(double base, int exponent) {
        if (base == 0)
            return 0;
        if (exponent == 0)
            return 1;
        double result = 1;
        if (exponent > 0){
            for (int i = 0; i < exponent; i++){
                result *= base;
            }
        }
        else {
            base = 1/base;
            for (int i = 0; i > exponent; i--){
                result *= base;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Power(2,-3));
    }
}
