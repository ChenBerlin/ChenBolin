package Practice;
//数组中只出现一次的数字
//题目描述
//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
//知识点：位运算
//思路：异或找出特征位
public class JZ40 {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int res = 0;
        for (int i :
                array) {
            res ^= i;
        }
        res &= (-res);
        for (int i :
                array) {
            if ((i & res) != 0) {
                num1[0] ^= i;
            }
            else
                num2[0] ^= i;
        }
    }
}
