package Practice;
//字符串的排列
//题目描述
//输入一个字符串,按字典序打印出该字符串中字符的所有排列。
//知识点：字符串、递归
//思路：固定pos的字符，排列后续字符，pos==length-1时add。
import java.util.ArrayList;
import java.util.Collections;

public class JZ27 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        char[] chars = str.toCharArray();
        int pos = 0;
        fun(list, chars, pos);
        char pre = ' ';
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != pre) {
                String s = new String(String.valueOf(chars[i]));
            }
        }
        Collections.sort(list);
        return list;
    }

    private void fun(ArrayList<String> list, char[] chars, int pos) {
        if (pos == chars.length - 1) {
            list.add(new String(chars));
            //System.out.println(pos+" "+new String(chars));
        }
        for (int i = pos; i < chars.length; i++) {
            if (i != pos && chars[i] == chars[pos])
                continue;
            else {
                swap(chars, i, pos);
                //System.out.println(pos+" "+i+" "+new String(chars));
                fun(list, chars, pos + 1);
                swap(chars, i, pos);
            }
        }
    }

    private void swap(char[] chars, int i, int pos) {
        char temp = chars[i];
        chars[i] = chars[pos];
        chars[pos] = temp;
    }

    public static void main(String[] args) {
        JZ27 test = new JZ27();
        System.out.println(test.Permutation("abc"));
    }
}
