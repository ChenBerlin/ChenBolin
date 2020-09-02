package Practice;
//把数组排成最小的数
//题目描述
//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
//知识点：数组、字符串
//思路：转成String比较大小
public class JZ32 {
    public String PrintMinNumber(int [] numbers) {
        String s = new String();
        if (numbers == null || numbers.length == 0)
            return s;
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                String s1 = ""+numbers[i]+numbers[j];
                String s2 = ""+numbers[j]+numbers[i];
                if (s1.compareTo(s2) > 0) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            s += numbers[i];
        }
        return s;
    }

    public static void main(String[] args) {
        JZ32 jz32 = new JZ32();
        int[] numbers = {3,32,321};
        System.out.println(jz32.PrintMinNumber(numbers));
    }
}
