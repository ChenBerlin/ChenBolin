package Practice;
//平衡二叉树
//题目描述
//输入一棵二叉树，判断该二叉树是否是平衡二叉树。
//知识点：二叉树、dfs
//思路：递归判断子树是否平衡，|left-right|<=1。
public class JZ39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root)!=-1;
    }

    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        if (left == -1)
            return -1;
        int right = getDepth(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) <= 1? 1+(Math.max(left, right)): -1;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void main(String[] args) {
        JZ39 jz39 = new JZ39();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = null;
        n3.right = n6;
        n4.left = null;
        n4.right = null;
        n5.left = n7;
        System.out.println(jz39.IsBalanced_Solution(n1));
    }
}
