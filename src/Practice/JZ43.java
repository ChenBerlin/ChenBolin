package Practice;
//左旋转字符串
//题目描述
//对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
//知识点：字符串
//思路：取子串拼接
public class JZ43 {
    public String LeftRotateString(String str,int n) {
        if (str==null||n > str.length())
            return str;
        return str.substring(n,str.length())+str.substring(0,n);
    }
}
