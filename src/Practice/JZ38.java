package Practice;
//二叉树的深度
//题目描述
//输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
//知识点：树、递归
//思路：对左子树、右子树递归，每递归一次深度加1.
public class JZ38 {
    public int TreeDepth(TreeNode root) {
        //如果节点为空，则返回。
        if (root == null)
            return 0;
        //初始化深度为1
        int leftdepth = 1;
        int rightdepth = 1;
        if (root.left!=null){
            //递归求左子树深度
            leftdepth += TreeDepth(root.left);
        }
        if (root.right!=null){
            //递归求右子树深度
            rightdepth += TreeDepth(root.right);
        }
        //返回较大值
        return leftdepth>rightdepth?leftdepth:rightdepth;
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
