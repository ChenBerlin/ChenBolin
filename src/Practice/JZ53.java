package Practice;
//表示数值的字符串
//题目描述
//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
//知识点：字符串、正则表达式
//思路：一、用正则表达式写出数值所有可能表示方式（简洁）
//     二、if穷举（运行快）
import java.util.regex.Pattern;

public class JZ53 {
    public boolean isNumeric(char[] str) {
        String pattern = "^[-+]?\\d*(?:\\.\\d*)?(?:[eE][+\\-]?\\d+)?$";
        String s = new String(str);
        return Pattern.matches(pattern,s);

        /*if穷举法
        * if(str==null || str.length==0)
            return false;
        boolean hasE = false;
        boolean decimal = false;
        boolean sign = false;

        for(int i =0;i<str.length;i++){
            char ch = str[i];
            if(ch=='e' || ch=='E'){
                if(hasE)
                    return false;
                if(i==str.length-1)
                    return false;
                hasE = true;
            }
            else if(ch=='+' || ch=='-'){
                if(sign && str[i-1]!='e' && str[i-1]!='E')
                    return false;
                if(!sign && i>0 && str[i-1]!='e' && str[i-1]!='E')
                    return false;
                sign = true;
            }
            else if(ch=='.'){
                if(hasE || decimal)
                    return false;
                decimal = true;
            }
            else if(ch<'0' || ch>'9')
                return false;
        }

        return true;
        * */
    }
}
