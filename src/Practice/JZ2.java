package Practice;
//替换空格
//题目描述
//请实现一个函数，将一个字符串中的每个空格替换成“%20”。
//知识点：字符串
//思路：replaceAll()
public class JZ2 {
    public String replaceSpace(StringBuffer str) {
        String result = str.toString();
        return result.replaceAll(" ","%20");
    }
}
