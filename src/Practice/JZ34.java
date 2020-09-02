package Practice;
//第一个只出现一次的字符
//题目描述
//在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
//知识点：字符串
//思路：依次取char，查询index之后是否有char。
public class JZ34 {
    public int FirstNotRepeatingChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i))==i && str.indexOf(str.charAt(i),i+1)==-1)
                return i;
        }
        return -1;
    }
}
