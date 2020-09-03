package Practice;
//把字符串转换成整数
//题目描述
//将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
//知识点：字符串、ASCII码
//思路：判断正负，再判断是否合法。
public class JZ49 {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;

        int res = 0;
        char[] chars = str.toCharArray();
        int index = 0;

        if (chars[0]=='+'||chars[0]=='-') {
            index++;
            if (index >= chars.length)
                return 0;
        }
        if (chars[index] == '0')
            return 0;

        while (index < chars.length) {
            char c = chars[index];
            if (c >= '0' && c <= '9') {
                res *= 10;
                res += (c - '0');
                index++;
            }
            else {
                return 0;
            }
        }

        return chars[0]=='-'?-res:res;
    }

    public static void main(String[] args) {
        JZ49 jz49 = new JZ49();
        System.out.println(jz49.StrToInt("+0147483647"));
    }
}
