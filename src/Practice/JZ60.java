package Practice;
//把二叉树打印成多行
//题目描述
//从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
//知识点：队列、树
//思路：用queue存放待遍历的节点，用两个变量记录每次遍历时队列的起始位和终止位，用list存放每层节点值。
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ60 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp;
        if(pRoot == null){
            return result;
        }
        //放入根节点
        queue.offer(pRoot);
        //记录每次遍历的节点索引起始位和终止位
        int start = 0,end = 1;
        //对节点队列遍历
        while(!queue.isEmpty()){
            //取出一个节点
            temp = queue.poll();
            //把节点的值装入list
            list.add(temp.val);
            //待遍历节点-1
            start++;
            //放入左节点
            if(temp.left != null){
                queue.offer(temp.left);
            }
            //放入右节点
            if(temp.right != null){
                queue.offer(temp.right);
            }
            //判断本层是否遍历结束
            if(start == end){
                //重置起始位置
                start = 0;
                //更新终止位置
                end = queue.size();
                //把本次遍历list放入result
                result.add(list);
                //创建新list，使list指向一块新的内存空间。
                //不能使用list.clear()，因为result对list是浅拷贝。
                list = new ArrayList<>();
            }
        }
        return result;
    }
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
