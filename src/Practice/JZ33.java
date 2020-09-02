package Practice;
//丑数
//题目描述
//把只包含质因子2、3和5的数称作丑数（Ugly Number）。因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
//知识点：数学
//思路：丑数=丑数*丑数 p2、p3、p5分别记录当前用了几个2、3、5相乘。
public class JZ33 {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0)
            return 0;
        int[] arr = new int[index];
        arr[0] = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for (int i = 1; i < index; i++) {
            arr[i] = Math.min(arr[p2]*2,Math.min(arr[p3]*3,arr[p5]*5));
            System.out.println(arr[i]);
            if (arr[i] == arr[p2]*2) {
                p2++;
            }
            if (arr[i] == arr[p3]*3) {
                p3++;
            }
            if (arr[i] == arr[p5]*5) {
                p5++;
            }
        }
        /*for (int i:
             arr) {
            System.out.println(i);
        }*/
        return arr[index - 1];
    }

    public static void main(String[] args) {
        JZ33 jz33 = new JZ33();
        System.out.println(jz33.GetUglyNumber_Solution(20));
    }
}
