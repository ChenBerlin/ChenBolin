package Practice;
//合并两个排序的链表
//题目描述
//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
//知识点：链表、分治
//思路：一、单纯链表操作
//     二、递归
public class JZ16 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null)
            return list2;
        if (list2==null)
            return list1;
        boolean b = list1.val<=list2.val;
        //当前节点
        ListNode cur;
        //如果list1.val<=list2.val
        if (b) {
            cur = list1;
            list1 = list1.next;
        }
        else {
            cur = list2;
            list2 = list2.next;
        }
        ListNode head = cur;
        while (list1!=null&&list2!=null){
            if (list1.val<=list2.val) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }
            else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        if (list1==null) {
            cur.next = list2;
        }
        if (list2==null) {
            cur.next = list1;
        }
        return head;
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
