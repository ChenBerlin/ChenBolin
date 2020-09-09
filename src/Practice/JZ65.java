package Practice;
//矩阵中的路径
//题目描述
//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
//知识点：dfs、回溯
//思路：依次遍历，第一个字符相等则向上下左右递归。
public class JZ65 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int[][] flag = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //从str[index]开始匹配
                int index = 0;
                if (solution(matrix, rows, cols, i, j, str, flag, index))
                    return true;
            }
        }
        return false;
    }

    private boolean solution(char[] matrix, int rows, int cols, int i, int j, char[] str, int[][] flag, int index) {
        //i-1和j-1可能小于0
        if (i < 0 || j < 0)
            return false;
        if (i >= rows||j >= cols||matrix[i*cols+j] != str[index]||flag[i][j] == 1)
            return false;
        if (index == str.length - 1)
            return true;
        flag[i][j] = 1;
        if (solution(matrix, rows, cols, i - 1, j, str, flag, index + 1)
            ||solution(matrix, rows, cols, i + 1, j, str, flag, index + 1)
            ||solution(matrix, rows, cols, i, j - 1, str, flag, index + 1)
            ||solution(matrix, rows, cols, i, j + 1, str, flag, index + 1)) {
            return true;
        }
        flag[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {
        String s = new String("ABCESFCSADEE");
        char[] matrix = s.toCharArray();
        int rows = 3;
        int cols = 4;
        s = "ABCCED";
        char[] str = s.toCharArray();
        JZ65 jz65 = new JZ65();
        System.out.println(jz65.hasPath(matrix, rows, cols, str));
    }
}
