package Practice;

//二维数组中的查找
//题目描述
//在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//知识点：查找、数组
//思路：从右上查找
public class JZ1 {
    public static boolean Find(int target, int [][] array) {
        if (array==null||array.length<=0||array[0].length<=0){
            return false;
        }
        int i = 0;
        int j = array[0].length-1;
        int temp = array[i][j];
        while (temp != target){
            if (j==0||i==array.length-1){
                return false;
            }
            if (temp>target){
                j--;
                temp = array[i][j];

            }
            if (temp<target){
                i++;
                temp = array[i][j];
            }
        }
        if (temp == target){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int a[][] = {{}};
        System.out.println(Find(7,a));
    }
}
