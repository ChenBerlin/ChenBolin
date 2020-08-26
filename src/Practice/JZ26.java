package Practice;
//二叉搜索树与双向链表
//题目描述
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
//知识点：树、链表、分治
//思路：中序遍历
import java.util.ArrayList;

public class JZ26 {
    public static ArrayList<TreeNode> list = new ArrayList<>();
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        if (pRootOfTree.left!=null) {
            Convert(pRootOfTree.left);
        }
        list.add(pRootOfTree);
        //System.out.println("add "+pRootOfTree.val);
        if (pRootOfTree.right!=null) {
            Convert(pRootOfTree.right);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        return list.get(0);
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
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(14);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(8);
        TreeNode t6 = new TreeNode(12);
        TreeNode t7 = new TreeNode(16);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        Convert(t1);

        TreeNode t = list.get(0);
        System.out.println(t.val);
        while (t.right!=null) {
            System.out.println(t.right.val);
            t = t.right;
        }
        System.out.println(t.val);
        while (t.left!=null) {
            System.out.println(t.left.val);
            t = t.left;
        }
    }
}
