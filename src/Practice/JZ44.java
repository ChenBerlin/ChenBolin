package Practice;
//翻转单词顺序列
//题目描述
//"student. a am I" ==>"I am a student."；"   " ==>"   "
//知识点：字符串
//思路：判断是否全是空格，是则直接返回；不是则按空格分隔成String[]，按序输出。
public class JZ44 {
    public String ReverseSentence(String str) {
        String[] list = str.split(" ");
        if (str.length()==0|| list.length == 0)
            return str;
        String res = new String();
        for (int i = list.length - 1; i > 0; i--) {
            res += list[i] + " ";
        }
        res += list[0];
        return res;
    }

    public static void main(String[] args) {
        JZ44 jz44 = new JZ44();
        System.out.println(jz44.ReverseSentence("    "));
    }
}
