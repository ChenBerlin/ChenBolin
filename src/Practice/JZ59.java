package Practice;
//之字形打印二叉树
//题目描述
//请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
//知识点：栈
//思路：把当前层结点存入栈，递归创建ArrayList。
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class JZ59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null)
            return lists;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);
        addValue(stack, lists);
        for (int i = 1; i < lists.size(); i+=2) {
            Collections.reverse(lists.get(i));
        }
        return lists;
    }

    //这种实现方式可能用队列好一点
    private void addValue(Stack<TreeNode> stack, ArrayList<ArrayList<Integer>> lists) {
        if (stack.isEmpty())
            return;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> temp_stack = new Stack<>();
        while (!stack.isEmpty()) {
            temp_stack.push(stack.pop());
        }
        while (!temp_stack.isEmpty()) {
            TreeNode t = temp_stack.pop();
            list.add(t.val);
            if (t.left != null) {
                stack.push(t.left);
            }
            if (t.right != null) {
                stack.push(t.right);
            }
        }
        lists.add(list);
        addValue(stack, lists);
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
        JZ59 jz59 = new JZ59();
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(11);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(jz59.Print(n1));
    }
}
