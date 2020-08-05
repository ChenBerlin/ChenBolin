package Practice;
//字符流中第一个不重复的字符
//题目描述
//请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
//知识点：字符串、LinkedHashMap
//思路：Insert：用LinkedHashMap<Character,Integer>存储数据，第一次出现value置为1，重复出现value置为-1。
//     FirstAppearingOnce：查询value为1的key。
import java.util.LinkedHashMap;
import java.util.Map;

public class JZ54 {
    LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)){
            map.replace(ch,-1);
        }
        else {
            map.put(ch,1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Map.Entry<Character,Integer> e:map.entrySet()
             ) {
            if (e.getValue()==1)
                return e.getKey();
        }
        return '#';
    }
}
