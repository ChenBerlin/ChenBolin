package Practice;
//二叉树的下一个节点
//题目描述
//给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
//知识点：树
//思路：若pNode有右子树则输出右子树的最左节点，若pNode无右子树则输出第一个满足pNode在其左子树中的父辈节点。
public class JZ57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //如果节点为空则返回空
        if (pNode==null){
            return null;
        }
        //如果节点有右子树
        if (pNode.right!=null){
            //查找右子树最左节点
            pNode = pNode.right;
            while (pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }
        //如果节点没有右子树
        //查找有左子树的父辈节点
        while (pNode.next!=null){
            if (pNode.next.left==pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        //遇到根节点，返回null。
        return null;
    }


    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
