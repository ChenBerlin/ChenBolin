package Practice;
//复杂链表的复制
//题目描述
//输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
//知识点：链表
//思路：1、复制每个结点；2、重新遍历链表，复制老结点的随机指针给新结点；3、拆分链表，将链表拆分为原链表和复制后的链表。
public class JZ25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null)
            return null;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        RandomListNode node=pHead;
        while(node!=null){
            RandomListNode temp = new RandomListNode(node.label);
            temp.next=node.next;
            node.next=temp;
            node=temp.next;
        }
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        node=pHead;
        while(node!=null){
            if(node.random!=null){
                node.next.random=node.random.next;
            }
            node=node.next.next;
        }
        //3、拆分链表，将链表拆分为原链表和复制后的链表
        node=pHead;
        RandomListNode root=pHead.next;
        RandomListNode tmp=root;
        while(node!=null){
            node.next=tmp.next;
            tmp.next=node.next==null?null:node.next.next;
            node=node.next;
            tmp=tmp.next;
        }
        return root;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
