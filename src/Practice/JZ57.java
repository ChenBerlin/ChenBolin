package Practice;

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
