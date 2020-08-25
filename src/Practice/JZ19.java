package Practice;
//顺时针打印矩阵
//题目描述
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//知识点：数组
//思路：判断边界
import java.util.ArrayList;

public class JZ19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        while(true){
            for(int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            if(++top > bottom)
                break;
            for(int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if(left > --right)
                break;
            for(int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            if(top > --bottom)
                break;
            for(int i = bottom; i >= top; i--){
                list.add(matrix[i][left]);
            }
            if(++left > right)
                break;
        }
        return list;
    }
}
