package Practice;
//二叉搜索树的后序遍历序列
//题目描述
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
//知识点：树
//思路：找到根节点，递归。
public class JZ23 {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null)
            return false;
        if (sequence.length == 0)
            return false;
        return verify(sequence, 0, sequence.length-1);
    }

    private static boolean verify(int[] sequence, int start, int end) {
        if (start >= end)
            return true;
        int root = sequence[end];
        int i = 0;
        while (sequence[i] < sequence[end]) {
            i++;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < root)
                return false;
        }
        return verify(sequence,start,i-1)&&verify(sequence,i,end-1);
    }

    public static void main(String[] args) {
        int a[] = {4,8,6,12,16,14,10};
        System.out.println(VerifySquenceOfBST(a));
    }
}
