package Practice;
//二叉树的镜像
//题目描述
//操作给定的二叉树，将其变换为源二叉树的镜像。
//知识点：树、递归
//思路：对左右子树分别递归交换。
public class JZ18 {
    public void Mirror(TreeNode root) {
        //如果节点为空，则返回。
        if (root==null)
            return;
        //求左子树镜像
        Mirror(root.left);
        //求右子树镜像
        Mirror(root.right);
        //设置临时变量
        TreeNode temp = new TreeNode(0);
        //交换左右节点
        temp = root.left;
        root.left = root.right;
        root.right = temp;
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
