package Practice;
//删除链表中重复的结点
//题目描述
//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
//知识点：链表、递归
//思路：递归找出不重复的结点构成链表
public class JZ56 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;

        //找出第一个不重复的结点。
        ListNode head= pHead;
        boolean flag = false;
        while (head.val==head.next.val) {
            head = head.next;
            flag = true;
            if (head.next == null)
                return null;
        }
        head = flag?deleteDuplication(head.next):head;
        //若存在不重复的结点，则找出后续结点。
        if (head!=null)
            head.next = deleteDuplication(head.next);
        return head;
    }
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        JZ56 jz56 = new JZ56();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode node = n1;
        while (node!=null) {
            System.out.print(node.val+"");
            node = node.next;
        }
        System.out.println();
        node = jz56.deleteDuplication(n1);
        while (node!=null) {
            System.out.print(node.val+"");
            node = node.next;
        }
    }
}
