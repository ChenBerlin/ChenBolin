package Practice;

public class JZ28 {
    public static int MoreThanHalfNum_Solution(int [] array) {
        int result = 0;
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times++;
            }
            else {
                times = result==array[i]? times+1: times-1;
            }
        }
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (result == array[i])
                times++;
        }
        return times > array.length/2? result:0;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(a));
    }
}
