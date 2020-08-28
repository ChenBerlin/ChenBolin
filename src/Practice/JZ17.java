package Practice;
//树的子结构
//题目描述
//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
//知识点：二叉树
//思路：递归
public class JZ17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return contain(root1,root2)?true:contain(root1.left,root2)||contain(root1.right,root2);
    }

    private boolean contain(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val == root2.val)
            return contain(root1.left,root2.left)&&contain(root1.right,root2.right);
        else
            return false;
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
