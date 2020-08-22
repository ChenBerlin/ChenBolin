package Practice;
//从尾到头打印链表
//题目描述
//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
//知识点：链表
//思路：依次存入list，调用工具类反转。
import java.util.ArrayList;
import java.util.Collections;

public class JZ3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode==null){
            return list;
        }
        while (listNode.next!=null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        list.add(listNode.val);
        Collections.reverse(list);
        return list;
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
