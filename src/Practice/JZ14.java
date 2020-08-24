package Practice;
//链表中倒数第k个结点
//题目描述
//输入一个链表，输出该链表中倒数第k个结点。
//知识点：链表
//思路：双指针
public class JZ14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (k > 0) {
            if (fast == null)
                return null;
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
        /*if (head==null)
            return null;
        LinkedList<ListNode> listNodes = new LinkedList<>();
        while (head!=null) {
            if (listNodes.size()<k) {
                listNodes.addFirst(head);
            }
            else {
                listNodes.removeLast();
                listNodes.addFirst(head);
            }
            head = head.next;
        }
        if (listNodes.getLast()==null)
            return null;
        return listNodes.getFirst();*/
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
