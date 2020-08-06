package Practice;
//求1+2+3+...+n
//题目描述
//求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//知识点：递归、位运算
//思路：短路与
public class JZ47 {
    public int Sum_Solution(int n) {
        boolean b = n>1&&(n+=Sum_Solution(n-1))>0;
        return n;
    }
}
