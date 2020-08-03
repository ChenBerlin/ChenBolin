package Practice;
//构建乘积数组
//题目描述
//给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
//对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
//知识点：数组
//思路：分别计算a[i]左侧和右侧的乘积，再相乘。
import java.util.Scanner;

public class JZ51 {
    public static int[] multiply(int[] A) {
        int length = A.length;
        int B[] = new int[length];
        if (length!=0){
            B[0] = 1;
            //计算left的乘积
            for (int i = 1; i < length; i++){
                B[i] = B[i-1] * A[i-1];
            }
            int temp = 1;
            //计算right的乘积并与左乘积相乘
            for (int j = length-2; j >= 0; j--){
                temp *= A[j+1];
                B[j] *= temp;
            }

        }
        return B;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        A = multiply(A);
        for (int i:A
             ) {
            System.out.print(i+" ");
        }
    }
}
