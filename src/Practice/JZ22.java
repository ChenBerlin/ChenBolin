package Practice;
//从上往下打印二叉树
//题目描述
//从上往下打印出二叉树的每个节点，同层节点从左至右打印
//知识点：队列、树
//思路：同JZ60
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root==null){
            return list;
        }
        TreeNode temp;
        queue.offer(root);
        int start = 0;
        int end = 1;
        while (!queue.isEmpty()) {
            while (start!=end) {
                temp = queue.poll();
                list.add(temp.val);
                if (temp.left!=null)
                    queue.offer(temp.left);
                if (temp.right!=null)
                    queue.offer(temp.right);
                start++;
            }
            if (start==end){
                start = 0;
                end = queue.size();
            }
        }
        return list;
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
