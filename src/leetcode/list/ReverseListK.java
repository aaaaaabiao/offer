package leetcode.list;

import offer.list.ReverseList;

/**
 * K个一组翻转链表
 *  给定这个链表：1->2->3->4->5
 *  当 k = 2 时，应当返回: 2->1->4->3->5
 *  当 k = 3 时，应当返回: 3->2->1->4->5
 * @author hubiao
 */
public class ReverseListK {
    public static ListNode reverseListK(ListNode head, int k) {
        if (head == null) return head;
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode p = dump;
        ListNode pre = p;
        while (p != null) {
            int i = 0;
            for (;i < k; i++) {
                p = p.next;
                if (p == null) {
                    break;
                }
            }
            if (i == k) {
                //记录下一组的开头
                ListNode next = p.next;

                //本组的开头,翻转后即为本组的尾巴
                ListNode start = pre.next;
                //本组的尾巴翻转后成为本组的头
                ListNode tail = p;
                ListNode list = reverseList(start, tail);
                pre.next = list;
                start.next = next;
                pre = start;
                p = pre;
            }
        }
        return dump.next;
    }

    public static ListNode reverseList(ListNode start, ListNode tail) {
        ListNode head = null;
        ListNode end = tail.next;
        while (start != end) {
            ListNode next = start.next;
            start.next = head;
            head = start;
            start = next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.creatList(1,2,3,4,5,6,7,8);
        ListNode.printList(reverseListK(head, 3));
    }
}
