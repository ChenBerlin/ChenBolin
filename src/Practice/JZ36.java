package Practice;
//两个链表的第一个公共结点
//题目描述
//输入两个链表，找出它们的第一个公共结点。
//知识点：链表、双指针
//思路：链表1长度a，链表2长度b，a+b=b+a
public class JZ36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null)
            return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next!=null?p1.next:pHead2;
            p2 = p2.next!=null?p2.next:pHead1;
            if (p1==pHead2&&p2==pHead1)
                return null;
        }
        return p1;
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
