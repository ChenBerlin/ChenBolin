package Practice;
//链表中环的入口结点
//题目描述
//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
//知识点：链表
//思路：一、暴力
//     二、设快慢指针，快指针每次移动2，慢指针每次移动1，第一次相遇后将一个指针重置到链表头。
//        再将快慢指针速度均调为1，再次相遇时即在入口结点。
public class JZ55 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null||pHead.next == null)
            return null;
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                fast = pHead;
                while (fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                if (fast == slow) {
                    return fast;
                }
            }
        }
        return null;
    }
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
