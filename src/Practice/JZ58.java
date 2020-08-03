package Practice;
//对称的二叉树
//题目描述
//请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
//知识点：树、递归
//思路：1的左右分别和2的右左比较
public class JZ58 {
    boolean isSymmetrical(TreeNode pRoot) {
        //如果根节点为空，返回true。
        if (pRoot==null){
            return true;
        }
        return solution(pRoot.left,pRoot.right);
    }
    public static boolean solution(TreeNode root1,TreeNode root2){
        //如果传入的两个节点都为空，返回true。
        if (root1==null&&root2==null){
            return true;
        }
        //如果传入的两个节点不为空，比较两个节点的value
        //递归比较 root1的左节点，root2的右节点  和  root1的右节点，root2的左节点
        if (root1!=null&&root2!=null){
            return (root1.val==root2.val)&&solution(root1.left,root2.right)&&solution(root1.right,root2.left);
        }
        return false;
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
