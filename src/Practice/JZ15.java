package Practice;
//反转链表
//题目描述
//输入一个链表，反转链表后，输出新链表的表头。
//知识点：链表
//思路：指针
public class JZ15 {
    public ListNode ReverseList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur!=null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
