package Practice;
//二叉树中和为某一值的路径
//题目描述
//输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
//知识点：树
//思路：dfs
import java.util.ArrayList;

public class JZ24 {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        getLists(root,target,new ArrayList<>());
        return lists;
    }

    private void getLists(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        target -= root.val;
        if (target==0 && root.left==null && root.right==null)
            lists.add(new ArrayList<>(list));
        else {
            getLists(root.left, target,list);
            getLists(root.right, target, list);
        }
        list.remove(list.size()-1);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
