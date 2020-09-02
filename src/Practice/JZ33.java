package Practice;

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
