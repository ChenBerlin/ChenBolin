package Practice;
//重建二叉树
//题目描述
//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//知识点：树、dfs、数组
//思路：找出左右子树，递归重建。
public class JZ4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length==0||in.length==0)
            return null;
        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i]==pre[0]){
                int arr1[] = new int[i];
                int arr2[] = new int[i];
                System.arraycopy(pre,1,arr1,0,i);
                System.arraycopy(in,0,arr2,0,i);
                treeNode.left = reConstructBinaryTree(arr1,arr2);

                int arr3[] = new int[pre.length-i-1];
                int arr4[] = new int[in.length-i-1];
                System.arraycopy(pre,i+1,arr3,0,pre.length-i-1);
                System.arraycopy(in,i+1,arr4,0,in.length-i-1);
                treeNode.right=reConstructBinaryTree(arr3,arr4);
                break;
            }
        }
        return treeNode;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
