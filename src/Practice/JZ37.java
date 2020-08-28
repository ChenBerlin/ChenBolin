package Practice;
//数字在升序数组中出现的次数
//题目描述
//统计一个数字在升序数组中出现的次数
//知识点：数组、二分
//思路：二分查找k和k+1，end-start。
public class JZ37 {
    public static int GetNumberOfK(int[] array, int k) {
        if (array==null||array.length==0)
            return 0;
        int start = getIndex(array,k);
        int end = getIndex(array,k+1);
        return start<=end?end-start:0;
    }

    private static int getIndex(int[] array, int k) {
        int mid = 0;
        int left = 0;
        int right = array.length;
        while (left < right) {
            mid = left + (right-left)/2;
            if (array[mid]>=k)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,3,3,3,4,5};
        System.out.println(GetNumberOfK(a, 3));
    }
}
